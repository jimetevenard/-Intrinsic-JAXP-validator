package com.jimetevenard.xml.intrinsicValidator;

/**
 * 
 * 
 * @author ext-jetevenard
 *
 */
public class XMLModelDeclaration {
	
	private String href;
	// Specifies the location of the referenced schema. Documents must specify this pseudo-attribute. Documents must set the value to a string that matches the grammar for <IRI-reference> given in RFC 3987 [RFC3987].

	private String type;
	// Specifies the content type of the referenced schema. If unspecified, the xml-model processor should return a parsing result that would be identical to that when the value is given as application/xml. The value of this pseudo-attribute is advisory in that it is intended to be used by an application only when no other source of media type information becomes available during retrieval of the schema itself.

	private String schematypens;
	// Specifies the namespace name of the schema language in which the referenced schema is written. The application can use this value when determining whether it can make use of the referenced schema.

	private String charset;
	// Specifies the character encoding for the referenced schema. If specified, documents must set the value to a valid character encoding name, which must be the name or alias labeled as "preferred MIME name" in the IANA Character Sets registry, if there is one, or the encoding's name, if none of the aliases are so labeled [IANACHARSET].

	private String title;
	// Gives the title (or other human readable description) of the referenced schema. If specified, documents may use any string as the value.

	private String group;
	// If, for any xml-model processing instruction, its group pseudo-attribute has a non-empty value, special rules for associating schemas apply as follows:
	// By default only schemas which do not have a group pseudo-attribute specified or schemas which have an empty value in the group pseudo-attribute on the corresponding xml-model processing instruction are treated as being associated with XML document.
	// An application may provide an interface for specifying a group name. If the group name is specified, only schemas which have the same value specified in the group pseudo-attribute on the corresponding xml-model processing instruction are considered to be associated with the XML document.

	private String phase;

	
	
	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSchematypens() {
		return schematypens;
	}

	public void setSchematypens(String schematypens) {
		this.schematypens = schematypens;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	@Override
	public String toString() {
		return "XMLModelDeclaration [href=" + href + ", type=" + type + ", schematypens=" + schematypens + ", charset="
				+ charset + ", title=" + title + ", group=" + group + ", phase=" + phase + "]";
	}
	
	
	
	

}
