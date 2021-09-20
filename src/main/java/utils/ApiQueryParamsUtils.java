package utils;

import java.util.HashMap;

import static constants.CosmosIdApiConstants.QueryParams.*;

public class ApiQueryParamsUtils {
    private static final String BREADCRUMBS_VALUE = "1";
    private static final String OFFSET_VALUE = "0";
    private static final String LIMIT_VALUE = "1000";
    private static final String FOLDER_ID_VALUE = "1622700773180";
    private static final String FOLDER_ID_FOR_COUNT = "84c966d5-8dce-429d-8f92-44d5e28b1581";
    private static final String UNDERSCORE_VALUE = "1622828908054";
    private static final String RUNS_VALUE = "1622700773181";

    public static HashMap<String, String> getQueryFilesParams() {
        HashMap<String, String> params = new HashMap<>();
        params.put(BREADCRUMBS, BREADCRUMBS_VALUE);
        params.put(OFFSET, OFFSET_VALUE);
        params.put(LIMIT, LIMIT_VALUE);
        params.put(UNDERSCORE, FOLDER_ID_VALUE);
        return params;
    }

    public static HashMap<String, String> getCountQueryParams() {
        HashMap<String, String> params = new HashMap<>();
        params.put(FOLDER_ID, FOLDER_ID_FOR_COUNT);
        params.put(UNDERSCORE, UNDERSCORE_VALUE);
        return params;
    }

    public static HashMap<String, String> getRunQueryParams() {
        HashMap<String, String> params = new HashMap<>();
        params.put(UNDERSCORE, RUNS_VALUE);
        return params;
    }

    public static HashMap<String, String> getAnalysisQueryParams() {
        HashMap<String, String> params = new HashMap<>();
        params.put("filter", "total");
        params.put(UNDERSCORE, "1622700773184");
        return params;
    }

    public static HashMap<String, String> getArtifactsQueryParams() {
        HashMap<String, String> params = new HashMap<>();
        params.put(UNDERSCORE, "1622700773185");
        return params;
    }


}
