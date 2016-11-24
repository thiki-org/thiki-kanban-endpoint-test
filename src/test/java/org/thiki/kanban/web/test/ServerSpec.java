package org.thiki.kanban.web.test;

import com.thoughtworks.gauge.Step;
import org.thiki.kanban.web.test.util.PropertiesUtil;

import java.io.IOException;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Created by xubt on 23/11/2016.
 */
public class ServerSpec {
    @Step("Visit remote server.")
    public void checkPageTitle() throws IOException {
        String serverAddress = PropertiesUtil.loadPropByName("server");
        given().when()
                .get(serverAddress)
                .then()
                .statusCode(200)
                .body("description", equalTo("Welcome!"));
    }
}
