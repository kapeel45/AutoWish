package com.pongo.autowish.document;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/document")
public class DocumentController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DocumentService docService;
	
	@PostMapping("/add")
	public @ResponseBody ResponseEntity<Document> addDocument(@RequestBody DocumentDto docDto) {
		Document doc = docService.addDocument(docDto);
		if(doc != null) {
			return new ResponseEntity<Document>(doc, HttpStatus.CREATED);
		}
		return new ResponseEntity<Document>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Document> getDocument(@PathVariable String id) {
		
		Document doc = docService.getDocument(id);
		
		if(doc == null) {
			return new ResponseEntity<Document>(HttpStatus.NO_CONTENT);	
		}
		
		return new ResponseEntity<Document>(doc,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public @ResponseBody ResponseEntity<List<Document>> getAllDocument() {
		
		List<Document> lstDoc = docService.getAllDocuments();
		
		if(lstDoc == null) {
			return new ResponseEntity<List<Document>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Document>>(lstDoc,HttpStatus.OK);
	}

}
