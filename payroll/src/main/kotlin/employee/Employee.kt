package employee

import Paycheck
import affiliation.AbstractAffiliation
import affiliation.Affiliation
import classification.PaymentClassification
import method.PaymentMethod
import schedule.PaymentSchedule
import java.util.*


data class Employee(
        var empId: Int,
        var name: String,
        var address: String,
        var pc: PaymentClassification,
        var ps: PaymentSchedule,
        var pm: PaymentMethod
) {

    var affiliation: AbstractAffiliation? = null
        get() = field ?: AbstractAffiliation.NONE

    fun <T : Affiliation> getAffiliation(tClass: Class<T>): T {
        val result: Affiliation? = affiliation
        check(!(result === AbstractAffiliation.NONE)) { "affiliation is none" }
        return tClass.cast(result)
    }

    fun isPayDate(payDate: Date): Boolean {
        return ps.isPayDate(payDate)
    }

    fun payday(payDate: Date): Paycheck {
        val paycheck = Paycheck(getPayPeriodStartDate(payDate), payDate)
        val grossPay: Double = pc.calculatePay(paycheck) // 총 임금
        val deductions: Double = when (affiliation) {
            null -> 0.0
            else -> affiliation!!.calculateDeductions(paycheck)
        }  // 공제
        paycheck.details(grossPay, deductions)
        pm.pay(paycheck)
        return paycheck
    }

    private fun getPayPeriodStartDate(payPeriodEndDate: Date): Date {
        return ps.getPayPeriodStartDate(payPeriodEndDate)
    }
}