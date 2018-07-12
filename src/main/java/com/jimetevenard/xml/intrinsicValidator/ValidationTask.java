package com.jimetevenard.xml.intrinsicValidator;

import javax.xml.transform.Source;

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
	
	
	
	
	
	

}
