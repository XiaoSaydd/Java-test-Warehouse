package org.cskj.demo01.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.cskj.demo01.bean.Category;

@Mapper
public interface CategoryMapper {

	List<Category> queryAll();
	
	int addAll(Category category);
	
	int updateAll(Category category);
	
	Category queryById(int id);
	
	int deleteAll(int id);
}
