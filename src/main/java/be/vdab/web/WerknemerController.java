package be.vdab.web;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Werknemer;
import be.vdab.services.WerknemerService;

@Controller
@RequestMapping(path = "/werknemer", produces = MediaType.TEXT_HTML_VALUE)
class WerknemerController {
	private static final String WERKNEMER_VIEW = "werknemers/werknemer";
	private static final String OPSLAG_VIEW = "werknemers/opslag"; 
	private static final String REDIRECT_URL_WERKNEMER_NIET_GEVONDEN = "redirect:/werknemer";
	private static final String REDIRECT_URL_NA_OPSLAG = "redirect:/werknemer";
	private static final String REDIRECT_URL_NA_LOCKING_EXCEPTION = 
			"redirect:/werknemer/{id}?optimisticlockingexception=true"; 
	private final WerknemerService werknemerService;
	
	WerknemerController(WerknemerService werknemerService) {
		this.werknemerService = werknemerService;
	}
	
	@GetMapping
	ModelAndView findByChefIsNull() {
		ModelAndView modelAndView = new ModelAndView(WERKNEMER_VIEW, "werknemer", 
				werknemerService.findByChefIsNull());
		return modelAndView;
	}
	
	@GetMapping("{id}")
	ModelAndView read(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView(WERKNEMER_VIEW);
		werknemerService.read(id)
			.ifPresent(werknemer -> modelAndView.addObject(werknemer));
		return modelAndView;
	}
	
	@GetMapping("{werknemer}/opslag")
	ModelAndView updateForm(@PathVariable Werknemer werknemer) {
		if (werknemer == null) {
			return new ModelAndView(REDIRECT_URL_WERKNEMER_NIET_GEVONDEN);
		}
		return new ModelAndView(OPSLAG_VIEW).addObject(werknemer);
	}
	
	@PostMapping("{id}/opslag")
	String update(@Valid Werknemer werknemer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return OPSLAG_VIEW;
		}
		try {
			werknemerService.update(werknemer);
			return REDIRECT_URL_NA_OPSLAG;
		} catch (ObjectOptimisticLockingFailureException ex) {
			return REDIRECT_URL_NA_LOCKING_EXCEPTION; 
		}
	}
	
	@InitBinder("werknemer")
	void initBinderFiliaal(WebDataBinder binder) {
		binder.initDirectFieldAccess();
	}
}
