package src.activity;

import src.model.Message;
import src.model.Subscriber;
import src.model.Topic;
import src.service.createTopic;
import src.service.pushMsg;
import src.service.resetOffset;
import src.service.subsTopic;

import java.util.HashMap;

public class Activity {
    public createTopic topicCreator = new createTopic();
    public HashMap<String , Thread> threadMap  = new HashMap<>();
    public pushMsg pushMsg = new pushMsg();
    public subsTopic topicSubscriber = new subsTopic();
    public resetOffset resetOffset = new resetOffset();

    public boolean addNewTopic(String topicId){
        Topic currTopic= new Topic(topicId);
        threadMap.put(topicId, new Thread("topic1_thread"));
        return topicCreator.createNewTopic(currTopic);
    }

    public boolean subscribeTopic(String topicId, Subscriber subs){
        return topicSubscriber.subscribeTopic(subs, topicId);

    }

    public boolean pushMsg(String topicId, String msg){
        Message message = new Message(msg);
        pushMsg.pushMsg(topicId,message, threadMap.get(topicId));
        return true;
    }

    public boolean resetOffset(String topicId, Subscriber subs){
        return true;
    }
}
