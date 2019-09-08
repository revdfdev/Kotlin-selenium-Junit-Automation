package com.rkodekar.selenium.pageObjects

import com.rkodekar.selenium.entities.Environment
import com.rkodekar.selenium.utils.SLIDER_CONTAINER
import com.rkodekar.selenium.utils.SLIDES
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class HomePage (driver: WebDriver, environment: Environment) {

    private var driver: WebDriver? = null

    @FindBy(className = SLIDER_CONTAINER)
    internal var _container: WebElement? = null

    init {
        this.driver = driver
        PageFactory.initElements(driver, this)
    }

    fun isSliderContainerDisplayed () = _container?.isDisplayed

    fun sliders () = _container?.findElements(By.xpath(SLIDES))
}