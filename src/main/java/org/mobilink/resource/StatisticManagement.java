package org.mobilink.resource;

import java.net.HttpURLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.mobilink.api.statistic.model.CheckListResultsModel;
import org.mobilink.api.statistic.model.CheckListSearchModel;
import org.mobilink.api.statistic.model.CklActivityMonthResultsModel;
import org.mobilink.api.statistic.model.CklActivityMonthSearchModel;
import org.mobilink.api.statistic.model.CklActivityUserResultsModel;
import org.mobilink.api.statistic.model.CklActivityUserSearchModel;
import org.mobilink.api.statistic.model.ToDoListResultsModel;
import org.mobilink.api.statistic.model.ToDoListSearchModel;
import org.mobilink.exception.model.ExceptionModel;

import com.liferay.portal.kernel.service.ServiceContext;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/statistics")
@Api(value="/statistics", description="APIs for Statistics")
public interface StatisticManagement {
	
	@GET
	@Path("todolist")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Get statistic list for TODO of every employee in group (or organization)", response = ToDoListResultsModel.class)
	@ApiResponses (value = {
	        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns statistic list", response = ToDoListResultsModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class)
	})
	
	public Response getToDoList(@Context HttpServletRequest request, @Context HttpHeaders header, 
			@Context ServiceContext serviceContext, 
			@ApiParam(value = "query bean") @BeanParam ToDoListSearchModel query);
	
	
	@GET
	@Path("checklist/year/{y}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Get statistic list for CHECKLIST by year of every employee in group (or organization)", response = CheckListResultsModel.class)
	@ApiResponses (value = {
	        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns statistic list of CHECKLIST", response = CheckListResultsModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class)
	})
	
	public Response getCheckList(@Context HttpServletRequest request, @Context HttpHeaders header, 
			@Context ServiceContext serviceContext,
			@ApiParam(value = "year for statistic") @PathParam("y") int year,
			@ApiParam(value = "query bean") @BeanParam CheckListSearchModel query
	);
	
	@GET
	@Path("checklist/activitiesbymonth/year/{y}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Get statistic list for ACTIVITY by month of year of every employee in group (or organization)", response = CklActivityMonthResultsModel.class)
	@ApiResponses (value = {
	        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns statistic list of CHECKLIST", response = CklActivityMonthResultsModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class)
	})
	public Response getActivityByMonth(@Context HttpServletRequest request, @Context HttpHeaders header, 
			@Context ServiceContext serviceContext,
			@ApiParam(value = "year for statistic") @PathParam("y") int year,
			@ApiParam(value = "query bean") @BeanParam CklActivityMonthSearchModel query
	);

	@GET
	@Path("checklist/activitiesbyuser/year/{y}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Get statistic list for ACTIVITY by user of month of year in group (or organization)", response = CklActivityUserResultsModel.class)
	@ApiResponses (value = {
	        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns statistic list of CHECKLIST", response = CklActivityUserResultsModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class)
	})
	public Response getActivityByUser(@Context HttpServletRequest request, @Context HttpHeaders header, 
			@Context ServiceContext serviceContext,
			@ApiParam(value = "year for statistic") @PathParam("y") int year,
			@ApiParam(value = "query bean") @BeanParam CklActivityUserSearchModel query
	);

}
