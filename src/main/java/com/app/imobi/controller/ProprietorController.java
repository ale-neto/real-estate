package com.app.imobi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.imobi.model.Proprietor;
import com.app.imobi.repository.ProprietorRepository;


@Controller
public class ProprietorController {
	
	@Autowired
	ProprietorRepository proprietorRespository;
	
	@RequestMapping(value="/")
	public String list(Model model){
		Iterable<Proprietor> proprietors = proprietorRespository.findAll();
		model.addAttribute("proprietor", proprietors);
		return "proprietor/list";
	}
	
	@RequestMapping(value="/createProprietor", method=RequestMethod.GET)
	public String create(){
		return "proprietor/create";
	}
	
	@RequestMapping(value="/createProprietor", method=RequestMethod.POST)
	public String create(Proprietor proprietor){
		proprietorRespository.save(proprietor);
		return "redirect:/createProprietor";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable("id") long id, Model model){
		Proprietor proprietor = proprietorRespository.findById(id);
		model.addAttribute("proprietor", proprietor);
		return "proprietor/edit";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public String edit(@PathVariable("id") long id, @Valid Proprietor proprietor, BindingResult result, Model model){
		proprietor.setId(id);
		proprietorRespository.save(proprietor);
		return "redirect:/";	
	}

	@RequestMapping(value="/delete/{id}")
	public String delete(@PathVariable("id") long id){
		Proprietor proprietor =  proprietorRespository.findById(id);
		proprietorRespository.delete(proprietor);
		return "redirect:/";
	}
}
