<%-- Copyright (c) 2016 lti. All rights reserved.--%>

<%--  @author Sunilkumar Prabhakar --%>

<%@ include file="init.jsp"%>

<%
	TTechnologyCustomerMap tTechnologyCustomer = null;

	long tTechnologyCustomerId = ParamUtil.getLong(renderRequest,"tTechnologyCustomerId", 0);
	long towerCustomerId = ParamUtil.getLong(renderRequest,"towerCustomerId", 0);
	long organizationId = ParamUtil.getLong(renderRequest,"organizationId", 0);
	Organization project=null;
	
	try
	{
		project=OrganizationLocalServiceUtil.getOrganization(organizationId);
	}
	catch(Exception e)
	{
		log("IPAC : Error while fetching organization for organization id " + organizationId, e);		
	}
	
	
	try {
		tTechnologyCustomer = TTechnologyCustomerMapLocalServiceUtil
				.getTTechnologyCustomerMap(tTechnologyCustomerId);
				
	} catch (Exception e) {
		log("IPAC : Error while fetching tower technology customer map for towertechnologyCustomer Map id "	+ tTechnologyCustomerId, e);
		}

	if (tTechnologyCustomer == null) {
		SessionErrors.add(renderRequest,"no-tTechnologyCustomer-found");
%>
<liferay-ui:error key="no-tTechnologyCustomerMap-found"
	message="invalid-tTechnologyCustomerMap" />
<aui:button icon="left-arrow" href="<%=homeURL%>" value="back"></aui:button>
<%
	} else {
		
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
			TowerTechnologyMap tt=TowerTechnologyMapLocalServiceUtil.getTowerTechnologyMap(tTechnologyCustomer.getTowerTechnologyId());

%>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageTechnology.jsp" />
	<portlet:param name="organizationId" value="<%=String.valueOf(organizationId)%>" />
	<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
</portlet:renderURL>

<liferay-ui:header backURL="<%=backURL%>" title="<%=LanguageUtil.format(request,\"edit-x\", tTechnologyCustomer.getName(themeDisplay.getLocale()))%>" cssClass="cust_header"/>
	
<portlet:actionURL var="editTTechnologyCustomerMapURL" name="editTTechnologyCustomerMap">
		<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageTechnology.jsp" />
		<portlet:param name="organizationId" value="<%=String.valueOf(organizationId)%>" />
		<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
		<portlet:param name="tTechnologyCustomerId"	value="<%=String.valueOf(tTechnologyCustomer.getTTechnologyCustomerId())%>" />
</portlet:actionURL>

<aui:form name="updateTitle" action="<%=editTTechnologyCustomerMapURL%>">
	<aui:model-context bean="<%=tTechnologyCustomer%>"	model="<%=TTechnologyCustomerMap.class%>" />
	<aui:fieldset>
		<aui:input name="ttName" disabled="true" type="text" value="<%=tt.getName(themeDisplay.getLocale()) %>"></aui:input>
		<aui:input name="name" label="name"></aui:input>
		<aui:select label="status" listTypeFieldName="statusId"	name="statusId" listType="<%=CCStatus.STATUS_LIST_TYPE%>"></aui:select>
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