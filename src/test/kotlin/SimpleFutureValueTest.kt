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

        val result1100 = SimpleFutureValue(thousand, tenPercent, BigDecimal.ONE)
        val result1200 = SimpleFutureValue(thousand, tenPercent, two)

        val fv1 = 1100.toBigDecimal()
        val fv2 = 1200.toBigDecimal()

        val interest1 = 100.toBigDecimal()
        val interest2 = 200.toBigDecimal()

        val yield1 = "0.10".toBigDecimal()
        val yield2 = "0.20".toBigDecimal()

        val er1 = "0.10".toBigDecimal()
        val er2 = "0.10".toBigDecimal()

        assert(result1100.fv.compareTo(fv1) == 0)
        assert(result1200.fv.compareTo(fv2) == 0)

        assert(result1100.interest.compareTo(interest1) == 0)
        assert(result1200.interest.compareTo(interest2) == 0)

        assert(result1100.yieldRate.compareTo(yield1) == 0)
        assert(result1200.yieldRate.compareTo(yield2) == 0)

        assert(result1100.effectiveRate.compareTo(er1) == 0)
        assert(result1200.effectiveRate.compareTo(er2) == 0)


    }
}