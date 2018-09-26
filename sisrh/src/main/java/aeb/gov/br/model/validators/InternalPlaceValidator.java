package aeb.gov.br.model.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import aeb.gov.br.model.localization.Building;
import aeb.gov.br.model.localization.InternalPlace;
import aeb.gov.br.util.StringUtil;

@Component
public class InternalPlaceValidator {
	private InternalPlace internalPlace;
	private List<String> errorMessages;
	
	public List<String> validateEmptyFields() {
		
		List<String> messages = new ArrayList<String>();

		if (StringUtil.isEmpty(internalPlace.getRoomNumber())) {
			messages.add("O campo de número da sala não foi informado");
		} else {
			// Do nothing
		}
		
		if (internalPlace.getBuilding() == null) {
			messages.add("O prédio deve ter sido selecionado ou preenchido");
		} else {
			// Do nothing
		}
		return messages;
	}
	
	public List<String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages() {
		this.errorMessages = validateEmptyFields();
	}

	public List<String> isInternalPlaceValid(InternalPlace internalPlace) {
		this.internalPlace = internalPlace;
		return validateEmptyFields();
	}
	
}
