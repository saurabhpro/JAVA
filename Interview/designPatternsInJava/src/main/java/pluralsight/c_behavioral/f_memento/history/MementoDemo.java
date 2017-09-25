/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.c_behavioral.f_memento.history;

public class MementoDemo {

	public static void main(String args[]) {

		Caretaker caretaker = new Caretaker();

		Employee emp = new Employee();

		emp.setName("John Wick");
		emp.setAddress("111 Main Street");
		emp.setPhone("888-555-1212");

		System.out.println("Employee before save:                     " + emp);

		caretaker.save(emp);

		emp.setPhone("444-555-6666");

		caretaker.save(emp);

		System.out.println("Employee after changed phone number save: " + emp);

		emp.setPhone("333-999-6666"); // <--- we haven't called save!

		caretaker.revert(emp);

		System.out.println("Reverts to last save point:               " + emp);

		caretaker.revert(emp);

		System.out.println("Reverted to original:                     " + emp);

	}
}
