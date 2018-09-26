package aeb.gov.br.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionAttributeService {

	private HttpServletRequest request;

	@Autowired
	public void setRequest(final HttpServletRequest request) {
		this.request = request;
	}

	public SessionAttributeService() {
		super();
	}

	/**
	 * 
	 * @param usuarioSessao
	 */
	public void iniciarSessao(final UserSession usuarioSessao) {
		final HttpSession newSession = request.getSession(true);
		newSession.setAttribute(UserSessionFactory.AEB_SESSION_USER, usuarioSessao);
	}

	/**
	 * 
	 */
	public void finalizarSessao() {
		final HttpSession currentSession = request.getSession(false);
		if (currentSession != null) {
			currentSession.invalidate();
		}
	}

	/**
	 * 
	 * @param nomeAtributo
	 * @param valorAtributo
	 */
	public void adicionarAtributo(final String nomeAtributo, final Object valorAtributo) {
		final HttpSession currentSession = request.getSession(false);
		if (currentSession != null) {
			currentSession.setAttribute(nomeAtributo, valorAtributo);
		}
	}

}