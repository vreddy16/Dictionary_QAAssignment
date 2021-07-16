package com.test.scripts;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.test.utilities.Dictionary;

public class fetchWords {
	/*
	 * We can write the below method as main method and run the main method directly from here and get result
	 * or use maven command mvn exec:java -Dexec.mainClass="main class"
	 */
	@Test
	public void FindAllDictWords() throws FileNotFoundException, IOException {
		//my dictionary has all words in upper case so changing the input to upper case
		String inpWord = System.getProperty("InputWord")!=null?System.getProperty("InputWord"):Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("InputWord");
		System.out.println("The input word is>>>"+inpWord);
		Dictionary dict = new Dictionary();
		System.out.println("Below are all the possible dictionaly words for "+dict.getAllWords(inpWord.toUpperCase()));
	}
	
}
