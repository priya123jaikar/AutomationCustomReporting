package products;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restUtils.RestUtils;
import utils.JsonUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class ProductsTests extends  ProductAPIs {
    @Test
    public  void  createProducts() throws IOException {
        Map<String ,Object> payload = Payloads.getCreateProductPayloadFromMap("21","","621","538","9","2");
        Response response = createProduct(payload);

        Assert.assertEquals(response.statusCode(),200);


    }
}
