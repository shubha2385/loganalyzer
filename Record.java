package com.nn.prt.loganalyzer.objectmodel;

/**
 * 
 * @author Shubhalaxmi Dali
 * @version 20052018
 */
public abstract class Record {

    private long startTime;
    private long endTime;

    public long getStartTime() {
	return startTime;
    }

    public void setStartTime(long startTime) {
	this.startTime = startTime;
    }

    public long getEndTime() {
	return endTime;
    }

    public void setEndTime(long endTime) {
	this.endTime = endTime;
    }

    public abstract void populate(String line);

}
