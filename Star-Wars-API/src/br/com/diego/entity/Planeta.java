package br.com.diego.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PLANETA")
public class Planeta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_planeta")
	private int id_planeta;

	@Column(name = "nm_planeta", nullable = false, length = 100)
	private String nome;

	@Column(name = "nm_clima", nullable = false, length = 100)
	private String clima;

	@Column(name = "nm_terreno", nullable = false, length = 100)
	private String terreno;

	@Column(name = "qt_filmes", nullable = false)
	private int quant_filmes;

	public int getId_planeta() {
		return id_planeta;
	}

	public void setId_planeta(int id_planeta) {
		this.id_planeta = id_planeta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public int getQuant_filmes() {
		return quant_filmes;
	}

	public void setQuant_filmes(int quant_filmes) {
		this.quant_filmes = quant_filmes;
	}

}