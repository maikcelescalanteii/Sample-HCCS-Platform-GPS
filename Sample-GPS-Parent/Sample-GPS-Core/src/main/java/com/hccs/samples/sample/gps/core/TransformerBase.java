package com.hccs.samples.sample.gps.core;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.hccs.samples.sample.gps.core.interfaces.Transformer;


public abstract class TransformerBase<T, R> implements ApplicationContextAware, Transformer<T, R> {

	protected ApplicationContext context;


	@Override
	public void setApplicationContext( ApplicationContext applicationContext ) throws BeansException {
		this.context = applicationContext;
	}


	/**
	 * 
	 * Shorthand to get bean from context.
	 * 
	 * @param type
	 *            class of interface
	 * @return
	 */
	protected <C> C getBean( Class<C> type ) {
		return context.getBean( type );
	}
}
