package com.jaxrs.cache.config;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author giulliano
 *
 */
public class CacheConfig  {

	private static Map<String, Long> ttl = new HashMap<String, Long>(); 

	/**
	 * Sholud receive key (url) and time in time to live in milis
	 * for each key. 
	 * @param config
	 */
	public static void configure(Map<String, Long> config){
		ttl = config;
	}

	public static Long ttl(String url){
		return ttl.get(url);
	}

}
