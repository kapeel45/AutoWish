package com.pongo.autowish.document;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pongo.autowish.auto.car.Car;
import com.pongo.autowish.auto.car.CarDto;
import com.pongo.autowish.auto.car.CarRepository;
import com.pongo.autowish.auto.car.FuelType;
import com.pongo.autowish.auto.car.Transmission;
import com.pongo.autowish.user.User;
import com.pongo.autowish.user.UserRepository;

@Service
public class DocumentService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DocumentRepository docRepo;
	
	@Autowired
	UserRepository userRepo;
	
	public Document addDocument(DocumentDto docDto) {
		
		try {
			Optional<User> user = userRepo.findById(Long.parseLong(docDto.getUserId()));
			
			if(user.isPresent()) {
				log.info("User found :: "+user.get().getUserId());
				
				Document doc = new Document();
				doc.setDocumentBackImage(docDto.getDocumentBackImage());
				doc.setDocumentFrontImage(docDto.getDocumentFrontImage());
				doc.setDocumentName(doc.getDocumentName());
				
				doc.setUser(user.get());
				
				return docRepo.save(doc);
			}
			else {
				log.error("user not found or not available:: userId:"+docDto.getUserId());
			}
		}
		catch(Exception e) {
			log.error("Exception:: "+e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}

	public Document getDocument(String id) {
		try {
			Optional<Document> doc = docRepo.findById(Long.parseLong(id));
			
			if(doc.isPresent()) {
				log.info("Document found :: carId: "+doc.get().getId());
				return doc.get();
			}else {
				log.error("No such document found error:: carId:"+id);
			}
		}catch(Exception e) {
			log.error("Exception :: "+e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public List<Document> getAllDocuments() {
		try {
			List<Document> lstDoc = docRepo.findAll();
			
			if(!lstDoc.isEmpty()) {
				log.info("All Document found");
				return lstDoc;
			}
		}catch(Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}

	
}
