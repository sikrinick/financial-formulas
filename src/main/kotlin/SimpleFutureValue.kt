import java.math.BigDecimal

/**
 * @constructor Creates object, that represents simple future value calculation with lazy invocation and caching until
 * parameters are changed
 * @param pv Present value. For example, starting value of deposit
 * @param r Annual rate, should be in percent value, for example, as 12%. NOT AS 0.12
 * @param t Term in years
 */
class SimpleFutureValue(
        pv: BigDecimal,
        r: BigDecimal,
        t: BigDecimal
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
     * Term, that marks result as non-cached on set
     */
    public var t: BigDecimal by Calculable.Cacheable(t)

    /**
     * Calculates simple future value based on next formula:
     * FV = PV * ( 1 + rt)
     * @return result of calculations
     */
    override fun calculate(): BigDecimal {
        if (r.scale() < 12) {
            r = r.setScale(12)
        }
        return pv * (BigDecimal.ONE + (r / Calculable.HUNDRED * t))
    }

}


