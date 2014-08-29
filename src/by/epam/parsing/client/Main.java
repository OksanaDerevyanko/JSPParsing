package by.epam.parsing.client;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ResourceBundle;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import by.epam.parsing.jspparser.JSPParser;

public class Main {

	private static ResourceBundle URLBundle = ResourceBundle
			.getBundle("URLBundle");

	static {
		new DOMConfigurator().doConfigure(URLBundle.getString("xmlURL"),
				LogManager.getLoggerRepository());
	}
	private static final Logger LOGGER = Logger.getLogger(Main.class);

	public static void main(String[] args) {

		JSPParser jspParser = new JSPParser();
		File jsp = new File(URLBundle.getString("jspURL"));

		try {
			jspParser.doParsing(jsp);
		} catch (FileNotFoundException e) {
			LOGGER.error("file not found: ", e);
		}

	}
}
