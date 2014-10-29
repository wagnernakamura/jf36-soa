/**
 * 
 */
package br.com.caelum.jaxb;

import java.io.FileOutputStream;
import java.math.BigDecimal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

/**
 * @author soa4769
 * 
 */
public class TesteMarshal {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Livro livro = new Livro("ARQ", "Arquitetura Java", "Paulo Silveira",
				new BigDecimal("29.90"), new Categoria("TI"));

		JAXBContext context = JAXBContext.newInstance(Livro.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(livro, new FileOutputStream("livro.xml"));
	}
}
