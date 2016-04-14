package com.codinginfinity.research.services.utilities;

import com.codinginfinity.research.services.PreconditionViolation;

import java.lang.reflect.Method;

public interface ServiceUtilities 
{

	Class<? extends Object> getRequestClass(Object serviceProvider, String serviceName) throws NotAServiceException;

	Class<? extends Object> getResponseClass(Object serviceProvider, String serviceName) throws NotAServiceException;

	Class<? extends Object> getRequestClass(Method service) throws NotAServiceException;

	Class<? extends Object> getResponseClass(Method service) throws NotAServiceException;

	Method getService(Object serviceProvider, String methodName) throws NotAServiceException;

	class NotAServiceException extends PreconditionViolation
	{
		public NotAServiceException() { super(); }
		public NotAServiceException(String message) { super(message); }
		public NotAServiceException(Throwable cause) { super(cause); }
		public NotAServiceException(String message, Throwable cause) {super(message, cause);}
	}
		
}