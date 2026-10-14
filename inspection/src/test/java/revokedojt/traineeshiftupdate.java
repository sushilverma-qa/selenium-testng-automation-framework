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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.time.Duration;

public class traineeshiftupdate extends basetest {

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
            username.sendKeys("ME2300000117");

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
            wait.until(ExpectedConditions.urlContains("EstablishmentDashboard"));

            String currentUrl1 = driver.getCurrentUrl();
            System.out.println("Current URL: " + currentUrl1);

            Assert.assertTrue(
                    currentUrl1.contains("EstablishmentDashboard"),
                    "❌ Login failed: Dashboard not loaded"
            );

            System.out.println("✅ Login Dashboard opened.");
            
            Thread.sleep(2000);
            
            
         // 🔹 Dashboard  Check
            WebElement dashboard = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//span[contains(@class,'h3') and normalize-space()='Dashboard']")));

            Assert.assertEquals(
                    dashboard.getText().trim(),
                    "Dashboard",
                    "Dashboard text mismatch");

            System.out.println("✅ Dashboard displayed with correct text");
           
            
            
            
            
            
            
            
            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            js1.executeScript("window.scrollBy(0, 500);");
            
           
            
         // Pehle element visible hone ka wait karo
            WebElement PublishedVacancies = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.id("Published_Vacancies")
                )
            );

            // Phir text lo
            String rawText = PublishedVacancies.getText().trim();
            System.out.println("Raw Text = " + rawText);

            int publishedCount = Integer.parseInt(rawText);
            System.out.println("Registered Establishments Count = " + publishedCount);

            Assert.assertTrue(
            		publishedCount > 0,
                "Published Vacancies count should be greater than 0"
            );
          
            
            
            
            int publishedCount1 = Integer.parseInt(
            	    driver.findElement(
            	        By.id("Published_Vacancies")
            	    ).getText().trim()
            	);

            	System.out.println(
            	    "Published Vacancies Count = " + publishedCount1
            	);

            	Assert.assertTrue(
            			publishedCount1 > 0,
            	    "Published Vacancies count should be greater than 0"
            	);
            
            
            
            
            	int ContractAcceptedAgainstInvitation = Integer.parseInt(
                	    driver.findElement(
                	        By.id("Contract_Accepted_Against_Invitation")
                	    ).getText().trim()
                	);

                	System.out.println(
                	    "ContractAcceptedAgainstInvitation Count = " + ContractAcceptedAgainstInvitation
                	);

                	Assert.assertTrue(
                			ContractAcceptedAgainstInvitation > 0,
                	    "Contract Accepted Against Invitation greater than 0"
                	);
            	
            	
            	
                	 JavascriptExecutor js2 = (JavascriptExecutor) driver;
                     js2.executeScript("window.scrollBy(0, 800);");
                     
                     Thread.sleep(8000);
                     
                	
                	
                	
                	
                	
                	
                	
                	int ContractAcceptedByApprovingAuthority = Integer.parseInt(
                    	    driver.findElement(
                    	        By.id("Contract_Accepted_By_Approving_Authority")
                    	    ).getText().trim()
                    	);

                    	System.out.println(
                    	    "Contract Accepted By Approving Authority = " + ContractAcceptedByApprovingAuthority
                    	);

                    	Assert.assertTrue(
                    			ContractAcceptedByApprovingAuthority > 0,
                    	    "Contract Accepted By Approving Authority Count should be greater than 0"
                    	);
                	
                	
                	

                    	int CandidateJoiningStatus = Integer.parseInt(
                        	    driver.findElement(
                        	        By.id("Candidate_Joining_Status")
                        	    ).getText().trim()
                        	);

                        	System.out.println(
                        	    "CandidateJoiningStatus = " + CandidateJoiningStatus
                        	);

                        	Assert.assertTrue(
                        			CandidateJoiningStatus > 0,
                        	    "CandidateJoiningStatus Count should be greater than 0"
                        	);
                    	
                    	
                    	
                    	
                        	
                        	 WebElement TraineeShiftUpdate =
                                     wait.until(ExpectedConditions.elementToBeClickable(
                                             By.xpath("//a[@href='/Web/TraineeShiftUpdate/Index']")));
                             
                        	 TraineeShiftUpdate.click();
                             System.out.println("✅ Clicked on TraineeShiftUpdate");
                             
                        	
                        	
                        	
                          //   WebElement search = wait.until(
                             //        ExpectedConditions.visibilityOfElementLocated(
                                    //     By.id("btnSearch")));
                                    
                                 
                             
                             
                          //   search.click();
                             
                             
                             
                             WebElement TraineeMMSKYID = wait.until(
                                     ExpectedConditions.visibilityOfElementLocated(By.id("MMSKY_ID"))
                             );
                             TraineeMMSKYID.sendKeys("302883682");    
                             
                             
                             
                             
                             
                             WebElement search = wait.until(
                                     ExpectedConditions.visibilityOfElementLocated(
                                         By.id("btnSearch")
                                     )
                                 );
                             
                             
                             search.click();
                             
                             
                            
                       //      WebElement checkbox = wait.until(
                            	  //      ExpectedConditions.elementToBeClickable(
                            	             //   By.xpath("//input[@type='checkbox' and @name='chkRelevant']")));

                            //	checkbox.click();

                            //	System.out.println("✅ Checkbox selected");
                             
                             
                             
                             
                             
                            	WebElement checkbox = wait.until(
                            	        ExpectedConditions.elementToBeClickable(
                            	                By.xpath("//input[@type='checkbox' and @name='chkRelevant']")));

                            	if (!checkbox.isSelected())
                            	{
                            	    checkbox.click();
                            	    System.out.println("✅ Checkbox selected");
                            	}
                            	else
                            	{
                            	    System.out.println("Checkbox is already selected");
                            	}
                             
                             
                            	WebElement shift = wait.until(
                            	        ExpectedConditions.visibilityOfElementLocated(
                            	                By.xpath("//select[@class='dropdown2 form-control form-select']")));

                            	Select select = new Select(shift);

                            	select.selectByVisibleText("Night Shift");

                            	System.out.println("✅ Night Shift selected");
                             
                             
                             
                            	
                            	WebElement startTime = driver.findElement(By.xpath("//input[@class='startTime']"));

                            	JavascriptExecutor js4 = (JavascriptExecutor) driver;

                            	js4.executeScript(
                            	    "arguments[0].value='23:00'; arguments[0].dispatchEvent(new Event('change'));",
                            	    startTime);

                            	System.out.println(startTime.getAttribute("value"));
                            	
                            	

                            	System.out.println("✅ Start Time entered successfully");
                            	
                            	System.out.println("Entered Value = " + startTime.getAttribute("value"));
                            	
                             
                            	WebElement endTime = driver.findElement(By.xpath("//input[@class='endTime']"));

                            	js.executeScript(
                            	    "arguments[0].value='07:00'; arguments[0].dispatchEvent(new Event('change'));",
                            	    endTime);
                            	
                            	
                            	

                            	System.out.println("✅ End Time entered successfully");
                            	
                            	
                            	WebElement remark = wait.until(
                            	        ExpectedConditions.elementToBeClickable(
                            	                By.xpath("//textarea[@class='remark form-control']")));

                            	remark.clear();
                            	remark.sendKeys("Shift Update successfully");

                            	System.out.println("✅ Remark entered successfully");
                            	
                            	
                            	
                            	 JavascriptExecutor js3 = (JavascriptExecutor) driver;
                                 js3.executeScript("window.scrollBy(0, 800);");
                                 
                                 Thread.sleep(8000);
                                 
                            	
                            	
                                 WebElement update = wait.until(
                                         ExpectedConditions.visibilityOfElementLocated(
                                             By.id("btnUpdate")
                                         )
                                     );
                                 
                                 
                                 update.click();
                            	
                            	
                            	
                                 WebElement no = wait.until(
                                         ExpectedConditions.visibilityOfElementLocated(
                                             By.id("modal-btn-no")
                                         )
                                     );
                                 
                                 
                                 no.click();
                                 
                                 
                                 
                                 WebElement update1 = wait.until(
                                         ExpectedConditions.visibilityOfElementLocated(
                                             By.id("btnUpdate")
                                         )
                                     );
                                 
                                 
                                 update1.click();
                                 
                                 
                                 
                                 WebElement yes = wait.until(
                                         ExpectedConditions.visibilityOfElementLocated(
                                             By.id("modal-btn-yes")
                                         )
                                     );
                                 
                                 
                                 yes.click();
                                 
                                 
                                 WebElement okButton = wait.until(
                                		    ExpectedConditions.elementToBeClickable(
                                		        By.xpath("//input[@value='Ok']")));

                                		okButton.click();

                                		System.out.println("✅ OK button clicked");
                                 
                                		
                                		
                                	
                                		
                                	//	JavascriptExecutor js7 = (JavascriptExecutor) driver;
                                      //   js7.executeScript("window.scrollBy(0, -800);");
                                         
                                       //  Thread.sleep(8000);
                                		
                                		
                                		
                                		
                                 
        } catch (Exception e) {
            System.out.println("❌ Login + OTP Test Failed");
            e.printStackTrace();
            Assert.fail("Login + OTP automation failed");
        }
    }
}


                             