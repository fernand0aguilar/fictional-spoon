package aeb.gov.br.service.organizational;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeb.gov.br.dao.organizational.DirectoryDAO;
import aeb.gov.br.model.organizational.Directory;

@Service
public class DirectoryService {
	private DirectoryDAO directoryDAO;

	public Iterable<Directory> findAll() {
		return directoryDAO.findAll();
	}

	@Autowired
	public void setDirectoryDAO(DirectoryDAO directoryDAO) {
		this.directoryDAO = directoryDAO;
	}

}
