package br.unifor.pin5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import br.unifor.pin5.entity.Obra;
import br.unifor.pin5.entity.User;
import br.unifor.pin5.repository.ObraRepository;
import br.unifor.pin5.repository.PatrocinadorRepository;
import br.unifor.pin5.repository.UserRepository;

@Service
public class ObraService {

	@Autowired
	private ObraRepository obraRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PatrocinadorRepository patrocinadorRepository;

	
	public List<Obra> findAll() {

		return obraRepository.findAll();
	}
	
	
	public void save(Obra obra, String name) {

		User user = userRepository.findByName(name);
		obra.setUser(user);
		obraRepository.save(obra);
		

	}

	


}
