package com.punisher;

import java.util.Scanner;

public class Main {
    private static Scanner Input = new Scanner(System.in);
    private static MobilePhone MyMobile = new MobilePhone("0039 330 4404");

    public static void main(String[] args) {

        boolean quit = false;
        StartPhone();
        PrintActions();
        while(!quit) {
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = Input.nextInt();
            Input.nextLine();

            switch (action) {
                case 1:
                    MyMobile.PrintContacts();
                    break;

                case 2:
                    AddNewContact();
                    break;

                case 3:
                    UpdateContact();
                    break;

                case 4:
                    Removecontact();
                    break;

                case 5:
                    SearchContact();
                    break;

                case 6:
                    PrintActions();
                    break;

                case 7:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;
            }

        }

    }

    private static void AddNewContact() {
        System.out.println("Enter new contact name: ");
        String name = Input.nextLine();
        System.out.println("Enter phone number: ");
        String phone = Input.nextLine();
        Contact NewContact = Contact.CreateContact(name, phone);
        if(MyMobile.AddNewContact(NewContact)) {
            System.out.println("New contact added: name = " + name + ", phone = "+ phone);
        } else {
            System.out.println("Cannot add, " + name + " already on file");
        }
    }

    private static void UpdateContact() {
        System.out.println("Enter existing contact name: ");
        String name = Input.nextLine();
        Contact ExistingContactRecord = MyMobile.SearchContact(name);
        if(ExistingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.print("Enter new contact name: ");
        String newName = Input.nextLine();
        System.out.print("Enter new contact phone number: ");
        String newNumber = Input.nextLine();
        Contact newContact = Contact.CreateContact(newName, newNumber);
        if(MyMobile.UpdateContact(ExistingContactRecord, newContact)) {
            System.out.println("Successfully updated record");
        } else {
            System.out.println("Error updating record.");
        }
    }

    private static void Removecontact() {
        System.out.println("Enter existing contact name: ");
        String name = Input.nextLine();
        Contact ExistingContactRecord = MyMobile.SearchContact(name);
        if (ExistingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }

        if(MyMobile.RemoveContact(ExistingContactRecord)) {
            System.out.println("Successfully deleted");
        } else {
            System.out.println("Error deleting contact");
        }
    }

    private static void SearchContact() {
        System.out.println("Enter existing contact name: ");
        String name = Input.nextLine();
        Contact ExistingContactRecord = MyMobile.SearchContact(name);
        if (ExistingContactRecord == null) {
            System.out.println("Contact not found.");
            return;

        }

        System.out.println("Name: " + ExistingContactRecord.getName() + " phone number is " + ExistingContactRecord.getPhoneNumber());
    }

    private static void StartPhone() {
        System.out.println("Starting phone...");
    }

    private static void PrintActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("1  - To print contacts \n" +
                "2  - To add a new contact\n" +
                "3  - To update an existing contact\n" +
                "4  - To remove an existing contact\n" +
                "5  - Search if an existing contact exists\n" +
                "6  - To print a list of available actions.\n" +
                "7  - To shutdown");
        System.out.println("Choose your action: ");
    }
}
