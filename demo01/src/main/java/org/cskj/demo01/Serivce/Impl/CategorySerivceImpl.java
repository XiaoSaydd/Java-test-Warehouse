package org.cskj.demo01.Serivce.Impl;

import java.util.List;

import org.cskj.demo01.Mapper.CategoryMapper;
import org.cskj.demo01.Serivce.CategorySerivce;
import org.cskj.demo01.bean.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorySerivceImpl implements CategorySerivce {

	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public List<Category> queryAll() {
		// TODO Auto-generated method stub
		return categoryMapper.queryAll();
	}
	
	@Override
	public int addAll(Category category) {
		// TODO Auto-generated method stub
		return categoryMapper.addAll(category);
	}

	@Override
	public int updateAll(Category category) {
		// TODO Auto-generated method stub
		return categoryMapper.updateAll(category);
	}

	@Override
	public Category queryById(int id) {
		// TODO Auto-generated method stub
		return categoryMapper.queryById(id);
	}

	@Override
	public int deleteAll(int id) {
		// TODO Auto-generated method stub
		return categoryMapper.deleteAll(id);
	}

}
