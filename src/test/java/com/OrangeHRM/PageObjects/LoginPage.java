package com.OrangeHRM.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	@FindBy(name="username")
	WebElement txtUsername;
	
	@FindBy(name = "password")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnLogin;
	
	//Methods
	public void enterUsername(String uname) {
		txtUsername.sendKeys(uname);
		String val = txtUsername.getAttribute("value");
		System.out.println("Value entered in Username field is - " + val);
	}
	
	public void enterPassword(String pwd) {
		txtPassword.sendKeys(pwd);
		String val = txtPassword.getAttribute("value");
		System.out.println("Value entered in Password field is - " + val);
	}
	
	public void clickLoginButton() {
		btnLogin.click();
		System.out.println("Clicked on Login button");
	}
}
