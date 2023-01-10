package Final_Project.minesweeper.src.main.java.com.example;

import javax.swing.*;
import java.util.*;
import java.awt.*;

public class GUI extends JFrame {

  int spacing = 5;
  
  public GUI() {
    this.setTitle("Minesweeper");
    this.setSize(1286, 829);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.setResizable(false);

    Board board = new Board();
    this.setContentPane(board);
  }

  public class Board extends JPanel {
    public void paintComponent(Graphics g) {
      g.setColor(Color.DARK_GRAY);
      g.fillRect(0, 0, 1280, 800);
      g.setColor(Color.GRAY);
      for (int x = 0; x < 16; x++) {
        for (int y = 0; y < 9; y++) {
          g.fillRect(spacing + x * 80, spacing + y * 80 + 80, 80 - 2 * spacing, 80 - 2 * spacing);
        }
      }
    }
  }

}
