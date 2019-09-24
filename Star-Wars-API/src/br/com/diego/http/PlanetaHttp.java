package br.com.diego.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PlanetaHttp {
	
	private int id_planeta;
	private String nome;
	private String clima;
	private String terreno;
	private int quant_filmes;
	
	
	public PlanetaHttp(int id_planeta, String nome, String clima, String terreno, int quant_filmes) {
		super();
		this.id_planeta = id_planeta;
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
		this.quant_filmes = quant_filmes;
	}
	public PlanetaHttp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCod_planeta() {
		return id_planeta;
	}
	public void setCod_planeta(int cod_planeta) {
		this.id_planeta = cod_planeta;
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
	public void setQuant_filmes(int qt_filmes) {
		this.quant_filmes = qt_filmes;
	}
	
	

}