package com.kuji.service.EduCounseServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuji.dao.EduCounseDao;
import com.kuji.entity.EduCounse;
import com.kuji.entity.TypeRules;
import com.kuji.service.EduCounseService;

@Service
public class EduCounseServiceImpl  implements EduCounseService{

	@Autowired 
	private EduCounseDao eduCounseDao;
	
	public int query(String eduCounseTitle) {
		int count = eduCounseDao.query(eduCounseTitle);
		if(count > 0){
            return 0;
        }else{
            return 1;
        }
	}

	public int insertIntoEduCounse(EduCounse eduCounse) {
		return 0;
	}

	public List<EduCounse> findAll() {
		return eduCounseDao.findAll();
	}

	public TypeRules findEduCounseById(long id) {
		return eduCounseDao.findEduCounseById(id);
	}
	

}
