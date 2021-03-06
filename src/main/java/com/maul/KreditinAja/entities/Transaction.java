package com.maul.KreditinAja.entities;


import java.util.List;
import java.util.Objects;

public class Transaction {
    private String id;
    private String propertyId;
    private String accountId;
    private Integer mortgagePayments;
    private Double loanAmount;
    private Double downPayment;
    private String dateTransaction;
    private String typeKpr;
    private List<DetailTransaction> detailTransactions;

    public Transaction() {
    }

    public Transaction(String id, String propertyId, String accountId, Integer mortgagePayments, Double loanAmount, Double downPayment, String dateTransaction, String typeKpr) {
        this.id = id;
        this.propertyId = propertyId;
        this.accountId = accountId;
        this.mortgagePayments = mortgagePayments;
        this.loanAmount = loanAmount;
        this.downPayment = downPayment;
        this.dateTransaction = dateTransaction;
        this.typeKpr = typeKpr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Integer getMortgagePayments() {
        return mortgagePayments;
    }

    public void setMortgagePayments(Integer mortgagePayments) {
        this.mortgagePayments = mortgagePayments;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Double getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(Double downPayment) {
        this.downPayment = downPayment;
    }

    public String getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(String dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public String getTypeKpr() {
        return typeKpr;
    }

    public void setTypeKpr(String typeKpr) {
        this.typeKpr = typeKpr;
    }

    public List<DetailTransaction> getDetailTransactions() {
        return detailTransactions;
    }

    public void setDetailTransactions(List<DetailTransaction> detailTransactions) {
        this.detailTransactions = detailTransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(propertyId, that.propertyId) &&
                Objects.equals(accountId, that.accountId) &&
                Objects.equals(mortgagePayments, that.mortgagePayments) &&
                Objects.equals(loanAmount, that.loanAmount) &&
                Objects.equals(downPayment, that.downPayment) &&
                Objects.equals(dateTransaction, that.dateTransaction) &&
                Objects.equals(typeKpr, that.typeKpr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, propertyId, accountId, mortgagePayments, loanAmount, downPayment, dateTransaction, typeKpr);
    }
}
