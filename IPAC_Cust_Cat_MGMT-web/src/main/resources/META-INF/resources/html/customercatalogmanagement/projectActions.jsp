<%-- Copyright (c) 2015 lti. All rights reserved.--%>

<%--  @author Sunilkumar Prabhakar --%>


<%@ include file="init.jsp"%>

<%
	SearchContainer searchContainer = (SearchContainer) request
			.getAttribute("liferay-ui:search:searchContainer");

	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Organization project = (Organization) row.getObject();
%>          

<liferay-ui:icon-menu>
	<portlet:renderURL var="manageScopeURL">
		<portlet:param name="mvcPath"
			value="/html/customercatalogmanagement/manageTower.jsp" />
		<portlet:param name="organizationId"
			value="<%=String.valueOf(project.getOrganizationId())%>" />
	</portlet:renderURL>

	<liferay-ui:icon image="configuration" url="<%=manageScopeURL%>" message="manage-tower" />
	<portlet:renderURL var="viewTreeURL">
		<portlet:param name="mvcPath" value="/html/customercatalogmanagement/treeView.jsp"/>
		<portlet:param name="customerId" value="<%=String.valueOf(project.getParentOrganizationId())%>"/>
		<portlet:param name="projectId" value="<%=String.valueOf(project.getOrganizationId())%>"/>
	</portlet:renderURL>
	
	<liferay-ui:icon iconCssClass="icon-cog" url="<%=viewTreeURL %>" label="true" message="view-catalog-tree" />
	
</liferay-ui:icon-menu>