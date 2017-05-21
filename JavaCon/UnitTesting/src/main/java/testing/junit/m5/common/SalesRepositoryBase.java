package testing.junit.m5.common;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public interface SalesRepositoryBase {
	List<Sale> loadSales();

	default int parseInt(String value) {
		return Integer.parseInt(value.trim());
	}

	void setError(PrintStream error);

	default List<Sale> loadSales(List<Sale> sales, final String fileLocation, PrintStream error) {
		if (sales == null) {
			sales = new ArrayList<>();
			try (CSVReader reader = new CSVReader(new FileReader(fileLocation))) {
				String[] nextLine;
				while ((nextLine = reader.readNext()) != null) {
					String product = nextLine[0].trim();
					String store = nextLine[1].trim();
					int number = parseInt(nextLine[2]);
					int pricePerItem = parseInt(nextLine[3]);
					sales.add(new Sale(product, store, number, pricePerItem));
				}
				return sales;
			} catch (IOException e) {
				e.printStackTrace(error);
				return null;
			}
		}
		return sales;
	}

}
