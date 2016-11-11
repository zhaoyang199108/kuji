package com.kuji.entity;

import java.util.Date;
/**
 *记忆训练
 */
public class MemoryTrain {

	private Date createTime;//创建时间
	private long exerciseId;//题目id
	private  String type;//类型
	private  String category;//所属类别
	private long memoryTrainId;
	private String errorNumber;//错误次数
	private String whichDay;//第几天
	private String  words;//词语
//	private String  anwserTime;//答题时间
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
	public long getMemoryTrainId() {
		return memoryTrainId;
	}
	public void setMemoryTrainId(long memoryTrainId) {
		this.memoryTrainId = memoryTrainId;
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
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
//	public String getAnwserTime() {
//		return anwserTime;
//	}
//	public void setAnwserTime(String anwserTime) {
//		this.anwserTime = anwserTime;
//	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
}
