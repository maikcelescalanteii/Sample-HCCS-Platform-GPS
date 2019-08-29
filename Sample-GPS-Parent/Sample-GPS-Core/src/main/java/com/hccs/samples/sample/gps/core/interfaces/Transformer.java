package com.hccs.samples.sample.gps.core.interfaces;


/**
 * General interface for transforming objects
 * such as domain models to adapters
 * 
 * @author Peakielsam
 *
 * @param <T> type of object to transform
 * @param <R> return type
 */
public interface Transformer<T,R> {

	R transform(T obj);
}
