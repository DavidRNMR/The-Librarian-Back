package com.thelibrarian.integration.service;

import com.thelibrarian.integration.utilities.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendEmail(String userName, String userEmail) {
        Mail mail = new Mail();
        mail.setFrom("no-reply@gmail.com");
        mail.setTo(userEmail);
        mail.setSubject("Bienvenid@ a The Librarian!");
        mail.setContent("Hola, " + userName + "!\n" +
                System.lineSeparator() +
                "Bienvenid@ a The Librarian!\n" +
                "Disfruta de miles de libros de todo el mundo con un acceso 24/7. " +
                "Te recordamos que en tu libreria personal 'Mis Libros' podras tener un maximo de 3 libros, los que puedes leer sin ningun limite de tiempo para devolverlos.\n" +
                "Para cualquer duda contacta con nosotros.\n" +
                System.lineSeparator() +
                "Un cordial saludo,\n" +
                "el equipo de The Librarian!");

        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(mail.getSubject());
        message.setFrom(mail.getFrom());
        message.setTo(mail.getTo());
        message.setText(mail.getContent());

        emailSender.send(message);

    }

}
