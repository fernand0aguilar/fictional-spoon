package aeb.gov.br.service.education;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import aeb.gov.br.dao.personal.education.EducationalLevelDAO;
import aeb.gov.br.model.personal.education.EducationLevel;

@Service
public class EducationalLevelService {

	private EducationalLevelDAO educationalLevelDAO;

	public Iterable<EducationLevel> list() {
		return educationalLevelDAO.findAll(new Sort(Direction.ASC, "level"));
	}

	@Autowired
	public void setEducationalLevelDAO(EducationalLevelDAO educationalLevelDAO) {
		this.educationalLevelDAO = educationalLevelDAO;
	}

}
