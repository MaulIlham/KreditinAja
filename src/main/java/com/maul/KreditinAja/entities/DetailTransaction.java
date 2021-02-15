package com.maul.KreditinAja.entities;

import java.util.Objects;

public class DetailTransaction {
    private String id;
    private String transactionId;
    private Double paymentAmount;
    private String datePayment;

    public DetailTransaction() {
    }

    public DetailTransaction(String id, String transactionId, Double paymentAmount, String datePayment) {
        this.id = id;
        this.transactionId = transactionId;
        this.paymentAmount = paymentAmount;
        this.datePayment = datePayment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(String datePayment) {
        this.datePayment = datePayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetailTransaction that = (DetailTransaction) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(transactionId, that.transactionId) &&
                Objects.equals(paymentAmount, that.paymentAmount) &&
                Objects.equals(datePayment, that.datePayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transactionId, paymentAmount, datePayment);
    }
}
