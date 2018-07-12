package com.jimetevenard.xml.intrinsicValidator.utils;

import java.io.PrintStream;
import java.util.List;

import com.jimetevenard.xml.intrinsicValidator.XMLModelDeclaration;

public class DebugTracer {
	
	private static final String PREFIX = "[\033[33mIntrinsic Validator\033[0m] ";
	

	public static void traceDeclarations(List<XMLModelDeclaration> xms) {
		
		
		prefixedPrint(" --- XML-MODEL DECLARATIONS --- ");
		if(xms == null){
			prefixedPrint("List is null !!");
		} else {
			prefixedPrint(xms.size() + " Declaration found");
			
			for (XMLModelDeclaration xmd : xms) {
				prefixedPrint(xmd.toString());
			}
		}
		
	}
	
	private static void prefixedPrint(String msg){
		PrintStream p = System.out;
		p.println(PREFIX+msg);
	}

}
