class ChatUser extends Thread {
    private volatile boolean running = true;
    private boolean paused = false;
    private final Object lock = new Object();

    // Constructor
    ChatUser(String name, int priority) {
        super(name);
        setPriority(priority);
    }

    // Pause the thread
    void pauseThread() {
        synchronized (lock) {
            paused = true;
        }
    }

    // Resume the thread
    void resumeThread() {
        synchronized (lock) {
            paused = false;
            lock.notifyAll();
        }
    }

    // Terminate the thread
    void terminateThread() {
        running = false;
        resumeThread();
    }

    // Check whether the thread is paused
    void checkPause() {
        synchronized (lock) {
            while (paused && running) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    running = false;
                }
            }
        }
    }

    // Thread execution
    public void run() {
        for (int i = 1; i <= 5 && running; i++) {
            checkPause();

            if (!running)
                break;

            System.out.println(getName() + " is sending message " + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                running = false;
            }
        }

        System.out.println(getName() + " has left the chat.");
    }
}

public class Exp8_Multithreading {
    public static void main(String[] args) {

        ChatUser user1 = new ChatUser("User 1", Thread.MAX_PRIORITY);
        ChatUser user2 = new ChatUser("User 2", Thread.NORM_PRIORITY);
        ChatUser user3 = new ChatUser("User 3", Thread.MIN_PRIORITY);

        // Start threads
        user1.start();
        user2.start();
        user3.start();

        try {
            Thread.sleep(1000);

            // Pause and resume User 2
            user2.pauseThread();
            System.out.println("User 2 paused.");

            Thread.sleep(1000);

            user2.resumeThread();
            System.out.println("User 2 resumed.");

            // Terminate User 3
            user3.terminateThread();
            System.out.println("User 3 terminated.");

            // Check thread status
            System.out.println("User 1 alive: " + user1.isAlive());
            System.out.println("User 2 alive: " + user2.isAlive());
            System.out.println("User 3 alive: " + user3.isAlive());

            // Wait for all threads to finish
            user1.join();
            user2.join();
            user3.join();

        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Chat session ended.");
    }
}