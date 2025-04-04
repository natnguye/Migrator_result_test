import java.util.ArrayList;

public class Level {
  private String name;
  private ArrayList<Event> events;

  public Level(String name)
  {
    this.name = name;
    events = new ArrayList<Event>();
  }

  public void addEvent(Event event)
  {
    events.add(event);
  }

  public Event nextEvent() {
    Event event = null;
    if(!events.isEmpty())
    {
      event = events.get(0);
      events.remove(0);
    }

    return event;
  }

  public void generateEvents()
  {
    addEvent(new Event("Entering the dungeon",
          "In the hot desert under a scorching sun, along a rocky cliff, you see the entrance to the dungeon of Shandogar. You welcome the soothing freshness of the dark cave but soon sense the uneasing feeling of this dangerous place : Many have tried to obtain the legendary Hand of Shandogar, but only few have returned to tell their failure. As you go deeper into the cold corridors of the underground dungeon, you only realize the gravity of the situation"));
    
    addEvent(new Event("The kobolds around a firecamp",
          "As you walk along the corridors, you see a dim light around the corner. You hear some creatures yapping and realize it's a group of kobold, gathered around a firecamp. They have not yet spotted your presence, what do you do?"));

  }
}
