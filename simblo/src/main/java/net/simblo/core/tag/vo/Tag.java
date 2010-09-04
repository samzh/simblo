package net.simblo.core.tag.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.simblo.base.vo.ValueObject;

@Entity
@Table(name = "si_tag")
public class Tag extends ValueObject {

	private String name;

	private int sortId;

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	@Column(name = "sort_id")
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}

	public int getSortId() {
		return sortId;
	}

}
