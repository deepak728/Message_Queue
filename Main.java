import src.activity.Activity;
import src.model.Subscriber;

public class Main {

    public static void main(String[] args){
        Activity activity = new Activity();

        activity.addNewTopic("topic1");
        activity.addNewTopic("topic2");
        activity.addNewTopic("topic3");
        activity.addNewTopic("topic4");

        Subscriber sbs1 = new Subscriber("sbs1");
        Subscriber sbs2 = new Subscriber("sbs2");
        Subscriber sbs3 = new Subscriber("sbs3");
        Subscriber sbs4 = new Subscriber("sbs4");
        Subscriber sbs5 = new Subscriber("sbs5");


        activity.subscribeTopic("topic1",sbs1);
        activity.subscribeTopic("topic1",sbs2);
        activity.subscribeTopic("topic2",sbs3);
        activity.subscribeTopic("topic2",sbs4);
        activity.subscribeTopic("topic3",sbs5);
        activity.subscribeTopic("topic4",sbs5);

        activity.pushMsg("topic1", "msg1a");
        activity.pushMsg("topic1","msg1b");
        activity.pushMsg("topic1", "msg1c");
        activity.pushMsg("topic1","msg1d");
        activity.pushMsg("topic1", "msg1e");
        activity.pushMsg("topic1","msg1f");
        activity.pushMsg("topic1", "msg1g");
        activity.pushMsg("topic1","msg1h");
        activity.pushMsg("topic1", "msg1i");
        activity.pushMsg("topic1","msg1j");
        activity.pushMsg("topic1", "msg1k");
        activity.pushMsg("topic1","msg1l");
        activity.pushMsg("topic1", "msg1m");
        activity.pushMsg("topic1","msg1n");
        activity.pushMsg("topic1", "msg1o");
        activity.pushMsg("topic1","msg1p");
        activity.pushMsg("topic1", "msg1q");
        activity.pushMsg("topic1","msg1r");
        activity.pushMsg("topic1", "msg1s");
        activity.pushMsg("topic1","msg1t");




        activity.pushMsg("topic2", "msg21");
        activity.pushMsg("topic2","msg22");

        activity.pushMsg("topic3", "msg31");
        activity.pushMsg("topic3","msg32");

        activity.pushMsg("topic4", "msg41");
        activity.pushMsg("topic4","msg42");
    }
}
