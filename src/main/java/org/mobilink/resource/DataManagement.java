package org.mobilink.resource;

import java.net.HttpURLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.headers.Header;
import org.mobilink.dictcollection.model.DictCollectionModel;
import org.mobilink.dictcollection.model.DictCollectionResults;
import org.mobilink.exception.model.ExceptionModel;

import io.swagger.annotations.*;


@Path("/dictCollections")
@Api(value="/dictCollections", description="APIs for DictCollection", tags="dictcollection")
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public interface DataManagement {

	@GET
	@Consumes({ MediaType.APPLICATION_ATOM_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Get all DictCollection", response = DictCollectionResults.class)
	@ApiResponses (value = {
	        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a list of DictCollection", response = DictCollectionResults.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class)
	})
	public Response getDictCollection(@Context HttpServletRequest request, @Context Header header);
	
	@GET
	@Path("/{code}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Get a DictCollection detail by its code", response = DictCollectionModel.class)
	public Response getDictCollectionDetail(@Context HttpServletRequest request, @Context Header header,
			@ApiParam(value = "code that need to be get detail", required = true) @PathParam("code") String code);
	
	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Add a DictCollection", response = DictCollectionModel.class)
	public Response addDictCollection(@Context HttpServletRequest request, @Context Header header, String body);

	
	@PUT
	@Path("/{code}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Update DictCollection by its code", response = DictCollectionModel.class)
	@ApiResponses(value = {
	        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a certain DictCollection", response = DictCollectionResults.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized"),
	        @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found"),
	        @ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal server problems")
	})
	public Response updateDictCollection(@Context HttpServletRequest request, @Context Header header,
			@ApiParam(value = "code that need to be update", required = true) @PathParam("code") String code);

}
