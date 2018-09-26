package aeb.gov.br.dao.outter;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aeb.gov.br.model.outter.PublicCompany;

@Repository
public interface PublicCompanyDAO extends CrudRepository<PublicCompany, Long> {

}
