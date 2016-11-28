package com.kuji.entity;

import java.util.Date;

/**
 * 题型规则
 * @author wudi
 *
 */
public class TypeRules {

	private Date createTime;//创建时间
	private long typeRulesId;
	private String typeRulesName;//规则名称
	private String typeRulesContent;//规则内容
	private long exerciseId;
	
	
	
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
	public long getTypeRulesId() {
		return typeRulesId;
	}
	public void setTypeRulesId(long typeRulesId) {
		this.typeRulesId = typeRulesId;
	}
	public String getTypeRulesName() {
		return typeRulesName;
	}
	public void setTypeRulesName(String typeRulesName) {
		this.typeRulesName = typeRulesName;
	}
	public String getTypeRulesContent() {
		return typeRulesContent;
	}
	public void setTypeRulesContent(String typeRulesContent) {
		this.typeRulesContent = typeRulesContent;
	}
	
}
