package com.rkodekar.selenium.yamlutils

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.rkodekar.selenium.entities.Environment
import com.rkodekar.selenium.entities.Shop
import java.io.Closeable
import java.io.File
import java.io.IOException

class YamlUtils(file: File): Closeable  {

    private var file: File?

    init  {
        if (!file.exists()) throw IOException("Required environment file is not found") else this.file = file
    }

    fun compute () = ObjectMapper(YAMLFactory()).registerKotlinModule().readValue(file, Environment::class.java)

    override fun close() {
        file = null
    }
}