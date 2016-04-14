package com.codinginfinity.research.services.mocking;

import java.lang.annotation.*;

/**
 * Created by andrew on 2016/04/11.
 */
@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Mocking {}
