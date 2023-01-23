package org.lobo.holidays.exception;

/**
 * The type Domain exception.
 * @author joseluis.anton
 */
public class DomainException extends RuntimeException{

  /**
   * Instantiates a new Domain exception.
   */
  public DomainException() {
  }

  /**
   * Instantiates a new Domain exception.
   *
   * @param message the message
   */
  public DomainException(String message) {
    super(message);
  }

  /**
   * Instantiates a new Domain exception.
   *
   * @param message the message
   * @param cause   the cause
   */
  public DomainException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Instantiates a new Domain exception.
   *
   * @param cause the cause
   */
  public DomainException(Throwable cause) {
    super(cause);
  }

  /**
   * Instantiates a new Domain exception.
   *
   * @param message            the message
   * @param cause              the cause
   * @param enableSuppression  the enable suppression
   * @param writableStackTrace the writable stack trace
   */
  public DomainException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
