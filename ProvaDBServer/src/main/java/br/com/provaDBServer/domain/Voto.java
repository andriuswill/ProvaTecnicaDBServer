package br.com.provaDBServer.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;


@Entity
public class Voto implements Serializable {
	
	@Id	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Id	
	@Column(nullable = false)
	private String funcionario;
	
	@Column(nullable = false)
	private int restaurante;

	

	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public String getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}

	public int getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(int restaurante) {
		this.restaurante = restaurante;
	}
	
	
}
