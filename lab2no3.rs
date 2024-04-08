use std::io;

fn check_time_format(num: i32) -> bool {
    if num < 100 {
        return false;
    }
    let hours = num / 100;
    let minutes = num % 100;

    return (0..=23).contains(&hours) && (0..=59).contains(&minutes);
}

fn main() {
    println!("Enter the number of test cases:");
    let mut input = String::new();
    io::stdin().read_line(&mut input).expect("Failed to read line");
    let case_count: i32 = input.trim().parse().expect("Please enter a number");

    let mut i = 0;
    while i < case_count {
        println!("Enter time format (hhmm) or -1 to exit:");
        input.clear();
        io::stdin().read_line(&mut input).expect("Failed to read line");
        let num: i32 = input.trim().parse().expect("Please enter a number");

        if num == -1 {
            break;
        }

        if check_time_format(num) {
            println!("YES");
        } else {
            println!("NO");
        }

        i += 1;
    }
}
