/**
 * 
 */
package br.com.caelum.jaxb;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author soa4769
 * 
 */
public class TesteMarshalJson {

	/**
	 * @param args
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 */
	public static void main(String[] args) throws JsonGenerationException,
			JsonMappingException, IOException {
		Livro livro = new Livro();
		livro.setCodigo("ARQ");
		livro.setCategoria(new Categoria("Livro Mole"));
		livro.setNomeAutor("Eu");
		livro.setTitulo("SOA");
		livro.setValor(new BigDecimal(10));

		ObjectMapper mapper = new ObjectMapper();
		//mapper.writeValue(new File("livro.json"), livro); //escreve Json
		Livro result = mapper.readValue(new File("livro.json"), Livro.class);
		
		System.out.println("O código do livro é: " + result.getTitulo());
	}
}
