package br.com.SevenDaysOfCode;



import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class HTMLGenerator {

	private List<Filme> filme;
	private int posicao;
	public PrintWriter pw;
	public String html;
	
	public HTMLGenerator(List<Filme> filme, int posicao) throws FileNotFoundException {
		this.filme = filme;
		this.posicao = posicao;
		this.pw = new PrintWriter(filme.get(posicao).titulo()+"-"+filme.get(posicao).ano()+".html");
		this.html = generator();
		
	}
	
	private String generator() {
		//Template HTML
		 String html = "<!doctype html>\r\n"
				+ "<html lang=\"pt\">\r\n"
				+ "  <head>\r\n"
				+ "    <meta charset=\"utf-8\"/>\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n"
				+ "\r\n"
				+ "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\" integrity=\"sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn\" crossorigin=\"anonymous\">\r\n"
				+ "\r\n"
				+ "    <title>7#DaysOfCode</title>\r\n"
				+ "  </head>\r\n"
				+ "  <body>\r\n"
				+ "    <div class=\"card\" style=\"width: 18rem;\">\r\n"
				+ "  <img src=\""+ filme.get(posicao).urlImage()+" class=\"card-img-top\" alt=\"...\">\r\n"
				+ "  <div class=\"card-body\">\r\n"
				+ "    <h5 class=\"card-title\">"+ filme.get(posicao).titulo()+"</h5>\r\n"
				+ "    \r\n"
				+ "  </div>\r\n"
				+ "  <ul class=\"list-group list-group-flush\">\r\n"
				+ "    <li class=\"list-group-item\">"+"Ano: "+filme.get(posicao).ano() +"</li>\r\n"
				+ "    <li class=\"list-group-item\">"+"Nota: "+filme.get(posicao).nota()+"</li>\r\n"
				+ "  </ul>\r\n"
				+ "</div>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "    <script src=\"https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\r\n"
				+ "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF\" crossorigin=\"anonymous\"></script>\r\n"
				+" </body>\r\n"
				+ "</html>";
		 return html;
		
	}


}
