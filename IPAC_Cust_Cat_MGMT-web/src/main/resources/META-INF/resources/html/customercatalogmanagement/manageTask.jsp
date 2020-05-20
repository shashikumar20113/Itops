<%-- Copyright (c) 2016 lti. All rights reserved.--%>

<%--  @author Sunilkumar Prabhakar --%>


<%@page import="com.liferay.portal.kernel.service.ListTypeServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.ListType"%>
<%@ include file="init.jsp"%>

<%
	TTDPSubProcessCustomerMap tTDPSubProcessCustomerMap = null;

	

	long towerCustomerId = ParamUtil.getLong(renderRequest,"towerCustomerId", 0);
	long tTechnologyCustomerId = ParamUtil.getLong(renderRequest,"tTechnologyCustomerId", 0);
	long tTDeliverableCustomerId = ParamUtil.getLong(renderRequest,"tTDeliverableCustomerId", 0);
	long tTDProcessCustomerId = ParamUtil.getLong(renderRequest,"tTDProcessCustomerId", 0);
	long tTDPSubProcessCustomerId = ParamUtil.getLong(renderRequest,"tTDPSubProcessCustomerId", 0);
	String pickDefaultMap = ParamUtil.getString(renderRequest,"pickDefaultMap");


	String arrayTaskIds = "[";
	
	Organization project = null;
	String pickDefaultTaskMap = "true";
	
	List<ListType> taskTypeList=ListTypeServiceUtil.getListTypes(SPStatus.TASK_LIST_TYPE);
	HashMap<Long,String> taskTypeMap=new HashMap<Long,String>();
	for(ListType status:taskTypeList)
	{
		taskTypeMap.put(status.getListTypeId(), status.getName());
	}
	


	try {
		tTDPSubProcessCustomerMap = TTDPSubProcessCustomerMapLocalServiceUtil
				.getTTDPSubProcessCustomerMap(tTDPSubProcessCustomerId);
	} catch (Exception e) {
		log("IPAC : Error while fetching tTDPSubProcessCustomer map for tTDPSubProcessCustomerId "+ tTDPSubProcessCustomerId, e);

	}
	
	if (tTDPSubProcessCustomerMap == null) {
		SessionErrors.add(renderRequest, NoSuchTTDPSubProcessCustomerMapException.class);
%>


<liferay-ui:error exception="<%=NoSuchTTDPSubProcessCustomerMapException.class%>"
message="invalid-Sub-Process" />
<aui:button icon="left-arrow" href="<%=homeURL%>" value="home"></aui:button>
<%
	} else {
		try {
			project = OrganizationLocalServiceUtil.getOrganization(tTDPSubProcessCustomerMap.getOrganizationId());
		} catch (Exception e) {
		log("IPAC : Error while fetching project for project id "
				+ tTDPSubProcessCustomerMap.getOrganizationId(), e);
		}
		
		
		if(ProjectCatalogPermission.isProjectCatalogViewer(themeDisplay, project) )
		{
		
		
			
			
			String tab = ParamUtil.getString(request, "tab", "current");
			PortletURL iteratorURL = renderResponse.createRenderURL();
			iteratorURL.setParameter("tab", tab);
			iteratorURL.setParameter("towerCustomerId",String.valueOf(towerCustomerId));
			iteratorURL.setParameter("tTechnologyCustomerId",String.valueOf(tTechnologyCustomerId));
			iteratorURL.setParameter("tTDeliverableCustomerId",String.valueOf(tTDeliverableCustomerId));
			iteratorURL.setParameter("tTDProcessCustomerId",String.valueOf(tTDProcessCustomerId));
			iteratorURL.setParameter("pickDefaultMap",String.valueOf(pickDefaultMap));
			iteratorURL.setParameter("tTDPSubProcessCustomerId",String.valueOf(tTDPSubProcessCustomerMap.getTTDPSubProcessCustomerId()));
			iteratorURL.setParameter("mvcPath",	"/html/customercatalogmanagement/manageTask.jsp");
		
			
			List<TTDPSPTaskCustomerMap> curTTDPSPTaskCustomerMaps = new ArrayList<TTDPSPTaskCustomerMap>();
			List<Long> curTTDPSubPSubProcessMapIds = new ArrayList<Long>();
			HashMap<Long, Task> taskHashMap = new HashMap<Long, Task>();
			
			
			List<Long> taskMapIds = new ArrayList<Long>();
			List<Long> curtaskMapIds = new ArrayList<Long>();
			HashMap<Long, TTDPSPTaskMap> tTDPSPTaskMapHashMap = new HashMap<Long, TTDPSPTaskMap>();
			int totalTTDPSPTaskCustomerMapsCount =0;
			
			//curTTDPSPTaskCustomerMaps = TTDPSPTaskCustomerMapLocalServiceUtil.findActiveByOrganizationId(organizationId);
			
			curTTDPSPTaskCustomerMaps = TTDPSPTaskCustomerMapLocalServiceUtil.findActiveByOrganizationAndSubProcess(project.getOrganizationId(), tTDPSubProcessCustomerMap.getTTDPSubProcessId());
			
			totalTTDPSPTaskCustomerMapsCount = curTTDPSPTaskCustomerMaps.size();
			System.out.println(tTDPSubProcessCustomerMap.getTTDPSubProcessId());
			
			for(TTDPSPTaskCustomerMap tTDPSPTaskCustomerMap:curTTDPSPTaskCustomerMaps){
				curtaskMapIds.add(tTDPSPTaskCustomerMap.getTaskId());
			}
			
			if(!curtaskMapIds.isEmpty()){
	
				List<Task> taskMaps = TaskLocalServiceUtil.findByTaskIdsList(curtaskMapIds);
				
				for(Task task:taskMaps){
					taskHashMap.put(task.getTaskId(), task);
				}
			}
			if(!project.getType().equalsIgnoreCase(CustomerConstants.TYPE_COMPANY))
			{

%>

<portlet:renderURL var="projectURL">
			<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageTower.jsp"/>
			<portlet:param name="organizationId" value="<%=String.valueOf(project.getOrganizationId()) %>"/>
			<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
		</portlet:renderURL>
	

	 <portlet:renderURL var="customerURL">
			<portlet:param name="mvcPath" value="/html/customercatalogmanagement/viewProjects.jsp"/>
			<portlet:param name="organizationId" value="<%=String.valueOf(project.getParentOrganizationId()) %>"/>
		</portlet:renderURL> 		
<% 		
 		
		PortalUtil.addPortletBreadcrumbEntry(request, project.getParentOrganization().getName(),customerURL);
		PortalUtil.addPortletBreadcrumbEntry(request, project.getName(),projectURL);
			}%>
			
				
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
		
		
		<portlet:renderURL var="processURL">
			<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageSubProcess.jsp"/>
			<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
			<portlet:param name="tTechnologyCustomerId" value="<%=String.valueOf(tTechnologyCustomerId)%>" />
			<portlet:param name="tTDeliverableCustomerId" value="<%=String.valueOf(tTDeliverableCustomerId)%>" />
			<portlet:param name="tTDProcessCustomerId" value="<%=String.valueOf(tTDProcessCustomerId)%>" />
		</portlet:renderURL>
			
			<%
			TowerCustomerMap towerCustomerMap=TowerCustomerMapLocalServiceUtil.getTowerCustomerMap(towerCustomerId);
			TTechnologyCustomerMap tTechnologyCustomerMap= TTechnologyCustomerMapLocalServiceUtil.getTTechnologyCustomerMap(tTechnologyCustomerId);
			TTDeliverableCustomerMap ttDeliverableCustomerMap=TTDeliverableCustomerMapLocalServiceUtil.getTTDeliverableCustomerMap(tTDeliverableCustomerId);
			TTDProcessCustomerMap ttdProcessCustomerMap=TTDProcessCustomerMapLocalServiceUtil.getTTDProcessCustomerMap(tTDProcessCustomerId);
			
		PortalUtil.addPortletBreadcrumbEntry(request, towerCustomerMap.getName(themeDisplay.getLocale()),towerURL);	
		PortalUtil.addPortletBreadcrumbEntry(request, tTechnologyCustomerMap.getName(themeDisplay.getLocale()),technologyURL);
		PortalUtil.addPortletBreadcrumbEntry(request, ttDeliverableCustomerMap.getName(themeDisplay.getLocale()),deliverableURL);
		PortalUtil.addPortletBreadcrumbEntry(request, ttdProcessCustomerMap.getName(themeDisplay.getLocale()),processURL);
		PortalUtil.addPortletBreadcrumbEntry(request, tTDPSubProcessCustomerMap.getName(themeDisplay.getLocale()),themeDisplay.getURLCurrent());
	
%>
	<portlet:renderURL var="backURL">
		<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageSubProcess.jsp" />
		<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
		<portlet:param name="tTechnologyCustomerId" value="<%=String.valueOf(tTechnologyCustomerId)%>" />
		<portlet:param name="tTDeliverableCustomerId" value="<%=String.valueOf(tTDeliverableCustomerId)%>" />
		<portlet:param name="tTDProcessCustomerId" value="<%=String.valueOf(tTDProcessCustomerId)%>" />
	</portlet:renderURL>

	<liferay-ui:header backURL="<%=backURL%>" title="<%=LanguageUtil.format(request,\"map-task-x-x-x-x-x-x\",new Object[]{project.getName() ,towerCustomerMap.getName(themeDisplay.getLocale()),tTechnologyCustomerMap.getName(themeDisplay.getLocale()),ttDeliverableCustomerMap.getName(themeDisplay.getLocale()),ttdProcessCustomerMap.getName(themeDisplay.getLocale()),tTDPSubProcessCustomerMap.getName(themeDisplay.getLocale())})%>" cssClass="cust_header"/>
	
	<portlet:actionURL name="updateTTDPSPTaskCustomerMap" var="updateTTDPSPTaskCustomerMapURL">
		<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageTask.jsp" />
		<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
		<portlet:param name="tTechnologyCustomerId" value="<%=String.valueOf(tTechnologyCustomerId)%>" />
		<portlet:param name="tTDPSubProcessCustomerId" value="<%=String.valueOf(tTDPSubProcessCustomerMap.getTTDPSubProcessCustomerId())%>" />
		<portlet:param name="tTDeliverableCustomerId" value="<%=String.valueOf(tTDeliverableCustomerId)%>" />
		<portlet:param name="tTDProcessCustomerId" value="<%=String.valueOf(tTDProcessCustomerId)%>" />
		<portlet:param name="tTDPSubProcessId" value="<%=String.valueOf(tTDPSubProcessCustomerMap.getTTDPSubProcessId())%>" />
		<portlet:param name="organizationId" value="<%=String.valueOf(project.getOrganizationId())%>" />
		
	</portlet:actionURL>

<%
String tabNames = null;
if (  ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project) )
{
tabNames = "current,available";
}else{
tabNames = "current";
}
%>

<liferay-ui:tabs names="<%=tabNames %>" param="tab" url="<%=iteratorURL.toString() %>" >
<liferay-ui:section>
	<liferay-ui:search-container emptyResultsMessage="no-task-mapped" iteratorURL="<%=iteratorURL %>" var="tTDPSPTaskCustomerMapSearchContainer" total="<%=curTTDPSPTaskCustomerMaps.size() %>">
		<liferay-ui:search-container-results
		 results="<%=ListUtil.subList(curTTDPSPTaskCustomerMaps,tTDPSPTaskCustomerMapSearchContainer.getStart(),tTDPSPTaskCustomerMapSearchContainer.getEnd())%>" 
		 
		 />
		<liferay-ui:search-container-row keyProperty="TTDPSPTaskCustomerId"
			className="com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap" modelVar="TTDPSPTaskCustomerMap">

			<liferay-ui:search-container-column-text name="name"  property="name"/>		
			<liferay-ui:search-container-column-text cssClass="<%=ArrayUtil.contains(SPStatus.DISABLED_STATUSES, taskHashMap.get(TTDPSPTaskCustomerMap.getTaskId()).getStatusId())?\"disabled\":\"active\" %>"
				 name="task-name"  value="<%=taskHashMap.get(TTDPSPTaskCustomerMap.getTaskId()).getName() %>" />
			<liferay-ui:search-container-column-text name="task-type"
			value="<%=taskTypeMap.get(Long.valueOf(TTDPSPTaskCustomerMap.getTaskTypeId())) %>"></liferay-ui:search-container-column-text>	 
			<liferay-ui:search-container-column-jsp	path="/html/customercatalogmanagement/taskActions.jsp" name="actions"/>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator	searchContainer="<%=tTDPSPTaskCustomerMapSearchContainer%>" />
	</liferay-ui:search-container>
</liferay-ui:section>
<%
	if (tab.equalsIgnoreCase("available") && ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project)) 
	{
				List<Task> tTDPSPTaskNotMapped = TaskLocalServiceUtil
						.findActiveByCompanyIdandNotInTaskIdsList(themeDisplay.getCompanyId(),curtaskMapIds);
				int totalTaskNotMappedCount = tTDPSPTaskNotMapped.size();

				List<Task> sortedTaskList = new ArrayList<Task>();
			

				//Fetching default taskId mapped to the tTDPSubProcessId
				List<TTDPSPTaskMap> mappedTaskList = TTDPSPTaskMapLocalServiceUtil
						.findByNotInTTDPSPTaskMap(tTDPSubProcessCustomerMap.getTTDPSubProcessId(), curtaskMapIds);


				for (Task task : tTDPSPTaskNotMapped) 
				{
					Boolean match = false;
					for (TTDPSPTaskMap tTDPSPTaskMap : mappedTaskList) 
					{
						if (task.getTaskId() == tTDPSPTaskMap.getTaskId()) 
						{
							sortedTaskList.add(0, task);
							match = true;
						}
					}
					if(!match){
						sortedTaskList.add(task);
					}
				}
				

				int count = 0;
				for (TTDPSPTaskMap mtask : mappedTaskList) {
					if (count > 0) {
						arrayTaskIds = arrayTaskIds + ",";
					}
					arrayTaskIds = arrayTaskIds + mtask.getTaskId();
					count++;
				}
				arrayTaskIds = arrayTaskIds + "]";


%>



<liferay-ui:section>
	<aui:form method="post" action="<%=updateTTDPSPTaskCustomerMapURL%>" name="TaskMapForm"> 
		<aui:input name="addTaskMapIds" type="hidden" />
		<liferay-ui:search-container emptyResultsMessage="no-task-available" delta="<%=totalTaskNotMappedCount %>" var="tTDPSubPSubProcessSearchContainer" 
			rowChecker="<%= new RowChecker(renderResponse)%>"  orderByCol="Task Name">
			<liferay-ui:search-container-results 
			results="<%=ListUtil.subList(sortedTaskList,tTDPSubPSubProcessSearchContainer.getStart(),tTDPSubPSubProcessSearchContainer.getEnd())%>"
			
			/>
			<liferay-ui:search-container-row keyProperty="taskId" className="com.lti.itops.ipac.spmgmt.model.Task" modelVar="Task">
			
	<%--  		<liferay-ui:search-container-column-text name="Id" value="<%=String.valueOf(Task.getTaskId()) %>" />--%>
			<liferay-ui:search-container-column-text 
				 name="name" property="name"/>
				 
			<liferay-ui:search-container-column-text name="task-type"
			value="<%=taskTypeMap.get(Long.valueOf(Task.getTaskTypeId())) %>"></liferay-ui:search-container-column-text>
			
			</liferay-ui:search-container-row>
			<aui:fieldset>    
				<div id="treeviewBreadcrumbDivId">
	<c:if test="<%=companyOrg!=null %>">
	<span class="treeview-breadcrumb" data-orgId="<%=companyOrgID%>" onclick="javascript:getCorrespondingOUAndCompentency(this);"><%=companyOrg.getName() %></span>
	</c:if>
</div>
<aui:row>
<aui:col width="20">
<aui:select label="OU" name="ouId" showEmptyOption="true" >
					<%
						List<Organization> ous=OrganizationLocalServiceUtil.search(themeDisplay.getCompanyId(), companyOrgID, null, CustomerConstants.TYPE_OU, null, null, null, QueryUtil.ALL_POS,QueryUtil.ALL_POS);
						for(Organization org:ous)
						{
							if(org.getStatusId()==ListTypeConstants.ORGANIZATION_STATUS_DEFAULT)
							{
					%>
							<aui:option value="<%=org.getOrganizationId() %>"><%=org.getName() %></aui:option>
					<%
							}
						}
					%>
				</aui:select>
</aui:col>
<aui:col width="20">
				<aui:select label="competency" name="competencyId" disabled="true"></aui:select>
</aui:col>
<aui:col width="20">
		<aui:select label="group" name="doGroupId" disabled="true"></aui:select>
</aui:col>
</aui:row>
</aui:fieldset>			
			
<%
				String taglibOnClick = renderResponse.getNamespace() + "updateTaskCustomerMap();";
				String pickDefaultOnClick = renderResponse.getNamespace() + "pickDefaultTaskMap();";
		if(totalTaskNotMappedCount > 0)
		{
%>
		<aui:button-row>
		<aui:button type="submit" onClick="<%=taglibOnClick %>"	value="update-mapping" />
		<aui:button  onClick="<%=pickDefaultOnClick %>" value="pick-default" />
		</aui:button-row>
<%
		}
%>
				<liferay-ui:search-iterator searchContainer="<%=tTDPSubPSubProcessSearchContainer%>" paginate="false"></liferay-ui:search-iterator>
		</liferay-ui:search-container>
	</aui:form>
</liferay-ui:section>
<portlet:resourceURL var="getList">
	<portlet:param name="<%=Constants.CMD %>" value="getOUChildren"/>
</portlet:resourceURL>

<portlet:resourceURL var="getGroupList">
	<portlet:param name="<%=Constants.CMD %>" value="getGroups"/>
</portlet:resourceURL>


<aui:script use="aui-loading-mask-deprecated">
      
		var <portlet:namespace/>loadingMask = new A.LoadingMask({
		    'strings.loading': 'Loading...',
		    target: A.getBody(),
		    background: '#000'
		});

		Liferay.provide(
				window,
				'getCorrespondingOUAndCompentency',
				function(currBreadcrumbNode) {	
					var A=AUI();
					
					var ouOrganizationId=currBreadcrumbNode.getAttribute("data-orgId");
					
					//remove breadcrumb label after curr clicked label
					var totalbreadcrumbLevel=document.getElementById("treeviewBreadcrumbDivId").childElementCount;
					
					if(totalbreadcrumbLevel!=1){
						
						var breadcrumbs=document.getElementById("treeviewBreadcrumbDivId");
						var children = breadcrumbs.getElementsByTagName('span');
						
						var breadcrumbElmt=[];
						var removeNode=false;
						for(var i = 0; i < children.length; i++) {
							
							if(removeNode){
								breadcrumbElmt.push(children[i]);
							}
							
							if( children[i].getAttribute("data-orgId")==currBreadcrumbNode.getAttribute("data-orgId")){ removeNode=true; }
							
						}
						
						for(var element in  breadcrumbElmt){
							console.log(breadcrumbElmt[element]);
							breadcrumbs.removeChild(breadcrumbElmt[element]);
						}
					}
					
					 <portlet:namespace/>loadingMask.show();
					 url='<%=getList %>'+'&<portlet:namespace/>ouId=' + ouOrganizationId
			         A.io.request(url,{
			        	 dataType: 'json',
			                 cache:false, 
			                 on: {
			                   success: function() {
			                	   var data=this.get('responseData');
			                	   if(data==null || data ==""){
			                		   A.one('#<portlet:namespace/>comptencyId').set('disabled', true);
			                           A.one('#<portlet:namespace/>doGroupId').set('disabled', true);
			                	   }else{
			                		   ouOptions = '<option value=""></option>';
			                		   for (i = 0; i < data.ous.length; i++) {
			                			   ouOptions += '<option value="' + data.ous[i].id + '">' + data.ous[i].name + '</option>';
			                             }
			                		   A.one('#<portlet:namespace/>ouId').html(ouOptions);
			                           A.one('#<portlet:namespace/>ouId').set('disabled', false);
			                           compOptions = '<option value=""></option>';
			                		   for (i = 0; i < data.competencies.length; i++) {
			                			   compOptions += '<option value="' + data.competencies[i].id + '">' + data.competencies[i].name + '</option>';
			                             }
			                		   A.one('#<portlet:namespace/>competencyId').html(compOptions);
			                           A.one('#<portlet:namespace/>competencyId').set('disabled', false);
			                           A.one('#<portlet:namespace/>doGroupId').html("");
			                           A.one('#<portlet:namespace/>doGroupId').set('disabled', true);
			                	   }
			                	   <portlet:namespace/>loadingMask.hide();
			                   },
			                   failure:function(){
									A.one('#<portlet:namespace/>competencyId').html("");
									A.one('#<portlet:namespace/>competencyId').set('disabled', true); 
									 A.one('#<portlet:namespace/>doGroupId').html("");
			                           A.one('#<portlet:namespace/>doGroupId').set('disabled', true);
									<portlet:namespace/>loadingMask.hide();
			                   }
			                 }
			         });
					
				}
			);
		
		  	
		AUI().ready('aui-io-request',function(A){ 
A.one('#<portlet:namespace/>ouId').on('change',function() {
	var ouId = this.val();
	 A.one('#<portlet:namespace/>competencyId').html("");
    A.one('#<portlet:namespace/>competencyId').set('disabled', true);
    A.one('#<portlet:namespace/>doGroupId').html("");
    A.one('#<portlet:namespace/>doGroupId').set('disabled', true);
	 if ((ouId !== '') && (ouId!=0)) {
		 <portlet:namespace/>loadingMask.show();
		 url='<%=getList %>'+'&<portlet:namespace/>ouId=' + ouId
         A.io.request(url,{
        	 dataType: 'json',
                 cache:false, 
                 on: {
                   success: function() {
                	   var data=this.get('responseData');
                	   if(data==null || data ==""){
                		   A.one('#<portlet:namespace/>comptencyId').set('disabled', true);
                           A.one('#<portlet:namespace/>doGroupId').set('disabled', true);
                	   }else{
                		   var treeviewBreadcrumbDiv = A.one("#treeviewBreadcrumbDivId");
              			 var breadcrumbLabel="<span class='treeview-breadcrumb' data-orgId='"+ouId+"' onclick='javascript:getCorrespondingOUAndCompentency(this);'> >> "+A.one("#<portlet:namespace />ouId option:selected").get("text");+"</span>";
              			 treeviewBreadcrumbDiv.append(breadcrumbLabel);
                		   ouOptions = '<option value=""></option>';
                		   for (i = 0; i < data.ous.length; i++) {
                			   ouOptions += '<option value="' + data.ous[i].id + '">' + data.ous[i].name + '</option>';
                             }
                		   A.one('#<portlet:namespace/>ouId').html(ouOptions);
                           A.one('#<portlet:namespace/>ouId').set('disabled', false);
                           compOptions = '<option value=""></option>';
                		   for (i = 0; i < data.competencies.length; i++) {
                			   compOptions += '<option value="' + data.competencies[i].id + '">' + data.competencies[i].name + '</option>';
                             }
                		   A.one('#<portlet:namespace/>competencyId').html(compOptions);
                           A.one('#<portlet:namespace/>competencyId').set('disabled', false);
                           A.one('#<portlet:namespace/>doGroupId').html("");
                           A.one('#<portlet:namespace/>doGroupId').set('disabled', true);
                	   }
                	   <portlet:namespace/>loadingMask.hide();
                   },
                   failure:function(){
						A.one('#<portlet:namespace/>competencyId').html("");
						A.one('#<portlet:namespace/>competencyId').set('disabled', true);
						A.one('#<portlet:namespace/>doGroupId').html("");
                        A.one('#<portlet:namespace/>doGroupId').set('disabled', true);
						<portlet:namespace/>loadingMask.hide();
                   }
                 }
	 		}
		 );
	 } else {
		A.one('#<portlet:namespace/>competencyId').html("");
		A.one('#<portlet:namespace/>competencyId').set('disabled', true);
		A.one('#<portlet:namespace/>doGroupId').html("");
        A.one('#<portlet:namespace/>doGroupId').set('disabled', true);
	 }
});
A.one('#<portlet:namespace/>competencyId').on('change',function() {
	var competencyId = this.val();
	 A.one('#<portlet:namespace/>doGroupId').html("");
    A.one('#<portlet:namespace/>doGroupId').set('disabled', true);
	 if ((competencyId !== '') && (competencyId!=0)) {
		 <portlet:namespace/>loadingMask.show();
		 url='<%=getGroupList %>'+'&<portlet:namespace/>competencyId=' + competencyId
         A.io.request(url,{
        	 dataType: 'json',
                 cache:false, 
                 on: {
                   success: function() {
                	   var data=this.get('responseData');
                	   if(data==null || data ==""){
                		   A.one('#<portlet:namespace/>doGroupId').set('disabled', true);
                	   }else{
                		   
                		 
                           groupOptions = '<option value=""></option>';
                		   for (i = 0; i < data.length; i++) {
                			   groupOptions += '<option value="' + data[i].id + '">' + data[i].name + '</option>';
                             }
                		   A.one('#<portlet:namespace/>doGroupId').html(groupOptions);
                           A.one('#<portlet:namespace/>doGroupId').set('disabled', false);
                	   }
                	   <portlet:namespace/>loadingMask.hide();
                   },
                   failure:function(){
						A.one('#<portlet:namespace/>doGroupId').html("");
						A.one('#<portlet:namespace/>doGroupId').set('disabled', true);  
						<portlet:namespace/>loadingMask.hide();
                   }
                 }
	 		}
		 );
	 } else {
		A.one('#<portlet:namespace/>doGroupId').html("");
		A.one('#<portlet:namespace/>doGroupId').set('disabled', true);
	 }
});
		});
		</aui:script>


<%
}else{
arrayTaskIds = arrayTaskIds + "]";
}
%>
</liferay-ui:tabs>
<aui:script>
var arrayTaskList = <%=arrayTaskIds%>;
Liferay.provide(
		window,
		'<portlet:namespace />pickDefaultTaskMap',
		function() {	

			for(id in arrayTaskList) {
				var chks = document.querySelectorAll("input[type='checkbox'][value='" + arrayTaskList[id] + "']");
				chks[0].checked=true;
			}
		},
		['liferay-util-list-fields']
	);
	
	Liferay.provide(
		window,
		'<portlet:namespace />updateTaskCustomerMap',
		function() {	
			document.<portlet:namespace />TaskMapForm.<portlet:namespace />addTaskMapIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />TaskMapForm, '<portlet:namespace />allRowIds');
			submitForm(document.<portlet:namespace />TaskMapForm);
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