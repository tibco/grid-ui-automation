package com.tibco.automation.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tibco.automation.common.utils.ssh.DefaultSshShellFactory;
import com.tibco.automation.common.utils.ssh.SshShell;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverManager;
import com.tibco.automation.common.utils.ssh.SshShellStreams;
import com.tibco.automation.page.common.HomePage;

public class DBAcess {

	private final static Log logger = LogFactory.getLog(DBAcess.class);
	String appliance_IP = "";
	ExtendedWebDriver driver;
	{// getting appliance IP from application URL to Connect using SSH
		String applicationURL = PropertiesUtil.getBundle().getPropertyValue("application.url").toString();
		String pattern = "\\d{1,3}(?:\\.\\d{1,3}){3}(?::\\d{1,5})?";
		Pattern compiledPattern = Pattern.compile(pattern);
		Matcher matcher = compiledPattern.matcher(applicationURL);
		while (matcher.find()) {
			appliance_IP = matcher.group();

		}
	}

	public void getColumnsNames(String tableName, String columnName[]) throws Exception {
		logger.info("Check if Columns are present in database from  '" + tableName + "'  table ");
		SshShell shell;
		DefaultSshShellFactory sshFactory = new DefaultSshShellFactory();

		shell = sshFactory.getShell(appliance_IP, "toor", "logapp");

		for (int i = 0; i < columnName.length; i++) {
			String output = "";

			String command = "mysql -e \"select " + columnName[i] + " from " + tableName + "" + "\"";

			SshShellStreams streams = shell.execute(command);
			output = streams.out;
			String firstName[] = output.split("\n");
			if (streams.err.equals("") && firstName[0].equals(columnName[i])) {

				logger.info("Column present:" + firstName[0]);
				WebDriverManager.getDriver().getAssertionService().addAssertionLog("Column present:" + firstName[0],
						MessageTypes.Pass);

			} else {

				logger.info(" " + streams.err);
				WebDriverManager.getDriver().getAssertionService().addAssertionLog(" " + streams.err ,
						MessageTypes.Fail);
				throw new Exception();

			}

		}

		shell.quit();

	}

	// Used this function to compare values from column from any table:
	public void getTableContent(String tableName, String columnName[], String columnValues[], int rowNumber)
			throws Exception {

		logger.info("Verify Column Content from '" + tableName + " '\n");
		SshShell shell;

		DefaultSshShellFactory sshFactory = new DefaultSshShellFactory();

		shell = sshFactory.getShell(appliance_IP, "toor", "logapp");
		for (int i = 0; i < columnValues.length; i++) {
			if (columnValues[i] == " ") {
				String command = "mysql -e \"select " + columnName[i] + " from " + tableName + "" + "\"";
				logger.info("columnName[" + i + "]" + columnName[i]);
				SshShellStreams streams = shell.execute(command);
				String output = streams.out;
				String out[] = output.split("\n");
				if (streams.err.equals("")) {
					logger.info("ColumnName: " + out[0]);
					WebDriverManager.getDriver().getAssertionService().addAssertionLog("Value Not present for ColumnName:" + out[0],
							MessageTypes.Pass);
				} else {
					logger.info("error: " + streams.err);
					WebDriverManager.getDriver().getAssertionService().addAssertionLog("error: " + streams.err, MessageTypes.Fail);
					throw new Exception();
				}
			} else {

				String command = "mysql -e \"select " + columnName[i] + " from " + tableName + "" + "\"";
				logger.info("columnName[" + i + "]" + columnName[i]);
				SshShellStreams streams = shell.execute(command);
				String output = streams.out;
				String out[] = output.split("\n");
				if (streams.err.equals("") && out[rowNumber].equals(columnValues[i])) {

					logger.info("columnvalue: " + out[rowNumber]);
					WebDriverManager.getDriver().getAssertionService().addAssertionLog("Columnvalue:" + out[rowNumber],
							MessageTypes.Pass);

				} else {
					logger.info("error: " + streams.err);
					WebDriverManager.getDriver().getAssertionService().addAssertionLog("error: " + streams.err, MessageTypes.Fail);
					throw new Exception();
				}

			}
		}

		shell.quit();

	}

	public String getColumnValue(String tableName, String columnName, int rowNumber) {
		SshShell shell;
		DefaultSshShellFactory sshFactory = new DefaultSshShellFactory();
		shell = sshFactory.getShell(appliance_IP, "toor", "logapp");
		String columnValue = "";
		String command = "mysql -e \"select " + columnName + " from " + tableName + "" + "\"";
		logger.info("columnName" + columnName);
		SshShellStreams streams = shell.execute(command);
		String output = streams.out;
		String out[] = output.split("\n");
		if (streams.err.equals("")) {
			logger.info("columnvalue: " + out[rowNumber]);
			WebDriverManager.getDriver().getAssertionService().addAssertionLog("ColumnValue: " + out[rowNumber], MessageTypes.Pass);
			columnValue = out[rowNumber];
		} else {
			logger.info("error: " + streams.err);
			WebDriverManager.getDriver().getAssertionService().addAssertionLog("error: " + streams.err, MessageTypes.Fail);
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		shell.quit();
		return columnValue;

	}
}
