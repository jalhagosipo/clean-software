package affiliation

import Paycheck


internal interface Affiliation {
    fun calculateDeductions(pc: Paycheck): Double
}