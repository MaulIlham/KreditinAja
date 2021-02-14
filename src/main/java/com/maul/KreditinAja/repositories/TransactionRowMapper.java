package com.maul.KreditinAja.repositories;

import com.maul.KreditinAja.entities.Transaction;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionRowMapper implements RowMapper<Transaction> {
    @Override
    public Transaction mapRow(ResultSet resultSet, int i) throws SQLException {
        Transaction transaction = new Transaction();
        transaction.setId(resultSet.getString("id"));
        transaction.setDownPayment(resultSet.getDouble("down_payment"));
        transaction.setDateTransaction(resultSet.getString("date_transaction"));
        transaction.setLoanAmount(resultSet.getDouble("loan_amount"));
        transaction.setMortgagePayments(resultSet.getInt("mortgage_payments"));
        transaction.setTypeKpr(resultSet.getString("type_kpr"));
        transaction.setPropertyId(resultSet.getString("property_id"));
        transaction.setAccountId(resultSet.getString("account_id"));
        return transaction;
    }
}
