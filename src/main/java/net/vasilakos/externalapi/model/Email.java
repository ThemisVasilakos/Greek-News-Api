package net.vasilakos.externalapi.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Email {

    @Transient
    public static final String SEQUENCE_NAME = "email_sequence";

    @Id
    private Long emailId;

    private String email;

    public Email() {
    }

    public Email(String email) {
        this.email = email;
    }

    public Long getEmailId() {
        return emailId;
    }

    public void setEmailId(Long emailId) {
        this.emailId = emailId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
