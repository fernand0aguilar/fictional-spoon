package aeb.gov.br.jms.jms.sender;

import java.io.Serializable;

import org.springframework.jms.core.JmsTemplate;

public abstract class AebQueueSender<T extends Serializable> {

	private final JmsTemplate jmsTemplate;

	public AebQueueSender(final JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public void send(final T message) {
		System.out.println(message);
		System.out.println(getQueueName());
		jmsTemplate.convertAndSend(getQueueName(), message);
	}
	
	public abstract String getQueueName();
}
