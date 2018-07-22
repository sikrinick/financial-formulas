package fv

import utils.pow
import java.math.BigDecimal

/**
 * @constructor Creates object, that represents compounding future value calculation
 * @param pmt Payment value. Shows how much money is added to deposit each period.
 * @param annualRate Annual rate, should be in absolute value, for example, as 0.12. NOT AS 12%
 * @param years Number of all years
 * @param capPeriodsPerYear Number of capitalization periods per year
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
     * FV = PMT * ((1 + r/m)^mn - 1) / r/m
     * @return result of calculations
     */
    override fun calculateFv(): BigDecimal {
        val ratePerPeriod = annualRate / capPeriodsPerYear
        val numberOfPeriods = years * capPeriodsPerYear
        return pmt * (((BigDecimal.ONE + ratePerPeriod) pow numberOfPeriods) - BigDecimal.ONE) / ratePerPeriod
    }

}


