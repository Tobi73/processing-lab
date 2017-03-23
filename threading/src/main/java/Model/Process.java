package Model;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by andreyzaytsev on 26.02.17.
 */
public class Process {

    private int id;

    private MemoryList[] virtualMemory;

    private LinkedBlockingQueue<Thread> threads;

    public Process(int id, LinkedBlockingQueue<Thread> threads, MemoryList[] virtualMemory){
        this.id = id;
        this.threads = threads;
        this.virtualMemory = virtualMemory;
    }

    public int getId(){
        return this.id;
    }

    public LinkedBlockingQueue<Thread> getThreads(){
        return threads;
    }

    public MemoryList[] getVirtualMemory(){
        return virtualMemory;
    }

    
}
