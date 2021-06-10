package constants;

public class CosmosIdApiConstants {

    public static final class ResponseCodes {
        public static final int CODE_200 = 200;
        public static final int CODE_201 = 201;
        public static final int CODE_400 = 400;
        public static final int CODE_500 = 500;
    }

    public static final class Paths {
        public static final String BASE_URI = "https://app.cosmosid.com";
        public static final String BASE_PATH = "/api";
        public static final String VERSION_V1 = "/v1";
        public static final String VERSION_V2 = "/v2";
        public static final String LOGIN = "/login";
        public static final String PROFILE = "/profile";
        public static final String METAGENID = "/metagenid";
        public static final String RUNS = "/runs";
        public static final String FILES = "/files";
        public static final String COUNT = "/count?";
        public static final String FOLDER_ID = "folder_id=";
        public static final String QUESTION_MARK = "?";
        public static final String BREADCRUMBS = "breadcrumbs";
        public static final String FILES_PATH = METAGENID + VERSION_V2 + FILES;
    }
}
