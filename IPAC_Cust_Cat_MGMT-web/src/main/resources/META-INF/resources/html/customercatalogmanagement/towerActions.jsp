<%-- Copyright (c) 2016 lti. All rights reserved.--%>

<%--  @author Sunilkumar Prabhakar, Raj Kumar Kulasekaran --%>




<%@ include file="init.jsp"%>

<%
	SearchContainer searchContainer = (SearchContainer) request
	.getAttribute("liferay-ui:search:searchContainer");

	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	Organization project = null;

	TowerCustomerMap towerCustomerMap = (TowerCustomerMap) row.getObject();
	
	long towerId = towerCustomerMap.getTowerId();
	long organizationId = towerCustomerMap.getOrganizationId();
	

	try {
		project = OrganizationLocalServiceUtil.getOrganization(organizationId);
	} catch (Exception e) {
		log("IPAC : Error while fetching project for project id "	+ organizationId, e);
	}
	
	
	
	int towerStatus = TowerLocalServiceUtil.getTower(towerId).getStatusId();
				
	if(!ArrayUtil.contains(SPStatus.DISABLED_STATUSES,towerStatus))
	{			
	
%>

<liferay-ui:icon-menu>

<%
	if (ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project))
		{

%>

	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath"
			value="/html/customercatalogmanagement/editTowerMap.jsp" />
			<portlet:param name="towerCustomerId"
			value="<%=String.valueOf(towerCustomerMap.getTowerCustomerId())%>" />
	</portlet:renderURL>
	
	<liferay-ui:icon image="edit" url="<%=editURL%>" label="true" message="edit" />
	<%
		}
		if ( ProjectCatalogPermission.isProjectCatalogViewer(themeDisplay, project) )
		{
		%>
	
	
	<portlet:renderURL var="manageTechnologyURL">
		<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageTechnology.jsp" />
			<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerMap.getTowerCustomerId())%>" />
	</portlet:renderURL>
	
	<liferay-ui:icon image="configuration" url="<%=manageTechnologyURL%>" label="true" message="manage-technology" />
		<%
		if(project.getType().equalsIgnoreCase(CustomerConstants.TYPE_PROJECT))
		{
	%>
	<portlet:renderURL var="viewTreeURL">
		<portlet:param name="mvcPath" value="/html/customercatalogmanagement/treeView.jsp"/>
		<portlet:param name="customerId" value="<%=String.valueOf(project.getParentOrganizationId())%>"/>
		<portlet:param name="projectId" value="<%=String.valueOf(project.getOrganizationId())%>"/>
		<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerMap.getTowerCustomerId()) %>"/>
		<portlet:param name="towerId" value="<%=String.valueOf(towerCustomerMap.getTowerId()) %>"/>
	</portlet:renderURL>
	
	<liferay-ui:icon iconCssClass="icon-cog" url="<%=viewTreeURL %>" label="true" message="view-catalog-tree" />
	
	
<%}
	}	
		
	if (TowerCustomerMapPermissions.isPermissionAdmin(themeDisplay,towerCustomerMap.getTowerCustomerId()))
		{
			int[] roleTyes = { RoleConstants.TYPE_ORGANIZATION };
%>
	<liferay-security:permissionsURL
		resourceGroupId="<%=themeDisplay.getCompanyGroupId() %>"
		modelResource="<%=TowerCustomerMap.class.getName()%>"
		modelResourceDescription="<%=towerCustomerMap.getName()%>"
		resourcePrimKey="<%=String.valueOf(towerCustomerMap.getTowerCustomerId())%>"
		var="permissionURL"
		windowState="<%=LiferayWindowState.POP_UP.toString()%>"
		roleTypes="<%=roleTyes%>"></liferay-security:permissionsURL>
	<liferay-ui:icon image="lock" url="<%=permissionURL%>" label="true"
		message="permissions" useDialog="true" />
<%
		}
%>

</liferay-ui:icon-menu>
<%
	}
%>
