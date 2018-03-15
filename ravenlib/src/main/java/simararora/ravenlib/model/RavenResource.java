package simararora.ravenlib.model;

import android.net.Uri;

import java.net.MalformedURLException;
import java.util.Map;

/**
 * Created by Simar Arora on 15/03/18.
 */

public class RavenResource {
    private String resourceType;
    private String resourceId;
    private String sourceId;
    private Map<String, Object> resourceIdParams;
    private Map<String, Object> sourceIdParams;
    private Uri uri;

    public RavenResource(Uri uri) throws Exception{
        //Path is of the type /ab/abcde/abc
        //Where ab is resourceType
        //abcde is resourceId
        //abc is sourceId
        this.uri = uri;
        String path = this.uri.getPath();
        String[] tokens = path.substring(1).split("/");
        if (tokens.length != 3)
            throw new MalformedURLException();
        resourceType = tokens[0];
        resourceId = tokens[1];
        sourceId = tokens[2];
    }

    public boolean isComplete() {
        return resourceIdParams != null && sourceIdParams != null;
    }

    public String getResourceType() {
        return resourceType;
    }

    public String getResourceId() {
        return resourceId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public Map<String, Object> getResourceIdParams() {
        return resourceIdParams;
    }

    public void setResourceIdParams(Map<String, Object> resourceIdParams) {
        this.resourceIdParams = resourceIdParams;
    }

    public void setSourceIdParams(Map<String, Object> sourceIdParams) {
        this.sourceIdParams = sourceIdParams;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "<b>RavenResource</b><br>" +
                "<br><b>resourceType:</b> " + resourceType +
                "<br><b>resourceId:</b> " + resourceId +
                "<br><b>sourceId:</b> " + sourceId +
                mapToString(resourceIdParams) +
                mapToString(sourceIdParams);
    }

    private String mapToString(Map<String, Object> map) {
        StringBuilder s = new StringBuilder();
        for (String key : map.keySet()) {
            s.append(String.format("<br><b>%s:</b> ", key)).append(map.get(key));
        }
        return s.toString();
    }
}
