package com.punisher;
public class Contacts {
    private String name;
    private String PhoneNumber;

    public Contacts(String name, String PhoneNumber) {
        this.name = name;
        this.PhoneNumber = PhoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }
    public static Contacts createContact(String name, String PhoneNumber) {
    return new Contacts(name,PhoneNumber);
    }

}
