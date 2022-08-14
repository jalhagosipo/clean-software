package acyclic_visitor

class HayesModem: Modem {
    var configurationString: String? = null

    override fun dial(pno: String) {
    }

    override fun hangup() {
    }

    override fun send(c: Char) {
    }

    override fun recv(): Char {
        return Char(0)
    }

    override fun accept(v: ModemVisitor) {
        try {
            val hv = v as HayesModemVisitor
            hv.visit(this)
        } catch (e: ClassCastException) {
        }
    }
}