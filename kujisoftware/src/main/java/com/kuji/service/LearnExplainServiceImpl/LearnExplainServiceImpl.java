package com.kuji.service.LearnExplainServiceImpl;

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
}
