package com.hccs.samples.sample.gps.core.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Indicates the object as a presentation model
 * which closely syncs with the glass
 * 
 * It encapsulates any glass operations and 
 * throws aggregated events.
 * 
 * @author Peakielsam
 */
@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Component
@Scope("prototype")
public @interface PresentationModelPrototype {

}
