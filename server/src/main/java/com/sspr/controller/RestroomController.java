package com.sspr.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sspr.domain.RestroomVO;
import com.sspr.service.RestroomService;

@RestController
@RequestMapping("restroom")
public class RestroomController {
	
	@Inject
	private RestroomService restService;
	
	//ȭ��� ����(������, ���� ����...)�� ������Ʈ��
	@RequestMapping(value="update", method=RequestMethod.POST)
	public void updateRestroom(@RequestBody RestroomVO input){
		RestroomVO vo = restService.readRestroom(input.getId());
		if(vo == null){
			restService.insertRestroom(input);
		}else{
			restService.updateRestroom(input);
		}
	}
	
	/**
	 * ȭ��� ������ ������.
	 * �����Ͱ� ���� ��� Default�� ���� ������� ����.
	 */
	@RequestMapping(value="get", method=RequestMethod.GET)
	public RestroomVO readRestroom(@RequestParam String id){
		RestroomVO vo = restService.readRestroom(id);
		if(vo == null){
			vo = new RestroomVO();
			vo.setId(id);
			vo.setState("����");
			restService.insertRestroom(vo);
			vo = restService.readRestroom(id);
		}
		return vo;
	}
	
	
}
