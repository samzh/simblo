package net.simblo.core.category.service.impl;

import java.util.List;

import net.simblo.core.category.dao.CategoryDAO;
import net.simblo.core.category.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl<Category> implements CategoryService<Category> {

	@SuppressWarnings("rawtypes")
	@Autowired
	private CategoryDAO categoryDAO;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void save(Category t) {
		categoryDAO.create(t);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void delete(Category t) {
		categoryDAO.delete(t);

	}

	@SuppressWarnings("unchecked")
	@Override
	public Category find(long id) {

		return (Category) categoryDAO.get(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAll() {
		return categoryDAO.findAll();
	}

	@Override
	public List<Category> findByCount(int count) {
	
		return null;
	}

}
