package fv

import cacheable.Calculable
import TimeValuable
import java.math.BigDecimal


/**
 * @constructor Creates object, that represents compounding future value calculation with lazy invocation and caching until
 * parameters are changed
 * @param pmt Payment value. Shows how much money is added to deposit each period.
 * @param ratePerPeriod Rate per period, should be in percent value, for example, as 12%. NOT AS 0.12
 * @param numberOfPeriods number of all periods
 */
abstract class AnnuityFutureValue(
        pmt: BigDecimal,
        ratePerPeriod: BigDecimal,
        numberOfPeriods: BigDecimal
): TimeValuable(ratePerPeriod, numberOfPeriods) {

    /**
     * Payment value. Marks result as non-cached on set
     */
    public var pmt: BigDecimal by Calculable.Cacheable(pmt)

}