package Part2;

public interface TowerMediator {
    void broadcast(String msg, Aircraft sender);
    boolean requestRunway(Aircraft a); // true, если разрешен посадка/взлет
}
