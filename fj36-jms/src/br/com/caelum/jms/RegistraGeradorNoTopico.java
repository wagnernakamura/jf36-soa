/**
 * 
 */
package br.com.caelum.jms;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author soa4769
 * 
 */
public class RegistraGeradorNoTopico {

	/**
	 * @param args
	 * @throws NamingException
	 * @throws JMSException
	 */
	public static void main(String[] args) throws NamingException, JMSException {
		InitialContext contextoInicial = new InitialContext();
		ConnectionFactory fabrica = (ConnectionFactory) contextoInicial
				.lookup("ConnectionFactory");
		Connection conexao = fabrica.createConnection();

		conexao.setClientID("GeradorEbook");

		Topic topico = (Topic) contextoInicial.lookup("livraria");
		Session sessao = conexao.createSession(false, Session.AUTO_ACKNOWLEDGE);

		TopicSubscriber assinante = (TopicSubscriber) sessao
				.createDurableSubscriber(topico, "AssinaturaEbook",
						"formato='ebook'", false);
		assinante.setMessageListener(new TratadorDeMensagem());

		conexao.start();

		Scanner teclado = new Scanner(System.in);
		System.out.println("Gerador esperando as mensagens do tópico JMS...");
		teclado.nextLine();

		teclado.close();
		conexao.close();
	}
}
