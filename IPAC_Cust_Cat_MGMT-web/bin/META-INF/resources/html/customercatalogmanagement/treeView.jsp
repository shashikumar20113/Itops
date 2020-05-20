<%-- Copyright (c) 2016 lti. All rights reserved.--%>

<%--  @author Rajkumar K, Balavigneshwaran M --%>


<%@ include file="init.jsp"%>

<portlet:resourceURL var="getDataList">
	<portlet:param name="<%=Constants.CMD %>" value="getDataList"/>
</portlet:resourceURL>

<portlet:resourceURL var="getDataListOfSelectedOptions">
	<portlet:param name="<%=Constants.CMD %>" value="getDataListOfSelectedOptions"/>
</portlet:resourceURL>

<portlet:resourceURL var="getCatalogElementsCount">
	<portlet:param name="<%=Constants.CMD %>" value="getCatalogElementsCount"/>
</portlet:resourceURL>

<portlet:renderURL var="backURLCustomer">
	<portlet:param name="mvcPath" value="/html/customercatalogmanagement/view.jsp"/>
</portlet:renderURL>
		

<%

	long customerId = ParamUtil.getLong(request, "customerId",0);
	long projectId = ParamUtil.getLong(request, "projectId",0);
	long technologyId = ParamUtil.getLong(request, "technologyId");
	long deliverableId = ParamUtil.getLong(request, "deliverableId");
	long processId = ParamUtil.getLong(request, "processId");
	long subprocessId = ParamUtil.getLong(request, "subprocessId");
	long towerCustomerMapId = ParamUtil.getLong(request, "towerCustomerId",0);
	long tTechnologyCustomerMapId = ParamUtil.getLong(request, "tTechnologyCustomerMapId",0); 
	long tTDeliverableCustomerMapId = ParamUtil.getLong(request, "tTDeliverableCustomerMapId",0);
	long tTDProcessCustomerMapId = ParamUtil.getLong(request, "tTDProcessCustomerMapId",0);
	long tTDPSubProcessCustomerMapId = ParamUtil.getLong(request, "tTDPSubProcessCustomerMapId",0); 
	
	Organization project = null;
	Organization customer = null;
	TowerCustomerMap tcm = null;
	TTechnologyCustomerMap ttcm = null;
	TTDeliverableCustomerMap ttdcm = null;
	TTDProcessCustomerMap ttdpcm = null;
	TTDPSubProcessCustomerMap ttdpscm = null;
	TTDPSPTaskCustomerMap ttdpstcm = null;
	int operation=0;

	if(customerId != 0) {
		
		operation = 7;
		
		customer = OrganizationLocalServiceUtil.getOrganization(customerId);
		
	}	
	if(projectId != 0) {
		
		operation = 1;
		
		project = OrganizationLocalServiceUtil.getOrganization(projectId);
		
	}
	if(towerCustomerMapId != 0) {
		
		operation = 2;
		
		tcm = TowerCustomerMapLocalServiceUtil.getTowerCustomerMap(towerCustomerMapId);
		
	}
	if(tTechnologyCustomerMapId != 0) {
		
		operation = 3;
		
		ttcm = TTechnologyCustomerMapLocalServiceUtil.getTTechnologyCustomerMap(tTechnologyCustomerMapId);

	}
	if(tTDeliverableCustomerMapId != 0) {
		
		operation = 4;
		
		ttdcm = TTDeliverableCustomerMapLocalServiceUtil.getTTDeliverableCustomerMap(tTDeliverableCustomerMapId);
		
	}
	if(tTDProcessCustomerMapId != 0) { 
		
		operation = 5;
		
		ttdpcm = TTDProcessCustomerMapLocalServiceUtil.getTTDProcessCustomerMap(tTDProcessCustomerMapId);
		
	}
	if(tTDPSubProcessCustomerMapId != 0) {
		
		operation = 6;
		
		ttdpscm = TTDPSubProcessCustomerMapLocalServiceUtil.getTTDPSubProcessCustomerMap(tTDPSubProcessCustomerMapId);
		
	}

	switch(operation) {

	case 1: 

%>
		<portlet:renderURL var="backURLProject">
			<portlet:param name="mvcPath" value="/html/customercatalogmanagement/viewProjects.jsp"/>
			<portlet:param name="organizationId" value="<%=String.valueOf(project.getParentOrganizationId()) %>"/>
		</portlet:renderURL>
		
		<liferay-ui:header backURL="<%=backURLProject%>" title="<%=LanguageUtil.format(request, \"customer-catalog-view-x-x\",new Object[]{customer.getName(),project.getName()})%>" cssClass="cust_header" />

<%
		break;

	case 2:
		
%>

		<portlet:renderURL var="backURLDomain">
			<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageTower.jsp"/>
			<portlet:param name="organizationId" value="<%=String.valueOf(project.getOrganizationId()) %>"/>
		</portlet:renderURL>
		
		<liferay-ui:header backURL="<%=backURLDomain%>" title="<%=LanguageUtil.format(request, \"customer-catalog-view-x-x-x\",new Object[]{customer.getName(),project.getName(),tcm.getName(themeDisplay.getLocale())})%>" cssClass="cust_header"/>
		
<% 		
		break;
	
	case 3:
		
%>
		<portlet:renderURL var="backURLTechnology">
			<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageTechnology.jsp"/>
			<portlet:param name="organizationId" value="<%=String.valueOf(project.getOrganizationId()) %>"/>
			<portlet:param name="towerId" value="<%=String.valueOf(tcm.getTowerId()) %>"/>
			<portlet:param name="towerCustomerId" value="<%=String.valueOf(tcm.getTowerCustomerId()) %>"/>
		</portlet:renderURL>
		
		<liferay-ui:header backURL="<%=backURLTechnology%>" title="<%=LanguageUtil.format(request, \"customer-catalog-view-x-x-x-x\",new Object[]{customer.getName(),project.getName(),tcm.getName(themeDisplay.getLocale()),ttcm.getName(themeDisplay.getLocale())})%>" cssClass="cust_header" />

<% 		
		break;
	
	case 4:
		
%>
		<portlet:renderURL var="backURLDeliverable">
			<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageDeliverable.jsp"/>
			<portlet:param name="organizationId" value="<%=String.valueOf(project.getOrganizationId()) %>"/>
			<portlet:param name="towerId" value="<%=String.valueOf(tcm.getTowerId()) %>"/>
			<portlet:param name="towerCustomerId" value="<%=String.valueOf(tcm.getTowerCustomerId()) %>"/>
			<portlet:param name="towerTechnologyId" value="<%=String.valueOf(ttcm.getTowerTechnologyId()) %>"/>
			<portlet:param name="technologyId" value="<%=String.valueOf(technologyId) %>"/>
			<portlet:param name="tTechnologyCustomerId" value="<%=String.valueOf(ttcm.getTTechnologyCustomerId()) %>"/>
		</portlet:renderURL>
		
		<liferay-ui:header backURL="<%=backURLDeliverable%>" title="<%=LanguageUtil.format(request, \"customer-catalog-view-x-x-x-x-x\",new Object[]{customer.getName(),project.getName(),tcm.getName(themeDisplay.getLocale()),ttcm.getName(themeDisplay.getLocale()),ttdcm.getName(themeDisplay.getLocale())})%>" cssClass="cust_header"/>

<% 		
		break;
	
	case 5:
		
%>
	
		<portlet:renderURL var="backURLProcess">
			<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageProcess.jsp"/>
			<portlet:param name="organizationId" value="<%=String.valueOf(project.getOrganizationId()) %>"/>
			<portlet:param name="towerId" value="<%=String.valueOf(tcm.getTowerId()) %>"/>
			<portlet:param name="towerCustomerId" value="<%=String.valueOf(tcm.getTowerCustomerId()) %>"/>
			<portlet:param name="towerTechnologyId" value="<%=String.valueOf(ttcm.getTowerTechnologyId()) %>"/>
			<portlet:param name="technologyId" value="<%=String.valueOf(technologyId) %>"/>
			<portlet:param name="tTechnologyCustomerId" value="<%=String.valueOf(ttcm.getTTechnologyCustomerId()) %>"/>
			<portlet:param name="deliverableId" value="<%=String.valueOf(deliverableId) %>"/>
			<portlet:param name="tTDeliverableId" value="<%=String.valueOf(ttdcm.getTTDeliverableId()) %>"/>
			<portlet:param name="tTDeliverableCustomerId" value="<%=String.valueOf(ttdcm.getTTDeliverableCustomerId()) %>"/>
		</portlet:renderURL>
		
		<liferay-ui:header backURL="<%=backURLProcess%>" title="<%=LanguageUtil.format(request, \"customer-catalog-view-x-x-x-x-x-x\",new Object[]{customer.getName(),project.getName(),tcm.getName(themeDisplay.getLocale()),ttcm.getName(themeDisplay.getLocale()),ttdcm.getName(themeDisplay.getLocale()),ttdpcm.getName(themeDisplay.getLocale())})%>" cssClass="cust_header"/>
		
<% 		
		break;
	
	case 6:
		
%>

		<portlet:renderURL var="backURLSubProcess">
			<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageSubProcess.jsp"/>
			<portlet:param name="organizationId" value="<%=String.valueOf(project.getOrganizationId()) %>"/>
			<portlet:param name="towerId" value="<%=String.valueOf(tcm.getTowerId()) %>"/>
			<portlet:param name="towerCustomerId" value="<%=String.valueOf(tcm.getTowerCustomerId()) %>"/>
			<portlet:param name="towerTechnologyId" value="<%=String.valueOf(ttcm.getTowerTechnologyId()) %>"/>
			<portlet:param name="technologyId" value="<%=String.valueOf(technologyId) %>"/>
			<portlet:param name="tTechnologyCustomerId" value="<%=String.valueOf(ttcm.getTTechnologyCustomerId()) %>"/>
			<portlet:param name="deliverableId" value="<%=String.valueOf(deliverableId) %>"/>
			<portlet:param name="tTDeliverableId" value="<%=String.valueOf(ttdcm.getTTDeliverableId()) %>"/>
			<portlet:param name="tTDeliverableCustomerId" value="<%=String.valueOf(ttdcm.getTTDeliverableCustomerId()) %>"/>
			<portlet:param name="processId" value="<%=String.valueOf(processId) %>"/>
			<portlet:param name="tTDProcessId" value="<%=String.valueOf(ttdpcm.getTTDProcessId()) %>"/>
			<portlet:param name="tTDProcessCustomerId" value="<%=String.valueOf(ttdpcm.getTTDProcessCustomerId()) %>"/>
		</portlet:renderURL>
		
		<liferay-ui:header backURL="<%=backURLSubProcess%>" title="<%=LanguageUtil.format(request, \"customer-catalog-view-x-x-x-x-x-x\",new Object[]{customer.getName(),project.getName(),tcm.getName(themeDisplay.getLocale()),ttcm.getName(themeDisplay.getLocale()),ttdcm.getName(themeDisplay.getLocale()),ttdpcm.getName(themeDisplay.getLocale())})%>" cssClass="cust_header" />
	
<%

		break;

	case 7: 

%>
		<liferay-ui:header backURL="<%=backURLCustomer%>" title="<%=LanguageUtil.format(request, \"customer-catalog-view-x\",new Object[]{customer.getName()})%>" cssClass="cust_header" />

<%
		break;

	default:
	
%>

		<liferay-ui:header backURL="<%=backURLCustomer%>" title="<%=LanguageUtil.format(request, \"customer-catalog-view\",new Object[]{})%>" cssClass="cust_header" />
<%
		
		break;

	}
	
%>

<% 
	
	// Permission checker
	
	if((customer ==  null && project == null && !CatalogPermission.isCompanyCompleteViewer(themeDisplay, companyOrg)) || (customer != null && project == null && !CatalogPermission.isCustomerCompleteViewer(themeDisplay, customer)) || (customer != null && project != null && !CatalogPermission.isProjectCompleteViewer(themeDisplay, project)))
	{
		
		SessionErrors.add(renderRequest, PrincipalException.class);
		
%>

		<liferay-ui:error exception="<%=PrincipalException.class%>" message="permission-denied" />
		
		<aui:button icon="left-arrow" href="<%=homeURL%>" value="back"></aui:button>

<%
	
		return;

	}

%>

	<div class ="selectOptions">
	
		 <aui:row>
	        <aui:fieldset>
	        	 <aui:col width="20">
	        	 
	        	 <%
	        	 	
	        	 	if(customer != null) {
	        
	        	 %>
	        	 
	        	 	<aui:select name="customers" label="customer" disabled="true" id="customers">
	        	 
	        	 		<aui:option value="<%=customer.getOrganizationId() %>"><%=customer.getName() %></aui:option>
	        	 		
	        	 	</aui:select>
	        	 
	        	 <%
	        	 	}
	        	 	else {
	        	 		
	        	 		List<Organization> customers = CustomerCatalogUtil.getCompanyCustomers(themeDisplay, companyOrg);
	        	 		
	        	 %>

	        	 	<aui:select name="customers" label="customer" id="customers" showEmptyOption="true">
	        	 		
	        	 <%
	        	 
	        	 		for(Organization cust : customers) {
	        	 
	        	 %>		
	        	 			<aui:option value="<%=cust.getOrganizationId() %>"><%=cust.getName() %></aui:option>
	        	 	
	        	 <%
	        	 
	        	 		}
	        	 
	        	 %>
	        	 	</aui:select>
	        		 
	        	<% 
	        	
	        	 	}
	        	 
	        	 %>
	        	 
	        	 </aui:col>
	        	 
	        	 <aui:col width="20">
	        	 
	        	 <%
	        	 	
	        	 	if(project != null) {
	        
	        	 %>
	        	 
	        	 	<aui:select name="projects" label="project" disabled="true" id="projects" >
	        	 
	        	 		<aui:option value="<%=project.getOrganizationId() %>"><%=project.getName() %></aui:option>
	        	 		
	        	 	</aui:select>
	        	 
	        	 <%
	        	 	}
	        	 	else if(customer != null) {
	        	 		
	        	 		List<Organization> projects = CustomerCatalogUtil.getCustomerProjects(themeDisplay, customer);
	        	 		
	        	 %>
	        	 
	        	 		<aui:select name="projects" label="project" id="projects" showEmptyOption="true">
	        	 		
	        	 <%
	        	 
	        	 			for(Organization proj : projects) {
	        	 
	        	 %>		
	        	 				<aui:option value="<%=proj.getOrganizationId() %>"><%=proj.getName() %></aui:option>
	        	 	
	        	 <%
	        	 
	        	 			}
	        	 
	        	 %>
	        	 		
	        	 		</aui:select>
	        		 
	        	<% 
	        	
	        	 	}
	        	 	else {
	        	 
	        	 %>
	        	 
	        	 		<aui:select name="projects" label="project" disabled="true" id="projects" >
	        	 		
	        	 		</aui:select>
	        	 
	        	 <%
	        	 
	        	 	}
	        	 
	        	 %>
	        	 
	        	 </aui:col>
	        	 
	        	 	 <aui:col width="20">
	        	 
	        	 <%
	        	 	
	        	 	if(tcm != null) {
	        
	        	 %>
	        	 
	        	 	<aui:select name="towers" label="tower" disabled="true" id="towers" >
	        	 
	        	 		<aui:option value="<%=tcm.getTowerCustomerId() %>"><%=tcm.getName(themeDisplay.getLocale()) %></aui:option>
	        	 		
	        	 	</aui:select>
	        	 
	        	 <%
	        	 	}
	        	 	else if(project != null) {
	        	 		
	        	 		List<TowerCustomerMap> tcms = CustomerCatalogUtil.getTowerCustomerMapsByProject(project);
	        	 		
	        	 %>
	        	 
	        	 		<aui:select name="towers" label="tower" id="towers" showEmptyOption="true">
	        	 		
	        	 <%
	        	 
	        	 			for(TowerCustomerMap tcm1 : tcms) {
	        	 
	        	 %>		
	        	 				<aui:option value="<%=tcm1.getTowerCustomerId() %>"><%=tcm1.getName(themeDisplay.getLocale()) %></aui:option>
	        	 	
	        	 <%
	        	 
	        	 			}
	        	 
	        	 %>
	        	 		
	        	 		</aui:select>
	        		 
	        	<% 
	        	
	        	 	}
	        	 	else {
	        	 
	        	 %>
	        	 
	        	 		<aui:select name="towers" label="tower" disabled="true" id="towers" >
	        	 		
	        	 		</aui:select>
	        	 
	        	 <%
	        	 
	        	 	}
	        	 
	        	 %>
	        	 
	        	</aui:col>
	        	
	        	<aui:col width="20">
	        	 
	        	 <%
	        	 	
	        	 	if(ttcm != null) {
	        
	        	 %>
	        	 
	        	 	<aui:select name="technologies" label="technology" disabled="true" id="technologies" >
	        	 
	        	 		<aui:option value="<%=ttcm.getTTechnologyCustomerId() %>"><%=ttcm.getName(themeDisplay.getLocale()) %></aui:option>
	        	 		
	        	 	</aui:select>
	        	 
	        	 <%
	        	 	}
	        	 	else if(tcm != null) {
	        	 		
	        	 		List<TTechnologyCustomerMap> ttcms = CustomerCatalogUtil.getTTechnologyCustomerMapsByTower(tcm);
	        	 		
	        	 %>
	        	 
	        	 		<aui:select name="technologies" label="technology" id="technologies" showEmptyOption="true">
	        	 		
	        	 <%
	        	 
	        	 			for(TTechnologyCustomerMap ttcm1 : ttcms) {
	        	 
	        	 %>		
	        	 				<aui:option value="<%=ttcm1.getTTechnologyCustomerId() %>"><%=ttcm1.getName(themeDisplay.getLocale()) %></aui:option>
	        	 	
	        	 <%
	        	 
	        	 			}
	        	 
	        	 %>
	        	 		
	        	 		</aui:select>
	        		 
	        	<% 
	        	
	        	 	}
	        	 	else {
	        	 
	        	 %>
	        	 
	        	 		<aui:select name="technologies" label="technology" disabled="true" id="technologies" >
	        	 		
	        	 		</aui:select>
	        	 
	        	 <%
	        	 
	        	 	}
	        	 
	        	 %>
	        	 
	        	</aui:col>
	        	</aui:fieldset> 
	    </aui:row>
	    <aui:row>
	    <aui:fieldset>
	    		<aui:col width="20">
	        	 
	        	 <%
	        	 	
	        	 	if(ttdcm != null) {
	        
	        	 %>
	        	 
	        	 	<aui:select name="deliverables" label="deliverable" disabled="true" id="deliverables" >
	        	 
	        	 		<aui:option value="<%=ttdcm.getTTDeliverableCustomerId() %>"><%=ttdcm.getName(themeDisplay.getLocale()) %></aui:option>
	        	 		
	        	 	</aui:select>
	        	 
	        	 <%
	        	 	}
	        	 	else if(ttcm != null) {
	        	 		
	        	 		List<TTDeliverableCustomerMap> ttdcms = CustomerCatalogUtil.getTTDeliverableCustomerMapsByTTechnology(ttcm);
	        	 		
	        	 %>
	        	 
	        	 		<aui:select name="deliverables" label="deliverable" id="deliverables" showEmptyOption="true">
	        	 		
	        	 <%
	        	 
	        	 			for(TTDeliverableCustomerMap ttdcm1 : ttdcms) {
	        	 
	        	 %>		
	        	 				<aui:option value="<%=ttdcm1.getTTDeliverableCustomerId() %>"><%=ttdcm1.getName(themeDisplay.getLocale()) %></aui:option>
	        	 	
	        	 <%
	        	 
	        	 			}
	        	 
	        	 %>
	        	 		
	        	 		</aui:select>
	        		 
	        	<% 
	        	
	        	 	}
	        	 	else {
	        	 
	        	 %>
	        	 
	        	 		<aui:select name="deliverables" label="deliverable" disabled="true" id="deliverables" >
	        	 		
	        	 		</aui:select>
	        	 
	        	 <%
	        	 
	        	 	}
	        	 
	        	 %>
	        	 
	        	</aui:col>
	    
	    		<aui:col width="20">
	        	 
	        	 <%
	        	 	
	        	 	if(ttdpcm != null) {
	        
	        	 %>
	        	 
	        	 	<aui:select name="processes" label="process" disabled="true" id="processes" >
	        	 
	        	 		<aui:option value="<%=ttdpcm.getTTDProcessCustomerId() %>"><%=ttdpcm.getName(themeDisplay.getLocale()) %></aui:option>
	        	 		
	        	 	</aui:select>
	        	 
	        	 <%
	        	 	}
	        	 	else if(ttdcm != null) {
	        	 		
	        	 		List<TTDProcessCustomerMap> ttdpcms = CustomerCatalogUtil.getTTDProcessCustomerMapsByTTDeliverable(ttdcm);
	        	 		
	        	 %>
	        	 
	        	 		<aui:select name="processes" label="process" id="processes" showEmptyOption="true">
	        	 		
	        	 <%
	        	 
	        	 			for(TTDProcessCustomerMap ttdpcm1 : ttdpcms) {
	        	 
	        	 %>		
	        	 				<aui:option value="<%=ttdpcm1.getTTDProcessCustomerId() %>"><%=ttdpcm1.getName(themeDisplay.getLocale()) %></aui:option>
	        	 	
	        	 <%
	        	 
	        	 			}
	        	 
	        	 %>
	        	 		
	        	 		</aui:select>
	        		 
	        	<% 
	        	
	        	 	}
	        	 	else {
	        	 
	        	 %>
	        	 
	        	 		<aui:select name="processes" label="process" disabled="true" id="processes" >
	        	 		
	        	 		</aui:select>
	        	 
	        	 <%
	        	 
	        	 	}
	        	 
	        	 %>
	        	 
	        	</aui:col>
	        	
	        	<aui:col width="20">
	        	 
	        	 <%
	        	 	
	        	 	if(ttdpscm != null) {
	        
	        	 %>
	        	 
	        	 	<aui:select name="subProcesses" label="sub-process" disabled="true" id="subProcesses">
	        	 
	        	 		<aui:option value="<%=ttdpscm.getTTDPSubProcessCustomerId() %>"><%=ttdpscm.getName(themeDisplay.getLocale()) %></aui:option>
	        	 		
	        	 	</aui:select>
	        	 
	        	 <%
	        	 	}
	        	 	else if(ttdpcm != null) {
	        	 		
	        	 		List<TTDPSubProcessCustomerMap> ttdpscms = CustomerCatalogUtil.getTTDSubProcessCustomerMapsByTTDProcess(ttdpcm);
	        	 		
	        	 %>
	        	 
	        	 		<aui:select name="subProcesses" label="sub-process" id="subProcesses" showEmptyOption="true">
	        	 		
	        	 <%
	        	 
	        	 			for(TTDPSubProcessCustomerMap ttdpscm1 : ttdpscms) {
	        	 
	        	 %>		
	        	 				<aui:option value="<%=ttdpscm1.getTTDPSubProcessCustomerId() %>"><%=ttdpscm1.getName(themeDisplay.getLocale()) %></aui:option>
	        	 	
	        	 <%
	        	 
	        	 			}
	        	 
	        	 %>
	        	 		
	        	 		</aui:select>
	        		 
	        	<% 
	        	
	        	 	}
	        	 	else {
	        	 
	        	 %>
	        	 
	        	 		<aui:select name="subProcesses" label="sub-process" disabled="true" id="subProcesses" >
	        	 		
	        	 		</aui:select>
	        	 
	        	 <%
	        	 
	        	 	}
	        	 
	        	 %>
	        	 
	        	</aui:col>
	    
	    		</aui:fieldset>
	    		
	          		
	          		
	          	
	    
	    </aui:row>
	   <aui:button-row>
	<aui:button type='button' cssClass="viewBtn"  name='view' value="view" onClick="fetchDataListOfSelectedOptions(),fetchCatalogElementsCount();"/>
	</aui:button-row>
	</div>
	
 		<!-- Dashboard code added by Moneekaparvathy Jagadhesan -->

<aui:row>
	
	<aui:col id="summary_view" span="3" cssClass="summary hideDiv">
	
		<aui:row cssClass="dom_class my_row">
			<aui:col id="dom_icon" cssClass="sum_icon" span="6" ></aui:col>	
			<aui:col span="6" cssClass="sum_info">
				<aui:row cssClass="sum_count"><div id="<portlet:namespace />dom_count" class="division"></div></aui:row>
		     	<aui:row cssClass="sum_text"><div id="<portlet:namespace />dom_label" class="division">Domain</div></aui:row>
			</aui:col>		
		</aui:row>
		
		<aui:row cssClass="tech_class my_row">
			<aui:col id="tech_icon" cssClass="sum_icon" span="6"></aui:col>
			<aui:col span="6" cssClass="sum_info">
				<aui:row cssClass="sum_count"><div id="<portlet:namespace />tech_count" class="division"></div></aui:row>
				<aui:row cssClass="sum_text"><div id="<portlet:namespace />tech_label" class="division">Technology</div></aui:row>
			</aui:col>			
		</aui:row>
		
		<aui:row cssClass="my_row deli_class">
			<aui:col id="deli_icon" cssClass="sum_icon" span="6"></aui:col>	
			<aui:col span="6" cssClass="sum_info">
				<aui:row cssClass="sum_count"><div id="<portlet:namespace />deli_count" class="division"></div></aui:row>
				<aui:row cssClass="sum_text"><div id="<portlet:namespace />deli_label" class="division">Deliverable</div></aui:row>
			</aui:col>		
		</aui:row>
		
		<aui:row cssClass="my_row proc_class">
			<aui:col id="proc_icon" cssClass="sum_icon" span="6"></aui:col>	
			<aui:col span="6" cssClass="sum_info">
				<aui:row cssClass="sum_count"><div id="<portlet:namespace />proc_count" class="division"></div></aui:row>
				<aui:row cssClass="sum_text"><div id="<portlet:namespace />proc_label" class="division">Process</div></aui:row>
			</aui:col>		
		</aui:row>
		
		<aui:row cssClass="my_row sproc_class">
			<aui:col id="sproc_icon" cssClass="sum_icon" span="6"></aui:col>		
			<aui:col span="6" cssClass="sum_info">
				<aui:row cssClass="sum_count"><div id="<portlet:namespace />sproc_count" class="division"></div></aui:row>
				<aui:row cssClass="sum_text"><div id="<portlet:namespace />sproc_label" class="division">Sub-Process</div></aui:row>
			</aui:col>	
		</aui:row>
		
		<aui:row cssClass="my_row task_class">
			<aui:col id="task_icon" cssClass="sum_icon" span="6"></aui:col>	
			<aui:col span="6" cssClass="sum_info">
				<aui:row cssClass="sum_count"><div id="<portlet:namespace />task_count" class="division"></div></aui:row>
				<aui:row cssClass="sum_text"><div id="<portlet:namespace />task_label" class="division">Task</div></aui:row>
			</aui:col>		
		</aui:row>
	</aui:col>
	
	<aui:col span="9"><div id="treeView"></div></aui:col>
	
</aui:row> 
	
	<aui:script use="aui-loading-mask-deprecated">
      
		var <portlet:namespace/>loadingMask = new A.LoadingMask({
		    'strings.loading': 'Loading...',
		    target: A.getBody(),
		    background: '#000'
		});
		
		AUI().ready('aui-io-request',function(A){ 
			
			A.one('#<portlet:namespace/>customers').on('change',function() {
				var customerId = this.val();
				A.one('#<portlet:namespace/>projects').html("");
				A.one('#<portlet:namespace/>towers').html("");
				A.one('#<portlet:namespace/>technologies').html("");
				A.one('#<portlet:namespace/>deliverables').html("");
				A.one('#<portlet:namespace/>processes').html("");
				A.one('#<portlet:namespace/>subProcesses').html("");
				A.one('#<portlet:namespace/>towers').set('disabled', true);
				A.one('#<portlet:namespace/>technologies').set('disabled', true);
				A.one('#<portlet:namespace/>deliverables').set('disabled', true);
				A.one('#<portlet:namespace/>processes').set('disabled', true);
				A.one('#<portlet:namespace/>subProcesses').set('disabled', true);
					if ((customerId !== '') && (customerId != 0)) {
						 <portlet:namespace/>loadingMask.show();
						 url='<%=getDataList %>'+'&<portlet:namespace/>customerId=' + customerId
			             A.io.request(url,{
			            	 dataType: 'json',
			                     cache:false, 
			                     on: {
			                       success: function() {
			                    	   var data=this.get('responseData');
			                    	   if(data==null || data ==""){
			                    		   A.one('#<portlet:namespace/>projects').set('disabled', true);
			                    	   }else{
			                    		   options = '<option value=""></option>';
			                    		   for (i = 0; i < data.length; i++) {
			                                   options += '<option value="' + data[i].projectId + '">' + data[i].name + '</option>';
			                                 }
			                    		   A.one('#<portlet:namespace/>projects').html(options);
			                               A.one('#<portlet:namespace/>projects').set('disabled', false);
			                    	   }
			                    	   <portlet:namespace/>loadingMask.hide();
			                       },
			                       failure:function() {
										A.one('#<portlet:namespace/>projects').html("");
										A.one('#<portlet:namespace/>projects').set('disabled', true);  
										<portlet:namespace/>loadingMask.hide(); 
			                      }
			                    }
					 		}
						 );
					 } else {
						A.one('#<portlet:namespace/>projects').html("");
						A.one('#<portlet:namespace/>projects').set('disabled', true);
					 }
			});
			
			A.one('#<portlet:namespace/>projects').on('change',function() {
				var projectId = this.val();
				A.one('#<portlet:namespace/>towers').html("");
				A.one('#<portlet:namespace/>technologies').html("");
				A.one('#<portlet:namespace/>deliverables').html("");
				A.one('#<portlet:namespace/>processes').html("");
				A.one('#<portlet:namespace/>subProcesses').html("");
				A.one('#<portlet:namespace/>technologies').set('disabled', true);
				A.one('#<portlet:namespace/>deliverables').set('disabled', true);
				A.one('#<portlet:namespace/>processes').set('disabled', true);
				A.one('#<portlet:namespace/>subProcesses').set('disabled', true);
					if ((projectId !== '') && (projectId != 0)) {
						 <portlet:namespace/>loadingMask.show();
						 url='<%=getDataList %>'+'&<portlet:namespace/>projectId=' + projectId
			             A.io.request(url,{
			            	 dataType: 'json',
			                     cache:false, 
			                     on: {
			                       success: function() {
			                    	   var data=this.get('responseData');
			                    	   if(data==null || data ==""){
			                    		   A.one('#<portlet:namespace/>towers').set('disabled', true);
			                    	   }else{
			                    		   options = '<option value=""></option>';
			                    		   for (i = 0; i < data.length; i++) {
			                                   options += '<option value="' + data[i].towerCustomerMapId + '">' + data[i].name + '</option>';
			                                 }
			                    		   A.one('#<portlet:namespace/>towers').html(options);
			                               A.one('#<portlet:namespace/>towers').set('disabled', false);
			                    	   }
			                    	   <portlet:namespace/>loadingMask.hide();
			                       },
			                       failure:function() {
										A.one('#<portlet:namespace/>towers').html("");
										A.one('#<portlet:namespace/>towers').set('disabled', true);  
										<portlet:namespace/>loadingMask.hide(); 
			                      }
			                    }
					 		}
						 );
					 } else {
						A.one('#<portlet:namespace/>towers').html("");
						A.one('#<portlet:namespace/>towers').set('disabled', true);
					 }
			});
			
			A.one('#<portlet:namespace/>towers').on('change',function() {
			var towerCustomerMapId = this.val();
			A.one('#<portlet:namespace/>technologies').html("");
			A.one('#<portlet:namespace/>deliverables').html("");
			A.one('#<portlet:namespace/>processes').html("");
			A.one('#<portlet:namespace/>subProcesses').html("");
			A.one('#<portlet:namespace/>deliverables').set('disabled', true);
			A.one('#<portlet:namespace/>processes').set('disabled', true);
			A.one('#<portlet:namespace/>subProcesses').set('disabled', true);
				if ((towerCustomerMapId !== '') && (towerCustomerMapId != 0)) {
					 <portlet:namespace/>loadingMask.show();
					 url='<%=getDataList %>'+'&<portlet:namespace/>towerCustomerMapId=' + towerCustomerMapId
		             A.io.request(url,{
		            	 dataType: 'json',
		                     cache:false, 
		                     on: {
		                       success: function() {
		                    	   var data=this.get('responseData');
		                    	   if(data==null || data ==""){
		                    		   A.one('#<portlet:namespace/>technologies').set('disabled', true);
		                    	   }else{
		                    		   options = '<option value=""></option>';
		                    		   for (i = 0; i < data.length; i++) {
		                                   options += '<option value="' + data[i].tTechnologyCustomerMapId + '">' + data[i].name + '</option>';
		                                 }
		                    		   A.one('#<portlet:namespace/>technologies').html(options);
		                               A.one('#<portlet:namespace/>technologies').set('disabled', false);
		                    	   }
		                    	   <portlet:namespace/>loadingMask.hide();
		                       },
		                       failure:function() {
									A.one('#<portlet:namespace/>technologies').html("");
									A.one('#<portlet:namespace/>technologies').set('disabled', true);  
									<portlet:namespace/>loadingMask.hide(); 
		                      }
		                    }
				 		}
					 );
				 } else {
					A.one('#<portlet:namespace/>technologies').html("");
					A.one('#<portlet:namespace/>technologies').set('disabled', true);
				 }
		});
						
			A.one('#<portlet:namespace/>technologies').on('change',function() {
				var tTechnologyCustomerMapId = this.val();
				A.one('#<portlet:namespace/>deliverables').html("");
		        A.one('#<portlet:namespace/>processes').html("");
		        A.one('#<portlet:namespace/>subProcesses').html("");
		        A.one('#<portlet:namespace/>processes').set('disabled', true);
		        A.one('#<portlet:namespace/>subProcesses').set('disabled', true);
				 
				 if ((tTechnologyCustomerMapId !== '') && (tTechnologyCustomerMapId!=0)) {
					 <portlet:namespace/>loadingMask.show();
					 url='<%=getDataList %>'+'&<portlet:namespace/>tTechnologyCustomerMapId=' + tTechnologyCustomerMapId
					 A.io.request(url,{
						 dataType: 'json',
		                     cache:false, 
		                     on: {
			                       success: function() {
			                    	   var data=this.get('responseData');
			                    	   if(data==null || data ==""){
			                    		   A.one('#<portlet:namespace/>deliverables').set('disabled', true);
			                    	   }else{
			                    		   options = '<option value=""></option>';
			                    		   for (i = 0; i < data.length; i++) {
			                                   options += '<option value="' + data[i].ttDeliverableCustomerMapId + '">' + data[i].name + '</option>';
			                                 }
			                    		   A.one('#<portlet:namespace/>deliverables').html(options);
			                               A.one('#<portlet:namespace/>deliverables').set('disabled', false);
			                    	   }
			                    	   <portlet:namespace/>loadingMask.hide();
			                       },
			                       failure:function(){
										A.one('#<portlet:namespace/>deliverables').html("");
										A.one('#<portlet:namespace/>deliverables').set('disabled', true);  
										<portlet:namespace/>loadingMask.hide();
			                       }
		                     }
				 		}
					 );
				 } else {
					A.one('#<portlet:namespace/>deliverables').html("");
					A.one('#<portlet:namespace/>deliverables').set('disabled', true);
				 }
			});
		
			A.one('#<portlet:namespace/>deliverables').on('change',function() {
				var ttDeliverableCustomerMapId = this.val();
				 A.one('#<portlet:namespace/>processes').html("");
		        A.one('#<portlet:namespace/>subProcesses').html("");
			    A.one('#<portlet:namespace/>subProcesses').set('disabled', true);
				 if ((ttDeliverableCustomerMapId !== '') && (ttDeliverableCustomerMapId!=0)) {
					 <portlet:namespace/>loadingMask.show();
					 url='<%=getDataList %>'+'&<portlet:namespace/>ttDeliverableCustomerMapId=' + ttDeliverableCustomerMapId
		             A.io.request(url,{
		            	 dataType: 'json',
		                     cache:false, 
		                     on: {
		                       success: function() {
		                    	   var data=this.get('responseData');
		                    	   if(data==null || data ==""){
		                    		   A.one('#<portlet:namespace/>processes').set('disabled', true);
		                    	   }else{
		                    		   options = '<option value=""></option>';
		                    		   for (i = 0; i < data.length; i++) {
		                                   options += '<option value="' + data[i].ttdProcessCustomerMapId + '">' + data[i].name + '</option>';
		                                 }
		                    		   A.one('#<portlet:namespace/>processes').html(options);
		                               A.one('#<portlet:namespace/>processes').set('disabled', false);
		                    	   }
		                    	   <portlet:namespace/>loadingMask.hide();
		                       },
		                       failure:function(){
									A.one('#<portlet:namespace/>processes').html("");
									A.one('#<portlet:namespace/>processes').set('disabled', true);  
									<portlet:namespace/>loadingMask.hide();
		                       }
		                     }
				 		}
					 );
				 } else {
					A.one('#<portlet:namespace/>processes').html("");
					A.one('#<portlet:namespace/>processes').set('disabled', true);
				 }
			});
		
			A.one('#<portlet:namespace/>processes').on('change',function() {
				var ttdProcessCustomerMapId = this.val();
				 if ((ttdProcessCustomerMapId !== '') && (ttdProcessCustomerMapId!=0)) {
					 <portlet:namespace/>loadingMask.show();
					 url='<%=getDataList %>'+'&<portlet:namespace/>ttdProcessCustomerMapId=' + ttdProcessCustomerMapId

		             A.io.request(url,{
		            	 dataType: 'json',
		                     cache:false, 
		                     on: {
		                       success: function() {
		                    	   var data=this.get('responseData');
		                    	   if(data==null || data ==""){
		                    		   A.one('#<portlet:namespace/>subProcesses').set('disabled', true);
		                    	   }else{
		                    		   options = '<option value=""></option>';
		                    		   for (i = 0; i < data.length; i++) {
		                                   options += '<option value="' + data[i].ttdpSubProcessCustomerMapId + '">' + data[i].name + '</option>';
		                                 }
		                    		   A.one('#<portlet:namespace/>subProcesses').html(options);
		                               A.one('#<portlet:namespace/>subProcesses').set('disabled', false);
		                    	   }
		                    	   <portlet:namespace/>loadingMask.hide();
		                       },
		                       failure:function() {
		                           	A.one('#<portlet:namespace/>subProcesses').html("");
		                 			A.one('#<portlet:namespace/>subProcesses').set('disabled', true);  
		                            <portlet:namespace/>loadingMask.hide();
		                       }
		                     }
				 		}
					 );
				 } else {
					A.one('#<portlet:namespace/>subProcesses').html("");
					A.one('#<portlet:namespace/>subProcesses').set('disabled', true);
				 }
			});

		});
		
	</aui:script>
	
	<aui:script>
	
		function fetchDataListOfSelectedOptions(){
			  
			AUI().use('aui-io-request-deprecated','aui-tree-view',function(A){
			var	customerId = A.one("#<portlet:namespace/>customers").val();
			var	projectId = A.one("#<portlet:namespace/>projects").val();
			var towerCustomerMapId = A.one("#<portlet:namespace/>towers").val();
			var tTechnologyCustomerMapId = A.one("#<portlet:namespace/>technologies").val();
			var ttDeliverableCustomerMapId = A.one("#<portlet:namespace/>deliverables").val();
			var ttdProcessCustomerMapId = A.one("#<portlet:namespace/>processes").val();
			console.log("ttdProcessCustomerMapId "+ttdProcessCustomerMapId);
			var ttdpSubProcessCustomerMapId = A.one("#<portlet:namespace/>subProcesses").val();
			console.log("ttdpSubProcessCustomerMapId "+ttdpSubProcessCustomerMapId);
			url='<%=getDataListOfSelectedOptions%>' + '&<portlet:namespace/>customerId=' + customerId  + '&<portlet:namespace/>projectId=' + projectId  + '&<portlet:namespace/>towerCustomerMapId=' + towerCustomerMapId  + '&<portlet:namespace/>tTechnologyCustomerMapId=' + tTechnologyCustomerMapId  + '&<portlet:namespace/>ttDeliverableCustomerMapId=' + ttDeliverableCustomerMapId  + '&<portlet:namespace/>ttdProcessCustomerMapId=' + ttdProcessCustomerMapId  + '&<portlet:namespace/>ttdpSubProcessCustomerMapId=' + ttdpSubProcessCustomerMapId
			A.io.request(url,{
			             dataType: 'json',
			             cache:false, 
			             on: {
			                success: function() {
			                	var data=this.get('responseData');
			                	A.one("#treeView").html("");
			                	A.one("#treeView").append("<div id='treeView1'></div>");
			                	var treeView= new A.TreeView({
					        	boundingBox: '#treeView1',
					        	children: data,
								}).render();
			                }
						}
					});
			});
		}
	
		function fetchCatalogElementsCount() {
			
			AUI().use('aui-io-request-deprecated',function(A){
				var	customerId = A.one("#<portlet:namespace/>customers").val();
				var	projectId = A.one("#<portlet:namespace/>projects").val();
				var towerCustomerMapId = A.one("#<portlet:namespace/>towers").val();
				var tTechnologyCustomerMapId = A.one("#<portlet:namespace/>technologies").val();
				var ttDeliverableCustomerMapId = A.one("#<portlet:namespace/>deliverables").val();
				var ttdProcessCustomerMapId = A.one("#<portlet:namespace/>processes").val();
				var ttdpSubProcessCustomerMapId = A.one("#<portlet:namespace/>subProcesses").val();
				A.one("#<portlet:namespace />summary_view").removeClass("hideDiv");
				var url='<%=getCatalogElementsCount%>' + '&<portlet:namespace/>customerId=' + customerId  + '&<portlet:namespace/>projectId=' + projectId  + '&<portlet:namespace/>towerCustomerMapId=' + towerCustomerMapId  + '&<portlet:namespace/>tTechnologyCustomerMapId=' + tTechnologyCustomerMapId  + '&<portlet:namespace/>ttDeliverableCustomerMapId=' + ttDeliverableCustomerMapId  + '&<portlet:namespace/>ttdProcessCustomerMapId=' + ttdProcessCustomerMapId  + '&<portlet:namespace/>ttdpSubProcessCustomerMapId=' + ttdpSubProcessCustomerMapId

				A.io.request(url,{
		             dataType: 'json',
		             cache:false, 
		             on: {
		                success: function() {
		                	var data=this.get('responseData');
		                	console.log("Inside success!!");
		                	
		                	A.one("#<portlet:namespace/>dom_count").html(data.tower);
		                	A.one("#<portlet:namespace/>tech_count").html(data.technology);
		                	A.one("#<portlet:namespace/>deli_count").html(data.deliverable);
		                	A.one("#<portlet:namespace/>proc_count").html(data.process);
		                	A.one("#<portlet:namespace/>sproc_count").html(data.subprocess);
		                	A.one("#<portlet:namespace/>task_count").html(data.tasks);
		                	console.log("data.process"+data.process);
		                	console.log("data.subprocess"+data.subprocess);
		                	console.log("data.tasks"+data.tasks);
		                	data.tower > 1 ? A.one("#<portlet:namespace/>dom_label").html("Domains") : A.one("#<portlet:namespace/>dom_label").html("Domain");  
		                	
		                	data.technology > 1 ? A.one("#<portlet:namespace/>tech_label").html("Technologies"):A.one("#<portlet:namespace/>tech_label").html("Technology");
		                	
		                	data.deliverable > 1 ? A.one("#<portlet:namespace/>deli_label").html("Deliverables") : A.one("#<portlet:namespace/>deli_label").html("Deliverable");
		                	
		                	data.process > 1 ? A.one("#<portlet:namespace/>proc_label").html("Processes") : A.one("#<portlet:namespace/>proc_label").html("Process"); 
		                	
		                	data.subprocess > 1 ? A.one("#<portlet:namespace/>sproc_label").html("Sub-Processes") : A.one("#<portlet:namespace/>sproc_label").html("Sub-Process"); 
		                	
		                	data.tasks > 1 ? A.one("#<portlet:namespace/>task_label").html("Tasks") : A.one("#<portlet:namespace/>task_label").html("Task");
		                	
		                }
					}
				});
		
			});

		}
			
	</aui:script>
	
	