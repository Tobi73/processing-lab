package Model;

/**
 * Created by andreyzaytsev on 22.03.17.
 */
public class MemoryTableUnit {

    private MemoryList virtualListLink;

    private MemoryList memoryListLink;

    private boolean presenceFlag;

    private int workTime;

    public MemoryTableUnit(MemoryList virtualLink, MemoryList physicalLink){
        this.virtualListLink = virtualLink;
        this.memoryListLink = physicalLink;
        this.presenceFlag = true;
        this.workTime = 0;
    }

    public MemoryList getVirtualListLink(){
        return virtualListLink;
    }

    public void setVirtualListLink(MemoryList list){
        this.virtualListLink = list;
    }

    public MemoryList getMemoryListLink(){
        return memoryListLink;
    }

    public void setMemoryListLink(MemoryList list){
        this.memoryListLink = list;
    }

    public boolean isPresent(){
        return presenceFlag;
    }

    public void setPresenceFlag(boolean presence){
        presenceFlag = presence;
    }

    public void incWorkTime(){
        workTime++;
    }

    public void resetWorkTime(){
        workTime = 0;
    }

    public int getWorkTime(){
        return workTime;
    }


}
