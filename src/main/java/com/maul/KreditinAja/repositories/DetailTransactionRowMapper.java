package com.maul.KreditinAja.repositories;

import com.maul.KreditinAja.entities.DetailTransaction;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DetailTransactionRowMapper implements RowMapper<DetailTransaction> {
    @Override
    public DetailTransaction mapRow(ResultSet resultSet, int i) throws SQLException {
        DetailTransaction detailTransaction = new DetailTransaction();
        detailTransaction.setId(resultSet.getString("id"));
        detailTransaction.setDatePayment(resultSet.getString("date_payment"));
        detailTransaction.setPaymentAmount(resultSet.getDouble("payment_amount"));
        detailTransaction.setTransactionId(resultSet.getString("transaction_id"));
        return detailTransaction;
    }
}
