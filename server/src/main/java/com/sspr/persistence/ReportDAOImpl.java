package com.sspr.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sspr.domain.ReportVO;

@Repository
public class ReportDAOImpl implements ReportDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace =
			"com.sspr.mappers.ReportMapper";
	
	@Override
	public void insert(ReportVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".insert",vo);
		
	}

	@Override
	public List<ReportVO> readMany(String restroom_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".readMany", restroom_id);
	}
	
	

	@Override
	public ReportVO readOne(String report_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".readOne", report_id);
	}

	@Override
	public void delete(ReportVO vo) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("report_id", vo.getReport_id());
		map.put("pwd", vo.getPwd());
		sqlSession.delete(namespace + ".delete", map);
	}
	
	

}
