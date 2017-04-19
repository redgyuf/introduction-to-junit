package junit_test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class JunitTester {
	@Rule
	public final ExpectedException exException = ExpectedException.none();	
	
	
	
	@Test
	public void testFilePartReaderConstructor(){
		exException.expect(IllegalArgumentException.class);
		FilePartReader fpr = new FilePartReader("src/junit_test/daninak.txt", 0, 1);		
	}
	
	@Test
	public void testReadLines() throws IOException{
		FilePartReader fpr = new FilePartReader("src/junit_test/daninak.txt", 1, 1);
		String result = fpr.readLines();
		
		assertEquals("DANI EGYY BUZI2 ", result);
	}
	
	@Test
	public void testWordsByABC() throws IOException{
		class MockedReader extends FilePartReader{

			public MockedReader(String filePath, Integer fromLine, Integer toLine) {
				super(filePath, fromLine, toLine);
			}

			@Override
			public String readLines() throws IOException {
				return "mockoltam a mockolandot";
			}			
		}
		FileWordAnalyzer fwa = new FileWordAnalyzer(new MockedReader("bliblu", 1, 2));
		ArrayList result = fwa.wordsByABC();	
		ArrayList goodResult = new ArrayList (Arrays.asList("a", "mockolandot", "mockoltam"));
		assertEquals(goodResult, result);
	}
	
	@Test
	public void testwordsContainingSubString() throws IOException{
		class MockedReader extends FilePartReader{

			public MockedReader(String filePath, Integer fromLine, Integer toLine) {
				super(filePath, fromLine, toLine);
			}

			@Override
			public String readLines() throws IOException {
				return "mockoltam a mockolandoté";
			}			
		}
		FileWordAnalyzer fwa = new FileWordAnalyzer(new MockedReader("bliblu", 1, 2));
		ArrayList result = fwa.wordsContainingSubString("é");	
		ArrayList goodResult = new ArrayList (Arrays.asList("mockolandoté"));
		assertEquals(goodResult, result);
	}
}
