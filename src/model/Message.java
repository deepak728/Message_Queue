package src.model;

import jdk.jfr.consumer.MetadataEvent;

public class Message {
    private String msg;

    public Message(String msf){
        msg= msf;
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
