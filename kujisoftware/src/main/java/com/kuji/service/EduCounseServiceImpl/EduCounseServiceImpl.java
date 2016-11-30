package com.kuji.service.EduCounseServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuji.dao.EduCounseDao;
import com.kuji.entity.EduCounse;
import com.kuji.service.EduCounseService;

@Service
public class EduCounseServiceImpl  implements EduCounseService{

	@Autowired 
	private EduCounseDao eduCounseDao;
	
	public EduCounse query(String eduCounseTitle) {
		System.out.print(eduCounseDao.query(eduCounseTitle));
            return eduCounseDao.query(eduCounseTitle);
	}

	public int insertIntoEduCounse(EduCounse eduCounse) {
		return eduCounseDao.insertIntoEduCounse(eduCounse);
	}

	public List<EduCounse> findAll() {
		return eduCounseDao.findAll();
	}

	public EduCounse findEduCounseById(long id) {
//		try{
//			return eduCounseDao.findEduCounseById(id);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		return eduCounseDao.findEduCounseById(id);
	}

	public int updateEduCounse(EduCounse eduCounse) {
		int count = eduCounseDao.updateEduCounse(eduCounse);
		if(count>0){
			return 1;
		}else{
			return 0;
		}
	}

	public int deleteEduCounseById(long id) {
		return eduCounseDao.deleteEduCounseById(id);
	}
	

}
