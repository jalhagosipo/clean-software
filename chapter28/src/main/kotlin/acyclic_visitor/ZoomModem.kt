package acyclic_visitor

class ZoomModem: Modem {
    var configurationValue: Int = 0

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
            val zv = v as ZoomModemVisitor
            zv.visit(this)
        } catch (e: ClassCastException) {
        }
    }
}