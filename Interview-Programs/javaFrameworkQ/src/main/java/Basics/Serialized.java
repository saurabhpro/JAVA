package Basics;

import java.io.Serializable;

public class Serialized implements Serializable {

    static int y = 44;      //Static Variables are not part of the object. They are not serialized.
    transient int i = 9;    // not serialized


    Serialized() {
        // not called on de-serialization
    }
}