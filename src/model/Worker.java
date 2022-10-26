package src.model;

import java.util.List;

public class Worker implements Runnable {
    private String workerId;
    public Topic topic;
    public topicSubscriber thisTopicSubs;
    public Worker(String id,Topic currTopic, topicSubscriber ts){
        workerId = id;
        topic = currTopic;
        thisTopicSubs = ts;
    }
    @Override
    public void run() {
        System.out.println(workerId + "running");
        while(true) {
            synchronized (this) {
                try {
                    List<Message> msg = topic.getMsgList();
                    if(thisTopicSubs.getIdx()>=msg.size())
                        this.wait();
                    if(thisTopicSubs.getIdx()>=msg.size())
                        continue;

                    thisTopicSubs.getSubscriber().consumeMsg(msg.get(thisTopicSubs.getIdx()));
                    thisTopicSubs.setIdx(thisTopicSubs.getIdx()+1);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

}
