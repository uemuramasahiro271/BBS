package com.bbs.app.selection_bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SelectionBbsController {

	//@Autowired
	//AccountRepository accountRepository;

    @GetMapping("/")
    public ModelAndView index(ModelAndView mv) {

		mv.setViewName("index");
    	mv.addObject("msg", "Hello World");

        return mv;
    }

	/*    @RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test() {
		var list = accountRepository.findAll();
	}*/
}
