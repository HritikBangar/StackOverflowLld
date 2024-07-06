import java.util.*;

public class Question {
    private User user;
    private List<String> topics;
    private String statement;
    private long timestamp;
    private int upvotes;
    private int downvotes;

    public Question(User user, List<String> topics, String statement) {
        this.user = user;
        this.topics = topics;
        this.statement = statement;
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "Question{" +
                "user=" + user +
                ", topics=" + topics +
                ", statement='" + statement + '\'' +
                ", timestamp=" + timestamp +
                ", upvotes=" + upvotes +
                ", downvotes=" + downvotes +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public int getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(int downvotes) {
        this.downvotes = downvotes;
    }
}
