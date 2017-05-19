package fr.flop.songmanager.util.exception;

public class ServerException extends RuntimeException {

	private static final long serialVersionUID = -8991087361429839974L;

	public ServerException(String message) {
		super(message);
	}

	public ServerException(String message, Throwable e) {
		super(message, e);
	}
}
