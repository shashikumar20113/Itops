<%-- Copyright (c) 2016 lti. All rights reserved.--%>

<%--  @author Sunilkumar Prabhakar --%>




<%@ include file="init.jsp"%>

<%
	SearchContainer searchContainer = (SearchContainer) request
			.getAttribute("liferay-ui:search:searchContainer");

ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

TTDPSPTaskCustomerMap tTDPSPTaskCustomerMap = (TTDPSPTaskCustomerMap) row.getObject();
long taskId = tTDPSPTaskCustomerMap.getTaskId();


long towerCustomerId = ParamUtil.getLong(renderRequest,	"towerCustomerId", 0);
long tTechnologyCustomerId = ParamUtil.getLong(renderRequest,	"tTechnologyCustomerId", 0);
long tTDeliverableCustomerId = ParamUtil.getLong(renderRequest,	"tTDeliverableCustomerId", 0);
long tTDProcessCustomerId = ParamUtil.getLong(renderRequest,	"tTDProcessCustomerId", 0);
long tTDPSubProcessCustomerId = ParamUtil.getLong(renderRequest,"tTDPSubProcessCustomerId", 0);


Organization project = null; 

try {
	project = OrganizationLocalServiceUtil.getOrganization(tTDPSPTaskCustomerMap.getOrganizationId());
} catch (Exception e) {
log("IPAC : Error while fetching project for project id "
		+ tTDPSPTaskCustomerMap.getOrganizationId(), e);
}

int taskStatus= TaskLocalServiceUtil.getTask(taskId).getStatusId();
		
if(!ArrayUtil.contains(SPStatus.DISABLED_STATUSES,taskStatus))
{

%>

<liferay-ui:icon-menu>
<%
if ( ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project))
{

%>
<portlet:renderURL var="editTaskURL">
	<portlet:param name="mvcPath" value="/html/customercatalogmanagement/editTask.jsp" />
	<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
	<portlet:param name="tTechnologyCustomerId"	value="<%=String.valueOf(tTechnologyCustomerId)%>" />
	<portlet:param name="tTDeliverableCustomerId"	value="<%=String.valueOf(tTDeliverableCustomerId)%>" />
	<portlet:param name="tTDProcessCustomerId"	value="<%=String.valueOf(tTDProcessCustomerId)%>" />
	<portlet:param name="tTDPSPTaskCustomerId"	value="<%=String.valueOf(tTDPSPTaskCustomerMap.getTTDPSPTaskCustomerId())%>" />
	<portlet:param name="tTDPSubProcessCustomerId" value="<%=String.valueOf(tTDPSubProcessCustomerId)%>" />
</portlet:renderURL>

<liferay-ui:icon image="edit" url="<%=editTaskURL%>" label="true" message="edit" />
	

<%
}
if (TTDPSPTaskCustomerMapPermissions.isPermissionAdmin(themeDisplay, tTDPSPTaskCustomerMap.getTTDPSPTaskCustomerId()))
{	
		int[] roleTyes = { RoleConstants.TYPE_ORGANIZATION };
%>

<liferay-security:permissionsURL
	resourceGroupId="<%=project.getGroupId() %>"
	modelResource="<%=TTDPSPTaskCustomerMap.class.getName()%>"
	modelResourceDescription="<%=tTDPSPTaskCustomerMap.getName(themeDisplay.getLocale())%>"
	resourcePrimKey="<%=String.valueOf(tTDPSPTaskCustomerMap.getTTDPSPTaskCustomerId())%>"
	var="permissionURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>"
	roleTypes="<%=roleTyes%>"></liferay-security:permissionsURL>
<liferay-ui:icon image="lock" url="<%=permissionURL%>" label="true" message="permissions" useDialog="true" />
<%
}
%>
</liferay-ui:icon-menu>
<%
}
%>