package org.zeus.crudmessages;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Contact> contacts;
    private static Scanner scanner;
    private static int id = 0;

    public static void main(String[] args) {

        contacts = new ArrayList<>();
        System.out.println("Welcome to Messenger");
        showInitialOptions();
    }

    private static void showInitialOptions(){
        System.out.println("Please select one: " +
                "\n\t1. Manage Contacts" +
                "\n\t2. Messages" +
                "\n\t3. Quit");

        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                manageContacts();
                break;
            case 2:
                manageMessages();
                break;
            default:
                break;
        }
    }

    private static void manageContacts() {
        System.out.println("Please select one: " +
                "\n\t1. Show all Contacts" +
                "\n\t2. Add a new contact" +
                "\n\t3. Search for a contact" +
                "\n\t4. Delete a contact" +
                "\n\t5. Go back");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                showAllContacts();
                break;
            case 2:
                addNewContacts();
                break;
            case 3:
                searchForContact();
                break;
            case 4:
                deleteContact();
                break;
            default:
                showInitialOptions();
                break;
        }
    }

    private static void manageMessages() {
        System.out.println("Please select one: " +
                "\n\t1. Show all messages" +
                "\n\t2. Send a new message" +
                "\n\t3. Go back");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                showAllMessages();
                break;
            case 2:
                sendNewMessages();
                break;
            default:
                showInitialOptions();
                break;
        }

    }

    private static void showAllMessages() {
        ArrayList<Message> allMessages = new ArrayList<>();
        for (Contact c: contacts) {
            allMessages.addAll(c.getMessages());
        }

        if(allMessages.size() > 0) {
            for (Message m: allMessages) {
                m.getDetails();
                System.out.println("****************");
            }
        } else {
            System.out.println("No Message");
        }

    }

    private static void sendNewMessages() {
        System.out.println("Message for?");
        String name = scanner.next();

        if(name.equals("")){
            System.out.println("Please enter the name of the contact");
        } else {
            boolean doesExist = false;

            for (Contact c: contacts) {
                if (c.getName().equals(name)){
                    doesExist = true;
                }
            }

            if (doesExist) {

                System.out.println("Enter a message: ");
                String text = scanner.next();
                if (text.equals("")){
                    System.out.println("Message empty. Enter a message.");
                    sendNewMessages();
                } else {

                    id++;
                    Message newMessage = new Message(text, name, id);
                    for (Contact c: contacts){
                        if(c.getName().equals(name)){
                            ArrayList<Message> newMessages = c.getMessages();
                            newMessages.add(newMessage);
                            Contact currentContact = c;
                            currentContact.setMessages(newMessages);
                            contacts.remove(c);
                            contacts.add(currentContact);
                        }
                    }

                }


            } else {
                System.out.println("No contact found");
            }

            showInitialOptions();


        }

    }

    private static void showAllContacts() {
        for (Contact c: contacts) {
            c.getDetails();
            System.out.println("**********************");
        }
        showInitialOptions();
    }

    private static void addNewContacts(){

        System.out.println("Please enter the contact's name");

        String name = scanner.next();
        System.out.println("Please enter contact's number");
        String number = scanner.next();
        System.out.println("Please enter contact's email");
        String email = scanner.next();

        if(name.equals("") || number.equals("") || email.equals("")){
            System.out.println("Please enter all of the information");
            addNewContacts();
        } else {

            boolean doesExist = false;

            for (Contact c: contacts) {
                if (c.getName().equals(name)){
                    doesExist = true;
                }

            }

            if (doesExist) {
                System.out.println("Contact " + name + " already existed");
            } else {
                Contact contact = new Contact(name,number,email);
                contacts.add(contact);
                System.out.println(name + " added successfully");
            }


        }

        showInitialOptions();
    }

    private static void searchForContact() {
        System.out.println("Please enter the contact name: ");
        String name = scanner.next();

        if(name.equals("")){

            System.out.println("Please enter the name");
            searchForContact();

        } else {

            boolean doesExist =  false;

            for (Contact c: contacts) {

                if (c.getName().equals(name)){
                    doesExist = true;
                    c.getDetails();
                }

            }


            if (!doesExist){
                System.out.println("Contact Not Found");
            }

            showInitialOptions();

        }

    }

    private static void deleteContact() {
        System.out.println("Please enter the name: ");
        String name = scanner.next();

        if(name.equals(" ")){

            System.out.println("Please enter the name");
            deleteContact();

        } else {

            boolean doesExist = false;

            for (Contact c: contacts) {
                if (c.getName().equals(name)){
                    doesExist = true;
                    contacts.remove(c);
                }
            }

            if(!doesExist) {
                System.out.println("Contact not found");
            }

            showInitialOptions();

        }

    }



}
