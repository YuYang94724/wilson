package com.java.state;

interface State{
    void  publish(User user);
    void  showDocument();
    void  allowEdit();
}

class Draft implements State{
    private Document document;

    public Draft(Document document){
        this.document = document;
    }

    @Override
    public void publish(User user) {
        if (user.getRole().equals("admin")){
            this.document.changeState(new Published(document));
        }else {
            this.document.changeState(new Moderation(document));
        }
    }

    @Override
    public void showDocument() {
        System.out.println("This document is in draft state and can submit this document for review");
    }

    @Override
    public void allowEdit() {
        System.out.println("Allow edit draft");
    }
}

class Published implements State{
    private Document document;

    public Published(Document document){
        this.document = document;
    }

    @Override
    public void publish(User user) {
        System.out.println("Document is already published");
    }

    @Override
    public void showDocument() {
        System.out.println("Ths document is published and can be viewed");
    }

    @Override
    public void allowEdit() {
        System.out.println("No edit");
    }
}

class Moderation implements State{
    private Document document;

    public Moderation(Document document){
        this.document = document;
    }

    @Override
    public void publish(User user) {
        if (user.getRole().equals("admin")){
            this.document.changeState(new Published(document));
        }
    }

    @Override
    public void showDocument() {
        System.out.println("Document is being reviewed by the admin.");
    }

    @Override
    public void allowEdit() {
        System.out.println("Only admin can allow this document.");
    }
}
class User{
    private String role;
    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }
}
class Document{
    private State state;

    public Document() {
        this.state = new Draft(this);
    }

    public State getState() {
        return this.state;
    }

    public void changeState(State state){
        this.state = state;
    }

    public void publish(User user){
        this.state.publish(user);
    }

    public void showDocument(){
        this.state.showDocument();
    }

    public void allowEdit(){
        this.state.allowEdit();
    }
}
public class StatePatten {
    public static void main(String[] args) {
        User admin = new User("admin");
        User author = new User("author");
        Document document = new Document();
        document.publish(author);
        document.showDocument();
        document.allowEdit();

    }
}
