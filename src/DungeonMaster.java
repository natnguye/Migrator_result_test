public class DungeonMaster {
    private String name;

    public DungeonMaster(String name) {
        this.name = name;
    }

    public void introduce() {
        System.out.println("Hello, I am " + name + ", your Dungeon Master!");
    }
}
