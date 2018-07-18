import org.junit.Test
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.math.BigDecimal

@RunWith(JUnit4::class)
class EffectiveRateTest {

    @Test
    fun sampleTest() {
        val rate = "10.000000"
        val testEf = "10.381289062500"

        val effectiveRate1 = EffectiveRate(
                rate.toBigDecimal().setScale(12) / 4.toBigDecimal(), 4.toBigDecimal())
                .result

        val effectiveRate2 = EffectiveRate(
                rate.toBigDecimal(), 4.toBigDecimal(), 1.toBigDecimal())
                .result

        assert(effectiveRate1.compareTo(testEf.toBigDecimal()) == 0)
        assert(effectiveRate2.compareTo(testEf.toBigDecimal()) == 0)
        assert(effectiveRate1.compareTo(effectiveRate2) == 0)
    }

}
