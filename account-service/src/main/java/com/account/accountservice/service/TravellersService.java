package com.account.accountservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.accountservice.repository.TravellersRepository;
import com.tourcoreservice.entity.Travellers;
import com.tourcoreservice.util.ObjectMapperUtils;

@Service
public class TravellersService {
	
	@Autowired
	TravellersRepository tRepository;
	
	public Travellers create(Travellers travellers) {
		
		if(this.isuserexist(travellers.getId())) {
			try {
				Travellers travellers1 = this.getById(travellers.getId());
				ObjectMapperUtils.map(travellers, travellers1);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return this.Update(travellers);
		}
		else {
			return tRepository.save(travellers);
		}
		
	}

	public Travellers getById(String googleid) {
		return tRepository.findById(googleid);
	}

	public List<Travellers> listAll() {
		return tRepository.findAll();
	}

	public Travellers Update(Travellers user) {
		return tRepository.save(user);
	}

	public void delete(long id) {
		tRepository.deleteById(id);

	}
	
	public boolean isuserexist(String username) {
        Travellers existUser = tRepository.findById(username);
        if (existUser == null) {
        	return false;    
        }
        else {
        	return true;
        }
         
    }
}
