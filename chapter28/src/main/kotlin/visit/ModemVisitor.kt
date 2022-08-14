package visit

interface ModemVisitor {
    fun visit(modem: HayesModem)
    fun visit(modem: ZoomModem)
    fun visit(modem: ErnieModem)
}
