package com.inti.service;

import java.util.List;

import com.inti.model.Soliste;

import org.springframework.stereotype.Service;

@Service
public interface ISolisteService {
	
	public List<Soliste> getAllSoliste();
	public Soliste saveSoliste(Soliste s);
	public Soliste getSoliste(Long id);
	public boolean updateSoliste(Soliste s);
	public void deleteSoliste(Long id);

}
