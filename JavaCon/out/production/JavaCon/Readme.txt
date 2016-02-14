>javac PFile1.java
>java PFile1
Trying to run PFile1.class is error saying class not found as herarchy searching is done.
First sees pakacge statement, which says p1...it'll look for p1 director and then the class file

to automatically create p1 folder
> javac -d . PFile1.java		//creates new folder names p1 and moves .class file in it
> java p1.PFile				//run with package name p1._class_name