public class UserLogin {
    private User currentlyLoggedInUser;

    public void loginUser(User user) {
        this.currentlyLoggedInUser = user;
    }

    public void logoutUser() {
        this.currentlyLoggedInUser = null;
    }

    public User getCurrentlyLoggedInUser() {
        return currentlyLoggedInUser;
    }
}
