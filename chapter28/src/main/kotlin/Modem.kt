interface Modem {
    fun dial(pno: String)
    fun hangup()
    fun send(c: Char)
    fun recv(): Char
    fun accept(v: ModemVisitor)
}