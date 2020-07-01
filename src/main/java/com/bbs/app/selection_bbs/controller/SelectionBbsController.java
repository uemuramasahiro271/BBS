package com.bbs.app.selection_bbs.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bbs.app.selection_bbs.entity.BbsEntity;
import com.bbs.app.selection_bbs.form.BbsForm;
import com.bbs.app.selection_bbs.service.BbsService;
import com.bbs.common.JsonUtil;

@Controller
public class SelectionBbsController {

	@Autowired
	private BbsService bbsService;

    @GetMapping("/")
    public ModelAndView index(ModelAndView mv) {

		mv.setViewName("index");
        return mv;
    }

    @GetMapping("/load")
    @ResponseBody
    public String load() {

		var list = new ArrayList<BbsForm>();
		for(BbsEntity entity : bbsService.findAll()) {
			var form = new BbsForm();
			form.setId(entity.getId());
			form.setTitle(entity.getTitle());
			form.setCurrentNo(entity.getCurrentNo());
			list.add(form);
		}

	    String json = JsonUtil.convert(list);
		System.out.println(json);

	    return json;
    }

}
