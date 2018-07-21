package fv

import utils.pow
import java.math.BigDecimal

/**
 * @constructor Creates object, that represents compounding future value calculation
 * @param pv Present value. For example, starting value of deposit
 * @param annualRate Annual rate, should be in absolute value, for example, as 0.12. NOT AS 12%
 * @param years Number of years
 * @param capPeriodsPerYear Number of capitalization periods per year
 */
class CompoundingFutureValue(
        override val pv: BigDecimal,
        override val annualRate: BigDecimal,
        override val years: BigDecimal,
        override val capPeriodsPerYear: BigDecimal
): FutureValue(
        pv = pv,
        pmt = BigDecimal.ZERO,
        annualRate = annualRate,
        years = years,
        capPeriodsPerYear = capPeriodsPerYear
) {
    /**
     * Calculates simple future value based on next formula:
     * FV = PV * (1 + r/m)^mn
     * @return result of calculations
     */
    override fun calculateFv(): BigDecimal {
        return pv * ((BigDecimal.ONE + annualRate / capPeriodsPerYear) pow (years * capPeriodsPerYear))
    }

}


