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

	public void Validar(Exchange exchange) {
		System.out.println("Validando: " + exchange.getExchangeId());
		String xml = exchange.getIn().getBody(String.class);

		if (!xml.contains("<pagamento>")) {
			throw new RuntimeException("Sem pagamento no pedido.");
		}
	}
}
