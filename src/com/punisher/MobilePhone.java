package com.punisher;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean AddNewContact(Contact contact) {
        if(FindContact(contact.getName()) >=0) {
            System.out.println("Contact is already on file");
            return false;
        }

        myContacts.add(contact);
        return true;

    }

    public boolean UpdateContact(Contact oldContact, Contact newContact) {
        int foundPosition = FindContact(oldContact);
        if(foundPosition <0) {
            System.out.println(oldContact.getName() +", was not found.");
            return false;
        }else if (FindContact(newContact.getName())!=-1) {
            System.out.println("Contact with name "+newContact.getName()+" already exits!!! \n error updating contact");
            return false;
        }

        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
        return true;
    }

    public boolean RemoveContact(Contact contact) {
        int foundPosition = FindContact(contact);
        if(foundPosition <0) {
            System.out.println(contact.getName() +", was not found.");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getName() + ", was deleted.");
        return true;
    }

    private int FindContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    private int FindContact(String contactName) {
        for(int i=0; i<this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if(contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public String SearchContact(Contact contact) {
        if(FindContact(contact) >=0) {
            return contact.getName();
        }
        return null;
    }

    public Contact SearchContact(String name) {
        int position = FindContact(name);
        if(position >=0) {
            return this.myContacts.get(position);
        }

        return null;
    }

    public void PrintContacts() {
        System.out.println("Contact List");
        if (this.myContacts.size()==0){
            System.out.println("NO contacts Available");
        }
        else {
            for (int i = 0; i < this.myContacts.size(); i++) {
                System.out.println((i + 1) + "." +
                        this.myContacts.get(i).getName() + " -> " +
                        this.myContacts.get(i).getPhoneNumber());
            }
        }
    }
}
