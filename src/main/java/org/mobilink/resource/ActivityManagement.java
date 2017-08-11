package org.mobilink.resource;

import java.net.HttpURLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.mobilink.activity.model.AtvArchiveResultsModel;
import org.mobilink.activity.model.AtvChecklistDoingInputModel;
import org.mobilink.activity.model.AtvChecklistInputModel;
import org.mobilink.activity.model.AtvChecklistModel;
import org.mobilink.activity.model.AtvChecklistResultsModel;
import org.mobilink.activity.model.AtvDocArchiveInputModel;
import org.mobilink.activity.model.AtvDocFileInputModel;
import org.mobilink.activity.model.AtvDocFileResultsModel;
import org.mobilink.activity.model.AtvLabelInputModel;
import org.mobilink.activity.model.AtvLabelResultsModel;
import org.mobilink.activity.model.AtvLabelSearchModel;
import org.mobilink.activity.model.AtvRatingInputModel;
import org.mobilink.activity.model.AtvWorkspaceInputModel;
import org.mobilink.activity.model.AtvWorkspaceResultsModel;
import org.mobilink.activity.model.AtvWorkspaceSearchModel;
import org.mobilink.exception.model.ExceptionModel;

import com.liferay.portal.kernel.service.ServiceContext;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/activities")
@Api(value="/activities", description="APIs for Activities")
public interface ActivityManagement {
	
	@GET
	@Path("{id}/docfiles")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Get DocFile of Activity by its id", response = AtvDocFileResultsModel.class)
	@ApiResponses (value = {
	        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a list of DocFile of activity", response = AtvDocFileResultsModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class)
	})
	public Response getDocFilesOfAtivity(@Context HttpServletRequest request, @Context HttpHeaders header, 
			@Context ServiceContext serviceContext, 
			@ApiParam(value = "id of avtivity need to get docfile") @PathParam("id") long id);
	
	@POST
	@Path("{id}/docfiles")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Add DocFile of Activity", response=AtvDocFileInputModel.class)
	@ApiResponses (value = {
	        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a docFileId was added to Activity", response=AtvDocFileInputModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class)
	})
	public Response addDocFileToAtivity(@Context HttpServletRequest request, @Context HttpHeaders header, 
			@Context ServiceContext serviceContext, 
			@ApiParam(value = "id of avtivity need to add docfile") @PathParam("id") long id,
			@ApiParam(value= "Model that store docFileId wanna add to activity") @BeanParam AtvDocFileInputModel docFile);
	
	@DELETE
	@Path("{id}/docfiles/{docFileId}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Delete DocFile of Activity", response=AtvDocFileInputModel.class)
	@ApiResponses (value = {
	        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a docFileId was deleted", response=AtvDocFileInputModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class)
	})
	public Response delDocFileOfAtivity(@Context HttpServletRequest request, @Context HttpHeaders header, 
			@Context ServiceContext serviceContext, 
			@ApiParam(value = "id of avtivity need to delete docfile") @PathParam("id") long id,
			@ApiParam(value = "docFileId of DocFile need to delete") @PathParam("docFileId") long docFileId);
	
	@GET
	@Path("{id}/docarchives")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Get Activity's DocArchive List", response=AtvArchiveResultsModel.class)
	@ApiResponses (value = {
	        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a list of DocArchive of Activity", response=AtvArchiveResultsModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class)
	})
	public Response getDocArchivesOfAtivity(@Context HttpServletRequest request, @Context HttpHeaders header, 
			@Context ServiceContext serviceContext, 
			@ApiParam(value = "id of avtivity need to get docarchive") @PathParam("id") long id);
	
	
	@POST
	@Path("{id}/docarchives")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Add DocArchive to Activity", response=AtvDocArchiveInputModel.class)
	@ApiResponses (value = {
	        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a DocArchiveId was added to Activity", response=AtvDocArchiveInputModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class)
	})
	public Response addDocArchiveToAtivity(@Context HttpServletRequest request, @Context HttpHeaders header, 
			@Context ServiceContext serviceContext, 
			@ApiParam(value = "id of avtivity need to add docarchive to") @PathParam("id") long id,
			@ApiParam(value = "Model that store docArchiveId wanna add to activity") @BeanParam AtvDocArchiveInputModel docArchive);

	@DELETE
	@Path("{id}/docarchives")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Remove DocArchive out of Activity", response=AtvDocArchiveInputModel.class)
	@ApiResponses (value = {
	        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a DocArchiveId was removed out of Activity", response=AtvDocArchiveInputModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class)
	})
	public Response deleteDocArchiveToAtivity(@Context HttpServletRequest request, @Context HttpHeaders header, 
			@Context ServiceContext serviceContext, 
			@ApiParam(value = "id of avtivity need to remove docarchive") @PathParam("id") long id);

	@GET
	@Path("{id}/checklists")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Get Activity's CheckList list", response=AtvChecklistResultsModel.class)
	@ApiResponses (value = {
	        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a CheckList list of Activity that was got by activityId", response=AtvChecklistResultsModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class)
	})
	public Response getCheckListOfAtivity(@Context HttpServletRequest request, @Context HttpHeaders header, 
			@Context ServiceContext serviceContext, 
			@ApiParam(value = "id of avtivity need to get checklist list") @PathParam("id") long id);
	
	@POST
	@Path("{id}/checklists")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Add a checklist to activity", response=AtvChecklistInputModel.class)
	@ApiResponses (value = {
	        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a CheckList list was added to activity", response=AtvChecklistInputModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class)
	})
	public Response addCheckListToAtivity(@Context HttpServletRequest request, @Context HttpHeaders header, 
			@Context ServiceContext serviceContext, 
			@ApiParam(value = "id of avtivity need to add checklist") @PathParam("id") long id,
			@ApiParam(value = "input model") @BeanParam AtvChecklistInputModel checklist);

	@PUT
	@Path("{id}/checklists/{checklistId}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Add a checklist to activity", response=AtvChecklistInputModel.class)
	@ApiResponses (value = {
	        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a CheckList list was updated", response=AtvChecklistInputModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class)
	})
	public Response updateCheckListOfAtivity(@Context HttpServletRequest request, @Context HttpHeaders header, 
			@Context ServiceContext serviceContext, 
			@ApiParam(value = "id of avtivity need to update checklist") @PathParam("id") long id,
			@ApiParam(value = "id of checklist need to update checklist") @PathParam("checklistId") long checklistId,
			@ApiParam(value = "input model") @BeanParam AtvChecklistInputModel checklist);

	@POST
	@Path("{id}/checklists/{checklistId}/rating")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Add a rating for user", response=AtvRatingInputModel.class)
	@ApiResponses (value = {
	        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a rating was updated to user", response=AtvRatingInputModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class)
	})
	public Response addRatingOfChecklist(@Context HttpServletRequest request, @Context HttpHeaders header, 
			@Context ServiceContext serviceContext, 
			@ApiParam(value = "id of avtivity need to add rating") @PathParam("id") long id,
			@ApiParam(value = "id of checklist need to add rating") @PathParam("checklistId") long checklistId,
			@ApiParam(value = "input model") @BeanParam AtvRatingInputModel checklist);
	
	@PUT
	@Path("{id}/checklists/{checklistId}/doing")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "update progress of a checklist", response=AtvChecklistDoingInputModel.class)
	@ApiResponses (value = {
	        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns progress was updated to checklist", response=AtvChecklistDoingInputModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class)
	})
	public Response updateDoingOfChecklist(@Context HttpServletRequest request, @Context HttpHeaders header, 
			@Context ServiceContext serviceContext, 
			@ApiParam(value = "id of avtivity need to update progress") @PathParam("id") long id,
			@ApiParam(value = "id of checklist need to update progress") @PathParam("checklistId") long checklistId,
			@ApiParam(value = "input model") @BeanParam AtvChecklistDoingInputModel checklist);
	
	@DELETE
	@Path("{id}/checklists/{checklistId}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Removes checklist of activity", response=AtvChecklistModel.class)
	@ApiResponses (value = {
	        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a checklist was deleted", response=AtvChecklistModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class)
	})
	public Response deleteChecklist(@Context HttpServletRequest request, @Context HttpHeaders header, 
			@Context ServiceContext serviceContext, 
			@ApiParam(value = "id of avtivity need to delete") @PathParam("id") long id,
			@ApiParam(value = "id of checklist need to delete") @PathParam("checklistId") long checklistId);

	//Label

	@GET
	@Path("{id}/labels")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Get Label list of activity", response=AtvLabelResultsModel.class)
	@ApiResponses (value = {
	        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns label list of activity", response=AtvLabelResultsModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class)
	})
	public Response getLabelOfActivity(@Context HttpServletRequest request, @Context HttpHeaders header, 
			@Context ServiceContext serviceContext, 
			@ApiParam(value = "id of avtivity need to get label list") @PathParam("id") long id,
			@ApiParam(value = "Query Param") @BeanParam AtvLabelSearchModel labelSearchModel);
	
	@POST
	@Path("{id}/labels")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Add Label to activity", response=AtvLabelInputModel.class)
	@ApiResponses (value = {
	        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns label was added to activity", response=AtvLabelInputModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class)
	})
	public Response addLabelToActivity(@Context HttpServletRequest request, @Context HttpHeaders header, 
			@Context ServiceContext serviceContext, 
			@ApiParam(value = "id of avtivity need to add to activity") @PathParam("id") long id,
			@ApiParam(value = "model input") @BeanParam AtvLabelInputModel labelInput);

	@DELETE
	@Path("{id}/labels/{labelId}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Remove Label out of activity", response=AtvLabelInputModel.class)
	@ApiResponses (value = {
	        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns label was remove out of activity", response=AtvLabelInputModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class)
	})
	public Response deleteLabelOfActivity(@Context HttpServletRequest request, @Context HttpHeaders header, 
			@Context ServiceContext serviceContext, 
			@ApiParam(value = "id of avtivity need to delete label") @PathParam("id") long id,
			@ApiParam(value = "labelId of avtivity need to delete label") @PathParam("labelId") long labelId);
	
	//Workspaces

	@GET
	@Path("{id}/workspaces")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Get Worspace list of activity", response=AtvWorkspaceResultsModel.class)
	@ApiResponses (value = {
	        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns Workspace list of activity", response=AtvWorkspaceResultsModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class)
	})
	public Response getWorkspacesOfActivity(@Context HttpServletRequest request, @Context HttpHeaders header, 
			@Context ServiceContext serviceContext, 
			@ApiParam(value = "id of avtivity need to get workspace list") @PathParam("id") long id,
			@ApiParam(value = "search query for workspace") @BeanParam AtvWorkspaceSearchModel query);
	
	@POST
	@Path("{id}/workspaces")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Add Workspace to activity", response=AtvWorkspaceInputModel.class)
	@ApiResponses (value = {
	        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns the workspcae was added to activity", response=AtvWorkspaceInputModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class)
	})
	public Response addWorkspaceToActivity(@Context HttpServletRequest request, @Context HttpHeaders header, 
			@Context ServiceContext serviceContext, 
			@ApiParam(value = "id of avtivity need to add workspace to activity") @PathParam("id") long id,
			@ApiParam(value = "model input") @BeanParam AtvWorkspaceInputModel workspaceInputModel);
	
	@DELETE
	@Path("{id}/workspaces/{workspaceId}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Remove Workspace out of activity", response=AtvWorkspaceInputModel.class)
	@ApiResponses (value = {
	        @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns Workspace was remove out of activity", response=AtvWorkspaceInputModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
	        @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class)
	})
	public Response deleteWorkspaceOfActivity(@Context HttpServletRequest request, @Context HttpHeaders header, 
			@Context ServiceContext serviceContext, 
			@ApiParam(value = "id of avtivity need to delete workspace") @PathParam("id") long id,
			@ApiParam(value = "workspaceId of avtivity need to delete workspace") @PathParam("workspaceId") long workspaceId);

}
