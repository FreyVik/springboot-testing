package com.freyvik.springboot_testing.app.models.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.freyvik.springboot_testing.app.models.entity.Cliente;

public record ClienteResponseDto(String nombre, String apellido, String email, String createAt ) {
	static DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    
	public ClienteResponseDto(Cliente cliente) {
        
		this(cliente.getNombre(), cliente.getApellido(), cliente.getEmail(), formatter.format(cliente.getCreateAt()));
	}
}
