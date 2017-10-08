package com.saurabh.service.filereader;

import com.saurabh.api.excel.read.FileOperations;
import com.saurabh.service.filereader.biometricdetails.BiometricFileToObject;
import com.saurabh.service.filereader.salesforce.SalesforceFileToObject;
import org.springframework.stereotype.Component;

/**
 * Created by Saurabh on 3/3/2016.
 */
@Component
public class SheetFactory {
	public FileOperations dispatch(String type) {

		switch (type) {
			case "Jxcel":
				return new BiometricFileToObject();
			case "XLS":
				// return new ApacheBiometricFileWorker(file);
				System.out.println("Not yet supported XLS by apache");
				break;
			case "XLSX":
				return new SalesforceFileToObject();
		}
		return null;
	}

}
