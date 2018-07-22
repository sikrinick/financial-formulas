import fv.CompoundingFutureValue
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.math.BigDecimal

@RunWith(JUnit4::class)
class CompoundingFutureValueTest {

    private val four = 4.toBigDecimal()
    private val twelve = 12.toBigDecimal()
    private val thousand = 1000.toBigDecimal()

    private val testPercent = "0.10".toBigDecimal().setScale(12)

    private val days360 = 360.toBigDecimal()
    private val days365 = 365.toBigDecimal()
    private val days366 = 366.toBigDecimal()

    @Test
    fun basicSimpleTest() {

        val result1 = CompoundingFutureValue(thousand, testPercent, BigDecimal.ONE, BigDecimal.ONE).fv
        val result4 = CompoundingFutureValue(thousand, testPercent, BigDecimal.ONE, four).fv
        val result12 = CompoundingFutureValue(thousand, testPercent, BigDecimal.ONE, twelve).fv

        val result360 = CompoundingFutureValue(thousand, testPercent, BigDecimal.ONE, days360).fv
        val result365 = CompoundingFutureValue(thousand, testPercent, BigDecimal.ONE, days365).fv
        val result366 = CompoundingFutureValue(thousand, testPercent, BigDecimal.ONE, days366).fv

        println("$result1")
        println("$result4")
        println("$result12")
        println("$result360")
        println("$result365")
        println("$result366")
    }
}