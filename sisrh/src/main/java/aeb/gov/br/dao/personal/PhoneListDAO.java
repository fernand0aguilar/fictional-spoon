package aeb.gov.br.dao.personal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import aeb.gov.br.model.personal.Employee;

@Repository
public interface PhoneListDAO extends CrudRepository<Employee, Long> {

	final static String PHONE_LIST_QUERY = ""
    + "SELECT "
    + "    employee.*, "
    + "    directory.*, "
    + "    coordination.*, "
    + "    division.*, "
    + "    role.*, "
    + "    publicEmployee.*, "
    + "    publicCompany.* "
    + "FROM "
    + "    funcionario as employee "
    + "        LEFT JOIN diretoria as directory "
    + "ON employee.id_diretoria = directory.id_diretoria "
    + "        LEFT JOIN coordenacao as coordination "
    + "            ON employee.id_coordenacao = coordination.id_coordenacao "
    + "        LEFT JOIN divisao as division "
    + "            ON employee.id_divisao = division.id_divisao "
    + "        LEFT JOIN cargo_funcionario as role "
    + "            ON employee.id_cargo_funcionario = role.id_cargo_funcionario "
    + "        LEFT JOIN categoria_funcionario as category "
    + "            ON employee.id_categoria_funcionario = category.id_categoria_funcionario "
    + "        LEFT JOIN servidor as publicEmployee "
    + "            ON employee.id_servidor = publicEmployee.id_servidor "
    + "        LEFT JOIN orgao as publicCompany "
    + "            ON publicEmployee.id_orgao = publicCompany.id_orgao "
    + "    WHERE ( "
    + "        COALESCE('-' || LOWER(employee.dsc_cpf), '') "
    + "        ||' ' "
    + "        ||COALESCE('-' || LOWER(employee.dsc_nome), '') "
    + "        ||' ' "
    + "        ||COALESCE('-' || LOWER(employee.dsc_email), '') "
    + "        ||' ' "
    + "        ||COALESCE('-' || LOWER(employee.dsc_login_rede), '') "
    + "        ||' ' "
    + "        ||COALESCE('-' || LOWER(directory.dsc_sigla), '') "
    + "        ||' ' "
    + "        ||COALESCE('-' || LOWER(coordination.dsc_sigla), '') "
    + "        ||' ' "
    + "        ||COALESCE('-' || LOWER(division.dsc_sigla), '') "
    + "        ||' ' "
    + "        ||COALESCE('-' || LOWER(employee.dsc_cpf), '') "
    + "    ) "
    + "LIKE CONCAT('%', LOWER(:QUERY), '%')";


	@Query(value = PHONE_LIST_QUERY, nativeQuery = true)
	public List<Employee> getPhoneListEntries(@Param("QUERY") String query);

}
