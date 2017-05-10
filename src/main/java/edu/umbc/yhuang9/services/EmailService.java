package edu.umbc.yhuang9.services;

import org.springframework.mail.SimpleMailMessage;

/**
 * Created by yhuang9 on 5/10/17.
 */
public interface EmailService {
    void sendSimpleMessageUsingTemplate(String to,
                                        String subject,
                                        SimpleMailMessage template,
                                        String ...templateArgs);

}
