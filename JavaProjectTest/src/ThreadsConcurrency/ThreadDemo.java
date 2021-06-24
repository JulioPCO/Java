package ThreadsConcurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


import ThreadsConcurrency.Status.DownloadAdderStatus;
import ThreadsConcurrency.Status.DownloadAtomicStatus;
import ThreadsConcurrency.Status.DownloadStatus;
import ThreadsConcurrency.Status.DownloadStatusLock;
import ThreadsConcurrency.Status.DownloadStatusVolatile;
import ThreadsConcurrency.Tasks.DownloadAdder;
import ThreadsConcurrency.Tasks.DownloadAtomic;
import ThreadsConcurrency.Tasks.DownloadConfinement;
import ThreadsConcurrency.Tasks.DownloadFileTask;
import ThreadsConcurrency.Tasks.DownloadInterrupt;
import ThreadsConcurrency.Tasks.DownloadLock;
import ThreadsConcurrency.Tasks.DownloadRaceCondition;
import ThreadsConcurrency.Tasks.DownloadVolatile;



public class ThreadDemo {
    public static void show(){
        int num = 9; // just for organization without thinking a lot...

        System.out.println(Thread.currentThread().getName());

        if (num == 1){
            //Starting a thread
            for (int i=1; i<10; i++){
                Thread thread = new Thread(new DownloadFileTask());
                thread.start();
            }

            //Joining Thread
            Thread thread = new Thread(new DownloadFileTask());
            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            System.out.println("File is ready to be scanned.");

            //Interrupting thread
            Thread thread2 = new Thread(new DownloadInterrupt());
            thread2.start();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            thread2.interrupt();
        }

        //Concurrency --> Race condition --> The threads competes with each other so the total number of operations is less than the expected
        // Race condition in this case occurs with the non atomic operation of getting the data from memory, incrementing in cpu and returning to memory
        // this cause two or more threads to get the same data from the memory and perform the operation on the same parameter.
        // So 10.000 operations are made but only a few of them really increments the status variable. 
        
        if (num ==2){
                var status  = new DownloadStatus();

                List<Thread> threads = new ArrayList<Thread>();

                for (int i=1; i<=10; i++){
                    Thread thread3 = new Thread(new DownloadRaceCondition(status));
                    thread3.start();
                    threads.add(thread3);
                }

                for (Thread threadvar:threads)
                    try {
                        threadvar.join();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                
                System.out.println(status.getTotalbytes());
            }

            //Confinement -> let each thread work with its own download object.
        if (num ==3){
            List<Thread> threads2 = new ArrayList<Thread>();
            List<DownloadConfinement> downloads = new ArrayList<>();

            for (int i=1; i<=10; i++){
                var task = new DownloadConfinement();
                downloads.add(task);
                Thread thread3 = new Thread(task);
                thread3.start();
                threads2.add(thread3);
            }

            for (Thread threadvar:threads2)
                try {
                    threadvar.join();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            
            var totalbytes = downloads.stream()
                    .map(t -> t.getStatus().getTotalbytes())
                    .reduce(0, (a,b) -> a + b);

            System.out.println(totalbytes);    
        }

        //Syncronization (Some say it is not a good practice to solve race condition for multi-threading )
        if (num == 4){
            var status2  = new DownloadStatusLock();

            List<Thread> threads3 = new ArrayList<Thread>();

            for (int i=1; i<=10; i++){
                Thread thread3 = new Thread(new DownloadLock(status2));
                thread3.start();
                threads3.add(thread3);
            }

            for (Thread threadvar:threads3)
                try {
                    threadvar.join();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            System.out.println(status2.getTotalbytes());
        }

        // Volatile Key -> Syncronization but allows other threads to see the data
        if (num == 5){
            var status3 = new DownloadStatusVolatile();
            var thread1 = new Thread(new DownloadVolatile(status3));
            var thread2 = new Thread(() -> {
                while(!status3.isDone()) {
                    synchronized(status3){ //to use wait java virtual machine expects synchronized block
                        try {
                            status3.wait(); //Avoid the while loop to run a million times, and notify the loop when the status3 changes
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } 
                    }
                }
                System.out.println(status3.getTotalbytes());
            });

            thread1.start();
            thread2.start();
        }

        //Atomic Objects
        if (num == 6){
            var status  = new DownloadAtomicStatus();

            List<Thread> threads = new ArrayList<Thread>();

            for (int i=1; i<=10; i++){
                Thread thread3 = new Thread(new DownloadAtomic(status));
                thread3.start();
                threads.add(thread3);
            }

            for (Thread threadvar:threads)
                try {
                    threadvar.join();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                
            System.out.println(status.getTotalbytes());            
        }

        //Adder
        if (num == 7){
            var status  = new DownloadAdderStatus();

            List<Thread> threads = new ArrayList<Thread>();

            for (int i=1; i<=10; i++){
                Thread thread3 = new Thread(new DownloadAdder(status));
                thread3.start();
                threads.add(thread3);
            }

            for (Thread threadvar:threads)
                try {
                    threadvar.join();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                
            System.out.println(status.getTotalbytes());     
        }

        // Synchronized Collection
        if (num ==8){
            Collection<Integer> collection = 
                     Collections.synchronizedCollection(new ArrayList<Integer>());

            var thread1 = new Thread(() ->{
                collection.addAll(Arrays.asList(1,2,3));
            });

            var thread2 = new Thread(() ->{
                collection.addAll(Arrays.asList(4,5,6));
            });

            thread1.start();
            thread2.start();

            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            System.out.println(collection);
        }

        // Concurred Collections or Partitioning
        if (num == 9){
            Map<Integer,String> map = new ConcurrentHashMap<>();
            map.put(1,"a");
            map.get(1);
            map.remove(1);

        }
    }

}
