# Intrinsic JAXP Validator

An implementation of the Java XML validation API [`SchemaFactory`](https://docs.oracle.com/javase/7/docs/api/javax/xml/validation/SchemaFactory.html)
to validate XML documents against their own declared grammars.

## How to use it

### Just as a Maven Dependency

This Maven artifact can be added as a dependency for any JAXP-compliant<sup>(2)</sup>
validator, such as the [XML Maven Plugin](https://www.mojohaus.org/xml-maven-plugin/).

You can find a example here : <https://github.com/labo-jim/intrinsic-validator-test-project>

### In your Java application

````
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
````

````
final String schemaLanguage = "http://componentcorp.com/xml/ns/xml-model/1.0";
SchemaFactory intrinsicSchemaFactory = SchemaFactory.newInstance(schemaLanguage);

Schema schema = intrinsicSchemaFactory.newSchema();	
Validator validator = schema.newValidator();

Source yourXML = Your XML...
validator.validate(yourXML);
````

The instanciation of a SAX [`ValidatorHandler`](https://docs.oracle.com/javase/7/docs/api/javax/xml/validation/ValidatorHandler.html)
is not supported for several reasons<sup>(1)</sup> (cf. below).

## What's under the hood

* The *Intrinsic JAXP Validator* will launch a SAX parsing of the document being
validating to fetch :
  * The [`xml-model` processing instrunction](https://www.w3.org/TR/xml-model/#the-xml-model-processing-instruction)
  * (*In a further release*), the [`xsi:@*` XML Schema Instance Attributes](https://msdn.microsoft.com/en-us/library/ms256207(v=vs.110).aspx)
* After that, it will instanciate a 
[`Validator`](https://docs.oracle.com/javase/7/docs/api/javax/xml/validation/Validator.html)
for each declared grammar found, and validate the document against it.

## Simple and Stupid

The *Intrinsic JAXP Validator* is designed under the [KISS principle](https://en.wikipedia.org/wiki/KISS_principle).  
It is simple and stupid.

The *Intrinsic JAXP Validator* does not handle himself any validation process.  
It will simply instanciate a [`SchemaFactory`](https://docs.oracle.com/javase/7/docs/api/javax/xml/validation/SchemaFactory.html)
for the declared schemma language.

This meens that you, of course, need to have a matching JAXP-compliant<sup>(2)</sup>
implementation of each schema type you use in your classpath.<sup>(3)</sup>

## Notes

1. **Why not supporting the SAX validation** (i.e. with a [`ValidatorHandler`](https://docs.oracle.com/javase/7/docs/api/javax/xml/validation/ValidatorHandler.html))
    * Because the goal of this helper is to validate XML documents against various
    Schema type, including the *unusual suspects*, i.e. Schematron and NVDL, for witch
    no SAX implementation is available.
    * Since who can do more can do less, validators that implements the
  [`ValidatorHandler`](https://docs.oracle.com/javase/7/docs/api/javax/xml/validation/ValidatorHandler.html)
  also implements the [`Validator`](https://docs.oracle.com/javase/7/docs/api/javax/xml/validation/Validator.html)
2. JAXP stands for *JAva XML Processing* API.  
   cf. <https://docs.oracle.com/javase/7/docs/api/javax/xml/validation/package-summary.html
3. An implementation for W3C XML-Schema is provided with the JVM.  
   For RelaxNG, see these wrappers for [Jing](http://www.thaiopensource.com/relaxng/jing.html) :
   * [XML "full" syntax](https://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22com.componentcorp.xml.validation%22%20AND%20a%3A%22relaxng%22)
   * [compact syntax](https://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22com.componentcorp.xml.validation%22%20AND%20a%3A%22relaxng-compact%22)

