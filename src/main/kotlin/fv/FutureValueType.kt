package fv

import java.math.BigDecimal

sealed class FutureValueType
object Simple: FutureValueType()
data class Compounding(val capPeriodsPerYear: BigDecimal): FutureValueType()