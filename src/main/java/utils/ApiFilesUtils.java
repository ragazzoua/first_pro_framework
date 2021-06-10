package utils;

import java.util.HashMap;

public class ApiFilesUtils {
    private static final String BREADCRUMBS = "1";
    private static final String OFFSET = "0";
    private static final String LIMIT = "1000";
    private static final String FOLDER_ID = "1622700773180";

    public static final String ROOT_FOLDER = "ROOT";

    public static HashMap<String, String> getQueryFilesParams() {
        HashMap<String, String> params = new HashMap<>();
        params.put("breadcrumbs", BREADCRUMBS);
        params.put("offset", OFFSET);
        params.put("limit", LIMIT);
        params.put("_", FOLDER_ID);
        return params;
    }

    public static HashMap<String, String> getCountQueryParams() {
        HashMap<String, String> params = new HashMap<>();
        params.put("breadcrumbs", BREADCRUMBS);
        params.put("offset", OFFSET);
        params.put("limit", LIMIT);
        params.put("_", FOLDER_ID);
        return params;
    }


}
