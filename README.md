# financial-formulas
Some financial formulas in Kotlin.

<b>SimpleFutureValue</b> - simple Future Value based on next formula: </br>
FV = PV * (1 + rt) </br>
FV - future value, PV - present value, r - annual rate, t - years
```
//FV = SimpleFutureValue(PV, r, t)
val fv = SimpleFutureValue(1000.toBigDecimal(), 10.toBigDecimal(), 1.toBigDecimal())
val result = fv.result //1100
```

<b>CompoundingFutureValue</b> - Future Value with compounding based on next formula: </br>
FV = PV * (1 + r/m)^mn </br>
FV - future value, PV - present value, r - annual rate, m - periods per year, n - number of years
```
//FV = CompoundingFutureValue(PV, r, m, n)
val fv = CompoundingFutureValue(1000.toBigDecimal(), 10.toBigDecimal(), 12.toBigDecimal(), 1.toBigDecimal())
val result = fv.result //1104.71306...
```
