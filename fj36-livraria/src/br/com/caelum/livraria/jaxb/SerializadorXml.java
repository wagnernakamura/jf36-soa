package br.com.caelum.livraria.jaxb;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import br.com.caelum.livraria.modelo.Pedido;

public class SerializadorXml {

	public String toXml(Pedido pedido) {
		try {
			// aqui vem o codigo do marshaller
			Marshaller marshaller = JAXBContext.newInstance(Pedido.class)
					.createMarshaller();
			StringWriter sw = new StringWriter();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(pedido, sw);

			return sw.toString();
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}
	}
}
