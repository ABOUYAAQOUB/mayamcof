package com.mayamcof.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mayamcof.IService.ICommande;
import com.mayamcof.Repository.CommandeRepository;
import com.mayamcof.model.Commande;

@Service
public class CommandeService implements ICommande{

	private CommandeRepository commandeRepository;
	
	public CommandeService(CommandeRepository commandeRepository) {
		
		this.commandeRepository = commandeRepository;
	}

	@Override
	public List<Commande> getAll() {
		
		return this.commandeRepository.findAll();
	}

	@Override
	public Commande getCommande(Long id) {
		
		return this.commandeRepository.findById(id).get();
	}

	@Override
	public Commande create(Commande commande) {
		
		return this.commandeRepository.save(commande);
	}

	@Override
	public Commande update(Commande commande) {
		
		Commande commandeUpdated = this.commandeRepository.findById(commande.getId()).get();
		
		commandeUpdated.setDatecommande(commande.getDatecommande());
		commandeUpdated.setFournisseur(commande.getFournisseur());
		commandeUpdated.setDetailCommandes(commande.getDetailCommandes());
		
		return this.commandeRepository.save(commandeUpdated);
	}

	@Override
	public void delete(Long id) {
		
		this.commandeRepository.delete(this.commandeRepository.findById(id).get());
	}

}
