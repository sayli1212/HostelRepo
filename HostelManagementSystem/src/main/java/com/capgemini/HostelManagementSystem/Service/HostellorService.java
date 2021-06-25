package com.capgemini.HostelManagementSystem.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.HostelManagementSystem.Exception.HostellorNotFoundException;
import com.capgemini.HostelManagementSystem.entity.Hostellor;
import com.capgemini.HostelManagementSystem.repository.HostellorRepository;
@Service
public class HostellorService {

	@Autowired
	HostellorRepository hostellorRepo;
	
	public void saveorUpdate(Hostellor hostellor)
	{
		hostellorRepo.save(hostellor);
	}
	
	public void delete(int id) {
		hostellorRepo.deleteById(id);
	}
	
	public void update( int id,Hostellor hostellor) 
	{
		Hostellor h= hostellorRepo.findById(id)
				.orElseThrow(() -> new HostellorNotFoundException("no hostellor present with id : "+id));
		hostellorRepo.save(h);
	}

	public List<Hostellor> getAllHostellors() 
	{
		List<Hostellor> hostellor = new ArrayList<Hostellor>();
		hostellorRepo.findAll().forEach(hostellor1 -> hostellor.add(hostellor1));
		return hostellor;
	}
    
	public Hostellor getHostellorById(int id) 
	{

		Hostellor h= hostellorRepo.findById(id)
				.orElseThrow(() -> new HostellorNotFoundException("no hostellor present with id : "+id));
		return h;
		
	}
	
}
