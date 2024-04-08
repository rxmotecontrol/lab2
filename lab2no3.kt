import java.util.Scanner

fun checkTimeFormat(num: Int): Boolean {
    if (num < 100) {
        return false
    }
    val hours = num / 100
    val minutes = num % 100

    return hours in 0..23 && minutes in 0..59
}

fun main() {
    val scanner = Scanner(System.in)
    print("Enter the number of test cases: ")
    val caseCount = scanner.nextInt()
    var i = 0

    while (i < caseCount) {
        print("Enter time format (hhmm) or -1 to exit: ")
        val num = scanner.nextInt()
        if (num == -1) {
            break
        }
        if (checkTimeFormat(num)) {
            println("YES")
        } else {
            println("NO")
        }
        i++
    }
}
