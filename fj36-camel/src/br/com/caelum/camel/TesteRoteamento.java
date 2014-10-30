/**
 * 
 */
package br.com.caelum.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @author soa4769
 * 
 */
public class TesteRoteamento {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				from("file:entrada?delay=5s")
						.log(LoggingLevel.INFO, "Processando mensagem ${id}")
						.bean(ValidadorPedido.class, "Validar")
						.transform(body(String.class).regexReplaceAll("nomeAutor", "autor"))
						.log(LoggingLevel.INFO, "Mensagem processada ${id}")
						.to("file:saida");
			}
		});

		context.start();
		Thread.sleep(30000);
		context.stop();
	}
}
