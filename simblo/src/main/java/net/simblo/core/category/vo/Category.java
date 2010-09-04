package net.simblo.core.category.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.simblo.base.vo.ValueObject;

@Entity
@Table (name = "si_category")
public class Category extends ValueObject {
	
	private String name;
	
	private int sortId;

	public void setSortId(int sortId) {
		this.sortId = sortId;
	}

	@Column (name = "sort_id")
	public int getSortId() {
		return sortId;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column (name = "name")
	public String getName() {
		return name;
	}

}
