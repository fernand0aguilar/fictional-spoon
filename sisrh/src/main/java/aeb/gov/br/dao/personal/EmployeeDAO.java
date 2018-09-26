package aeb.gov.br.dao.personal;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import aeb.gov.br.model.organizational.Coordination;
import aeb.gov.br.model.organizational.Directory;
import aeb.gov.br.model.organizational.Division;
import aeb.gov.br.model.organizational.EmployeeCategory;
import aeb.gov.br.model.organizational.EmployeeRole;
import aeb.gov.br.model.personal.Employee;

@Repository
public interface EmployeeDAO extends PagingAndSortingRepository<Employee, Long> {

	public Employee findByNetworkLogin(String networkLogin);

	public Employee findByNetworkLoginAndActiveTrue(String networkLogin);

	public Employee findByCpf(String cpf);

	public Employee findByRg_rg(String rg);

	public int countByCpf(String cpf);

	@Query(value = "SELECT employee.name, employee.birthDate, employee.networkLogin FROM Employee employee WHERE MONTH(employee.birthDate) = :MONTH")
	public List<Employee> findByMothOfBirthday(@Param("MONTH") int month);

	public Page<Employee> findAll(Pageable pageable);

	@Query(value = "SELECT employee from Employee employee WHERE LOWER(employee.name) LIKE CONCAT('%', LOWER(:NAME), '%')")
	public Page<Employee> findByName(@Param("NAME") String name, Pageable pageable);

	public int countByEmployeeRoleAndActiveTrue(EmployeeRole employeeRole);

	public Iterable<Employee> findAllByEmployeeRoleAndActiveTrue(EmployeeRole role);

	public int countByEmployeeCategoryAndActiveTrue(EmployeeCategory employeeCategory);

	public Iterable<Employee> findAllByEmployeeCategoryAndActiveTrue(EmployeeCategory employeeCategory);

	public Employee findByRg_id(Long id);

	public List<Employee> findAllByCoordination(Coordination coo);

	public List<Employee> findAllByDirectory(Directory dir);

	public List<Employee> findAllByDivision(Division div);
	
	

}
