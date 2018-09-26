package aeb.gov.br.service.education;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aeb.gov.br.dao.personal.education.EducationalBackgroundDAO;
import aeb.gov.br.model.personal.education.EducationalBackground;

@Service
@Transactional
public class EducationalBackgroundService {

	private EducationalBackgroundDAO educationalBackgroundDAO;

	public EducationalBackground insert(EducationalBackground educationalBackground) {
		return educationalBackgroundDAO.save(educationalBackground);
	}
	
	public Iterable<EducationalBackground> listEducationalBackground(Long employeeId) {
		return educationalBackgroundDAO.findByEmployee_id(employeeId);
	}
	
	public EducationalBackground edit(EducationalBackground educationalBackground){
		return educationalBackgroundDAO.save(educationalBackground);
	}

	
	public void delete(EducationalBackground educationalBackground){
		educationalBackgroundDAO.delete(educationalBackground);
	}
	
	@Autowired
	public void setEducationalBackgroundDAO(EducationalBackgroundDAO educationalBackgroundDAO) {
		this.educationalBackgroundDAO = educationalBackgroundDAO;
	}

	

}
