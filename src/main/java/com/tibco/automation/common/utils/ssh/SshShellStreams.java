package com.tibco.automation.common.utils.ssh;

public class SshShellStreams {

    public String out;

    public String err;

    public SshShellStreams( String out, String err ) {
        this.out = out == null ? "" : out;
        this.err = err == null ? "" : err;
    }
}