package aeb.gov.br.jms.jms.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import aeb.gov.br.jms.model.EmailModelQueueItem;

@Component
public class EmailQueuSender extends AebQueueSender<EmailModelQueueItem> {

	@Autowired
	public EmailQueuSender(final JmsTemplate jmsTemplate) {
		super(jmsTemplate);
	}

	@Override
	public String getQueueName() {
		return "Queue.Aeb.Email.Send";
	}

}
