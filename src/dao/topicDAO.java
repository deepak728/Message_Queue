package src.dao;

import src.model.Message;
import src.model.Subscriber;
import src.model.Topic;

import java.util.HashMap;

public class topicDAO {
    HashMap<String, Topic> topicMap;
    public static topicDAO instance= null;

    private topicDAO(){
        topicMap = new HashMap<>();
    }

    public static topicDAO getInstance(){
        if(instance==null)
            instance = new topicDAO();
        return instance;
    }

    public boolean addTopic(Topic topic){
        if(!topicMap.containsKey(topic.getTopicId())){
            topicMap.put(topic.getTopicId(), topic);

        }else{
            System.out.println("topic already exist");
            return false;
        }
        //System.out.println(topicMap.get(topic.getTopicId()).getTopicId());
        return true;
    }

    public boolean isTopicPresent(String topicId){
        return topicMap.containsKey(topicId);
    }

    public Topic fetchTopic(String topicId){
        return topicMap.get(topicId);
    }

    public boolean subscribeTopic(Subscriber sbs, String topicId){
        Topic currTopic = topicMap.get(topicId);
        currTopic.addSubscriber(sbs);
        //System.out.println(topicMap.get(topicId).getSubsList());
        return true;
    }

    public boolean addMsgToTopic(String topicId, Message msg){
        topicMap.get(topicId).addMsgToTopic(msg);
        //System.out.println(topicMap.get(topicId).getMsgList());
        return true;
    }
}
