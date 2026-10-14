package revokedojt;

import base.basetest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.List;
import java.util.ArrayList;
import java.util.List;



public class ledger extends basetest {

    @Test
    public void TC_DD_01_dropdownIsDisplayed() {
        try {
            driver.get("https://betwabasin-ojt.mp.gov.in/WEB/Login/Login");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // ── Login ────────────────────────────────────────────────────────
            WebElement username = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("username"))
            );
            username.sendKeys("ME2300000117");

            driver.findElement(By.id("txtpassword")).sendKeys("TestUser@123");

            System.out.println("⚠ Please enter CAPTCHA manually");
            Thread.sleep(15000);

            WebElement loginBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick='enc();']"))
            );
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", loginBtn);
            System.out.println("✅ Login button clicked");

            // ── Navigate to EstablishmentLedger ──────────────────────────────
            wait.until(ExpectedConditions.urlContains("EstablishmentDashboard"));
            System.out.println("✅ EstablishmentDashboard page opened. URL: " + driver.getCurrentUrl());
            Thread.sleep(2000);

            
            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            js1.executeScript("window.scrollBy(0, 500);");
            
            
            
            WebElement TPAAssociationRequest =
                    wait.until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//a[@href='/Web/TPAAssociationRequestEstablishment/Index']")));
            
            TPAAssociationRequest.click();
            System.out.println("✅ Clicked on TPAAssociationRequest");
            
            
            
           WebElement tpaDropdown = wait.until(
            	   ExpectedConditions.elementToBeClickable(
            	       By.xpath("//span[@id='select2-txtTPANo-container']")));
            	    
                    	tpaDropdown.click();
            
                    	
                    	 WebElement download = wait.until(
                             	   ExpectedConditions.elementToBeClickable(
                             	       By.xpath("//button[@id='exportBtn']")));
                             	    
                  		  download.click();
          
                  		System.out.println("✅ Clicked on download successfully");
                    	
            
                    	
                    		  
                    		  
                    		  
                    		  
                    		  
                    		  
                    		  
                    		  
                    		  
                    		  
                    		  
                    		  
                    		  
                    		  
                    		  WebElement viewdetails =
                                      wait.until(ExpectedConditions.elementToBeClickable(
                                              By.xpath("//a[contains(@onclick,'ZoWpsYfG78CHqg_cBa3zbw')]")));
                              
                    		  viewdetails.click();
                              System.out.println("✅ Clicked on viewdetails");         		  
                    		  
                    		  
                              WebElement closeBtn = wait.until(
                            		    ExpectedConditions.elementToBeClickable(
                            		        By.xpath("//div[@id='Modalmessage1']//a[contains(@class,'close')]")
                            		    )
                            		);

                            		closeBtn.click();
                              
                              
                    		  
                              
                              WebElement back = wait.until(
                            		  //ExpectedConditions.visibilityOfElementLocated(
                            		  
                                  	   ExpectedConditions.elementToBeClickable(
                                  	     //  By.xpath("//button[@id='btnback']")));
                             By.xpath("//button[@id='btnback' and contains(@class,'btn-primary')]")));
                              
                            //  By.xpath("//button[contains(@class,'btn-primary')]")));
                              back.click();
                              
                             
                              
                              
                              System.out.println("✅ Clicked on back button"); 
                              
                             
                              
                              WebElement tpaAddressHeader = driver.findElement(
                            	        By.xpath("//th[contains(text(),'TPA Address')]"));

                            	if (tpaAddressHeader.isDisplayed())
                            	{
                            	    System.out.println("✅ TPA Address column is displayed");
                            	}
                            	else
                            	{
                            	    System.out.println("❌ TPA Address column is not displayed");
                            	}
                              
                              
                              
                            	 WebElement ContactPerson = driver.findElement(
                             	        By.xpath("//th[contains(text(),'Contact Person')]"));

                             	if (ContactPerson.isDisplayed())
                             	{
                             	    System.out.println("✅ Contact Person column is displayed");
                             	}
                             	else
                             	{
                             	    System.out.println("❌ Contact Person column is not displayed");
                             	}
                               
                            	
                            	
                             	List<WebElement> tpaAddresses =
                             	        driver.findElements(By.xpath("//tbody/tr/td[6]"));

                             	for (int i = 0; i < tpaAddresses.size(); i++)
                             	{
                             	    String address = tpaAddresses.get(i).getText().trim();

                             	    if (!address.isEmpty())
                             	    {
                             	        System.out.println("✅ Address Displayed: " + address);
                             	    }
                             	    else
                             	    {
                             	        System.out.println("❌ Address Missing in row " + (i + 1));
                             	    }
                             	}
                            	
                            	
                            	
                            	
                              
                              
                              
            
        } catch (Exception e) {
            System.out.println("❌ TC_DD_01 Failed");
            e.printStackTrace();
            Assert.fail("TC_DD_01 failed: " + e.getMessage());
        }
    }
}
