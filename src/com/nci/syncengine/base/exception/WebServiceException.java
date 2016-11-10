package com.nci.syncengine.base.exception;

public class WebServiceException extends CatchedException {

	private static final long serialVersionUID = -5935167937413542509L;

	public WebServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param s
	 * @param e
	 */
	public WebServiceException(String s, Throwable e) {
		super(s, e);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param s
	 */
	public WebServiceException(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param e
	 */
	public WebServiceException(Throwable e) {
		super(e);
		// TODO Auto-generated constructor stub
	}
}
