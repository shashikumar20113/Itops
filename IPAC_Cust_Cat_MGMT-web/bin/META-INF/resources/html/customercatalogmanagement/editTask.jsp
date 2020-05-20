<%-- Copyright (c) 2016 lti. All rights reserved.--%>

<%--  @author Sunilkumar Prabhakar --%>


 
<%@ include file="init.jsp"%>

<%
	TTDPSPTaskCustomerMap tTDPSPTaskCustomerMap = null;
	Task task = null;
	

	long tTDPSPTaskCustomerId = ParamUtil.getLong(renderRequest,"tTDPSPTaskCustomerId", 0);
	
	long towerCustomerId = ParamUtil.getLong(renderRequest,	"towerCustomerId", 0);
	long tTechnologyCustomerId = ParamUtil.getLong(renderRequest,"tTechnologyCustomerId", 0);
	long tTDeliverableCustomerId = ParamUtil.getLong(renderRequest,"tTDeliverableCustomerId", 0);
	long tTDProcessCustomerId = ParamUtil.getLong(renderRequest,"tTDProcessCustomerId", 0);
	long tTDPSubProcessCustomerId = ParamUtil.getLong(renderRequest,"tTDPSubProcessCustomerId", 0);
	
	
Organization project=null;
	

	try {
		tTDPSPTaskCustomerMap = TTDPSPTaskCustomerMapLocalServiceUtil
				.getTTDPSPTaskCustomerMap(tTDPSPTaskCustomerId);
		
				
	} catch (Exception e) {
		log("IPAC : Error while fetching TTDPSPTaskCustomer map for TTDPSPTaskCustomerMap id "	+ tTDPSPTaskCustomerId, e);
		}
	
	
	try {
		task = TaskLocalServiceUtil.getTask(tTDPSPTaskCustomerMap.getTaskId());
	} catch (Exception e) {
		log("IPAC : Error while fetching DPSPTask for taskId: "	+ tTDPSPTaskCustomerMap.getTaskId(), e);
	}
	
if (tTDPSPTaskCustomerMap == null) {
		SessionErrors.add(renderRequest,"no-tTDPSubProcessCustomerMap-found");
%>
<liferay-ui:error key="no-tTDPSubProcessCustomerMap-found"
	message="invalid-tTDPSubProcessCustomerMap" />
<aui:button icon="left-arrow" href="<%=homeURL%>" value="back"></aui:button>
<%
	} else {
		try
		{
			project=OrganizationLocalServiceUtil.getOrganization(tTDPSPTaskCustomerMap.getOrganizationId());
		}
		catch(Exception e)
		{
			log("IPAC : Error while fetching organization for organization id " + tTDPSPTaskCustomerMap.getOrganizationId(), e);		
		}	
		if(project==null)
		{
			SessionErrors.add(renderRequest,"no-project-found");

			%>
			<liferay-ui:error key="no-project-found"
	message="invalid-project" />
<aui:button icon="left-arrow" href="<%=homeURL%>" value="back"></aui:button>
			<%
		}
		else
		{
		if ( ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project) ) {
%>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageTask.jsp" />
	<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
	<portlet:param name="tTechnologyCustomerId" value="<%=String.valueOf(tTechnologyCustomerId)%>" />
	<portlet:param name="tTDeliverableCustomerId" value="<%=String.valueOf(tTDeliverableCustomerId)%>" />
	<portlet:param name="tTDProcessCustomerId" value="<%=String.valueOf(tTDProcessCustomerId)%>" />
	<portlet:param name="tTDPSubProcessCustomerId" value="<%=String.valueOf(tTDPSubProcessCustomerId)%>" />
	<portlet:param name="tTDPSubProcessId" value="<%=String.valueOf(tTDPSPTaskCustomerMap.getTTDPSubProcessId())%>" />
</portlet:renderURL>

<liferay-ui:header backURL="<%=backURL%>" title="<%=LanguageUtil.format(request,\"edit-x\", task.getName())%>" cssClass="cust_header"/>
	
<portlet:actionURL var="editTTDPSPTaskCustomerURL" name="editTTDPSPTaskCustomerMap">
		<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageTask.jsp" />
		<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
		<portlet:param name="tTechnologyCustomerId" value="<%=String.valueOf(tTechnologyCustomerId)%>" />
		<portlet:param name="tTDeliverableCustomerId" value="<%=String.valueOf(tTDeliverableCustomerId)%>" />
		<portlet:param name="tTDProcessCustomerId" value="<%=String.valueOf(tTDProcessCustomerId)%>" />
		<portlet:param name="tTDPSubProcessCustomerId" value="<%=String.valueOf(tTDPSubProcessCustomerId)%>" />
		<portlet:param name="tTDPSubProcessId" value="<%=String.valueOf(tTDPSPTaskCustomerMap.getTTDPSubProcessId())%>" />
		<portlet:param name="tTDPSPTaskCustomerId"	value="<%=String.valueOf(tTDPSPTaskCustomerMap.getTTDPSPTaskCustomerId())%>" />
</portlet:actionURL>

<aui:form name="updateTitle" action="<%=editTTDPSPTaskCustomerURL%>">
	<aui:model-context bean="<%=tTDPSPTaskCustomerMap%>"	model="<%=TTDPSPTaskCustomerMap.class%>" />
	<aui:fieldset>
			<aui:input name="task-name" label="task-name" type="text" value="<%=task.getName() %>" disabled="true"></aui:input>
	
		<aui:input name="name" label="name"></aui:input>
		<%
				Organization group=null;
				try
				{
					group=OrganizationLocalServiceUtil.getOrganization(tTDPSPTaskCustomerMap.getDoGroupId());
				}
				catch(Exception e)
				{
					log("IPAC : Error while fetching organization for organization id " + tTDPSPTaskCustomerMap.getDoGroupId(), e);	
				}
			if(group==null)
			{
		%>
		
		<div id="treeviewBreadcrumbDivId">
	<c:if test="<%=companyOrg!=null %>">
	<span class="treeview-breadcrumb" data-orgId="<%=companyOrgID%>" onclick="javascript:getCorrespondingOUAndCompentency(this);"><%=companyOrg.getName() %></span>
	</c:if>
</div>
		<aui:row>
<aui:col width="30">
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
<aui:col width="30">
				<aui:select label="competency" name="competencyId" disabled="true"></aui:select>
</aui:col>
<aui:col width="30">
		<aui:select label="group" name="doGroupId" disabled="true"></aui:select>
</aui:col>
</aui:row>
	<%
			}
			else
			{
				Organization competency=group.getParentOrganization();
				Organization ou=competency.getParentOrganization();
				List<Organization> hOUs=new ArrayList<Organization>();
				Organization cOU=ou.getParentOrganization();
				while(true)
				{
					if(cOU.getOrganizationId()==companyOrgID || !cOU.getType().equalsIgnoreCase(CustomerConstants.TYPE_OU))
					{
						break;
					}
					
					hOUs.add(cOU);
					cOU=cOU.getParentOrganization();
				}
				%>
						
		<div id="treeviewBreadcrumbDivId">
	<c:if test="<%=companyOrg!=null %>">
	<span class="treeview-breadcrumb" data-orgId="<%=companyOrgID%>" onclick="javascript:getCorrespondingOUAndCompentency(this);"><%=companyOrg.getName() %></span>
	<%
		for(int i=hOUs.size()-1;i>=0;i--)
		{
			%>
			<span class="treeview-breadcrumb" data-orgId="<%=hOUs.get(i).getOrganizationId() %>" onclick="javascript:getCorrespondingOUAndCompentency(this);"><%=hOUs.get(i).getName() %></span>
			<%
		}
	
	%>
	</c:if>
</div>
		<aui:row>
<aui:col width="30">
<aui:select label="OU" name="ouId" showEmptyOption="true" >
					<%
						List<Organization> ous=OrganizationLocalServiceUtil.search(themeDisplay.getCompanyId(), cOU.getOrganizationId(), null, CustomerConstants.TYPE_OU, null, null, null, QueryUtil.ALL_POS,QueryUtil.ALL_POS);
						for(Organization org:ous)
						{
							if(org.getStatusId()==ListTypeConstants.ORGANIZATION_STATUS_DEFAULT)
							{
								
								
								
								if(org.getOrganizationId()==ou.getOrganizationId())
								{
								
									
									
									
					%>
										<aui:option value="<%=org.getOrganizationId() %>" selected="true"><%=org.getName() %></aui:option>
					<%
							}else
							{
								%>
							<aui:option value="<%=org.getOrganizationId() %>" ><%=org.getName() %></aui:option>	
								<%
							}
							}
						}
					%>
				</aui:select>
</aui:col>
<aui:col width="30">
				<aui:select label="competency" name="competencyId" showEmptyOption="true">
				<%
						List<Organization> competencies=OrganizationLocalServiceUtil.search(themeDisplay.getCompanyId(), ou.getOrganizationId(), null, CustomerConstants.TYPE_COMPETENCY, null, null, null, QueryUtil.ALL_POS,QueryUtil.ALL_POS);
						for(Organization org:competencies)
						{
							if(org.getStatusId()==ListTypeConstants.ORGANIZATION_STATUS_DEFAULT)
							{
								if(org.getOrganizationId()==competency.getOrganizationId())
								{
					%>
							<aui:option value="<%=org.getOrganizationId() %>"   selected="true"><%=org.getName() %></aui:option>
					<%
							}else
							{
								%>
							<aui:option value="<%=org.getOrganizationId() %>" ><%=org.getName() %></aui:option>	
								<%
							}
							}
						}
					%>
				</aui:select>
</aui:col>
<aui:col width="30">
		<aui:select label="group" name="doGroupId" showEmptyOption="true">
		<%
						List<Organization> groups=OrganizationLocalServiceUtil.search(themeDisplay.getCompanyId(), competency.getOrganizationId(), null, CustomerConstants.TYPE_GROUP, null, null, null, QueryUtil.ALL_POS,QueryUtil.ALL_POS);
						for(Organization org:groups)
						{
							if(org.getStatusId()==ListTypeConstants.ORGANIZATION_STATUS_DEFAULT)
							{
								if(org.getOrganizationId()==group.getOrganizationId())
								{
					%>
							<aui:option value="<%=org.getOrganizationId() %>"  selected="true"><%=org.getName() %></aui:option>
					<%
							}else
							{
								%>
							<aui:option value="<%=org.getOrganizationId() %>"><%=org.getName() %></aui:option>	
								<%
							}
							}
						}
					%>
		</aui:select>
</aui:col>
</aui:row>
				
				<%
				
			}
	%>
		<aui:select label="status" listTypeFieldName="statusId"	name="statusId" listType="<%=CCStatus.STATUS_LIST_TYPE%>"></aui:select>
	</aui:fieldset>
	<aui:button-row>	
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" href="<%=backURL%>"></aui:button>
	</aui:button-row>
</aui:form>

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
	} else {
		SessionErrors.add(renderRequest, PrincipalException.class);
%>
<liferay-ui:error exception="<%=PrincipalException.class%>"
	message="permission-denied" />
<aui:button icon="left-arrow" href="<%=homeURL%>" value="back"></aui:button>

<%
	}
	}
	}
%>