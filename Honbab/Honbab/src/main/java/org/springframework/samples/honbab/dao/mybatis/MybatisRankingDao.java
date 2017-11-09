package org.springframework.samples.honbab.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.honbab.dao.RankingDao;
import org.springframework.samples.honbab.dao.mybatis.mapper.OrderMapper;
import org.springframework.samples.honbab.dao.mybatis.mapper.RankingMapper;
import org.springframework.samples.honbab.domain.Ranking;
import org.springframework.stereotype.Repository;
@Repository
public class MybatisRankingDao implements RankingDao{
	
	@Autowired
	 private RankingMapper rankingMapper;
	
	public List<Ranking> getRanking() {
		return rankingMapper.getRanking();
	}
}
