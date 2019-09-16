package com.ace.SpringHibernetJPADemo.ServiceValidation;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import com.ace.SpringHibernetJPADemo.exceptionHandler.CustomerExceptionHandler;
import com.ace.SpringHibernetJPADemo.request.CustomerRequest;
import com.google.gson.Gson;

import ch.qos.logback.classic.Logger;

public class LogRequestResponse {
	private static final Logger logger =  (Logger) LoggerFactory.getLogger(LogRequestResponse.class);
	public void logRequest(Object object, HttpServletRequest request) {
logger.info("*******************request******************************************");
logger.info("------------------------------------------------------------------------");
logger.info(request.getMethod() + "........." + request.getRequestURI());
logger.info("-------------------------------------------------------------------------");
		if (!(object == null)) {
			Gson gson = new Gson();
			String RequestAsjson = gson.toJson(object);
			char[] chararray = RequestAsjson.toCharArray();
		
			StringBuilder s = new StringBuilder();
			int count=0;
			s = s.append(" ");
			for (char c : chararray ) {
				count = count+1;
				s = s.append(c);
				if (c == ',' || count==chararray.length) {
					logger.info(new String(s));
					s = new StringBuilder();
					s = s.append(" ");

				}

			}

			/*
			 * List<String> list=Arrays.asList(RequestAsjson.split(",")); for (String string
			 * : list) { System.out.println(string );
			 */

		}
		logger.info("*******************request******************************************");
	}

	public void logResponse(ResponseEntity<Object> response) {
		logger.info("*******************responsse******************************************");
		
		if (!(response == null)) {
			Gson gson = new Gson();
			String ResponseAsjson = gson.toJson(response.getBody());
			char[] chararray = ResponseAsjson.toCharArray();

			StringBuilder s = new StringBuilder();
			int count=0;
			s = s.append(" ");
			for (char c : chararray ) {
				count = count+1;
				s = s.append(c);
				if (c == ',' || count==chararray.length) {
					logger.info(new String(s));
					s = new StringBuilder();
					s = s.append(" ");

				}
				/*
				 * List<String> list = Arrays.asList(ResponseAsjson.split(",")); for (String
				 * string : list) { System.out.println(string + " ,");
				 */
			}
		}
		logger.info("*******************responsse******************************************");
	}

}
