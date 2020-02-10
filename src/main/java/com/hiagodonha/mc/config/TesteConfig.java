package com.hiagodonha.mc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.hiagodonha.mc.bo.EmailBo;
import com.hiagodonha.mc.bo.MockEmailBo;

@Configuration
@Profile("test")
public class TesteConfig {
	
	@Bean
	public EmailBo emailBo() {
		return new MockEmailBo();
	}

}
