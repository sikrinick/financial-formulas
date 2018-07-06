import utils.pow
import java.math.BigDecimal

/**
 * @constructor Creates object, that represents simple future value calculation with lazy invocation and caching until
 * parameters are changed
 * @param pv Present value. For example, starting value of deposit
 * @param r Annual rate, should be in percent value, for example, as 12%. NOT AS 0.12
 * @param m number of periods per year
 * @param n number of years
 */
class CompoundingFutureValue(
        pv: BigDecimal,
        r: BigDecimal,
        m: BigDecimal,
        n: BigDecimal
): Calculable<BigDecimal>() {

    /**
     * Present value, that marks result as non-cached on set
     */
    public var pv: BigDecimal by Calculable.Cacheable(pv)

    /**
     * Annual rate, that marks result as non-cached on set
     */
    public var r: BigDecimal by Calculable.Cacheable(r)

    /**
     * Periods per year, that marks result as non-cached on set
     */
    public var m: BigDecimal by Calculable.Cacheable(m)

    /**
     * Number of years, that marks result as non-cached on set
     */
    public var n: BigDecimal by Calculable.Cacheable(n)

    /**
     * Calculates simple future value based on next formula:
     * FV = PV * (1 + r/m)^mn
     * @return result of calculations
     */
    override fun calculate(): BigDecimal {
        if (r.scale() < 12) {
            r = r.setScale(12)
        }
        return pv * ((BigDecimal.ONE + (r / Calculable.HUNDRED / m)) pow (m * n))
    }

}


