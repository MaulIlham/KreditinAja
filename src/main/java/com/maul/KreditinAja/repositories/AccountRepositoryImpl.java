package com.maul.KreditinAja.repositories;

import com.maul.KreditinAja.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class AccountRepositoryImpl implements AccountRepository{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Account findByUsername(String username) {
        String query = "SELECT * from account where username = ?";
        RowMapper<Account> accountRowMapper = new BeanPropertyRowMapper<Account>(Account.class);
        Account account = jdbcTemplate.queryForObject(query, accountRowMapper, username);
        return account;
    }

    @Override
    public List<Account> findAll() {
        String query = "SELECT * from account";
        RowMapper<Account> accountRowMapper = new AccountRowMapper();
        List<Account> accounts = jdbcTemplate.query(query, accountRowMapper);
        return accounts;
    }

    @Override
    public Account findById(String id) {
        String query = "SELECT * from account where id = ?";
        RowMapper<Account> accountRowMapper = new BeanPropertyRowMapper<Account>(Account.class);
        Account account = jdbcTemplate.queryForObject(query, accountRowMapper, id);
        return account;
    }

    @Override
    public void save(Account data) {
        String query = "INSERT INTO account(id,username,email,password) VALUES(?,?,?,?)";
        jdbcTemplate.update(query, data.getId(), data.getUsername(), data.getEmail(), data.getPassword());
    }

    @Override
    public void update(Account data) {
        String query = "UPDATE account set username = ?, email = ?, password = ? where id = ?";
        jdbcTemplate.update(query,data.getUsername(),data.getEmail(),data.getPassword(),data.getId());
    }

    @Override
    public void deleteById(String id) {
        String query = "DELETE FROM account where id = ?";
        jdbcTemplate.update(query, id);
    }

    @Override
    public void deleteAll() {
        String query = "TRUNCATE TABLE account";
        jdbcTemplate.update(query);
    }
}
