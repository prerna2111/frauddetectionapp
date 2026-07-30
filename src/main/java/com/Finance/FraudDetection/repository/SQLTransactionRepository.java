package com.Finance.FraudDetection.repository;

import com.Finance.FraudDetection.model.transaction;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

@Repository
@Profile("JDBC")
public class SQLTransactionRepository implements ITransactionRepository{
    private JdbcTemplate jdbcTemplate;
    private RowMapper<transaction> rowMapper=(rs,rowNum)->new transaction(
            rs.getInt("id"),
            rs.getBigDecimal("amount"),
            rs.getString("txn_country"),
            rs.getTimestamp("txn_timestamp").toLocalDateTime(),
            rs.getString("status"),
            rs.getInt("customer_id"));

    public SQLTransactionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<transaction> findAll() {
        return jdbcTemplate.query("SELECT * FROM transactions ORDER BY txn_timestamp DESC",rowMapper);
    }

    @Override
    public transaction findByID(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM transactions WHERE id = ?",rowMapper,id);
    }

    @Override
    public int save(transaction t) {
        KeyHolder keyholder = new GeneratedKeyHolder();
        String sql = "INSERT INTO transactions (amount,txn_country,txn_timestamp,status,customer_id)"+"VALUES(?,?,?,?,?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setBigDecimal(1,t.getAmount());
            ps.setString(2, t.getTxnCountry());
            ps.setTimestamp(3, Timestamp.valueOf(t.getTxnTimestamp()));
            ps.setString(4,t.getStatus());
            ps.setInt(5,t.getCustomer_id());
            return ps;
        },keyholder);
        return keyholder.getKey().intValue();
    }

    @Override
    public void updateflag(int id, String flag) {
        jdbcTemplate.update("UPDATE transactions SET status = ? WHERE id = ?",flag,id);
    }
}
