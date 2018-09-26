package aeb.gov.br.dao.personal.education;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aeb.gov.br.model.personal.education.EducationalBackground;

@Repository
public interface EducationalBackgroundDAO extends CrudRepository<EducationalBackground, Long> {

	public Iterable<EducationalBackground> findByEmployee_id(Long employeeId);

}
