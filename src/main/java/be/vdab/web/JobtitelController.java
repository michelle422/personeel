package be.vdab.web;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Jobtitel;
import be.vdab.services.JobtitelService;
import be.vdab.services.WerknemerService;

@Controller
@RequestMapping(path = "/jobtitels", produces = MediaType.TEXT_HTML_VALUE)
public class JobtitelController {
	private static final String JOBTITELS_VIEW = "jobtitels/jobtitels";
	private final JobtitelService jobtitelService;
	private final WerknemerService werknemerService;
	
	JobtitelController(JobtitelService jobtitelService, 
			WerknemerService werknemerService) {
		this.jobtitelService = jobtitelService;
		this.werknemerService = werknemerService;
	}

	@GetMapping
	ModelAndView findAll() {
		return new ModelAndView(JOBTITELS_VIEW, "jobtitels", jobtitelService.findAll());
	}
	
	@GetMapping("{jobtitel}")
	ModelAndView findWerknemersByJobtitel(@PathVariable Jobtitel jobtitel) {
		ModelAndView modelAndView = new ModelAndView(JOBTITELS_VIEW)
				.addObject("jobtitels", jobtitelService.findAll())
				.addObject("jobtitel", jobtitel);
		modelAndView.addObject("werknemers", werknemerService.findWerknemersByJobtitel(jobtitel));
		return modelAndView;
	}
	
	@InitBinder("jobtitels")
	void initBinderFiliaal(WebDataBinder binder) {
		binder.initDirectFieldAccess();
	}
}
