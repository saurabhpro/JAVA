package com.jetbrains.testcontainersdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class CustomerDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static Customer mapRowToCustomer(ResultSet rs, int rowNum) throws SQLException {
        return new Customer(rs.getLong("id"),
                rs.getString("first_name"),
                rs.getString("last_name"));
    }

    public List<Customer> findAll() {
        return jdbcTemplate.query(
                "SELECT id, first_name, last_name FROM customers",
                CustomerDao::mapRowToCustomer
        );
    }
}
