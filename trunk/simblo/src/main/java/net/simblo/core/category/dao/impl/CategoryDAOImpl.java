package net.simblo.core.category.dao.impl;

import net.simblo.base.dao.BaseDao;
import net.simblo.core.category.dao.CategoryDAO;
import net.simblo.core.category.vo.Category;

import org.springframework.stereotype.Repository;

@Repository
public class CategoryDAOImpl extends BaseDao<Category> implements CategoryDAO {
	public CategoryDAOImpl() {
		super(Category.class);
	}

	public CategoryDAOImpl(Class<Category> clazz) {
		super(clazz);
	}
}
