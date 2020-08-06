package com.saurabh.student;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {
    @DisplayName("Grades to show for - lower the better")
    @Test
    void result() {
        Student student = new Student();
        assertEquals(4, student.result(50, 50, 50, 50, 50));
    }
}