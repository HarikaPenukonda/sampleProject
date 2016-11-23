package com.niit.Controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.UserDetails;

@Controller
public class HomeController {
	
	
	@Autowired
	private UserDetailsDAO userDetailsDAO;

	@Autowired
	private UserDetails userDetails;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;
	
	


	@RequestMapping("/")
	public ModelAndView showindex() {
		System.out.println("test1");
		ModelAndView mv = new ModelAndView("HomePage");
		mv.addObject("message,Hello World");
		return mv;
	}

	@RequestMapping("/Signin")
	public ModelAndView showsignin() {
		ModelAndView mv = new ModelAndView("Signin");
		System.out.println("Signed In");
		return mv;

	}


	@ModelAttribute
	public UserDetails returnObject() {
		return new UserDetails();
	}
	
	@RequestMapping(value = "/login_session_attributes")
	public String login_session_attributes(HttpSession session, Model model,@RequestParam(value="username")String id) {
		Object name=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("inside security check");

		session.setAttribute("name", name);
		System.out.println(name);

		userDetails = userDetailsDAO.get(id);
		System.out.println("Userdetails");
		session.setAttribute("loggedInUser", userDetails.getName());
		session.setAttribute("loggedInUserID", userDetails.getId());

		session.setAttribute("LoggedIn", "true");

		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities();

		String role = "ROLE_USER";
		for (GrantedAuthority authority : authorities) {
			if (authority.getAuthority().equals(role)) {
				System.out.println(role);
				return "HomePage";
			} else {
				session.setAttribute("isAdmin",1);
				model.addAttribute("Page1", 1);
			}
		}
		return "AdminHome";

	}

	@RequestMapping("/perform_logout")
	public ModelAndView logout(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("home");
		session.invalidate();
		session = request.getSession(true);
		session.setAttribute("category", category);
		session.setAttribute("categoryList", categoryDAO.list());

		mv.addObject("logOutMessage", "You have successfully logged out!");
		mv.addObject("loggedout", "true");

		return mv;
	}
	/*@RequestMapping("/Signup")
	public ModelAndView showsignup(@Valid @ModelAttribute("UserDetails") UserDetails user, BindingResult result,
			HttpServletRequest request) throws IOException {
		ModelAndView mv = new ModelAndView("Signup");
		mv.addObject("message,Signup");
		return mv;
	}*/
	/*@RequestMapping("/register")
	public ModelAndView register(@Valid @ModelAttribute("UserDetails") UserDetails userDetails, BindingResult result,
			HttpServletRequest request) throws IOException {
		System.out.println(userDetails.getPassword());
		System.out.println(userDetails.getConfirmpassword());
		ModelAndView mv = new ModelAndView("Signin");
		userDetails.setRole("ROLE_USER");
		userDetails.setEnabled(true);
		if (userDetails.getConfirmpassword().equals(userDetails.getPassword())) {
			userDetailsDAO.save(userDetails);
		}
		return mv;*/
	
	
	}	

	
	

	


