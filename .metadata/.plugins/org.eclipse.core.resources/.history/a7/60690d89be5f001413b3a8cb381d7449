package br.com.caelum.livraria.jms;

import java.io.Serializable;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import br.com.caelum.livraria.modelo.Pedido;

@Component
@Lazy(true)
public class EnviadorMensagemJms implements Serializable {

	private static final long serialVersionUID = 1L;

	public void enviar(Pedido pedido) {

		try {
			Context localContext = getContextoLocal();
			Topic topico = (Topic) localContext.lookup("jms/topico/livraria");
			ConnectionFactory factory = (ConnectionFactory) localContext
					.lookup("jms/ConnectionFactory");

			Connection conexao = factory.createConnection();
			Session session = conexao.createSession(false,
					Session.AUTO_ACKNOWLEDGE);

			// crie e envie a mensagem aqui
			MessageProducer publisher = session.createProducer(topico);

			System.out.println("JMS: Enviando pedido: " + pedido);

			Message msg = session.createTextMessage(pedido.toString());

			// para o seletor
			msg.setStringProperty("formato", pedido.getFormato());
			publisher.send(msg);

			session.close();
			conexao.close();
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}

	private Context getContextoLocal() throws NamingException {
		InitialContext initialContext = new InitialContext();
		Context localContext = (Context) initialContext.lookup("java:comp/env");
		return localContext;
	}
}
