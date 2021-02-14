package com.maul.KreditinAja.repositories;

import com.maul.KreditinAja.entities.DetailTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class DetailTransactionRepositoryImpl implements DetailTransactionRepository{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<DetailTransaction> findAll() {
        String query = "SELECT * from detailtransaction";
        RowMapper<DetailTransaction> detailTransactionRowMapper = new DetailTransactionRowMapper();
        List<DetailTransaction> detailTransactions = jdbcTemplate.query(query, detailTransactionRowMapper);
        return detailTransactions;
    }

    @Override
    public DetailTransaction findById(String id) {
        String query = "SELECT * from detailtransaction where id = ?";
        RowMapper<DetailTransaction> detailTransactionRowMapper = new BeanPropertyRowMapper<DetailTransaction>(DetailTransaction.class);
        DetailTransaction detailTransaction = jdbcTemplate.queryForObject(query, detailTransactionRowMapper, id);
        return detailTransaction;
    }

    @Override
    public void save(DetailTransaction data) {
        String query = "INSERT INTO detailtransaction(id,transaction_id,payment_amount,date_payment) VALUES(?,?,?,?)";
        jdbcTemplate.update(query,data.getId(),data.getTransactionId(),data.getPaymentAmount(),data.getDatePayment());
    }

    @Override
    public void update(DetailTransaction data) {
        String query = "UPDATE detailtransaction set transaction_id= ?, payment_amount = ?, date_payment = ? where id = ?";
        jdbcTemplate.update(query,data.getTransactionId(),data.getPaymentAmount(),data.getDatePayment(),data.getId());
    }

    @Override
    public void deleteById(String id) {
        String query = "DELETE FROM detailtransaction where id = ?";
        jdbcTemplate.update(query, id);
    }
}
