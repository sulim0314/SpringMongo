package com.multi.mapper;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.client.result.DeleteResult;
import com.multi.domain.MemoVO;

import lombok.extern.log4j.Log4j;

@Repository
@Log4j
public class MemoMapperImpl implements MemoMapper {
	
	@Inject
	private MongoTemplate mongoTemplate;

	@Override
	public int insertMemo(MemoVO memo) {
		//insert(T obj, String collectionName)
		MemoVO vo=mongoTemplate.insert(memo, "memo");
		log.info("vo==="+vo);
		return 0;
	}

	@Override
	public List<MemoVO> listMemo() {
		
		List<MemoVO> memoArr = mongoTemplate.findAll(MemoVO.class, "memo");
		
		return memoArr;
	}

	@Override
	public int deleteMemo(String id) {
		DeleteResult res = mongoTemplate.remove(query(where("_id").is(id)), MemoVO.vlass)
		
		return 0;
	}

	@Override
	public int updateMemo(MemoVO memo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemoVO getMemo(String id) {
		return this.mongoTemplate.findOne(query(where("id").is(id)), MemoVO.class);
	}

}
