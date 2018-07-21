package fv

import utils.pow
import java.math.BigDecimal

/**
 * @constructor Creates object, that represents compounding future value calculation with lazy invocation and caching until
 * parameters are changed
 * @param pmt Payment value. Shows how much money is added to deposit each period.
 * @param ratePerPeriod Rate per period, should be in percent value, for example, as 12%. NOT AS 0.12
 * @param numberOfPeriods number of all periods
 */
data class AnnuityCompoundingFutureValue(
        override val pmt: BigDecimal,
        override val annualRate: BigDecimal,
        override val years: BigDecimal,
        override val capPeriodsPerYear: BigDecimal
): FutureValue(
        pv = BigDecimal.ZERO,
        pmt = pmt,
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
        val ratePerPeriod = annualRate / capPeriodsPerYear
        val numberOfPeriods = years * capPeriodsPerYear
        return pmt * (((BigDecimal.ONE + ratePerPeriod) pow numberOfPeriods) - BigDecimal.ONE) / ratePerPeriod
    }

}


