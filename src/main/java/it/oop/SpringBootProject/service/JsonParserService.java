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
 * Gestisce tutte le operazioni su JSON
 * 
 * @author <a href="https://github.com/mattbn">Mattia Bonanese</a>
 *
 */
public class JsonParserService {
	
	private static final ObjectMapper om = new ObjectMapper();
	
	
	/**
	 * Ottiene una stringa JSON identificativa dell'oggetto passato
	 * 
	 * @param <T> Il tipo dell'oggetto
	 * @param object L'oggetto da convertire
	 * @return La stringa identificativa (JSON)
	 */
	public static <T> String write(T object) {
		String res = "\"error\" : \"Errore nel parsing dell'oggetto\"";
		
		try {
			res = om.writerWithDefaultPrettyPrinter().writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	/**
	 * Legge una stringa JSON e ritorna un oggetto corrispondente
	 * 
	 * @param <T> Il tipo dell'oggetto 
	 * @param jsonString La stringa formato JSON
	 * @param cls La classe dell'oggetto da restituire
	 * @return L'oggetto corrispondente
	 */
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
	
	/**
	 * Legge una stringa JSON e ritorna un oggetto corrispondente
	 * 
	 * @param <T> Il tipo dell'oggetto
	 * @param jsonString La stringa formato JSON
	 * @param tr La TypeReference dell'oggetto
	 * @return L'oggetto corrispondente
	 */
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
	
	/*
	public static <T> T convert(String jsonString, TypeReference<T> tr) {
		return om.convertValue(jsonString, tr);
	}
	*/
	
	/**
	 * Ottiene i metadati di una specifica classe
	 * 
	 * @param cls La classe dell'oggetto
	 * @return Una stringa di metadati relativa all'oggetto passato
	 */
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
