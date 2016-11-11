package com.kuji.entity;

/**
 * 音乐上传
 * @author wudi
 *
 */
public class MusicUpload {

	private  String type;//类型
	private  String playOrder;//播放顺序
	private  String music;//音乐
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPlayOrder() {
		return playOrder;
	}
	public void setPlayOrder(String playOrder) {
		this.playOrder = playOrder;
	}
	public String getMusic() {
		return music;
	}
	public void setMusic(String music) {
		this.music = music;
	}
	
}
