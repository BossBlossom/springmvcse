package jp.com.java.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.com.java.entity.Profile;
import jp.com.java.service.ProfileService;

@Controller
@RequestMapping("/profile")
public class ProfileController 
{
	@Autowired
	private ProfileService profileService;
	@Autowired
	private static String UPLOADED_FOLDER = "C:/Users/Kitsune/Pictures/temp//";
	
	@RequestMapping(method = RequestMethod.GET)
	public String Profile(Model model)
	{
		Profile profile = new Profile();
		model.addAttribute("profile", profile);
		model.addAttribute("mode", "profile");
		return "profile";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String handleProfile(@RequestParam("file") MultipartFile file, @ModelAttribute("profile") Profile profile, BindingResult result, Model model, RedirectAttributes redirectAttributes)
	{
		if(result.hasErrors())
			return "profile";
		
		try
		{
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
			
			redirectAttributes.addFlashAttribute("message",
					"You successfully uploaded '" + file.getOriginalFilename() + "'");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		profile.setAvatar(file.getOriginalFilename());
		profileService.createProfile(profile);
		return "redirect:/home";
	}
}
