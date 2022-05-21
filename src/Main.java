public class Main {

    private static final int SUPPORT_SPECIALIST = 3;

    public static void main(String[] args) {

        CallCenter callCenter = new CallCenter();
        new Thread(null, callCenter::addCall, "Thread-ATS").start();

        for (int i = 1; i <= SUPPORT_SPECIALIST; i++) {
            new Thread(null, callCenter::acceptCall, "Support Specialist №" + i).start();
        }

    }

}
