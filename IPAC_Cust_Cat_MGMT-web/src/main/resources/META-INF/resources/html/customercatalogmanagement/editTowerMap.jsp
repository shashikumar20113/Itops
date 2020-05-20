<%-- Copyright (c) 2016 lti. All rights reserved.--%>

<%--  @author Sunilkumar Prabhakar --%>



<%@ include file="init.jsp"%>



<%
long towerCustomerId = ParamUtil.getLong(renderRequest, "towerCustomerId", 0);

	TowerCustomerMap towerCustomerMap = null;

	
	try {
			towerCustomerMap = TowerCustomerMapLocalServiceUtil.getTowerCustomerMap(towerCustomerId);
	} catch (Exception e) {
		log("IPAC : Error while fetching tower technology customer map for towertechnologyCustomer Map id "	+ towerCustomerId, e);
		}
	

	
	if (towerCustomerMap == null) {
		SessionErrors.add(renderRequest,"no-towerCustomerMap-found");
%>
<liferay-ui:error key="no-towerCustomerMap-found"
	message="invalid-towerCustomerMap" />
<aui:button icon="left-arrow" href="<%=homeURL%>" value="back"></aui:button>
<%
	} else {

		long organizationId = towerCustomerMap.getOrganizationId();
		Organization project=null;
		
		try
		{
			project=OrganizationLocalServiceUtil.getOrganization(organizationId);
		}
		catch(Exception e)
		{
			log("IPAC : Error while fetching organization for organization id " + organizationId, e);		
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
		if ( ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project)) {
			Tower tower=TowerLocalServiceUtil.getTower(towerCustomerMap.getTowerId());

%>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageTower.jsp" />
			<portlet:param name="organizationId" value="<%=String.valueOf(organizationId)%>" />
</portlet:renderURL>

<liferay-ui:header backURL="<%=backURL%>" title="<%=LanguageUtil.format(request,\"edit-x\", towerCustomerMap.getName(themeDisplay.getLocale()))%>" cssClass="cust_header"/>
	
<portlet:actionURL var="editTowerCustomerMapURL" name="editTowerCustomerMap">
		<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageTower.jsp" />
		<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerMap.getTowerCustomerId())%>" />
		<portlet:param name="organizationId" value="<%=String.valueOf(organizationId
				)%>" />
</portlet:actionURL>

<aui:form name="updateTowerMap" action="<%=editTowerCustomerMapURL%>">
	<aui:model-context bean="<%=towerCustomerMap%>"
		model="<%=TowerCustomerMap.class%>" />
	<aui:fieldset>
		<aui:input name="tower-name" label="tower-name"  value="<%=tower.getName() %>" type="text" disabled="true"></aui:input>
		<aui:input name="name" label="name"></aui:input>
		<aui:select label="status" listTypeFieldName="statusId" name="statusId" listType="<%=CCStatus.STATUS_LIST_TYPE%>"></aui:select>
	</aui:fieldset>
	<aui:button-row>	
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" href="<%=backURL%>"></aui:button>
	</aui:button-row>
</aui:form>
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