<%-- Copyright (c) 2016 lti. All rights reserved.--%>

<%--  @author Sunilkumar Prabhakar --%>



<%@page import="com.lti.itops.ipac.spmgmt.service.TTDPSubProcessMapLocalServiceUtil"%>
<%@page import="com.lti.itops.ipac.spmgmt.service.SubProcessLocalServiceUtil"%>
<%@page import="com.lti.itops.ipac.spmgmt.model.TTDPSubProcessMap"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.service.TTDPSubProcessCustomerMapLocalServiceUtil"%>
<%@page import="com.lti.itops.ipac.spmgmt.model.SubProcess"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap"%>
<%@ include file="init.jsp"%>

<%
	TTDPSubProcessCustomerMap tTDPSubProcessCustomerMap = null;
	SubProcess subProcess = null;


	long tTDPSubProcessCustomerId = ParamUtil.getLong(renderRequest,"tTDPSubProcessCustomerId", 0);
	
	long towerCustomerId = ParamUtil.getLong(renderRequest,	"towerCustomerId", 0);
	long tTechnologyCustomerId = ParamUtil.getLong(renderRequest,"tTechnologyCustomerId", 0);
	long tTDeliverableCustomerId = ParamUtil.getLong(renderRequest,"tTDeliverableCustomerId", 0);
	long tTDProcessCustomerId = ParamUtil.getLong(renderRequest,"tTDProcessCustomerId", 0);

	
	try {
		tTDPSubProcessCustomerMap = TTDPSubProcessCustomerMapLocalServiceUtil
				.getTTDPSubProcessCustomerMap(tTDPSubProcessCustomerId);
				
	} catch (Exception e) {
		log("IPAC : Error while fetching ttdpsp customer map for TTDPSubProcessCustomerMap id "	+ tTDPSubProcessCustomerId, e);
		}

if (tTDPSubProcessCustomerMap == null) {
		SessionErrors.add(renderRequest,"no-tTDPSubProcessCustomerMap-found");
%>
<liferay-ui:error key="no-tTDPSubProcessCustomerMap-found"
	message="invalid-tTDPSubProcessCustomerMap" />
<aui:button icon="left-arrow" href="<%=homeURL%>" value="back"></aui:button>
<%
	} else {

Organization project=null;
	
	try
	{
		project=OrganizationLocalServiceUtil.getOrganization(tTDPSubProcessCustomerMap.getOrganizationId());
	}
	catch(Exception e)
	{
		log("IPAC : Error while fetching organization for organization id " + tTDPSubProcessCustomerMap.getOrganizationId(), e);		
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
			
			TTDPSubProcessMap ttdpSubProcessMap=TTDPSubProcessMapLocalServiceUtil.getTTDPSubProcessMap(tTDPSubProcessCustomerMap.getTTDPSubProcessId());
			try {
				subProcess = SubProcessLocalServiceUtil.getSubProcess(ttdpSubProcessMap.getSubProcessId());
			} catch (Exception e) {
				log("IPAC : Error while fetching SubProcess for subprocessId: "	+ ttdpSubProcessMap.getSubProcessId(), e);
			}
%>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageSubProcess.jsp" />
	<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
	<portlet:param name="tTechnologyCustomerId" value="<%=String.valueOf(tTechnologyCustomerId)%>" />
	<portlet:param name="tTDeliverableCustomerId" value="<%=String.valueOf(tTDeliverableCustomerId)%>" />
	<portlet:param name="tTDProcessCustomerId" value="<%=String.valueOf(tTDProcessCustomerId)%>" />
</portlet:renderURL>

<liferay-ui:header backURL="<%=backURL%>" title="<%=LanguageUtil.format(request,\"edit-x\", tTDPSubProcessCustomerMap.getName(themeDisplay.getLocale()))%>" cssClass="cust_header"/>
	
<portlet:actionURL var="editTTDPSubProcessCustomerURL" name="editTTDPSubProcessCustomerMap">
		<portlet:param name="mvcPath" value="/html/customercatalogmanagement/manageSubProcess.jsp" />		
		<portlet:param name="towerCustomerId" value="<%=String.valueOf(towerCustomerId)%>" />
		<portlet:param name="tTechnologyCustomerId" value="<%=String.valueOf(tTechnologyCustomerId)%>" />
		<portlet:param name="tTDeliverableCustomerId" value="<%=String.valueOf(tTDeliverableCustomerId)%>" />
		<portlet:param name="tTDProcessCustomerId" value="<%=String.valueOf(tTDProcessCustomerId)%>" />
		<portlet:param name="tTDPSubProcessCustomerId"	value="<%=String.valueOf(tTDPSubProcessCustomerMap.getTTDPSubProcessCustomerId())%>" />
</portlet:actionURL>

<aui:form name="updateTitle" action="<%=editTTDPSubProcessCustomerURL%>">
	<aui:model-context bean="<%=tTDPSubProcessCustomerMap%>"	model="<%=TTDPSubProcessCustomerMap.class%>" />
	<aui:fieldset>
		<aui:input type="text" name="sub-process-name" value="<%=subProcess.getName() %>" disabled="true"></aui:input>
		<aui:input type="text" name="ttdpsp-name" value="<%=ttdpSubProcessMap.getName(themeDisplay.getLocale()) %>" disabled="true"></aui:input>
		
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