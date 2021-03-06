/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package list.arraylist;

import list.arraylist.model.Emp2;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Saurabh on 9/6/2015.
 */
public class Serialization {

	static void withString() {
		ArrayList<String> al = new ArrayList<>();
		al.add("Hello");
		al.add("Hi");
		al.add("Random");

		try (FileOutputStream fos = new FileOutputStream("myfile"); //FileNotFoundException
		     ObjectOutputStream oos = new ObjectOutputStream(fos))  //IOException (General)
		{
			oos.writeObject(al);
			/*
			since try with resources block has AutoClosable Implemented classes, these line are not needed
            oos.close();
            fos.close();
            */

			System.out.println("after deserialization");

			FileInputStream fin = new FileInputStream("myfile");
			ObjectInputStream oin = new ObjectInputStream(fin);
			ArrayList<String> al2 = (ArrayList<String>) oin.readObject();        //ClassNotFoundException

			fin.close();
			oin.close();        //not in try-with resources
			/*
	        Iterator<String> i = al2.iterator();
            while (i.hasNext()) {
                String z = i.next();
                System.out.println(z);
            }
             */
			for (String z : al2) {
				System.out.println(z);
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void withOwnClass() {
		ArrayList<Emp2> al = new ArrayList<>();

		al.add(new Emp2(10));
		al.add(new Emp2(20));
		al.add(new Emp2(30));

		try (FileOutputStream fos = new FileOutputStream("myfile"); //FileNotFoundException
		     ObjectOutputStream oos = new ObjectOutputStream(fos))  //IOException (General)
		{
	        /*
	        If java.list.arraylist.deadlock.Emp2 does not implement Serualization = NotSerializableException (subclass of IOException) occurs
            */
			oos.writeObject(al);
	        /*
            since try with resources block has AutoClosable Implemented classes, these line are not needed
            oos.close();
            fos.close();
            */

			System.out.println("after deserialization");

			FileInputStream fin = new FileInputStream("myfile");
			ObjectInputStream oin = new ObjectInputStream(fin);
			ArrayList al2 = (ArrayList) oin.readObject();        //ClassNotFoundException

			fin.close();
			oin.close();        //not in try-with resources
	        /*
	        Iterator<java.list.arraylist.deadlock.Emp2> i = al2.iterator();
            while (i.hasNext()) {
                java.list.arraylist.deadlock.Emp2 z = i.next();
                System.out.println(z.x);
            }
             */
			for (Emp2 z : (Iterable<Emp2>) al2) {
				System.out.println(z.x);
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//  withString();
		withOwnClass();
	}
}
