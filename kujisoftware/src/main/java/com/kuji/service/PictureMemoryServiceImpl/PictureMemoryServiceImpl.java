package com.kuji.service.PictureMemoryServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuji.dao.PictureMemoryDao;
import com.kuji.entity.PictureMemory;
import com.kuji.service.PictureMemoryService;

@Service
public class PictureMemoryServiceImpl implements PictureMemoryService {

	@Autowired 
	private PictureMemoryDao pictureMemoryDao;
	
	public int insertIntoPictureMemory(PictureMemory pictureMemory) {
		int count = pictureMemoryDao.insertIntoPictureMemory(pictureMemory);
		if(count>0){
			return 1;
		}else{
			return 0;
		}
	}

	public List<PictureMemory> findAll() {
		return pictureMemoryDao.findAll();
	}

	public PictureMemory findPictureMemoryByExerciseAndWhichDayAndType(
			PictureMemory pictureMemory) {
		return pictureMemoryDao.findPictureMemoryByExerciseAndWhichDayAndType(pictureMemory);
	}

	public PictureMemory findPictureMemoryById(long id) {
		return pictureMemoryDao.findPictureMemoryById(id);
	}

	public int deletePictureMemoryById(long id) {
		return pictureMemoryDao.deletePictureMemoryById(id);
	}
}
