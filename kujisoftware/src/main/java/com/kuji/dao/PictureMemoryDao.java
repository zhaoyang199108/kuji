package com.kuji.dao;

import java.util.List;

import com.kuji.entity.PictureMemory;

public interface PictureMemoryDao {

	int insertIntoPictureMemory(PictureMemory pictureMemory);
	List<PictureMemory> findAll();
	PictureMemory findPictureMemoryByExerciseAndWhichDayAndType(PictureMemory pictureMemory);
	PictureMemory findPictureMemoryById(long id);
	int deletePictureMemoryById(long id);
	
}
