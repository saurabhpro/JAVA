/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package com.saurabh.special.model;

import java.util.List;

public record StudentDetails(int id,
                             String name,
                             String department,
                             List<String> favoriteSports) {
    public static class Builder {
        private int id;
        private String name;
        private String department;
        private List<String> favoriteSports;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDepartment(String department) {
            this.department = department;
            return this;
        }

        public Builder setFavoriteSports(List<String> favoriteSports) {
            this.favoriteSports = favoriteSports;
            return this;
        }

        public StudentDetails build() {
            return new StudentDetails(id, name, department, favoriteSports);
        }
    }
}