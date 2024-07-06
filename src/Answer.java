public class Answer {
    private User user;
    private String answer;
    private int upvotes;
    private int downvotes;

    public Answer(User user, String answer) {
        this.user = user;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "user=" + user +
                ", answer='" + answer + '\'' +
                ", upvotes=" + upvotes +
                ", downvotes=" + downvotes +
                '}';
    }
}
