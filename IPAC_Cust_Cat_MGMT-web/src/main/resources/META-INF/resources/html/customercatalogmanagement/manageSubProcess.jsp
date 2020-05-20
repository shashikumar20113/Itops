<%-- Copyright (c) 2016 lti. All rights reserved.--%>

<%--  @author Sunilkumar Prabhakar --%>


<%@ include file="init.jsp"%>

<%
	TTDProcessCustomerMap tTDProcessCustomerMap = null;
	Process process = null;
	

	long towerCustomerId = ParamUtil.getLong(renderRequest,"towerCustomerId", 0);
	long tTechnologyCustomerId = ParamUtil.getLong(renderRequest,"tTechnologyCustomerId", 0);
	long tTDeliverableCustomerId = ParamUtil.getLong(renderRequest,"tTDeliverableCustomerId", 0);
	long tTDProcessCustomerId = ParamUtil.getLong(renderRequest,"tTDProcessCustomerId", 0);
	
	
	
	try {
		tTDProcessCustomerMap = TTDProcessCustomerMapLocalServiceUtil
				.getTTDProcessCustomerMap(tTDProcessCustomerId);
	} catch (Exception e) {
		log("IPAC : Error while fetching tTDProcessCustomer map for tTDProcessCustomerId "+ tTDProcessCustomerId, e);

	}
	
	if (tTDProcessCustomerMap == null) {
		SessionErrors.add(renderRequest, NoSuchTTDPSubProcessCustomerMapException.class);
%>


<liferay-ui:error exception="<%=NoSuchTTDPSubProcessCustomerMapException.class%>"
message="invalid-technology" />
<aui:button icon="left-arrow" href="<%=homeURL%>" value="home"></aui:button>
<%
	} else {

		Organization project = null;
		
		try {
			project = OrganizationLocalServiceUtil.getOrganization(tTDProcessCustomerMap.getOrganizationId());
		} catch (Exception e) {
		log("IPAC : Error while fetching project for project id "
				+ tTDProcessCustomerMap.getOrganizationId(), e);
		}
		
		if( ProjectCatalogPermission.isProjectCatalogViewer(themeDisplay, project))
		{
			TTDeliverableCustomerMap tTDeliverableCustomerMap=null;
			try {
				tTDeliverableCustomerMap = TTDeliverableCustomerMapLocalServiceUtil
						.getTTDeliverableCustomerMap(tTDeliverableCustomerId);
			} catch (Exception e) {
				log("IPAC : Error while fetching tTDeliverableCustomerMap map for tTDeliverableCustomerId "+ tTDeliverableCustomerId, e);

			}
			
			TTechnologyCustomerMap tTechnologyCustomerMap=null;
			try {
				tTechnologyCustomerMap = TTechnologyCustomerMapLocalServiceUtil
						.getTTechnologyCustomerMap(tTechnologyCustomerId);
			} catch (Exception e) {
				log("IPAC : Error while fetching tTechnologyCustomerMap map for tTechnologyCustomerId "+ tTechnologyCustomerId, e);

			}
			
			TowerCustomerMap towerCustomerMap=null;
			try {
				towerCustomerMap = TowerCustomerMapLocalServiceUtil
						.getTowerCustomerMap(towerCustomerId);
			} catch (Exception e) {
				log("IPAC : Error while fetching TowerCustomerMap for towerCustomerId "+ towerCustomerId, e);

			}
			
		
		String tab = ParamUtil.getString(request, "tab", "current");
		PortletURL iteratorURL = renderResponse.createRenderURL();
		iteratorURL.setParameter("tab", tab);
		iteratorURL.setParameter("organizationId",String.valueOf(project.getOrganizationId()));
		iteratorURL.setParameter("towerCustomerId",String.valueOf(towerCustomerId));
		iteratorURL.setParameter("tTechnologyCustomerId",String.valueOf(tTechnologyCustomerId));
		iteratorURL.setParameter("tTDeliverableCustomerId",String.valueOf(tTDeliverableCustomerId));
		iteratorURL.setParameter("tTDProcessCustomerId",String.valueOf(tTDProcessCustomerMap.getTTDProcessCustomerId()));
		iteratorURL.setParameter("mvcPath",	"/html/customercatalogmanagement/manageSubProcess.jsp");
	
		
		List<TTDPSubProcessCustomerMap> curTTDPSubProcessCustomerMaps = new ArrayList<TTDPSubProcessCustomerMap>();
		List<Long> curTTDPSubProcessMapIds = new ArrayList<Long>();
		HashMap<Long, SubProcess> subProcessHashMap = new HashMap<Long, SubProcess>();
		
		List<TTDPSubProcessMap> tTDPSubProcessMaps = TTDPSubProcessMapLocalServiceUtil
				.findActiveByTTDProcessId(tTDProcessCustomerMap.getTTDProcessId());
		
		List<Long> tTDPSubProcessIds = new ArrayList<Long>();
		List<Long> subProcessMapIds = new ArrayList<Long>();
		HashMap<Long, TTDPSubProcessMap> tTDPSubProcessHashMap = new HashMap<Long, TTDPSubProcessMap>();
		int curTTDPSubProcessCustomerMapsCount =0;
		
		for(TTDPSubProcessMap tTDPSubProcessMap :tTDPSubProcessMaps){
			tTDPSubProcessIds.add(tTDPSubProcessMap.getTTDPSubProcessId());
			subProcessMapIds.add(tTDPSubProcessMap.getSubProcessId());
			tTDPSubProcessHashMap.put(tTDPSubProcessMap.getTTDPSubProcessId(), tTDPSubProcessMap);
		}
		
		
		if(!tTDPSubProcessIds.isEmpty()){

			curTTDPSubProcessCustomerMaps = TTDPSubProcessCustomerMapLocalServiceUtil
					.findActiveTTDPSubProcessCustomerMap(tTDPSubProcessIds, project.getOrganizationId());
			curTTDPSubProcessCustomerMapsCount = curTTDPSubProcessCustomerMaps.size();

			for(TTDPSubProcessCustomerMap tTDPSubProcessCustomerMap:curTTDPSubProcessCustomerMaps){
				curTTDPSubProcessMapIds.add(tTDPSubProcessCustomerMap.getTTDPSubProcessId());
			}
			
			List<SubProcess> subProcessMaps = SubProcessLocalServiceUtil
					.findBySubProcessIdsList(subProcessMapIds);
			for(SubProcess subProcess:subProcessMaps){
				subProcessHashMap.put(subProcess.getSubProcessId(), subProcess);
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
			<portlet:param name="mvcPath" value="/html/customercatalogmanagement/view.jsp"/>
			<portlet:param name="organizationId" value="<%=String.valueOf(project.getParentOrganizationId() )%>"/>
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
		
		 <portlet:renderURL var="technologyURL">
			<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageDeliverable.jsp"/>
			<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
			<portlet:param name="tTechnologyCustomerId" value="<%=String.valueOf(tTechnologyCustomerId)%>" />
		</portlet:renderURL>
		
		<portlet:renderURL var="deliverableURL">
			<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageProcess.jsp"/>
			<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
			<portlet:param name="tTechnologyCustomerId" value="<%=String.valueOf(tTechnologyCustomerId)%>" />
			<portlet:param name="tTDeliverableCustomerId" value="<%=String.valueOf(tTDeliverableCustomerId)%>" />
			<portlet:param name="tTDProcessCustomerId" value="<%=String.valueOf(tTDProcessCustomerId)%>" />
		</portlet:renderURL>
		
		<%
		PortalUtil.addPortletBreadcrumbEntry(request, towerCustomerMap.getName(themeDisplay.getLocale()),towerURL);	
		PortalUtil.addPortletBreadcrumbEntry(request, tTechnologyCustomerMap.getName(themeDisplay.getLocale()),technologyURL);
		PortalUtil.addPortletBreadcrumbEntry(request, tTDeliverableCustomerMap.getName(themeDisplay.getLocale()),deliverableURL);
		PortalUtil.addPortletBreadcrumbEntry(request, tTDProcessCustomerMap.getName(themeDisplay.getLocale()),themeDisplay.getURLCurrent());
	
%>
	<portlet:renderURL var="backURL">
		<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageProcess.jsp" />
		<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
		<portlet:param name="tTechnologyCustomerId" value="<%=String.valueOf(tTechnologyCustomerId)%>" />
		<portlet:param name="tTDeliverableCustomerId" value="<%=String.valueOf(tTDeliverableCustomerId)%>" />
	</portlet:renderURL>

	<liferay-ui:header backURL="<%=backURL%>" title="<%=LanguageUtil.format(request,\"map-sub-process-x-x-x-x-x\",new Object[]{project.getName() ,towerCustomerMap.getName(themeDisplay.getLocale()),tTechnologyCustomerMap.getName(themeDisplay.getLocale()),tTDeliverableCustomerMap.getName(themeDisplay.getLocale()),tTDProcessCustomerMap.getName(themeDisplay.getLocale())})%>" cssClass="cust_header"/>
	
	<portlet:actionURL name="updateTTDPSubProcessCustomerMap" var="updateTTDPSubProcessCustomerMapURL">
		<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageSubProcess.jsp" />
		<portlet:param name="organizationId" value="<%=String.valueOf(project.getOrganizationId())%>" />
		<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
		<portlet:param name="tTechnologyCustomerId" value="<%=String.valueOf(tTechnologyCustomerId)%>" />
		<portlet:param name="tTDProcessCustomerId" value="<%=String.valueOf(tTDProcessCustomerMap.getTTDProcessCustomerId())%>" />
		<portlet:param name="tTDeliverableCustomerId" value="<%=String.valueOf(tTDeliverableCustomerId)%>" />
	</portlet:actionURL>
<%
String tabNames = null;
if ( ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project))
{
tabNames = "current,available";
}else{
tabNames = "current";
}
%>
<liferay-ui:tabs names="<%=tabNames %>" param="tab" url="<%=iteratorURL.toString() %>" >
<liferay-ui:section>
	<liferay-ui:search-container emptyResultsMessage="no-sub-process-mapped" iteratorURL="<%=iteratorURL %>" var="tTDPSubProcessCustomerMapSearchContainer" total="<%=curTTDPSubProcessCustomerMaps.size() %>">
		<liferay-ui:search-container-results
		 results="<%=ListUtil.subList(curTTDPSubProcessCustomerMaps,tTDPSubProcessCustomerMapSearchContainer.getStart(),tTDPSubProcessCustomerMapSearchContainer.getEnd())%>" 
		
		 />
		<liferay-ui:search-container-row keyProperty="TTDPSubProcessCustomerId"
			className="com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap" modelVar="TTDPSubProcessCustomerMap">
			<portlet:renderURL var="manageTaskURL">
	<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageTask.jsp" />
		<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
		<portlet:param name="tTechnologyCustomerId"	value="<%=String.valueOf(tTechnologyCustomerId)%>" />
		<portlet:param name="tTDeliverableCustomerId"	value="<%=String.valueOf(tTDeliverableCustomerId)%>" />
		<portlet:param name="tTDProcessCustomerId"	value="<%=String.valueOf(tTDProcessCustomerId)%>" />
		<portlet:param name="tTDPSubProcessCustomerId"	value="<%=String.valueOf(TTDPSubProcessCustomerMap.getTTDPSubProcessCustomerId())%>" />
</portlet:renderURL>
			<liferay-ui:search-container-column-text href="<%=manageTaskURL %>"  name="name"  property="name"/>	
			<liferay-ui:search-container-column-text cssClass="<%=ArrayUtil.contains(SPStatus.DISABLED_STATUSES, subProcessHashMap.get(tTDPSubProcessHashMap.get(TTDPSubProcessCustomerMap.getTTDPSubProcessId()).getSubProcessId()).getStatusId())?\"disabled\":\"active\" %>"
				 name="sub-process-name"  value="<%=subProcessHashMap.get(tTDPSubProcessHashMap.get(TTDPSubProcessCustomerMap.getTTDPSubProcessId()).getSubProcessId()).getName() %>" />
			<liferay-ui:search-container-column-text 
				 name="ttdpsp-name"  value="<%=tTDPSubProcessHashMap.get(TTDPSubProcessCustomerMap.getTTDPSubProcessId()).getName(themeDisplay.getLocale()) %>" />		 
			<liferay-ui:search-container-column-jsp	path="/html/customercatalogmanagement/subProcessActions.jsp" name="actions"/>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator	searchContainer="<%=tTDPSubProcessCustomerMapSearchContainer%>" />
	</liferay-ui:search-container>
</liferay-ui:section>
<%
if(tab.equalsIgnoreCase("available") && ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project))
{
	
	List<TTDPSubProcessMap> tTdPSubProcessNotMapped = TTDPSubProcessMapLocalServiceUtil
			.findByNotInTTDPSubProcessMap(tTDProcessCustomerMap.getTTDProcessId(), curTTDPSubProcessMapIds);
	
	int totalSubProcessNotMappedCount = tTdPSubProcessNotMapped.size();
	List<TTDPSubProcessMap> activeTTdPSubProcessNotMapped=new ArrayList<TTDPSubProcessMap>(); 
	
	for(TTDPSubProcessMap ttdpSubProcessMap:tTdPSubProcessNotMapped)
	{
		if(!ArrayUtil.contains(SPStatus.DISABLED_STATUSES,subProcessHashMap.get(ttdpSubProcessMap.getSubProcessId()).getStatusId()))
		{
			activeTTdPSubProcessNotMapped.add(ttdpSubProcessMap);
		}
	}

%>

<liferay-ui:section>
	<aui:form method="post" action="<%=updateTTDPSubProcessCustomerMapURL%>" name="TTDPSubProcessMapForm"> 
		<aui:input name="addSubProcessMapIds" type="hidden" />
		<liferay-ui:search-container emptyResultsMessage="no-sub-process-available" delta="<%=activeTTdPSubProcessNotMapped.size() %>" var="tTDPSubProcessSearchContainer" rowChecker="<%= new RowChecker(renderResponse) %>">
			<liferay-ui:search-container-results 
			results="<%=ListUtil.subList(activeTTdPSubProcessNotMapped,tTDPSubProcessSearchContainer.getStart(), tTDPSubProcessSearchContainer.getEnd())%>"
			
			/>
			<liferay-ui:search-container-row keyProperty="TTDPSubProcessId" className="com.lti.itops.ipac.spmgmt.model.TTDPSubProcessMap" modelVar="TTDPSubProcessMap">
				<liferay-ui:search-container-column-text  
				name="name" property="name"/>
					<liferay-ui:search-container-column-text 
				 name="sub-process-name"  value="<%=subProcessHashMap.get(TTDPSubProcessMap.getSubProcessId()).getName() %>" />
			</liferay-ui:search-container-row>
			
<%
		String taglibOnClick = renderResponse.getNamespace() + "updatePSubProcessCustomerMap();";
		if(totalSubProcessNotMappedCount > 0)
		{
%>
		<aui:button-row>
			<aui:button type="submit" onClick="<%=taglibOnClick %>"	value="update-mapping" />
		</aui:button-row>
<%
		}
%>
				<liferay-ui:search-iterator searchContainer="<%=tTDPSubProcessSearchContainer%>" paginate="false"></liferay-ui:search-iterator>
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
		'<portlet:namespace />updatePSubProcessCustomerMap',
		function() {	
			document.<portlet:namespace />TTDPSubProcessMapForm.<portlet:namespace />addSubProcessMapIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />TTDPSubProcessMapForm, '<portlet:namespace />allRowIds');
			submitForm(document.<portlet:namespace />TTDPSubProcessMapForm);
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