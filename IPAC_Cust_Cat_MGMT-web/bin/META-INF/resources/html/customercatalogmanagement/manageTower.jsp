<%-- Copyright (c) 2016 lti. All rights reserved.--%>

<%--  @author Sunilkumar Prabhakar, Raj Kumar Kulasekaran --%>




<%@ include file="init.jsp"%>

<%
	Organization project = null;
	long organizationId = ParamUtil.getLong(renderRequest,
			"organizationId", 0);

	try {
		project = OrganizationLocalServiceUtil
				.getOrganization(organizationId);
	} catch (Exception e) {
		log("IPAC : Error while fetching project for organization id "	+ organizationId, e);
				e.printStackTrace();
	}
	if (project == null) {
		SessionErrors.add(renderRequest, NoSuchOrganizationException.class);
%>
	<liferay-ui:error exception="<%=NoSuchOrganizationException.class%>" message="invalid-project" />
	<aui:button icon="left-arrow" href="<%=homeURL%>" value="back"></aui:button>
<%
	} else {
		if(ProjectCatalogPermission.isProjectCatalogViewer(themeDisplay, project))
		{

				String tab = ParamUtil.getString(request, "tab", "current");
				PortletURL iteratorURL = renderResponse.createRenderURL();
				iteratorURL.setParameter("tab", tab);
				iteratorURL.setParameter("organizationId",String.valueOf(project.getOrganizationId()));
				iteratorURL.setParameter("mvcPath",	"/html/customercatalogmanagement/manageTower.jsp");
				
				HashMap<Long,Tower> towersHashMap = new HashMap<Long,Tower>();
				List<TowerCustomerMap> towerCustomerMaps = new ArrayList<TowerCustomerMap>();
				List<Tower> towersMap = new ArrayList<Tower>();
				List<Long> towerIds = new ArrayList<Long>();
				
			
				towerCustomerMaps = TowerCustomerMapLocalServiceUtil
						.findActiveTowerCustomerMapByOrganizationId(organizationId);
				
				int towerCustomerCount= towerCustomerMaps.size();
				
				if(!towerCustomerMaps.isEmpty())
				{
	
					for (TowerCustomerMap towerCustomerMap : towerCustomerMaps) 
					{
						towerIds.add(towerCustomerMap.getTowerId());
					}
					
					towersMap = TowerLocalServiceUtil.findTowerIdByTowerIdList(towerIds);
					for(Tower tower : towersMap){
						towersHashMap.put(tower.getTowerId(), tower);
					}
				}
				

	
%>



<%
//Breadcrum for the Page

 	if(project.getType().equalsIgnoreCase(CustomerConstants.TYPE_PROJECT))
	{
 		
 	 %>
  	  	<portlet:renderURL var="customerURL">
			<portlet:param name="mvcPath" value="/html/customercatalogmanagement/viewProjects.jsp"/>
			<portlet:param name="organizationId" value="<%=String.valueOf(project.getParentOrganizationId()) %>"/>
		</portlet:renderURL>
  	<%
  		
		PortalUtil.addPortletBreadcrumbEntry(request, project.getParentOrganization().getName(),customerURL);
	}
	PortalUtil.addPortletBreadcrumbEntry(request, project.getName(),themeDisplay.getURLCurrent());
%>


<portlet:renderURL var="backURL">
	<%
		if(project.getType().equalsIgnoreCase(CustomerConstants.TYPE_PROJECT))
		{
	%>
	<portlet:param name="mvcPath" value="/html/customercatalogmanagement/viewProjects.jsp" />
	<portlet:param name="organizationId" value="<%=String.valueOf(project.getParentOrganizationId())%>" />
	<%
		}
	%>
</portlet:renderURL>

<liferay-ui:header backURL="<%=backURL%>"
	title="<%=LanguageUtil.format(request,\"map-tower-x\", project.getName())%>" cssClass="cust_header"/>
	
<portlet:actionURL name="updateTowerCustomerMap" var="updateTowerCustomerURL">
	<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageTower.jsp" />
		<portlet:param name="organizationId" value="<%=String.valueOf(organizationId)%>" />
</portlet:actionURL>
<%
String tabNames = null;
if(ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project))
{
tabNames = "current,available";
}else{
tabNames = "current";
}
%>

<liferay-ui:tabs names="<%=tabNames%>" param="tab" url="<%=iteratorURL.toString() %>">
	<liferay-ui:section>
		<liferay-ui:search-container emptyResultsMessage="no-towers-mapped" iteratorURL="<%=iteratorURL %>" var="towerCustomerSearchContainer" delta="10" total="<%=towerCustomerMaps.size() %>" >
		<liferay-ui:search-container-results 
			results="<%=ListUtil.subList(towerCustomerMaps, towerCustomerSearchContainer.getStart(), towerCustomerSearchContainer.getEnd())%>" 
			/>
		<liferay-ui:search-container-row keyProperty="towerCustomerId" className="com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap" modelVar="towerCustomerMap">
			<portlet:renderURL var="manageTechnologyURL">
		<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageTechnology.jsp" />
			<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerMap.getTowerCustomerId())%>" />
	</portlet:renderURL>
						<liferay-ui:search-container-column-text property="name" href="<%=manageTechnologyURL %>"/>
				<liferay-ui:search-container-column-text name="tower-name" value="<%=towersHashMap.get(towerCustomerMap.getTowerId()).getName() %>"  cssClass="<%=ArrayUtil.contains(SPStatus.DISABLED_STATUSES, towersHashMap.get(towerCustomerMap.getTowerId()).getStatusId())?\"disabled\":\"active\" %>"/>
			<liferay-ui:search-container-column-jsp	path="/html/customercatalogmanagement/towerActions.jsp"	name="actions"/>
		</liferay-ui:search-container-row>
			<liferay-ui:search-iterator	searchContainer="<%=towerCustomerSearchContainer%>" paginate="true"/></liferay-ui:search-container>
	</liferay-ui:section>
<%	
if(tab.equalsIgnoreCase("available") && ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project)){
	List<Tower> towerList = TowerLocalServiceUtil.findActiveByCompanyIdandNotInTowerIds(themeDisplay.getCompanyId(), towerIds);
	int towerCount = towerList.size();
%>	
	
	<liferay-ui:section>
		<aui:form action="<%=updateTowerCustomerURL%>" method="post" name="towerCustForm">
			<aui:input name="organizationId" type="hidden"	value="<%=project.getOrganizationId()%>" />
			<aui:input name="addTowerMapIds" type="hidden" />
				<liferay-ui:search-container emptyResultsMessage="no-towers-available" delta="<%=towerCount %>" var="towerSearchContainer" rowChecker="<%= new RowChecker(renderResponse)%>">
				<liferay-ui:search-container-results
					 results="<%= ListUtil.subList(towerList, towerSearchContainer.getStart(), towerSearchContainer.getEnd())%>" 
					/>
				<liferay-ui:search-container-row  keyProperty="towerId" className="com.lti.itops.ipac.spmgmt.model.Tower" modelVar="tower">
					<liferay-ui:search-container-column-text name="tower-name"	value="<%=tower.getName() %>"/>
				</liferay-ui:search-container-row>
<%
		String taglibOnClick = renderResponse.getNamespace() + "updateTowerCustomerMap();";
		if(towerCount > 0)
		{
%>
		<aui:button-row>
			<aui:button type="submit" onClick="<%=taglibOnClick %>"	value="update-mapping" />
		</aui:button-row>
<%
		}
%>		
		<liferay-ui:search-iterator	searchContainer="<%=towerSearchContainer%>" paginate="false"/></liferay-ui:search-container>
		</aui:form>
</liferay-ui:section>
<%
}
%>
<aui:script>
	Liferay.provide(
		window,
		'<portlet:namespace />updateTowerCustomerMap',
		function() {	
			document.<portlet:namespace />towerCustForm.<portlet:namespace />addTowerMapIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />towerCustForm, '<portlet:namespace />allRowIds');
			submitForm(document.<portlet:namespace />towerCustForm);
		},
		['liferay-util-list-fields']
	);
</aui:script>
</liferay-ui:tabs>

<%
		}
		else
		{
			SessionErrors.add(renderRequest, PrincipalException.class);
			%>
			<liferay-ui:error exception="<%=PrincipalException.class%>"
				message="permission-denied" />
			<aui:button icon="left-arrow" href="<%=homeURL%>" value="back"></aui:button>

			<%
		}
	}
%>
`