package com.hiagodonha.mc.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

public class MockEmailBo extends AbstractEMailBo {

	private static final Logger LOG = LoggerFactory.getLogger(MockEmailBo.class);
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Simulando envio de email..");
		LOG.debug(msg.toString());
		LOG.info("Email enviado..");
	}

}
