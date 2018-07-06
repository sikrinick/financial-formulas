import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.math.BigDecimal

@RunWith(JUnit4::class)
class CompoundingFutureValueTest {

    val TWO = 2.toBigDecimal()
    val FOUR = 4.toBigDecimal()
    val TWELVE = 12.toBigDecimal()
    val THOUSAND = 1000.toBigDecimal()

    val DAYS_360 = 360.toBigDecimal()
    val DAYS_365 = 365.toBigDecimal()
    val DAYS_366 = 366.toBigDecimal()

    @Test
    fun basicSimpleTest() {
        val testPercent = BigDecimal.TEN
        
        val result1_1 = CompoundingFutureValue(THOUSAND, testPercent, BigDecimal.ONE, BigDecimal.ONE).result
        val result1_4 = CompoundingFutureValue(THOUSAND, testPercent, BigDecimal.ONE, FOUR).result

        val result4_1 = CompoundingFutureValue(THOUSAND, testPercent, FOUR, BigDecimal.ONE).result
        val result4_4 = CompoundingFutureValue(THOUSAND, testPercent, FOUR, FOUR).result

        val result12_1 = CompoundingFutureValue(THOUSAND, testPercent, TWELVE, BigDecimal.ONE).result
        val result12_4 = CompoundingFutureValue(THOUSAND, testPercent, TWELVE, FOUR).result

        val result12_1_sec = CompoundingFutureValue(THOUSAND, testPercent.setScale(12) / TWELVE, TWELVE).result
        val result12_4_sec = CompoundingFutureValue(THOUSAND, testPercent.setScale(12) / TWELVE,  TWELVE * FOUR).result

        assert(result12_1_sec == result12_1)
        assert(result12_4_sec == result12_4)

        val result360_1 = CompoundingFutureValue(THOUSAND, testPercent, DAYS_360, BigDecimal.ONE).result
        val result360_4 = CompoundingFutureValue(THOUSAND, testPercent, DAYS_360, FOUR).result

        val result365_1 = CompoundingFutureValue(THOUSAND, testPercent, DAYS_365, BigDecimal.ONE).result
        val result365_4 = CompoundingFutureValue(THOUSAND, testPercent, DAYS_365, FOUR).result

        val result366_1 = CompoundingFutureValue(THOUSAND, testPercent, DAYS_366, BigDecimal.ONE).result
        val result366_4 = CompoundingFutureValue(THOUSAND, testPercent, DAYS_366, FOUR).result

        println("$result1_1, $result1_4")
        println("$result4_1, $result4_4")
        println("$result12_1, $result12_4")
        println("$result360_1, $result360_4")
        println("$result365_1, $result365_4")
        println("$result366_1, $result366_4")
    }
}