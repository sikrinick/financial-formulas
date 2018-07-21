package fv

import java.math.BigDecimal

/**
 * @constructor Creates object, that represents compounding future value
 * @param pv Present value. For example, starting value of deposit
 * @param annualRate Annual rate, should be in absolute value, for example, as 0.12. NOT AS 12%
 * @param years Number of years
 */
data class SimpleFutureValue(
        override val pv: BigDecimal,
        override val annualRate: BigDecimal,
        override val years: BigDecimal
): FutureValue(
        pv = pv,
        pmt = BigDecimal.ZERO,
        annualRate = annualRate,
        years = years,
        capPeriodsPerYear = 1.00.toBigDecimal() / years
) {

    /**
     * Calculates simple future value based on next formula:
     * FV = PV * (1 + rt)
     * @return result of calculations
     */
    override fun calculateFv(): BigDecimal {
        return pv * (BigDecimal.ONE + (annualRate * years))
    }

}


