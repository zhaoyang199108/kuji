package com.kuji.service.MusicUploadServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuji.dao.MusicUploadDao;
import com.kuji.entity.MusicUpload;
import com.kuji.service.MusicUploadService;

@Service
public class MusicUploadServiceImpl implements MusicUploadService{

	@Autowired 
	private MusicUploadDao musicUploadDao;
	
	public int insertIntoMusicUpload(MusicUpload musicUpload) {
		int count = musicUploadDao.insertIntoMusicUpload(musicUpload);
		if(count>0){
			return 0;
		}else{
			return 1;
		}
	}
	
}
