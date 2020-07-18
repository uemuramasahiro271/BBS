package com.bbs.app.selection_bbs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bbs.app.selection_bbs.entity.BbsEntity;
import com.bbs.app.selection_bbs.form.BbsForm;
import com.bbs.app.selection_bbs.form.BbsSearchConditionForm;
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

    @GetMapping("/loadBbs")
    @ResponseBody
    public String load() {

    	var formList = convertBbsEntityToForm(bbsService.findAll());

	    String json = JsonUtil.convert(formList);
		System.out.println(json);

	    return json;
    }

    @PostMapping("/searchBbs")
    @ResponseBody
    public String searchBbs(@RequestBody String param) {

    	var form = JsonUtil.parse(BbsSearchConditionForm.class, param);

    	var entityList = bbsService.findBbs(form.getTitleCondition());
    	var formList = convertBbsEntityToForm(entityList);
	    String json = JsonUtil.convert(formList);
		System.out.println(json);

	    return json;
    }

    @GetMapping("/postPage")
    public ModelAndView postPage() {

    	var mv = new ModelAndView();
    	mv.setViewName("postPage");

    	return mv;
    }

    private List<BbsForm> convertBbsEntityToForm(List<BbsEntity> entityList) {
		var list = new ArrayList<BbsForm>();
		for(BbsEntity entity : entityList) {
			var form = new BbsForm();
			form.setId(entity.getId());
			form.setTitle(entity.getTitle());
			form.setCurrentNo(entity.getCurrentNo());
			list.add(form);
		}

		return list;
    }
}
