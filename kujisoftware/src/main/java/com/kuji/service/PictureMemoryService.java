package com.kuji.service;

import java.util.List;

import com.kuji.entity.PictureMemory;

public interface PictureMemoryService {

	int   insertIntoPictureMemory(PictureMemory pictureMemory);//添加
	List<PictureMemory> findAll();
	PictureMemory findPictureMemoryByExerciseAndWhichDayAndType(PictureMemory pictureMemory);
	PictureMemory findPictureMemoryById(long id);
	int deletePictureMemoryById(long id);
}
