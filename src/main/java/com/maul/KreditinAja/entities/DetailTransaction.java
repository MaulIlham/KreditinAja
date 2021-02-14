package com.maul.KreditinAja.entities;

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
}
