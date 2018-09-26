package aeb.gov.br.dao.localization;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aeb.gov.br.model.localization.UF;

@Repository
public interface UFDAO extends CrudRepository<UF, Long> {

}
