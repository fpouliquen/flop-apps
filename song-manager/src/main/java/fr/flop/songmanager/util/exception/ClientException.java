package fr.flop.songmanager.util.exception;

public class ClientException extends Exception {

	private static final long serialVersionUID = 8408080488869203352L;

	public ClientException(String message) {
		super(message);
	}

	public ClientException(String message, Throwable exception) {
		super(message, exception);
	}
}
