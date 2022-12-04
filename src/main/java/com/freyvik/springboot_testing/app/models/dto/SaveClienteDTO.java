package com.freyvik.springboot_testing.app.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class SaveClienteDTO {

	@NotBlank
	private String nombre;
	@NotBlank
	private String apellido;
	@Email
	private String email;
	@NotBlank
	@Pattern(regexp = "^[0-3]{1}\\d{1}[/][0-1]{1}\\d{1}[/][12]{1}[09]{1}\\d{2}$", message = "Formato fecha no valido [dd/mm/aaaa]")
	private String createAt;
	
	/*
	@JsonCreator
	public SaveClienteDTO(
			@JsonProperty(required = true) String nombre,
			@JsonProperty(required = true) String apellido,
			@JsonProperty(required = true) String email
			) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}
	*/
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
		
	public String getCreateAt() {
		return createAt;
	}
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}
	@Override
	public String toString() {
		return "{nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + "}";
	}
}
