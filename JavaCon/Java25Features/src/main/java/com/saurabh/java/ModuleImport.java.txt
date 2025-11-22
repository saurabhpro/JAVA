package com.saurabh.java;

import static java.io.IO.*;
import module java.base;

class ModuleImport {
    void main() {
        final var authors = List.of("James", "Bill", "Guy", "Alex", "Dan", "Gavin");
        for (var name : authors) {
            println(name + ": " + name.length());
        }
    }
}