package com.codinginfinity.research.services.utilities;

import java.lang.reflect.Method;

@FunctionalInterface
public interface MethodOverrideChecker 
{
	boolean overrides(Method base, Method specialized);
}