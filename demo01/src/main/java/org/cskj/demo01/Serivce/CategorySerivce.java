package org.cskj.demo01.Serivce;

import java.util.List;

import org.cskj.demo01.bean.Category;

public interface CategorySerivce {

	List<Category> queryAll();
	
	Category queryById(int id);
	
	int addAll(Category category);
	
	int updateAll(Category category);
	
	int deleteAll(int id);
}
