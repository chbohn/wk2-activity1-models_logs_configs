package wk2.activity1.models_logs_configs.resources;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import wk2.activity1.models_logs_configs.logger.ServiceLogger;
import wk2.activity1.models_logs_configs.models.GetProductRequestModel;
import wk2.activity1.models_logs_configs.models.GetProductResponseModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.io.IOException;

@Path("test")
public class TestPage {
    @Path("hello")
    @GET
    public Response helloWorld() {
        System.err.println("Hello world!");
        return Response.status(Status.OK).build();
    }

    @Path("product")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(String jsonText) {
        System.err.println("Getting product...");
        ObjectMapper mapper = new ObjectMapper();
        int num1;
        int num2;
        int product;
        String resultJSON = "";

        try {
            num1 = mapper.readTree(jsonText).get("num1").asInt();
            num2 = mapper.readTree(jsonText).get("num2").asInt();
            product = num1 * num2;
            System.err.println(num1 + " * " + num2 + " = " + product);
            resultJSON = Integer.toString(product);
        } catch (IOException e) {
            e.printStackTrace();
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.status(Status.OK).entity(resultJSON).build();
    }

    @Path("betterProduct")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBetterProduct(String jsonText) {
        ObjectMapper mapper = new ObjectMapper();
        GetProductRequestModel requestModel;
        GetProductResponseModel responseModel;

        try {
            throw new IOException(); // Remove when ready to implement
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }

    @Path("bestProduct")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBestProduct(String jsonText) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            throw new IOException(); // Remove when ready to implement
        } catch (IOException e) {
            e.printStackTrace();
            if (e instanceof JsonMappingException) {
                System.err.println("Could not map JSON to POJO.");
            } else if (e instanceof JsonParseException) {
                System.err.println("Could not Parse JSON.");
            } else {
                System.err.println("IOException happened.");
            }
        }
        return Response.status(Status.NOT_IMPLEMENTED).build();
    }
}
