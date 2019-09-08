package com.rkodekar.selenium.entities

data class Base(val url: String)
data class Shop(val base: Base)
data class Environment(val shop: Shop);