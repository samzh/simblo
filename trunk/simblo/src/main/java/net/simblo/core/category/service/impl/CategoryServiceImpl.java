package net.simblo.core.category.service.impl;

import java.util.List;

import net.simblo.core.category.dao.CategoryDAO;
import net.simblo.core.category.service.CategoryService;
import net.simblo.core.category.vo.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO<Category> categoryDAO;

	@Override
	@Transactional
	public void save(Category t) {
		categoryDAO.create(t);

	}

	@Override
	@Transactional
	public void delete(Category t) {
		categoryDAO.delete(t);

	}

	@Override
	public Category find(long id) {

		return (Category) categoryDAO.get(id);
	}

	@Override
	public List<Category> findAll() {
		return categoryDAO.findAll();
	}

	@Override
	public List<Category> findByCount(int count) {

		return null;
	}

	@Override
	public long getCount() {
		return categoryDAO.getCount();
	}

}
