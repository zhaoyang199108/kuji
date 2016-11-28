package com.kuji.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kuji.entity.TypeRules;

public interface TypeRulesDao {

	TypeRules query(@Param("typeRulesName")  String typeRulesName);

	int insertIntoTypeRules(TypeRules typeRules);

	TypeRules findTypeRulesById(long id);

	int deleteTypeRulesById(long id);

	int updateTypeRules(TypeRules typeRules);

	List<TypeRules> findAll();

}
