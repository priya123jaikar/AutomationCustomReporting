package products;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Payloads {
    public  static  String getCreateProductPayloadFromString(String id , String products , String total , String discountedTotal  , String userId , String totalProducts){
        String payload ="{\n" +
                "  \"id\": "+id+",\n" +
                "  \"products\": [ \n" +
                "    {\n" +
                "      \n" +
                "    } \n" +
                "  ],\n" +
                "  \"total\": "+total+", \n" +
                "  \"discountedTotal\": "+discountedTotal+",\n" +
                "  \"userId\": "+userId+", \n" +
                "  \"totalProducts\": "+totalProducts+"\n" +
                "}\n";
        return  payload;
    }

    public  static  Map<String, Object> getCreateProductPayloadFromMap(String id , String products , String total , String discountedTotal  , String userId , String totalProducts){
        Map<String, Object> payload = new HashMap<>();
        payload.put("id", id);
        payload.put("products", products);
        payload.put("total", total);
        payload.put("discountedTotal" , discountedTotal);
        payload.put("userId" , userId);
        payload.put("totalProducts", totalProducts);

        return  payload;
    }
}
