<%-- Copyright (c) 2016 lti. All rights reserved.--%>

<%--  @author Sunilkumar Prabhakar, Raj Kumar Kulasekaran --%>


<%@ include file="init.jsp"%>
<%
	List<Organization> projects = new ArrayList<Organization>();

	Organization customer = null;
	
	long organizationId = ParamUtil.getLong(renderRequest,
			"organizationId", 0);
	
	
	 try {
		customer = OrganizationLocalServiceUtil.getOrganization(organizationId);
	} catch (Exception e) {
		log("IPAC : Error while fetching customer for customer id "+ organizationId, e);
	}
if (customer == null) {
	SessionErrors.add(renderRequest,NoSuchOrganizationException.class); 
%>
 <liferay-ui:error exception="<%=NoSuchOrganizationException.class%>" message="invalid-customer" />
<aui:button icon="left-arrow" href="<%=homeURL%>" value="back"></aui:button>
<%
} else {
	
	if (CatalogPermission.isCustomerCompleteViewer(themeDisplay, customer)) {
		
		 DynamicQuery dq=DynamicQueryFactoryUtil.forClass(Organization.class);
		 
		dq.add(PropertyFactoryUtil.forName("parentOrganizationId").eq(customer.getOrganizationId()));
		
		dq.add(PropertyFactoryUtil.forName("type").eq(CustomerConstants.TYPE_PROJECT));
		
		dq.add(PropertyFactoryUtil.forName("companyId").eq(themeDisplay.getCompanyId()));
		
		dq.add(PropertyFactoryUtil.forName("statusId").ne(Long.valueOf(CustomerConstants.ORG_DEACTIVATE_STATUS)));
		
		projects = OrganizationLocalServiceUtil.dynamicQuery(dq); 
		
	}else{
		
		projects = CustomerCatalogUtil.getUserCustomerProjects(themeDisplay, organizationId);
	
	}
	
	PortalUtil.addPortletBreadcrumbEntry(request, customer.getName(),themeDisplay.getURLCurrent());
	
	PortletURL iteratorURL=renderResponse.createRenderURL();
	iteratorURL.setParameter("mvcPath", "/html/customercatalogmanagement/viewProjects.jsp");
	iteratorURL.setParameter("organizationId",String.valueOf( organizationId));
	
%>
<liferay-ui:header backURL="<%=homeURL%>" title="<%=LanguageUtil.format(request,\"projects-x\", customer.getName())%>" cssClass="cust_header"/>
<liferay-ui:error exception="<%=PrincipalException.class%>"	message="permission-denied" />

<liferay-ui:search-container emptyResultsMessage="no-projects-found" orderByCol="name" var="projectSearchContainer"  delta="10" iteratorURL="<%=iteratorURL%>">
	<liferay-ui:search-container-results results="<%=ListUtil.subList(projects,projectSearchContainer.getStart(), projectSearchContainer.getEnd())%>"></liferay-ui:search-container-results>
		<liferay-ui:search-container-row className="com.liferay.portal.kernel.model.Organization" modelVar="project">
		<%
			String logoImage = "<img src=\"/image/organization_logo?img_id=" + project.getLogoId() + "\"/>";
		%>
		<portlet:renderURL var="manageScopeURL">
		<portlet:param name="mvcPath"
			value="/html/customercatalogmanagement/manageTower.jsp" />
		<portlet:param name="organizationId"
			value="<%=String.valueOf(project.getOrganizationId())%>" />
	</portlet:renderURL>
		<liferay-ui:search-container-column-text value="<%=logoImage%>" cssClass="logo_col"	name="logo"/>
		<liferay-ui:search-container-column-text property="name" value="<%=project.getName()%>" href="<%=manageScopeURL %>"/>
		<liferay-ui:search-container-column-jsp	path="/html/customercatalogmanagement/projectActions.jsp" name="actions"/>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator paginate="true" searchContainer="<%=projectSearchContainer%>"></liferay-ui:search-iterator>
</liferay-ui:search-container>
<%
}
%>