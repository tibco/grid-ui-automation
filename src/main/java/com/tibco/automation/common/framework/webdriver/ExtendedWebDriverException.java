package com.tibco.automation.common.framework.webdriver;

public class ExtendedWebDriverException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExtendedWebDriverException() {
        super();
    }

    public ExtendedWebDriverException(String message) {
        super(message);
    }

    public ExtendedWebDriverException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return super.getMessage();

    }
}