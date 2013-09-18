package com.jaxrs.cache;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.jaxrs.cache.config.CacheConfig;

public class CacheTest {

	@Before
	public void setup() {
		Map<String, Long> ttl = new HashMap<>();
		ttl.put("abc", 1000L);
		CacheConfig.configure(ttl);

		new Cache().put("abc", "123");
	}

	@Test
	public void getBeforeExpires() {
		Object object = new Cache().get("abc");
		Assert.assertNotNull(object);
	}

	@Test
	public void getAfterExpires() throws InterruptedException {
		Thread.sleep(1100L);
		Object object = new Cache().get("abc");
		Assert.assertNotNull(object);

		Thread.sleep(100L);
		object = new Cache().get("abc");
		Assert.assertNull(object);
	}

}
