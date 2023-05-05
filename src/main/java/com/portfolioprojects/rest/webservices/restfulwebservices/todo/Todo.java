package com.portfolioprojects.rest.webservices.restfulwebservices.todo;

import java.time.LocalDate;

//Database (MySQL)
//create a List of Todos ==> we will use real database (H2, MySQL)


public class Todo {


    private int id;
    private String username;
    //    @Size(min = 10, message = "Enter at least 10 characters")
    private String description;
    //    @FutureOrPresent(message = "Please enter a future date")

    //    @FutureOrPresent(message = "Only present and future dates are accepted")
    private LocalDate targetDate;

    private boolean isCompleted;

    public Todo(int id, String username, String description, LocalDate targetDate, boolean isCompleted) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.isCompleted = isCompleted;
    }

    public Todo() {
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public void setIsCompleted(boolean completed) {
        this.isCompleted = completed;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", done=" + isCompleted +
                '}';
    }
}
