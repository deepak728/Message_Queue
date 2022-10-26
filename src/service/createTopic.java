package src.service;

import src.dao.topicDAO;
import src.model.Topic;

public class createTopic {

    public topicDAO daoObject= topicDAO.getInstance();

    public boolean createNewTopic(Topic topic){
        return daoObject.addTopic(topic);
    }
}
