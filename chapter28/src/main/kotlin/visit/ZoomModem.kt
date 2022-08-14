package visit

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
        v.visit(this)
    }
}