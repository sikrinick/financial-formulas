package fv

import Calculable
import TimeValuable
import java.math.BigDecimal


/**
 * @constructor Creates object, that represents compounding future value calculation with lazy invocation and caching until
 * parameters are changed
 * @param pv Present value. For example, starting value of deposit.
 * @param ratePerPeriod Rate per period, should be in percent value, for example, as 12%. NOT AS 0.12
 * @param numberOfPeriods number of all periods
 */
abstract class FutureValue(
        pv: BigDecimal,
        ratePerPeriod: BigDecimal,
        numberOfPeriods: BigDecimal
): TimeValuable(ratePerPeriod, numberOfPeriods) {

    /**
     * Present value. Marks result as non-cached on set
     */
    public var pv: BigDecimal by Calculable.Cacheable(pv)

}