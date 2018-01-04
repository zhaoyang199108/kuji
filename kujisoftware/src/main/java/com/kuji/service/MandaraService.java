package com.kuji.service;

import java.util.List;

import com.kuji.entity.Mandara;

public interface MandaraService {

	public List<Mandara> findAll();

	public Mandara findMandaraByDayAndTypeAndExerciseId(Mandara mandara);

	public int insertIntoMandara(Mandara mandara);

	public int updateMandara(Mandara mandara);

	public Mandara findMandaraById(long id);


}
