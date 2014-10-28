/**
 * 
 */
package br.com.caelum.livraria.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.naming.InitialContext;

/**
 * @author soa4769
 * 
 */
public class EnviadorDeMensagensParaFila {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		InitialContext initialContext = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) initialContext
				.lookup("ConnectionFactory");
		Connection conexao = factory.createConnection();

		Queue fila = (Queue) initialContext.lookup("gerador");
		Session session = conexao
				.createSession(false, Session.AUTO_ACKNOWLEDGE);

		// crie e envie a mensagem aqui
		MessageProducer publisher = session.createProducer(fila);
		Message msg = session.createTextMessage("Mensagem com Stomp");

		publisher.send(msg);

		session.close();
		conexao.close();
	}
}
