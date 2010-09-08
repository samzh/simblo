package net.simblo.core.category.dao.impl;

import org.springframework.stereotype.Repository;

import net.simblo.base.dao.BaseDao;
import net.simblo.core.category.dao.CategoryDAO;
import net.simblo.core.category.vo.Category;

@SuppressWarnings("rawtypes")
@Repository
public class CategoryDAOImpl extends BaseDao implements CategoryDAO {
	public CategoryDAOImpl() {
		super(Category.class);
	}

	public CategoryDAOImpl(Class<Category> clazz) {
		super(clazz);
	}
}
