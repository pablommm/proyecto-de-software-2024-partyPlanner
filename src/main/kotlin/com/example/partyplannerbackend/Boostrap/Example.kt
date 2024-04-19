package com.example.partyplannerbackend.Boostrap


import com.example.partyplannerbackend.DemoApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

class ServeLetInitializer : SpringBootServletInitializer(){

    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(DemoApplication::class.java)
    }
}