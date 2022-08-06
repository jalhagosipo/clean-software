interface Product {
    //인터페이스의 프로퍼티 선언
    //실제로는 getNickname() {} 이라는 비어있는 함수만 생성 됨
    //val nickname: String

    //주생성자에서 프로퍼티 override 로 구현하기
    //구현을하면 nickname 프로퍼티가 생성되고 생성자에서 할당이 됨
    //getNickname() { return nickname } 이 자동 생성 됨
    //class PrivateUser(override val nickname: String) : User

    val price: Int

    val name: String?

    val sku: String?
}