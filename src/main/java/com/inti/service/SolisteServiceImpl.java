package com.inti.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.inti.model.Soliste;
import com.inti.repository.SolisteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolisteServiceImpl implements ISolisteService {
	
	@Autowired
	SolisteRepository solisteRepository;

	@Override
	public List<Soliste> getAllSoliste() {
		return solisteRepository.findAll();
	}

	@Override
	public Soliste saveSoliste(Soliste s) {
		if (Objects.nonNull(s)) {
			return solisteRepository.save(s);
		}
		return null;
	}

	@Override
	public Soliste getSoliste(Long id) {
		Optional<Soliste> s = Optional.of(solisteRepository.findById(id).orElse(null));
		return s.get();
	}

	@Override
	public boolean updateSoliste(Soliste s) {
		if (Objects.nonNull(s)) {
			solisteRepository.save(s);
			return true;
		}
		return false;
	}

	@Override
	public void deleteSoliste(Long id) {
		if (Objects.nonNull(id)) {
			solisteRepository.deleteById(id);
		}
	}

}
