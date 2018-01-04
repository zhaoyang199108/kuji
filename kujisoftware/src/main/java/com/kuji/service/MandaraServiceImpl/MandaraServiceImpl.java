package com.kuji.service.MandaraServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuji.dao.MandaraDao;
import com.kuji.entity.Mandara;
import com.kuji.service.MandaraService;

@Service
public class MandaraServiceImpl implements MandaraService{

	@Autowired
	private MandaraDao mandaraDao;
	
	public List<Mandara> findAll() {
		return mandaraDao.findAll();
	}

	public Mandara findMandaraByDayAndTypeAndExerciseId(Mandara mandara) {
		return mandaraDao.findMandaraByDayAndTypeAndExerciseId(mandara);
	}

	public int insertIntoMandara(Mandara mandara) {
		int count = mandaraDao.insertIntoMandara(mandara);
		if(count>0){
			return 1;
		}else{
			return 0;
		}
	}

	public int updateMandara(Mandara mandara) {
		int count = mandaraDao.updateMandara(mandara);
		if(count>0){
			return 1;
		}else{
			return 0;
		}
	}

	public Mandara findMandaraById(long id) {
		return mandaraDao.findMandaraById(id);
	}

	
}
