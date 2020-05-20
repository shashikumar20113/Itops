<%-- Copyright (c) 2016 lti. All rights reserved.--%>

<%--  @author Sunilkumar Prabhakar, Raj Kumar Kulasekaran --%>


<%@page import="com.lti.itops.ipac.custcatmgmt.permission.CatalogPermission"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.permission.CatalogActionKeys"%>
<%@ include file="init.jsp"%>
<%
if(companyOrg==null)  
    {
    	SessionErrors.add(renderRequest,
    			NoSuchOrganizationException.class);
   %>
    <liferay-ui:error exception="<%=NoSuchOrganizationException.class%>"
	message="settings-not-found" />
   <%
    }else{
	List<Organization> customers = new ArrayList<Organization>();

if (permissionChecker.hasPermission(
		companyOrg.getGroupId(), Organization.class.getName(),
		companyOrgID,
		CatalogActionKeys.VIEW_SCOPE ) || permissionChecker.hasPermission(
				companyOrg.getGroupId(), Organization.class.getName(),
				companyOrgID,
				CatalogActionKeys.MANAGE_SCOPE )) {
	customers = OrganizationLocalServiceUtil.search(
			themeDisplay.getCompanyId(),
			companyOrgID,
			"", CustomerConstants.TYPE_CUSTOMER, null, null, null,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS);
} else {
		
		customers = CustomerCatalogUtil.getUserCustomers(themeDisplay);
}

%>
 
<liferay-ui:breadcrumb showCurrentGroup="<%= false %>" showGuestGroup="<%= false %>" showLayout="<%= false %>" showParentGroups="<%= false %>" showPortletBreadcrumb="<%= true %>"  />
<liferay-ui:header	title="<%=LanguageUtil.get(request,\"customer-catalog\")%>" cssClass="cust_header"/>


<!-- For Tool Bar -->
	
<%

	if(CatalogPermission.isCompanyCompleteViewer(themeDisplay, companyOrg)) {

%>

		<aui:nav-bar markupView="lexicon">
			
			<aui:nav cssClass="navbar-nav">
			
				<portlet:renderURL var="treeViewURL">
				
					<portlet:param name="mvcPath" value="/html/customercatalogmanagement/treeView.jsp" />
			
				</portlet:renderURL>
				
				<aui:nav-item iconCssClass="icon-cog" label="view-tree-map" href="<%=treeViewURL %>"/>
				<portlet:renderURL var="manageCompanyScopeURL">
		<portlet:param name="mvcPath"
			value="/html/customercatalogmanagement/manageTower.jsp" />
		<portlet:param name="organizationId"
			value="<%=String.valueOf(companyOrgID)%>" />
	</portlet:renderURL>
				
				<aui:nav-item iconCssClass="icon-cog" label="<%=LanguageUtil.format(request, \"compscope-x\", companyOrg.getName()) %>" href="<%=manageCompanyScopeURL %>"/>
			
			</aui:nav>
			
		</aui:nav-bar>

<%
	
	}



	PortletURL iteratorURL = renderResponse.createRenderURL(); 
	iteratorURL.setParameter("mvcPath","/html/customercatalogmanagement/view.jsp");

%>

<liferay-ui:search-container emptyResultsMessage="no-customers-found" orderByCol="name" var="catalogSearchContainer"  delta="10" iteratorURL="<%=iteratorURL %>">

	<liferay-ui:search-container-results results="<%=ListUtil.subList(customers, catalogSearchContainer.getStart(), catalogSearchContainer.getEnd())%>"/>
	<liferay-ui:search-container-row className="com.liferay.portal.kernel.model.Organization" modelVar="customer">
			<%
			String logoImage = "<img src=\"/image/organization_logo?img_id="+ customer.getLogoId() + "\"/>";
			%>
			<portlet:renderURL var="viewCustomerURL">
		<portlet:param name="mvcPath" value="/html/customercatalogmanagement/viewProjects.jsp" />
		<portlet:param name="organizationId" value="<%=String.valueOf(customer.getOrganizationId())%>" />
	</portlet:renderURL>
	
		<liferay-ui:search-container-column-text value="<%=logoImage%>"	name="logo" cssClass="logo_col"/>
		<liferay-ui:search-container-column-text property="name" name="customer-name" value="<%=customer.getName()%>" href="<%=viewCustomerURL %>"/>
		<liferay-ui:search-container-column-jsp path="/html/customercatalogmanagement/customerActions.jsp" name="actions"/>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator paginate="true" searchContainer="<%=catalogSearchContainer%>"/>
</liferay-ui:search-container>
<%
}%>