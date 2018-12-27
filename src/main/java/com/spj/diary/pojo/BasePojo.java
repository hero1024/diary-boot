package com.spj.diary.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
@Setter
@Getter
public class BasePojo {
	/** 创建时间 */
	private Date created;
	/** 最后一次修改时间 */
	private Date updated;

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}
}
