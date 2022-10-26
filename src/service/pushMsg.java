package src.service;

import src.dao.topicDAO;
import src.model.Message;
import src.model.Topic;

public class pushMsg {
    public topicDAO daoObject = topicDAO.getInstance();

    public boolean pushMsg(String topicId, Message msg, Thread thread){
        daoObject.addMsgToTopic(topicId,msg);
        new Thread(() -> daoObject.fetchTopic(topicId).publishMsg(msg)).start();
        return true;
    }

}
