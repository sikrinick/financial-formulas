package fv

import java.math.BigDecimal

/**
 * @constructor Creates object, that represents compounding future value calculation with lazy invocation and caching until
 * parameters are changed
 * @param pv Present value. For example, starting value of deposit
 * @param ratePerPeriod Rate per period, should be in percent value, for example, as 12%. NOT AS 0.12
 * @param numberOfPeriods number of all periods
 */
class SimpleFutureValue(
        pv: BigDecimal,
        ratePerPeriod: BigDecimal,
        numberOfPeriods: BigDecimal
): FutureValue(pv, ratePerPeriod, numberOfPeriods) {

    /**
     * Calculates simple future value based on next formula:
     * FV = PV * (1 + rt)
     * @return result of calculations
     */
    override fun calculate(): BigDecimal {
        if (ratePerPeriod.scale() < 12) {
            ratePerPeriod = ratePerPeriod.setScale(12)
        }
        return pv * (BigDecimal.ONE + (ratePerPeriod / HUNDRED * numberOfPeriods))
    }

}


