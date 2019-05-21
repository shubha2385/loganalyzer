package com.nn.prt.loganalyzer.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.nn.prt.loganalyzer.objectmodel.Request;

/**
 * 
 * @author Shubhalaxmi Dali
 * @version 21052018
 */
public class LogAnalyzer {

    private ArrayList<Request> records;

    public LogAnalyzer() {
	records = new ArrayList<>();
    }

    public void loadLog(String file) {
	try (FileInputStream inputStream = new FileInputStream(file); Scanner sc = new Scanner(inputStream, "UTF-8")) {

	    while (sc.hasNextLine()) {
		String line = sc.nextLine();
		if (LogParser.isRequest(line))
		    records.add(LogParser.parseEntry(line));
	    }

	} catch (IOException e) {
	    System.err.println(e);
	}

    }

    public int getRequestsCount() {
	return records != null ? records.size() : 0;
    }

    public long getFailedRequestsCount() {
	if (hasNoRecords()) {
	    return 0;
	} else {
	    return records.stream().filter(LogParser::isFailed).count();
	}
    }

    public long getAvgResponseTime() {
	if (hasNoRecords()) {
	    return 0;
	} else {
	    return Math.round(records.stream().mapToLong(record -> record.getEndTime() - record.getStartTime())
		    .average().orElse(0));
	}
    }

    public Map<String, Long> getRequestCountPerEndPoint() {
	if (hasNoRecords()) {
	    return new HashMap<>();
	} else {
	    return records.stream().collect(Collectors.groupingBy(Request::getName, Collectors.counting()));
	}
    }

    private boolean hasNoRecords() {
	return records == null || records.isEmpty();
    }

}
