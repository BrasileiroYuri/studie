package com.belezanaweb.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;

@Getter
@JsonInclude(Include.NON_NULL)
@Builder
public class ProblemDetails {

	private Integer status;
	private String type;
	private String title;
	private String detail;

	private OffsetDateTime timeStamp;
	List<Object> objects;

	@Getter
	@Builder
	public static class Object {

		private String name;
		private String userMessage;

	}

}
