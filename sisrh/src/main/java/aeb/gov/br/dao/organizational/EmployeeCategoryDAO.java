package aeb.gov.br.dao.organizational;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import aeb.gov.br.model.organizational.EmployeeCategory;

@Repository
public interface EmployeeCategoryDAO extends PagingAndSortingRepository<EmployeeCategory, Long> {

}
