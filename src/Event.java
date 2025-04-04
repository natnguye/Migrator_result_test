public class Event
{
  private String name;
  private String description;

  public Event(String name, String description)
  {
    this.name = name;
    this.description = description;
  }

  public void start()
  {
    System.out.println("Event \"" + name + "\" :");
    System.out.println(description);
  }

  public int act(String input)
  {
    if(input.startsWith("ATTACK "))
    {
      System.out.println("You fight your way through the enemy.");
    }
    else if(input.startsWith("TALK "))
    {
      System.out.println("You try a diplomatic approach to the situation and try to talk your way out of this.");
    }
    else if(input.startsWith("FLEE "))
    {
      System.out.println("You try to sneak your way out without being noticed.");
    }
    else if(input.isEmpty())
    {
      System.out.println("You do nothing, waiting for a reaction.");
    }
    else
    {
      System.out.println("I did not understand \""+input+"\". Type something else or simply press enter.");
      return 0;
    }

    return 1;
  }
}
