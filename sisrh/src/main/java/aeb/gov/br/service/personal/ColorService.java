package aeb.gov.br.service.personal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aeb.gov.br.dao.personal.ColorDAO;
import aeb.gov.br.model.personal.Color;

@Service
@Transactional
public class ColorService {
	private ColorDAO colorDAO;

	public Iterable<Color> getColors() {
		return colorDAO.findAll();
	}

	@Autowired
	public void setColorDAO(ColorDAO colorDAO) {
		this.colorDAO = colorDAO;
	}

}
