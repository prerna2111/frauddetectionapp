package com.Finance.FraudDetection.repository;

import com.Finance.FraudDetection.model.customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {
    //private List<customer> customers = new ArrayList<>();
    private JdbcTemplate jdbcTemplate;
    private RowMapper<customer> rowMapper=(rs, rowNum)->new customer(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("accountNumber"),
            rs.getString("registeredCountry")
    );

    public CustomerRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public List<customer> getCustomers() {
        return jdbcTemplate.query("SELECT * FROM customers",rowMapper);
    }


    public customer getCustomerByID(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM customers WHERE id = ?",rowMapper,id);
    }
}
