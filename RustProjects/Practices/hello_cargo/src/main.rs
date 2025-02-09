struct Game2048 {
    panel: [[i32; 5]; 5],
}

impl Game2048 {
    pub fn to_left(&mut self) {
      let dimension: usize = self.panel.len();
      for i in 0..dimension {
        let mut cnt: i32 = 0;
        self.panel[i][0] = 1;
        for j in 0..dimension {
          // when encouter zero nothing to do 
          if self.panel[i][j] == 0 {
            continue;
          }

          // Otherwise accumulate each one.
          self.panel[i][j] += cnt;
          cnt += self.panel[i][j];
        }
      }
    }
    pub fn to_right(&self) {}
    pub fn to_up(&self) {}
    pub fn to_down(&self) {}

    pub fn show_panel(&self) {
        for i in 0..self.panel.len() {
            for j in 0..self.panel[i].len() {
                print!("{}\t", self.panel[i][j]);
            }
            println!();
        }
    }
}

fn main() {
    let panel: [[i32; 5]; 5] = [[0; 5]; 5];
    let mut player = Game2048 { panel };

    loop {
        println!("Current Panel Status: ");
        player.show_panel();

        // Reading a number from screen that user choosen
        let mut typing_contents = String::new();
        std::io::stdin()
            .read_line(&mut typing_contents)
            .expect("Not Correctly!");
        println!("{}", typing_contents);
        if typing_contents == "quit" || typing_contents == "q" {
            break;
        }

        if typing_contents == "left" {
            player.to_left();
        } else if typing_contents == "right" {
            player.to_right();
        } else if typing_contents == "up" {
            player.to_up();
        } else if typing_contents == "down" {
            player.to_down();
        }
    }
}
