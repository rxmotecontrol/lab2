use std::io;

fn illustration(banki: i32, ostatok: i32, count_steps: i32) {
    if count_steps == 0 {
        println!("Jars");
        for _ in 0..banki {
            print!("F");
        }
        println!();
    } else if count_steps % 2 != 0 {
        println!("{} step", count_steps);
        for _ in 0..banki {
            print!("E");
        }
        println!();
    } else {
        println!("{} step", count_steps);
        for _ in 0..(banki - ostatok) {
            print!("F");
        }
        println!();
        for _ in 0..ostatok {
            print!("E");
        }
        println!();
    }
}

fn main() {
    let mut input = String::new();

    println!("Input jar quantity: ");
    io::stdin().read_line(&mut input).unwrap();
    let banki: i32 = input.trim().parse().unwrap();
    input.clear();

    println!("Input exchange: ");
    io::stdin().read_line(&mut input).unwrap();
    let obmen: i32 = input.trim().parse().unwrap();

    if banki <= 0 || obmen <= 0 {
        println!("Error");
    } else {
        let mut count_empty = 0;
        let mut count_steps = 0;
        let mut ostatok = 0;
        let mut new_banki = banki;

        while new_banki >= obmen {
            if count_steps == 0 {
                illustration(new_banki, ostatok, count_steps);
            }
            count_steps += 1;
            illustration(new_banki, ostatok, count_steps);
            count_empty += new_banki - ostatok;
            ostatok = new_banki % obmen;
            new_banki = (new_banki / obmen) + ostatok;
            count_steps += 1;
            illustration(new_banki, ostatok, count_steps);
        }

        if new_banki < obmen {
            count_empty += new_banki - ostatok;
            count_steps += 1;
            illustration(new_banki, ostatok, count_steps);
            println!("Jars drunk: {}", count_empty);
            println!("Step count: {}", count_steps);
        }
    }
}
