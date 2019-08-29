package com.hccs.samples.sample.gps.core;


import java.util.HashMap;
import java.util.Map;


/**
 * This transform target class is used for <code>Transformer</code>
 * to easily add parameters to its transform function
 * 
 * @author Peakielsam
 *
 * @param <T>
 */
public class TransformTarget<T> {

	public T target;

	private Map<String, Object> params;


	public TransformTarget() {
		params = new HashMap<String, Object>();
	}


	public boolean hasParameter( String key ) {
		return params.containsKey( key );
	}


	@SuppressWarnings( "unchecked" )
	public <K> K getParameter( String key ) {
		try {
			K o = (K) params.get( key );
			return o;
		} catch ( ClassCastException cex ) {
			throw new RuntimeException( "Type of transform target parameter does not match", cex );
		}
	}


	public <K> void addParameter( String key, K obj ) {
		params.put( key, obj );
	}

}
