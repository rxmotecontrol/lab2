package main

import (
	"fmt"
)

func illustration(banki, ostatok, countSteps int) {
	if countSteps == 0 {
		fmt.Println("Jars")
		for i := 0; i < banki; i++ {
			fmt.Print("F")
		}
		fmt.Println()
	} else if countSteps%2 != 0 {
		fmt.Printf("%d step\n", countSteps)
		for i := 0; i < banki; i++ {
			fmt.Print("E")
		}
		fmt.Println()
	} else {
		fmt.Printf("%d step\n", countSteps)
		for i := 0; i < (banki - ostatok); i++ {
			fmt.Print("F")
		}
		fmt.Println()
		for i := 0; i < ostatok; i++ {
			fmt.Print("E")
		}
		fmt.Println()
	}
}

func main() {
	var banki, obmen int

	fmt.Println("Input jar quantity: ")
	fmt.Scan(&banki)

	fmt.Println("Input exchange: ")
	fmt.Scan(&obmen)

	if banki <= 0 || obmen <= 0 {
		fmt.Println("Error")
	} else {
		countEmpty := 0
		countSteps := 0
		ostatok := 0
		newBanki := banki

		for newBanki >= obmen {
			if countSteps == 0 {
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

		if newBanki < obmen {
			countEmpty += newBanki - ostatok
			countSteps++
			illustration(newBanki, ostatok, countSteps)
			fmt.Printf("Jars drunk: %d\n", countEmpty)
			fmt.Printf("Step count: %d\n", countSteps)
		}
	}
}
