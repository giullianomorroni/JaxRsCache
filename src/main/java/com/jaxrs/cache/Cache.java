package com.jaxrs.cache;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.jaxrs.cache.config.CacheConfig;

public class Cache  {

	private static Map<String, Object> cache = new HashMap<>();
	private static Map<String, Long> ttl = new HashMap<>();

	public Cache() {
		super();
	}

	/**
	 * Add a value to cache.
	 * @param url
	 * @param value
	 */
	public void put(String url, Object value){
		Long timeInMillis = Calendar.getInstance().getTimeInMillis();
		cache.put(url, value);
		ttl.put(url, timeInMillis);
	}

	/**
	 * Add a value to cache and register its time to live
	 * @param url
	 * @param value
	 * @param timeToLive
	 */
	public void put(String url, Object value, Long timeToLive){
		Long timeInMillis = Calendar.getInstance().getTimeInMillis();
		cache.put(url, value);
		ttl.put(url, timeInMillis);
		CacheConfig.ttl(url, timeToLive);
	}

	public Object get(String url){
		Long timeInMillis = Calendar.getInstance().getTimeInMillis();
		Long createdTimeInMillis = ttl.get(url);
		if (createdTimeInMillis == null)
			return null;
		Long timeToLiveInMillis = CacheConfig.ttl(url);

		if ((timeInMillis - createdTimeInMillis) > timeToLiveInMillis) {
			Object value = cache.get(url);
			cache.remove(url);
			return value;
		}

		return cache.get(url);
	}

}
