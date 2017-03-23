package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andreyzaytsev on 22.03.17.
 */
public class MemoryTable {

    private MemoryList[] memoryLists;

    private List<MemoryTableUnit> memoryTableUnits;

    private MemoryList[] swapLists;

    private Process process;

    private MemoryList[] virtualMemory;

    private static String exceptionMessage = "Out of memory";

    public MemoryTable(MemoryList[] physicalMemory, MemoryList[] swapMemory, Process process){
        this.memoryLists = physicalMemory;
        this.swapLists = swapMemory;
        this.memoryTableUnits = new ArrayList<>();
        this.process = process;
        this.virtualMemory = process.getVirtualMemory();
    }


    public void tryAllocate() throws Exception {
        for(int i = 0; i < virtualMemory.length; i++){
            if(allocateMemory(virtualMemory[i], memoryLists)){
                continue;
            }
            if(allocateMemory(virtualMemory[i], swapLists)){
                continue;
            }
            throw new Exception(exceptionMessage);
        }
        return;
    }

    public MemoryList tryAllocateSingleList() throws Exception {
        MemoryList freeMemory;
        if((freeMemory = allocateMemory(memoryLists)) != null){
            return freeMemory;
        }
        if((freeMemory = allocateMemory(swapLists)) != null){
            return freeMemory;
        }
        throw new Exception(exceptionMessage);
    }

    private boolean allocateMemory(MemoryList virtualMemory, MemoryList[] memory){
        for (int i = 0; i < memory.length; i++){
            if(!memory[i].isFull()){
                memoryTableUnits.add(new MemoryTableUnit(virtualMemory, memory[i]));
                memory[i].setFull(true);
                return true;
            }
        }
        return false;
    }

    private MemoryList allocateMemory(MemoryList[] memory){
        for(int i = 0; i < memory.length; i++){
            if(!memory[i].isFull()){
                return memory[i];
            }
        }
        return null;
    }
}
