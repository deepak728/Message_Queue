package src.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;


public class Topic {
    private String topicId;
    private List<Message> msgList;
    private List<topicSubscriber> subsList;
    private Map<String, Worker> workerMap;

    public List<Message> getMsgList() {
        return msgList;
    }

    public void setMsgList(List<Message> msgList) {
        this.msgList = msgList;
    }

    public List<topicSubscriber> getSubsList() {
        return subsList;
    }

    public void setSubsList(List<topicSubscriber> subsList) {
        this.subsList = subsList;
    }

    public Map<String, Worker> getWorkerMap() {
        return workerMap;
    }

    public void setWorkerMap(HashMap<String, Worker> workerMap) {
        this.workerMap = workerMap;
    }
    public Topic(String topicIden) {
        topicId = topicIden;
        msgList = new ArrayList<>();
        subsList = new ArrayList<>();
        workerMap = new HashMap<>();

    }
    public String getTopicId(){
        return topicId;
    }

    public boolean addMsgToTopic(Message msg){
        msgList.add(msg);
        return true;
    }

    public  boolean addSubscriber(Subscriber sbs){
        subsList.add(new topicSubscriber(msgList.size(),sbs));
        if(!createWorker(sbs.getSubsId())) return false;
        return true;
    }

    public topicSubscriber find_subscriber(String subsid){
        for(int i=0;i<subsList.size();i++){
            if (subsList.get(i).getSubscriber().getSubsId().equals(subsid)){
                return subsList.get(i);
            }
        }
        return null;
    }
    public boolean createWorker(String subsId){
        if(workerMap.containsKey(subsId)) return false;

        topicSubscriber subs = find_subscriber(subsId);
        workerMap.put(subsId, new Worker(subsId.toString()+"_worker",this ,subs));
        new Thread(workerMap.get(subsId)).start();
        return true;
    }


    public synchronized void publishMsg(Message msg){

        for(Map.Entry<String, Worker> set: workerMap.entrySet()){
            synchronized (set.getValue()){
                set.getValue().notifyAll();
            }
        }
    }
}
