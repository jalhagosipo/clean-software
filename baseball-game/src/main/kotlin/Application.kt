import java.util.*

// 0 - 9 가능
// 3자리 숫자 맞추기
// 같은 수가 같은 자리에 있으면 스트라이크
// 다른 자리에 있으면 볼
// 같은 수가 전혀 없으면 낫싱
// input이 잘못되면 안내메시지를 보여준다.
// 단, 컴퓨터가 만든 숫자(맞춰야하는 숫자)에는 다른 숫자로 구성됨


fun main() {

    val bg = BaseballGame(3)

    while (true) {
        val sc: Scanner = Scanner(System.`in`)
        val number = sc.nextLine()

        when (val score = bg.checkAnswer(number)) {
            "You win" -> {
                println("You win")
                break
            }
            else -> println(score)
        }
    }
}

class BaseballGame(val numDigit: Int = 3) {
    private val numbers = listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
    var answer: String = initialize()

    fun checkAnswer(guess: String): String {
        val validationResult = validate(guess)
        if (validationResult != "OK") {
            return validationResult
        }
        val scoreString = calculateScore(guess)
        return if (scoreString.contains("$numDigit Strike"))
            "You win"
        else
            scoreString
    }

    private fun initialize(): String {
        var ans = ""
        for (index: Int in 0 until numDigit) {
            while (true) {
                val index = (0..9).random()
                val char = numbers[index]
                if (!ans.contains(char)) {
                    ans += char
                    break
                }
            }
        }

        return ans
    }

    // 각 자리의 숫자에 중복이 없는지 확인
    private fun validate(guess: String): String {
        // 개수부족, 넘침
        // 같은 숫자는 안됨
        // 숫자가 아닌 것 입력

        if (guess.length != answer.length) {
            return "$numDigit 자리수를 입력해주세요."
        }

        val set = mutableSetOf<Char>()
        for (c in guess) {
            set.add(c)
        }
        if (set.size != guess.length) {
            return "같은 숫자를 입력하는 것은 안됩니다."
        }

        return "OK"
    }

    private fun calculateScore(guess: String): String {
        var ball = 0
        var strike = 0

        for ((idx, ch) in guess.withIndex()) {
            val i = answer.indexOf(ch)
            if (i >= 0) {
                if (i == idx) strike +=1
                else ball += 1
            }
        }

        return if (strike == 0 && ball == 0) {
            "Nothing"
        } else {
            "$strike Strike, $ball Ball"
        }
    }

}