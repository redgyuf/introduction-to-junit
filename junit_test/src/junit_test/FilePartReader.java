package junit_test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.SynchronousQueue;

public class FilePartReader {

	private String filePath;
	private Integer fromLine;
	private Integer toLine;

	public FilePartReader(String filePath, Integer fromLine, Integer toLine) {
		this.filePath = filePath;
		if (toLine < fromLine || fromLine < 1)
			throw new IllegalArgumentException();
		this.fromLine = fromLine;
		this.toLine = toLine;
	}

	private String read() throws IOException {
		return new String(Files.readAllBytes(Paths.get(filePath)));
	}

	public String readLines() throws IOException {
		String result = "";
		String input = read();
		String[] inputLines = input.split("\n");

		for (int i = 0; i < inputLines.length; i++) {
			if (i >= fromLine && i <= toLine) {
				result += inputLines[i].trim() + " ";
			}
		}
		return result;

	}

}
