package com.tibco.automation.common.utils.ssh;

public interface SshShellFactory {
    SshShell getShell( String host, String user, String password );
}
