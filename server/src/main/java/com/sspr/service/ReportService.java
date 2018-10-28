package com.sspr.service;

import java.util.List;

import com.sspr.domain.ReportVO;

public interface ReportService {
	public void insertReport(ReportVO vo);
	public List<ReportVO> readReports(String restroom_id);
	public ReportVO readReport(String report_id);
	public void deleteReport(ReportVO vo);
	
}
