package com.spj.diary.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 日记项，每个日记对应一个 Diary 实例
 *  
 */
@ToString
@Setter
@Getter
@Table(name = "tb_diary")
public class Diary extends BasePojo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long userId;
	
	/** 关联情绪 */
	private Long moodId;
	
	/** 写作日期 */
	private Date writeDate;
	
	/** 日记关键字 */
	private String keyword;
	
	/** 地点位置 */
	private String site;
	
	private String remark;
	
	/** 是否锁定 0、未锁定 1、锁定 */
	private Integer isLock;
	
	/** 状态 0、正常 -1、删除，默认为0 */
	private Integer status = 0;

	/** 日记等级(重要程度)，满分 5 分 */
	private Integer score;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getMoodId() {
		return moodId;
	}

	public void setMoodId(Long moodId) {
		this.moodId = moodId;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getIsLock() {
		return isLock;
	}

	public void setIsLock(Integer isLock) {
		this.isLock = isLock;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
}
