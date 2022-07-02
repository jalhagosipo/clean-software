package affiliation

import Paycheck


interface Affiliation {
    fun calculateDeductions(pc: Paycheck): Double
}