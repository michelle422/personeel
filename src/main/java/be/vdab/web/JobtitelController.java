package be.vdab.web;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.JobtitelService;

@Controller
@RequestMapping(path = "/jobtitels", produces = MediaType.TEXT_HTML_VALUE)
public class JobtitelController {
	private static final String JOBTITELS_VIEW = "jobtitels/jobtitels";
	private final JobtitelService jobtitelService;
	
	JobtitelController(JobtitelService jobtitelService) {
		this.jobtitelService = jobtitelService;
	}

	@GetMapping
	ModelAndView findAll() {
		return new ModelAndView(JOBTITELS_VIEW, "jobtitels", jobtitelService.findAll());
	}
	
	@InitBinder("jobtitels")
	void initBinderFiliaal(WebDataBinder binder) {
		binder.initDirectFieldAccess();
	}
}
