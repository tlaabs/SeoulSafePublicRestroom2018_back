package com.sspr.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sspr.domain.RestroomVO;

@Repository
public class RestroomDAOImpl implements RestroomDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace =
			"com.sspr.mappers.RestroomMapper";
	
	@Override
	public RestroomVO read(String id) {
		// TODO Auto-generated method stub
		RestroomVO vo = sqlSession.selectOne(namespace+".read",id);
		return vo;
	}

	@Override
	public void insert(RestroomVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".insert",vo);
		
	}

	@Override
	public void update(RestroomVO vo) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".update",vo);
	}

}
