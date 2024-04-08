fun main() {
    var m: Int
    var n: Int
    var mStart = 0
    var nStart = 0
    var isOver = false

    println("Enter m:")
    m = 3
    println("Enter n:")
    n = 3
    println("Enter line:")
    val line = "DDR"

    var mCurr = 1
    var nCurr = 1

    if (m < 1 || n < 1) {
        println("Error")
    } else {
        for (i in line) {
            when (i) {
                'L' -> mCurr -= 1
                'R' -> mCurr += 1
                'D' -> nCurr += 1
                'U' -> nCurr -= 1
            }

            if (mCurr > m || nCurr > n) {
                println("Error")
                isOver = true
                break
            }
        }

        if (mCurr < 1 || nCurr < 1) {
            if (mCurr < 1) {
                mStart = 2 + Math.abs(mCurr)
            }
            if (nCurr < 1) {
                nStart = 2 + Math.abs(nCurr)
            }
            println("$mStart $nStart")
        } else if (!isOver) {
            println("1 1")
        }
    }
}
