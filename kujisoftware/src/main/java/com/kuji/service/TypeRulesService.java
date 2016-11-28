package com.kuji.service;

import java.util.List;

import com.kuji.entity.TypeRules;

public interface TypeRulesService {

	TypeRules  query(String typeRulesName);//校验有无重复

	int insertIntoTypeRules(TypeRules typeRules);//添加

	TypeRules findTypeRulesById(long id);

	int deleteTypeRulesById(long id);

	int updateTypeRules(TypeRules typeRules);

	List<TypeRules> findAll();

}
