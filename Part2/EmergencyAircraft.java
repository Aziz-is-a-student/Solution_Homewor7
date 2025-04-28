package Part2;
class EmergencyAircraft extends Aircraft {
    public EmergencyAircraft(String id) {
        super(id);
    }

    @Override
    public void receive(String msg) {
        System.out.println(id + " получает сообщение: " + msg);
    }
}