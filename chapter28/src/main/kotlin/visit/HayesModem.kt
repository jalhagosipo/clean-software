package visit

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
        v.visit(this)
    }
}