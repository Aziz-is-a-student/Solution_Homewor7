package Part2;
import java.util.LinkedList;
import java.util.Queue;
public class ControlTower implements TowerMediator{
    private Queue<Aircraft> landingQueue = new LinkedList<>();
    private Queue<Aircraft> takeOffQueue = new LinkedList<>();

    @Override
    public void broadcast(String msg, Aircraft sender) {
        // Когда одно воздушное судно отправляет сообщение, все остальные получают его
        System.out.println(sender.id + ": " + msg);
    }

    @Override
    public boolean requestRunway(Aircraft a) {
        if (a instanceof EmergencyAircraft) {
            // Экстренная посадка всегда получает приоритет
            System.out.println(a.id + " получает приоритет для посадки!");
            return true;
        }

        // Если очередь для посадки пустая, добавляем в очередь
        if (landingQueue.isEmpty()) {
            landingQueue.add(a);
            return true;
        }

        // В противном случае — отказываем
        return false;
    }

    // Метод для экстренных ситуаций
    public void emergencyLanding(Aircraft a) {
        System.out.println(a.id + " делает экстренную посадку!");
        landingQueue.clear(); // Все самолеты в очереди должны подождать
    }

    public void processLandingQueue() {
        if (!landingQueue.isEmpty()) {
            Aircraft a = landingQueue.poll();
            System.out.println(a.id + " садится на полосу.");
        }
    }

    public void processTakeOffQueue() {
        if (!takeOffQueue.isEmpty()) {
            Aircraft a = takeOffQueue.poll();
            System.out.println(a.id + " взлетает с полосы.");
        }
    }
}
