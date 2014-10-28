/**
 * 
 */
package br.com.caelum.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author soa4769
 *
 */
public class TratadorDeMensagem implements MessageListener {

	/* (non-Javadoc)
	 * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
	 */
	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		
		try {
			System.out.println("Tratador recebendo mensagem: " + textMessage.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
