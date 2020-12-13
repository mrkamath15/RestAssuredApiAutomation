package responsePojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SingleUserData {
    private Data data;
    private Support support;

    public Data getData() {
        return data;
    }

    public Support getSupport() {
        return support;
    }
}
