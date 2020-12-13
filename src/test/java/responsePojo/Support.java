package responsePojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Support {
    private String url;
    private String text;

    public String getUrl() {
        return url;
    }

    public String getText() {
        return text;
    }
}
