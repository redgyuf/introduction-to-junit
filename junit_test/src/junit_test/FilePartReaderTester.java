package junit_test;

import java.io.IOException;

public class FilePartReaderTester {

	public static void main(String[] args) throws IOException {
		FilePartReader fpr = new FilePartReader("src/junit_test/daninak.txt", 1, 4);
		fpr.readLines();

	}

}
