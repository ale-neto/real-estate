package com.app.imobi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.imobi.model.Immobile;
import com.app.imobi.model.Proprietor;
import com.app.imobi.repository.ImmobileRepository;
import com.app.imobi.repository.ProprietorRepository;

@Controller
public class ImmobileController {

	@Autowired
	ImmobileRepository immobileRespository;
	
	@Autowired
	ProprietorRepository proprietorRespository;
	
	@RequestMapping(value="/view/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable("id") long id, Model model){
		Proprietor proprietor = proprietorRespository.findById(id);
		model.addAttribute("proprietor", proprietor);
		Iterable<Immobile> immobile = immobileRespository.findByProprietor(proprietor);
		model.addAttribute("immobile", immobile);
		return "immobile/view";
	}
	
	@RequestMapping(value="/view/{id}", method=RequestMethod.POST)
	public String edit(@PathVariable("id") long id, @Valid Immobile immobile, BindingResult result, RedirectAttributes attributes){
		Proprietor proprietor = proprietorRespository.findById(id);
		immobile.setProprietor(proprietor);
		immobile.setTotalArea(immobile.getLandArea() + immobile.getBuildingArea());
		immobile.setTotalVenalValue(immobile.getLandVenalValue() + immobile.getLandArea());
		immobile.setTaxAmount(immobile.getTotalVenalValue() * immobile.getAliquot());
		immobileRespository.save(immobile);
		return "redirect:/view/{id}";
	}
	
	@RequestMapping(value="/deleteImmobile/{id}")
	public String delete(@PathVariable("id") long id){
		Immobile immobile = immobileRespository.findById(id);
		immobileRespository.delete(immobile);
		Proprietor proprietor = immobile.getProprietor();
		long idProprietor = proprietor.getId();
		String idString = "" + idProprietor;
		return "redirect:/view/" + idString;
	}
	
}
