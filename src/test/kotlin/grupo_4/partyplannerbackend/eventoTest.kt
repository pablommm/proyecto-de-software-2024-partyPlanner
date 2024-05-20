package grupo_4.partyplannerbackend

import com.example.partyplannerbackend.Domain.*
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import java.time.LocalDate
import java.time.LocalDateTime

class eventoTest:DescribeSpec  ({
    isolationMode = IsolationMode.InstancePerTest


    val salonDiamante = Instalacion(
        nombreDeInstalacion = "Salon Diamante",
        descripcionDeInstalacion = "Esta es la descripcion de salon diamante lalalala lalal al al ala la la la",
        costoDeInstalacion = 800,
        CapacidadInstalacion = 80000,
        LocalidadDeInstalacion = "Buenos Aires",
        imagenPrincipal = "https://i.ibb.co/DwGzkdy/foto-salon-diamante.webp"
    )

    val catering = Servicio(
        nombreDeServicio = "Servicio de catering",
        descripcion = "esto es una descripcion lalalalalalalalalalalalalalalalala",
        categoria = Categoria.GASTRONOMIA,
        monto = 160.0)

    val catering2 = Servicio(
        nombreDeServicio = "Servicio de catering",
        descripcion = "esto es una descripcion lalalalalalalalalalalalalalalalala",
        categoria = Categoria.GASTRONOMIA,
        monto = 120.0)
    val fiestaCumpleaños = Evento(
        nombreDelEvento = "Fiesta de cumpleaños de Juan",
        lugar = salonDiamante,
        fechaEventoIni = LocalDateTime.now(),
        fechaEventoFin = LocalDateTime.now(),
        serviciosAdquiridos = mutableListOf(),
        presupuesto = 1000
    )

    it("verificamos si al iniciar el evento comienza con estado 1"){
        fiestaCumpleaños.estadoPresupuesto.shouldBe(1)
        fiestaCumpleaños.aniadirServicio(catering)
        fiestaCumpleaños.porcentajeGastado().shouldBe(84.0)
        //fiestaCumpleaños.actualizarEstadoDePresupuesto()
        //fiestaCumpleaños.estadoPresupuesto.shouldBe(2)
        fiestaCumpleaños.aniadirServicio(catering2)
        fiestaCumpleaños.actualizarEstadoDePresupuesto()
        fiestaCumpleaños.porcentajeGastado().shouldBe(96.0)
        fiestaCumpleaños.actualizarEstadoDePresupuesto()
        fiestaCumpleaños.estadoPresupuesto.shouldBe(3)

    }



}

)