package aeb.gov.br.dao.personal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aeb.gov.br.model.personal.Employee;
import aeb.gov.br.model.personal.Hobbie;

@Repository
public interface HobbieDAO extends CrudRepository<Hobbie, Long> {

	public Iterable<Hobbie> findAllByEmployee(Employee employee);

}
