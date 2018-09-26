package aeb.gov.br.dao.localization;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aeb.gov.br.model.localization.Address;

@Repository
public interface AddressDAO extends CrudRepository<Address, Long> {

}
