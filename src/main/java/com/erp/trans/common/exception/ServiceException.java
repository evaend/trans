package com.erp.trans.common.exception;

/**
 * 服务层异常定义
 * */
public class ServiceException extends BaseException{

	public ServiceException() {
		super();
	}


	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

}
