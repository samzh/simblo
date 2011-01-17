package net.simblo.core.category.service;

import java.util.List;

import net.simblo.base.service.IService;
import net.simblo.core.category.vo.Category;

public interface CategoryService extends IService<Category> {
	
	List<Category> findAll();
	
	List<Category> findByCount(int count);

}
