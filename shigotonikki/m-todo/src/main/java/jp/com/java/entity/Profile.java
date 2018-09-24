package jp.com.java.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import jp.com.java.utils.Gender;

@Entity
@Table(name="profiles")
public class Profile 
{
	@Id
	@GeneratedValue
	@Column(name="ID_PROFILE")
	private int idProfile;
	
	@Column(name="AVATAR")
	private String avatar;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="FULL_NAME")
	private String fullName;
	
	@Enumerated(EnumType.STRING)
	@Column(name="GENDER")
	private Gender gender;
	
	@Column(name="BIRTH_DATE")
	private String birthDate;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="PHONE")
	private long phone;

	public int getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(int idProfile) {
		this.idProfile = idProfile;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
	
}
