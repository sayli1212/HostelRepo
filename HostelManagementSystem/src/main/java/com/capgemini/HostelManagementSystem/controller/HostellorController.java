package com.capgemini.HostelManagementSystem.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.HostelManagementSystem.Exception.HostellorNotFoundException;
import com.capgemini.HostelManagementSystem.Service.HostellorService;
import com.capgemini.HostelManagementSystem.entity.Hostellor;
import com.capgemini.HostelManagementSystem.repository.HostellorRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/")
public class HostellorController {

	@Autowired
	HostellorService hostellorService;
	
	@Autowired
	HostellorRepository hostellorRepo;
	@PostMapping("/hostellor")
	private int addHostellor(@RequestBody Hostellor hostellor)
		{
		hostellorService.saveorUpdate(hostellor);
			return hostellor.getId();
	  }
	
	@DeleteMapping("/hostellor/{id}")
	private void deleteHostellorById(@PathVariable("id") int id)
			{
		Hostellor h=hostellorRepo.findById(id)
				.orElseThrow(() -> new HostellorNotFoundException("Hostellor not exists with id :" + id));
		hostellorService.delete(id);
			}
	
	@PutMapping("/hostellor/{id}")
	public  ResponseEntity <Hostellor> updateHosteller( @PathVariable int id,@RequestBody Hostellor hostellor) 
	{
		Hostellor h=hostellorRepo.findById(id)
				.orElseThrow(() -> new HostellorNotFoundException("Hostellor not exists with id :" + id));

    
    h.setHostellorname(hostellor.getHostellorname());
    h.setCollegename(hostellor.getCollegename());
    h.setAge(hostellor.getAge());
    h.setRoomno(hostellor.getRoomno());
    Hostellor updatedHostellor=hostellorRepo.save(h);
   	return ResponseEntity.ok(updatedHostellor);
	
	}
	
	
	@GetMapping("/hostellor")
	private List<Hostellor> getAllHostellors() 
	{
		return hostellorService.getAllHostellors();
	}
	
	@GetMapping("/hostellor/{id}")
	public Hostellor getHostellorById(@PathVariable("id") int id) 
	{
		Hostellor h=hostellorService.getHostellorById(id);
		return h;
	}
}

