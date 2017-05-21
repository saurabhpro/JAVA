package com.saurabh.atm.util.generator;

/**
 * Created by saurabhkumar on 14/05/17.
 */
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseCredentials;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;


public class FirebaseUtil {

	public void init(){
		FileInputStream serviceAccount = null;
		try {
			serviceAccount = new FileInputStream("/Users/saurabhkumar/GitHub/JAVA/ATM/src/main/resources/atmjava-firebase-admin.json");

			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
					.setDatabaseUrl("https://atmjava.firebaseio.com/")
					.build();

			//System.out.println(options.getDatabaseAuthVariableOverride().entrySet());
			FirebaseApp.initializeApp(options);
			//System.out.println(Firebase);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


	}
	/*
	public static void writeToList(String url, Map<String, Object> map) {
		long num = RandomNumberGenerator.generate();
		Firebase listRef = new Firebase(url + "/data/");
		map.put("_id", num);
		Firebase push = listRef.child("" + num);
		push.setValue(map);
	}*/
}