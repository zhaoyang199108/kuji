package com.kuji.entity;

import java.util.Date;
/**
 * 图片记忆
 * @author wudi
 *
 */
public class PictureMemory {

	private Date createTime;//创建时间
	private long exerciseId;//题目id
	private long pictureMemoryId;
	private  String pictureMemoryType;//类型
	private  String pictureMemoryCategory;//所属类别
	private String pictureMemoryErrorNumber;//错误次数
	private String pictureMemoryWhichDay;//第几天
	private String pictureMemoryImgName;//图片名字
	private String  pictureMemoryNumber;//数量
	private String pictureMemoryScore;//分数
	
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
	public long getPictureMemoryId() {
		return pictureMemoryId;
	}
	public void setPictureMemoryId(long pictureMemoryId) {
		this.pictureMemoryId = pictureMemoryId;
	}
	public String getPictureMemoryType() {
		return pictureMemoryType;
	}
	public void setPictureMemoryType(String pictureMemoryType) {
		this.pictureMemoryType = pictureMemoryType;
	}
	public String getPictureMemoryCategory() {
		return pictureMemoryCategory;
	}
	public void setPictureMemoryCategory(String pictureMemoryCategory) {
		this.pictureMemoryCategory = pictureMemoryCategory;
	}
	public String getPictureMemoryErrorNumber() {
		return pictureMemoryErrorNumber;
	}
	public void setPictureMemoryErrorNumber(String pictureMemoryErrorNumber) {
		this.pictureMemoryErrorNumber = pictureMemoryErrorNumber;
	}
	public String getPictureMemoryWhichDay() {
		return pictureMemoryWhichDay;
	}
	public void setPictureMemoryWhichDay(String pictureMemoryWhichDay) {
		this.pictureMemoryWhichDay = pictureMemoryWhichDay;
	}
	public String getPictureMemoryImgName() {
		return pictureMemoryImgName;
	}
	public void setPictureMemoryImgName(String pictureMemoryImgName) {
		this.pictureMemoryImgName = pictureMemoryImgName;
	}
	public String getPictureMemoryNumber() {
		return pictureMemoryNumber;
	}
	public void setPictureMemoryNumber(String pictureMemoryNumber) {
		this.pictureMemoryNumber = pictureMemoryNumber;
	}
	public String getPictureMemoryScore() {
		return pictureMemoryScore;
	}
	public void setPictureMemoryScore(String pictureMemoryScore) {
		this.pictureMemoryScore = pictureMemoryScore;
	}
	
}
