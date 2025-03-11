package com.tibco.automation.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tibco.automation.common.utils.ssh.DefaultSshShellFactory;
import com.tibco.automation.common.utils.ssh.SshShell;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.tibco.automation.common.framework.reporter.LLReporter.MessageTypes;
import com.tibco.automation.common.framework.webdriver.ExtendedWebDriver;
import com.tibco.automation.common.framework.webdriver.WebDriverManager;
import com.tibco.automation.common.utils.ssh.SshShellStreams;
import com.tibco.automation.page.common.HomePage;

public class Backend {

	private final static Log logger = LogFactory.getLog(Backend.class);
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

	public String getLatestFileName() {
		String latestFileName = "";
		SshShell shell;
		DefaultSshShellFactory sshFactory = new DefaultSshShellFactory();
		shell = sshFactory.getShell(appliance_IP, "toor", "logapp");
		String command = "cd /loglogic/backup_prep/status_files;ls -t | head -n1";
		SshShellStreams streams = shell.execute(command);
		String[] output = streams.out.split("\n");
		if (streams.err.equals("")) {
			logger.info(command + output[0]);
			latestFileName = output[0];
		} else {
			logger.info("error:" + streams.err);
			WebDriverManager.getDriver().getAssertionService().assertFalse(true, streams.err);

		}

		return latestFileName;
	}

	public void deleteFiles() {
		SshShell shell;
		DefaultSshShellFactory sshFactory = new DefaultSshShellFactory();
		shell = sshFactory.getShell(appliance_IP, "toor", "logapp");
		String commandDelete = "rm -r -f /loglogic/backup_prep/status_files/*";

		shell.execute(commandDelete);

	}

	public void verifySysLogFile() throws Exception {
		SshShell shell;
		String error = "error", fail = "fail", exception = "exception";
		String syslog;
		DefaultSshShellFactory sshFactory = new DefaultSshShellFactory();
		shell = sshFactory.getShell(appliance_IP, "toor", "logapp");
		String command = "tac /var/log/sys.log | awk 'NR <=20'";
		SshShellStreams streams = shell.execute(command);
		syslog = streams.out;
		logger.info("sys.log file: \n" + syslog);
		WebDriverManager.getDriver().getAssertionService().addAssertionLog("sys.log file: \n" + syslog, MessageTypes.Info);
		String syslogIgnorCase = syslog.toLowerCase();
		if (syslogIgnorCase.contains(error) || syslogIgnorCase.contains(fail) || syslogIgnorCase.contains(exception)) {
			WebDriverManager.getDriver().getAssertionService().addAssertionLog("error || fail || exception present in sys.log file",
					MessageTypes.Fail);
			logger.info("error || fail || exception present in sys.log file");
		} else {
			WebDriverManager.getDriver().getAssertionService().addAssertionLog("syslog doesn't have error/fail/exception in sys.log",
					MessageTypes.Pass);
			logger.info("syslog doesn't have error/fail/exception in sys.log");
		}

		shell.quit();

	}

	public void verifyStatusFile(String latestFileName) throws Exception {
		SshShell shell;
		String error = "error", fail = "fail", exception = "exception";
		String statusFile;
		DefaultSshShellFactory sshFactory = new DefaultSshShellFactory();
		shell = sshFactory.getShell(appliance_IP, "toor", "logapp");
		String command = "cat /loglogic/backup_prep/status_files/" + latestFileName;
		logger.info(command);
		SshShellStreams streams = shell.execute(command);
		statusFile = streams.out;
		logger.info("Status file: \n" + statusFile);
		String statusFileIgnorCase = statusFile.toLowerCase();
		if (statusFileIgnorCase.contains(error) || statusFileIgnorCase.contains(fail)
				|| statusFileIgnorCase.contains(exception)) {
			WebDriverManager.getDriver().getAssertionService().addAssertionLog("error || fail || exception present in status File",
					MessageTypes.Fail);
			logger.info("error || fail || exception present in status File");
		} else {
			WebDriverManager.getDriver().getAssertionService().addAssertionLog("status File doesn't have error/fail/exception",
					MessageTypes.Pass);
			logger.info("status File doesn't have error/fail/exception");
		}

		shell.quit();

	}

	/*
	 * parameters: 
	 * source- source File name with location 
	 * destination- destination on appliance
	 */
	public void copyFile(String source, String destination) {
		JSch jsch = new JSch();
		Session session = null;
		logger.info("Copying " + source + " to appliance....");
		WebDriverManager.getDriver().getAssertionService().addAssertionLog("Copying " + source + " to appliance....", MessageTypes.Info);
		try {
			session = jsch.getSession("toor", appliance_IP, 22);
			session.setPassword("logapp");
			//session.setConfig("StrictHostKeyChecking", "no");
			session.connect();
			ChannelSftp channel = null;
			channel = (ChannelSftp) session.openChannel("sftp");
			channel.connect();
			File localFile = new File(source);
			channel.cd(destination);
			try {
				channel.put(new FileInputStream(localFile), localFile.getName());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			channel.disconnect();
			session.disconnect();
			logger.info("Done....!!!");
			WebDriverManager.getDriver().getAssertionService().addAssertionLog("Done....!!!", MessageTypes.Info);
		} catch (JSchException e) {
			e.printStackTrace();
		} catch (SftpException e) {
			e.printStackTrace();
		}

	}

	public void mtaskStopStart() {
		SshShell shell;
		DefaultSshShellFactory sshFactory = new DefaultSshShellFactory();
		shell = sshFactory.getShell(appliance_IP, "toor", "logapp");
		String command = "cd /loglogic/bin;mtask stop;mtask start";
		logger.info(command);
		logger.info("Stop mtask and then start again...");
		WebDriverManager.getDriver().getAssertionService().addAssertionLog("Stop mtask and then start again...", MessageTypes.Info);
		SshShellStreams streams = shell.execute(command);

	}

	public boolean checkFilePresent(String path) {
		SshShell shell;
		DefaultSshShellFactory sshFactory = new DefaultSshShellFactory();
		shell = sshFactory.getShell(appliance_IP, "toor", "logapp");
		String command = " [ -f " + path + " ] && echo Present || echo Not Present";			
		SshShellStreams streams = shell.execute(command);
		String verifyFilePresent = streams.out;		
		logger.info(verifyFilePresent);
		if (verifyFilePresent.contains("Not Present")) {
			return false;
		} else {
			return true;
		}
	}

	
}
