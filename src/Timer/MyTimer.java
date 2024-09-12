package Timer;

public class MyTimer implements Runnable {
    private double timePassed;
    private boolean running;
    private Thread thread;
    private final Runnable lambda;
    private final int pause;

    public MyTimer() {
        this(10,null);
    }

    public MyTimer(Runnable lambda) {
        this(10, lambda);
    }
    public MyTimer(int pause, Runnable lambda) {
        this.timePassed = 0.0;
        this.running = false;
        this.lambda = lambda;
        this.pause = pause;
    }

    @Override
    public void run() {
        while (running) {
            try {
                thread.sleep(pause);
                timePassed += (double) pause/1000;
                if (lambda != null) {
                    lambda.run();
                }

            } catch (InterruptedException e) { //catches not all exeptions
                Thread.currentThread().interrupt();
            }catch (Exception e) {
                e.printStackTrace();
                running = false;
            }
        }
    }

    public void pause(){running = false;}
    public void setTime(double i){timePassed = i;}

    public void Continue(){
        running = true;
    }

    public void start() {
        if (thread == null) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }

    }

    public void stop() {
        running = false;
        if (thread != null) {
            thread.interrupt();
        }
        timePassed = 0.0;
    }

    public double time() {
        return timePassed;
    }
}