package com.sspr.persistence;

import java.util.List;

import com.sspr.domain.ReportVO;

public interface ReportDAO {
	public void insert(ReportVO vo);
	public List<ReportVO> readMany(String restroom_id);
	public ReportVO readOne(String report_id);
	public void delete(ReportVO vo);
	
}
