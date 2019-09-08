package com.rkodekar.selenium.pageObjects

import com.rkodekar.selenium.entities.Environment
import com.rkodekar.selenium.utils.HOME_BUTTON
import com.rkodekar.selenium.utils.SHOP_PAGE_URL
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class ShopPage (driver: WebDriver, environment: Environment) {

    private var driver: WebDriver? = null

    @FindBy(xpath = HOME_BUTTON)
    internal var _homeButton: WebElement? = null

    init {
        this.driver = driver
        PageFactory.initElements(driver, this)
    }

    fun checkIfShopPageIsDisplayed() = driver?.currentUrl?.equals(SHOP_PAGE_URL)

    fun checkIfHomeButtonIsDisplayed()  = _homeButton?.isDisplayed

    fun clickOnHomeButton () {
        _homeButton?.click()
    }
}