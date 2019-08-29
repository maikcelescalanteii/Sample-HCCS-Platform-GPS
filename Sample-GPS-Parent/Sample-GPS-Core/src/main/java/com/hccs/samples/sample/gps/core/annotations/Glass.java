package com.hccs.samples.sample.gps.core.annotations;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;


/**
 * Indicates the object is a member of glass layer which
 * contains the view logic and components
 * 
 * @author Peakielsam
 */
@Target(ElementType.TYPE)
@Documented
@Retention( RetentionPolicy.RUNTIME )
@Component
public @interface Glass {

}
