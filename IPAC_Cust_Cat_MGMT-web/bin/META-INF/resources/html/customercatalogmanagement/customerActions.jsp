<%-- Copyright (c) 2016 lti. All rights reserved.--%>

<%--  @author Sunilkumar Prabhakar,Raj Kumar Kulasekaran --%>
 
<%@page import="com.lti.itops.ipac.custcatmgmt.permission.CatalogPermission"%>
<%@ include file="init.jsp"%>

<% 
	SearchContainer searchContainer = (SearchContainer) request
			.getAttribute("liferay-ui:search:searchContainer");

	ResultRow  row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Organization customer = (Organization) row.getObject();
%>
 
<liferay-ui:icon-menu>

	<portlet:renderURL var="viewCustomerURL">
		<portlet:param name="mvcPath" value="/html/customercatalogmanagement/viewProjects.jsp" />
		<portlet:param name="organizationId" value="<%=String.valueOf(customer.getOrganizationId())%>" />
	</portlet:renderURL>
	
	<liferay-ui:icon image="view" url="<%=viewCustomerURL%>" label="true" message="view-projects" />
	<% 
	if (CatalogPermission.isCustomerCompleteViewer(themeDisplay, customer)) {
	%>
	<portlet:renderURL var="viewTreeURL">
		<portlet:param name="mvcPath" value="/html/customercatalogmanagement/treeView.jsp"/>
		<portlet:param name="customerId" value="<%=String.valueOf(customer.getOrganizationId())%>"/>
	</portlet:renderURL>
	
	<liferay-ui:icon iconCssClass="icon-cog" url="<%=viewTreeURL %>" label="true" message="view-catalog-tree" />
		<%
	}
		%>
</liferay-ui:icon-menu>