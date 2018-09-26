package aeb.gov.br.dao.personal.education;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import aeb.gov.br.model.personal.education.EducationLevel;

@Repository
public interface EducationalLevelDAO extends PagingAndSortingRepository<EducationLevel, Long> {

}
