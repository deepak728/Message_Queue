package src.model;

import java.util.concurrent.TimeUnit;

public class Subscriber {
    private String subsId;

    public void consumeMsg(Message msg){
        System.out.println(subsId + " consumed " + msg.getMsg());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Subscriber(String id){
        subsId= id;
    }
    public String getSubsId() {
        return subsId;
    }

    public void setSubsId(String subsId) {
        this.subsId = subsId;
    }
}
