package com.nn.prt.loganalyzer;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import com.nn.prt.loganalyzer.helpers.LogAnalyzer;

/**
 * 
 * @author Shubhalaxmi Dali
 * @version 22052018
 */
public class MainApp {

    public static void main(String[] args) {
	Path currentDir = Paths.get("");

	IntStream.range(1, 7).forEach(index -> {
	    LogAnalyzer logAnalyzer = new LogAnalyzer();
	    String fileName = currentDir.toAbsolutePath() + "\\resources\\test_"+ index +".log";
	    logAnalyzer.loadLog(fileName);
	    System.out.println("Log Analysis of file " + fileName);
	    System.out.println("total requests = " + logAnalyzer.getRequestsCount());
	    System.out.println("total failed requests = " + logAnalyzer.getFailedRequestsCount());
	    System.out.println("average response time = " + logAnalyzer.getAvgResponseTime());
	    System.out.println("number of requests per end point = " + logAnalyzer.getRequestCountPerEndPoint());
	    System.out.println("=================================================================================");
	});

    }

}
