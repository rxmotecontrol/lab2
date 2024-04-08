package main

import (
	"fmt"
)

func main() {
	var m, n, mStart, nStart int
	var line string
	mCurr := 1
	nCurr := 1
	fmt.Println("Input m")
	fmt.Scan(&m)
	fmt.Println("Input n")
	fmt.Scan(&n)
	fmt.Println("Input line")
	fmt.Scan(&line)
	for _, char := range line {
		if char == 'L' {
			mCurr -= 1
		}
		if char == 'R' {
			mCurr += 1
		}
		if char == 'D' {
			nCurr += 1
		}
		if char == 'U' {
			nCurr -= 1
		}
	}
	if mCurr > m || nCurr > n {
		fmt.Println("Error")
	}
	if mCurr < 1 || nCurr < 1 {
		if mCurr < 1 {
			mStart = 2 - mCurr
		}
		if nCurr < 1 {
			nStart = 2 - nCurr
		}
		fmt.Println(mStart, nStart)
	} else {
		fmt.Println("1 1")
	}
}
