package com.jimetevenard.xml.intrinsicValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jimetevenard.xml.intrinsicValidator.utils.ProcessingInstructionParser;

public class XMLModelParser {
	
	private static final String HREF = "href";
	private static final String TYPE = "type";
	private static final String SCHEMA_TYPENS = "schematypens";
	private static final String CHARSET = "charset";
	private static final String TITLE = "title";
	private static final String GROUP = "group";
	private static final String PHASE = "phase";
	
	private List<XMLModelDeclaration> parsedDeclarations = new ArrayList<XMLModelDeclaration>();
	
	public void addAndParsePI(String piData){
		Map<String, String> piValuesMap = ProcessingInstructionParser.parseData(piData);
		XMLModelDeclaration declaration = new XMLModelDeclaration();
		
		populateDeclaration(declaration, piValuesMap);
		
		this.parsedDeclarations.add(declaration);
	}
	
	public List<XMLModelDeclaration> getParsedDeclarations() {
		return parsedDeclarations;
	}
	
	private void populateDeclaration(XMLModelDeclaration declaration, Map<String, String> piValuesMap){
		declaration.setCharset(piValuesMap.get(CHARSET));
		declaration.setGroup(piValuesMap.get(GROUP));
		declaration.setHref(piValuesMap.get(HREF));
		declaration.setPhase(piValuesMap.get(PHASE));
		declaration.setSchematypens(piValuesMap.get(SCHEMA_TYPENS));
		declaration.setTitle(piValuesMap.get(TITLE));
		declaration.setType(piValuesMap.get(TYPE));
	}
	
	

}
