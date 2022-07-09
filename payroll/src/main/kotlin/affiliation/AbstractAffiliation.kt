package affiliation

import Paycheck


abstract class AbstractAffiliation : Affiliation {

    companion object {
        val NONE: AbstractAffiliation = object : AbstractAffiliation() {
            override fun calculateDeductions(pc: Paycheck): Double {
                return 0.0
            }
        }
    }
}