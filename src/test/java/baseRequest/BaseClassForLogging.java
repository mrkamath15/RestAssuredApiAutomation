package baseRequest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class BaseClassForLogging {
    protected static RequestSpecification spec;
    private RequestSpecBuilder builder;
    private boolean setUpDone = false;

    public BaseClassForLogging() {
        if (!setUpDone) {
            builder = new RequestSpecBuilder();
            builder.setBaseUri("https://reqres.in/");
            builder.setBasePath("api");
            builder.setContentType("application/json");
            builder.addFilter(new RequestLoggingFilter(LogDetail.URI));
            builder.addFilter(new ResponseLoggingFilter(LogDetail.STATUS));

            spec = builder.build();

            setUpDone = true;
        }
    }
}
