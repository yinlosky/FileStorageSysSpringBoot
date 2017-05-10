package edu.umbc.yhuang9.fileentity;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by yhuang9 on 5/10/17.
 */
public class MailObject {
    @Email
    @NotNull
    @Size(min=1, message="Please, set an email address to send the message to")
    private String to;
    private String subject;
    private String text;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
