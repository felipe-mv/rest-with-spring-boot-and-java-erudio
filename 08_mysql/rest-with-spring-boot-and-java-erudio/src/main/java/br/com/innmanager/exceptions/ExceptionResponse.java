package br.com.innmanager.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date timeStamp;
	private String menssage;
	private String details;
	
	public ExceptionResponse(Date timeStamp, String menssage, String details) {		
		this.timeStamp = timeStamp;
		this.menssage = menssage;
		this.details = details;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public String getMenssage() {
		return menssage;
	}

	public String getDetails() {
		return details;
	}
	
	
}
