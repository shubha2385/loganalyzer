package com.nn.prt.loganalyzer.helpers;

import com.nn.prt.loganalyzer.constants.LogRecordType;
import com.nn.prt.loganalyzer.constants.Status;
import com.nn.prt.loganalyzer.objectmodel.Request;

/**
 * 
 * @author Shubhalaxmi Dali
 * @version 20052018
 */
public class LogParser {

    public static Request parseEntry(String line) {
	if (isRequest(line)) {
	    return ParserFactory.INSTANCE.getParser(line).parse(line);
	}
	return null;
    }

    public static boolean isRequest(String line) {
	if (isBlank(line)) {
	    return false;
	}
	return line.trim().indexOf(LogRecordType.REQUEST.name()) == 0;
    }

    private static boolean isBlank(String line) {
	return line == null || line.trim().isEmpty();
    }

    public static boolean isFailed(Request request) {
	return Status.KO.equals(request.getStatus());
    }

}
