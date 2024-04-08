func illustration(banki: Int, ostatok: Int, count_steps: Int) {
    if count_steps == 0 {
        print("Jars")
        print(String(repeating: "F", count: banki))
    } else if count_steps % 2 == 1 {
        print("\(count_steps) step")
        print(String(repeating: "E", count: banki))
    } else {
        print("\(count_steps) step")
        print(String(repeating: "F", count: banki - ostatok))
        print(String(repeating: "E", count: ostatok))
    }
}

print("Input jar quantity:")
if let banki = Int(readLine() ?? ""), banki > 0 {
    print("Input exchange:")
    if let obmen = Int(readLine() ?? ""), obmen > 0 {
        var count_empty = 0
        var count_steps = 0
        var ostatok = 0
        var new_banki = banki

        while new_banki >= obmen {
            if count_steps == 0 {
                illustration(banki: new_banki, ostatok: ostatok, count_steps: count_steps)
            }
            count_steps += 1
            illustration(banki: new_banki, ostatok: ostatok, count_steps: count_steps)
            count_empty += new_banki - ostatok
            ostatok = new_banki % obmen
            new_banki = (new_banki / obmen) + ostatok
            count_steps += 1
            illustration(banki: new_banki, ostatok: ostatok, count_steps: count_steps)
        }

        if new_banki < obmen {
            count_empty += new_banki - ostatok
            count_steps += 1
            illustration(banki: new_banki, ostatok: ostatok, count_steps: count_steps)
            print("Jars drunk: \(count_empty)")
            print("Step count: \(count_steps)")
        }
    } else {
        print("Error")
    }
} else {
    print("Error")
}
