package chapter2.reusingCommonInitialization;

public abstract class IntegrationTests implements AutoCloseable {
    protected final Database database;

    protected IntegrationTests() {
        this.database = new Database();
    }

    @Override
    public void close() {
        database.close();
    }
}
