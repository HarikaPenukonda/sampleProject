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

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

@Controller

public class SupplierController {

	private static Logger Log = LoggerFactory.getLogger(SupplierController.class);

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Supplier supplier;

	@RequestMapping(value = "/supplier", method = RequestMethod.GET)
	public String listCategories(@ModelAttribute("supplier") Supplier supplier, BindingResult result,
			HttpServletRequest request, Model model) {

		Log.debug("starting of the method listSuppliers");
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", this.supplierDAO.list());
		Log.debug("End of the method listSuppliers");
		return "supplier";
	}

	@RequestMapping(value = "/sadd", method = RequestMethod.POST)
	public String addSupplier(@ModelAttribute("supplier") Supplier supplier, Model model) {
		Log.debug("starting of the method addSupplier");

		ModelAndView mv = new ModelAndView("/supplier");

		{

			supplierDAO.save(supplier);
			System.out.println("The supplier is added successfully");

			mv.addObject("error message,if exists with this id" + supplier.getId());

			Log.debug("ending of the method addsuppliers");
			mv.addObject("supplierList", supplierDAO.list());
			return "/supplier";
		}

	}

	@RequestMapping("supplierdelete{id}")
	public ModelAndView deleteSupplier(@PathVariable("id") String id,@ModelAttribute("supplier") Supplier supplier, BindingResult result,Model model
			) throws Exception {
		supplier = supplierDAO.get(id);

		ModelAndView mv = new ModelAndView("/supplier");

		
		if (supplier == null) {
			mv.addObject("errorMessage", "could not delete the supplier");
		} else {
			supplierDAO.delete(supplier);
			System.out.println("delete");

		}
		mv.addObject("supplierList", supplierDAO.list());

		return mv;
	}

	@RequestMapping(value = "supdate{id}", method = RequestMethod.GET)
	public String updateSupplier(@PathVariable("id") String id, Supplier supplier) {
		ModelAndView mv = new ModelAndView("/supplier");
		supplierDAO.update(supplier);
		System.out.println("update supplier");
		mv.addObject("message", "Successfully updated");
		mv.addObject("supplierList", supplierDAO.list());
		return "/supplier" ;
	}
}
