package com.maul.KreditinAja.entities;

public class Image {
    private String id;
    private String name;
    private String propertyId;

    public Image() {
    }

    public Image(String id, String name, String propertyId) {
        this.id = id;
        this.name = name;
        this.propertyId = propertyId;
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

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }
}
