package com.saksoft.crud.model;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class GenericErrorResponse {

	private String errorMessage;
	private String errorCode;
	private LocalDateTime dateTime;
	
}
