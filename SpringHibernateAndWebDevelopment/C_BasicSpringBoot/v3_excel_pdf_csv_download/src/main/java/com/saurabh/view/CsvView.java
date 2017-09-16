package com.saurabh.view;

import com.saurabh.model.User;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class CsvView extends AbstractCsvView {


	@Override
	protected void buildCsvDocument(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.setHeader("Content-Disposition", "attachment; filename=\"my-csv-file.csv\"");

		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) model.get("users");

		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

		String[] header = {"Firstname", "LastName", "LastName", "JobTitle", "Company", "Address", "City", "Country", "PhoneNumber"};

		csvWriter.writeHeader(header);

		for (User user : users) {
			csvWriter.write(user, header);
		}

		csvWriter.close();

	}
}