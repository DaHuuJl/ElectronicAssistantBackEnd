package ru.cchgeu.electronicassistantbackend.services.mail;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

/**
 * Сервис для отправки сообщений
 */
@Service
public class MailSenderServiceImpl implements MailSenderService {

    @Value("${spring.mail.username}")
    private String username;

    private final JavaMailSender mailSender;

    public MailSenderServiceImpl(JavaMailSender javaMailSender) {
        this.mailSender = javaMailSender;
    }

    /**
     * Метод отпрвляет текст
     * @param email почта получателя
     * @param subject тема письма
     * @param message сообщение
     */
    @Override
    public void sendMessage(String email, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(username);
        mailMessage.setTo(email);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }

    /**
     * Метод отправляет html документ
     * @param email почта получателя
     * @param subject тема письма
     * @param htmlDocument строка в формате html
     */
    @SneakyThrows
    @Override
    public void sendHtmlDocument(String email, String subject, String htmlDocument) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        helper.setFrom(username);
        helper.setTo(email);
        helper.setSubject(subject);
        helper.setText(htmlDocument, true);
        mailSender.send(mimeMessage);
    }
}
