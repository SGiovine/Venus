package it.objectmethod.srlgroupjob.controller.bean;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import org.hibernate.annotations.Entity;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.JsonNode;

public class LoginError{

	private String error;

	public String toString() {
		return "LoginError [isThereErr = "+error+"]";
	}
	
	public String getError() {
	
		return error;
	}

	public void setError(String error) {
		
		this.error = error;
	}


}
