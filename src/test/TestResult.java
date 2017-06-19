package test;

/**
 * Test result row for reporting purposes
 *
 * @author AbuKhleif
 */
public class TestResult {
    private String result;
    private String description;

    public TestResult(String result, String description) {
        this.result = result;
        this.description = description;
    }

    public String getResult() {
        return result;
    }

    public String getDescription() {
        return description;
    }
}
