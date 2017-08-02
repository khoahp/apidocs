package org.mobilink.resource;

import java.net.HttpURLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.headers.Header;
import org.mobilink.exception.model.ExceptionModel;
import org.mobilink.label.model.LabelInputModel;
import org.mobilink.label.model.LabelModel;
import org.mobilink.label.model.LabelResults;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/labels")
@Api(value = "/labels", description = "APIs for Label", tags = "labels")
public interface Label {
	@GET
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Get all Label", response = LabelResults.class)
	@ApiResponses(value = {
			@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a list of Label", response = LabelResults.class),
			@ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class) })
	public Response getLabels(@Context HttpServletRequest request, @Context Header header,
			@ApiParam(value = "number of page", required = false) @QueryParam("page") String page,
			@ApiParam(value = "size of page", required = false) @QueryParam("pageSize") String pageSize);

	/**
	 * @param request
	 * @param header
	 * @param type
	 * @return
	 */
	@GET
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Get a LabelResults detail by its id", response = LabelModel.class)
	public Response getLabel(@Context HttpServletRequest request, @Context Header header,
			@ApiParam(value = "Id that need to be get detail", required = true) @PathParam("id") String id);

	/**
	 * @param request
	 * @param header
	 * @param type
	 * @param input
	 * @return
	 */
	@PUT
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Update Labels by its id", response = LabelModel.class)
	@ApiResponses(value = {
			@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a certain LabelsModel that has been updated", response = LabelModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized"),
			@ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found"),
			@ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal server problems") })
	public Response updateLabel(@Context HttpServletRequest request, @Context Header header,
			@ApiParam(value = "Id that need to be updated", required = true) @PathParam("id") String id,
			@ApiParam LabelInputModel input);

	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Add a Label", response = LabelModel.class)
	@ApiResponses(value = {
			@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a certain Label was created", response = LabelModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized"),
			@ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found"),
			@ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal server problems") })
	public Response addLabel(@Context HttpServletRequest request, @Context Header header, String body);

	@DELETE
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Delete Label by its id", response = LabelModel.class)
	@ApiResponses(value = {
			@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a certain Label was deleted", response = LabelModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized"),
			@ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found"),
			@ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal server problems") })
	public Response deleteLabel(@Context HttpServletRequest request, @Context Header header,
			@ApiParam(value = "Id that need to be deleted", required = true) @PathParam("id") String id);

}
