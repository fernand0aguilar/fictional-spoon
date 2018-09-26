package aeb.gov.br.dao.localization;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aeb.gov.br.model.localization.Building;

@Repository
public interface BuildingDAO extends CrudRepository<Building, Long> {

	Building findByNome(String nome);

}
