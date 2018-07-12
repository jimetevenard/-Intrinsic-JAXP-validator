package com.jimetevenard.xml.intrinsicValidator.utils;

import java.io.PrintStream;


public class DebugTracer {
	
	private static final String PREFIX = "[\033[33mIntrinsic Validator\033[0m] ";
	

	public static <T> void traceIterable(Iterable<T> it, String label) {
	
		pPrint(" --- "+label+" --- ");
		if(it == null){
			pPrint("Provided Iterable is null !!");
		} else {
			for (Object o : it) {
				pPrint("\t* " + o.toString());
			}
		}
		
	}
	
	public static void pPrint(String msg){
		PrintStream p = System.out;
		p.println(PREFIX+msg);
	}

}
