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

public class ojtdetails extends basetest {

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
            username.sendKeys("mmsky.bhopal");

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

                            
                 
                    WebElement inspectionmenu =
                            wait.until(ExpectedConditions.visibilityOfElementLocated(
                                    By.xpath("//a[@data-toggle='collapse' and @data-target='#collapseUtilities1']")
                            ));
                    
                    
                    
                  //  ExpectedConditions.presenceOfElementLocated
                    JavascriptExecutor js13 = (JavascriptExecutor) driver;
                    js13.executeScript("arguments[0].click();", inspectionmenu);

                    System.out.println("✅ Utilities menu1 expanded");
                    Thread.sleep(1500);
                    
                   
                    	 System.out.println("✅ Inspection clicked successfully");
                    
                    	 WebElement mapojtdetails =
                                 wait.until(ExpectedConditions.visibilityOfElementLocated(
                                         By.xpath("//a[@href='/Web/IOMapOJTLocation/EstablishmentInspectionDetails']")
                                 ));
                         
                         
                         
                       
                         JavascriptExecutor js14 = (JavascriptExecutor) driver;
                         js14.executeScript("arguments[0].click();", mapojtdetails);
                         
                         

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

    
                 
                         
                         WebElement searchBtn = wait.until(
                                 ExpectedConditions.visibilityOfElementLocated(
                                        // By.xpath("//button[@onclick='IOMapChange()']")
                                		 By.xpath("//button[@id='btnAdd' and contains (@class, 'btn-primary' )]")
                                 )
                         );

                         JavascriptExecutor js1 = (JavascriptExecutor) driver;
                         js1.executeScript("arguments[0].click();", searchBtn);

                         System.out.println("✅ search button clicked");
                         
                         Thread.sleep(1000);
                         
                         WebElement downloadBtn = wait.until(
                                 ExpectedConditions.visibilityOfElementLocated(
                                        // By.xpath("//button[@onclick='IOMapChange()']")
                                		 By.id("exportBtn")));
                                 
                         
                         downloadBtn.click();
                         System.out.println("✅ Download button clicked");
                         
                         
                         Thread.sleep(2000);
                         
                         JavascriptExecutor js4 = (JavascriptExecutor) driver;
                         js4.executeScript("window.scrollBy(0, 500);");

                          // 🔹 Sirf dekhne ke liye (optional)
                          Thread.sleep(2000);

                          System.out.println("✅ Page scrolled down");

                         
                         
                         
                   
                          Thread.sleep(2000);
                          
                          
                          
                          
                        //  JavascriptExecutor js5 = (JavascriptExecutor) driver;
                         // js5.executeScript("window.scrollBy(600, 0);");

                           // 🔹 Sirf dekhne ke liye (optional)
                           //Thread.sleep(2000);

                          
                          
                          System.out.println("✅ Page scrolled right");

                         
                         
                   
                            
                        //  List<WebElement> actionBtns = driver.findElements(
                        		   // By.xpath("//button[contains(@id,'dropdownBtn')]")
                        	//	);

                        		//actionBtns.get(0).click(); // first row
                          
                          
                        		WebElement dotBtn = wait.until(
                        			  //  ExpectedConditions.elementToBeClickable(
                        			    		ExpectedConditions.visibilityOfElementLocated(		
                        			        By.xpath("(//button[contains(@id,'dropdownBtn')])[1]")
                        			    )
                        			);

                        		
                        			dotBtn.click();
                        	
                        System.out.println("✅ action button clicked");
                         
                         Thread.sleep(2000);
                         
                         
                       WebElement viewdetails = wait.until(
                        		ExpectedConditions.visibilityOfElementLocated(		
                        				//By.xpath("//a[@onclick='ViewInspectionDetails(81,1011246,11226,8961)']")));
                      
                       
                       By.xpath("(//a[contains(@onclick,'ViewInspectionDetails')])[1]")));
                       
                       
                       
                         viewdetails.click();
                         
                         
                         
                         JavascriptExecutor js5 = (JavascriptExecutor) driver;

                         for (int i = 0; i < 5; i++) {                                     // yah top to bottom slow move karne ke liye he
                             js.executeScript("window.scrollBy(0, 200)");
                             Thread.sleep(500);   // delay → slow effect
                         }
                         
                         
                         
                         
                         
                         WebElement approve = wait.until(
                          		ExpectedConditions.visibilityOfElementLocated(		
                          				//By.xpath("//a[@onclick='ViewInspectionDetails(81,1011246,11226,8961)']")));
                        
                         
                       //  By.xpath("//a[contains(@onclick,'approveRequestDistrict')])[1]")));
                         
                         
                         By.xpath("(//button[contains(@onclick,'approveRequestDistrict')])[1]")
                         )
                     );
                         
                         approve.click();
                         
                         Thread.sleep(2000);
                         
                         
                         
                         WebElement yesbtn = wait.until(
                           		ExpectedConditions.visibilityOfElementLocated(		
                           				//By.xpath("//a[@onclick='ViewInspectionDetails(81,1011246,11226,8961)']")));
                         
                          
                        //  By.xpath("//a[contains(@onclick,'approveRequestDistrict')])[1]")));
                          
                          
                          By.xpath("//button[@id='modal-btn-yes']")
                          )
                      );
                          
                         yesbtn.click();
                          
                          Thread.sleep(2000);
                         
                         
                         
                         
                         
                    
                        // WebElement dropdown = wait.until(
                               //  ExpectedConditions.elementToBeClickable(
                                  //   By.id("select2-ddlIO-container")));
                                 
                             

                           // JavascriptExecutor js6 = (JavascriptExecutor) driver;     // yah kaam nahi kar raha he
                           //  js6.executeScript("arguments[0].click();", dropdown);          // yah kaam nahi kar raha he
                            
                             
                          //   js.executeScript("arguments[0].scrollIntoView({block:'center'});", dropdown);
                         //   dropdown.click();

                           //  System.out.println("✅ Inspection Officer dropdown opened");
                             
                             
                           //  Thread.sleep(1000);


                    
                    
                             
                             // 2️⃣ Get options AFTER dropdown opens
                           //  List<WebElement> options = wait.until(
                            		 //  ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            		   //    By.xpath("//li[@role='option' and contains(@class,'select2-results__option')]")));
                             
                             // visibilityOfElementLocated
                             // presenceOfAllElementsLocated
                          
                            // System.out.println("📋 Available Inspection Officers:");

                             
                             
                
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                 
                 
        } catch (Exception e) {
            System.out.println("❌ Login + OTP Test Failed");
            e.printStackTrace();
            Assert.fail("Login + OTP automation failed");
        }
    }
}

            
            
            
            


            
            
