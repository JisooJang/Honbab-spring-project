package org.springframework.samples.honbab.controller;

import java.io.Serializable;

import org.springframework.samples.honbab.domain.Account;
import org.springframework.web.multipart.MultipartFile;


@SuppressWarnings("serial")
public class AccountForm implements Serializable {

	private Account account;

	private boolean newAccount;

	private String repeatedPassword;

	private MultipartFile profile;
	
	public MultipartFile getProfile() {
		return profile;
	}

	public void setProfile(MultipartFile profile) {
		this.profile = profile;
	}

	public AccountForm(Account account) {
		this.account = account;
		this.newAccount = false;
		
	}

	public AccountForm() {
		this.account = new Account();
		this.newAccount = true;
		profile = null;
	}

	public Account getAccount() {
		return account;
	}

	public boolean isNewAccount() {
		return newAccount;
	}

	public void setRepeatedPassword(String repeatedPassword) {
		this.repeatedPassword = repeatedPassword;
	}

	public String getRepeatedPassword() {
		return repeatedPassword;
	}
}
