package src.model;

public class topicSubscriber {
    private Subscriber subscriber;
    private int idx;

    topicSubscriber(int index, Subscriber sbs){
        subscriber =sbs;
        idx= index;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }
}
