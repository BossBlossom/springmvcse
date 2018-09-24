package jp.com.java.model;

import org.springframework.web.multipart.MultipartFile;

public class UploadFormModel 
{
	String image;
	MultipartFile[] uploadFile;
	
	public MultipartFile[] getUploadFile()
	{
		return uploadFile;
	}
	
	public void setUploadFile(MultipartFile[] uploadFile)
	{
		this.uploadFile = uploadFile;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
