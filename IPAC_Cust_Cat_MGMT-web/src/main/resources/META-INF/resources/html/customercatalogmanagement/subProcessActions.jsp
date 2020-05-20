<%-- Copyright (c) 2016 lti. All rights reserved.--%>

<%--  @author Sunilkumar Prabhakar --%>




<%@ include file="init.jsp"%>

<%
	SearchContainer searchContainer = (SearchContainer) request
			.getAttribute("liferay-ui:search:searchContainer");

ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

TTDPSubProcessCustomerMap tTDPSubProcessCustomerMap = (TTDPSubProcessCustomerMap) row.getObject();
long tTDPSubProcessId = tTDPSubProcessCustomerMap.getTTDPSubProcessId();
TTDPSubProcessMap tTDPSubProcessMap = TTDPSubProcessMapLocalServiceUtil.getTTDPSubProcessMap(tTDPSubProcessId);

long subProcessId = tTDPSubProcessMap.getSubProcessId();

long organizationId = tTDPSubProcessCustomerMap.getOrganizationId();
long towerCustomerId = ParamUtil.getLong(renderRequest,	"towerCustomerId", 0);
long tTechnologyCustomerId = ParamUtil.getLong(renderRequest,	"tTechnologyCustomerId", 0);
long tTDeliverableCustomerId = ParamUtil.getLong(renderRequest,	"tTDeliverableCustomerId", 0);
long tTDProcessCustomerId = ParamUtil.getLong(renderRequest,	"tTDProcessCustomerId", 0);

Organization project = null;

try {
	project = OrganizationLocalServiceUtil.getOrganization(organizationId);
} catch (Exception e) {
log("IPAC : Error while fetching project for project id "
		+ organizationId, e);
}

int subProcessStatus = SubProcessLocalServiceUtil.getSubProcess(subProcessId).getStatusId();

if(!ArrayUtil.contains(SPStatus.DISABLED_STATUSES,subProcessStatus))
{

%>

<liferay-ui:icon-menu>
<%
if (ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project))
{

%>
<portlet:renderURL var="editSubProcessURL">
	<portlet:param name="mvcPath" value="/html/customercatalogmanagement/editSubProcessMap.jsp" />
	<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
	<portlet:param name="tTechnologyCustomerId"	value="<%=String.valueOf(tTechnologyCustomerId)%>" />
	<portlet:param name="tTDeliverableCustomerId"	value="<%=String.valueOf(tTDeliverableCustomerId)%>" />
	<portlet:param name="tTDProcessCustomerId"	value="<%=String.valueOf(tTDProcessCustomerId)%>" />
	<portlet:param name="tTDPSubProcessCustomerId"	value="<%=String.valueOf(tTDPSubProcessCustomerMap.getTTDPSubProcessCustomerId())%>" />
</portlet:renderURL>

<liferay-ui:icon image="edit" url="<%=editSubProcessURL%>" label="true" message="edit" />
<%
}

if ( ProjectCatalogPermission.isProjectCatalogViewer(themeDisplay, project))
{
%>
	
<portlet:renderURL var="manageTaskURL">
	<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageTask.jsp" />
		<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
		<portlet:param name="tTechnologyCustomerId"	value="<%=String.valueOf(tTechnologyCustomerId)%>" />
		<portlet:param name="tTDeliverableCustomerId"	value="<%=String.valueOf(tTDeliverableCustomerId)%>" />
		<portlet:param name="tTDProcessCustomerId"	value="<%=String.valueOf(tTDProcessCustomerId)%>" />
		<portlet:param name="tTDPSubProcessCustomerId"	value="<%=String.valueOf(tTDPSubProcessCustomerMap.getTTDPSubProcessCustomerId())%>" />
</portlet:renderURL>

<liferay-ui:icon image="configuration" url="<%=manageTaskURL%>" label="true" message="manage-task" />
	<%
		if(project.getType().equalsIgnoreCase(CustomerConstants.TYPE_PROJECT))
		{
	%>
<portlet:renderURL var="viewTreeURL">
		<portlet:param name="mvcPath" value="/html/customercatalogmanagement/treeView.jsp"/>
		<portlet:param name="customerId" value="<%=String.valueOf(project.getParentOrganizationId())%>"/>
		<portlet:param name="projectId" value="<%=String.valueOf(project.getOrganizationId())%>"/>
		<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId) %>"/>
		<portlet:param name="tTechnologyCustomerMapId"	value="<%=String.valueOf(tTechnologyCustomerId)%>" />
		<portlet:param name="tTDeliverableCustomerMapId"	value="<%=String.valueOf(tTDeliverableCustomerId)%>" />
		<portlet:param name="tTDProcessCustomerMapId"	value="<%=String.valueOf(tTDProcessCustomerId)%>" />
		<portlet:param name="tTDPSubProcessCustomerMapId"	value="<%=String.valueOf(tTDPSubProcessCustomerMap.getTTDPSubProcessCustomerId())%>" />
</portlet:renderURL>
	
<liferay-ui:icon iconCssClass="icon-cog" url="<%=viewTreeURL %>" label="true" message="view-catalog-tree" />

	<%
		}
}		
if (TTDPSubProcessCustomerMapPermissions.isPermissionAdmin(themeDisplay,tTDPSubProcessCustomerMap.getTTDPSubProcessCustomerId()))
{
		int[] roleTyes = { RoleConstants.TYPE_ORGANIZATION };
	%>

<liferay-security:permissionsURL
	resourceGroupId="<%=project.getGroupId() %>"
	modelResource="<%=TTDPSubProcessCustomerMap.class.getName()%>"
	modelResourceDescription="<%=tTDPSubProcessCustomerMap.getName(themeDisplay.getLocale())%>"
	resourcePrimKey="<%=String.valueOf(tTDPSubProcessCustomerMap.getTTDPSubProcessCustomerId())%>"
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