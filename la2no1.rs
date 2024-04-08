use std::io;

fn main() {
    let mut m_start: Option<i32> = None;
    let mut n_start: Option<i32> = None;

    let mut m = String::new();
    let mut n = String::new();
    let mut line = String::new();

    println!("Enter m:");
    io::stdin().read_line(&mut m).expect("Failed to read input.");
    let m: i32 = m.trim().parse().expect("Please enter a number.");

    println!("Enter n:");
    io::stdin().read_line(&mut n).expect("Failed to read input.");
    let n: i32 = n.trim().parse().expect("Please enter a number.");

    println!("Enter line:");
    io::stdin().read_line(&mut line).expect("Failed to read input.");
    let line = line.trim();

    let mut m_curr = 1;
    let mut n_curr = 1;

    if m < 1 || n < 1 {
        println!("Error");
    } else {
        for i in line.chars() {
            match i {
                'L' => m_curr -= 1,
                'R' => m_curr += 1,
                'U' => n_curr -= 1,
                'D' => n_curr += 1,
                _ => (),
            }
        }

        if m_curr > m || n_curr > n {
            println!("Error");
        } else if m_curr < 1 || n_curr < 1 {
            if m_curr < 1 {
                m_start = Some(2 + m_curr.abs());
            }
            if n_curr < 1 {
                n_start = Some(2 + n_curr.abs());
            }
            if let (Some(m_start), Some(n_start)) = (m_start, n_start) {
                println!("{} {}", m_start, n_start);
            }
        } else {
            println!("1 1")
        }
    }
}