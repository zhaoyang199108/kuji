package com.kuji.entity;

import java.util.Date;

/**
 * 学习记忆
 * @author wudi
 *
 */
public class LearnExplain {

	private Date createTime;//创建时间
	private long exerciseId;//类别
	private  String learnExplainType;//类型
	private long learnExplainId;
	private String learnExplainWhichDay;//第几天
	private String learnExplainImgPath;//图片路径
	private String learnExplainVoicePath;//语音路径
	private String  learnExplainNumber;//数量
	private String learnExplainScore;//分数
	
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
	public String getLearnExplainType() {
		return learnExplainType;
	}
	public void setLearnExplainType(String learnExplainType) {
		this.learnExplainType = learnExplainType;
	}
	public long getLearnExplainId() {
		return learnExplainId;
	}
	public void setLearnExplainId(long learnExplainId) {
		this.learnExplainId = learnExplainId;
	}
	public String getLearnExplainWhichDay() {
		return learnExplainWhichDay;
	}
	public void setLearnExplainWhichDay(String learnExplainWhichDay) {
		this.learnExplainWhichDay = learnExplainWhichDay;
	}
	public String getLearnExplainImgPath() {
		return learnExplainImgPath;
	}
	public void setLearnExplainImgPath(String learnExplainImgPath) {
		this.learnExplainImgPath = learnExplainImgPath;
	}
	public String getLearnExplainVoicePath() {
		return learnExplainVoicePath;
	}
	public void setLearnExplainVoicePath(String learnExplainVoicePath) {
		this.learnExplainVoicePath = learnExplainVoicePath;
	}
	public String getLearnExplainNumber() {
		return learnExplainNumber;
	}
	public void setLearnExplainNumber(String learnExplainNumber) {
		this.learnExplainNumber = learnExplainNumber;
	}
	public String getLearnExplainScore() {
		return learnExplainScore;
	}
	public void setLearnExplainScore(String learnExplainScore) {
		this.learnExplainScore = learnExplainScore;
	}
	
}
