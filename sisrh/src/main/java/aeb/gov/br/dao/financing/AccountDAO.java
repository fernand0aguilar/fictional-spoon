package aeb.gov.br.dao.financing;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aeb.gov.br.model.financing.Account;

@Repository
public interface AccountDAO extends CrudRepository<Account, Long> {

}
