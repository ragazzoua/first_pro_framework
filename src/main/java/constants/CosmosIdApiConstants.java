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
        public static final String COUNT = "/count";
        public static final String ANALYSIS = "/analysis";
        public static final String ARTIFACTS = "/artifacts";
        public static final String FILES_PATH_V2 = METAGENID + VERSION_V2 + FILES;
        public static final String FILES_PATH_V1 = METAGENID + VERSION_V1 + FILES;
        public static final String RUNS_PATH = METAGENID + VERSION_V1 + RUNS;
        public static final String X_TOKEN = "x-token";
        public static final String RUNS_VALUE = "/7f4c7326-0a4e-4b56-a8d0-8ce002191672";
        public static final String ARTIFACTS_VALUE = "/437ef8e4-b595-4fd8-a2f5-64221831e925";
    }

    public static final class QueryParams {
        public static final String FOLDER_ID = "folder_id";
        public static final String UNDERSCORE = "_";
        public static final String BREADCRUMBS = "breadcrumbs";
        public static final String OFFSET = "offset";
        public static final String LIMIT = "limit";
    }

    public static final class ValueFromResponse {
        public static final String TOTAL = "total";
        public static final String ITEMS_NAME_0 = "items.name[0]";
        public static final String NAME = "name";
        public static final String RUNS_STATUS_0 = "runs.status[0]";
        public static final String ANALYSIS_STATUS_0 = "analysis.status[0]";
        public static final String ARTIFACTS_ARTIFACT_TYPE_0 = "artifacts.artifact_type[0]";
        public static final String ARTIFACTS_ARTIFACT_TYPE_1 = "artifacts.artifact_type[1]";
    }

}
