package aeb.gov.br.service.localization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeb.gov.br.dao.localization.CityDAO;
import aeb.gov.br.model.localization.City;
import aeb.gov.br.model.localization.UF;

@Service
public class CityService {
	private CityDAO cityDao;

	public City find(Long id) {
		return cityDao.findOne(id);
	}

	public Iterable<City> getCityFromUf(Long id) {
		
		return cityDao.findAllByUfOrderByNameAsc(new UF(id));
	}

	@Autowired
	public void setCityDao(CityDAO cityDao) {
		this.cityDao = cityDao;
	}

}
