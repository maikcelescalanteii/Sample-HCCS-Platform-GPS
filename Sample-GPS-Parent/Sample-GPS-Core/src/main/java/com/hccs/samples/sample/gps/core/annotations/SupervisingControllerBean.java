package com.hccs.samples.sample.gps.core.annotations;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Bean;


/**
 * Indicates an object to be a supervising controller
 * 
 * This is marked as Bean indication of the supervising controller
 * having no default constructor thus can't be
 * marked as @Component
 * 
 * @author Peakielsam
 */
@Target( {
	ElementType.METHOD, ElementType.ANNOTATION_TYPE
} )
@Retention( RetentionPolicy.RUNTIME )
@Documented
@Bean
public @interface SupervisingControllerBean {

	String[] name() default {};

}
