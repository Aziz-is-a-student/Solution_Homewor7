package Part2;
import java.util.Random;
import java.util.concurrent.*;
public class AirportSimulation {
    private static final ControlTower tower = new ControlTower();

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable simulationTask = () -> {
            Aircraft aircraft = generateRandomAircraft();
            tower.broadcast(aircraft.id + " запрашивает разрешение на посадку.", aircraft);
            boolean clearedForLanding = tower.requestRunway(aircraft);

            if (clearedForLanding) {
                tower.processLandingQueue();
            } else {
                tower.broadcast(aircraft.id + " добавлен в очередь на посадку.", aircraft);
            }
        };

        executor.scheduleAtFixedRate(simulationTask, 0, 1, TimeUnit.SECONDS);



        Aircraft emergencyAircraft = new EmergencyAircraft("EmergencyPlane");
        tower.broadcast("MAYDAY! " + emergencyAircraft.id, emergencyAircraft);
        tower.emergencyLanding(emergencyAircraft);
    }

    // Генерируем случайные самолеты
    private static Aircraft generateRandomAircraft() {
        Random rand = new Random();
        String id = "Aircraft" + rand.nextInt(100);
        int aircraftType = rand.nextInt(4);

        switch (aircraftType) {
            case 0: return new PassengerPlane(id);
            case 1: return new CargoPlane(id);
            case 2: return new Helicopter(id);
            case 3: return new EmergencyAircraft(id);
            default: return new PassengerPlane(id);
        }
    }


}
