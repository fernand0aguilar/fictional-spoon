package aeb.gov.br.jms.jms.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import aeb.gov.br.jms.model.EmployeeHistoryUpdateQueueItem;

@Component
public class EmployeeHistoryUpdateQueueSender extends AebQueueSender<EmployeeHistoryUpdateQueueItem> {

	@Autowired
	public EmployeeHistoryUpdateQueueSender(JmsTemplate jmsTemplate) {
		super(jmsTemplate);
	}

	@Override
	public String getQueueName() {
		return "Queue.Aeb.EmployeeHistory.Update";
	}

}
