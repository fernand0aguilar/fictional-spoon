package aeb.gov.br.service.telephony;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aeb.gov.br.dao.telephony.PhoneDAO;
import aeb.gov.br.model.localization.UF;
import aeb.gov.br.model.telephony.Phone;
import aeb.gov.br.model.telephony.PhoneCategory;

@Service
@Transactional
public class PhoneService {

	private PhoneDAO phoneDAO;

	public Phone createPhone(Phone phone) {
		return phoneDAO.save(phone);
	}
	
	public Iterable<Phone> getAllPhone() {
		return phoneDAO.findAll();
	}

	public Phone insertPhone(Phone phone) {
		return phoneDAO.save(phone);	
	}
	
	public Phone getPhoneByNumber(String number) {
		return phoneDAO.findByNumber(number);
	}
	
	public Iterable<Phone> getAllRamal() {
		PhoneCategory phoneCategory = new PhoneCategory();
		phoneCategory.setId((long) 4);
		return phoneDAO.findAllByPhoneCategory(phoneCategory);
	}
	
	@Autowired
	public void setPhoneDAO(PhoneDAO phoneDAO) {
		this.phoneDAO = phoneDAO;
	}

}
