import fv.SimpleFutureValue
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.math.BigDecimal

@RunWith(JUnit4::class)
class SimpleFutureValueTest {

    private val two = "2.00".toBigDecimal()
    private val tenPercent = "0.10".toBigDecimal()
    private val thousand = "1000.00".toBigDecimal()


    @Test
    fun basicSimpleTest() {

        val result1100 = SimpleFutureValue(thousand, tenPercent, BigDecimal.ONE).fv
        val result1200 = SimpleFutureValue(thousand, tenPercent, two).fv

        val expected1100 = 1100.toBigDecimal()
        val expected1200 = 1200.toBigDecimal()

        assert(result1100.compareTo(expected1100) == 0)
        assert(result1200.compareTo(expected1200) == 0)
    }
}