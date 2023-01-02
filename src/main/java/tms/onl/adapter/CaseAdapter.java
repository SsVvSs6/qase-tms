package tms.onl.adapter;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import tms.onl.model.Case;

import static tms.onl.utils.StringConstant.GET_ALL_CASES_API_ENDPOINT;
import static tms.onl.utils.StringConstant.GET_SINGLE_CASE_API_ENDPOINT;

public class CaseAdapter extends BaseAdapter {

    @Step("Get all test cases")
    public Response getAllCases(String projectCode) {
        return get(String.format(GET_ALL_CASES_API_ENDPOINT, projectCode));
    }

    @Step("Get a specific test case")
    public Response getSingleTestCase(String projectCode, String caseCode) {
        return get(String.format(GET_SINGLE_CASE_API_ENDPOINT, projectCode, caseCode));
    }

    @Step("Create new test case")
    public Response createNewTestCase(String projectCode, Case testCase) {
        return post(String.format(GET_ALL_CASES_API_ENDPOINT, projectCode), converter.toJson(testCase));
    }

    @Step("Delete test case")
    public Response deleteTestCase(String projectCode, String caseCode) {
        return delete(String.format(GET_SINGLE_CASE_API_ENDPOINT, projectCode, caseCode));
    }
}
