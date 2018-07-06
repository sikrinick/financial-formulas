import org.junit.Test
import java.math.BigDecimal

class SimpleFutureValueTest {

    val TWO = 2.toBigDecimal()
    val THOUSAND = 1000.toBigDecimal()

    @Test
    fun basicSimpleTest() {
        val result1100 = SimpleFutureValue(THOUSAND, BigDecimal.TEN, BigDecimal.ONE).result
        val result1200 = SimpleFutureValue(THOUSAND, BigDecimal.TEN, TWO).result

        val expected1100 = 1100.toBigDecimal()
        val expected1200 = 1200.toBigDecimal()

        assert(result1100.compareTo(expected1100) == 0)
        assert(result1200.compareTo(expected1200) == 0)
    }
}