package com.jora.masterservice.common;

public class ErrorHandler {

	public static String errorTraceForLogger(Exception e) {
		StringBuilder sb = new StringBuilder();
		sb.append(e.getMessage());
		for (StackTraceElement element : e.getStackTrace()) {
			String className = element.getClassName();
			if (className.startsWith("com.jora")) {
				sb.append("\n");
				sb.append(String.format("at %s.%s(%s: %s)", element.getClassName(), element.getMethodName(),
						element.getFileName(), element.getLineNumber()));
			}
		}
		return sb.toString();
	}
}
