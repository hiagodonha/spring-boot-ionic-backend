package com.hiagodonha.mc.bo;

import org.springframework.mail.SimpleMailMessage;

import com.hiagodonha.mc.model.Pedido;

public interface EmailBo {
	
	void sendOrderConfimationEmail(Pedido pedido);
	
	void sendEmail(SimpleMailMessage msg);
}
