package com.kuji.service.MusicUploadServiceImpl;

import java.util.List;

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
			return 1;
		}else{
			return 0;
		}
	}

	public List<MusicUpload> findAllMusic() {
		// TODO Auto-generated method stub
		List<MusicUpload> list = musicUploadDao.findAllMusic();
		return list;
	}

	public List<MusicUpload> findMusicByName(String fileName) {
		// TODO Auto-generated method stub
		return musicUploadDao.findMusicByName(fileName);
	}

	public MusicUpload finMusicById(long id) {
		// TODO Auto-generated method stub
		return musicUploadDao.finMusicById(id);
	}
	
}
