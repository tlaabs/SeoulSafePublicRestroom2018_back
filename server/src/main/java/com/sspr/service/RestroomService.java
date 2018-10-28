package com.sspr.service;

import com.sspr.domain.RestroomVO;

public interface RestroomService {
	public RestroomVO readRestroom(String id);
	public void insertRestroom(RestroomVO vo);
	public void updateRestroom(RestroomVO vo);
}
