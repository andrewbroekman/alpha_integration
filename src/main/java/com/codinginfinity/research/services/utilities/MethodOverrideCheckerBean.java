package com.codinginfinity.research.services.utilities;

import java.lang.reflect.Method;

public class MethodOverrideCheckerBean implements MethodOverrideChecker 
{
	@Override
	public boolean overrides(Method base, Method specialized) 
	{
		if (!base.getName().equals(specialized.getName()))
			return false;
		else
			return sameParameters(base, specialized); // && sameReturnType(base, specialized);
	}

	private boolean sameParameters(Method m1, Method m2)
	{
		if (m1.getParameterCount() != m2.getParameterCount())
			return false;

		for (int i=0; i<m1.getParameters().length; ++i)
			if (!m1.getParameters()[i].getType().equals(m2.getParameters()[i].getType()))
				return false;
		
		return true;
	}

	private Boolean sameReturnType(Method m1, Method m2)
	{
		if (m1.getReturnType().equals(m2.getReturnType()))
			return true;
		else
			return false;
	}

}