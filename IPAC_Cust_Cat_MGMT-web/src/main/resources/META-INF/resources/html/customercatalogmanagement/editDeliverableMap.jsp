<%-- Copyright (c) 2016 lti. All rights reserved.--%>

<%--  @author Sunilkumar Prabhakar --%>





<%@ include file="init.jsp"%>

<%
	TTDeliverableCustomerMap tTDeliverableCustomerMap = null;
	Deliverable deliverable = null;
	TTDeliverableMap ttDeliverableMap=null;

	long tTDeliverableCustomerId = ParamUtil.getLong(renderRequest,"tTDeliverableCustomerId", 0);
	

	long towerCustomerId = ParamUtil.getLong(renderRequest,	"towerCustomerId", 0);
	long tTechnologyCustomerId = ParamUtil.getLong(renderRequest,"tTechnologyCustomerId", 0);

	try {
		tTDeliverableCustomerMap = TTDeliverableCustomerMapLocalServiceUtil
				.getTTDeliverableCustomerMap(tTDeliverableCustomerId);
				
	} catch (Exception e) {
		log("IPAC : Error while fetching tower deliverable customer map for TTDeliverableCustomerMap id "	+ tTDeliverableCustomerId, e);
		}


	
	if (tTDeliverableCustomerMap == null) {
		SessionErrors.add(renderRequest,NoSuchTTDeliverableCustomerMapException.class);
%>
<liferay-ui:error exception="<%=NoSuchTTDeliverableCustomerMapException.class %>"
	message="invalid-tTDeliverableCustomerMap" />
<aui:button icon="left-arrow" href="<%=homeURL%>" value="back"></aui:button>
<%
	} else {
		Organization project=null;
		
		try
		{
			project=OrganizationLocalServiceUtil.getOrganization(tTDeliverableCustomerMap.getOrganizationId());
		}
		catch(Exception e)
		{
			log("IPAC : Error while fetching organization for organization id " + tTDeliverableCustomerMap.getOrganizationId(), e);		
		}
	
		
		try {
			ttDeliverableMap = TTDeliverableMapLocalServiceUtil.getTTDeliverableMap(tTDeliverableCustomerMap.getTTDeliverableId());
		} catch (Exception e) {
			log("IPAC : Error while fetching TTDeliverable for ttdeliverableId: "	+ tTDeliverableCustomerMap.getTTDeliverableId(), e);
		}
		try {
			deliverable = DeliverableLocalServiceUtil.getDeliverable(ttDeliverableMap.getDeliverableId());
		} catch (Exception e) {
			log("IPAC : Error while fetching Deliverable for deliverableId: "	+ ttDeliverableMap.getDeliverableId(), e);
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
	<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageDeliverable.jsp" />	
	<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
	<portlet:param name="tTechnologyCustomerId" value="<%=String.valueOf(tTechnologyCustomerId)%>" />
</portlet:renderURL>

<liferay-ui:header backURL="<%=backURL%>" title="<%=LanguageUtil.format(request,\"edit-x\", tTDeliverableCustomerMap.getName(themeDisplay.getLocale()))%>" cssClass="cust_header"/>
	
<portlet:actionURL var="editTTDeliverableCustomerURL" name="editTTDeliverableCustomerMap">
		<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageDeliverable.jsp" />
		<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
		<portlet:param name="tTechnologyCustomerId" value="<%=String.valueOf(tTechnologyCustomerId)%>" />
		<portlet:param name="tTDeliverableCustomerId"	value="<%=String.valueOf(tTDeliverableCustomerMap.getTTDeliverableCustomerId())%>" />
</portlet:actionURL>

<aui:form name="updateTitle" action="<%=editTTDeliverableCustomerURL%>">
	<aui:model-context bean="<%=tTDeliverableCustomerMap%>"	model="<%=TTDeliverableCustomerMap.class%>" />
	<aui:fieldset>
		<aui:input type="text" name="deliverable-name" value="<%=deliverable.getName() %>" disabled="true"></aui:input>
		<aui:input type="text" name="ttd-name" value="<%=ttDeliverableMap.getName(themeDisplay.getLocale()) %>" disabled="true"></aui:input>
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