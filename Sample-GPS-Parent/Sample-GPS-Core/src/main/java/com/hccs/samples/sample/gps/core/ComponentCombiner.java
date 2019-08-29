package com.hccs.samples.sample.gps.core;


import java.util.Objects;

import com.hccs.samples.sample.gps.core.interfaces.GlassAttacher;
import com.hccs.samples.sample.gps.core.interfaces.GlassGrabber;


public abstract class ComponentCombiner<T> {

	protected GlassAttacher<T> attacher;
	protected GlassGrabber<T> grabber;
	protected FormBase form;


	protected void setForm( FormBase form ) {
		this.form = form;
	}


	protected <G> G getGlass( Class<G> type ) {
		return form.getBean( type );
	}


	protected <G> G getGlass( Class<G> type, String name ) {
		return form.getBean( type, name );
	}


	protected void setAttacher( GlassAttacher<T> attacher ) {
		this.attacher = attacher;
	}


	protected void setGrabber( GlassGrabber<T> grabber ) {
		this.grabber = grabber;
	}


	public void combineTwoComponents() {
		Objects.requireNonNull( attacher );
		Objects.requireNonNull( grabber );
		this.attacher.attachComponent( grabber.getComponent() );
	}
}
