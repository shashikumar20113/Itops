<%-- Copyright (c) 2016 lti. All rights reserved.--%>

<%--  @author Sunilkumar Prabhakar, Raj Kumar Kulasekaran --%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTechnologyCustomerMapException"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.util.CustomerCatalogUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.lti.itops.ipac.spmgmt.model.TowerTechnologyMap"%>
<%@page import="com.lti.itops.ipac.spmgmt.service.TowerTechnologyMapLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.model.ListTypeConstants"%>
<%@page import="com.lti.itops.ipac.spmgmt.service.TaskLocalServiceUtil"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.service.TTDPSPTaskCustomerMapLocalServiceUtil"%>
<%@page import="com.lti.itops.ipac.spmgmt.model.Task"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.permission.TTDPSubProcessCustomerMapPermissions"%>
<%@page import="com.lti.itops.ipac.spmgmt.model.TTDProcessMap"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.permission.TTDProcessCustomerMapPermissions"%>
<%@page import="com.lti.itops.ipac.spmgmt.service.TTDProcessMapLocalServiceUtil"%>
<%@page import="com.lti.itops.ipac.spmgmt.service.ProcessLocalServiceUtil"%>
<%@page import="com.lti.itops.ipac.spmgmt.service.TechnologyLocalServiceUtil"%>
<%@page import="com.lti.itops.ipac.spmgmt.model.Technology"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.exception.NoSuchTowerCustomerMapException"%>
<%@page import="com.lti.itops.ipac.spmgmt.service.ProcessLocalServiceUtil"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDPSubProcessCustomerMapException"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.exception.NoSuchOrganizationException"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.util.PortletKeys"%>
<%@page import="com.liferay.portal.kernel.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.PortalPreferencesLocalServiceUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.util.CustomerConstants"%>
<%@ taglib prefix="liferay-security" uri="http://liferay.com/tld/security"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.model.RoleConstants"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.permission.TTDeliverableCustomerMapPermissions"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.permission.ProjectCatalogPermission"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.util.SPStatus"%>
<%@page import="com.liferay.portal.kernel.util.ArrayUtil"%>
<%@page import="com.lti.itops.ipac.spmgmt.service.DeliverableLocalServiceUtil"%>
<%@page import="com.lti.itops.ipac.spmgmt.model.TTDeliverableMap"%>
<%@page import="com.lti.itops.ipac.spmgmt.service.TTDeliverableMapLocalServiceUtil"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.lti.itops.ipac.spmgmt.service.TowerLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.permission.CatalogPermission"%>
<%@page import="com.lti.itops.ipac.spmgmt.model.Tower"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.service.TowerCustomerMapLocalServiceUtil"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap"%>
<%@page import="com.liferay.portal.kernel.security.auth.PrincipalException"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.util.CCStatus"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTDeliverableCustomerMapException"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.service.TTDeliverableCustomerMapLocalServiceUtil"%>
<%@page import="com.lti.itops.ipac.spmgmt.model.Deliverable"%>
<%@page import="com.lti.itops.ipac.spmgmt.model.Deliverable"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.permission.TTDPSPTaskCustomerMapPermissions"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.exception.NoSuchTTechnologyCustomerMapException"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.lti.itops.ipac.custcatmgmt.service.TTechnologyCustomerMapLocalServiceUtil"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.model.TTechnologyCustomerMap"%>
<%@page import="com.lti.itops.ipac.spmgmt.service.TTDPSPTaskMapLocalServiceUtil"%>
<%@page import="com.lti.itops.ipac.spmgmt.model.TTDPSPTaskMap"%>
<%@page import="com.lti.itops.ipac.spmgmt.model.Process"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.service.TTDPSubProcessCustomerMapLocalServiceUtil"%>
<%@page import="com.lti.itops.ipac.spmgmt.service.SubProcessLocalServiceUtil"%>
<%@page import="com.lti.itops.ipac.spmgmt.model.TTDPSubProcessMap"%>
<%@page import="com.lti.itops.ipac.spmgmt.service.TTDPSubProcessMapLocalServiceUtil"%>
<%@page import="com.lti.itops.ipac.spmgmt.model.SubProcess"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.service.TTDProcessCustomerMapLocalServiceUtil"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.permission.TTechnologyCustomerMapPermissions"%>
<%@page import="com.lti.itops.ipac.custcatmgmt.permission.TowerCustomerMapPermissions"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />
<portlet:renderURL var="homeURL" portletMode="view"></portlet:renderURL>
<%
	PortletPreferences prefs=PortalPreferencesLocalServiceUtil.getPreferences(company.getCompanyId(), PortletKeys.PREFS_OWNER_TYPE_COMPANY);
	long companyOrgID=Long.parseLong(prefs.getValue(CustomerConstants.COMPANY_ORG_ID, "0"));
	Organization companyOrg=null;
	if(companyOrgID !=0 )
	{
		companyOrg=OrganizationLocalServiceUtil.getOrganization(companyOrgID);
	}
 %>

 