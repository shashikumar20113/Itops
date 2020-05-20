<%-- Copyright (c) 2016 lti. All rights reserved.--%>

<%--  @author Sunilkumar Prabhakar, Raj Kumar Kulasekaran --%>


<%@ include file="init.jsp"%>

<%
	TTDeliverableCustomerMap tTDeliverableCustomerMap = null;
	TTechnologyCustomerMap tTechnologyCustomerMap = null;
    
	TowerCustomerMap towerCustomerMap = null;
   
	
	long towerCustomerId = ParamUtil.getLong(renderRequest,	"towerCustomerId", 0);
	long tTechnologyCustomerId = ParamUtil.getLong(renderRequest,"tTechnologyCustomerId", 0);
	long tTDeliverableCustomerId = ParamUtil.getLong(renderRequest,"tTDeliverableCustomerId", 0);
	
	
	Organization project = null;
	

	    
	


	try {
		tTDeliverableCustomerMap = TTDeliverableCustomerMapLocalServiceUtil
				.getTTDeliverableCustomerMap(tTDeliverableCustomerId);
	} catch (Exception e) {
		log("IPAC : Error while fetching DeliverableCustomer map for tTDeliverableCustomerId "+ tTDeliverableCustomerId, e);

	}
	
	if (tTDeliverableCustomerMap == null) {
		SessionErrors.add(renderRequest, NoSuchTTDeliverableCustomerMapException.class);
%>


<liferay-ui:error exception="<%=NoSuchTTDeliverableCustomerMapException.class%>"
message="invalid-tTDeliverableCustomerMap" />
<aui:button icon="left-arrow" href="<%=homeURL%>" value="home"></aui:button>
<%
	} else {

		try {
			tTechnologyCustomerMap = TTechnologyCustomerMapLocalServiceUtil.getTTechnologyCustomerMap(tTechnologyCustomerId);
		} catch (Exception e) {
			log("IPAC : Error while fetching TTechnologyCustomer map for tTechnologyCustomerId "+ tTechnologyCustomerId, e);

		}

		try {
			towerCustomerMap = TowerCustomerMapLocalServiceUtil.getTowerCustomerMap(towerCustomerId);
		} catch (Exception e) {
			log("IPAC : Error while fetching TowerCustomer map for towerCustomerId "+ towerCustomerId, e);

		}
		try {
			project = OrganizationLocalServiceUtil.getOrganization(tTDeliverableCustomerMap.getOrganizationId());
		} catch (Exception e) {
		log("IPAC : Error while fetching project for project id "
				+ tTDeliverableCustomerMap.getOrganizationId(), e);
		}
		if(ProjectCatalogPermission.isProjectCatalogViewer(themeDisplay, project))
		{
			
						
			String tab = ParamUtil.getString(request, "tab", "current");
			PortletURL iteratorURL = renderResponse.createRenderURL();
			iteratorURL.setParameter("tab", tab);			
			iteratorURL.setParameter("towerCustomerId",String.valueOf(towerCustomerId));
			iteratorURL.setParameter("tTechnologyCustomerId",String.valueOf(tTechnologyCustomerId));
			iteratorURL.setParameter("tTDeliverableCustomerId",String.valueOf(tTDeliverableCustomerMap.getTTDeliverableCustomerId()));
			iteratorURL.setParameter("mvcPath",	"/html/customercatalogmanagement/manageProcess.jsp");
		
			
			List<TTDProcessCustomerMap> curTTDProcessCustomerMaps = new ArrayList<TTDProcessCustomerMap>();
			List<Long> curTTDProcessMapIds = new ArrayList<Long>();
			HashMap<Long, Process> processHashMap = new HashMap<Long, Process>();
			int totalProcessCustomerMapsCount=0;
			
			List<TTDProcessMap> tTDProcessMaps = TTDProcessMapLocalServiceUtil
					.findActiveByTTDeliverableId(tTDeliverableCustomerMap.getTTDeliverableId());
			
			List<Long> tTDProcessIds = new ArrayList<Long>();
			List<Long> ProcessMapIds = new ArrayList<Long>();
			HashMap<Long, TTDProcessMap> tTProcessHashMap = new HashMap<Long, TTDProcessMap>();
			
			for(TTDProcessMap tTDProcessMap :tTDProcessMaps){
				tTDProcessIds.add(tTDProcessMap.getTTDProcessId());
				ProcessMapIds.add(tTDProcessMap.getProcessId());
				tTProcessHashMap.put(tTDProcessMap.getTTDProcessId(), tTDProcessMap);
			}
			
			if(!tTDProcessIds.isEmpty()){
				
				curTTDProcessCustomerMaps = TTDProcessCustomerMapLocalServiceUtil.findActiveTTDProcessCustomerMap(tTDProcessIds, project.getOrganizationId());
				totalProcessCustomerMapsCount = curTTDProcessCustomerMaps.size();
	
				for(TTDProcessCustomerMap tTDProcessCustomerMap:curTTDProcessCustomerMaps){
					curTTDProcessMapIds.add(tTDProcessCustomerMap.getTTDProcessId());
				}
				
				List<Process> processMaps = ProcessLocalServiceUtil
						.findByProcessIdsList(ProcessMapIds);       
				
				for(Process process:processMaps){
					processHashMap.put(process.getProcessId(), process);
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
			<portlet:param name="mvcPath" value="/html/customercatalogmanagement/viewprojects.jsp"/>
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
		
		 <portlet:renderURL var="technologyURL">
			<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageDeliverable.jsp"/>
			<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
			<portlet:param name="tTechnologyCustomerId" value="<%=String.valueOf(tTechnologyCustomerId)%>" />
		</portlet:renderURL>
			
			<%
		PortalUtil.addPortletBreadcrumbEntry(request, towerCustomerMap.getName(themeDisplay.getLocale()),towerURL);	
		PortalUtil.addPortletBreadcrumbEntry(request, tTechnologyCustomerMap.getName(themeDisplay.getLocale()),technologyURL);
		PortalUtil.addPortletBreadcrumbEntry(request, tTDeliverableCustomerMap.getName(themeDisplay.getLocale()),themeDisplay.getURLCurrent());
	%>
	<portlet:renderURL var="backURL">
		<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageDeliverable.jsp" />
		<portlet:param name="organizationId" value="<%=String.valueOf(project.getOrganizationId())%>" />
		<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />	
		<portlet:param name="tTechnologyCustomerId" value="<%=String.valueOf(tTechnologyCustomerId)%>" />
	</portlet:renderURL>

	<liferay-ui:header backURL="<%=backURL%>" title="<%=LanguageUtil.format(request,\"map-process-x-x-x-x\",new Object[]{project.getName() ,towerCustomerMap.getName(themeDisplay.getLocale()),tTechnologyCustomerMap.getName(themeDisplay.getLocale()),tTDeliverableCustomerMap.getName(themeDisplay.getLocale())})%>" cssClass="cust_header"/>
	
	<portlet:actionURL name="updateTTDProcessCustomerMap" var="updateTTDProcessCustomerMapURL">
		<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageProcess.jsp" />
		<portlet:param name="organizationId" value="<%=String.valueOf(project.getOrganizationId())%>" />
		<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
		<portlet:param name="tTechnologyCustomerId" value="<%=String.valueOf(tTechnologyCustomerId)%>" />
		<portlet:param name="tTDeliverableCustomerId" value="<%=String.valueOf(tTDeliverableCustomerMap.getTTDeliverableCustomerId())%>" />
	</portlet:actionURL>
<%
String tabNames = null;
if ( ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project) )
{
tabNames = "current,available";
}else{
tabNames = "current";
}
%>


<liferay-ui:tabs names="<%=tabNames %>" param="tab" url="<%=iteratorURL.toString() %>">
<liferay-ui:section>
	<liferay-ui:search-container emptyResultsMessage="no-process-mapped"	iteratorURL="<%=iteratorURL %>" var="tTDProcessCustomerMapSearchContainer" total="<%=curTTDProcessCustomerMaps.size() %>">
		<liferay-ui:search-container-results
		 results="<%=ListUtil.subList(curTTDProcessCustomerMaps,tTDProcessCustomerMapSearchContainer.getStart(),tTDProcessCustomerMapSearchContainer.getEnd())%>" 
		 
		 />
		<liferay-ui:search-container-row keyProperty="TTDProcessCustomerId"
			className="com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap" modelVar="TTDProcessCustomerMap">
			<portlet:renderURL var="manageSubProcessURL">
	<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageSubProcess.jsp" />
		<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
		<portlet:param name="tTechnologyCustomerId"	value="<%=String.valueOf(tTechnologyCustomerId)%>" />
		<portlet:param name="tTDeliverableCustomerId"	value="<%=String.valueOf(tTDeliverableCustomerId)%>" />
		<portlet:param name="tTDProcessCustomerId"	value="<%=String.valueOf(TTDProcessCustomerMap.getTTDProcessCustomerId())%>" />
</portlet:renderURL>
			<liferay-ui:search-container-column-text name="name" property="name" href="<%=manageSubProcessURL %>"/>
			<liferay-ui:search-container-column-text cssClass="<%=ArrayUtil.contains(SPStatus.DISABLED_STATUSES, processHashMap.get(tTProcessHashMap.get(TTDProcessCustomerMap.getTTDProcessId()).getProcessId()).getStatusId())?\"disabled\":\"active\" %>"
				 name="process-name"  value="<%=processHashMap.get(tTProcessHashMap.get(TTDProcessCustomerMap.getTTDProcessId()).getProcessId()).getName() %>" />
				<liferay-ui:search-container-column-text name="ttdp-name"  value="<%=tTProcessHashMap.get(TTDProcessCustomerMap.getTTDProcessId()).getName() %>" />			 
			<liferay-ui:search-container-column-jsp	path="/html/customercatalogmanagement/processActions.jsp" name="actions"/>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator	searchContainer="<%=tTDProcessCustomerMapSearchContainer%>" />
	</liferay-ui:search-container>
</liferay-ui:section>
<%
if(tab.equalsIgnoreCase("available") && ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project) )
{

	List<TTDProcessMap> tTdProcessNotMapped = TTDProcessMapLocalServiceUtil
			.findByNotInTTDProcessMap(tTDeliverableCustomerMap.getTTDeliverableId(), curTTDProcessMapIds);
	int totalProcessNotMappedCount = tTdProcessNotMapped.size();
	
	List<TTDProcessMap> activeTTdProcessNotMapped=new ArrayList<TTDProcessMap>();
	for(TTDProcessMap ttdProcessMap:tTdProcessNotMapped)
	{
		if(!ArrayUtil.contains(SPStatus.DISABLED_STATUSES, processHashMap.get( ttdProcessMap.getProcessId()).getStatusId() ))
		{
			activeTTdProcessNotMapped.add(ttdProcessMap);
		}
	}
%>
<liferay-ui:section>
	<aui:form method="post" action="<%=updateTTDProcessCustomerMapURL%>" name="TTDProcessMapForm"> 
		<aui:input name="addProcessMapIds" type="hidden" />
		<liferay-ui:search-container emptyResultsMessage="no-process-available" delta="<%=activeTTdProcessNotMapped.size() %>" var="tTDProcessSearchContainer" rowChecker="<%= new RowChecker(renderResponse) %>">
			<liferay-ui:search-container-results 
			results="<%=ListUtil.subList(activeTTdProcessNotMapped,tTDProcessSearchContainer.getStart(), tTDProcessSearchContainer.getEnd())%>"
			
			/>
			<liferay-ui:search-container-row keyProperty="TTDProcessId" className="com.lti.itops.ipac.spmgmt.model.TTDProcessMap" modelVar="TTDProcessMap">
				<liferay-ui:search-container-column-text 
				 name="name" property="name"/>
				 <liferay-ui:search-container-column-text 
				 name="process-name" value="<%=processHashMap.get(TTDProcessMap.getProcessId()).getName() %>"/>
			</liferay-ui:search-container-row>
		
<%
		String taglibOnClick = renderResponse.getNamespace() + "updateProcessCustomerMap();";
		if(totalProcessNotMappedCount > 0)
		{
%>
		<aui:button-row>
			<aui:button type="submit" onClick="<%=taglibOnClick %>"	value="update-mapping" />
		</aui:button-row>
<%
		}
%>
				<liferay-ui:search-iterator searchContainer="<%=tTDProcessSearchContainer%>" paginate="false"></liferay-ui:search-iterator>
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
		'<portlet:namespace />updateProcessCustomerMap',
		function() {	
			document.<portlet:namespace />TTDProcessMapForm.<portlet:namespace />addProcessMapIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />TTDProcessMapForm, '<portlet:namespace />allRowIds');
			submitForm(document.<portlet:namespace />TTDProcessMapForm);
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