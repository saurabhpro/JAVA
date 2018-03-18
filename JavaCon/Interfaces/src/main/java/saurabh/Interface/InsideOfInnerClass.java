/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package saurabh.Interface;

class InsideOfInnerClass {

	public interface InterfaceInsideOfInnerClass {
		void show();
	}

	private class InnerClass {
//		public interface InterfaceInsideOfInnerClass {
//			void show();
//		}

		// this is not allowed since
	}
}
