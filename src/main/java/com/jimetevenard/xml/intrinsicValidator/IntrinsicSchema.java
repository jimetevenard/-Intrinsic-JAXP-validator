package com.jimetevenard.xml.intrinsicValidator;

import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.validation.ValidatorHandler;

public class IntrinsicSchema extends Schema{
	
	private SchemaFactory parentFactory;
	
	

	protected IntrinsicSchema(SchemaFactory parentFactory) {
		super();
		this.parentFactory = parentFactory;
	}

	@Override
	public Validator newValidator() {
		return new IntrinsicValidator(parentFactory.getResourceResolver(), parentFactory.getErrorHandler());
	}

	@Override
	public ValidatorHandler newValidatorHandler() {
		throw new UnsupportedOperationException("no ValidatorHandler can be obtained from this Schema. use newValidator() instead.");
	}

}
