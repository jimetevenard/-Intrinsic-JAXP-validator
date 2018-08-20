package com.jimetevenard.xml.intrinsicValidator;

import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

public class ValidationTask {
	
	
	
	private String schemaLanguageURI;
	
	private Source schema;

	protected ValidationTask(String schemaLanguageURI, Source schema) {
		super();
		this.schemaLanguageURI = schemaLanguageURI;
		this.schema = schema;
	}

	public String getSchemaLanguageURI() {
		return schemaLanguageURI;
	}

	public Source getSchema() {
		return schema;
	}

	@Override
	public String toString() {
		return "ValidationTask [schemaLanguageURI=" + schemaLanguageURI + ", schema(Source) systemID=" + schema.getSystemId() + "]";
	}
	
	public void performValidation(Source xmlDocument, LSResourceResolver resolver, ErrorHandler errorHandler) throws SAXException, IOException{
		SchemaFactory schemaFactory = SchemaFactory.newInstance(this.getSchemaLanguageURI());
		schemaFactory.setResourceResolver(resolver);
		schemaFactory.setErrorHandler(errorHandler);
		
		Schema schema = schemaFactory.newSchema(this.getSchema());
		Validator validator = schema.newValidator();
		validator.validate(xmlDocument);
	}
	
	
	
	
	
	

}
