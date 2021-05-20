package xyz.ghostletters.searchapp.pulsar;

import io.quarkus.runtime.StartupEvent;
import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.MessageListener;
import org.apache.pulsar.client.api.PulsarClientException;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class BookListener {

    private static final String topicName = "persistent://public/default/foobar.public.book";


    MessageListener messageListener = (consumer, msg) -> {
        try {
            // Do something with the message
            System.out.println("Message received: " + new String(msg.getData()));

            // Acknowledge the message so that it can be deleted by the message broker
            consumer.acknowledge(msg);
        } catch (Exception e) {
            // Message failed to process, redeliver later
            consumer.negativeAcknowledge(msg);
        }
    };

    public void onStart(@Observes StartupEvent event) throws PulsarClientException {
        PulsarSubscriber.initConsumerWithListener(topicName, messageListener);
    }
}
