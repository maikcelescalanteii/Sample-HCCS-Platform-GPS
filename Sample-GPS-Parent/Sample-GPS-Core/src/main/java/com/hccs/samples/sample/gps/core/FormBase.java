package com.hccs.samples.sample.gps.core;


import javax.annotation.PostConstruct;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hccs.samples.sample.gps.core.interfaces.Form;


/**
 * Base class for Forms. Provides default context
 * for each form.
 * 
 * @author Peakielsam
 */
public abstract class FormBase implements Form {

	protected AnnotationConfigApplicationContext context;

	private boolean isInitialized;

	protected String form_identifier;


	/**
	 * Subclasses must override and provide their
	 * Spring configuration class.
	 * 
	 * @return
	 */
	public abstract Class<?> configClass();


	/**
	 * Called after object creation (i.e. constructor)
	 * and after context is created. Use
	 * this instead of marking @PostConstruct
	 * on your concrete classes so you won't
	 * get uninitialized beans
	 */
	public abstract void postContextSetup();


	/**
	 * Place component initialization here
	 */
	public abstract void initComponents();


	@PostConstruct
	public void init() {
		setupContext( configClass() );
		postContextSetup();
		setupActions();
	}


	@Override
	public void show() {
		synchronized ( this ) {
			if ( !isInitialized ) {
				initComponents();
				isInitialized = true;
			}
		}
	}


	/**
	 * Instantiates our context
	 * 
	 * @param configClass
	 */
	private void setupContext( Class<?> configClass ) {
		context = new AnnotationConfigApplicationContext( configClass );
	}


	/**
	 * Shorthand to get bean from context.
	 * 
	 * Note: Using 'protected' access modifier as this is a friend of
	 * <code>ComponentCombiner</code>. We don't want 'world' level
	 * to have access to form beans
	 * 
	 * @param type
	 *            class of interface
	 * @return
	 */
	protected <T> T getBean( Class<T> type ) {
		return context.getBean( type );
	}


	/**
	 * Shorthand to get bean from context by its name.
	 * 
	 * Note: Using 'protected' access modifier as this is a friend of
	 * <code>ComponentCombiner</code>. We don't want 'world' level
	 * to have access to form beans
	 * 
	 * 
	 * @param type
	 *            class of interface
	 * @param name
	 *            bean name of the instance.
	 * @return
	 */
	protected <T> T getBean( Class<T> type, String name ) {
		return context.getBean( name, type );
	}
	
	
	/**
	 * Form identifier
	 * 
	 * @param form_identifier
	 */
	public void setForm_identifier( String form_identifier ) {
		this.form_identifier = form_identifier;
	}
	
	
	/**
	 * Form identifier
	 * 
	 * @return
	 */
	public String getForm_identifier() {
		return form_identifier;
	}
}
