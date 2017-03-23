package Controller;

import Model.MemoryList;
import Model.MemoryTable;
import Model.Process;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by andreyzaytsev on 13.03.17.
 */
public class MemoryManager {

    private MemoryList[] memory;

    private MemoryList[] swap;

    private List<Process> processes = Collections.emptyList();

    private List<MemoryTable> tables = Collections.emptyList();

    public MemoryManager(MemoryList[] memorySize, MemoryList[] swapSize, List<Process> processes) throws Exception {
        this.memory = memorySize;
        this.swap = swapSize;
        this.processes = processes;
        this.tables = initTables();
        initialAllocation();
    }

    private List<MemoryTable> initTables(){
        List<MemoryTable> tables = new ArrayList<>();
        for(int i = 0; i < processes.size(); i++){
            tables.add(new MemoryTable(memory, swap, processes.get(i)));
        }
        return tables;
    }

    private void initialAllocation() throws Exception {
        for(MemoryTable table : tables){
            table.tryAllocate();
        }
    }

    public void handlePageError(){

    }

    public void tryRefer(){

    }



}
