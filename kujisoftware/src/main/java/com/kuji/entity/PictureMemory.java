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
	private  String type;//类型
	private  String category;//所属类别
	private String errorNumber;//错误次数
	private String whichDay;//第几天
	private String imgName;//图片名字
	private String  number;//数量
	private String score;//分数
	
	
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
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
	public long getPictureMemoryId() {
		return pictureMemoryId;
	}
	public void setPictureMemoryId(long pictureMemoryId) {
		this.pictureMemoryId = pictureMemoryId;
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
	public String getErrorNumber() {
		return errorNumber;
	}
	public void setErrorNumber(String errorNumber) {
		this.errorNumber = errorNumber;
	}
	public String getWhichDay() {
		return whichDay;
	}
	public void setWhichDay(String whichDay) {
		this.whichDay = whichDay;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
}
