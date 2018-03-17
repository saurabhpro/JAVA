/*
 * Copyright 2017 Saurabh Kumar 29/10/17 8:45 PM
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

public class TheObjectInheritanceConundrum {
	/*
	 * In Java, all classes inherit from the Object class directly or indirectly.
	 * Therefore, there is always a single inheritance tree of classes in Java,
	 * and Object class is root of the tree.
	 *
	 * In Java, if we create a class that doesn’t inherit from any class then it automatically inherits from Object class .
	 */
}


class MyLifeMyChoices extends TheObjectInheritanceConundrum {
	/*
	 * You would think this class extends two classes Object + TheObjectInheritanceConundrum
	 * But no!
	 *
	 * As written above this is an example of classic INDIRECT inheritance to Object inheritance
	 *
	 * So for MyLifeMyChoice its only extending TheObjectInheritanceConundrum which does the Object thingy
	 */
}