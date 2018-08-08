package fv

import utils.pow
import java.math.BigDecimal


/**
 * @constructor Creates object, that represents compounding future value calculation with lazy invocation and caching until
 * parameters are changed
 * @param pv Present value. For example, starting value of deposit.
 * @param pmt
 * @param annualRate Rate per period, should be in absolute value, for example, as 0.12. NOT AS 12%
 * @param years Number of years
 * @param capPeriodsPerYear Number of periods per year
 */
abstract class FutureValue(
        protected open val pv: BigDecimal,
        protected open val pmt: BigDecimal,
        protected open val annualRate: BigDecimal,
        protected open val years: BigDecimal,
        protected open val capPeriodsPerYear: BigDecimal) {

    private val npv by lazy { pv + pmt * capPeriodsPerYear * years }

    public val fv by lazy { calculateFv() }

    public val interest by lazy { fv - npv }

    public val yieldRate by lazy { interest / npv }

    public val effectiveRate by lazy {
        val factor = BigDecimal.ONE + (annualRate / capPeriodsPerYear)
        ((factor pow capPeriodsPerYear) - BigDecimal.ONE)
    }

    protected abstract fun calculateFv(): BigDecimal

    public val results by lazy { FutureValueResults(fv, interest, yieldRate, effectiveRate) }


    companion object {
        const val defaultScale = 12

        class AnnualRateScaleException : RuntimeException(
                "Annual rate scale should be at least $defaultScale, " +
                "or autoScaleChange should be set as false"
        )

        public fun rateScaleCheck(annualRate: BigDecimal, autoScaleChange: Boolean = false): BigDecimal {
            return if (annualRate.scale() < defaultScale) {
                if (autoScaleChange) {
                    annualRate.setScale(defaultScale)
                } else {
                    throw AnnualRateScaleException()
                }
            } else {
                annualRate
            }

        }
    }

}