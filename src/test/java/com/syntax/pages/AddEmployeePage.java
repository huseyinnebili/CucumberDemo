package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;
/*
 * US24548: Add Employee Details

TestCase: Add Employee Verification
Step 1: Login to the OrangeHRM *
Step 2: Click on PIM *
Step 3: Click on Add Employee*
Step 4: Enter fName, lName, select Location*
Step 5 Click Save
Step 6: Verify employee is added
 */

public class AddEmployeePage extends BaseClass {
	@FindBy(id = "menu_pim_viewPimModule")
	public WebElement PIM;

	@FindBy(id = "menu_pim_addEmployee")
	public WebElement addEmployee;

	@FindBy(id = "firstName")
	public WebElement firstName;

	
	@FindBy(id = "lastName")
	public WebElement lastName;
	
	
	@FindBy(xpath = "//*[@value='-- Select --']")
	public WebElement select;
	
	@FindBy(xpath = "//*[@id='location_inputfileddiv']/..//ul/li[3]")
	public WebElement location;
	
	@FindBy(id = "systemUserSaveBtn")
	public WebElement saveButton;
	
//	@FindBy(xpath = "//button[text()='Next']")
//	public WebElement secondNextButton;
//	
//	@FindBy(xpath = "(//*[@value = '-- Select --'])[6]")
//	public WebElement regionSelect;
//	
//	@FindBy(xpath = "(//*[@value = '-- Select --'])[6]/..//ul/li[3]")
//	public WebElement valueOfRegion;
//	
//	@FindBy(xpath = "(//*[@value = '-- Select --'])[7]")
//	public WebElement fteSelect;
//	
//	@FindBy(xpath = "(//*[@value = '-- Select --'])[7]/..//ul/li[3]")
//	public WebElement valueOfFTE;
//	
//	@FindBy(xpath = "(//*[@value = '-- Select --'])[8]")
//	public WebElement tempdepSelect;
//	
//	@FindBy(xpath = "(//*[@value = '-- Select --'])[8]/..//ul/li[3]")
//	public WebElement valueOftempdep;
//	
//	
//	@FindBy(xpath = "//button[text()='Save']")
//	public WebElement saveButton;
//	
	
	public AddEmployeePage() {
		PageFactory.initElements(driver, this);
	}
	
public void clickOnPIM() {
	PIM.click();
	

}
public void clickAddEmployeeButton() {
	addEmployee.click();
}
	
public void provideFirstName( String name) {
	firstName.click();
	firstName.sendKeys(name);
}
public void provideLastName( String name) {
	lastName.click();
	lastName.sendKeys(name);
}
public void selectClick() {
	select.click();
}
public void locationClick() {
	location.click();
}
//public void nextButtonClick() {
//	nextButton.click();
//}
//public void secondNextButtonClick() {
//	secondNextButton.click();
//}
//public void regionSelectClick() {
//	regionSelect.click();
//}
//
//public void fteSelect() {
//	fteSelect.click();
//	valueOfFTE.click();
//}
//
//public void tempdepSelect() {
//	tempdepSelect.click();
//	valueOftempdep.click();
//}

public void saveButtonClick() {
	saveButton.click();
}

}
