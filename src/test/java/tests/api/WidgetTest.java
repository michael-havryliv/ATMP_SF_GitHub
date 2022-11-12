package tests.api;

import config.EndPointsConfig;
import models.widget.ContentParameters;
import models.widget.Widget;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class WidgetTest extends BaseAPITest{

    @Test
    public void createWidgetTest(){
        Widget widget = new Widget();
        widget.setName("myWidget");
        widget.setWidgetType("oldLineChart");

        //content params
        ContentParameters contentParameters = new ContentParameters();
        List<String> contentFields = new ArrayList<>();
        contentFields.add("string");
        contentParameters.setContentFields(contentFields);
        widget.setContentParameters(contentParameters);
        //filter ids
        List<Integer> filterIds = new ArrayList<>();
        filterIds.add(1);
        widget.setFilterIds(filterIds);

        given()
                .spec(requestSpecification)
                .body(widget)
                .when().post(EndPointsConfig.getWidgetEP())
                .then().assertThat().statusCode(201).log().all();
    }

    @Test
    public void modifyWidgetTest(){
        Widget widget = new Widget();
        widget.setShare(false);
        widget.setDescription("NewDescription");

        given()
                .spec(requestSpecification)
                .body(widget)
                .when().put(EndPointsConfig.getWidgetIdEP(1))
                .then().assertThat().statusCode(200).log().all();
    }

}
