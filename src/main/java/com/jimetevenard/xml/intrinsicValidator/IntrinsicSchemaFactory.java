package com.jimetevenard.xml.intrinsicValidator;


import javax.xml.transform.Source;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

public class IntrinsicSchemaFactory extends SchemaFactory{
	
	private LSResourceResolver resourceResolver;
	private ErrorHandler errorHandler;

	private static final String INTRINSIC_NS = "http://componentcorp.com/xml/ns/xml-model/1.0";

	@Override
	public boolean isSchemaLanguageSupported(String schemaLanguage) {
		return schemaLanguage.equals(INTRINSIC_NS);
	}

	@Override
	public void setErrorHandler(ErrorHandler errorHandler) {
		this.errorHandler = errorHandler;
		
	}

	@Override
	public ErrorHandler getErrorHandler() {
		return this.errorHandler;
	}

	@Override
	public void setResourceResolver(LSResourceResolver resourceResolver) {
		this.resourceResolver = resourceResolver;
		
	}

	@Override
	public LSResourceResolver getResourceResolver() {
		return this.resourceResolver;
	}

	@Override
	public Schema newSchema(Source[] schemas) throws SAXException {
		/*
		 * We're performing intrinsic validation,
		 * so there will not be any schema Source
		 */
		return newSchema();
	}

	@Override
	public Schema newSchema() throws SAXException {
		return new IntrinsicSchema(this);
	}



}
