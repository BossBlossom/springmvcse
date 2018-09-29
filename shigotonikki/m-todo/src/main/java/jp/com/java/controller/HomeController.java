package jp.com.java.controller;

import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController 
{
	
	@GetMapping
	public String index() {
		return "forward:/home";
	}
	
	@GetMapping(value = "/login")
	public String Login() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		AuthenticationTrustResolver authenticationTrustResolver = new AuthenticationTrustResolverImpl();
		if(authenticationTrustResolver.isAnonymous(authentication))
		{
			return "login";
		}
			
		
		return "redirect:/home";
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null)
			SecurityContextHolder.getContext().setAuthentication(null);
			
		return "redirect:/login?logout=true";
	}
	
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model)
	{
		return "denied";
	}
}
