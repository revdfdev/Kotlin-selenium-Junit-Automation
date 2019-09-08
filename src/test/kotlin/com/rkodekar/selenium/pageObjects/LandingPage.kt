package com.rkodekar.selenium.pageObjects

import com.rkodekar.selenium.entities.Environment
import com.rkodekar.selenium.utils.SHOP_BUTTON
import junit.framework.Assert
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import java.util.concurrent.TimeUnit
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt

class LandingPage (driver: WebDriver, val environment: Environment) {

    private var driver: WebDriver? = null

    @FindBy(xpath = SHOP_BUTTON)
    internal var _shopButton: WebElement? = null

    init {
        this.driver = driver
        PageFactory.initElements(driver, this)
    }


    fun openLandingPage() {
        driver?.manage()?.deleteAllCookies()
        driver?.manage()?.window()?.maximize()
        driver?.manage()?.timeouts()?.implicitlyWait(30, TimeUnit.SECONDS)
        driver?.manage()?.timeouts()?.pageLoadTimeout(30, TimeUnit.SECONDS)
        driver?.get(environment.shop.base.url)
    }

    fun checkIfShopButtonIsDisplayed() = _shopButton?.isDisplayed

    fun clickOnShopButton() {
        _shopButton?.click()
    }
}