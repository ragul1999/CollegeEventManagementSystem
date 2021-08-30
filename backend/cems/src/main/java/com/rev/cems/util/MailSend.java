package com.rev.cems.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


@Component
public class MailSend {

	 private static JavaMailSender javaMailSender;

	    @Autowired
	    public MailSend(JavaMailSender s)
	    {
	    	this.javaMailSender=s;
	    }
	    
	    
	    public static  void sendMail(List<String> toReceiver,String subject,String message){		
			    
	    	SimpleMailMessage msg = new SimpleMailMessage();
			        for(String s:toReceiver)
			        {
			        		msg.setTo(s);
					        msg.setSubject(subject);
					        msg.setText(message);

					        javaMailSender.send(msg);	
			        }
			        
   
		}
	
	
}
