package fv

import utils.pow
import java.math.BigDecimal


/**
 * @constructor Creates object, that represents compounding future value calculation with lazy invocation and caching until
 * parameters are changed
 * @param pv Present value. For example, starting value of deposit.
 * @param pmt
 * @param paymentsPerYear
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

    private val npv by lazy { fv - (pv + pmt * capPeriodsPerYear * years) }

    public val fv by lazy { calculateFv() }

    public val interest by lazy { fv - npv }

    public val yield by lazy { interest / npv }

    public val effectiveRate by lazy {
        val factor = BigDecimal.ONE + (annualRate / capPeriodsPerYear)
        ((factor pow capPeriodsPerYear) - BigDecimal.ONE)
    }

    protected abstract fun calculateFv(): BigDecimal

}