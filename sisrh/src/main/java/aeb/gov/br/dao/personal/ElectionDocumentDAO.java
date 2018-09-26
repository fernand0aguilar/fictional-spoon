package aeb.gov.br.dao.personal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aeb.gov.br.model.personal.ElectionDocument;

@Repository
public interface ElectionDocumentDAO extends CrudRepository<ElectionDocument, Long> {

}
