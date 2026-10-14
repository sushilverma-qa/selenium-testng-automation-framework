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

public class mappedojt extends basetest {

    @Test
    public void loginTest() {
        try {
            driver.get("https://43.204.105.70/WEB/Login/Login");

            // ✅ Create wait ONLY ONCE
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Username
            WebElement username = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("username"))
            );
            username.sendKeys("mmsky.raisen");

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

            System.out.println("✅ Login. Dashboard opened.");

         // 🔹 Thoda wait taaki dashboard fully render ho jaye
            Thread.sleep(2000);

            // 🔹 Page scroll down (Y-axis)
            JavascriptExecutor js2 = (JavascriptExecutor) driver;
           js2.executeScript("window.scrollBy(0, 1200);");

            // 🔹 Sirf dekhne ke liye (optional)
            Thread.sleep(2000);

            System.out.println("✅ Page scrolled down");

                            
                 
                    WebElement revokemenu =
                            wait.until(ExpectedConditions.visibilityOfElementLocated(
                                    By.xpath("//a[@data-toggle='collapse' and @data-target='#collapseUtilities1']")
                            ));
                    
                    
                    
                  //  ExpectedConditions.presenceOfElementLocated
                    JavascriptExecutor js13 = (JavascriptExecutor) driver;
                    js13.executeScript("arguments[0].click();", revokemenu);

                    System.out.println("✅ Utilities menu1 expanded");
                    Thread.sleep(1500);
                    
                   
                    	 System.out.println("✅ third Inspection clicked successfully");
                    
                    	 WebElement revokemapojt =
                                 wait.until(ExpectedConditions.visibilityOfElementLocated(
                                         By.xpath("//a[@href='/Web/IOMapOJTLocation/EstablishmentInspectionDetails']")
                                 ));
                         
                         
                         
                       
                         JavascriptExecutor js14 = (JavascriptExecutor) driver;
                         js14.executeScript("arguments[0].click();", revokemapojt);
                         
                         

                         wait.until(ExpectedConditions.urlContains("IOMapOJTLocation/EstablishmentInspectionDetails"));

                         String currentUrl3 = driver.getCurrentUrl();
                         System.out.println("Current URL: " + currentUrl3);

                         Assert.assertTrue(
                                 currentUrl3.contains("IOMapOJTLocation/EstablishmentInspectionDetails"),
                                 "❌ Mapojt page not open"
                         );

                         System.out.println("✅ establishment details page opened.");

                      // 🔹 Thoda wait taaki dashboard fully render ho jaye
                         Thread.sleep(2000);

    
                 
                    
                     
                             
                             
                             

                             WebElement dropdown = wait.until(
                                     ExpectedConditions.elementToBeClickable(
                                         By.id("select2-IODropDown-container")));
                                  
                        
                             dropdown.click();
                             
                             WebElement searchBox = wait.until(
                            		    ExpectedConditions.visibilityOfElementLocated(
                            		        By.xpath("//input[@class='select2-search__field']")
                            		    )
                            		);
                             searchBox.sendKeys("raisen (IO2500000054)");
                             
                             
                             
                             WebElement option = wait.until(
                            		    ExpectedConditions.elementToBeClickable(
                            		        By.xpath("//li[contains(@class,'select2-results__option') and contains(text(),'raisen (IO2500000054)')]")
                            		    )
                            		);
                            		option.click();

                            		System.out.println("✅ Inspection Officer selected");
                             
                             
                            		 WebElement search = wait.until(
                                 		    ExpectedConditions.visibilityOfElementLocated(
                                 		        By.xpath("//button[@id='btnAdd' and @onclick='OnSearch();']")
                                 		    )
                                 		);
                                  search.click();

                            		
                            		
                            		
                            		
                            
        } catch (Exception e) {
            System.out.println("❌ Login + OTP Test Failed");
            e.printStackTrace();
            Assert.fail("Login + OTP automation failed");
        }
    }
}

            
            
            
            


            
            
