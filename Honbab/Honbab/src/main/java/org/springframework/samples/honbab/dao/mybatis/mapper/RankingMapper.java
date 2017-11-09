package org.springframework.samples.honbab.dao.mybatis.mapper;

import java.util.List;

import org.springframework.samples.honbab.domain.Ranking;

public interface RankingMapper {
	List<Ranking> getRanking();

}
