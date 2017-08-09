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
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.mobilink.docfile.model.AttachsResults;
import org.mobilink.docfile.model.ChangeLogResults;
import org.mobilink.docfile.model.DocFileDetailModel;
import org.mobilink.docfile.model.DocFileModel;
import org.mobilink.docfile.model.DocFileResults;
import org.mobilink.docfile.model.LabelResults;
import org.mobilink.docfile.model.LabelShortModel;
import org.mobilink.docfile.model.LinkModel;
import org.mobilink.docfile.model.LinkResults;
import org.mobilink.docfile.model.LinkShortModel;
import org.mobilink.docfile.model.RolesInputModel;
import org.mobilink.docfile.model.RolesModel;
import org.mobilink.docfile.model.RolesResults;
import org.mobilink.docfile.model.RolesShortModel;
import org.mobilink.docfile.model.UserDocFileInputModel;
import org.mobilink.docfile.model.UserDocFileModel;
import org.mobilink.docfile.model.UserDocFileResults;
import org.mobilink.docfile.model.UserDocFileShortModel;
import org.mobilink.exception.model.ExceptionModel;
import org.mobilink.location.model.LocationInputModel;
import org.mobilink.location.model.LocationModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/docfiles")
@Api(value = "/docfiles", description = "APIs for DocFile", tags = "doc,file,docfiles")
public interface DocFile {
	@GET
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Get all DocFile", response = DocFileResults.class)
	@ApiResponses(value = {
			@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a list of DocFile", response = DocFileResults.class),
			@ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class) })
	public Response getDocFiles(@Context HttpServletRequest request, @Context HttpHeaders header,
			@ApiParam(value = "template", required = false) @QueryParam("template ") String template,
			@ApiParam(value = "register", required = false) @QueryParam("register") String register,
			@ApiParam(value = "issuer", required = false) @QueryParam("issuer") String issuer,
			@ApiParam(value = "type(1-5)", required = false) @QueryParam("type") String type,
			@ApiParam(value = "typename", required = false) @QueryParam("typename") String typename,
			@ApiParam(value = "month", required = false) @QueryParam("month") String month,
			@ApiParam(value = "year", required = false) @QueryParam("year") String year,
			@ApiParam(value = "label", required = false) @QueryParam("label") String label,
			@ApiParam(value = "top= new/overdue/duesoon", required = false) @QueryParam("top") String top,
			@ApiParam(value = "permission= read/write/owner", required = false) @QueryParam("permission") String permission,
			@ApiParam(value = "keyword", required = false) @QueryParam("keyword") String keyword,
			@ApiParam(value = "page", required = false) @QueryParam("page") String page,
			@ApiParam(value = "size of page", required = false) @QueryParam("pageSize") String pageSize,
			@ApiParam(value = "sort=modifiedDate/createDate/promulgationDate/registerDate/dueDate", required = false) @QueryParam("sort") String sort);
	
	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Add a DocFile", response = DocFileModel.class)
	@ApiResponses(value = {
			@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a certain DocFile was created", response = DocFileModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized"),
			@ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found"),
			@ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal server problems") })
	public Response addDocFile(@Context HttpServletRequest request, @Context HttpHeaders header, String body);
	
	@GET
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Get a DocFileDetailModel detail by its id", response = DocFileDetailModel.class)
	public Response getDocFiles(@Context HttpServletRequest request, @Context HttpHeaders header,
			@ApiParam(value = "Id that need to be get detail", required = true) @PathParam("id") String id);
	
	@DELETE
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Delete DocFile by its id", response = DocFileModel.class)
	@ApiResponses(value = {
			@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a certain DocFile was deleted", response = DocFileModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized"),
			@ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found"),
			@ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal server problems") })
	public Response deleteDocFile(@Context HttpServletRequest request, @Context HttpHeaders header,
			@ApiParam(value = "Id that need to be deleted", required = true) @PathParam("id") String id);
//Label
	@GET
	@Path("/{id}/labels")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Get all Label", response = LabelResults.class)
	@ApiResponses(value = {
			@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a list of Label", response = LabelResults.class),
			@ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class) })
	public Response getLabels(@Context HttpServletRequest request, @Context HttpHeaders header,
			@ApiParam(value = "number of page", required = false) @QueryParam("page") String page,
			@ApiParam(value = "size of page", required = false) @QueryParam("pageSize") String pageSize);
	
	@POST
	@Path("/{id}/labels")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Add a Label", response = LabelShortModel.class)
	@ApiResponses(value = {
			@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a certain Label was created", response = LabelShortModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized"),
			@ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found"),
			@ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal server problems") })
	public Response addLabel(@Context HttpServletRequest request, @Context HttpHeaders header, String body);

	@DELETE
	@Path("/{id}/labels/{labelId}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Delete Label by its labelId", response = LocationModel.class)
	@ApiResponses(value = {
			@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a certain Label was deleted", response = LocationModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized"),
			@ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found"),
			@ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal server problems") })
	public Response deleteLabel(@Context HttpServletRequest request, @Context HttpHeaders header,
			@ApiParam(value = "labelId that need to be deleted", required = true) @PathParam("labelId") String labelId);
//Roles
	@GET
	@Path("/{id}/roles")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Get all Roles", response = RolesResults.class)
	@ApiResponses(value = {
			@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a list of Roles", response = RolesResults.class),
			@ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class) })
	public Response getRoles(@Context HttpServletRequest request, @Context HttpHeaders header,
			@ApiParam(value = "number of page", required = false) @QueryParam("page") String page,
			@ApiParam(value = "size of page", required = false) @QueryParam("pageSize") String pageSize);	
	
	@POST
	@Path("/{id}/roles")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Add a Roles", response = RolesShortModel.class)
	@ApiResponses(value = {
			@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a certain Roles was created", response = RolesShortModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized"),
			@ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found"),
			@ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal server problems") })
	public Response addRoles(@Context HttpServletRequest request, @Context HttpHeaders header, String body);
	
	@PUT
	@Path("/{id}/roles/{roleId}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Update Roles by its id", response = RolesModel.class)
	@ApiResponses(value = {
			@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a certain RolesModel that has been updated", response = RolesModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized"),
			@ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found"),
			@ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal server problems") })
	public Response updateRoles(@Context HttpServletRequest request, @Context HttpHeaders header,
			@ApiParam(value = "roleId that need to be updated", required = true) @PathParam("roleId") String roleId,
			@ApiParam RolesInputModel input);
	
	@DELETE
	@Path("/{id}/roles/{roleId}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Delete Roles by its roleId", response = RolesModel.class)
	@ApiResponses(value = {
			@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a certain Roles was deleted", response = RolesModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized"),
			@ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found"),
			@ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal server problems") })
	public Response deleteRole(@Context HttpServletRequest request, @Context HttpHeaders header,
			@ApiParam(value = "roleId that need to be deleted", required = true) @PathParam("roleId") String roleId);

//Users
	@GET
	@Path("/{id}/users")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Get all Users", response = UserDocFileResults.class)
	@ApiResponses(value = {
			@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a list of Users", response = UserDocFileResults.class),
			@ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class) })
	public Response getUsers(@Context HttpServletRequest request, @Context HttpHeaders header,
			@ApiParam(value = "number of page", required = false) @QueryParam("page") String page,
			@ApiParam(value = "size of page", required = false) @QueryParam("pageSize") String pageSize);	
	
	@POST
	@Path("/{id}/users")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Add a Users", response = UserDocFileShortModel.class)
	@ApiResponses(value = {
			@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a certain Users was created", response = UserDocFileShortModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized"),
			@ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found"),
			@ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal server problems") })
	public Response addUsers(@Context HttpServletRequest request, @Context HttpHeaders header, String body);
	
	@PUT
	@Path("/{id}/users/{userId}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Update Users by its userId", response = UserDocFileModel.class)
	@ApiResponses(value = {
			@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a certain UserDocFileModel that has been updated", response = UserDocFileModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized"),
			@ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found"),
			@ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal server problems") })
	public Response updateUsers(@Context HttpServletRequest request, @Context HttpHeaders header,
			@ApiParam(value = "userId that need to be updated", required = true) @PathParam("userId") String userId,
			@ApiParam UserDocFileInputModel input);
	
	@DELETE
	@Path("/{id}/users/{userId}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Delete Users by its roleId", response = UserDocFileModel.class)
	@ApiResponses(value = {
			@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a certain Users was deleted", response = UserDocFileModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized"),
			@ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found"),
			@ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal server problems") })
	public Response deleteUser(@Context HttpServletRequest request, @Context HttpHeaders header,
			@ApiParam(value = "userId that need to be deleted", required = true) @PathParam("userId") String userId);

//Links	
	@GET
	@Path("/{id}/links")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Get all Links", response = LinkResults.class)
	@ApiResponses(value = {
			@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a list of Links", response = LinkResults.class),
			@ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class) })
	public Response getLinks(@Context HttpServletRequest request, @Context HttpHeaders header,
			@ApiParam(value = "number of page", required = false) @QueryParam("page") String page,
			@ApiParam(value = "size of page", required = false) @QueryParam("pageSize") String pageSize);	
	
	@POST
	@Path("/{id}/links")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Add a Links", response = LinkShortModel.class)
	@ApiResponses(value = {
			@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a certain Links was created", response = LinkShortModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized"),
			@ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found"),
			@ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal server problems") })
	public Response addLinks(@Context HttpServletRequest request, @Context HttpHeaders header, String body);
	
	@DELETE
	@Path("/{id}/links/{docFileId}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Delete Links by its docFileId", response = LinkModel.class)
	@ApiResponses(value = {
			@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a certain Links was deleted", response = LinkModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized"),
			@ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found"),
			@ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal server problems") })
	public Response deleteLink(@Context HttpServletRequest request, @Context HttpHeaders header,
			@ApiParam(value = "docFileId that need to be deleted", required = true) @PathParam("docFileId") String docFileId);

//Attach
	@GET
	@Path("/{id}/attachs")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Get all Attachs", response = AttachsResults.class)
	@ApiResponses(value = {
			@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a list of Attachs", response = AttachsResults.class),
			@ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class) })
	public Response getAttachs(@Context HttpServletRequest request, @Context HttpHeaders header,
			@ApiParam(value = "number of page", required = false) @QueryParam("page") String page,
			@ApiParam(value = "size of page", required = false) @QueryParam("pageSize") String pageSize);	
	
//Changelog
	@GET
	@Path("/{id}/changelogs")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Get all Changelogs", response = ChangeLogResults.class)
	@ApiResponses(value = {
			@ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns a list of Changelogs", response = ChangeLogResults.class),
			@ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized", response = ExceptionModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found", response = ExceptionModel.class),
			@ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Access denied", response = ExceptionModel.class) })
	public Response getChangelogs(@Context HttpServletRequest request, @Context HttpHeaders header,
			@ApiParam(value = "number of page", required = false) @QueryParam("page") String page,
			@ApiParam(value = "size of page", required = false) @QueryParam("pageSize") String pageSize);	
	
}	
