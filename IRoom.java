import java.util.List;

public interface IRoom {
    String getName();

    String getDescription();

    boolean canGoEast();

    boolean canGoWest();

    boolean canGoNorth();

    boolean canGoSouth();

    IRoom getEast();

    IRoom getWest();

    IRoom getNorth();

    IRoom getSouth();

    void setEast(IRoom newEast);

    void setWest(IRoom newWest);

    void setNorth(IRoom newNorth);

    void setSouth(IRoom newSouth);

    List<IPerson> getPeople();

}
