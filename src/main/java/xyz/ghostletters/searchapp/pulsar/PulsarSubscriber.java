package xyz.ghostletters.searchapp.pulsar;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.MessageListener;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;

public class PulsarSubscriber {

    public static Consumer initConsumerWithListener(String topicName, MessageListener messageListener) throws PulsarClientException {
        return initClient().newConsumer()
                .topic(topicName)
                .subscriptionName("my-subscription")
                .messageListener(messageListener)
                .subscribe();
    }

    private static PulsarClient initClient() throws PulsarClientException {
        return PulsarClient.builder()
                .serviceUrl("pulsar://localhost:6650")
                .build();
    }
}
