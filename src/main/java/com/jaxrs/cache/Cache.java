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

	public void put(String url, Object value){
		long timeInMillis = Calendar.getInstance().getTimeInMillis();
		cache.put(url, value);
		ttl.put(url, timeInMillis);
	}

	public Object get(String url){
		long timeInMillis = Calendar.getInstance().getTimeInMillis();
		long createdTimeInMillis = ttl.get(url);
		long timeToLiveInMillis = CacheConfig.ttl(url);

		if ((timeInMillis - createdTimeInMillis) > timeToLiveInMillis) {
			Object value = cache.get(url);
			cache.remove(url);
			return value;
		}

		return cache.get(url);
	}

}
