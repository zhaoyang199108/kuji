package com.kuji.entity;

/**
 * 音乐上传
 * @author wudi
 *
 */
public class MusicUpload {
	private  long musicUploadId;

	public long getMusicUploadId() {
		return musicUploadId;
	}
	public void setMusicUploadId(long musicUploadId) {
		this.musicUploadId = musicUploadId;
	}
	public String getMusicUploadType() {
		return musicUploadType;
	}
	public void setMusicUploadType(String musicUploadType) {
		this.musicUploadType = musicUploadType;
	}
	public String getMusicUploadPlayOrder() {
		return musicUploadPlayOrder;
	}
	public void setMusicUploadPlayOrder(String musicUploadPlayOrder) {
		this.musicUploadPlayOrder = musicUploadPlayOrder;
	}
	public String getMusicUploadMusic() {
		return musicUploadMusic;
	}
	public void setMusicUploadMusic(String musicUploadMusic) {
		this.musicUploadMusic = musicUploadMusic;
	}
	private  String musicUploadType;//类型
	private  String musicUploadPlayOrder;//播放顺序
	private  String musicUploadMusic;//音乐
	private String musicUploadName;
	private long version;

	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public String getMusicUploadName() {
		return musicUploadName;
	}
	public void setMusicUploadName(String musicUploadName) {
		this.musicUploadName = musicUploadName;
	}
	
	

}
