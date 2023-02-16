package itstep.task_4.thread_task;

public class Player extends Thread{
    private final int MAX_STEP_COUNT=10;
    private static final int[] counter={0};
    private static final String[] state={""};
    private String name;

    public Player(String name) {
        this.name=name;
        state[0]=name;
    }

    @Override
    public void run(){
            while (counter[0] < MAX_STEP_COUNT) {
                synchronized (counter) {
                    if(!state[0].equals(name)){
                    counter[0]++;
                    System.out.println(name +" "+counter[0]);
                    state[0]=name;}
            }
            }
        }
}
