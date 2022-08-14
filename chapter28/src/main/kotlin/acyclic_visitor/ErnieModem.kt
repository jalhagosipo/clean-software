package acyclic_visitor

class ErnieModem: Modem {
    var internalPattern: String? = null

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
            val ev = v as ErnieModemVisitor
            ev.visit(this)
        } catch (e: ClassCastException) {
        }
    }
}