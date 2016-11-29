package com.kuji.service.TypeRulesServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuji.dao.TypeRulesDao;
import com.kuji.entity.TypeRules;
import com.kuji.service.TypeRulesService;

@Service
public class TypeRulesServiceImpl  implements TypeRulesService{


	@Autowired 
	private TypeRulesDao typeRulesDao;
	
	public TypeRules query(String typeRulesName) {
		return  typeRulesDao.query(typeRulesName);
	}

	public int insertIntoTypeRules(TypeRules typeRules) {
		int count = typeRulesDao.insertIntoTypeRules(typeRules);
		if(count>0){
			return 1;
		}else{
			return 0;
		}
	}

	public TypeRules findTypeRulesById(long id) {
		return typeRulesDao.findTypeRulesById(id);
	}

	public int deleteTypeRulesById(long id) {
		return typeRulesDao.deleteTypeRulesById(id);
	}

	public int updateTypeRules(TypeRules typeRules) {
		int count = typeRulesDao.updateTypeRules(typeRules);
		if(count>0){
			return 1;
		}else{
			return 0;
		}
	}

	public List<TypeRules> findAll() {
		return typeRulesDao.findAll();
	} 
	

}
