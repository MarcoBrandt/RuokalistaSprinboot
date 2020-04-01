package fi.hh.projekti.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.hh.projekti.domain.Projekti;
import fi.hh.projekti.domain.ProjektiRepository;

@Controller
public class ProjektiController {

	@Autowired
	private ProjektiRepository repository;

    // Login form
    @RequestMapping("/login.html")
    public String login() {
      return "login.html";
    }
	
	@RequestMapping(value= { "/", "/projektilista"})
	public String projektiLista(Model model) {
		model.addAttribute("projektit", repository.findAll());
		return "projektilista";
	}
	
	// Poistaminen, vain ADMIN voi tehdä
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET) 
	public String deleteProjekti(@PathVariable("id") Long projektiId, Model model) {
		System.out.println("Poistettu id: " + projektiId);
		repository.deleteById(projektiId);
		return "redirect:../projektilista";
	}

	// Lisääminen, vain ADMIN voi tehdä
	
	@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/add")
    public String addProjekti(Model model){
    	model.addAttribute("projekti", new Projekti());
        return "addprojekti";
    }     
     
    // Tallentaminen
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@Valid Projekti projekti, BindingResult bindingResult, Model model){
        
        if (bindingResult.hasErrors()) {
        	System.out.println("Virheellinen tuotelisäys");
        	return "addprojekti";
        }
 
    	repository.save(projekti);
    	System.out.println("Uusi tuote lisätty: " + projekti);
        return "redirect:projektilista";
    }   
	  
	// REST
    @RequestMapping(value="/projektis")
    public @ResponseBody List<Projekti> studentListRest() {	
        return (List<Projekti>) repository.findAll();
    }    

    @RequestMapping(value="/projekti/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Projekti> findProjektiRest(@PathVariable("id") Long projektiId) {	
    	return repository.findById(projektiId);
    }  
    
    
}
	

