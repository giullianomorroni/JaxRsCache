package com.jaxrs.cache.response;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.jaxrs.cache.json.JsonConversor;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class HttpResponse implements Serializable {

	private static final long serialVersionUID = 1934905362923238485L;

	@XmlElement
	private String message;

	@XmlElement
	private String json;

	public HttpResponse() {
		super();
	}

	public HttpResponse(String message, Object object) {
		super();
		this.message = message;
		this.json = JsonConversor.json(object);
	}

	public HttpResponse(Object object) {
		this("ok", object);
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	@Override
	public String toString() {
		return "HttpResponse [message=" + message + ", json=" + json + "]";
	}

}
