package com.maul.KreditinAja.repositories;

import com.maul.KreditinAja.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class TransactionRepositoryImpl implements TransactionRepository{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Transaction> findAll() {
        String query = "SELECT * from transaction";
        RowMapper<Transaction> transactionRowMapper = new TransactionRowMapper();
        List<Transaction> transactions = jdbcTemplate.query(query, transactionRowMapper);
        return transactions;
    }

    @Override
    public Transaction findById(String id) {
        String query = "SELECT * from transaction where id = ?";
        RowMapper<Transaction> transactionRowMapper = new BeanPropertyRowMapper<Transaction>(Transaction.class);
        Transaction transaction = jdbcTemplate.queryForObject(query, transactionRowMapper, id);
        return transaction;
    }

    @Override
    public void save(Transaction data) {
        String query = "INSERT INTO transaction(id,property_id,account_id,mortgage_payments,loan_amount,down_payment,date_transaction,type_kpr) VALUES(?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(query,data.getId(),data.getPropertyId(),data.getAccountId(),data.getMortgagePayments(),data.getLoanAmount(),data.getDownPayment(),data.getDateTransaction(),data.getTypeKpr());
    }

    @Override
    public void update(Transaction data) {
        String query = "UPDATE transaction SET property_id = ?,account_id = ?,mortgage_payments = ?,loan_amount = ?,down_payment = ?,date_transaction = ?,type_kpr = ? where id =?";
        jdbcTemplate.update(query,data.getPropertyId(),data.getAccountId(),data.getMortgagePayments(),data.getLoanAmount(),data.getDownPayment(),data.getDateTransaction(),data.getTypeKpr(),data.getId());
    }

    @Override
    public void deleteById(String id) {
        String query = "DELETE FROM transaction where id = ?";
        jdbcTemplate.update(query, id);
    }

    @Override
    public void deleteAll() {
        String query = "TRUNCATE TABLE transaction";
        jdbcTemplate.update(query);
    }
}
