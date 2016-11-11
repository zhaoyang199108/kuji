package com.kuji.entity;

import java.util.Date;

/**
 * 学习记忆
 * @author wudi
 *
 */
public class LearnExplain {

	private Date createTime;//创建时间
	private long exerciseId;//题目id
	private  String type;//类型
	private  String category;//所属类别
	private long learnExplainId;
	private String whichDay;//第几天
//	private String imgPath;//图片路径
	private String imgName;//图片名字
	private String voicePath;//语音路径
	private String voiceName;//语音名字
	private String  number;//数量
	private String score;//分数
	
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public long getExerciseId() {
		return exerciseId;
	}
	public void setExerciseId(long exerciseId) {
		this.exerciseId = exerciseId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public long getLearnExplainId() {
		return learnExplainId;
	}
	public void setLearnExplainId(long learnExplainId) {
		this.learnExplainId = learnExplainId;
	}
	
	public String getWhichDay() {
		return whichDay;
	}
	public void setWhichDay(String whichDay) {
		this.whichDay = whichDay;
	}
//	public String getImgPath() {
//		return imgPath;
//	}
//	public void setImgPath(String imgPath) {
//		this.imgPath = imgPath;
//	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public String getVoicePath() {
		return voicePath;
	}
	public void setVoicePath(String voicePath) {
		this.voicePath = voicePath;
	}
	public String getVoiceName() {
		return voiceName;
	}
	public void setVoiceName(String voiceName) {
		this.voiceName = voiceName;
	}
	
}
