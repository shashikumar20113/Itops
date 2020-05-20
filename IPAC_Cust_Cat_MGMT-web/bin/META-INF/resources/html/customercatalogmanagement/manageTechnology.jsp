<%-- Copyright (c) 2016 lti. All rights reserved.--%>

<%--  @author Sunilkumar Prabhakar, Raj Kumar Kulasekaran --%>



<%@ include file="init.jsp"%>

<%
	TowerCustomerMap towerCustomer = null;

	long towerCustomerId = ParamUtil.getLong(renderRequest,"towerCustomerId", 0);
	try {
		towerCustomer = TowerCustomerMapLocalServiceUtil
				.getTowerCustomerMap(towerCustomerId);
	} catch (Exception e) {
		log("IPAC : Error while fetching tower customer map for towerCustomer Map id "+ towerCustomerId, e);
	}

	
	
	
	if (towerCustomer == null) {
		SessionErrors.add(renderRequest, NoSuchTowerCustomerMapException.class);
%>


<liferay-ui:error exception="<%=NoSuchTowerCustomerMapException.class%>"
message="invalid-towerCustomerMap" />
<aui:button icon="left-arrow" href="<%=homeURL%>" value="back"></aui:button>
<%
	} else {
		long towerId=towerCustomer.getTowerId();
		long organizationId= towerCustomer.getOrganizationId();

		Organization project = null;
		
		try {
			project = OrganizationLocalServiceUtil.getOrganization(towerCustomer.getOrganizationId());
		} catch (Exception e) {
		log("IPAC : Error while fetching project for project id "
				+ towerCustomer.getOrganizationId(), e);
		}
		
		if(ProjectCatalogPermission.isProjectCatalogViewer(themeDisplay, project))
		{
			String tab = ParamUtil.getString(request, "tab", "current");
			PortletURL iteratorURL = renderResponse.createRenderURL();
			iteratorURL.setParameter("tab", tab);
			iteratorURL.setParameter("towerCustomerId",String.valueOf(towerCustomer.getTowerCustomerId()));
			iteratorURL.setParameter("mvcPath",	"/html/customercatalogmanagement/manageTechnology.jsp");
		
			List<TTechnologyCustomerMap> towerTechnologyCustomerMaps = new ArrayList<TTechnologyCustomerMap>();
			HashMap<Long,Technology> curtechnologiesHashMap =new  HashMap<Long,Technology>();
			HashMap<Long, TowerTechnologyMap> towerTechnologyHashMap = new HashMap<Long, TowerTechnologyMap>();
			int towerTechnologyCustomerMapCount = 0;
			List<Long> curTowerTechnologyIds = new ArrayList<Long>();
			List<Long> curTechnologyIds = new ArrayList<Long>();
			
			List<TowerTechnologyMap> towerTechnologyMaps = TowerTechnologyMapLocalServiceUtil
					.findActiveByTowerId(towerId);
			
			List<Long> towerTechnologyIds = new ArrayList<Long>();
			for(TowerTechnologyMap towerTechnologyMap : towerTechnologyMaps){
				towerTechnologyIds.add(towerTechnologyMap.getTowerTechnologyId());
			}
	
			if(towerTechnologyIds != null && !towerTechnologyIds.isEmpty() )
			{
				towerTechnologyCustomerMaps = TTechnologyCustomerMapLocalServiceUtil
					.getActiveTTechnologyCustomerMapByorganizationId(organizationId, towerTechnologyIds);
				towerTechnologyCustomerMapCount = towerTechnologyCustomerMaps.size();
		
				if( towerTechnologyCustomerMaps != null && !towerTechnologyCustomerMaps.isEmpty() )
				{
					curTowerTechnologyIds=new ArrayList<Long>();
					for(TTechnologyCustomerMap towerTechnologyCustomerMap:towerTechnologyCustomerMaps)
					{
						curTowerTechnologyIds.add(towerTechnologyCustomerMap.getTowerTechnologyId());
					}
					
			
					List<TowerTechnologyMap> curtowerTechnologyMaps= TowerTechnologyMapLocalServiceUtil
							.findActiveTowerTechnologMap(towerId, curTowerTechnologyIds);
				
					curTechnologyIds=new ArrayList<Long>();
					towerTechnologyHashMap = new HashMap<Long, TowerTechnologyMap>();
					for(TowerTechnologyMap towerTechnologyMap:curtowerTechnologyMaps)
					{
						curTechnologyIds.add(towerTechnologyMap.getTechnologyId());
						towerTechnologyHashMap.put(towerTechnologyMap.getTowerTechnologyId(), towerTechnologyMap);
					}
				
					List<Technology> curtechnologiesMap= TechnologyLocalServiceUtil
							.findByTechnologyIdsList(curTechnologyIds);
						
					curtechnologiesHashMap = new HashMap<Long,Technology>();
					for(Technology technology : curtechnologiesMap)
					{
					curtechnologiesHashMap.put(technology.getTechnologyId(), technology);
					}
				
				}
			}
			
			if(!project.getType().equalsIgnoreCase(CustomerConstants.TYPE_COMPANY))
			{
			
%>



		
		 <portlet:renderURL var="projectURL">
			<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageTower.jsp"/>
			<portlet:param name="organizationId" value="<%=String.valueOf(organizationId) %>"/>
		</portlet:renderURL>



  	  	<portlet:renderURL var="customerURL">
			<portlet:param name="mvcPath" value="/html/customercatalogmanagement/viewProjects.jsp"/>
			<portlet:param name="organizationId" value="<%=String.valueOf(project.getParentOrganizationId()) %>"/>
		</portlet:renderURL>
  	<%
 		PortalUtil.addPortletBreadcrumbEntry(request, project.getParentOrganization().getName(),customerURL);
		PortalUtil.addPortletBreadcrumbEntry(request, project.getName(),projectURL);
			}
		PortalUtil.addPortletBreadcrumbEntry(request, towerCustomer.getName(themeDisplay.getLocale()),themeDisplay.getURLCurrent());
	
%>
	<portlet:renderURL var="backURL">
		<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageTower.jsp" />
		<portlet:param name="organizationId" value="<%=String.valueOf(towerCustomer.getOrganizationId())%>" />
	</portlet:renderURL>

	<liferay-ui:header backURL="<%=backURL%>" title="<%=LanguageUtil.format(request,\"map-technology-x-x\", new Object[]{project.getName(), towerCustomer.getName(themeDisplay.getLocale())})%>" cssClass="cust_header" />
	
	<portlet:actionURL name="updateTTechnologyCustomerMap" var="updateTechnoloyCustomerURL">
		<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageTechnology.jsp" />
		<portlet:param name="organizationId" value="<%=String.valueOf(towerCustomer.getOrganizationId())%>" />
		<portlet:param name="towerId" value="<%=String.valueOf(towerCustomer.getTowerId())%>" />
		<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomer.getTowerCustomerId())%>" />
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

<liferay-ui:tabs names="<%=tabNames%>" param="tab" url="<%=iteratorURL.toString()%>">
<liferay-ui:section>
	<liferay-ui:search-container emptyResultsMessage="no-technology-mapped"	iteratorURL="<%=iteratorURL %>" var="tTechnologyCustomerMapSearchContainer" total="<%=towerTechnologyCustomerMaps.size() %>">
		<liferay-ui:search-container-results 
			results="<%=ListUtil.subList(towerTechnologyCustomerMaps,tTechnologyCustomerMapSearchContainer.getStart(),tTechnologyCustomerMapSearchContainer.getEnd())%>" 
			
			/>
		<liferay-ui:search-container-row keyProperty="TTechnologyCustomerId"
			className="com.lti.itops.ipac.custcatmgmt.model.TTechnologyCustomerMap" modelVar="TTechnologyCustomerMap">
			<portlet:renderURL var="manageDeliverableURL">
		<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageDeliverable.jsp" />
			<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
			<portlet:param name="tTechnologyCustomerId" value="<%=String.valueOf(TTechnologyCustomerMap.getTTechnologyCustomerId())%>" />
	</portlet:renderURL>
				<liferay-ui:search-container-column-text name="name"  href="<%=manageDeliverableURL %>" property="name"/>
			<liferay-ui:search-container-column-text
				 name="technology-name"  cssClass="<%=ArrayUtil.contains(SPStatus.DISABLED_STATUSES, curtechnologiesHashMap.get(towerTechnologyHashMap.get(TTechnologyCustomerMap.getTowerTechnologyId()).getTechnologyId()).getStatusId())?\"disabled\":\"active\" %>"
				 value="<%=curtechnologiesHashMap.get(towerTechnologyHashMap.get(TTechnologyCustomerMap.getTowerTechnologyId()).getTechnologyId()).getName() %>" />
			<liferay-ui:search-container-column-text
				 name="tt-name"  value="<%=towerTechnologyHashMap.get(TTechnologyCustomerMap.getTowerTechnologyId()).getName(themeDisplay.getLocale()) %>" />		 
			<liferay-ui:search-container-column-jsp	path="/html/customercatalogmanagement/technologyActions.jsp" name="actions"/>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator	searchContainer="<%=tTechnologyCustomerMapSearchContainer%>" />
	</liferay-ui:search-container>
</liferay-ui:section>

<%
if(tab.equalsIgnoreCase("available") && ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project))
{

	List<TowerTechnologyMap> towerTechnologyCustomerNotMapped = TowerTechnologyMapLocalServiceUtil.findActiveTowerTechnologMapNotInTTIds(towerId, curTowerTechnologyIds);
		
	int towerTechnologyCustomerNotMappedCount = towerTechnologyCustomerNotMapped.size();
	
	List<Technology> technologiesNotMappedMap=TechnologyLocalServiceUtil
			.findActiveByCompanyIdandNotInTechnologyIdsList(themeDisplay.getCompanyId(), curTechnologyIds);
	
	
	//if(!technologiesNotMappedMap.isEmpty())
	//{
	
		HashMap<Long,Technology> technologiesNotMappedHashMap = new HashMap<Long,Technology>();
		for(Technology technology : technologiesNotMappedMap){
			technologiesNotMappedHashMap.put(technology.getTechnologyId(), technology);
			
		}
		
		
		List<TowerTechnologyMap> activeTowerTechnologyCustomerNotMapped=new ArrayList<TowerTechnologyMap>();
		for(TowerTechnologyMap tt:towerTechnologyCustomerNotMapped)
		{
			if(technologiesNotMappedHashMap.containsKey(tt.getTechnologyId()))
			{
				activeTowerTechnologyCustomerNotMapped.add(tt);
			}
		}
	
%>

<liferay-ui:section>
	<aui:form method="post" action="<%=updateTechnoloyCustomerURL %>" name="towerTechnologyMapForm"> 
		<aui:input name="addTechnologyMapIds" type="hidden" />
		<liferay-ui:search-container emptyResultsMessage="no-technology-available" delta="<%=activeTowerTechnologyCustomerNotMapped.size() %>" var="tTechnologySearchContainer" rowChecker="<%= new RowChecker(renderResponse) %>">
			<liferay-ui:search-container-results 
				results="<%=ListUtil.subList(activeTowerTechnologyCustomerNotMapped,tTechnologySearchContainer.getStart(),tTechnologySearchContainer.getEnd())%>"
				
				/>
			
			<liferay-ui:search-container-row keyProperty="towerTechnologyId" className="com.lti.itops.ipac.spmgmt.model.TowerTechnologyMap" modelVar="towerTechnologyMap">
				<liferay-ui:search-container-column-text 
				 name="name" property="name"/>
				 <liferay-ui:search-container-column-text 
				 name="technology-name" value="<%=technologiesNotMappedHashMap.get(towerTechnologyMap.getTechnologyId()).getName() %>"/>
			</liferay-ui:search-container-row>
	
<%
		String taglibOnClick = renderResponse.getNamespace() + "updateTechnologyCustomerMap();";
		if(towerTechnologyCustomerNotMappedCount > 0)
		{
%>
		<aui:button-row>
			<aui:button type="submit" onClick="<%=taglibOnClick %>"	value="update-mapping" />
		</aui:button-row>
<%
		}
%>
				<liferay-ui:search-iterator searchContainer="<%=tTechnologySearchContainer%>" paginate="false"></liferay-ui:search-iterator>
		</liferay-ui:search-container>
	</aui:form>
</liferay-ui:section>
<%
}
//}
%>
</liferay-ui:tabs>
	
<aui:script>
	Liferay.provide(
		window,
		'<portlet:namespace />updateTechnologyCustomerMap',
		function() {	
			document.<portlet:namespace />towerTechnologyMapForm.<portlet:namespace />addTechnologyMapIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />towerTechnologyMapForm, '<portlet:namespace />allRowIds');
			submitForm(document.<portlet:namespace />towerTechnologyMapForm);
		},
		['liferay-util-list-fields']
	);
</aui:script>

<%
	} else {
		SessionErrors.add(renderRequest, PrincipalException.class);
%>
<liferay-ui:error exception="<%=PrincipalException.class%>"
	message="permission-denied" />
<aui:button icon="left-arrow" href="<%=homeURL%>" value="back"></aui:button>

<%
	}
	}
%>