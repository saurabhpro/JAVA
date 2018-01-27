package excep;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

class ScanInt4 {
	public static void main(String[] args) {
		//String integerStr = "";
		String integerStr = "Tro";
		//String integerStr = "99"; // ok
		System.out.println("The string to scan integer from it is: " + integerStr);
		Scanner consoleScanner = new Scanner(integerStr);
		try {
			System.out.println("The integer value scanned from string is: " + consoleScanner.nextInt());
		} catch (InputMismatchException ime) {
			// "Tro"
			System.out.println("Error: Cannot scan an integer from the given string");
		} catch (NoSuchElementException nsee) {
			// ""
			System.out.println("Error: Cannot scan an integer from the given string \"\" (empty)");
		} catch (IllegalStateException ise) {
			System.out.println("Error: nextInt() called on a closed Scanner object");
		} finally {
			System.out.println("Done reading the integer... closing the Scanner");
			consoleScanner.close();
		}

		// in a multi-catch block, you cannot combine catch handlers for two exceptions that share
		// a base- and derived-class relationship. You can only combine catch handlers for exceptions
		// that do not share the parent-child relationship between them.

		//The answer is that if a class implements java.io.Closeable,
		// then you must call the close() method of that class; otherwise, it will result in a resource leak.

		// auto-closable
		try (Scanner consoleScanner0 = new Scanner(integerStr)) {
			System.out.println("The integer value scanned from string is: " + consoleScanner0.nextInt());
		} finally {
			System.out.println("Done reading the integer... closing the Scanner");
		}

		// without finally or catch
		try (Scanner consoleScanner0 = new Scanner(integerStr)) {
			System.out.println("The integer value scanned from string is: " + consoleScanner0.nextInt());
		}

		// buffer is the temporary byte buffer used for copying data from one stream to another stream
		byte[] buffer = new byte[1024];
		// these stream constructors can throw FileNotFoundException
		try (
				ZipOutputStream zipFile = new ZipOutputStream(new FileOutputStream(""));
				FileInputStream fileIn = new FileInputStream("")
		) {
			zipFile.putNextEntry(new ZipEntry(""));         // putNextEntry can throw IOException
			int lenRead = 0; // the variable to keep track of number of bytes sucessfully read copy the contents of the input file into the zip file
			while ((lenRead = fileIn.read(buffer)) > 0) {        // read can throw IOException
				zipFile.write(buffer, 0, lenRead);              // write can throw IOException
			}
			// the streams will be closed automatically because they are within try-with-resources statement
		} catch (IOException e) {
			e.printStackTrace();
		}

		// ou cannot assign to the resource variables declared in the try-with-resources
		// within the body of the try-with-resources statement.


	}
}