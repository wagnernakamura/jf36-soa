/**
 * 
 */
package br.com.caelum.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 * @author soa4769
 * 
 */
public class TesteUnmarshal {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		JAXBContext context = JAXBContext.newInstance(Livro.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Livro livro = (Livro)unmarshaller.unmarshal(new File("livro.xml"));
		System.out.println(livro.getTitulo());
		System.out.println(livro.getCategoria().getNome());
	}
}
