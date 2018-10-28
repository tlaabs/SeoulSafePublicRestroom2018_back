package com.sspr.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sspr.domain.ReportVO;
import com.sspr.persistence.ReportDAO;

@Service
public class ReportServiceImpl implements ReportService{

	@Inject
	private ReportDAO dao;

	@Override
	public void insertReport(ReportVO vo) {
		// TODO Auto-generated method stub
		dao.insert(vo);
	}

	@Override
	public List<ReportVO> readReports(String restroom_id) {
		// TODO Auto-generated method stub
		return dao.readMany(restroom_id);
	}
	

	@Override
	public ReportVO readReport(String report_id) {
		// TODO Auto-generated method stub
		return dao.readOne(report_id);
	}

	@Override
	public void deleteReport(ReportVO vo) {
		// TODO Auto-generated method stub
		dao.delete(vo);
	}
	
}
