package com.visa.prj.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Its for the RUNTIME to execute it.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // Table level
public @interface Table {
	// LHS setters, RHS getters.
	String name(); // Property, no variables & no methods.
}
