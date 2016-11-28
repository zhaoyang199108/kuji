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
		// TODO Auto-generated method stub
		return learnExplainDao.findAll();
	}

	public LearnExplain findHelpById(long id) {
		// TODO Auto-generated method stub
		return learnExplainDao.findHelpById(id);
	}

	public int deleteHelpById(long id) {
		// TODO Auto-generated method stub
		int count = learnExplainDao.deleteHelpById(id);
		if(count>0){
			return 1;
		}else{
			return 0;
		}
	}
}
