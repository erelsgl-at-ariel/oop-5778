package lesson4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class TestCSV {

	public static void main(String[] args) throws IOException {
		Reader in = new FileReader("test.csv");
		Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);
		for (CSVRecord record : records) {
		    String name = record.get("Name");
		    String phone = record.get("Phone");
		    System.out.println(name+" "+phone);
			
			int a = 6;
		}	
	}

}
