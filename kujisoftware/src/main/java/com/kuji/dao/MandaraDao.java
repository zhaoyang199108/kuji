package com.kuji.dao;

import java.util.List;

import com.kuji.entity.Mandara;

public interface MandaraDao {

	List<Mandara> findAll();

	Mandara findMandaraByDayAndTypeAndExerciseId(Mandara mandara);

	int insertIntoMandara(Mandara mandara);

	int updateMandara(Mandara mandara);

	Mandara findMandaraById(long id);

}
