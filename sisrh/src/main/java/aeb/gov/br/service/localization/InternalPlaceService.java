package aeb.gov.br.service.localization;

import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeb.gov.br.dao.localization.InternalPlaceDAO;
import aeb.gov.br.model.localization.Building;
import aeb.gov.br.model.localization.InternalPlace;
import aeb.gov.br.model.telephony.Phone;
import aeb.gov.br.model.validators.InternalPlaceValidator;
import aeb.gov.br.service.telephony.PhoneService;

@Service
public class InternalPlaceService {
	
	InternalPlaceDAO internalPlaceDAO;
	InternalPlaceValidator internalPlaceValidator;
	private BuildingService buildingService;
	private PhoneService phoneService;
	
	public List<String> validateFields(InternalPlace internalPlace) {
		List<String> messages = internalPlaceValidator.isInternalPlaceValid(internalPlace);
		return messages;
	}
	
	
	public void insertInternalPlace(InternalPlace internalPlace) {
		Building building = internalPlace.getBuilding();
		Phone phone = internalPlace.getPhone();
		//Check if building exists, insert on db and update object
		if(building.getId() == 0){
			building.setId(null);
			Building newBuilding = insertBuilding(building);
			internalPlace.setBuilding(newBuilding);
		}
		//Check if Ramal exists, insert on db and update object
		if(phone != null && phone.getNumber() != null && (!phone.getNumber().isEmpty())){
			phone.setId(null);
			Phone newPhone = insertPhone(phone);
			internalPlace.setPhone(newPhone);
		}
		else{
			internalPlace.setPhone(null);
		}
		save(internalPlace);
	}
	

	private void save(InternalPlace internalPlace){
		internalPlaceDAO.save(internalPlace);
	}
	
	private Building insertBuilding(Building building){
		return buildingService.insertBuilding(building);
	}
	
	private Phone insertPhone(Phone phone){
		return phoneService.insertPhone(phone);
	}
	
	@Autowired
	public void setInternalPlaceValidator(InternalPlaceValidator internalPlaceValidator) {
		this.internalPlaceValidator = internalPlaceValidator;
	}

	@Autowired
	public void setBuildingService(BuildingService buildingService) {
		this.buildingService = buildingService;
	}

	@Autowired
	public void setPhoneService(PhoneService phoneService) {
		this.phoneService = phoneService;
	}

	@Autowired
	public void setInternalPlaceDAO(InternalPlaceDAO internalPlaceDAO) {
		this.internalPlaceDAO = internalPlaceDAO;
	}
}
