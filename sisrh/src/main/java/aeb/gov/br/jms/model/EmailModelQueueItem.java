package aeb.gov.br.jms.model;

import java.io.Serializable;

import aeb.gov.br.jms.util.EmailType;

public class EmailModelQueueItem implements Serializable {

	private static final long serialVersionUID = 2370014188080188497L;
	private String emailTo;
	private String urlConfirmacao;
	private String receiverNickname;
	private String subject;
	private String body;
	private String emailFrom;
	private String senderNickname;

	private EmailType emailType;

	public EmailModelQueueItem() {
		super();
	}

	public EmailModelQueueItem(final String emailTo, final String urlConfirmacao) {
		super();
		this.emailTo = emailTo;
		this.urlConfirmacao = urlConfirmacao;
	}

	public EmailModelQueueItem(final String emailTo, final String urlConfirmacao, String receiverNickname) {
		super();
		this.emailTo = emailTo;
		this.urlConfirmacao = urlConfirmacao;
		this.receiverNickname = receiverNickname;
	}

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getUrlConfirmacao() {
		return urlConfirmacao;
	}

	public void setUrlConfirmacao(String urlConfirmacao) {
		this.urlConfirmacao = urlConfirmacao;
	}

	public String getReceiverNickname() {
		return receiverNickname;
	}

	public void setReceiverNickname(String receiverNickname) {
		this.receiverNickname = receiverNickname;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public EmailType getEmailType() {
		return emailType;
	}

	public void setEmailType(EmailType emailType) {
		this.emailType = emailType;
	}

	public String getEmailFrom() {
		return emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public String getSenderNickname() {
		return senderNickname;
	}

	public void setSenderNickname(String senderNickname) {
		this.senderNickname = senderNickname;
	}

}
