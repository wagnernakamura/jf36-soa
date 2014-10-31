/**
 * 
 */
package br.com.caelum.camel;

import org.apache.camel.Exchange;

/**
 * @author soa4769
 * 
 */
public class ValidadorPedido {

	/**
	 * 
	 */
	public ValidadorPedido() {
	}

	public void Validar(Exchange exchange) throws InterruptedException {
		System.out.println("Validando: " + exchange.getExchangeId());
		String xml = exchange.getIn().getBody(String.class);

		Thread.sleep(5000);
		
		if (!xml.contains("<pagamento>")) {
			throw new RuntimeException("Sem pagamento no pedido.");
		}
	}
}
