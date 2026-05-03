package com.saurabh.java;

import module java.base;

import static java.lang.IO.println;

class ModuleImport {

    void main() {
        final var authors = List.of("James", "Bill", "Guy", "Alex", "Dan", "Gavin");
        for (var name : authors) {
            println(name + ": " + name.length());
        }
    }
}