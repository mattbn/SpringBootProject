/**
 * 
 */
package it.oop.SpringBootProject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;

/**
 * @author Mattia
 *
 */
public class JsonParserService {
	
	private static final ObjectMapper om = new ObjectMapper();
	
	
	public static <T> String write(T object) {
		String res = "\"error\" : \"Errore nel parsing dell'oggetto\"";
		
		try {
			res = om.writerWithDefaultPrettyPrinter().writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static <T> T read(String jsonString, Class<T> cls) {
		T res = null;
		
		try {
			res = om.readValue(jsonString, cls);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static <T> T read(String jsonString, TypeReference<T> tr) {
		T res = null;
		
		try {
			res = om.readValue(jsonString, tr);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static <T> T convert(String jsonString, TypeReference<T> tr) {
		return om.convertValue(jsonString, tr);
	}
	
	public static String getClassMetadata(Class<?> cls) {
		String res = "\"error\" : \"Errore nel parsing dell'oggetto\"";
		
		JsonSchemaGenerator jsg = new JsonSchemaGenerator(om);
		try {
			JsonSchema jschema = jsg.generateSchema(cls);
			res = write(jschema);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		}
		
		return res;
	}

}
