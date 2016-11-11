package com.kuji.service.PictureMemoryServiceImpl;

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
			return 0;
		}else{
			return 1;
		}
	}
}
