package com.bbs.app.postpage.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbs.app.postpage.entity.ContentEntity;
import com.bbs.app.postpage.entity.ContentPk;
import com.bbs.app.postpage.form.ContentForm;
import com.bbs.app.postpage.service.PostPageService;
import com.bbs.app.selection_bbs.service.BbsService;
import com.bbs.common.JsonUtil;

@Controller
public class PostPageController {

	@Autowired
	private BbsService bbsService;

	@Autowired
	private PostPageService postPageService;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	@PostMapping("/loadPostPage")
	@ResponseBody
	public String loadPostPage(@RequestBody String json) {

		var form = JsonUtil.parse(ContentForm.class, json);

		var contents = bbsService.getContents(form.getBbsId());

		var formList = contents.stream()
				.collect(
						() -> new ArrayList<ContentForm>(),
						(list, entity) -> list.add(new ContentForm(entity.getContentPk().getBbsId(), entity.getContentPk().getNo(), entity.getContributor(), dateFormat.format(entity.getDate()), entity.getText())),
						(list, forms) -> list.addAll(forms));

	    String resultJson = JsonUtil.convert(formList);
		System.out.println(resultJson);

	    return resultJson;
	}

	@PostMapping("/addPostItem")
	@ResponseBody
	public String addPostItem(@RequestBody String json) {

		var form = JsonUtil.parse(ContentForm.class, json);

		var id = form.getBbsId();
		var bbsEntity = bbsService.findById(id).get();
		var currentNo = bbsEntity.getCurrentNo();
		var no = ++currentNo;

		var entity = new ContentEntity();
		try {
			entity.setContentPk(new ContentPk(id, no));
			entity.setContributor(form.getContributor());
			entity.setDate(dateFormat.parse(form.getDate()));
			entity.setText(form.getText());
			entity.setBbsEntity(bbsEntity);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		postPageService.add(entity);
		bbsEntity.setCurrentNo(no);
		bbsService.update(bbsEntity);

		form.setNo(no);
	    String resultJson = JsonUtil.convert(form);
		System.out.println(resultJson);

		return resultJson;
	}

	@PostMapping("/deletePostItem")
	@ResponseBody
	public String deletePostItem(@RequestBody String json) {

		var form = JsonUtil.parse(ContentForm.class, json);

		postPageService.delete(form.getBbsId(), form.getNo());

	    String resultJson = JsonUtil.convert(form);
		System.out.println(resultJson);

		return resultJson;
	}

	@PostMapping("/editPostItem")
	@ResponseBody
	public String editPostItem(@RequestBody String json) {

		var form = JsonUtil.parse(ContentForm.class, json);
		var id = form.getBbsId();
		var bbsEntity = bbsService.findById(id).get();
		var no = form.getNo();

		var entity = new ContentEntity();
		try {
			entity.setContentPk(new ContentPk(id, no));
			entity.setContributor(form.getContributor());
			entity.setDate(dateFormat.parse(form.getDate()));
			entity.setText(form.getText());
			entity.setBbsEntity(bbsEntity);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		postPageService.update(entity);

	    String resultJson = JsonUtil.convert(form);
		System.out.println(resultJson);

		return resultJson;
	}

}
