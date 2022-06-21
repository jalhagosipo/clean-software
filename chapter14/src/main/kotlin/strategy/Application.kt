package strategy

interface Application {
    fun init()
    fun idle()
    fun cleanup()
    fun done(): Boolean
}