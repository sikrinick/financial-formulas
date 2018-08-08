package fv

import java.math.BigDecimal

data class FutureValueResults(val fv: BigDecimal,
                              val interest: BigDecimal,
                              val yieldRate: BigDecimal,
                              val effectiveRate: BigDecimal)