package View;


import Controller.MemoryManager;
import Controller.ProcessPlanner;
import Controller.ThreadPlanner;
import Model.MemoryList;
import Model.Thread;
import Model.Process;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by andreyzaytsev on 26.02.17.
 */
public class Monitor {

    /*
    public static void main(String[] args) {
        LinkedBlockingQueue<Process> processes = new LinkedBlockingQueue<>();
        LinkedBlockingQueue<Thread> allThreads = new LinkedBlockingQueue<>();
        int timeQuantum = 15;
        Random rand = new Random();
        for(int i = 0; i < 3; i++){
            LinkedBlockingQueue<Thread> threads = new LinkedBlockingQueue<>();
            for(int j = 0; j < rand.nextInt(5) + 1; j++){
                threads.add(new Thread(rand.nextInt(5) + 15, j));
            }
            allThreads.addAll(threads);
            processes.add(new Process(i, threads));
        }
        ThreadPlanner planner = new ThreadPlanner(timeQuantum);
        for(Process process : processes){
            planner.setThreadsToPlan(process.getThreads());
            while (!planner.isEmpty()){
                try {
                    System.out.print("Process " + process.getId() + " is working");
                    planner.makeWork();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Process " + process.getId() + " has ended");
        }

    }
    */

    public static void main(String[] args){
        List<Process> processes = new ArrayList<>();
        List<Thread> allThreads = new ArrayList<>();
        int timeQuantum = 15;
        Random rand = new Random();
        for(int i = 0; i < 3; i++){
            LinkedBlockingQueue<Thread> threads = new LinkedBlockingQueue<>();
            for(int j = 0; j < rand.nextInt(5) + 1; j++){
                threads.add(new Thread(rand.nextInt(5) + 15, j));
            }
            allThreads.addAll(threads);
            MemoryList[] virtualMemory = new MemoryList[rand.nextInt(15)];
            for(int j = 0; j < virtualMemory.length; j++){
                virtualMemory[j] = new MemoryList();
            }
            processes.add(new Process(i, threads, virtualMemory));
        }
        MemoryList[] physicalMemory = new MemoryList[10];
        for(int i = 0; i < physicalMemory.length; i++){
            physicalMemory[i] = new MemoryList();
        }
        MemoryList[] swap = new MemoryList[20];
        for(int i = 0; i < swap.length; i++){
            swap[i] = new MemoryList();
        }
        try {
            MemoryManager manager = new MemoryManager(physicalMemory, swap, processes);
            System.out.println("Done 1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }


}
