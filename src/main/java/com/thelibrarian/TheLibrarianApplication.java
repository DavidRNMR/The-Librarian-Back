package com.thelibrarian;

import com.thelibrarian.integration.service.EmailService;
import com.thelibrarian.integration.utilities.Mail;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class TheLibrarianApplication {

	@Autowired
	private EmailService emailService;

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		
		SpringApplication.run(TheLibrarianApplication.class, args);
	}


	/*@EventListener(ApplicationReadyEvent.class)
	public void sendMail() {

		Mail mail = new Mail();
		mail.setFrom("no-reply@gmail.com");
		mail.setTo("itrifonov87@gmail.com");
		mail.setSubject("Sending Simple Email with JavaMailSender Example");
		mail.setContent("This is a simple email content created with Spring Framework.");

		emailService.sendEmail(mail);
	}*/

}
