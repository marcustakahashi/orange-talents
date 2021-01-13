package br.com.mtakahashi.orangetalents.domain.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CriarApostaInput {
	
	@NotBlank
	@Email
	@Size(max = 80)
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
