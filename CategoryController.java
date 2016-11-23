package com.niit.Controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

@Controller

public class CategoryController {

	private static Logger Log = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String listCategories(@ModelAttribute("category") Category category, BindingResult result,
			HttpServletRequest request, Model model) {

		Log.debug("starting of the method listCategories");
		model.addAttribute("category", category);
		model.addAttribute("categoryList", this.categoryDAO.list());
		Log.debug("End of the method listCategories");
		return "category";
	}

	@RequestMapping(value = "/cadd", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category, Model model) {
		Log.debug("starting of the method addCategory");

		ModelAndView mv = new ModelAndView("/category");
		 {
			System.out.println("Test case 3");
			categoryDAO.save(category);
		

	
			mv.addObject("error message,if exists with this id" + category.getId());
		

		Log.debug("ending of the method addcategories");
		model.addAttribute("categoryList", categoryDAO.list());
		return "/category";
		 }

}

	@RequestMapping("categorydelete{id}")
	public ModelAndView deleteCategory(@PathVariable("id") String id, @ModelAttribute("category") Category category,
			BindingResult result, Model model) throws Exception {
		category = categoryDAO.get(id);

		ModelAndView mv = new ModelAndView("/category");

		System.out.println("delete");
		if (category == null) {
			mv.addObject("errorMessage", "could not delete the category");
		} else {
			categoryDAO.delete(category);
			System.out.println("the category is deleted");

		}
		mv.addObject("categoryList", categoryDAO.list());

		return mv;
	}

	@RequestMapping(value = "cupdate{id}", method = RequestMethod.GET)
	public String updateCategory(@PathVariable("id") String id, Category category) {
		ModelAndView mv = new ModelAndView("/category");
		categoryDAO.update(category);
		System.out.println("update category");
		mv.addObject("message", "Successfully updated");
		mv.addObject("categoryList", categoryDAO.list());
		return "/category";
	}
}
