import java.util.*;

public class QnAManager {

    private UserLogin userLogin;
    private TopicSubscriptionService topicSubscriptionService = new TopicSubscriptionService();
    private UserService userService = new UserService();
    private QuestionAnswerInventory questionAnswerInventory = new QuestionAnswerInventory();

    private Boolean validRequest() {
        return userLogin.getCurrentlyLoggedInUser() != null;
    }

    public QnAManager(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    public void subscribeTopic(List<String> topics) {
        if (!validRequest()) {
            System.out.println("user not logged in");
            return;
        }
        topicSubscriptionService.addSubscriptions(userLogin.getCurrentlyLoggedInUser(), topics);
    }

    public void unsubscribeTopics(List<String> topics) {
        if (!validRequest()) {
            System.out.println("user not logged in");
            return;
        }
        topicSubscriptionService.removeSubscriptions(userLogin.getCurrentlyLoggedInUser(), topics);
    }

    public void showFeed(List<String> selectedTopics, Boolean answered) {
        List<String> topics = topicSubscriptionService.getSubscriptions(userLogin.getCurrentlyLoggedInUser());
        List<Question> questions = null;
        if (selectedTopics.isEmpty()) {
            questions = questionAnswerInventory.getQuestions();
        } else {
            questions = questionAnswerInventory.getQuestions(selectedTopics);
        }
        for(Question question : questions) {
            List<Answer> answers = questionAnswerInventory.getAnswers(question);
            if (answered && answers.isEmpty()) continue;
            System.out.println("Question:");
            System.out.println(question);
            if (!validRequest()) {
                continue;
            }
            System.out.println("Answers:");
            for(Answer answer : answers) {
                System.out.println(answer);
            }
        }
    }

    public List<Answer> getAnswers(Question question) {
        if (!validRequest()) {
            System.out.println("user not logged in");
            return List.of();
        }
        return questionAnswerInventory.getAnswers(question);
    }

    public void askQuestion(String statement, List<String> topics) {
        if (!validRequest()) {
            System.out.println("user not logged in");
            return;
        }
        Question question = new Question(userLogin.getCurrentlyLoggedInUser(), topics, statement);
        questionAnswerInventory.addQuestion(question.getTopics(), question);
    }

    public void signupUser(int id, String name) {
        userService.add(new User(id, name));
    }

    public void loginUser(int id) {
        User user = userService.getUser(id);
        if (user == null) {
            System.out.println("USER NOT FOUND");
            return;
        }
        userLogin.loginUser(user);
    }

    public void logoutUser() {
        userLogin.logoutUser();
    }
}
