import java.util.*;

public class QuestionAnswerInventory {
    private List<Question> questions = new ArrayList<>();
    private List<Answer> answers = new ArrayList<>();
    private Map<String, List<Question>> topicQuestions = new HashMap<>();
    private Map<Question, List<Answer>> questionAnswers = new HashMap<>();

    public void addQuestion(List<String> topics, Question question) {
        questions.add(question);
        for (String topic : topics) {
            topicQuestions.computeIfAbsent(topic, k -> new ArrayList<>()).add(question);
        }
    }

    public List<Question> getQuestions(String topic) {
        return topicQuestions.getOrDefault(topic, new ArrayList<>());
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public List<Question> getQuestions(List<String> topics) {
        List<Question> questions = new ArrayList<>();
        for (String topic : topics) {
            questions.addAll(getQuestions(topic));
        }
        return questions;
    }

    public List<Answer> getAnswers(Question question) {
        return questionAnswers.computeIfAbsent(question, k -> new ArrayList<>());
    }
}
