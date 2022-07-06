package br.com.SevenDaysOfCode;

public record Filme(String titulo, String urlImage, int ano, double nota) {

	public Filme(String titulo, String urlImage, int ano, double nota) {
		this.titulo = titulo;
		this.urlImage = urlImage;
		this.ano = ano;
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Titulo: " + titulo + "\nImagem: " + urlImage + "\nAno: " + ano + "\nNota: "
				+ nota;
	}

}
