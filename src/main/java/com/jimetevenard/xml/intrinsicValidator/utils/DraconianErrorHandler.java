
package com.jimetevenard.xml.intrinsicValidator.utils;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;


public class DraconianErrorHandler implements ErrorHandler{
    public static final DraconianErrorHandler INSTANCE = new DraconianErrorHandler();
    
    public void fatalError( SAXParseException e ) throws SAXException {
        throw e;
    }
    public void error( SAXParseException e ) throws SAXException {
        throw e;
    }
    public void warning( SAXParseException e ) throws SAXException {
        // noop
    }
    
}
