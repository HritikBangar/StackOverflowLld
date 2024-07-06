import java.util.*;

public class TopicSubscriptionService {
    private Map<User, List<String>> subscribedTopic = new HashMap<>();

    public void addSubscription(User user, String topic) {
        subscribedTopic.computeIfAbsent(user, k -> new ArrayList<>()).add(topic);
    }

    public void addSubscriptions(User user, List<String> topics) {
        for(String topic: topics) {
            addSubscription(user, topic);
        }
    }

    public void removeSubscriptions(User user, List<String> topics) {
        List<String> subscribedTopics = getSubscriptions(user);
        for(String topic: topics) {
            subscribedTopics.remove(topic);
        }
    }

    public List<String> getSubscriptions(User user) {
        return subscribedTopic.getOrDefault(user, new ArrayList<>());
    }
}
