package com.kuji.service;

import java.util.List;

import com.kuji.entity.MusicUpload;

public interface MusicUploadService {

	int   insertIntoMusicUpload(MusicUpload musicUpload);//添加
	List<MusicUpload> findAllMusic();
	List<MusicUpload> findMusicByName(String fileName);
	MusicUpload finMusicById(long id);
	int updateMusicUpload(MusicUpload musicUpload);
}
