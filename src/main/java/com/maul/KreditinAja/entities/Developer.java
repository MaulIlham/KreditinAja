package com.maul.KreditinAja.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Developer {
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String fax;
    private String website;
    private String address;
    private String province;
    private String city;
    private String subDistrict;
    private String village;
    private String postCode;
    private String accountId;
    private List<Property> properties;

    public Developer() {
    }

    public Developer(String id, String name, String email, String phoneNumber, String fax, String website, String address, String province, String city, String subDistrict, String village, String postCode, String accountId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.fax = fax;
        this.website = website;
        this.address = address;
        this.province = province;
        this.city = city;
        this.subDistrict = subDistrict;
        this.village = village;
        this.postCode = postCode;
        this.accountId = accountId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return Objects.equals(id, developer.id) &&
                Objects.equals(name, developer.name) &&
                Objects.equals(email, developer.email) &&
                Objects.equals(phoneNumber, developer.phoneNumber) &&
                Objects.equals(fax, developer.fax) &&
                Objects.equals(website, developer.website) &&
                Objects.equals(address, developer.address) &&
                Objects.equals(province, developer.province) &&
                Objects.equals(city, developer.city) &&
                Objects.equals(subDistrict, developer.subDistrict) &&
                Objects.equals(village, developer.village) &&
                Objects.equals(postCode, developer.postCode) &&
                Objects.equals(accountId, developer.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phoneNumber, fax, website, address, province, city, subDistrict, village, postCode, accountId);
    }
}
