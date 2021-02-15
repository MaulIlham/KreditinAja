package com.maul.KreditinAja.entities;

import java.util.Objects;

public class Profile {
    private String id;
    private String firstName;
    private String lastName;
    private String gender;
    private String birthDate;
    private String address;
    private String photoProfile;
    private String photoIdentity;
    private String accountId;
    private boolean isDeveloper;

    public Profile() {
    }

    public Profile(String id, String firstName, String lastName, String gender, String birthDate, String address, String photoProfile, String photoIdentity, String accountId, boolean isDeveloper) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.address = address;
        this.photoProfile = photoProfile;
        this.photoIdentity = photoIdentity;
        this.accountId = accountId;
        this.isDeveloper = isDeveloper;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhotoProfile() {
        return photoProfile;
    }

    public void setPhotoProfile(String photoProfile) {
        this.photoProfile = photoProfile;
    }

    public String getPhotoIdentity() {
        return photoIdentity;
    }

    public void setPhotoIdentity(String photoIdentity) {
        this.photoIdentity = photoIdentity;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public boolean getIsDeveloper() {
        return isDeveloper;
    }

    public void setIsDeveloper(boolean isDeveloper) {
        this.isDeveloper = isDeveloper;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return isDeveloper == profile.isDeveloper &&
                Objects.equals(id, profile.id) &&
                Objects.equals(firstName, profile.firstName) &&
                Objects.equals(lastName, profile.lastName) &&
                Objects.equals(gender, profile.gender) &&
                Objects.equals(birthDate, profile.birthDate) &&
                Objects.equals(address, profile.address) &&
                Objects.equals(photoProfile, profile.photoProfile) &&
                Objects.equals(photoIdentity, profile.photoIdentity) &&
                Objects.equals(accountId, profile.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, gender, birthDate, address, photoProfile, photoIdentity, accountId, isDeveloper);
    }
}
