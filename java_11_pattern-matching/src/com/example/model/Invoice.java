package com.example.model;

import java.time.LocalDate;

public class Invoice {
    public Invoice(LocalDate issueDate){
        this.issueDate = issueDate;
    }
    private LocalDate issueDate;

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "issueDate=" + issueDate +
                '}';
    }
}
