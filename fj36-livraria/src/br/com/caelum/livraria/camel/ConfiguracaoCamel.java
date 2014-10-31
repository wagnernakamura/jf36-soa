package br.com.caelum.livraria.camel;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfiguracaoCamel {

	@Autowired
	CamelContext context;

	@PostConstruct
	void init() throws Exception {
		ConnectionFactory factory = new ActiveMQConnectionFactory(
				"tcp://localhost:61616");

		context.addComponent("activemq",
				JmsComponent.jmsComponentAutoAcknowledge(factory));

		context.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {
//				from("activemq:topic:TOPICO.LIVRARIA")
//					.log(LoggingLevel.INFO,	"CAMEL: Recebendo MSG ${id}")
//					//.filter().xpath("//formato[text()='EBOOK']") //opção
//					.filter().xpath("/pedido/itens/item/formato[text()='EBOOK']")
//					.split().xpath("/pedido/itens")
//					//.split().tokenizeXML("item").streaming()//opção
//					.log(LoggingLevel.INFO,	"CAMEL: Filtrado MSG ${id} ${body}")
//					.to("activemq:queue:FILA.GERADOR");
				
				//teste direct
				from("activemq:topic:TOPICO.LIVRARIA")
				.to("direct:notas")
				.log(LoggingLevel.INFO,	"CAMEL: Recebendo MSG ${id}")
				//.filter().xpath("//formato[text()='EBOOK']") //opção
				.filter().xpath("/pedido/itens/item/formato[text()='EBOOK']")
				.split().xpath("/pedido/itens")
				//.split().tokenizeXML("item").streaming()//opção
				.log(LoggingLevel.INFO,	"CAMEL: Filtrado MSG ${id} ${body}")
				.to("activemq:queue:FILA.GERADOR");
				
				from("direct:notas")
					.setHeader("data", constant(new SimpleDateFormat("dd/MM/yyyy").format(new Date())))
					.split().xpath("/pedido/pagamento")
					.convertBodyTo(String.class)
					.to("velocity:nota.vm")
					.log(LoggingLevel.INFO, "CAMEL: MSG transformado com Velocity ${body}");
			};
		});

		context.start();
	}

	@PreDestroy
	void destroy() throws Exception {
		context.stop();
	}
}
