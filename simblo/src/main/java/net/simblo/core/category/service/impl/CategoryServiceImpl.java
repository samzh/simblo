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
	private CategoryDAO categoryDAO;

	@Override
	@Transactional
	public void persist(Category t) {
		categoryDAO.persist(t);

	}

	@Override
	@Transactional
	public void remove(Category t) {
		categoryDAO.remove(t);

	}

	@Override
	public Category find(long id) {

		return (Category) categoryDAO.find(id);
	}

	@Override
	public List<Category> findAll() {
		return categoryDAO.queryAll();
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
