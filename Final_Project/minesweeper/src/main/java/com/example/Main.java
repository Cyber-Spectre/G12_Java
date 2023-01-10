package Final_Project.minesweeper.src.main.java.com.example;

//?https://www.youtube.com/playlist?list=PLGxHvpw-PAk6QvPw0fYe8bks31GRKvymK

public class Main implements Runnable {

  GUI gui = new GUI();

  public static void main(String[] args) {
    new Thread(new Main()).start();
  }

  @Override
  public void run() {
    while(true) {
      gui.repaint();
    }
  }

}