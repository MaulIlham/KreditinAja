package com.maul.KreditinAja.entities;

import java.util.List;

public class Property {
    private String id;
    private String name;
    private String size;
    private String address;
    private String latitude;
    private String longitude;
    private String certificate;
    private Integer powerSupply;
    private String description;
    private Double price;
    private String status;
    private String accountId;
    private String developerId;
    private List<Image> images;

    public Property() {
    }

    public Property(String id, String name, String size, String address, String latitude, String longitude, String certificate, Integer powerSupply, String description, Double price, String status, String accountId, String developerId) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.certificate = certificate;
        this.powerSupply = powerSupply;
        this.description = description;
        this.price = price;
        this.status = status;
        this.accountId = accountId;
        this.developerId = developerId;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public Integer getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(Integer powerSupply) {
        this.powerSupply = powerSupply;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(String developerId) {
        this.developerId = developerId;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
