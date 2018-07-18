import cacheable.Calculable
import java.math.BigDecimal

/**
 * @constructor Creates object, that represents compounding future value calculation with lazy invocation and caching until
 * parameters are changed
 * @param ratePerPeriod Rate per period, should be in percent value, for example, as 12%. NOT AS 0.12
 * @param numberOfPeriods number of all periods
 */
abstract class TimeValuable(
        ratePerPeriod: BigDecimal,
        numberOfPeriods: BigDecimal
): Calculable<BigDecimal>() {
    companion object {
        val HUNDRED = 100.toBigDecimal()
    }

    /**
     * Annual rate. Marks result as non-cached on set
     */
    public var ratePerPeriod: BigDecimal by Calculable.Cacheable(ratePerPeriod)

    /**
     * Number of all periods. Marks result as non-cached on set
     */
    public var numberOfPeriods: BigDecimal by Calculable.Cacheable(numberOfPeriods)


}