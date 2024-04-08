import java.util.Scanner

fun illustration(banki: Int, ostatok: Int, countSteps: Int) {
    if (countSteps == 0) {
        println("Jars")
        println("F".repeat(banki))
    } else if (countSteps % 2 != 0) {
        println("$countSteps step")
        println("E".repeat(banki))
    } else {
        println("$countSteps step")
        println("F".repeat(banki - ostatok))
        println("E".repeat(ostatok))
    }
}

fun main() {
    var banki = 9
    var obmen = 3

    if (banki <= 0 || obmen <= 0) {
        println("Error")
    } else {
        var countEmpty = 0
        var countSteps = 0
        var ostatok = 0
        var newBanki = banki

        while (newBanki >= obmen) {
            if (countSteps == 0) {
                illustration(newBanki, ostatok, countSteps)
            }
            countSteps++
            illustration(newBanki, ostatok, countSteps)
            countEmpty += newBanki - ostatok
            ostatok = newBanki % obmen
            newBanki = (newBanki / obmen) + ostatok
            countSteps++
            illustration(newBanki, ostatok, countSteps)
        }

        if (newBanki < obmen) {
            countEmpty += newBanki - ostatok
            countSteps++
            illustration(newBanki, ostatok, countSteps)
            println("Jars drunk: $countEmpty")
            println("Step count: $countSteps")
        }
    }
}
