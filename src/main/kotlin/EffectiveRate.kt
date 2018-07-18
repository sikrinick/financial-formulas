import cacheable.Calculable
import java.math.BigDecimal
import utils.pow

/**
 * @constructor Creates object, that represents effective rate with lazy invocation and caching until
 * parameters are changed
 * @param ratePerPeriod Rate per period, should be in percent value, for example, as 12%. NOT AS 0.12
 * @param periodsPerYear number of periods per year
 */
class EffectiveRate(
        ratePerPeriod: BigDecimal,
        periodsPerYear: BigDecimal
): Calculable<BigDecimal>() {
    companion object {
        val HUNDRED = 100.toBigDecimal()
    }

    /**
     * @constructor Creates object, that represents effective rate with lazy invocation and caching until
     * parameters are changed
     * @param r Annual rate, should be in percent value, for example, as 12%. NOT AS 0.12
     * @param m number of periods per year
     * @param n number of years
     */
    constructor(r: BigDecimal, m: BigDecimal, n: BigDecimal)
            : this(r.setScale(12) / m, m*n)

    /**
     * Annual rate. Marks result as non-cached on set
     */
    public var ratePerPeriod: BigDecimal by Calculable.Cacheable(ratePerPeriod)

    /**
     * Number of periods per year. Marks result as non-cached on set
     */
    public var periodsPerYear: BigDecimal by Calculable.Cacheable(periodsPerYear)

    /**
     * Calculates simple future value based on next formula:
     * Effective rate = (1 + r)^m or
     * @return result of calculations
     */
    override fun calculate(): BigDecimal {
        if (ratePerPeriod.scale() < 12) {
            ratePerPeriod = ratePerPeriod.setScale(12)
        }
        return (((BigDecimal.ONE + (ratePerPeriod / HUNDRED)) pow periodsPerYear) - BigDecimal.ONE) * HUNDRED
    }

}