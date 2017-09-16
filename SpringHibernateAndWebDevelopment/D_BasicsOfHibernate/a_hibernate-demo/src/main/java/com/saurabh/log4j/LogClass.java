package com.saurabh.log4j;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Created by saurabhkumar on 08/04/17.
 */
public class LogClass {
	private static Logger log = Logger.getLogger(LogClass.class);

	public static void main(String[] args) {
		log.setLevel(Level.WARN);
		log();

		log.setLevel(Level.DEBUG);
		log();

		log.setLevel(Level.ERROR);
		log();

		log.setLevel(Level.FATAL);
		log();

		log.setLevel(Level.TRACE);
		log();

		log.setLevel(Level.ALL);
		log();

	}

	private static void log(){
		System.out.println("\n\n/**"+log.getEffectiveLevel()+"**/");
		log.trace("Trace Message!");
		log.debug("Debug Message!");
		log.info("Info Message!");
		log.warn("Warn Message!");
		log.error("Error Message!");
		log.fatal("Fatal Message!");

	}
}
