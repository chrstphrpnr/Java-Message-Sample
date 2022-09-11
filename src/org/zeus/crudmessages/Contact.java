package org.zeus.crudmessages;

import java.util.ArrayList;

public class Contact {
    private String name;
    private String number;
    private String email;
    private ArrayList<Message> messages; //To save different messages for every contact inside an arraylist

    // Two construct is needed because at the time of creating a new contact, the contact doesn't have any messages

    //this constructor will not accept an arraylist of any messages
    public Contact(String name, String number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.messages = new ArrayList<>(); //To not have an error and will not save the messages in arraylist
    }

    public Contact(String name, String number, String email, ArrayList<Message> messages) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.messages = messages;
    }

    public void getDetails () {
        System.out.println  (
                              "Name: " + this.name + " "
                            + "\nNumber: " + this.number + " "
                            + "\nEmail: " + this.email
                );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }
}
