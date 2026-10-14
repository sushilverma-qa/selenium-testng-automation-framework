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

public class ojtrevoked extends basetest {

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
                    
                   
                    	 System.out.println("✅ Second Inspection clicked successfully");
                    
                    	 WebElement revokemapojt =
                                 wait.until(ExpectedConditions.visibilityOfElementLocated(
                                         By.xpath("//a[@href='/Web/IOMapOJTLocation/IOMapOJTRevoke']")
                                 ));
                         
                         
                         
                       
                         JavascriptExecutor js14 = (JavascriptExecutor) driver;
                         js14.executeScript("arguments[0].click();", revokemapojt);
                         
                         

                         wait.until(ExpectedConditions.urlContains("IOMapOJTLocation/IOMapOJTRevoke"));

                         String currentUrl3 = driver.getCurrentUrl();
                         System.out.println("Current URL: " + currentUrl3);

                         Assert.assertTrue(
                                 currentUrl3.contains("IOMapOJTLocation/IOMapOJTRevoke"),
                                 "❌ Mapojt page not open"
                         );

                         System.out.println("✅ revoke maojt page opened.");

                      // 🔹 Thoda wait taaki dashboard fully render ho jaye
                         Thread.sleep(2000);

    
                 
                    
                         WebElement dropdown = wait.until(
                                 ExpectedConditions.elementToBeClickable(
                                     By.id("select2-ddlIO-container")
                                 )
                             );

                           // JavascriptExecutor js6 = (JavascriptExecutor) driver;     // yah kaam nahi kar raha he
                           //  js6.executeScript("arguments[0].click();", dropdown);          // yah kaam nahi kar raha he
                            
                             
                             js.executeScript("arguments[0].scrollIntoView({block:'center'});", dropdown);
                            dropdown.click();

                             System.out.println("✅ Inspection Officer dropdown opened");
                             
                             
                             Thread.sleep(1000);


                    
                    
                             
                             // 2️⃣ Get options AFTER dropdown opens
                             List<WebElement> options = wait.until(
                            		   ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            		       By.xpath("//li[@role='option' and contains(@class,'select2-results__option')]")));
                             
                             // visibilityOfElementLocated
                             // presenceOfAllElementsLocated
                          
                             System.out.println("📋 Available Inspection Officers:");

                             // 3️⃣ Select first valid option (NO stale issue)
                             for (int i = 0; i < options.size(); i++)        // option list he aur size () built in function he, define karne ki jarurat nahi hoti he easki
                             {

                            	    WebElement option = options.get(1);   // ith option uthao  // yah poora HTML de deta he  //1
                            	    String text = option.getText().trim();    // yah html me se text leta he.                //2

                            	    
                            	   // String text = options.get(i).getText();   // 1 aue 2 ko combine bhi likh sakte hain
                            	    System.out.println(text);

                            	    if (!text.equals("--Select IO Officer--")) 
                            	    {
                            	        option.click();        //3
                            	       // options.get(i).click();    // 3 ko ease bhi likh sakte hain yadi 1 and 2 ka use kiya he tab
                            	        System.out.println("✅ Selected: " + text);
                            	        break;
                            	    }
                            	}

                            
                             
                             WebElement searchBtn = wait.until(
                                     ExpectedConditions.visibilityOfElementLocated(
                                            // By.xpath("//button[@onclick='IOMapChange()']")
                                    		 By.xpath("//button[@id='btnSearch' and contains (@class, 'btn-primary' )]")
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
                              
                    
                    
                             WebElement dotBtn = wait.until(
                                     ExpectedConditions.visibilityOfElementLocated(
                                             By.xpath("//button[@id='dropdownBtn2']")));
                                    		 //By.id("dropdownBtn0")));
                                     
                             
                             dotBtn.click();
                             System.out.println("✅ action button clicked");
                             
                             Thread.sleep(2000);
                             
                             
                             
                            // WebElement rvkojtBtn = wait.until(
                                   //  ExpectedConditions.visibilityOfElementLocated(
                                        //     By.xpath("//a[@onclick='revokeIOMappedOJT(142,1011246,173,354,75)']")));
                                    		 //By.id("dropdownBtn0")));
                                 
                             
                           //  rvkojtBtn.click();
                             
                             
                             
                             List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
                             
                             int count = 0;
                             int maxIterations = 5; // safety limit

                             while (rows.size() > 0 && count < maxIterations) 

                          //   for (int i = 0; i < rows.size(); i++) 
                            // while (rows.size() > 0) 
                             {
                                // rows = driver.findElements(By.xpath("//table/tbody/tr"));

                                 WebElement currentRow = rows.get(0);
                                 
                                 // 👉 Step 1: Click Action (3 dots)
                                 WebElement actionBtn = currentRow.findElement(
                                     By.xpath(".//button[contains(@id,'dropdownBtn')]")
                                 );

                                 
                                // wait.until(ExpectedConditions.elementToBeClickable(actionBtn)).click();
                                // System.out.println("✅ Action clicked for row: " + (i+1));
                                
                                 wait.until(ExpectedConditions.elementToBeClickable(actionBtn)).click();

                                 System.out.println("✅ Action clicked");
                                 
                              // 👉 Step 2: Click Revoke (after dropdown opens)
                                 WebElement revokeBtn = wait.until(
                                     ExpectedConditions.elementToBeClickable(
                                         currentRow.findElement(By.xpath(".//a[contains(@onclick,'revokeIOMappedOJT')]"))
                                     )
                                 );

                                 revokeBtn.click();
                               //  System.out.println("✅ Revoke clicked for row: " + (i+1));
                                 System.out.println("✅ Revoke clicked");

                                 
                                 // 👉 Step 3: Handle confirmation
                                 WebElement yesBtn = wait.until(
                                         ExpectedConditions.visibilityOfElementLocated(
                                                // By.xpath("//a[@onclick='revokeIOMappedOJT(72,1011232,7555,26146,33)']")));
                                        		 By.id("modal-btn-yes")));
                                         
                                 
                                 yesBtn.click();
                                 System.out.println("✅ confirmation yes button clicked");
                                 
                                 WebElement okBtn = wait.until(
                                		    ExpectedConditions.elementToBeClickable(
                                		        By.xpath("//div[@class='modal-footer']//input[@value='Ok']")
                                		    )
                                		);
                              // 👉 Scroll + JS click (100% reliable)
                                 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", okBtn);

                                 System.out.println("✅ OK button clicked");

                            
                              // 👉 Wait till modal disappears (VERY IMPORTANT)
                               //  wait.until(ExpectedConditions.invisibilityOfElementLocated(
                                   //  By.xpath("//div[contains(@class,'modal') and contains(@style,'display: block')]")
                              //   ));
                                 
                                 wait.until(ExpectedConditions.invisibilityOfElementLocated(
                                	        By.xpath("//input[@value='Ok']")
                                	    ));

                              // 👉 Step 6: Refresh rows list
                                 rows = driver.findElements(By.xpath("//table/tbody/tr"));
                                 count++; // 🔥 important
                             }
                                // okBtn.click();
                             
                                		
                            

                               //  System.out.println("✅ Completed row: " + (i+1));
                             
                                 
                                 
                                 
                                 

                                
                                 

                             //    revokeBtn.click();

                                 // confirmation same
                          //   }
                             
                             
                             
                             
                             
                             
                             
                             
                             
                             
                             
                             
                             System.out.println("✅ Revoke Mapped OJT button clicked");
                             
                          
                             
                    
                 
                            // WebElement yesBtn = wait.until(
                                  //   ExpectedConditions.visibilityOfElementLocated(
                                            // By.xpath("//a[@onclick='revokeIOMappedOJT(72,1011232,7555,26146,33)']")));
                                    		// By.id("modal-btn-yes")));
                                     
                             
                           //  yesBtn.click();
                           //  System.out.println("✅ confirmation yes button clicked");
                             
                          //   Thread.sleep(2000);
                             
                             
                 
                 
                 
        } catch (Exception e) {
            System.out.println("❌ Login + OTP Test Failed");
            e.printStackTrace();
            Assert.fail("Login + OTP automation failed");
        }
    }
}

            
            
            
            


            
            
