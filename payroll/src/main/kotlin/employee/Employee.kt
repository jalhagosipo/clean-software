package employee

import Paycheck
import affiliation.AbstractAffiliation
import affiliation.Affiliation
import classification.PaymentClassification
import method.PaymentMethod
import schedule.PaymentSchedule
import java.util.*


class Employee(
        var empId: Int,
        private var name: String,
        private var address: String,
        private var pc: PaymentClassification,
        private var ps: PaymentSchedule,
        private var pm: PaymentMethod
) {

    private var affiliation: AbstractAffiliation? = null

    fun setName(name: String) {
        this.name = name
    }

    fun setAddress(address: String) {
        this.address = address
    }

    fun getName(): String {
        return this.name
    }

    fun getAddress(): String {
        return this.address
    }

    fun setClassification(pc: PaymentClassification) {
        this.pc = pc
    }

    fun setSchedule(ps: PaymentSchedule) {
        this.ps = ps
    }

    fun setMethod(pm: PaymentMethod) {
        this.pm = pm
    }

    fun <T : PaymentClassification?> getClassification(tClass: Class<T>): T {
        return tClass.cast(pc)
    }

    fun <T : PaymentSchedule?> getSchedule(tClass: Class<T>): T {
        return tClass.cast(ps)
    }

    fun <T : PaymentMethod?> getMethod(tClass: Class<T>): T {
        return tClass.cast(pm)
    }

    fun <T : Affiliation> getAffiliation(tClass: Class<T>): T {
        val result: Affiliation? = affiliation
        check(!(result === AbstractAffiliation.NONE)) { "affiliation is none" }
        return tClass.cast(result)
    }

    fun setAffiliation(af: AbstractAffiliation?) {
        this.affiliation = af
    }

    fun getAffiliation(): Affiliation? {
        return Optional.ofNullable(affiliation)
                .orElse(AbstractAffiliation.NONE)
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