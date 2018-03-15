package simararora.ravendashboard.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Created by Simar Arora on 15/03/18.
 */

public class CreateModel {

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("data")
    @Expose
    private Map<String, String> data;

    public CreateModel(String type, Map<String, String> data) {
        this.type = type;
        this.data = data;
    }

    public CreateModel(Map<String, String> data) {
        this.data = data;
    }

    public CreateModel() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
}
