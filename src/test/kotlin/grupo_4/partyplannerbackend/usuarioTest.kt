package grupo_4.partyplannerbackend

import com.example.partyplannerbackend.Domain.Usuario
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import java.time.LocalDate

class usuarioTest:DescribeSpec  ({
    isolationMode = IsolationMode.InstancePerTest
    val evento1 =
    val usuario1 = Usuario(nombreYApellido = "san martin", username = "san_martin",id= 5, contrasenia = "1234",eventos= MutableList())
}

)