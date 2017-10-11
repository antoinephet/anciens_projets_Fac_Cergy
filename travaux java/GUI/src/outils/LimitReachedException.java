package outils;

public class LimitReachedException extends Exception {
    public LimitReachedException(int limit) {
        super("Limit " + limit + " reached for the counter !");
    }
}
