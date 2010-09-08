package net.simblo.core.category.service;

import java.util.List;

import net.simblo.base.service.IService;

public interface CategoryService<Category> extends IService<Category> {
	
	List<Category> findAll();

}
