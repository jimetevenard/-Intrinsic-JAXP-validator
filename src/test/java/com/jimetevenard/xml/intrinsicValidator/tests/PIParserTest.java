package com.jimetevenard.xml.intrinsicValidator.tests;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import com.jimetevenard.xml.intrinsicValidator.utils.ProcessingInstructionParser;

public class PIParserTest {
	
	@Test
	public void ValidDoubleQuotedTest(){
		String testOK = "toto=\"Contenu de toto\" tata=\"Contenu de tata\" ";
		Map<String, String> map = ProcessingInstructionParser.parseData(testOK);
		
		if(map.size() != 2) fail();
		if(!map.get("toto").equals("Contenu de toto")) fail();
		if(!map.get("tata").equals("Contenu de tata")) fail();
	}
	
	@Test
	public void ValidSimpleQuotedTest(){
		String testOK = "toto='Contenu de toto avec simple quote' tata='Contenu de tata avec simple quote' ";
		Map<String, String> map = ProcessingInstructionParser.parseData(testOK);
		
		if(map.size() != 2) fail();
		if(!map.get("toto").equals("Contenu de toto avec simple quote")) fail();
		if(!map.get("tata").equals("Contenu de tata avec simple quote")) fail();
	}
	
	@Test
	public void ValidMixedTest(){
		String testOK = "toto='Contenu de toto avec simple quote' foo=\"Contenu de foo\" tata='Contenu de tata avec simple quote' ";
		Map<String, String> map = ProcessingInstructionParser.parseData(testOK);
		
		if(map.size() != 3) fail();
		if(!map.get("toto").equals("Contenu de toto avec simple quote")) fail();
		if(!map.get("foo").equals("Contenu de foo")) fail();
	}
	
}
