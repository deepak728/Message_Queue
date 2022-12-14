# Message_Queue

Machine code for Message_Queue like kafka.

## Problem Statement
We have to design a message queue supporting publisher-subscriber model. It should support following operations:

* It should support multiple topics where messages can be published. <br/>
* Publisher should be able to publish a message to a particular topic. <br/>
* Subscribers should be able to subscribe to a topic. <br/>
* Whenever a message is published to a topic, all the subscribers, who are subscribed to that topic, should receive the message. <br/> <br/>
* Subscribers should be able to run in parallel. <br/>
