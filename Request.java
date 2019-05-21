package com.nn.prt.loganalyzer.objectmodel;

import com.nn.prt.loganalyzer.constants.Status;

/**
 * 
 * @author Shubhalaxmi Dali
 * @version 20052018
 */
public final class Request extends Record {

    private static final String DELIM = "\\s+";

    private long id;
    private String name;
    private Status status;
    private String message;

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Status getStatus() {
	return status;
    }

    public void setStatus(Status status) {
	this.status = status;
    }

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

    @Override
    public void populate(String line) {
	String[] requestData = line.strip().split(DELIM);
	setId(Long.parseLong(requestData[1]));
	setName(requestData[2]);
	setStartTime(Long.parseLong(requestData[3]));
	setEndTime(Long.parseLong(requestData[4]));
	setStatus(Status.valueOf(requestData[5]));
	if (hasMessage(Status.valueOf(requestData[5]))) {
	    setMessage(requestData[6]);
	}
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (id ^ (id >>> 32));
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Request other = (Request) obj;
	if (id != other.id)
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Request [id=" + id + ", name=" + name + ", status=" + status + ", message=" + message + "]";
    }

    private boolean hasMessage(Status status) {
	return Status.KO.equals(status);
    }
}
