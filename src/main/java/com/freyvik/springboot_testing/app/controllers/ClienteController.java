package com.freyvik.springboot_testing.app.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freyvik.springboot_testing.app.models.dao.ClienteDao;
import com.freyvik.springboot_testing.app.models.dao.ClienteJpaRepository;
import com.freyvik.springboot_testing.app.models.dto.ClienteResponseDto;
import com.freyvik.springboot_testing.app.models.dto.SaveClienteDTO;
import com.freyvik.springboot_testing.app.models.entity.Cliente;

import jakarta.validation.Valid;

@Controller
public class ClienteController {
	
	private ClienteDao clienteDao;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public ClienteController(ClienteJpaRepository clienteJpaRepository) {
		this.clienteDao = clienteJpaRepository;
	}
	
	@GetMapping("/test")
	public ResponseEntity<?> test() {
		return new ResponseEntity<String>("test", HttpStatus.OK);
	}
	
	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listar() throws JsonProcessingException {
		String result;
	
		List<Cliente> allClientesList = clienteDao.findAll();

		List<ClienteResponseDto> clientesListDto = allClientesList.stream()
				.map( c -> new ClienteResponseDto(c))
				.collect(Collectors.toList());
		
		result = objectMapper.writeValueAsString(clientesListDto);
		
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	@PutMapping("/save")
	public ResponseEntity<SaveClienteDTO> save(@Valid @RequestBody SaveClienteDTO saveRequest) {
		
		return ResponseEntity.ok(saveRequest);
	}
}
