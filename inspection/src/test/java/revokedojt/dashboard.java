package revokedojt;

import base.basetest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;


import java.time.Duration;

public class dashboard extends basetest {

    @Test
    public void loginTest() {
        try {
            driver.get("https://betwabasin-ojt.mp.gov.in/WEB/Login/Login");

            // ✅ Create wait ONLY ONCE
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Username
            WebElement username = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("username"))
            );
            username.sendKeys("mmsky.indore");

            // Password
            WebElement password =
                    driver.findElement(By.id("txtpassword"));
            password.sendKeys("TestUser@123");

            System.out.println("⚠ Please enter CAPTCHA manually");
            Thread.sleep(15000);

            // Login button
            WebElement loginBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[@onclick='enc();']")
                    )
            );

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", loginBtn);

            System.out.println("✅ Login button clicked");

            
                      // 🔹 Validate Dashboard
            wait.until(ExpectedConditions.urlContains("DirectorateDashboard"));

            String currentUrl1 = driver.getCurrentUrl();
            System.out.println("Current URL: " + currentUrl1);

            Assert.assertTrue(
                    currentUrl1.contains("DirectorateDashboard"),
                    "❌ Login failed: Dashboard not loaded"
            );

            System.out.println("✅ Login Dashboard opened.");
            
            Thread.sleep(2000);
            
            
         // 🔹 TPA Dashboard Tab Check
            WebElement tpaDashboard = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//button[contains(text(),'TPA Dashboard')]")
                )
            );

            Assert.assertTrue(
                tpaDashboard.isDisplayed(),
                "❌ TPA Dashboard tab is NOT visible"
            );
            System.out.println("✅ TPA Dashboard tab is visible");
            
            
            
            
            
            
            
            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            js1.executeScript("window.scrollBy(0, 500);");
            
           
            
         // Pehle element visible hone ka wait karo
            WebElement regElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.id("Establishments_registered")
                )
            );

            // Phir text lo
            String rawText = regElement.getText().trim();
            System.out.println("Raw Text = " + rawText);

            int registeredCount = Integer.parseInt(rawText);
            System.out.println("Registered Establishments Count = " + registeredCount);

            Assert.assertTrue(
                registeredCount > 0,
                "Registered Establishments count should be greater than 0"
            );
          
            
            
            
            int registeredCount1 = Integer.parseInt(
            	    driver.findElement(
            	        By.id("Establishments_registered")
            	    ).getText().trim()
            	);

            	System.out.println(
            	    "Registered Establishments Count = " + registeredCount1
            	);

            	Assert.assertTrue(
            	    registeredCount1 > 0,
            	    "Registered Establishments count should be greater than 0"
            	);
            
            
            
            
            
            
            
            
            
            
            
           
            
            
            
            	int pcomplete = Integer.parseInt(
                	    driver.findElement(
                	        By.id("Establishments_registered_and_completed_profile")
                	    ).getText().trim()
                	);

                	System.out.println(
                	    "profile complete Count = " + pcomplete
                	);

                	Assert.assertTrue(
                			pcomplete > 0,
                	    "profile complete count should be greater than 0"
                	);
            	
            	
            	
                	
                	int nepf = Integer.parseInt(
                    	    driver.findElement(
                    	        By.id("Total_Establishment_Non_EPF")
                    	    ).getText().trim()
                    	);

                    	System.out.println(
                    	    "non epf Count = " + nepf
                    	);

                    	Assert.assertTrue(
                    			nepf > 0,
                    	    "non epf Count should be greater than 0"
                    	);
                	
                	
                	

                    	int vc = Integer.parseInt(
                        	    driver.findElement(
                        	        By.id("Vacancies_created")
                        	    ).getText().trim()
                        	);

                        	System.out.println(
                        	    "non epf Count = " + vc
                        	);

                        	Assert.assertTrue(
                        			vc > 0,
                        	    "non epf Count should be greater than 0"
                        	);
                    	
                    	
                    	
                    	
                        	
                        	 WebElement eregistration =
                                     wait.until(ExpectedConditions.elementToBeClickable(
                                             By.xpath("//a[@href='/Web/EstablishmentDashboard/EstablishmentDashboardDetailRpt?Flag=MQ%3D%3D&RptName=UmVnaXN0ZXJlZCBFc3RhYmxpc2htZW50cyBSZXBvcnQ%3D']")));
                             
                        	 eregistration.click();
                             System.out.println("✅ Clicked on establishment registration");
                             
                        	
                        	
                        	
                        	
                        	
                        	
                        	
                    	
            
            
        } catch (Exception e) {
            System.out.println("❌ Login + OTP Test Failed");
            e.printStackTrace();
            Assert.fail("Login + OTP automation failed");
        }
    }
}

