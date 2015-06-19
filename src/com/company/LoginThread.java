package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * Created by tgreen on 6/19/15.
 */
public class LoginThread implements Runnable{

    public void run(){
        Thread thread = Thread.currentThread();
        System.out.println("RunnableJob is being run by " + thread.getName() + " (" + thread.getId() + ")");
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/login.seam");

        // Find the text input element by its name
        WebElement username = driver.findElement(By.id("loginForm:username"));
        WebElement password = driver.findElement(By.id("loginForm:password"));
        WebElement submitButton = driver.findElement(By.id("loginForm:submit"));


        // Enter something to search for
        username.sendKeys("tgreen");
        password.sendKeys("citcarhc!3nm");

        // Now submit the form. WebDriver will find the form for us from the element
        submitButton.submit();

        WebElement welcomeMessage = driver.findElement(By.id("welcomeMessage"));
        // Check the title of the page
        System.out.println("Username: " + welcomeMessage.getText());

        //logout
        WebElement logout = driver.findElement(By.id("menuLogoutId"));
        logout.click();
        WebElement login = driver.findElement(By.id("menuLoginId"));
        System.out.println("Logged Out: " +login.isDisplayed());
        driver.quit();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
