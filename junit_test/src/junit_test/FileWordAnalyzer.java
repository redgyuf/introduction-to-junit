package junit_test;

import java.io.IOException;
import java.util.ArrayList;

public class FileWordAnalyzer {
	FilePartReader fpr = null;

	public FileWordAnalyzer(FilePartReader fpr) {
		super();
		this.fpr = fpr;
	}

	public ArrayList wordsByABC() throws IOException {
		String input = fpr.readLines();
		ArrayList<String> orderedLines = new ArrayList();
		for (String word : input.split(" ")) {
			orderedLines.add(word);
		}
		orderedLines.sort(String::compareToIgnoreCase);
		return orderedLines;
	}

	public ArrayList wordsContainingSubString(String subString) throws IOException {
		String input = fpr.readLines();
		ArrayList<String> containedWords = new ArrayList();
		for (String word : input.split(" ")) {
			if (word.toLowerCase().contains(subString)) {
				containedWords.add(word);
			}
		}
		return containedWords;
	}

}
