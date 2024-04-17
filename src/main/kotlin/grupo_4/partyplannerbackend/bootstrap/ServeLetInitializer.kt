package grupo4.partyplannerbackend.bootstrap

import grupo_4.partyplannerbackend.PartyPlannerBackendApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

class ServeLetInitializer : SpringBootServletInitializer() {
    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(PartyPlannerBackendApplication::class.java)
    }

}