package aeb.gov.br.dao.organizational;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aeb.gov.br.model.organizational.Directory;
import aeb.gov.br.model.personal.Employee;

@Repository
public interface DirectoryDAO extends CrudRepository<Directory, Long> {

	Directory findByDirector(Employee boss);

}
