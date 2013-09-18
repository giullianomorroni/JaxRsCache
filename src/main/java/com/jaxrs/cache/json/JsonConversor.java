package com.jaxrs.cache.json;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonConversor {

	public static String json(Object object) {
		if (object == null)
			return null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(object);
			return json;
		} catch (JsonParseException | JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
