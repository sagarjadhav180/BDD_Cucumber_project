package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.AppleMacBookDetails;
import model.MachineDetails;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import utils.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.List;
import java.util.Map;

import static com.aventstack.extentreports.reporter.configuration.ViewName.LOG;

public class apiStepDefinitions {

    private static final Logger LOG = LogManager.getLogger(apiStepDefinitions.class);
    private HTTPHelper httpHelper;
    private String machineId;

    public apiStepDefinitions() {
        this.httpHelper = new HTTPHelper();
    }

    @Then("I must get response code {string}")
    public void iMustGetResponseCode(String statusCode) {
        int actualStatusCode = httpHelper.response.statusCode();
        Assert.assertEquals(actualStatusCode, Integer.parseInt(statusCode), "Status code is not 200. Actual status code is ==> " + actualStatusCode);
    }

    @And("I must be able to see all the objects")
    public void iMustBeAbleToSeeAllTheObjects(DataTable dataTable) {
        MachineDetails machineDetail = ResponseHandler.deserailizeResponse(httpHelper.response, MachineDetails.class);
        System.out.println("===============================");
        System.out.println(machineDetail);
        System.out.println("===============================");
        List<Map<String, String>> rows = dataTable.asMaps();
        for (Map<String, String> row : rows) {
            Assert.assertEquals(machineDetail.getId(), row.get("id"),
                    "Ids are not matching. Actual Id is " + machineDetail.getId());

            Assert.assertEquals(machineDetail.getName(), row.get("name"),
                    "Names are not matching. Actual name is " + machineDetail.getName());

            Assert.assertEquals(machineDetail.getData().getGeneration(), row.get("Generation"),
                    "Generation values are not matching. Actual Generation is " + machineDetail.getData().getGeneration());

            Assert.assertEquals(machineDetail.getData().getPrice(), row.get("Price"),
                    "Price values are not matching. Actual Price is " + machineDetail.getData().getPrice());

            Assert.assertEquals(machineDetail.getData().getCapacity(), row.get("Capacity"),
                    "Capacity values are not matching. Actual Capacity is " + machineDetail.getData().getCapacity());


        }
    }

    @Given("I make request to {string} to view objects")
    public void iMakeRequestToToViewObjects(String pathParam) throws IOException, ParseException {
        httpHelper.response = HTTPHelper.GET(pathParam);

    }


    @And("I must be able to see newly created object")
    public void iMustBeAbleToSeeNewlyCreatedObject(DataTable dataTable) {
        AppleMacBookDetails machineDetails = ResponseHandler.deserailizeResponse(httpHelper.response, AppleMacBookDetails.class);
        List<Map<String, String>> rows = dataTable.asMaps();
        for (Map<String, String> row : rows) {
            Assert.assertEquals(machineDetails.getName(), row.get("name"),
                    "Names are not matching. Actual name is " + machineDetails.getName());

            Assert.assertEquals(String.valueOf(machineDetails.getData().getYear()), row.get("year"),
                    "Years are not matching. Actual year is " + machineDetails.getData().getYear());

            Assert.assertEquals(String.valueOf(machineDetails.getData().getPrice()), row.get("price"),
                    "Prices are not matching. Actual price is " + machineDetails.getData().getPrice());

            Assert.assertEquals(machineDetails.getData().getCpuModel(), row.get("CPU model"),
                    "CPU models are not matching. Actual CPU model is " + machineDetails.getData().getCpuModel());

            Assert.assertEquals(machineDetails.getData().getHardDiskSize(), row.get("Hard disk size"),
                    "Hard disk sizes are not matching. Actual size is " + machineDetails.getData().getHardDiskSize());

        }
    }

    @Given("I make a {string} request to create machine data using {string}")
    public void iMakeARequestToCreateMachineDataUsing(String requsetType, String jsonFile) {
        String payload = jsonReader.readFromJson(jsonFile);
        LOG.info("=====Payload====="+payload+"================");
        httpHelper.response = HTTPHelper.POST(payload, "objects");
        AppleMacBookDetails machineDetail = ResponseHandler.deserailizeResponse(httpHelper.response, AppleMacBookDetails.class);
        this.machineId = machineDetail.getId();
        LOG.info("=====Machine id===== "+this.machineId+" ================");

    }

    @And("I make request to {string} to view newly created objects")
    public void iMakeRequestToToViewNewlyCreatedObjects(String pathParam) {
        httpHelper.response = httpHelper.GET(pathParam.concat("/").concat(this.machineId));
    }

    @Given("I make a {string} request to create machine data using data from excel file for scenario {string}")
    public void iMakeARequestToCreateMachineDataUsingDataFromExcelFileForScenario(String requsetType, String ScenarioName) throws IOException {
        Map<String, String> map = excelReader.getData(ScenarioName);
        String payload = map.get("requestbody");
        httpHelper.response = HTTPHelper.POST(payload, "objects");
        AppleMacBookDetails machineDetails = ResponseHandler.deserailizeResponse(httpHelper.response, AppleMacBookDetails.class);
        this.machineId = machineDetails.getId();
        LOG.info("====Machine id -> "+ this.machineId+" ======");
    }

    @And("I must be able to see newly created object using jsonpath")
    public void iMustBeAbleToSeeNewlyCreatedObjectUsingJsonpath(DataTable dataTable) {
        String name = httpHelper.response.jsonPath().getString("name");
        String year = httpHelper.response.jsonPath().getString("data.year");
        String price = httpHelper.response.jsonPath().getString("data.price");
        String cpuModel = httpHelper.response.jsonPath().getString("data['CPU model']");
        String diskSize = httpHelper.response.jsonPath().getString("data['Hard disk size']");

        LOG.info("====name "+name+" =========");
        LOG.info("====year "+year+" =========");
        LOG.info("====price "+price+" =========");
        LOG.info("====cpuModel "+cpuModel+" =========");
        LOG.info("====diskSize "+diskSize+" =========");

        List<Map<String, String>> rows = dataTable.asMaps();
        for (Map<String, String> row : rows) {
            Assert.assertEquals(
                    name,
                    row.get("name"),
                    String.format("Names do not match. Expected: %s, Actual: %s", row.get("name"), name)
            );

            Assert.assertEquals(
                    year,
                    row.get("year"),
                    String.format("Years do not match. Expected: %s, Actual: %s", row.get("year"), year)
            );

            Assert.assertEquals(
                    price,
                    row.get("price"),
                    String.format("Prices do not match. Expected: %s, Actual: %s", row.get("price"), price)
            );

            Assert.assertEquals(
                    cpuModel,
                    row.get("CPU model"),
                    String.format("CPU models do not match. Expected: %s, Actual: %s", row.get("CPU model"), cpuModel)
            );

            Assert.assertEquals(
                    diskSize,
                    row.get("Hard disk size"),
                    String.format("Hard disk sizes do not match. Expected: %s, Actual: %s", row.get("Hard disk size"), diskSize)
            );
        }

    }
}
