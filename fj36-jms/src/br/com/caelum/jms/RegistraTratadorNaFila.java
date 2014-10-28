/**
 * 
 */
package br.com.caelum.jms;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.naming.InitialContext;

/**
 * @author soa4769 
 * JMS 1.0 - QueueConnectionFactory 
 * JMS 1.1 - ConnectionFactory (Generalizou)
 */
public class RegistraTratadorNaFila {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		InitialContext initialContext = new InitialContext();

		ConnectionFactory fabrica = (ConnectionFactory) initialContext
				.lookup("ConnectionFactory");
		Connection conexao = fabrica.createConnection();
		Queue fila = (Queue) initialContext.lookup("gerador");
		Session sessao = conexao.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		MessageConsumer consumidor = sessao.createConsumer(fila);

		consumidor.setMessageListener(new TratadorDeMensagem());
		conexao.start();
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Tratador esperando as mensagens na fila JMS.");
		
		teclado.nextLine();
		teclado.close();
		conexao.close();
	}
}
