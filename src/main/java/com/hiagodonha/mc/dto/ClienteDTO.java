package com.hiagodonha.mc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.hiagodonha.mc.bo.validation.ClienteUpdate;
import com.hiagodonha.mc.model.Cliente;

@ClienteUpdate
public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Preenchimento de nome é obrigatório")
	@Length(min = 5, max = 120, message = "No minimo 5 caracter e no max 120")
	private String nome;
	
	@NotEmpty(message = "Preenchimento de nome é obrigatório")
	@Email(message = "Email inválido")
	private String email;
	

	public ClienteDTO() {}
	
	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
