package com.jimetevenard.xml.intrinsicValidator;

import javax.xml.transform.Source;

public class ValidationTask {
	
	private static final String TYPE_DTD = "application/xml-dtd";
	private static final String TYPE_RNC = "application/relax-ng-compact-syntax";
	static public final String RELAXNG_COMPACT_URI
    	= "http://www.iana.org/assignments/media-types/application/relax-ng-compact-syntax";
			
	
	private String schemaLanguageURI;
	
	private Source schema;
	
	private ValidationTask(){
		
	}

	public static ValidationTask of(XMLModelDeclaration declaration){
		throw new RuntimeException("TODO"); // TODO
	}

	public String getSchemaLanguageURI() {
		return schemaLanguageURI;
	}

	public Source getSchema() {
		return schema;
	}
	
	

}
