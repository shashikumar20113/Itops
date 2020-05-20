<%-- Copyright (c) 2016 lti. All rights reserved.--%>

<%--  @author Sunilkumar Prabhakar, Raj Kumar Kulasekaran --%>




<%@ include file="init.jsp"%>

<%
	TTechnologyCustomerMap tTechnologyCustomerMap = null;
	TowerCustomerMap towerCustomer=null;
	long towerCustomerId = ParamUtil.getLong(renderRequest,	"towerCustomerId", 0);
	long tTechnologyCustomerId = ParamUtil.getLong(renderRequest,"tTechnologyCustomerId", 0);
       
	try {
		towerCustomer = TowerCustomerMapLocalServiceUtil
				.getTowerCustomerMap(towerCustomerId);
	} catch (Exception e) {
		log("IPAC : Error while fetching tower customer map for towerCustomer Map id "+ towerCustomerId, e);
	}
	

	try {
		tTechnologyCustomerMap = TTechnologyCustomerMapLocalServiceUtil
				.getTTechnologyCustomerMap(tTechnologyCustomerId);
	} catch (Exception e) {
		log("IPAC : Error while fetching tt customer map for ttCustomer Map id "+ tTechnologyCustomerId, e);
	}


	if (tTechnologyCustomerMap == null) {
		SessionErrors.add(renderRequest, NoSuchTTechnologyCustomerMapException.class);
%>


<liferay-ui:error exception="<%=NoSuchTTechnologyCustomerMapException.class%>"
message="invalid-tTechnologyCustomerMap" />
<aui:button icon="left-arrow" href="<%=homeURL%>" value="home"></aui:button>
<%
	} else {
		
		Organization project = null;
		
		try {
			project = OrganizationLocalServiceUtil.getOrganization(tTechnologyCustomerMap.getOrganizationId());
		} catch (Exception e) {
		log("IPAC : Error while fetching project for project id "
				+ tTechnologyCustomerMap.getOrganizationId(), e);
		}
		

		if(ProjectCatalogPermission.isProjectCatalogViewer(themeDisplay, project) )
		{
			String tab = ParamUtil.getString(request, "tab", "current");
			PortletURL iteratorURL = renderResponse.createRenderURL();
			iteratorURL.setParameter("tab", tab);
			iteratorURL.setParameter("towerCustomerId",String.valueOf(towerCustomerId));
			iteratorURL.setParameter("tTechnologyCustomerId",String.valueOf(tTechnologyCustomerMap.getTTechnologyCustomerId()));
			iteratorURL.setParameter("mvcPath",	"/html/customercatalogmanagement/manageDeliverable.jsp");
		
	
			List<TTDeliverableCustomerMap> tTDeliverableCustomerMaps = new ArrayList<TTDeliverableCustomerMap>();
			HashMap<Long, Deliverable> deliverableHashMap = new HashMap<Long, Deliverable>();
			List<Long> curTTDeliverableMapIds = new ArrayList<Long>();
			int tTDeliverableCustomerMapCount = 0;
			
			List<TTDeliverableMap> tTDeliverableMaps = TTDeliverableMapLocalServiceUtil
					.findActiveByTowerTechnologyId(tTechnologyCustomerMap.getTowerTechnologyId());
	
			List<Long> tTDeliverableIds = new ArrayList<Long>();
			List<Long> deliverableMapIds = new ArrayList<Long>();
			HashMap<Long, TTDeliverableMap> tTDeliverableHashMap = new HashMap<Long, TTDeliverableMap>();
	
			for (TTDeliverableMap tTDeliverableMap : tTDeliverableMaps) {
				deliverableMapIds.add(tTDeliverableMap.getDeliverableId());
				tTDeliverableIds.add(tTDeliverableMap.getTTDeliverableId());
				tTDeliverableHashMap.put(tTDeliverableMap.getTTDeliverableId(),tTDeliverableMap);
			}
			
			if (!tTDeliverableIds.isEmpty()) {
	
				tTDeliverableCustomerMaps = TTDeliverableCustomerMapLocalServiceUtil
						.findActiveTTDeliverableCustomerMap(tTDeliverableIds, project.getOrganizationId());
				tTDeliverableCustomerMapCount = tTDeliverableCustomerMaps.size();
				
				for(TTDeliverableCustomerMap ttDeliverableCustomerMap:tTDeliverableCustomerMaps){
					curTTDeliverableMapIds.add(ttDeliverableCustomerMap.getTTDeliverableId());
				}
				
				List<Deliverable> deliverables = DeliverableLocalServiceUtil
						.findByDeliverableIdsList(deliverableMapIds);
	
				for (Deliverable deliverable : deliverables) {
					deliverableHashMap.put(deliverable.getDeliverableId(), deliverable);
				}
	
			}
			if(!project.getType().equalsIgnoreCase(CustomerConstants.TYPE_COMPANY))
			{
			
%>



		<portlet:renderURL var="projectURL">
			<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageTower.jsp"/>
			<portlet:param name="organizationId" value="<%=String.valueOf(project.getOrganizationId()) %>"/>
		
		</portlet:renderURL>


	 <portlet:renderURL var="customerURL">
			<portlet:param name="mvcPath" value="/html/customercatalogmanagement/viewProjects.jsp"/>
			<portlet:param name="organizationId" value="<%=String.valueOf(project.getParentOrganizationId()) %>"/>
		</portlet:renderURL>
 
 <%		
  		
		PortalUtil.addPortletBreadcrumbEntry(request, project.getParentOrganization().getName(),customerURL);
		PortalUtil.addPortletBreadcrumbEntry(request, project.getName(),projectURL);
			}
			%>
					
 		<portlet:renderURL var="towerURL">
			<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageTechnology.jsp"/>
			<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
		</portlet:renderURL>
			<%
		PortalUtil.addPortletBreadcrumbEntry(request, towerCustomer.getName(themeDisplay.getLocale()),towerURL);	
		PortalUtil.addPortletBreadcrumbEntry(request, tTechnologyCustomerMap.getName(themeDisplay.getLocale()),themeDisplay.getURLCurrent());
	
%>
	<portlet:renderURL var="backURL">
		<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageTechnology.jsp" />
		<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
	</portlet:renderURL>

	<liferay-ui:header backURL="<%=backURL%>" title="<%=LanguageUtil.format(request,\"map-deliverable-x-x-x\", new Object[]{project.getName() ,towerCustomer.getName(themeDisplay.getLocale()),tTechnologyCustomerMap.getName(themeDisplay.getLocale())})%>"  cssClass="cust_header" />
	
	<portlet:actionURL name="updateTTDeliverableCustomerMap" var="updateTTDeliverableCustomerMapURL">
		<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageDeliverable.jsp" />
		<portlet:param name="organizationId" value="<%=String.valueOf(project.getOrganizationId())%>" />
		<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
		<portlet:param name="tTechnologyCustomerId" value="<%=String.valueOf(tTechnologyCustomerMap.getTTechnologyCustomerId())%>" />
	</portlet:actionURL>



<%
String tabNames = null;
if(ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project) )
{
tabNames = "current,available";
}else{
tabNames = "current";
}
%>

<liferay-ui:tabs names="<%=tabNames %>" param="tab" url="<%=iteratorURL.toString() %>" >
<liferay-ui:section>
	<liferay-ui:search-container emptyResultsMessage="no-deliverable-mapped"	iteratorURL="<%=iteratorURL %>" var="tTDeliverableCustomerMapSearchContainer" total="<%=tTDeliverableCustomerMaps.size() %>">
		<liferay-ui:search-container-results 
			results="<%=ListUtil.subList(tTDeliverableCustomerMaps,tTDeliverableCustomerMapSearchContainer.getStart(),tTDeliverableCustomerMapSearchContainer.getEnd())%>" 
			
		/>
		<liferay-ui:search-container-row keyProperty="TTDeliverableCustomerId"
			className="com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap" modelVar="TTDeliverableCustomerMap">
			<portlet:renderURL var="manageProcessURL">
			<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageProcess.jsp" />
				<portlet:param name="organizationId" value="<%=String.valueOf(project.getOrganizationId())%>" />
				<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
				<portlet:param name="tTechnologyCustomerId"	value="<%=String.valueOf(tTechnologyCustomerId)%>" />
				<portlet:param name="tTDeliverableCustomerId"	value="<%=String.valueOf(TTDeliverableCustomerMap.getTTDeliverableCustomerId())%>" />
			</portlet:renderURL>
			<liferay-ui:search-container-column-text name="name"  property="name" href="<%=manageProcessURL %>"/>			 
			<liferay-ui:search-container-column-text cssClass="<%=ArrayUtil.contains(SPStatus.DISABLED_STATUSES, deliverableHashMap.get(tTDeliverableHashMap.get(TTDeliverableCustomerMap.getTTDeliverableId()).getDeliverableId()).getStatusId())?\"disabled\":\"active\" %>"
			name="deliverable-name" value="<%=deliverableHashMap.get(tTDeliverableHashMap.get(TTDeliverableCustomerMap.getTTDeliverableId()).getDeliverableId()).getName() %>" />
			<liferay-ui:search-container-column-text 
				 name="ttd-name" value="<%=tTDeliverableHashMap.get(TTDeliverableCustomerMap.getTTDeliverableId()).getName(themeDisplay.getLocale()) %>" />
			<liferay-ui:search-container-column-jsp	path="/html/customercatalogmanagement/deliverableActions.jsp" name="actions"/>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator	searchContainer="<%=tTDeliverableCustomerMapSearchContainer%>" />
	</liferay-ui:search-container>
</liferay-ui:section>
<%
if(tab.equalsIgnoreCase("available") && ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project))
{

	List<TTDeliverableMap> tTDeliverableNotMapped = TTDeliverableMapLocalServiceUtil
			.findByNotInTTDeliverableMap(tTechnologyCustomerMap.getTowerTechnologyId(), curTTDeliverableMapIds);
	
	int tTDeliverableNotMappedCount = tTDeliverableNotMapped.size();
	List<TTDeliverableMap> activeTTDeliverableNotMapped=new ArrayList<TTDeliverableMap>();
	for(TTDeliverableMap tTDeliverableMap:tTDeliverableNotMapped)
	{
		if(!ArrayUtil.contains( SPStatus.DISABLED_STATUSES  ,deliverableHashMap.get(tTDeliverableMap.getDeliverableId()).getStatusId()))
		{
			activeTTDeliverableNotMapped.add(tTDeliverableMap);
		}
	}
%>

<liferay-ui:section>
	<aui:form method="post" action="<%=updateTTDeliverableCustomerMapURL %>" name="TTDeliverableMapForm"> 
		<aui:input name="addDeliverableMapIds" type="hidden" />
		<liferay-ui:search-container emptyResultsMessage="no-deliverable-available" delta="<%=activeTTDeliverableNotMapped.size() %>" var="tTDeliverableSearchContainer" rowChecker="<%= new RowChecker(renderResponse) %>">
			<liferay-ui:search-container-results 
				results="<%=ListUtil.subList(activeTTDeliverableNotMapped,tTDeliverableSearchContainer.getStart(),tTDeliverableSearchContainer.getEnd())%>"
				
				/>
			
			<liferay-ui:search-container-row keyProperty="TTDeliverableId" className="com.lti.itops.ipac.spmgmt.model.TTDeliverableMap" modelVar="TTDeliverableMap">
					<liferay-ui:search-container-column-text 
					 name="name" property="name"/>
					 <liferay-ui:search-container-column-text 
					 name="deliverable-name" value="<%=deliverableHashMap.get(TTDeliverableMap.getDeliverableId()).getName() %>"/>
			</liferay-ui:search-container-row>
		
<%
		String taglibOnClick = renderResponse.getNamespace() + "updateDeliverableCustomerMap();";
		if(tTDeliverableNotMappedCount > 0)
		{
%>
		<aui:button-row>
			<aui:button type="submit" onClick="<%=taglibOnClick %>"	value="update-mapping" />
		</aui:button-row>
<%
		}
%>
				<liferay-ui:search-iterator searchContainer="<%=tTDeliverableSearchContainer%>" paginate="false"></liferay-ui:search-iterator>
		</liferay-ui:search-container>
	</aui:form>
</liferay-ui:section>
<%
}
%>

</liferay-ui:tabs>
	
<aui:script>
	Liferay.provide(
		window,
		'<portlet:namespace />updateDeliverableCustomerMap',
		function() {	
			document.<portlet:namespace />TTDeliverableMapForm.<portlet:namespace />addDeliverableMapIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />TTDeliverableMapForm, '<portlet:namespace />allRowIds');
			submitForm(document.<portlet:namespace />TTDeliverableMapForm);
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