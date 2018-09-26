package aeb.gov.br.jms.config;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;

public class AEBExceptionListener implements ExceptionListener {

	public void onException(JMSException exception) {

		exception.printStackTrace();
	}

}
