package aeb.gov.br.service.localization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeb.gov.br.dao.localization.BuildingDAO;
import aeb.gov.br.model.localization.Building;

@Service
public class BuildingService {
	
	private BuildingDAO buildingDAO;

	public Iterable<Building> getAllBuilding() {
		return buildingDAO.findAll();
	}
	
	public Building insertBuilding(Building building) {
		return buildingDAO.save(building);
	}
	
	public Building getBuildingByNome(String nome) {
		return buildingDAO.findByNome(nome);
	}
	
	@Autowired
	public void setBuildingDAO(BuildingDAO buildingDAO) {
		this.buildingDAO = buildingDAO;
	}

}
