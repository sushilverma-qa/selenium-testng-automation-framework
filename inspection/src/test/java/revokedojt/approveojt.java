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

public class approveojt extends basetest {

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
                         
                         
                    //   WebElement viewdetails = wait.until(
                        		//ExpectedConditions.visibilityOfElementLocated(		
                        			
                  //     By.xpath("(//a[contains(@onclick,'ViewInspectionDetails')])[1]")));
                       
                        // viewdetails.click();
                         
                         
                         
                         
                         
                         
                         
                         int rowCount = driver.findElements(By.xpath("//table/tbody/tr")).size();

                         for (int i = 1; i <= rowCount; i++) {

                             // 👉 Wait table load
                             wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody/tr")));

                             // 👉 Dynamic XPath for each row
                             By viewXpath = By.xpath("(//table/tbody/tr)[" + i + "]//a[contains(@onclick,'ViewInspectionDetails')]");

                             WebElement viewDetails = wait.until(ExpectedConditions.presenceOfElementLocated(viewXpath));

                             // 👉 Scroll into view
                             ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewDetails);
                             Thread.sleep(1000);

                             // 👉 Click using JS (important for stability)
                             ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewDetails);

                             System.out.println("✅ Clicked row: " + i);

                             // 👉 Wait detail page load
                             //Click ke baad new page open hota hai, Yeh wait karta hai jab tak back button dikhe
                             
                            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='onBackFrm();']")));
                             
                             wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@onclick,'approveRequestDistrict')]")));
                             // 👉 Scroll page
                             for (int j = 0; j < 5; j++) {
                                 ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)");
                                 Thread.sleep(400);
                             }

                             WebElement approve = wait.until(
                                     ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@onclick,'approveRequestDistrict')]"))
                                 );
                                 approve.click();
                                 
                                 
                                 
                                 WebElement yesbtn = wait.until(
                                    		ExpectedConditions.visibilityOfElementLocated(		
                                    				//By.xpath("//a[@onclick='ViewInspectionDetails(81,1011246,11226,8961)']")));
                                  
                                   
                                 //  By.xpath("//a[contains(@onclick,'approveRequestDistrict')])[1]")));
                                   
                                   
                                   By.xpath("//button[@id='modal-btn-yes']")));
                                   
                               
                                   
                                  yesbtn.click();
                                   
                                   Thread.sleep(2000);
                                 
                                 
                             
                                   WebElement okBtn = wait.until(
                                		    ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Ok']"))
                                		);
                                		okBtn.click();
                             
                             
                                		Thread.sleep(2000);
                             
                             
                             
                             // 👉 Back button
                             WebElement back = wait.until(
                                 ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick='onBackFrm();']"))
                             );
                             back.click();

                             // 🔥 MOST IMPORTANT (fix issue) , Old page ka DOM completely remove hone ka wait karta hai
                            // Agar yeh nahi lagao:Selenium purane DOM me hi kaam karta rahega,👉 aur next row fail ho jayegi ❌ 


                             wait.until(ExpectedConditions.stalenessOf(back)); // old page gone

                             // 👉 Wait table reload, Back ke baad table dobara load hoti hai
                             wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody/tr")));

                             Thread.sleep(1500); // stability
                         }
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                       //  JavascriptExecutor js5 = (JavascriptExecutor) driver;

                      //   for (int i = 0; i < 5; i++) {                                     // yah top to bottom slow move karne ke liye he
                         //    js.executeScript("window.scrollBy(0, 200)");
                         //    Thread.sleep(500);   // delay → slow effect
                       //  }
                         
                         
                         
                         
                         
                      //   WebElement approve = wait.until(
                          	//	ExpectedConditions.visibilityOfElementLocated(		
                          			//	//By.xpath("//a[@onclick='ViewInspectionDetails(81,1011246,11226,8961)']")));
                        
                         
                       //  By.xpath("//a[contains(@onclick,'approveRequestDistrict')])[1]")));
                         
                         
                     //    By.xpath("(//button[contains(@onclick,'approveRequestDistrict')])[1]")));
                         
                    
                         
                        // approve.click();
                         
                        // Thread.sleep(2000);
                         
                         
                         
                      //   WebElement back = wait.until(
                           		//ExpectedConditions.visibilityOfElementLocated(		
                           	   //  By.xpath("//button[@onclick='onBackFrm();']")));
                          
                        // back.click();
                          
                        //  Thread.sleep(2000);
                         
                         
                         
                         
                         
                    
                        
                
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                 
                 
        } catch (Exception e) {
            System.out.println("❌ Login + OTP Test Failed");
            e.printStackTrace();
            Assert.fail("Login + OTP automation failed");
        }
    }
}

            
            
            
            


            
            
