package com.nn.prt.loganalyzer.helpers;

import com.nn.prt.loganalyzer.objectmodel.Request;

public enum ParserFactory {
    INSTANCE;

    private ParserFactory() {

    }

    Parser<String, Request> getParser(String line) {
	if (LogParser.isRequest(line)) {
	    return loggerLine -> {
		Request request = new Request();
		request.populate(loggerLine);
		return request;
	    };
	} else {
	    return null;
	}
    }

}
