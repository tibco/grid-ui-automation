package com.tibco.automation.common.listeners;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import java.util.Set;
import org.testng.IInvokedMethod;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.collections.Lists;
import org.testng.internal.Utils;
import org.testng.log4testng.Logger;
import org.testng.reporters.util.StackTraceTools;
import org.testng.xml.XmlSuite;
import java.util.Properties;
import javax.activation.*;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



public class MyReporterListener
  implements IReporter
{
  private static final Logger L = Logger.getLogger(MyReporterListener.class);

  
  private PrintWriter m_out;

  
  private int m_row;

  
  private int m_methodIndex;

  
  private int m_rowTotal;


  
  public void generateReport(List<XmlSuite> xml, List<ISuite> suites, String outdir) {
    try {
      this.m_out = createWriter(outdir);
    }
    catch (IOException e) {
      L.error("output file", e);
      return;
    } 
    String tos[]= {"hbirse@tibco.com","pgarud@tibco.com","rshukla@tibco.com","pmulak@tibco.com"};
    String from="pmulak@tibco.com";
    startHtml(this.m_out);
    generateSuiteSummaryReport(suites);
    generateMethodSummaryReport(suites);
    generateMethodDetailReport(suites);
    endHtml(this.m_out);
    this.m_out.flush();
    this.m_out.close();
    try {
		sendMail(from,tos,"Grid Server Automation Report","PFA the report",outdir+"\\");
	} catch (MessagingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  

  
  protected PrintWriter createWriter(String outdir) throws IOException {
    (new File(outdir)).mkdirs();
    return new PrintWriter(new BufferedWriter(new FileWriter(new File(outdir, "GridServer_AutomationReport.html"))));
    
  }


  
  protected void generateMethodSummaryReport(List<ISuite> suites) {
    this.m_methodIndex = 0;
    startResultSummaryTable("passed");
    for (ISuite suite : suites) {
      if (suites.size() > 1) {
        titleRow(suite.getName(), 4);
      }
      Map<String, ISuiteResult> r = suite.getResults();
      for (ISuiteResult r2 : r.values()) {
        ITestContext testContext = r2.getTestContext();
        String testName = testContext.getName();
      //  resultSummary(suite, testContext.getFailedConfigurations(), testName, "failed", " (configuration methods)");
        
        resultSummary(suite, testContext.getFailedTests(), testName, "failed", "");
        
       // resultSummary(suite, testContext.getSkippedConfigurations(), testName, "skipped", " (configuration methods)");
        
        resultSummary(suite, testContext.getSkippedTests(), testName, "skipped", "");
        
        resultSummary(suite, testContext.getPassedTests(), testName, "passed", "");
      } 
    } 
    
    this.m_out.println("</table>");
  }

  
  protected void generateMethodDetailReport(List<ISuite> suites) {
    this.m_methodIndex = 0;
    for (ISuite suite : suites) {
      Map<String, ISuiteResult> r = suite.getResults();
      for (ISuiteResult r2 : r.values()) {
        ITestContext testContext = r2.getTestContext();
        if (r.values().size() > 0) {
          this.m_out.println("<h1>" + testContext.getName() + "</h1>");
        }
       // resultDetail(testContext.getFailedConfigurations());
        resultDetail(testContext.getFailedTests());
       // resultDetail(testContext.getSkippedConfigurations());
        resultDetail(testContext.getSkippedTests());
        resultDetail(testContext.getPassedTests());
      } 
    } 
  }




  
  private void resultSummary(ISuite suite, IResultMap tests, String testname, String style, String details) {
    if (tests.getAllResults().size() > 0) {
      StringBuffer buff = new StringBuffer();
      String lastClassName = "";
      int mq = 0;
      int cq = 0;
      for (ITestNGMethod method : getMethodSet(tests, suite)) {
        this.m_row++;
        this.m_methodIndex++;
        ITestClass testClass = method.getTestClass();
        String className = testClass.getName();
        if (mq == 0) {
          titleRow(testname + " &#8212; " + style + details, 4);
        }
        if (!className.equalsIgnoreCase(lastClassName)) {
          if (mq > 0) {
            cq++;
            this.m_out.println("<tr class=\"" + style + ((cq % 2 == 0) ? "even" : "odd") + "\">" + "<td rowspan=\"" + mq + "\">" + lastClassName + "</td>" + buff);
          } 

          
          mq = 0;
          buff.setLength(0);
          lastClassName = className;
        } 
        Set<ITestResult> resultSet = tests.getResults(method);
        long end = (long) Float.MIN_VALUE;
        long start = (long) Float.MAX_VALUE;
        for (ITestResult testResult : tests.getResults(method)) {
          if (testResult.getEndMillis() > end) {
            end = testResult.getEndMillis();
          }
          if (testResult.getStartMillis() < start) {
            start = testResult.getStartMillis();
          }
        } 
        mq++;
        if (mq > 1) {
          buff.append("<tr class=\"" + style + ((cq % 2 == 0) ? "odd" : "even") + "\">");
        }
        
        String description = method.getDescription();
        String testInstanceName = (String)resultSet.toArray(new ITestResult[0])[0].getTestName();
        buff.append("<td><a href=\"#m" + this.m_methodIndex + "\">" + qualifiedName(method) + " " + ((description != null && description.length() > 0) ? ("(\"" + description + "\")") : "") + "</a>" + ((null == testInstanceName) ? "" : ("<br>(" + testInstanceName + ")")) + "</td>" + "<td class=\"numi\">" + (end - start) + "</td>" + "</tr>");
      //  buff.append("<td><a href=\"#m" + "\">" + qualifiedName(method) + " " + ((description != null && description.length() > 0) ? ("(\"" + description + "\")") : "") + "</a>" + ((null == testInstanceName) ? "" : ("<br>(" + testInstanceName + ")")) + "</td>" + "<td class=\"numi\">" + (end - start) + "</td>" + "</tr>");
      } 









      
      if (mq > 0) {
        cq++;
        this.m_out.println("<tr class=\"" + style + ((cq % 2 == 0) ? "even" : "odd") + "\">" + "<td rowspan=\"" + mq + "\">" + lastClassName + "</td>" + buff);
      } 
    } 
  }


  
  private void startResultSummaryTable(String style) {
    tableStart(style, "summary");
    this.m_out.println("<tr><th>Class</th><th>Test<br>Case</th><th>Time<br/>(ms)</th></tr>");
    
    this.m_row = 0;
  }
  
  private String qualifiedName(ITestNGMethod method) {
    StringBuilder addon = new StringBuilder();
    String[] groups = method.getGroups();
    int length = groups.length;
    if (length > 0 && !"basic".equalsIgnoreCase(groups[0])) {
      addon.append("(");
      for (int i = 0; i < length; i++) {
        if (i > 0) {
          addon.append(", ");
        }
        addon.append(groups[i]);
      } 
      addon.append(")");
    } 
    
    return "<b>" + method.getMethodName() + "</b> " + addon;
  }
  
  private void resultDetail(IResultMap tests) {
    for (ITestResult result : tests.getAllResults()) {
      ITestNGMethod method = result.getMethod();
      this.m_methodIndex++;
      String cname = method.getTestClass().getName();
      this.m_out.println("<h2 id=\"m" + this.m_methodIndex + "\">" + cname + ":" + method.getMethodName() + "</h2>");
      
      Set<ITestResult> resultSet = tests.getResults(method);
      generateForResult(result, method, resultSet.size());
      this.m_out.println("<p class=\"totop\"><a href=\"#summary\"><b>BACK TO SUMMARY</b></a></p>");
    } 
  }

  
  private void generateForResult(ITestResult ans, ITestNGMethod method, int resultSetSize) {
    Object[] parameters = ans.getParameters();
    boolean hasParameters = (parameters != null && parameters.length > 0);
    if (hasParameters) {
      tableStart("result", null);
      this.m_out.print("<tr class=\"param\">");
      for (int x = 1; x <= parameters.length; x++) {
        this.m_out.print("<th>Parameter #" + x + "</th>");
      }
      this.m_out.println("</tr>");
      this.m_out.print("<tr class=\"param stripe\">");
      for (Object p : parameters) {
        this.m_out.println("<td>" + toString(p) + "</td>");
      }
      this.m_out.println("</tr>");
    } 
    List<String> msgs = Reporter.getOutput(ans);
    boolean hasReporterOutput = (msgs.size() > 0);
    Throwable exception = ans.getThrowable();
    boolean hasThrowable = (exception != null);
    if (hasReporterOutput || hasThrowable) {
      String indent = " style=\"padding-left:3em\"";
      if (hasParameters) {
        this.m_out.println("<tr><td" + indent + " colspan=\"" + parameters.length + "\">");
      } else {
        
        this.m_out.println("<div" + indent + ">");
      } 
      if (hasReporterOutput) {
        if (hasThrowable) {
          this.m_out.println("<h3>Test Messages</h3>");
        }
        for (String line : msgs) {
          this.m_out.println(line + "<br/>");
        }
      } 
      if (hasThrowable) {
        boolean wantsMinimalOutput = (ans.getStatus() == 1);
        if (hasReporterOutput) {
          this.m_out.println("<h3>" + (wantsMinimalOutput ? "Expected Exception" : "Failure") + "</h3>");
        }

        
        generateExceptionReport(exception, method);
      } 
      if (hasParameters) {
        this.m_out.println("</td></tr>");
      } else {
        
        this.m_out.println("</div>");
      } 
    } 
    if (hasParameters) {
      this.m_out.println("</table>");
    }
  }

  
  protected void generateExceptionReport(Throwable exception, ITestNGMethod method) { generateExceptionReport(exception, method, exception.getLocalizedMessage()); }

  
  private void generateExceptionReport(Throwable exception, ITestNGMethod method, String title) {
    this.m_out.println("<p>" + Utils.escapeHtml(title) + "</p>");
    StackTraceElement[] s1 = exception.getStackTrace();
    Throwable t2 = exception.getCause();
    if (t2 == exception) {
      t2 = null;
    }
    int maxlines = Math.min(100, StackTraceTools.getTestRoot(s1, method));
    for (int x = 0; x <= maxlines; x++) {
      this.m_out.println(((x > 0) ? "<br/>at " : "") + Utils.escapeHtml(s1[x].toString()));
    }
    if (maxlines < s1.length) {
      this.m_out.println("<br/>" + (s1.length - maxlines) + " lines not shown");
    }
    if (t2 != null) {
      generateExceptionReport(t2, method, "Caused by " + t2.getLocalizedMessage());
    }
  }




  
  private Collection<ITestNGMethod> getMethodSet(IResultMap tests, ISuite suite) {
	    List<IInvokedMethod> r = Lists.newArrayList();
	    List<IInvokedMethod> invokedMethods = suite.getAllInvokedMethods();
	    for (IInvokedMethod im : invokedMethods) {
	      if (tests.getAllMethods().contains(im.getTestMethod())) {
	        r.add(im);
	      }
	    } 
	    Arrays.sort(r.toArray(new IInvokedMethod[r.size()]), new TestSorter(null));
	    List<ITestNGMethod> result = Lists.newArrayList();

	    
	    for (IInvokedMethod m : r) {
	      result.add(m.getTestMethod());
	    }


	    
	    for (ITestNGMethod m : tests.getAllMethods()) {
	      if (!result.contains(m)) {
	        result.add(m);
	      }
	    } 
	    return result;
	  }
	  
  
  public void generateSuiteSummaryReport(List<ISuite> suites) {
	  this.m_out.print("<br><b>SUMMARY:</b><br/>");
    tableStart("result", null);
    
    this.m_out.print("<tr><th>Test<br/>Modules</th>");
    //tableColumnStart("Methods<br/>Passed");
    tableColumnStart("Scenarios<br/>Passed");
    tableColumnStart("Scenarios<br/>Failed");
    tableColumnStart("Scenarios<br/>Skipped");
    tableColumnStart("Total<br/>Time");
   // tableColumnStart("Included<br/>Groups");
   // tableColumnStart("Excluded<br/>Groups");
    this.m_out.println("</tr>");
    NumberFormat formatter = new DecimalFormat("#,##0.0");
    int qty_tests = 0;
    //int qty_pass_m = 0;
    int qty_pass_s = 0;
    int qty_skip = 0;
    int qty_fail = 0;
    long time_start = (long) Float.MAX_VALUE;
    long time_end = (long) Float.MIN_VALUE;
    for (ISuite suite : suites) {
      if (suites.size() > 1) {
        titleRow(suite.getName(), 7);
      }
      Map<String, ISuiteResult> tests = suite.getResults();
      for (ISuiteResult r : tests.values()) {
        qty_tests++;
        ITestContext overview = r.getTestContext();
        startSummaryRow(overview.getName());
        int q = getMethodSet(overview.getPassedTests(), suite).size();
       // qty_pass_m += q;
       // summaryCell(q, 2147483647);
        q = overview.getPassedTests().size();
        qty_pass_s += q;
        summaryCell(q, 2147483647);
        
        q = getMethodSet(overview.getFailedTests(), suite).size();
        qty_fail += q;
        summaryCell(q, 0);
        
        q = getMethodSet(overview.getSkippedTests(), suite).size();
        qty_skip += q;
        summaryCell(q, 0);
        
        time_start = Math.min(overview.getStartDate().getTime(), time_start);
        time_end = Math.max(overview.getEndDate().getTime(), time_end);
        summaryCell(formatter.format((overview.getEndDate().getTime() - overview.getStartDate().getTime()) / 1000.0D) + " sec", true);

        
       // summaryCell(overview.getIncludedGroups());
      //  summaryCell(overview.getExcludedGroups());
        this.m_out.println("</tr>");
      } 
    } 
    if (qty_tests > 1) {
      this.m_out.println("<tr class=\"total\"><td>Total</td>");
     // summaryCell(qty_pass_m, 2147483647);
      summaryCell(qty_pass_s, 2147483647);
      summaryCell(qty_fail, 0);
      summaryCell(qty_skip, 0);
      summaryCell(formatter.format((time_end - time_start) / 1000.0D) + " sec", true);
      
     // this.m_out.println("<td colspan=\"2\">&nbsp;</td></tr>");
    } 
    this.m_out.println("</table>");
    this.m_out.print("<br><b>DETAILED ANALYSIS:</b><br/>");
  }
  
  private void summaryCell(String[] val) {
    StringBuffer b = new StringBuffer();
    for (String v : val) {
      b.append(v + " ");
    }
    summaryCell(b.toString(), true);
  }

  
  private void summaryCell(String v, boolean isgood) { this.m_out.print("<td class=\"numi" + (isgood ? "" : "_attn") + "\">" + v + "</td>"); }

  
  private void startSummaryRow(String label) {
    this.m_row++;
    this.m_out.print("<tr" + ((this.m_row % 2 == 0) ? " class=\"stripe\"" : "") + "><td style=\"text-align:left;padding-right:2em\">" + label + "</td>");
  }


  
  private void summaryCell(int v, int maxexpected) {
    summaryCell(String.valueOf(v), (v <= maxexpected));
    this.m_rowTotal += v;
  }
  
  private void tableStart(String cssclass, String id) {
    this.m_out.println("<table cellspacing=\"0\" cellpadding=\"0\"" + ((cssclass != null) ? (" class=\"" + cssclass + "\"") : " style=\"padding-bottom:2em\"") + ((id != null) ? (" id=\"" + id + "\"") : "") + ">");



    
    this.m_row = 0;
  }

  
  private void tableColumnStart(String label) { this.m_out.print("<th class=\"numi\">" + label + "</th>"); }

  
  private void titleRow(String label, int cq) {
    this.m_out.println("<tr><th colspan=\"" + cq + "\">" + label + "</th></tr>");
    this.m_row = 0;
  }
  
  String toString(Object obj) {
    String result;
    if (obj != null) {
      if (obj instanceof boolean[]) {
        result = Arrays.toString((boolean[])obj);
      }
      else if (obj instanceof byte[]) {
        result = Arrays.toString((byte[])obj);
      }
      else if (obj instanceof char[]) {
        result = Arrays.toString((char[])obj);
      }
      else if (obj instanceof double[]) {
        result = Arrays.toString((double[])obj);
      }
      else if (obj instanceof float[]) {
        result = Arrays.toString((float[])obj);
      }
      else if (obj instanceof int[]) {
        result = Arrays.toString((int[])obj);
      }
      else if (obj instanceof long[]) {
        result = Arrays.toString((long[])obj);
      }
      else if (obj instanceof Object[]) {
        result = Arrays.deepToString((Object[])obj);
      }
      else if (obj instanceof short[]) {
        result = Arrays.toString((short[])obj);
      } else {
        
        result = obj.toString();
      } 
    } else {
      result = "null";
    } 
    return Utils.escapeHtml(result);
  }

 
  
  protected void writeStyle(String[] formats, String[] targets) {}

  
  protected void startHtml(PrintWriter out) {
    out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">");
    out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
    out.println("<head>");
    out.println("<title>TestNG:  Unit Test</title>");
    out.println("<style type=\"text/css\">");
    out.println("table caption,table.info_table,table.result,table.passed,table.failed {margin-bottom:10px;border:1px solid #000099;background-color:#E8F6F5;border-collapse:collapse;empty-cells:show;}");
    out.println("table.info_table td,table.info_table th,table.result td,table.result th,table.passed td,table.passed th,table.failed td,table.failed th {");
    out.println("border:1px solid #000099;padding:.25em .5em .25em .5em");
    out.println("}");
    out.println("table.result th {vertical-align:bottom}");
    out.println("tr.param th {padding-left:1em;padding-right:1em}");
    out.println("tr.param td {padding-left:.5em;padding-right:2em}");
    out.println("td.numi,th.numi,td.numi_attn {");
    out.println("text-align:right");
    out.println("}");
    out.println("tr.total td {font-weight:bold}");
    out.println("table caption {");
    out.println("text-align:center;font-weight:bold;");
    out.println("}");
    out.println("table.passed tr.stripe td,table tr.passedodd td {color: #0AB10F;}");
    out.println("table.passed td,table tr.passedeven td {color: #0AB10F;}");
    out.println("table.failed tr.stripe td,table tr.failedodd td,table.result td.numi_attn {color: #DD0000;}");
    out.println("table.failed td,table tr.failedeven td,table.result tr.stripe td.numi_attn {color: #DD0000;}");
   
    //out.println("table.skipped tr.stripe td,table tr.skippedodd td,table.result td.numi_attn {color: #ffaa00;}");
    //out.println("table.skipped td,table tr.skippedeven td,table.result tr.stripe td.numi_attn {color: #ffaa00;}");
    
   out.println("table.passed tr.stripe td,table tr.skippedodd td {color: #ffaa00;}");
   out.println("table.passed td,table tr.skippedodd td {color: #ffaa00;}");
    out.println("tr.stripe td,tr.stripe th {color: #000099;}");
    out.println("p.totop {font-size:85%;text-align:center;border-bottom:2px black solid}");
    out.println("div.shootout {padding:2em;border:3px #4854A8 solid}");
    out.println("</style>");
    out.println("</head>");
    out.println("<body>");
  }

  protected void sendMail(String from, String tos[], String subject,String text,String outdir) throws MessagingException
  {
	//Recipient's Mail id
	 // String receipientTo = "hbirse@tibco.com";
	  
	  //Sender's Mail id
	  for(String receiver:tos) {
	  String senderFrom = from;
	  String ts=System.getProperty("timestamp");
	  //Path of HTML test report
	  String path ="C:\\Users\\Administrator\\Desktop\\GS_UI_Automation\\GS-UIAutomation\\test-output\\"+ts+"\\GridServer_AutomationReport.html";
	  System.out.println("file path : "+path);
	  //Getting System properties
	  Properties prop = System.getProperties();
	  
	  //Setting up smtp host
	  prop.setProperty("mail.smtp.host", "smtp.gmail.com");
	  
	  //Creating a new session for smtp
	  Session session = Session.getDefaultInstance(prop);
	  
	  MimeMessage msg = new MimeMessage(session);
	  
	  
	  
	  //Instance of From Internet address
	  InternetAddress frmAddress = new InternetAddress(senderFrom);
	 
	  //Instance of To Internet address
	  InternetAddress toAddress = new InternetAddress(receiver);
	  
	  //Setting up sender's address
	  msg.setFrom(frmAddress);
	  
	  //Setting up recipient's address
	  msg.addRecipient(Message.RecipientType.TO, toAddress);
	  
	  //Setting email's subject
	  msg.setSubject("Grid Server Automation Status Report");
	  
	  BodyPart msgBody = new MimeBodyPart();
	  
	  //Setting email's message body
	  msgBody.setText("PFA the Grid Server UI Automation Report. Please download and open it in Chrome/Firefox for better performance");
	  
	  //Instance of second part
	  Multipart multiPart = new MimeMultipart();
	  
	  multiPart.addBodyPart(msgBody);
	  
	  //Another mail body
	  msgBody = new MimeBodyPart();
	  
	  //Path to pdf file for attachment
	  DataSource source = new FileDataSource(path);
	  
	  DataHandler dataHandler = new DataHandler(source);
	  
	  msgBody.setDataHandler(dataHandler);
	  
	  msgBody.setFileName(path);
	  
	  multiPart.addBodyPart(msgBody);
	  
	  msg.setContent(multiPart);
	  
	  //Authentication and connection establishment to the sender's mail
	  Transport transport = session.getTransport("smtps");
	  transport.connect("smtp.gmail.com",465,"pmulak@tibco.com","");
	  transport.sendMessage(msg, msg.getAllRecipients());
	  transport.close();
	  
	  System.out.println("Mail Sent to: "+receiver);
	  }
	  
	  
}

	
	

  
  protected void endHtml(PrintWriter out) { out.println("</body></html>"); }



  
  private class TestSorter
    extends Object
    implements Comparator<IInvokedMethod>
  {
    private TestSorter(Object object) {}


    
    public int compare(IInvokedMethod o1, IInvokedMethod o2) { return (int)(o1.getDate() - o2.getDate()); }
  }
}
