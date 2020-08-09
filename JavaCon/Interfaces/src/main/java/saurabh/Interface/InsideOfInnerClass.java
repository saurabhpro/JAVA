/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package saurabh.Interface;

class InsideOfInnerClass {

    public interface InterfaceInsideOfInnerClass {
        void show();
    }

    private class InnerClass {
//        public interface InterfaceInsideOfInnerClass {
//            void show();
//        }
    }
    // this is not allowed since its an instance class,
	// the below one works as they are static
    protected static class InnerClassStatic {
        public interface InterfaceInsideOfInnerClass {
            void show();
        }
    }

}
