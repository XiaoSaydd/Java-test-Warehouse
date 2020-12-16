package org.cskj.demo01.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.cskj.demo01.Serivce.CategorySerivce;
import org.cskj.demo01.bean.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class CategoryController {

	@Autowired
	private CategorySerivce categorySerivce;
	
	@RequestMapping("/list")
	public ModelAndView queryAll(String currentPage) {
		currentPage = currentPage == null  ? "1" : currentPage;
		PageHelper.offsetPage((Integer.parseInt(currentPage)-1)*5,5);
		List<Category> list = categorySerivce.queryAll();
		PageInfo<Category> pageInfo = new PageInfo<Category>(list);
		return new ModelAndView("/listCategory").addObject("pageInfo", pageInfo);
	}
	
	@RequestMapping("/toadd")
	public String toadd() {
		return "add";
	}
	
	@RequestMapping("/add")
	public String addAll(Category category,HttpServletResponse response) throws IOException {
		 categorySerivce.addAll(category);
		 System.out.println(category);
		 return "redirect:list";
	}
	@RequestMapping("/queryById")
	@ResponseBody
	public void queryById(int id, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		Category category = categorySerivce.queryById(id);
		String jsonString = JSON.toJSONString(category);
		response.getWriter().print(jsonString);
	}
	@RequestMapping("/toupdate")
	public String toupdate() {
		return "update";
	}
	@RequestMapping("/update")
	public String updateAll(Category category,HttpServletResponse response) throws IOException {
		 categorySerivce.updateAll(category);
		 return "redirect:list";
	}
	
	@RequestMapping("/deletes")
	public String deleteAll(int id) {
		categorySerivce.deleteAll(id);
		return"redirect:list";
	}
//	public ModelAndView queryAll() {
//		List<Category> list = categorySerivce.queryAll();
//		ModelAndView mav = new ModelAndView("/listCategory").addObject("list", list);
//		return mav;
//	}
}
