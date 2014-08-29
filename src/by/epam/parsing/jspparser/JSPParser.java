package by.epam.parsing.jspparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import by.epam.parsing.entity.Composite;
import by.epam.parsing.entity.Leaf;
import by.epam.parsing.entity.Component;

public class JSPParser {

	private static final Logger LOGGER = Logger.getLogger("JSPParser");

	private static ResourceBundle regexBundle = ResourceBundle
			.getBundle("RegexBundle");

	public Component doParsing(File file) throws FileNotFoundException {
		Component component = new Composite("page");
		LOGGER.debug("parsing begins");
		addPageTags(file, component);
		LOGGER.debug("parsing finishes");
		return component;
	}

	private void addPageTags(File file, Component page)
			throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			String currLine = scanner.nextLine();
			addScopeContent(currLine, page);

		}

		scanner.close();

	}

	private void addScopeContent(String currLine, Component component) {
		if (isDirective(currLine)) {
			String parentName = component.getTagName();
			component.addTag(new Leaf(currLine, parentName));
			LOGGER.debug("directive found");
		}
		if (isDoctype(currLine)) {
			String parentName = component.getTagName();
			component.addTag(new Leaf(currLine, parentName));
			LOGGER.debug("doctype found");
		}
		if (isSimpleSingleTag(currLine)) {
			String parentName = component.getTagName();
			component.addTag(new Leaf(currLine, parentName));
			LOGGER.debug("simple single tag found");
		}
		if (isSimpleTwinTag(currLine)) {
			String parentName = component.getTagName();
			component.addTag(new Leaf(currLine, parentName));
			LOGGER.debug("simple twin tag found");
		}
		if (isOpenTag(currLine)) {
			String parentName = component.getTagName();
			Component complexTag = new Composite(currLine, parentName);
			LOGGER.debug("open tag found");
			component.addTag(complexTag);
		}
		if (isScriplet(currLine)) {
			String parentName = component.getTagName();
			component.addTag(new Leaf(currLine, parentName));
			LOGGER.debug("scriplet found");
		}
	}

	private boolean isScriplet(String currLine) {
		String scripletRegex = regexBundle.getString("scripletRegex");
		Pattern scripletPattern = Pattern.compile(scripletRegex);
		Matcher matcher = scripletPattern.matcher(currLine);
		return matcher.matches();
	}

	private boolean isSimpleTwinTag(String currLine) {
		String twinRegex = regexBundle.getString("twinRegex");
		Pattern twinPattern = Pattern.compile(twinRegex);
		Matcher matcher = twinPattern.matcher(currLine);
		return matcher.matches();
	}

	private boolean isOpenTag(String currLine) {
		String openRegex = regexBundle.getString("openRegex");
		Pattern openPattern = Pattern.compile(openRegex);
		Matcher matcher = openPattern.matcher(currLine);
		return matcher.matches();
	}

	private boolean isSimpleSingleTag(String currLine) {
		String simpleSingleRegex = regexBundle.getString("simpleSingleRegex");
		Pattern simpleSinglePattern = Pattern.compile(simpleSingleRegex);
		Matcher matcher = simpleSinglePattern.matcher(currLine);
		return matcher.matches();
	}

	private boolean isDoctype(String currLine) {
		String doctypeRegex = regexBundle.getString("doctypeRegex");
		Pattern doctypePattern = Pattern.compile(doctypeRegex);
		Matcher matcher = doctypePattern.matcher(currLine);
		return matcher.matches();
	}

	private boolean isDirective(String currLine) {
		String directiveRegex = regexBundle.getString("directiveRegex");
		Pattern directivePattern = Pattern.compile(directiveRegex);
		Matcher matcher = directivePattern.matcher(currLine);
		return matcher.matches();
	}

}
