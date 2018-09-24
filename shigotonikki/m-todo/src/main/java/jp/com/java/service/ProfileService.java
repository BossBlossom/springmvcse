package jp.com.java.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.com.java.dao.ProfileDao;
import jp.com.java.entity.Profile;

@Service
public class ProfileService 
{
	@Autowired
	private ProfileDao profileDao;
	@Transactional(value=TxType.REQUIRED)
	public Profile createProfile(Profile profile)
	{
		Profile result = profileDao.create(profile);
		return result;
	}
}
