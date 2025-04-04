import java.util.Scanner;


public class DungeonMaster {
  private String name;
  private Scanner scanner;

  public DungeonMaster(String name) {
    this.name = name;
    this.scanner = new Scanner(System.in);
  }

  public void introduce() {
    System.out.println("Hello, I am " + name + ", your Dungeon Master!");
  
    start();
  }
  public void start() 
  {
    Level firstFloor = new Level("First Floor");
    firstFloor.generateEvents();

    Event currentEvent = firstFloor.nextEvent();

    while(currentEvent != null)
    {
      currentEvent.start();
      while(currentEvent.act(askPlayer()) == 0){}
      currentEvent = firstFloor.nextEvent();
    }      
  }

  public String askPlayer()
  {
    return scanner.nextLine();
  }
}
