<%-- Copyright (c) 2016 lti. All rights reserved.--%>

<%--  @author Sunilkumar Prabhakar --%>




<%@ include file="init.jsp"%>

<%
	SearchContainer searchContainer = (SearchContainer) request
			.getAttribute("liferay-ui:search:searchContainer");

ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

TTDProcessCustomerMap tTDProcessCustomerMap = (TTDProcessCustomerMap) row.getObject();
TTDProcessMap tTDProcessMap = TTDProcessMapLocalServiceUtil.getTTDProcessMap(tTDProcessCustomerMap.getTTDProcessId());


long towerCustomerId = ParamUtil.getLong(renderRequest,	"towerCustomerId", 0);
long tTechnologyCustomerId = ParamUtil.getLong(renderRequest,	"tTechnologyCustomerId", 0);
long tTDeliverableCustomerId = ParamUtil.getLong(renderRequest,	"tTDeliverableCustomerId", 0);


Organization project = null;

try {
	project = OrganizationLocalServiceUtil.getOrganization(tTDProcessCustomerMap.getOrganizationId());
} catch (Exception e) {
log("IPAC : Error while fetching project for project id "
		+ tTDProcessCustomerMap.getOrganizationId(), e);
}

int processStatus = ProcessLocalServiceUtil.getProcess(tTDProcessMap.getProcessId()).getStatusId();
		
if(!ArrayUtil.contains(SPStatus.DISABLED_STATUSES, processStatus))
{

%>

<liferay-ui:icon-menu>

<%
if ( ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project) )
{

%>

<portlet:renderURL var="editProcessURL">
	<portlet:param name="mvcPath" value="/html/customercatalogmanagement/editProcessMap.jsp" />
	<portlet:param name="organizationId" value="<%=String.valueOf(project.getOrganizationId())%>" />
	<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
	<portlet:param name="tTechnologyCustomerId"	value="<%=String.valueOf(tTechnologyCustomerId)%>" />
	<portlet:param name="tTDeliverableCustomerId"	value="<%=String.valueOf(tTDeliverableCustomerId)%>" />
	<portlet:param name="tTDProcessCustomerId"	value="<%=String.valueOf(tTDProcessCustomerMap.getTTDProcessCustomerId())%>" />
</portlet:renderURL>

<liferay-ui:icon image="edit" url="<%=editProcessURL%>" label="true" message="edit" />
<%
}

if (ProjectCatalogPermission.isProjectCatalogViewer(themeDisplay, project))
{
%>
	
<portlet:renderURL var="manageSubProcessURL">
	<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageSubProcess.jsp" />
		<portlet:param name="organizationId" value="<%=String.valueOf(project.getOrganizationId())%>" />
		<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
		<portlet:param name="tTechnologyCustomerId"	value="<%=String.valueOf(tTechnologyCustomerId)%>" />
		<portlet:param name="tTDeliverableCustomerId"	value="<%=String.valueOf(tTDeliverableCustomerId)%>" />
		<portlet:param name="tTDProcessCustomerId"	value="<%=String.valueOf(tTDProcessCustomerMap.getTTDProcessCustomerId())%>" />
</portlet:renderURL>

<liferay-ui:icon image="configuration" url="<%=manageSubProcessURL%>" label="true" message="manage-sub-process" />	
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
		<portlet:param name="tTDProcessCustomerMapId"	value="<%=String.valueOf(tTDProcessCustomerMap.getTTDProcessCustomerId())%>" />
</portlet:renderURL>
	
<liferay-ui:icon iconCssClass="icon-cog" url="<%=viewTreeURL %>" label="true" message="view-catalog-tree" />
		
<%
		}
}

if (TTDProcessCustomerMapPermissions.isPermissionAdmin(themeDisplay,tTDProcessCustomerMap.getTTDProcessCustomerId()))
	{	
		int[] roleTyes = { RoleConstants.TYPE_ORGANIZATION };
%>

<liferay-security:permissionsURL
	resourceGroupId="<%=project.getGroupId() %>"
	modelResource="<%=TTDProcessCustomerMap.class.getName()%>"
	modelResourceDescription="<%=tTDProcessCustomerMap.getName(themeDisplay.getLocale())%>"
	resourcePrimKey="<%=String.valueOf(tTDProcessCustomerMap.getTTDProcessCustomerId())%>"
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