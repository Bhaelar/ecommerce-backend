package com.example.ecommerce.exceptions;

public class UserEmailExistsException extends RuntimeException {

	private static final long serialVersionUID = 5861310537366287163L;

    public UserEmailExistsException() {
        super();
    }

    public UserEmailExistsException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UserEmailExistsException(final String message) {
        super(message);
    }

    public UserEmailExistsException(final Throwable cause) {
        super(cause);
    }
}
