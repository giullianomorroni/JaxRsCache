package com.jaxrs.cache.filter;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.jaxrs.cache.Cache;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import com.sun.jersey.spi.container.ResourceFilter;


public class CacheFilter implements ResourceFilter, ContainerRequestFilter, ContainerResponseFilter {

	private static Cache cache = new Cache();

	@Override
	public ContainerRequest filter(ContainerRequest request) {
		Object object = cache.get(request.getRequestUri().toString());
		if (object != null){
			ResponseBuilder builder = Response.status(Response.Status.ACCEPTED).entity(object);
	        throw new WebApplicationException(builder.build());			
		}
		return request;
	}

	@Override
	public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {
		Object object = cache.get(request.getRequestUri().toString());
		if (object != null){
			response.setEntity(object);
		}
		return response;
	}

	@Override
	public ContainerRequestFilter getRequestFilter() {
		return this;
	}

	@Override
	public ContainerResponseFilter getResponseFilter() {
		return this;
	}

}
