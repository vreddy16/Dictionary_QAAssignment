package com.test.utilities;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
	public static boolean isEnglishWord(Map<Character, Integer> inputLettersCountMap, String currentWord) {
		//getting the character count of each char in the current word of dictionary
		Map<Character, Integer> dictionaryWordCount = getCharacterCount(currentWord);
		boolean wordFound = true;
		//iterating through each character of current dictionary word
		for(Character chr : dictionaryWordCount.keySet()) {
			int currentDictWordCharCount = dictionaryWordCount.get(chr);
			//validating if the current char of dictionary word is available in letters entered by user
			int inputLetterCharCount = inputLettersCountMap.containsKey(chr)?inputLettersCountMap.get(chr):0;
			if(currentDictWordCharCount>inputLetterCharCount) {
				wordFound = false;
				break;
			}
		}
		return wordFound;
	}

	public static Map<Character, Integer> getCharacterCount(String letters) {
		Map<Character, Integer> letterCountMap = new HashMap<Character,Integer>();
		
		for(int i = 0;i<letters.length();i++) {
			char currentChar = letters.charAt(i);
			int count = letterCountMap.containsKey(currentChar)? letterCountMap.get(currentChar):0;
			count = count +1;
			letterCountMap.put(currentChar, count);
		}
		
		return letterCountMap;
	}
	
	public static List<String> getAllWords(String letters) throws FileNotFoundException, IOException {
		List<String> collectionOfWords = new ArrayList<String>();
		//getting the count of each character in the letters entered by user
		Map<Character, Integer> inputLettersCountMap = getCharacterCount(letters);
		//read the dictionary file
		BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\dictionary.txt"));
		//iterate through each word
		for(String currentWord = reader.readLine();currentWord!=null;currentWord= reader.readLine()) {
			if(isEnglishWord(inputLettersCountMap, currentWord)) {
				collectionOfWords.add(currentWord);
			}
		}
		return collectionOfWords;
	}
}
