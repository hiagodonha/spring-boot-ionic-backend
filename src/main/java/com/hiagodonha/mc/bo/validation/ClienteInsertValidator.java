package com.hiagodonha.mc.bo.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.hiagodonha.mc.bo.validation.utils.BR;
import com.hiagodonha.mc.dto.ClienteNewDTO;
import com.hiagodonha.mc.model.enums.TipoCliente;
import com.hiagodonha.mc.rest.exception.FieldMessage;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	@Override
	public void initialize(ClienteInsert ann) {}

	@Override
	public boolean isValid(ClienteNewDTO clienteNewDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		if(clienteNewDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(clienteNewDto.getCep())) {
			list.add(new FieldMessage("cpfOuCpnj", "CPF inválido"));
		}
		
		if(clienteNewDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(clienteNewDto.getCep())) {
			list.add(new FieldMessage("cpfOuCpnj", "CNPJ inválido"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage())
			.addPropertyNode(e.getFieldName()).addConstraintViolation();
		}
		return list.isEmpty();
	}
	
}