package fv.factory

import fv.*
import java.math.BigDecimal

object FutureValueFactory {

    public fun createStandard(
            pv: BigDecimal,
            annualRate: BigDecimal,
            years: BigDecimal,
            capPeriodsPerYear: BigDecimal = BigDecimal.ZERO,
            type: FutureValueType,
            autoScaleChange: Boolean = false
    ): FutureValue {
        val annualRateScaled = FutureValue.rateScaleCheck(annualRate, autoScaleChange)
        return when (type) {
            is Simple -> SimpleFutureValue(pv, annualRateScaled, years)
            is Compounding -> CompoundingFutureValue(pv, annualRateScaled, years, capPeriodsPerYear)
        }
    }

    public fun createAnnuity(
            pmt: BigDecimal,
            annualRate: BigDecimal,
            years: BigDecimal,
            capPeriodsPerYear: BigDecimal,
            type: FutureValueType,
            autoScaleChange: Boolean = false
    ): FutureValue {
        val annualRateScaled = FutureValue.rateScaleCheck(annualRate, autoScaleChange)
        return when (type) {
            is Simple -> throw WrongTypeException(type)
            is Compounding -> AnnuityCompoundingFutureValue(pmt, annualRateScaled, years, capPeriodsPerYear)
        }
    }

    class WrongTypeException(type: FutureValueType)
        : RuntimeException("This method doesn't support future value type: $type")

}