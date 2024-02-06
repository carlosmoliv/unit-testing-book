package chapter2.reusingCommonInitialization;

public class Database implements AutoCloseable {
    public void connect() {
        System.out.println("Connected to the database");
    }

    public void executeQuery(String query) {
        System.out.println("Executing query: " + query);
    }

    @Override
    public void close() {
        System.out.println("Closing the database connection");
    }
}
