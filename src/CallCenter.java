import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;

public class CallCenter {

    private final int NUMBER_OF_CALLS = 60; // number of calls
    private final int TIME_GENERATION = 1000; //the time to generate a call
    private final int TIME_SPEND = 4000; //the time spent by a technical support specialist
                                         // to solve a client issue
    private LinkedBlockingQueue<Call> listCall = new LinkedBlockingQueue<>();

    public void addCall() {

        for (int i = 1; i <= NUMBER_OF_CALLS; i++) {
            try {
                listCall.add(new Call(i, "Client"));
                Date data = new Date();
                SimpleDateFormat formatForDate = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
                System.out.println("[" + formatForDate.format(data) + "]" + " Received " + i +
                        " calls from different clients / Total calls not processed = " + listCall.size() +
                        " / " + Thread.currentThread().getName());
                Thread.sleep(TIME_GENERATION);
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }

    }


    public void acceptCall() {

        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(TIME_SPEND);
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
            if (listCall.poll() != null) {
                System.out.println(Thread.currentThread().getName()
                        + " accepted the call / Total calls not processed = " + listCall.size());
            }
        }

    }

}
