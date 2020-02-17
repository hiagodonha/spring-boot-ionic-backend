package com.hiagodonha.mc.bo;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;

import com.hiagodonha.mc.model.Pedido;

public interface EmailBo {
	
	@Bean
	void sendOrderConfimationEmail(Pedido pedido);
	
	@Bean
	void sendEmail(SimpleMailMessage msg);
}
