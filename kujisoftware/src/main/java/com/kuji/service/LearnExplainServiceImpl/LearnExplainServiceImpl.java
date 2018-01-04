package com.kuji.service.LearnExplainServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuji.dao.LearnExplainDao;
import com.kuji.entity.LearnExplain;
import com.kuji.service.LearnExplainService;

@Service
public class LearnExplainServiceImpl  implements LearnExplainService{
	@Autowired 
	private LearnExplainDao learnExplainDao;
	
	public int insertIntoLearnExplain(LearnExplain learnExplain) {
		int count = learnExplainDao.insertIntoLearnExplain(learnExplain);
		if(count>0){
			return 1;
		}else{
			return 0;
		}
	}

	public int query(String learnExplainType, String exerciseId,
			String learnExplainWhichDay) {
		int count = learnExplainDao.query(learnExplainType,exerciseId,learnExplainWhichDay);
		if(count > 0){
            return 0;
        }else{
            return 1;
        }
	}

	public List<LearnExplain> findAll() {
		return learnExplainDao.findAll();
	}
	public LearnExplain findLearnExplainById(long id) {
		return learnExplainDao.findLearnExplainById(id);
	}

	public int deleteLearnExplainById(long id) {
		int count = learnExplainDao.deleteLearnExplainById(id);
		if(count>0){
			return 1;
		}else{
			return 0;
		}
	}

	public int updateLearnExplain(LearnExplain learnExplain) {
		int count = learnExplainDao.updateLearnExplain(learnExplain);
		if(count>0){
			return 1;
		}else{
			return 0;
		}
	}

	public LearnExplain findLearnExplainBy(String learnExplainType,
			String exerciseId, String learnExplainWhichDay) {
		// TODO Auto-generated method stub
		return learnExplainDao.findLearnExplainBy(learnExplainType,exerciseId,learnExplainWhichDay);
	}
}
