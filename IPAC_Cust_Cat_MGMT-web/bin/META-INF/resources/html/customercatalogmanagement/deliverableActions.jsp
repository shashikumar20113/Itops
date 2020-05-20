<%-- Copyright (c) 2016 lti. All rights reserved.--%>

<%--  @author Sunilkumar Prabhakar, Raj Kumar Kulasekaran --%>


 
 
<%@ include file="init.jsp"%>

<%
	SearchContainer searchContainer = (SearchContainer) request
			.getAttribute("liferay-ui:search:searchContainer");

ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
  
TTDeliverableCustomerMap tTDeliverableCustomerMap = (TTDeliverableCustomerMap) row.getObject();
long tTDeliverableId = tTDeliverableCustomerMap.getTTDeliverableId();
TTDeliverableMap tTDeliverableMap = TTDeliverableMapLocalServiceUtil.getTTDeliverableMap(tTDeliverableId);
   

long deliverableId = tTDeliverableMap.getDeliverableId();
long organizationId = tTDeliverableCustomerMap.getOrganizationId();
long towerCustomerId = ParamUtil.getLong(renderRequest,	"towerCustomerId", 0);
long tTechnologyCustomerId = ParamUtil.getLong(renderRequest,	"tTechnologyCustomerId", 0);

Organization project = null;

try {
	project = OrganizationLocalServiceUtil.getOrganization(organizationId);
} catch (Exception e) {
log("IPAC : Error while fetching project for project id "
		+ organizationId, e);
}


int deliverableStatus = DeliverableLocalServiceUtil.getDeliverable(deliverableId).getStatusId();
		
if( !ArrayUtil.contains(SPStatus.DISABLED_STATUSES,deliverableStatus))
{
		
		
%>

<liferay-ui:icon-menu>

<%
if ( ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project))
{

%>

<portlet:renderURL var="editDeliverableURL">
	<portlet:param name="mvcPath" value="/html/customercatalogmanagement/editDeliverableMap.jsp" />
	<portlet:param name="organizationId" value="<%=String.valueOf(project.getOrganizationId())%>" />
	<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
	<portlet:param name="tTechnologyCustomerId"	value="<%=String.valueOf(tTechnologyCustomerId)%>" />
	<portlet:param name="tTDeliverableCustomerId"	value="<%=String.valueOf(tTDeliverableCustomerMap.getTTDeliverableCustomerId())%>" />
</portlet:renderURL>

<liferay-ui:icon image="edit" url="<%=editDeliverableURL%>" label="true" message="edit" />
	
<%
}
if (ProjectCatalogPermission.isProjectCatalogViewer(themeDisplay, project))
{

%>	
<portlet:renderURL var="manageProcessURL">
	<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageProcess.jsp" />
		<portlet:param name="organizationId" value="<%=String.valueOf(project.getOrganizationId())%>" />
		<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
		<portlet:param name="tTechnologyCustomerId"	value="<%=String.valueOf(tTechnologyCustomerId)%>" />
		<portlet:param name="tTDeliverableCustomerId"	value="<%=String.valueOf(tTDeliverableCustomerMap.getTTDeliverableCustomerId())%>" />
</portlet:renderURL>

<liferay-ui:icon image="configuration" url="<%=manageProcessURL%>" label="true" message="manage-process"  />	
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
		<portlet:param name="tTDeliverableCustomerMapId"	value="<%=String.valueOf(tTDeliverableCustomerMap.getTTDeliverableCustomerId())%>" />
</portlet:renderURL>
	
<liferay-ui:icon iconCssClass="icon-cog" url="<%=viewTreeURL %>" label="true" message="view-catalog-tree" />
		
		

	<%
	}
}
	if (TTDeliverableCustomerMapPermissions
			.isPermissionAdmin(themeDisplay,tTDeliverableCustomerMap.getTTDeliverableCustomerId()))
	{
		int[] roleTyes = { RoleConstants.TYPE_ORGANIZATION };
	%>

<liferay-security:permissionsURL
	resourceGroupId="<%=project.getGroupId() %>"
	modelResource="<%=TTDeliverableCustomerMap.class.getName()%>"
	modelResourceDescription="<%=tTDeliverableCustomerMap.getName(themeDisplay.getLocale())%>"
	resourcePrimKey="<%=String.valueOf(tTDeliverableCustomerMap.getTTDeliverableCustomerId())%>"
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