package com.jimetevenard.xml.intrinsicValidator;

import java.io.InputStream;
import java.io.Reader;

import javax.xml.transform.Source;

import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;


public class ValidationTaskFactory {
	
	private static final String TYPE_DTD = "application/xml-dtd";
	private static final String TYPE_RNC = "application/relax-ng-compact-syntax";
	static public final String RELAXNG_COMPACT_URI
    	= "http://www.iana.org/assignments/media-types/application/relax-ng-compact-syntax";
			
	
	private LSResourceResolver resolver;
	private String baseSystemID;
	
	public ValidationTask of(XMLModelDeclaration declaration){

		
		
		String schemaLanguageURI;		
		if(declaration.getSchematypens() != null && !declaration.getSchematypens().isEmpty()){
			schemaLanguageURI = declaration.getSchematypens();
		} else {
			schemaLanguageURI = nonXMLSchemaURI(declaration);
		}
		
	
		Source schema = resolveHref(declaration);
		return new ValidationTask(schemaLanguageURI, schema);
		
		
		
	}
	private Source resolveHref(XMLModelDeclaration declaration) {
		this.checkState();
		LSInput input = resolver.resolveResource(declaration.getType(), declaration.getSchematypens(), declaration.getHref(), declaration.getHref(), baseSystemID);
		return convertLSInputToSource(input);
	}
	
	private Source convertLSInputToSource(LSInput input) {
        Source source=null;
        Reader reader=input.getCharacterStream();
        if (reader!=null){
            source = new StreamSource(reader);
            source.setSystemId(input.getSystemId());
        }
        else{
            InputStream stream= input.getByteStream();
            if (stream!=null){
                source = new StreamSource(stream);
                source.setSystemId(input.getSystemId());
            }
        }
        return source;
    }
	private void checkState(){
		if(this.resolver == null) throw new IllegalStateException("No URIResolver !");
		if(this.baseSystemID == null) throw new IllegalStateException("No base systemID !");
	}

	private static String nonXMLSchemaURI(XMLModelDeclaration declaration) {
		switch (declaration.getType()) {
		case TYPE_RNC:
			return RELAXNG_COMPACT_URI;
		case TYPE_DTD:
			throw new UnsupportedOperationException("No DTD handling at the moment.");
		default:
			throw new UnsupportedOperationException("Unknown type.");
		}
	}
	
	
	public LSResourceResolver getResolver() {
		return resolver;
	}
	public void setResolver(LSResourceResolver resolver) {
		this.resolver = resolver;
	}
	public String getBaseSystemID() {
		return baseSystemID;
	}
	public void setBaseSystemID(String baseSystemID) {
		this.baseSystemID = baseSystemID;
	}
	
	

}
