package com.niit.Handler;



import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;
import com.niit.shoppingcart.model.UserDetails;

@Component

public class registrationHandler {
	public UserDetails initFlow(){
		return new UserDetails();
	}
	


	public String validateDetails(UserDetails userDetails,MessageContext messageContext){
		String status = "success";
		if(userDetails.getName().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"name").defaultText("Name cannot be Empty").build());
			status = "failure";
			System.out.println("name pass");
		}
		if(userDetails.getId().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"id").defaultText("UserId cannot be Empty").build());
			status = "failure";
			System.out.println("userid pass");
		}
		if(userDetails.getPassword().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"password").defaultText("Password cannot be Empty").build());
			status = "failure";
			System.out.println("password pass");
		}
		if(userDetails.getConfirmpassword().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"confirmpassword").defaultText("Confirmed Password cannot be Empty").build());
			status = "failure";
			System.out.println("cpassword pass");
		}
		if(!userDetails.getConfirmpassword().equals(userDetails.getPassword())){
			messageContext.addMessage(new MessageBuilder().error().source(
					"confirmpassword").defaultText("Passwords do not match").build());
			status = "failure";
			System.out.println("check password pass");
		}
		
			if(userDetails.getMail().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"Mail").defaultText("Email cannot be Empty").build());
			status = "failure";
			System.out.println("emailid pass");
		}
		if(userDetails.getContact().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"Contact").defaultText("Mobile No. cannot be Empty").build());
			status = "failure";
			System.out.println("mob pass");
		}
		if(userDetails.getAddress().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"address").defaultText("Address cannot be Empty").build());
			status = "failure";
			System.out.println("address pass");
		}
		
		return status;
	}

}
