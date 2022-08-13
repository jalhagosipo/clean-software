class UnixModemConfigurator: ModemVisitor {
    override fun visit(modem: HayesModem) {
        modem.configurationString = "&s1=4&D=3"
    }

    override fun visit(modem: ZoomModem) {
        modem.configurationValue = 42
    }

    override fun visit(modem: ErnieModem) {
        modem.internalPattern = "C is too slow"
    }
}