package org.springframework.samples.honbab.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.honbab.domain.Ranking;

public interface RankingDao {

	public List<Ranking> getRanking() throws DataAccessException;
}
