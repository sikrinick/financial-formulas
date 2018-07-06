package fv

import utils.pow
import java.math.BigDecimal

/**
 * @constructor Creates object, that represents compounding future value calculation with lazy invocation and caching until
 * parameters are changed
 * @param pv Present value. For example, starting value of deposit
 * @param ratePerPeriod Rate per period, should be in percent value, for example, as 12%. NOT AS 0.12
 * @param numberOfPeriods number of all periods
 */
class CompoundingFutureValue(
        pv: BigDecimal,
        ratePerPeriod: BigDecimal,
        numberOfPeriods: BigDecimal
): FutureValue(pv, ratePerPeriod, numberOfPeriods) {

    /**
     * @constructor Creates object, that represents simple future value calculation with lazy invocation and caching until
     * parameters are changed
     * @param pv Present value. For example, starting value of deposit
     * @param r Annual rate, should be in percent value, for example, as 12%. NOT AS 0.12
     * @param m number of periods per year
     * @param n number of years
     */
    constructor(pv: BigDecimal, r: BigDecimal, m: BigDecimal, n: BigDecimal)
            : this(pv, r.setScale(12) / m, m*n)

    /**
     * Calculates simple future value based on next formula:
     * FV = PV * (1 + r/m)^mn
     * @return result of calculations
     */
    override fun calculate(): BigDecimal {
        if (ratePerPeriod.scale() < 12) {
            ratePerPeriod = ratePerPeriod.setScale(12)
        }
        return pv * ((BigDecimal.ONE + (ratePerPeriod / HUNDRED)) pow numberOfPeriods)
    }

}


