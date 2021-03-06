/**
 * 
 */
package it.oop.SpringBootProject.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import it.oop.SpringBootProject.model.FlareEvent;
import it.oop.SpringBootProject.model.GeomagConditionsEvent;
import it.oop.SpringBootProject.model.GeomagStormEvent;
import it.oop.SpringBootProject.model.IntensityLevel;
import it.oop.SpringBootProject.model.SolarEvent;

/**
 * Deserializzatore personalizzato per la classe SolarEvent
 * 
 * @author <a href="https://github.com/mattbn">Mattia Bonanese</a>
 *
 */
@SuppressWarnings("serial")
public class SolarEventDeserializer extends StdDeserializer<SolarEvent> {
	
	private static final Map<String,SolarEvent> events = 
			Map.of("Flare", new FlareEvent(), 
					"GeomagneticConditions", new GeomagConditionsEvent(), 
					"GeomagneticStorm", new GeomagStormEvent());
	
	public SolarEventDeserializer() {
		this(null);
	}
	
	public SolarEventDeserializer(Class<?> cls) {
		super(cls);
	}
	
	@Override
	public SolarEvent deserialize(JsonParser jp, DeserializationContext dc) {
		SolarEvent res = null;
		
		try {
			
			JsonNode node = jp.getCodec().readTree(jp);
			ObjectMapper om = (ObjectMapper)jp.getCodec();
			JsonNode typeNode = node.get("type");
			for(Map.Entry<String,SolarEvent> e : events.entrySet())
				if(typeNode != null && e.getKey().equals(typeNode.asText())) {
					IntensityLevel il = om.treeToValue(node.get("intensity"), IntensityLevel.class);
					Calendar c = om.treeToValue(node.get("date"), Calendar.class);
					c.add(Calendar.YEAR, 1900); // setta la data nel formato desiderato
					return e.getValue().getClass().getDeclaredConstructor(IntensityLevel.class, 
							Calendar.class).newInstance(il, c);
				}
			
		} catch (IOException | InstantiationException | IllegalAccessException | 
				IllegalArgumentException | InvocationTargetException | 
				NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		return res;
	}

}
