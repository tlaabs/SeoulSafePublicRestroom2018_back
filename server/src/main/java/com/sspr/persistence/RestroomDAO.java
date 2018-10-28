package com.sspr.persistence;

import com.sspr.domain.RestroomVO;

public interface RestroomDAO {
	public RestroomVO read(String id);
	public void insert(RestroomVO vo);
	public void update(RestroomVO vo);
}
