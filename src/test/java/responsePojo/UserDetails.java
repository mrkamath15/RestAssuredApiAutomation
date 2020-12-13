package responsePojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDetails {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private Data[] data;
    private Support support;

    public int getPage() {
        return page;
    }

    public int getPer_page() {
        return per_page;
    }

    public int getTotal() {
        return total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public Data[] getData() {
        return data;
    }

    public Support getSupport() {
        return support;
    }
}
