package com.kuji.entity;

import java.util.Date;

/*
 * 教育资讯
 */
public class EduCounse {

	private Date createTime;//创建时间
	private long exerciseId;//类别
	private long eduCounseId;
	private String eduCounseTitle;//标题
	private String eduCounseContent;//内容文本
	private String eduCounseImg;//内容文本
	
	
	public long getExerciseId() {
		return exerciseId;
	}
	public void setExerciseId(long exerciseId) {
		this.exerciseId = exerciseId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public long getEduCounseId() {
		return eduCounseId;
	}
	public void setEduCounseId(long eduCounseId) {
		this.eduCounseId = eduCounseId;
	}
	public String getEduCounseTitle() {
		return eduCounseTitle;
	}
	public void setEduCounseTitle(String eduCounseTitle) {
		this.eduCounseTitle = eduCounseTitle;
	}
	public String getEduCounseContent() {
		return eduCounseContent;
	}
	public void setEduCounseContent(String eduCounseContent) {
		this.eduCounseContent = eduCounseContent;
	}
	public String getEduCounseImg() {
		return eduCounseImg;
	}
	public void setEduCounseImg(String eduCounseImg) {
		this.eduCounseImg = eduCounseImg;
	}
	
}
