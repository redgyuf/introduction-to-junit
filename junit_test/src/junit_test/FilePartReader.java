package junit_test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
		String content = null;
		File file = new File(filePath); // for ex foo.txt
		FileReader reader = null;
		try {
			reader = new FileReader(file);
			char[] chars = new char[(int) file.length()];
			reader.read(chars);
			content = new String(chars);
			reader.close();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		return content;
	}
	
	

}
