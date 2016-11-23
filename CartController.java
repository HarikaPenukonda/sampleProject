package com.niit.Controller;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Product;




@Controller
	public class CartController {
		@Autowired
		CartDAO cartDAO;
		@Autowired
		Cart cart;
		@Autowired
		ProductDAO productDAO;
		@Autowired
		Product product;
		@Autowired
		UserDetailsDAO userDetailsDAO;

		@ModelAttribute
		public Cart returnObject() {
			return new Cart();
		}

		@RequestMapping("/productselect{id}")
		public ModelAndView oneproductPage(@PathVariable("id")String id)throws Exception {
			ModelAndView mv = new ModelAndView("1productview");
			mv.addObject("oneproduct", productDAO.get(id));
			return mv;
		}

		@RequestMapping(value = "/buy{id}&{pid}")
		public ModelAndView buyproductPage(@Valid @PathVariable("id") String id, @PathVariable("pid") String pid,@RequestParam("quantity") String quantity,
				HttpSession session) throws Exception {
			int k = Integer.parseInt(quantity);
			ModelAndView mv = new ModelAndView("mycart");
			cart.setQuantity(k);
			cart.setUser_Id(id);
			cart.setProd_Id(pid);
			cart.setCartuser(userDetailsDAO.get(id));
			product = productDAO.get(pid);
			cart.setCartproduct(product);
			cart.setPrice(cart.getQuantity()*product.getPrice());
			cartDAO.save(cart);
			mv.addObject("mycartList", cartDAO.mycartproducts(id));
			session.setAttribute("cartvalue", cartDAO.totalproducts(id));
			return mv;
		}

		@RequestMapping(value = "/viewmycart{id}")
		public ModelAndView viewmycart(@PathVariable("id") String id) throws Exception {
			ModelAndView mv = new ModelAndView("mycart");
			System.out.println("Test01");
			mv.addObject("mycartList", cartDAO.mycartproducts(id));
			System.out.println(cartDAO.totalprice(id));
			return mv;
		}

		
		@RequestMapping(value = "/cartitemdelete{id}")
		public ModelAndView deleteCategory(@PathVariable("id") int id, HttpSession session) throws Exception {
			cart = cartDAO.getbyid(id);
			cartDAO.delete(cart);
			ModelAndView mv = new ModelAndView("mycart");
			mv.addObject("mycartList", cartDAO.mycartproducts(cart.getUser_Id()));
			session.setAttribute("cartvalue", cartDAO.totalproducts(cart.getUser_Id()));
			mv.addObject("cartprice", cartDAO.totalprice(cart.getUser_Id()));
			mv.addObject("cartmessage", cart.getCartproduct().getName());
			mv.addObject("cartmessage1", " has been deleted from your cart");
			return mv;
		}

	}
	
		
	

