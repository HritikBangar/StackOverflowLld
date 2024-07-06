import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserLogin userLogin = new UserLogin();
        QnAManager manager = new QnAManager(userLogin);
        manager.signupUser(1, "Sachin");
        manager.loginUser(1);
        manager.subscribeTopic(List.of("java", "jdk"));
        manager.askQuestion("What are new open source jdks?", List.of("java", "jdk"));
        manager.askQuestion("Does Hadoop work on JDK 11?", List.of("hadoop", "jdk"));
        manager.showFeed(List.of(), false);
        manager.showFeed(List.of("java"), false);
        manager.showFeed(List.of(), true);
        manager.logoutUser();
    }
}
