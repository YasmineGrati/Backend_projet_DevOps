package com.esprit.examen.services;

import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.examen.entities.DetailFacture;
import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.Operateur;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.DetailFactureRepository;
import com.esprit.examen.repositories.FactureRepository;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.repositories.OperateurRepository;
import com.esprit.examen.repositories.ProduitRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class FactureServiceImpl implements IFactureService {

	@Autowired
	FactureRepository factureRepository;

	@Autowired
	DetailFactureRepository detailFactureRepository;

	
	@Override
	public List<Facture> retrieveAllFactures() {
		List<Facture> factures = (List<Facture>) factureRepository.findAll();
		return factures;
	}

	
	public Facture addFacture(Facture f) {
		return factureRepository.save(f);
	}

	@Override
	public void cancelFacture(Long factureId) {
		// Méthode 01
		Facture facture = factureRepository.findById(factureId).orElse(new Facture());
		facture.setArchivee(true);
		factureRepository.save(facture);
		//Méthode 02 (Avec JPQL)
		factureRepository.updateFacture(factureId);
	}

	@Override
	public Facture retrieveFacture(Long factureId) {
		Facture facture = factureRepository.findById(factureId).orElse(null);
		return facture;
	}


}