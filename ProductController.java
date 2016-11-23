package com.niit.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;

@Controller
public class ProductController {

	@Autowired(required = true)
	private ProductDAO productDAO;
	/*
	 * @Autowired private Product product;
	 */

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private Supplier supplier;


	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String listSuppliers(Model model) {

		model.addAttribute("product", new Product());
		model.addAttribute("productList", this.productDAO.list());
		model.addAttribute("category", category);
		model.addAttribute("categoryList", this.categoryDAO.list());
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", this.supplierDAO.list());

		return "product";
	}

	@RequestMapping(value = "/padd", method = RequestMethod.POST)
	public String addproduct(@Valid @ModelAttribute("product") Product product, Model model, 
			HttpServletRequest request) throws IOException {

		String filename;

		byte[] bytes;
		System.out.println(product.getName());

		System.out.println("image uploaded");

		System.out.println("myproduct controller called");
		MultipartFile image = product.getImage();
		Path path;
		path = Paths
				.get("F://New folder//FrontEnd//src//main//webapp//Resources//images//" + product.getName() + ".jpg");

		System.out.println("Path = " + path);
		System.out.println("File name = " + product.getImage().getOriginalFilename());
		if (image != null && !image.isEmpty()) {
			try {
				image.transferTo(new File(path.toString()));
				System.out.println("Image Saved in:" + path.toString());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Image not saved");
			}
		}
		ModelAndView mv = new ModelAndView("/product");
		Category category = categoryDAO.get(product.getCategory().getId());
		product.setCategory(category);
		product.setCatid(category.getId());
		System.out.println("1");
		
		Supplier supplier = supplierDAO.get(product.getSupplier().getId());
		System.out.println("2");
		product.setSupplier(supplier);
		System.out.println("3");
		product.setSupid(supplier.getId());
		System.out.println("4");
		productDAO.save(product);
		System.out.println("products are added");
		mv.addObject("productList", productDAO.list());

		return "/product";
	}

	@RequestMapping("productdelete{id}")
	public ModelAndView deleteProduct(@PathVariable("id") String id, Product product) throws Exception {
		product = productDAO.get(id);

		ModelAndView mv = new ModelAndView("product");

		System.out.println("delete");
		if (product == null) {
			mv.addObject("errorMessage", "could not delete the product");
		} else {
			productDAO.delete(product);
			System.out.println("Products is deleted sucessfully");

		}
		mv.addObject("productList", productDAO.list());

		return mv;
	}

	@RequestMapping(value = "pupdate{id}", method = RequestMethod.GET)
	public String updateSupplier(@PathVariable("id") String id, Model model) {
		ModelAndView mv = new ModelAndView("product");

		System.out.println("update supplier");
		model.addAttribute("supplier", this.productDAO.get(id));
		model.addAttribute("listSuppliers", this.productDAO.list());
		mv.addObject("productList", productDAO.list());

		return "product";

	}

	@RequestMapping("/products")
	public ModelAndView viewItems() throws JsonGenerationException, JsonMappingException, IOException {
		List<Product> list = productDAO.list();
		System.out.println("user list=" + list);
		ObjectMapper om = new ObjectMapper();
		String listjson = om.writeValueAsString(list);
		System.out.println(listjson);
		return new ModelAndView("products", "listofitem", listjson);
	}

	@RequestMapping("/viewproducts")
	public ModelAndView productViewDetails(@RequestParam("id") String id, Model model) {
		System.out.println("I am in productViewDetails");
		System.out.println("ID:" + id);
		// int i = Integer.parseInt(prodid);
		model.addAttribute("productList", this.productDAO.list());
		Product product = productDAO.get(id);
		return new ModelAndView("viewproducts", "product", product);
	}

	String setName;
	List<Product> plist;

	// @SuppressWarnings("unchecked")
	@RequestMapping("/GsonCon")
	public @ResponseBody String getValues() throws Exception {
		String result = "";
		plist = productDAO.list();
		Gson gson = new Gson();
		result = gson.toJson(plist);
		return result;

	}

}
