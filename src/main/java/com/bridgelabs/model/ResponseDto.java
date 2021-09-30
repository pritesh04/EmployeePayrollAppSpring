package com.bridgelabs.model;

import lombok.Data;

@Data
public class ResponseDto {
String message;
private Object data;

public ResponseDto(String message, Object data) {
	super();
	this.message = message;
	this.data = data;
}


}
