package com.jimetevenard.xml.intrinsicValidator;

import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class SchemaDeclarationHandler implements ContentHandler{
	
	private boolean firstElementReached = false;
	private static final String XML_MODEL = "xml-model";
	
	private final XMLModelParser xmlModelParser = new XMLModelParser();
	
	/**
	 * 
	 * Intercepts the root element to stop PI fetching
	 */
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		if(!this.firstElementReached){
			this.firstElementReached = true;
		}

	}
	
	/**
	 * Intercepts xml-model PIs before root
	 */
	public void processingInstruction(String target, String data) throws SAXException {
		if(target.equals(XML_MODEL)){
			this.xmlModelParser.addAndParsePI(data);
		}
	}
	
	public List<XMLModelDeclaration> getXmlModelDeclarations() {
		return xmlModelParser.getParsedDeclarations();
	}
	
	// ===================================================
	// ====== Methods Below won't do anything ============


	public void setDocumentLocator(Locator locator) {
		// nothing
	}

	public void startDocument() throws SAXException {
		// nothing
	}

	public void endDocument() throws SAXException {
		// nothing
	}

	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		// nothing
	}

	public void endPrefixMapping(String prefix) throws SAXException {
		// nothing
	}

	

	public void endElement(String uri, String localName, String qName) throws SAXException {
		// nothing
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		// nothing
	}

	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		// nothing
	}

	
	public void skippedEntity(String name) throws SAXException {
		// nothing
	}



}
