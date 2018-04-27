package be.vdab.web;

import javax.validation.Valid;

import org.springframework.http.MediaType;
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
	private static final String REDIRECT_URL_NA_OPSLAG = "redirect:/";
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
	
	@GetMapping("{werknemer}")
	ModelAndView read(@PathVariable Werknemer werknemer) {
		ModelAndView modelAndView = new ModelAndView(WERKNEMER_VIEW); 
		if (werknemer != null) {
			modelAndView.addObject(werknemer);
		}
		return modelAndView;
	}
	
	@GetMapping("/{werknemer}/opslag")
	ModelAndView opslag(@PathVariable Werknemer werknemer) {
		ModelAndView modelAndView = new ModelAndView(OPSLAG_VIEW);
		modelAndView.addObject(new OpslagForm());
		return modelAndView;
	}
	
	@PostMapping("{werknemer}/opslag")
	ModelAndView opslag(@PathVariable Werknemer werknemer, @Valid OpslagForm opslagForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView(OPSLAG_VIEW);
		}
		werknemerService.opslag(werknemer, opslagForm.getBedrag());
		return new ModelAndView(REDIRECT_URL_NA_OPSLAG);
	}
	
	@InitBinder("werknemer")
	void initBinderFiliaal(WebDataBinder binder) {
		binder.initDirectFieldAccess();
	}
}
