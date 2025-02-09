
use std::io;
use rand::Rng;
use std::cmp::Ordering;
/**
 * This is a guess game!
 * Conguration!
 */
fn main() {
    let secret_number = rand::thread_rng().gen_range(0..=100);
    println!("Cheating {}", secret_number);

    loop {
        println!("Input your guess: ");
        let mut guess= String::new();
        io::stdin().read_line(&mut guess)
            .expect("Failed catch it.");

        let guess: u32 = match guess.trim().parse() {
            Ok(num) => num,
            Err(_) => continue,
        };

        println!("Your guess {guess}");
        match guess.cmp(&secret_number) {
            Ordering::Less => println!("Too small!"),
            Ordering::Greater => println!("Too big!"),
            Ordering::Equal => {
                println!("Your win!");
                break;
            }
        }
    }
}
