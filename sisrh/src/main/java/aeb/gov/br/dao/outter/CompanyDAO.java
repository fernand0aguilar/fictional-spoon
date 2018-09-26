package aeb.gov.br.dao.outter;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aeb.gov.br.model.outter.Company;

@Repository
public interface CompanyDAO extends CrudRepository<Company, Long> {

}
