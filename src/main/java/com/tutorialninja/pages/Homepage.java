package com.tutorialninja.pages;

import com.tutorialninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Homepage extends Utility {
    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        }
    }

    By mouseHoverDesktop = By.linkText("Desktops");
    By desktopText = By.xpath("//h2[contains(text(),'Desktops')]");

    By mouseHoverLaptopAndNotebooks = By.linkText("Laptops & Notebooks");
    By laptopAndNotebookText = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");
    By mouseHoverComponents = By.linkText("Components");
    By componentsText = By.xpath("//h2[contains(text(),'Components')]");


    //********************************************************************

    //1.1 Mouse hover on “Desktops” Tab and click
    public void showAllDesktop(){
        mouseHoverToElement(mouseHoverDesktop);
        selectMenu("Show All Desktops");
    }
    public String verifyDesktopText(){
        return getTextFromElement(desktopText);
    }

    //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
    public void showAllLaptopAndNotebook(){
        mouseHoverToElement(mouseHoverLaptopAndNotebooks);
        selectMenu("Show All Laptops & Notebooks");
    }
    public String verifyLaptopAndNotebookText(){
        return getTextFromElement(laptopAndNotebookText);
    }

    //3.1 Mouse hover on “Components” Tab and click
    public void showAllComponents(){
        mouseHoverToElement(mouseHoverComponents);
        selectMenu("Show All Components");
    }
    public String verifyComponentsText(){
        return getTextFromElement(componentsText);
    }

}
