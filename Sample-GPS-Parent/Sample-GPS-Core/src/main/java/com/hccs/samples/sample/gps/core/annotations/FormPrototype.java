package com.hccs.samples.sample.gps.core.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * This type of form can produce multiple instances
 * 
 * @author Peakielsam
 */
@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Component
@Scope("prototype")
public @interface FormPrototype {

	String[] name() default {};

}
