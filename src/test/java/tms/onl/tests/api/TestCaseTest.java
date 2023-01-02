package tms.onl.tests.api;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tms.onl.adapter.CaseAdapter;
import tms.onl.model.Case;
import tms.onl.utils.Retry;
import tms.onl.utils.TestListener;

import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static java.net.HttpURLConnection.HTTP_OK;

@Listeners(TestListener.class)
public class TestCaseTest {

    private static int newCaseId;
    private final String projectCode = "QTQ";

    @Test (description = "Get all test cases", retryAnalyzer = Retry.class, enabled = true)
    public void getAllTestCasesTest() {
        int statusCode = new CaseAdapter().getAllCases(projectCode).getStatusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }

    @Test (description = "Get Single test case", retryAnalyzer = Retry.class, enabled = true)
    public void getSingleTestCase() {
        String caseId = "11";
        String expectedCaseName = "First API test";
        String pathToNameField = "result.title";
        Response response = new CaseAdapter().getSingleTestCase(projectCode, caseId);
        int statusCode = response.getStatusCode();
        String actualCaseName = response.body().path(pathToNameField);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(statusCode, HTTP_OK);
        softAssert.assertEquals(actualCaseName, expectedCaseName);
        softAssert.assertAll();
    }

    @Test (description = "Test case is not found", retryAnalyzer = Retry.class, enabled = true)
    public void getNotFoundTestCase() {
        String caseId = "1";
        int statusCode = new CaseAdapter().getSingleTestCase(projectCode, caseId).getStatusCode();
        Assert.assertEquals(statusCode, HTTP_NOT_FOUND);
    }

    @Test (description = "Create tes case", priority = 1, groups = "Short", retryAnalyzer = Retry.class, enabled = true)
    public void createNewTestCase() {
        String testCaseTitle = "API created case";
        Case testCase = Case.builder()
                .title(testCaseTitle)
                .build();
        String pathToIdField = "result.id";
        Response response = new CaseAdapter().createNewTestCase(projectCode, testCase);
        int statusCode = response.getStatusCode();
        newCaseId = response.body().path(pathToIdField);
        Assert.assertEquals(statusCode, HTTP_OK);
    }

    @Test (description = "Delete test case", priority = 2, groups = "Short", retryAnalyzer = Retry.class, enabled = true)
    public void deleteTestCase() {
        int statusCode = new CaseAdapter().deleteTestCase(projectCode, String.valueOf(newCaseId)).getStatusCode();
        Assert.assertEquals(statusCode, HTTP_OK);
    }
}
