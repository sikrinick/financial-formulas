package utils

import ch.obermuhlner.math.big.BigDecimalMath
import java.math.BigDecimal
import java.math.MathContext


public infix fun BigDecimal.pow(other: BigDecimal): BigDecimal {
    return BigDecimalMath.pow(this, other, MathContext(this.precision()))
}