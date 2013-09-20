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

	/**
	 * If its key doesnt have an ttl value will assume defaul 86400 (one day from time its inputed)
	 * @param url
	 * @return
	 */
	public static Long ttl(String url){
		Long timeToLive = ttl.get(url);
		if (timeToLive == null) {
			timeToLive = 86400L;
			ttl.put(url, timeToLive);
		}
		return timeToLive;
	}

	public static void ttl(String url, Long timeToLive){
		ttl.put(url, timeToLive);
	}

}
