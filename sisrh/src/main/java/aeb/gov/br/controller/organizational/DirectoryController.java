package aeb.gov.br.controller.organizational;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aeb.gov.br.controller.BaseController;
import aeb.gov.br.model.organizational.Directory;
import aeb.gov.br.service.organizational.DirectoryService;

@RestController
@Scope("request")
@RequestMapping("/directory")
public class DirectoryController extends BaseController {

	private DirectoryService directoryService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Iterable<Directory>> listDirectories() {
		return new ResponseEntity<Iterable<Directory>>(directoryService.findAll(), HttpStatus.OK);
	}

	@Autowired
	public void setDirectoryService(DirectoryService directoryService) {
		this.directoryService = directoryService;
	}

}
