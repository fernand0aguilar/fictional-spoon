package aeb.gov.br.dao.personal;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import aeb.gov.br.model.personal.MaritalStatus;

@Repository
public interface MaritalStatusDAO extends PagingAndSortingRepository<MaritalStatus, Long> {

}
