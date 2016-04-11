package com.codinginfinity.research.services.utilities;

import com.codinginfinity.research.services.Request;
import com.codinginfinity.research.services.Response;

import java.lang.reflect.Method;

public class ServiceUtilitiesBean implements ServiceUtilities
{
	@Override
	public Class<? extends Object> getRequestClass(Object serviceProvider, String serviceName) throws
		NotAServiceException
	{
		return getRequestClass(getService(serviceProvider, serviceName));
	}

	@Override
	public Class<? extends Object> getResponseClass(Object serviceProvider, String serviceName) throws
		NotAServiceException
	{
		return getResponseClass(getService(serviceProvider, serviceName));
	}

	@Override
	public Class<? extends Object> getRequestClass(Method service) throws NotAServiceException 
	{
		if (service.getParameters().length != 1)
			throw new NotAServiceException("More than one parameter");
		else
		{
			Class<? extends Object> requestClass = service.getParameters()[0].getType();
			if (Request.class.isAssignableFrom(requestClass))
				return requestClass;
			else
				throw new NotAServiceException("Parameter not a Request class");
		}
	}

	@Override
	public Class<? extends Object> getResponseClass(Method service) throws NotAServiceException
	{
		Class<? extends Object> responseClass = service.getReturnType();
		if (Response.class.isAssignableFrom(responseClass))
			return responseClass;
		else
			throw new NotAServiceException("Return type not a Response class");
	}

	@Override
	public Method getService(Object serviceProvider, String serviceName) throws NotAServiceException
	{
		for (Method service: serviceProvider.getClass().getMethods())
		{
			if (service.getName().equals(serviceName))
			{
				getRequestClass(service);
				return service;
			}
		}	
		throw new NotAServiceException("Method with that name does not exist");
	}

}