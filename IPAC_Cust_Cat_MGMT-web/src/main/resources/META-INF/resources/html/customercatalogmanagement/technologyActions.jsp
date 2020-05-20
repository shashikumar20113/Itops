<%-- Copyright (c) 2016 lti. All rights reserved.--%>

<%--  @author Sunilkumar Prabhakar, Raj Kumar Kulasekaran --%>



<%@ include file="init.jsp"%>

<%
	SearchContainer searchContainer = (SearchContainer) request
			.getAttribute("liferay-ui:search:searchContainer");

	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	
	
	long towerCustomerId = ParamUtil.getLong(renderRequest,	"towerCustomerId", 0);
	TowerCustomerMap towerCustomMap=TowerCustomerMapLocalServiceUtil.getTowerCustomerMap(towerCustomerId);
	TTechnologyCustomerMap tTechnologyCustomerMap = (TTechnologyCustomerMap) row.getObject();
	long towerTechnologyId = tTechnologyCustomerMap.getTowerTechnologyId();
	TowerTechnologyMap towerTechnologyMap = TowerTechnologyMapLocalServiceUtil.getTowerTechnologyMap(towerTechnologyId);

	long technologyId = towerTechnologyMap.getTechnologyId();


	long organizationId=towerCustomMap.getOrganizationId();
	Organization project = null;
	
	try {
		project = OrganizationLocalServiceUtil.getOrganization(organizationId);
	} catch (Exception e) {
	log("IPAC : Error while fetching project for project id "
			+ organizationId, e);
	}
	
	int technologyStatus = TechnologyLocalServiceUtil.getTechnology(technologyId).getStatusId();
			
	if(!ArrayUtil.contains(SPStatus.DISABLED_STATUSES,technologyStatus ))
	{
	
%>

<liferay-ui:icon-menu>

		<%
		if (ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project))
		{
		%>

	<portlet:renderURL var="editTechnologyURL">
		<portlet:param name="mvcPath" value="/html/customercatalogmanagement/editTechnologyMap.jsp" />
		<portlet:param name="organizationId" value="<%=String.valueOf(project.getOrganizationId())%>" />
		<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
		<portlet:param name="tTechnologyCustomerId"	value="<%=String.valueOf(tTechnologyCustomerMap.getTTechnologyCustomerId())%>" />
	</portlet:renderURL>
	
	<liferay-ui:icon image="edit" url="<%=editTechnologyURL%>" label="true" message="edit" />
		<%
		}
		if (ProjectCatalogPermission.isProjectCatalogViewer(themeDisplay, project))
		{
		%>
		
	<portlet:renderURL var="manageDeliverableURL">
		<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageDeliverable.jsp" />
			<portlet:param name="organizationId" value="<%=String.valueOf(project.getOrganizationId())%>" />
			<portlet:param name="technologyId" value="<%=String.valueOf(towerTechnologyMap.getTechnologyId())%>" />
			<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
			<portlet:param name="towerTechnologyId" value="<%=String.valueOf(towerTechnologyMap.getTowerTechnologyId())%>" />
			<portlet:param name="tTechnologyCustomerId" value="<%=String.valueOf(tTechnologyCustomerMap.getTTechnologyCustomerId())%>" />
	</portlet:renderURL>
	
	<liferay-ui:icon image="configuration" url="<%=manageDeliverableURL%>" label="true" message="manage-deliverable" />	
			<%
		if(project.getType().equalsIgnoreCase(CustomerConstants.TYPE_PROJECT))
		{
	%>
	<portlet:renderURL var="viewTreeURL">
		<portlet:param name="mvcPath" value="/html/customercatalogmanagement/treeView.jsp"/>
		<portlet:param name="customerId" value="<%=String.valueOf(project.getParentOrganizationId())%>"/>
		<portlet:param name="projectId" value="<%=String.valueOf(project.getOrganizationId())%>"/>
		<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId) %>"/>
		<portlet:param name="tTechnologyCustomerMapId" value="<%=String.valueOf(tTechnologyCustomerMap.getTTechnologyCustomerId())%>" />
	</portlet:renderURL>
	
	<liferay-ui:icon iconCssClass="icon-cog" url="<%=viewTreeURL %>" label="true" message="view-catalog-tree" />
		
		
		<%
		}
		}
		if (TTechnologyCustomerMapPermissions.isPermissionAdmin(themeDisplay,tTechnologyCustomerMap.getTTechnologyCustomerId()))
		{
				int[] roleTyes = { RoleConstants.TYPE_ORGANIZATION };
		%>
	
	<liferay-security:permissionsURL
		resourceGroupId="<%=project.getGroupId() %>"
		modelResource="<%=TTechnologyCustomerMap.class.getName()%>"
		modelResourceDescription="<%=tTechnologyCustomerMap.getName(themeDisplay.getLocale())%>"
		resourcePrimKey="<%=String.valueOf(tTechnologyCustomerMap.getTTechnologyCustomerId())%>"
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