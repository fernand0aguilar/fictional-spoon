package aeb.gov.br.dao.telephony;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import aeb.gov.br.model.telephony.Phone;
import aeb.gov.br.model.telephony.PhoneCategory;

@Repository
public interface PhoneDAO extends CrudRepository<Phone, Long> {

	Iterable<Phone> findAllByPhoneCategory(PhoneCategory phoneCategory);

	Phone findByNumber(String number);

}
