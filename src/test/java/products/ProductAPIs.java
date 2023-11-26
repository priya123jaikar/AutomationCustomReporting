package products;

import io.restassured.response.Response;
import restUtils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class ProductAPIs {
    public Response createProduct(Map<String , Object> createProductPayload){
        String endpoint = (String) Base.dataFromJsonFile.get("createProductEndPoint");
        return RestUtils.performPost(endpoint,createProductPayload, new HashMap<>());
    }
}
