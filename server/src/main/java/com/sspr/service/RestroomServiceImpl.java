package com.sspr.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sspr.domain.RestroomVO;
import com.sspr.persistence.RestroomDAO;

@Service
public class RestroomServiceImpl implements RestroomService{

	@Inject
	private RestroomDAO dao;
	
	@Override
	public RestroomVO readRestroom(String id) {
		// TODO Auto-generated method stub
		return dao.read(id);
	}

	@Override
	public void insertRestroom(RestroomVO vo) {
		// TODO Auto-generated method stub
		dao.insert(vo);
	}

	@Override
	public void updateRestroom(RestroomVO vo) {
		// TODO Auto-generated method stub
		dao.update(vo);
	}
	
}
