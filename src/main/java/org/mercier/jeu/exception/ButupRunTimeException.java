package org.mercier.jeu.exception;

public class ButupRunTimeException extends RuntimeException {

	private static final long serialVersionUID = -8616830523517387653L;

	public ButupRunTimeException() {
		super();
	}

	public ButupRunTimeException(String message) {
		super(message);
	}

	public ButupRunTimeException(Throwable cause) {
		super(cause);
	}

}
