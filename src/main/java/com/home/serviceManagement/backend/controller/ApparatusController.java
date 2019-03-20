package com.home.serviceManagement.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.serviceManagement.backend.dto.ApparatusDTO;
import com.home.serviceManagement.backend.service.ApparatusService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/apparatus")
public class ApparatusController {
	@Autowired
	private ApparatusService apparatusService;
	@GetMapping
	public List<ApparatusDTO> findAll(){
		return apparatusService.findAllApparatus();
	}
	
	@GetMapping(value="/{apparatusId}")
	public ApparatusDTO findApparatus(@PathVariable("apparatusId") String apparatusId){
		return apparatusService.findApparatus(apparatusId);
	}
	
	@PutMapping(value="/{apparatusId}")
	public void saveApparatus(@PathVariable("apparatusId") String apparatusId,@RequestBody ApparatusDTO apparatusDTO) {
		apparatusService.save(apparatusId, apparatusDTO);
	}
	
	@PostMapping(value="/{apparatusId}")
	public boolean updateApparatus(@PathVariable("apparatusId") String apparatusId,@RequestBody ApparatusDTO apparatusDTO) {
		return apparatusService.update(apparatusId, apparatusDTO);
	}
	@DeleteMapping(value="/{apparatusId}")
	public boolean deleteApparatus(@PathVariable("apparatusId") String apparatusId) {
		return apparatusService.delete(apparatusId);
	}

	
	
}
