import java.util.ArrayList;
import java.util.List;

public class Room101 implements IRoom {

    private IRoom east;
    private IRoom west;
    private IRoom north;
    private IRoom south;

    private String name;
    private String description;

    List<IPerson> people = new ArrayList<IPerson>();

    Room101(String newName, String newDescription) {
        name = newName;
        description = newDescription;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean canGoEast() {
        return east != null;
    }

    @Override
    public boolean canGoWest() {
        return west != null;
    }

    @Override
    public boolean canGoNorth() {
        return north != null;
    }

    @Override
    public boolean canGoSouth() {
        return south != null;
    }

    @Override
    public IRoom getEast() {
        return east;
    }

    @Override
    public IRoom getWest() {
        return west;
    }

    @Override
    public IRoom getNorth() {
        return north;
    }

    @Override
    public IRoom getSouth() {
        return south;
    }

    @Override
    public List<IPerson> getPeople() {
        return people;
    }

    @Override
    public void setEast(IRoom newEast) {
        east = newEast;

    }

    @Override
    public void setWest(IRoom newWest) {
        west = newWest;

    }

    @Override
    public void setNorth(IRoom newNorth) {
        north = newNorth;

    }

    @Override
    public void setSouth(IRoom newSouth) {
        south = newSouth;

    }

}
