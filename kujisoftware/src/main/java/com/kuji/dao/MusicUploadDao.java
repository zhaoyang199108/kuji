package com.kuji.dao;

import java.util.List;

import com.kuji.entity.MusicUpload;

public interface MusicUploadDao {

	int insertIntoMusicUpload(MusicUpload musicUpload);
	List<MusicUpload> findAllMusic();
}
