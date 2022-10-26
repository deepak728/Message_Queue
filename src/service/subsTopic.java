package src.service;

import src.dao.topicDAO;
import src.model.Subscriber;

public class subsTopic {
    public topicDAO daoObject = topicDAO.getInstance();

    public boolean subscribeTopic(Subscriber sbs, String topicId){
        if(!daoObject.isTopicPresent(topicId)) return false;
        return daoObject.subscribeTopic( sbs, topicId);
    }
}
