package Model;

/**
 * Created by andreyzaytsev on 13.03.17.
 */
public class MemoryList {

    private boolean isFull  = false;

    public void setFull(boolean status){
        isFull = status;
    }

    public boolean isFull(){
        return isFull;
    }

}
