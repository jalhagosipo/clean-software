// TODO 다른 예시를 가져오든지 코드 완성하든지
//import javax.swing.JList
//import javax.swing.JTextField
//import javax.swing.event.DocumentEvent
//import javax.swing.event.DocumentListener
//
//
//class QuickEntryMediator(
//        private val itsTextField: JTextField,
//        private val itsList: JList<*>
//) {
//
//  private fun textFieldChanged() {
//    val prefix = itsTextField.text
//    if (prefix.isEmpty()) {
//      itsList.clearSelection()
//      return
//    }
//    val m = itsList.model
//    var found = false
//    var i = 0
//    while (!found && i < m.size) {
//      val o = m.getElementAt(i)
//      val s = o.toString()
//      if (s.startsWith(prefix)) {
//        itsList.setSelectedValue(o, true)
//        found = true
//      }
//      i++
//    }
//    if (!found) {
//      itsList.clearSelection()
//    }
//  }
//
//  init {
//    itsTextField.document.addDocumentListener(
//            object : DocumentListener {
//              fun changedUpdate(e: DocumentEvent) {
//                textFieldChanged()
//              }
//
//              fun insertUpdate(e: DocumentEvent) {
//                textFieldChanged()
//              }
//
//              fun removeUpdate(e: DocumentEvent) {
//                textFieldChanged()
//              }
//            }
//    )
//  }
//}
