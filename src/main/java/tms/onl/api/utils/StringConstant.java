package tms.onl.api.utils;

public class StringConstant {

    public static final String TOKEN_NAME = "Token";
    public static final String TOKEN_VALUE = "f673a89fc7182686c55acd791d8716cfb0f4da9b";
    public static final String BASE_URL = "https://api.qase.io/v1";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String JSON = "application/json";
    public static final String CASE_API_ENDPOINT = "/case";
    public static final String GET_ALL_CASES_API_ENDPOINT = CASE_API_ENDPOINT + "/%s";
    public static final String GET_SINGLE_CASE_API_ENDPOINT = GET_ALL_CASES_API_ENDPOINT + "/%s";

    private StringConstant() {
    }
}
