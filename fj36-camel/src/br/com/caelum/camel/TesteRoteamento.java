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
				
				onException(RuntimeException.class)
					.log("Exceção processando ${file:name}")
					.handled(true)
					.to("file:exception");
				
				errorHandler(deadLetterChannel("file:erro")
						.maximumRedeliveries(5)
						.redeliveryDelay(2000)
						.useOriginalMessage()
						);
				
				from("file:entrada?delay=5s")
						.threads(5)
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
