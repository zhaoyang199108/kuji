package com.kuji.service;

import java.util.List;

import com.kuji.entity.MusicUpload;

public interface MusicUploadService {

	int   insertIntoMusicUpload(MusicUpload musicUpload);//添加
	List<MusicUpload> findAllMusic();
}
