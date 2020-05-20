package com.lti.itops.ipac.custcatmgmt.web.portlet;

import com.lti.itops.ipac.custcatmgmt.constants.CustomerCatalogManagementPortletKeys;
import com.lti.itops.ipac.custcatmgmt.model.TTDPSPTaskCustomerMap;
import com.lti.itops.ipac.custcatmgmt.model.TTDPSubProcessCustomerMap;
import com.lti.itops.ipac.custcatmgmt.model.TTDProcessCustomerMap;
import com.lti.itops.ipac.custcatmgmt.model.TTDeliverableCustomerMap;
import com.lti.itops.ipac.custcatmgmt.model.TTechnologyCustomerMap;
import com.lti.itops.ipac.custcatmgmt.model.TowerCustomerMap;
import com.lti.itops.ipac.custcatmgmt.permission.CatalogPermission;
import com.lti.itops.ipac.custcatmgmt.permission.ProjectCatalogPermission;
import com.lti.itops.ipac.custcatmgmt.service.TTDPSPTaskCustomerMapLocalServiceUtil;
import com.lti.itops.ipac.custcatmgmt.service.TTDPSubProcessCustomerMapLocalServiceUtil;
import com.lti.itops.ipac.custcatmgmt.service.TTDProcessCustomerMapLocalServiceUtil;
import com.lti.itops.ipac.custcatmgmt.service.TTDeliverableCustomerMapLocalServiceUtil;
import com.lti.itops.ipac.custcatmgmt.service.TTechnologyCustomerMapLocalServiceUtil;
import com.lti.itops.ipac.custcatmgmt.service.TowerCustomerMapLocalServiceUtil;
import com.lti.itops.ipac.custcatmgmt.util.CCStatus;
import com.lti.itops.ipac.custcatmgmt.util.CustomerCatalogUtil;
import com.lti.itops.ipac.custcatmgmt.util.CustomerConstants;
import com.lti.itops.ipac.spmgmt.service.TTDPSubProcessMapLocalServiceUtil;
import com.lti.itops.ipac.spmgmt.service.TTDProcessMapLocalServiceUtil;
import com.lti.itops.ipac.spmgmt.service.TTDeliverableMapLocalServiceUtil;
import com.lti.itops.ipac.spmgmt.service.TaskLocalServiceUtil;
import com.lti.itops.ipac.spmgmt.service.TowerLocalServiceUtil;
import com.lti.itops.ipac.spmgmt.service.TowerTechnologyMapLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ListTypeConstants;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.PortalPreferencesLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author asharm31
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.ipac",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Customer Catalog Portlet",
		"com.liferay.portlet.footer-portlet-javascript=/js/main.js",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.private-request-attributes=false",
        "com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.render-weight=50",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/customercatalogmanagement/view.jsp",
		"javax.portlet.name=" + CustomerCatalogManagementPortletKeys.CustomerCatalogManagement,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CustomerCatalogManagementPortlet extends MVCPortlet {


	private static final Log _log = LogFactoryUtil
			.getLog(CustomerCatalogManagementPortlet.class);
	
	
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		renderRequest.getPortletSession().
				setAttribute("moduleHelpPage","customer-catalog", PortletSession.APPLICATION_SCOPE);
		super.doView(renderRequest, renderResponse);
	}
	
	
	
	/**
	 * Action Method for updating tower mapping to customer
	 * 
	 * @throws SystemException
	 * @throws PortalException
	 * 
	 */
	public void updateTowerCustomerMap(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException, PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			long organizationId = ParamUtil.getLong(actionRequest,"organizationId");
			long[] addTowerMapIds = StringUtil.split(
					ParamUtil.getString(actionRequest, "addTowerMapIds"), 0L);
			Organization project=OrganizationLocalServiceUtil.getOrganization(organizationId);
			if (ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project))
			{
				if (addTowerMapIds.length > 0) {

					List<Long> availableTowerIds = getAvailableTowerCustomerIds(
							organizationId, addTowerMapIds);

					for (Long addtowerId : addTowerMapIds) {
						if (!availableTowerIds.contains(addtowerId)) {
							TowerCustomerMapLocalServiceUtil
									.addTowerCustomerMapping(addtowerId,
											organizationId, TowerLocalServiceUtil.getTower(addtowerId).getName(),
											themeDisplay.getCompanyId(),
											themeDisplay.getUserId(), CCStatus.ACTIVE_STATUS);
						} else {
							TowerCustomerMapLocalServiceUtil
									.updateTowerCustomerMapping(addtowerId,
											organizationId, 
											themeDisplay.getUserId(),  CCStatus.ACTIVE_STATUS);
						}
					}
				}
			} else {
				_log.error("IPAC : Error while creating Tower Customer Map . User '"
						+ themeDisplay.getUserId()
						+ "' does not have permission to create Tower Customer Map.");
				SessionErrors.add(actionRequest, PrincipalException.class);
			}
		} catch (Exception e) {

			_log.error("IPAC : Error while creating TowerCustomer Map", e);
			actionResponse.setRenderParameter("mvcPath",
					"/html/customercatalogmanagement/manageTower.jsp");
			SessionErrors.add(actionRequest, e.getClass());
		}
	}

	/*
	 * Action Method to edit the TowerCustomerMap
	 */

	public void editTowerCustomerMap(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException, PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			long towerCustomerId = ParamUtil.getLong(actionRequest, "towerCustomerId");
			Map<Locale, String> name =
					LocalizationUtil.getLocalizationMap(actionRequest, "name");
			int statusId = ParamUtil.getInteger(actionRequest, "statusId");
			TowerCustomerMap towerCustomerMap=TowerCustomerMapLocalServiceUtil.getTowerCustomerMap(towerCustomerId);
			Organization project=OrganizationLocalServiceUtil.getOrganization(towerCustomerMap.getOrganizationId());
			if (ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project))
			{
				TowerCustomerMapLocalServiceUtil.editTowerCustomerMapping(
						towerCustomerId, name, themeDisplay.getUserId(),
						statusId);

			} else {
				_log.error("IPAC : Error while creating Tower Customer Map . User '"
						+ themeDisplay.getUserId()
						+ "' does not have permission to create Tower Customer Map.");
				SessionErrors.add(actionRequest, PrincipalException.class);
			}
		} catch (Exception e) {
			_log.error("IPAC : Error while editing TowerCustomer Map", e);
			actionResponse.setRenderParameter("mvcPath",
					"/html/customercatalogmanagement/manageTower.jsp");
			
			SessionErrors.add(actionRequest, e.getClass());

		}
	}

	/*
	 * Method to get the list of existing tower customer map Id's
	 */

	public List<Long> getAvailableTowerCustomerIds(long organizationId,
			long[] towerMapIds) throws SystemException {

		try {
			DynamicQuery dq = DynamicQueryFactoryUtil
					.forClass(TowerCustomerMap.class);
					dq.add(PropertyFactoryUtil.forName("organizationId").eq(
							organizationId));
					dq.add(PropertyFactoryUtil.forName("towerId").in(towerMapIds));
					dq.setProjection(ProjectionFactoryUtil.property("towerId"));

			@SuppressWarnings("unchecked")
			List<Long> availableTowerIds = TowerCustomerMapLocalServiceUtil
					.dynamicQuery(dq);
			return availableTowerIds;
		} catch (Exception e) {
			_log.error(
					"IPAC : Error while getting available towerId for TowerCustomer Map",
					e);
		}

		return null;
	}

	/**
	 * Action Method for updating technology mapping to customer
	 * 
	 * @throws SystemException
	 * @throws PortalException
	 * 
	 */
	public void updateTTechnologyCustomerMap(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException, PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			long organizationId = ParamUtil.getLong(actionRequest,
					"organizationId");
			long[] addTechnologyMapIds = StringUtil.split(
					ParamUtil.getString(actionRequest, "addTechnologyMapIds"),
					0L);

			Organization project=OrganizationLocalServiceUtil.getOrganization(organizationId);
			if (ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project))
			{
				if (addTechnologyMapIds.length > 0) {

					List<Long> availableTechnologyIds = getAvailableTTechnologyCustomerIds(
							organizationId, addTechnologyMapIds);

						for (long addTTechnologyId : addTechnologyMapIds) {
							if (!availableTechnologyIds
									.contains(addTTechnologyId)) {

								TTechnologyCustomerMapLocalServiceUtil
										.addTTechnologyCustomerMapping(
												addTTechnologyId,
												organizationId, TowerTechnologyMapLocalServiceUtil.getTowerTechnologyMap(addTTechnologyId).getNameMap(),
												themeDisplay.getCompanyId(),
												themeDisplay.getUserId(),
												CCStatus.ACTIVE_STATUS);
							} else {

								TTechnologyCustomerMapLocalServiceUtil
										.updateTTechnologyCustomerMapping(
												addTTechnologyId,
												organizationId, 
												themeDisplay.getUserId(),
												CCStatus.ACTIVE_STATUS);
							}
						}
				}

			} else {
				_log.error("IPAC : Error while creating Technology Customer Map . User '"
						+ themeDisplay.getUserId()
						+ "' does not have permission to create Technology Customer Map.");
				SessionErrors.add(actionRequest, PrincipalException.class);
			}

		} catch (Exception e) {

			_log.error(
					"IPAC : Error while creating TechnologyCustomer Map", e);
			actionResponse.setRenderParameter("mvcPath",
					"/html/customercatalogmanagement/manageTechnology.jsp");
			SessionErrors.add(actionRequest, e.getClass());
		}

	}

	/*
	 * Action Method to edit the TechnologyCustomerMap
	 */

	public void editTTechnologyCustomerMap(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException, PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			long organizationId = ParamUtil.getLong(actionRequest, "organizationId");
			long tTechnologyCustomerId = ParamUtil.getLong(actionRequest, "tTechnologyCustomerId");
			int statusId = ParamUtil.getInteger(actionRequest, "statusId");
			Map<Locale, String> name =
					LocalizationUtil.getLocalizationMap(actionRequest, "name");			Organization project=OrganizationLocalServiceUtil.getOrganization(organizationId);
			if (ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project))
			{	TTechnologyCustomerMapLocalServiceUtil
						.editTTechnologyCustomerMapping(tTechnologyCustomerId, organizationId, name, themeDisplay.getUserId(), statusId);
			
			} else {
				_log.error("IPAC : Error while creating Technology Customer Map . User '"
						+ themeDisplay.getUserId()
						+ "' does not have permission to create Technology Customer Map.");
				SessionErrors.add(actionRequest, PrincipalException.class);
			}
		} catch (Exception e) {
			_log.error("IPAC : Error while editing TechnologyCustomer Map",
					e);
			actionResponse.setRenderParameter("mvcPath",
					"/html/customercatalogmanagement/manageTechnology.jsp");
			SessionErrors.add(actionRequest, e.getClass());
			

		}
	}

	/*
	 * Method to get the list of existing tower customer map Id's
	 */

	public List<Long> getAvailableTTechnologyCustomerIds(long organizationId,
			long[] towerTechnologyIdMapIds) throws SystemException {

		try {
			DynamicQuery dq = DynamicQueryFactoryUtil
					.forClass(TTechnologyCustomerMap.class);
					dq.add(PropertyFactoryUtil.forName("organizationId").eq(
							organizationId));
					dq.add(PropertyFactoryUtil.forName("towerTechnologyId").in(
							towerTechnologyIdMapIds));		
					dq.setProjection(
							ProjectionFactoryUtil.property("towerTechnologyId"));

			@SuppressWarnings("unchecked")
			List<Long> availableTechnologyIds = TTechnologyCustomerMapLocalServiceUtil
					.dynamicQuery(dq);

			return availableTechnologyIds;
		} catch (Exception e) {
			_log.error(
					"IPAC : Error while getting avaialble towerId for TechnologyCustomer Map",
					e);
			
		}

		return null;
	}


	/**
	 * Action Method for updating TTDeliverable mapping to customer
	 * 
	 * @throws SystemException
	 * @throws PortalException
	 * 
	 */
	public void updateTTDeliverableCustomerMap(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException, PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		
		try {
			long organizationId = ParamUtil.getLong(actionRequest, "organizationId");
			long[] addDeliverableMapIds = StringUtil.split(
					ParamUtil.getString(actionRequest, "addDeliverableMapIds"),	0L);
			Organization project=OrganizationLocalServiceUtil.getOrganization(organizationId);
			if (ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project))
			{

				if (addDeliverableMapIds.length > 0) {

					List<Long> availableDeliverableIds = getAvailableTTDeliverableCustomerIds(organizationId, addDeliverableMapIds);
					
						for (long addTTDeliverableId : addDeliverableMapIds) {
							if (!availableDeliverableIds
									.contains(addTTDeliverableId)) {

								TTDeliverableCustomerMapLocalServiceUtil
										.addTTDeliverableCustomerMapping(
												addTTDeliverableId,
												organizationId,TTDeliverableMapLocalServiceUtil.getTTDeliverableMap(addTTDeliverableId).getNameMap(),
												themeDisplay.getCompanyId(),
												themeDisplay.getUserId(),
												CCStatus.ACTIVE_STATUS);
							} else {

								TTDeliverableCustomerMapLocalServiceUtil
										.updateTTDeliverableCustomerMapping(
												addTTDeliverableId,
												organizationId, 
												themeDisplay.getUserId(),
												CCStatus.ACTIVE_STATUS);
							}
						}
				}

			} else {
				_log.error("IPAC : Error while creating Deliverable Customer Map . User '"
						+ themeDisplay.getUserId()
						+ "' does not have permission to create Deliverable Customer Map.");
				SessionErrors.add(actionRequest, PrincipalException.class);
			}

		} catch (Exception e) {

			_log.error(
					"IPAC : Error while creating DeliverableCustomer Map", e);
			actionResponse.setRenderParameter("mvcPath",
					"/html/customercatalogmanagement/manageDeliverable.jsp");
			SessionErrors.add(actionRequest, e.getClass());
		
		}

	}
	
	
	/*
	 * Action Method to edit the DeliverableCustomerMap
	 */

	public void editTTDeliverableCustomerMap(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException, PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			long tTDeliverableCustomerId = ParamUtil.getLong(actionRequest, "tTDeliverableCustomerId");
			int statusId = ParamUtil.getInteger(actionRequest, "statusId");
			Map<Locale, String> name =
					LocalizationUtil.getLocalizationMap(actionRequest, "name");			TTDeliverableCustomerMap ttDeliverableCustomerMap=TTDeliverableCustomerMapLocalServiceUtil.getTTDeliverableCustomerMap(tTDeliverableCustomerId);
			Organization project=OrganizationLocalServiceUtil.getOrganization(ttDeliverableCustomerMap.getOrganizationId());
			if (ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project))
			{
				TTDeliverableCustomerMapLocalServiceUtil
						.editTTDeliverableCustomerMapping(tTDeliverableCustomerId,  name, themeDisplay.getUserId(), statusId);
			} else {
				_log.error("IPAC : Error while creating Deliverable Customer Map . User '"
						+ themeDisplay.getUserId()
						+ "' does not have permission to create Deliverable Customer Map.");
				SessionErrors.add(actionRequest, PrincipalException.class);
			}
		} catch (Exception e) {
			_log.error("IPAC : Error while editing DeliverableCustomer Map",
					e);
			actionResponse.setRenderParameter("mvcPath",
					"/html/customercatalogmanagement/manageDeliverable.jsp");
			SessionErrors.add(actionRequest, e.getClass());
		

		}
	}
	
	/*
	 * Method to get the list of existing tTDeliverable customer map Id's
	 */

	public List<Long> getAvailableTTDeliverableCustomerIds(long organizationId,
			long[] TTDeliverableIdMapIds) throws SystemException {

		try {
			DynamicQuery dq = DynamicQueryFactoryUtil
					.forClass(TTDeliverableCustomerMap.class);
					dq.add(PropertyFactoryUtil.forName("organizationId").eq(
							organizationId));
					dq.add(PropertyFactoryUtil.forName("TTDeliverableId").in(
							TTDeliverableIdMapIds));		
					dq.setProjection(
							ProjectionFactoryUtil.property("TTDeliverableId"));

			@SuppressWarnings("unchecked")
			List<Long> availableDeliverableIds = TTDeliverableCustomerMapLocalServiceUtil
					.dynamicQuery(dq);

			return availableDeliverableIds;
		} catch (Exception e) {
			_log.error(
					"IPAC : Error while getting avaialble TTdeliverableId for DeliverableCustomer Map",
					e);
			
		}

		return null;
	}
	
		
	
	/**
	 * Action Method for updating TTDProcess mapping to customer
	 * 
	 * @throws SystemException
	 * @throws PortalException
	 * 
	 */
	public void updateTTDProcessCustomerMap(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException, PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		
		try {
			long organizationId = ParamUtil.getLong(actionRequest, "organizationId");
			long[] addProcessMapIds = StringUtil.split(
					ParamUtil.getString(actionRequest, "addProcessMapIds"),	0L);
			Organization project=OrganizationLocalServiceUtil.getOrganization(organizationId);
			if (ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project))
			{

				if (addProcessMapIds.length > 0) {
					List<Long> availableProcessIds = getAvailableTTDProcessCustomerIds(organizationId, addProcessMapIds);
					
						for (long addTTDProcessId : addProcessMapIds) {
							if (!availableProcessIds
									.contains(addTTDProcessId)) {
								TTDProcessCustomerMapLocalServiceUtil
										.addTTDProcessCustomerMapping(
												addTTDProcessId,
												organizationId, TTDProcessMapLocalServiceUtil.getTTDProcessMap(addTTDProcessId).getNameMap(),
												themeDisplay.getCompanyId(),
												themeDisplay.getUserId(),
												CCStatus.ACTIVE_STATUS);
							} else {
								TTDProcessCustomerMapLocalServiceUtil
										.updateTTDProcessCustomerMapping(
												addTTDProcessId,
												organizationId,  
												themeDisplay.getUserId(),
												CCStatus.ACTIVE_STATUS);
							}
						}
				}

			} else {
				_log.error("IPAC : Error while creating Process Customer Map . User '"
						+ themeDisplay.getUserId()
						+ "' does not have permission to create Process Customer Map.");
				SessionErrors.add(actionRequest, PrincipalException.class);
			}

		} catch (Exception e) {

			_log.error(
					"IPAC : Error while creating ProcessCustomer Map", e);
			actionResponse.setRenderParameter("mvcPath",
					"/html/customercatalogmanagement/manageProcess.jsp");
			SessionErrors.add(actionRequest, e.getClass());
			
		}

	}
	
	
	/*
	 * Action Method to edit the ProcessCustomerMap
	 */

	public void editTTDProcessCustomerMap(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException, PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			long tTDProcessCustomerId = ParamUtil.getLong(actionRequest,"tTDProcessCustomerId");
			int statusId = ParamUtil.getInteger(actionRequest, "statusId");
			Map<Locale, String> name =
					LocalizationUtil.getLocalizationMap(actionRequest, "name");			TTDProcessCustomerMap ttdProcessCustomerMap=TTDProcessCustomerMapLocalServiceUtil.getTTDProcessCustomerMap(tTDProcessCustomerId);
			Organization project=OrganizationLocalServiceUtil.getOrganization(ttdProcessCustomerMap.getOrganizationId());
			if (ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project))
			{

				TTDProcessCustomerMapLocalServiceUtil
						.editTTDProcessCustomerMapping(tTDProcessCustomerId,
								ttdProcessCustomerMap.getOrganizationId(), name,
								themeDisplay.getCompanyId(),
								themeDisplay.getUserId(), statusId);

			} else {
				_log.error("IPAC : Error while creating Process Customer Map . User '"
						+ themeDisplay.getUserId()
						+ "' does not have permission to create Process Customer Map.");
				SessionErrors.add(actionRequest, PrincipalException.class);
			}
		} catch (Exception e) {
			_log.error("IPAC : Error while editing ProcessCustomer Map",
					e);
			actionResponse.setRenderParameter("mvcPath",
					"/html/customercatalogmanagement/manageProcess.jsp");
			SessionErrors.add(actionRequest, e.getClass());

		}
	}
	
	/*
	 * Method to get the list of existing tTProcess customer map Id's
	 */

	public List<Long> getAvailableTTDProcessCustomerIds(long organizationId,
			long[] TTDProcessIdMapIds) throws SystemException {

		try {
			DynamicQuery dq = DynamicQueryFactoryUtil
					.forClass(TTDProcessCustomerMap.class);
					dq.add(PropertyFactoryUtil.forName("organizationId").eq(
							organizationId));
					dq.add(PropertyFactoryUtil.forName("TTDProcessId").in(
							TTDProcessIdMapIds));		
					dq.setProjection(
							ProjectionFactoryUtil.property("TTDProcessId"));

			@SuppressWarnings("unchecked")
			List<Long> availableProcessIds = TTDProcessCustomerMapLocalServiceUtil
					.dynamicQuery(dq);

			return availableProcessIds;
		} catch (Exception e) {
			_log.error(
					"IPAC : Error while getting avaialble TTDProcessId for ProcessCustomer Map",
					e);
		}

		return null;
	}
	
	
	
	/**
	 * Action Method for updating TTDPSubProcess mapping to customer
	 * 
	 * @throws SystemException
	 * @throws PortalException
	 * 
	 */
	public void updateTTDPSubProcessCustomerMap(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException, PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		
		try {
			long organizationId = ParamUtil.getLong(actionRequest, "organizationId");
			long[] addPSubProcessMapIds = StringUtil.split(
					ParamUtil.getString(actionRequest, "addSubProcessMapIds"),
					0L);
			Organization project=OrganizationLocalServiceUtil.getOrganization(organizationId);
			if (ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project))
			{
				if (addPSubProcessMapIds.length > 0) {

					List<Long> availablePSubProcessIds = getAvailableTTDPSubProcessCustomerIds(organizationId, addPSubProcessMapIds);
					
						for (long addTTDPSubProcessId : addPSubProcessMapIds) {
							if (!availablePSubProcessIds
									.contains(addTTDPSubProcessId)) {

								TTDPSubProcessCustomerMapLocalServiceUtil
										.addTTDPSubProcessCustomerMapping(
												addTTDPSubProcessId,
												organizationId, TTDPSubProcessMapLocalServiceUtil.getTTDPSubProcessMap(addTTDPSubProcessId).getNameMap(),
												themeDisplay.getCompanyId(),
												themeDisplay.getUserId(),
												CCStatus.ACTIVE_STATUS);
							} else {

								TTDPSubProcessCustomerMapLocalServiceUtil
										.updateTTDPSubProcessCustomerMapping(
												addTTDPSubProcessId,
												organizationId, 
												themeDisplay.getUserId(),
												CCStatus.ACTIVE_STATUS);
							}
						}
				}

			} else {
				_log.error("IPAC : Error while creating SubProcess Customer Map . User '"
						+ themeDisplay.getUserId()
						+ "' does not have permission to create SubProcess Customer Map.");
				SessionErrors.add(actionRequest, PrincipalException.class);
			}

		} catch (Exception e) {

			_log.error(
					"IPAC : Error while creating SubProcessCustomer Map", e);
			actionResponse.setRenderParameter("mvcPath",
					"/html/customercatalogmanagement/manageSubProcess.jsp");
			SessionErrors.add(actionRequest, e.getClass());
		}

	}
	
	
	/*
	 * Action Method to edit the PSubProcessCustomerMap
	 */

	public void editTTDPSubProcessCustomerMap(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException, PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		

		try {
			long tTDPSubProcessCustomerId = ParamUtil.getLong(actionRequest, "tTDPSubProcessCustomerId");
			int statusId = ParamUtil.getInteger(actionRequest, "statusId");
			Map<Locale, String> name =
					LocalizationUtil.getLocalizationMap(actionRequest, "name");			TTDPSubProcessCustomerMap ttdpSubProcessCustomerMap=TTDPSubProcessCustomerMapLocalServiceUtil.getTTDPSubProcessCustomerMap(tTDPSubProcessCustomerId);
			Organization project=OrganizationLocalServiceUtil.getOrganization(ttdpSubProcessCustomerMap.getOrganizationId());
			if (ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project))
			{
				TTDPSubProcessCustomerMapLocalServiceUtil
						.editTTDPSubProcessCustomerMapping(tTDPSubProcessCustomerId, name,
								themeDisplay.getUserId(), statusId);

			} else {
				_log.error("IPAC : Error while creating SubProcess Customer Map . User '"
						+ themeDisplay.getUserId()
						+ "' does not have permission to create SubProcess Customer Map.");
				SessionErrors.add(actionRequest, PrincipalException.class);
			}
		} catch (Exception e) {
			_log.error("IPAC : Error while editing SubProcessCustomer Map",
					e);
			actionResponse.setRenderParameter("mvcPath",
					"/html/customercatalogmanagement/manageSubProcess.jsp");
			SessionErrors.add(actionRequest, e.getClass());

		}
	}
	
	/*
	 * Method to get the list of existing tTPSubProcess customer map Id's
	 */

	public List<Long> getAvailableTTDPSubProcessCustomerIds(long organizationId,
			long[] TTDPSubProcessIdMapIds) throws SystemException {

		try {
			DynamicQuery dq = DynamicQueryFactoryUtil
					.forClass(TTDPSubProcessCustomerMap.class);
					dq.add(PropertyFactoryUtil.forName("organizationId").eq(
							organizationId));
					dq.add(PropertyFactoryUtil.forName("TTDPSubProcessId").in(
							TTDPSubProcessIdMapIds));		
					dq.setProjection(
							ProjectionFactoryUtil.property("TTDPSubProcessId"));

			@SuppressWarnings("unchecked")
			List<Long> availablePSubProcessIds = TTDPSubProcessCustomerMapLocalServiceUtil
					.dynamicQuery(dq);

			return availablePSubProcessIds;
		} catch (Exception e) {
			_log.error(
					"IPAC : Error while getting avaialble TTDPSubProcessId for PSubProcessCustomer Map",
					e);
		}

		return null;
	}
	
	
	
	/**
	 * Action Method for updating TTDPSPTask mapping to customer
	 * 
	 * @throws SystemException
	 * @throws PortalException
	 * 
	 */
	public void updateTTDPSPTaskCustomerMap(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException, PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		
		try {
			long organizationId = ParamUtil.getLong(actionRequest, "organizationId");
			long doGroupId=ParamUtil.getLong(actionRequest, "doGroupId");
			long tTDPSubProcessId = ParamUtil.getLong(actionRequest, "tTDPSubProcessId");
			long[] addTaskMapIds = StringUtil.split(
					ParamUtil.getString(actionRequest, "addTaskMapIds"),
					0L);
			Organization project=OrganizationLocalServiceUtil.getOrganization(organizationId);
			if (ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project))
			{
				if (addTaskMapIds.length > 0) {

					List<Long> availablePSPTaskIds = TTDPSPTaskCustomerMapLocalServiceUtil.findAllByOrganizationAndSubProcess(organizationId, tTDPSubProcessId);
					
						for (long taskId : addTaskMapIds) {
							if (!availablePSPTaskIds.contains(taskId)) {

								TTDPSPTaskCustomerMapLocalServiceUtil
										.addTTDPSPTaskCustomerMapping(
												taskId, tTDPSubProcessId,
												organizationId, TaskLocalServiceUtil.getTask(taskId).getName(),
												TaskLocalServiceUtil.getTask(taskId).getTaskTypeId(),
												themeDisplay.getCompanyId(),
												themeDisplay.getUserId(),
												CCStatus.ACTIVE_STATUS,doGroupId,
												0l,0l,0);
							} else {

								TTDPSPTaskCustomerMapLocalServiceUtil
										.updateTTDPSPTaskCustomerMapping(
												taskId, tTDPSubProcessId,
												organizationId,
												themeDisplay.getUserId(),
												CCStatus.ACTIVE_STATUS,doGroupId);
							}
						}
				}

			} else {
				_log.error("IPAC : Error while creating PSPTask Customer Map . User '"
						+ themeDisplay.getUserId()
						+ "' does not have permission to create PSPTask Customer Map.");
				SessionErrors.add(actionRequest, PrincipalException.class);
			}

		} catch (Exception e) {

			_log.error(
					"IPAC : Error while creating PSPTaskCustomer Map", e);
			actionResponse.setRenderParameter("mvcPath",
					"/html/customercatalogmanagement/managePSPTask.jsp");
			SessionErrors.add(actionRequest, e.getClass());
		}

	}
	
	
	/*
	 * Action Method to edit the PSPTaskCustomerMap
	 */

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		String cmd=ParamUtil.getString(resourceRequest, Constants.CMD,"");
		if(cmd.equalsIgnoreCase("getOUChildren"))
		{
			long ouID=ParamUtil.getLong(resourceRequest, "ouId",0);
			
			try {
				List<Organization> ous=OrganizationLocalServiceUtil.search(themeDisplay.getCompanyId(), ouID, null, CustomerConstants.TYPE_OU, null, null, null, QueryUtil.ALL_POS,QueryUtil.ALL_POS);
				List<Organization> competencies=OrganizationLocalServiceUtil.search(themeDisplay.getCompanyId(), ouID, null, CustomerConstants.TYPE_COMPETENCY, null, null, null, QueryUtil.ALL_POS,QueryUtil.ALL_POS);
				JSONObject ouObj=JSONFactoryUtil.createJSONObject();
				JSONArray ouArr=JSONFactoryUtil.createJSONArray();
				JSONArray compArr=JSONFactoryUtil.createJSONArray();
				for(Organization ou:ous)
				{
					if(ou.getStatusId()== ListTypeConstants.ORGANIZATION_STATUS_DEFAULT)
					{
						JSONObject obj=JSONFactoryUtil.createJSONObject();
						obj.put("id", ou.getOrganizationId());
						obj.put("name",ou.getName());
						ouArr.put(obj);
						
					}
				}
				for(Organization competency:competencies)
				{
					if(competency.getStatusId()== ListTypeConstants.ORGANIZATION_STATUS_DEFAULT)
					{
						JSONObject obj=JSONFactoryUtil.createJSONObject();
						obj.put("id", competency.getOrganizationId());
						obj.put("name",competency.getName());
						compArr.put(obj);
						
					}
				}
				ouObj.put("ous", ouArr);
				ouObj.put("competencies", compArr);
			
				resourceResponse.getWriter().write(ouObj.toString());
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				_log.error(
						"IPAC : Error while fetching OU children ", e);
				}
		}
		
		else if(cmd.equalsIgnoreCase("getGroups"))
		{

			long competencyID=ParamUtil.getLong(resourceRequest, "competencyId",0);
			
			try {
				List<Organization> groups=OrganizationLocalServiceUtil.search(themeDisplay.getCompanyId(), competencyID, null, CustomerConstants.TYPE_GROUP, null, null, null, QueryUtil.ALL_POS,QueryUtil.ALL_POS);
				JSONArray grpArr=JSONFactoryUtil.createJSONArray();
				for(Organization group:groups)
				{
					if(group.getStatusId()== ListTypeConstants.ORGANIZATION_STATUS_DEFAULT)
					{
						JSONObject obj=JSONFactoryUtil.createJSONObject();
						obj.put("id", group.getOrganizationId());
						obj.put("name",group.getName());
						grpArr.put(obj);
						
					}
				}
				
				
				resourceResponse.getWriter().write(grpArr.toString());
			} catch (SystemException e) {
				_log.error("IPAC : Error while fetching groups ",e);
			}
		
			
		}
		else if (cmd.equals("getDataList")) {
				
			try {
			
				getDataList(resourceRequest, resourceResponse);
				
			} catch (Exception e) {
			
				_log.error("IPAC : Error while fetching data.",e);
				
			}
		
		}
		else if(cmd.equals("getDataListOfSelectedOptions")) {
			
			try {
				
				getDataListOfSelectedOptions(resourceRequest,resourceResponse);
				
			} catch (Exception e) {
			
				_log.error("IPAC : Error while fetching data for selected options.",e);
				
			}
			
		}
		else if (cmd.equals("getChildNodesOfCustomer")) {
			
			try {
			
				getChildNodesOfCustomer(resourceRequest, resourceResponse);
				
			} catch (Exception e) {
			
				_log.error("IPAC : Error while fetching child nodes.",e);
				
			}
		
		}
		else if (cmd.equals("getChildNodesOfProject")) {
			
			try {
			
				getChildNodesOfProject(resourceRequest, resourceResponse);
				
			} catch (Exception e) {
			
				_log.error("IPAC : Error while fetching child nodes.",e);
				
			}
		
		}
		else if (cmd.equals("getChildNodesOfTowerCustomer")) {
			
			try {
			
				getChildNodesOfTowerCustomer(resourceRequest, resourceResponse);
				
			} catch (Exception e) {
			
				_log.error("IPAC : Error while fetching child nodes.",e);
				
			}
		
		}
		else if (cmd.equals("getChildNodesOfTTechnologyCustomer")) {
			
			try {
			
				getChildNodesOfTTechnologyCustomer(resourceRequest, resourceResponse);
				
			} catch (Exception e) {
			
				_log.error("IPAC : Error while fetching child nodes.",e);
				
			}
		
		}
		else if (cmd.equals("getChildNodesOfTTDeliverableCustomer")) {
			
			try {
			
				getChildNodesOfTTDeliverableCustomer(resourceRequest, resourceResponse);
				
			} catch (Exception e) {
			
				_log.error("IPAC : Error while fetching child nodes.",e);
				
			}
		
		}
		else if (cmd.equals("getChildNodesOfTTDProcessCustomer")) {
			
			try {
			
				getChildNodesOfTTDProcessCustomer(resourceRequest, resourceResponse);
				
			} catch (Exception e) {
			
				_log.error("IPAC : Error while fetching child nodes.",e);
				
			}
		
		}
		else if (cmd.equals("getChildNodesOfTTDPSubProcessCustomer")) {
			
			try {
			
				getChildNodesOfTTDPSubProcessCustomer(resourceRequest, resourceResponse);
				
			} catch (Exception e) {
			
				_log.error("IPAC : Error while fetching child nodes.",e);
				
			}
		
		}
		
		else if (cmd.equals("getCatalogElementsCount")) {
			
			try {
			
				getCatalogElementsCount(resourceRequest, resourceResponse);
				
			} catch (Exception e) {
			
				_log.error("IPAC : Error while fetching elements count.",e);
				
			}
		
		}
		
	}

	/*
	 * Resource Method for getting the combo box data list according to selection
	 *  
	 */
	
	public void getDataList(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortalException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long customerId = ParamUtil.getLong(resourceRequest, "customerId",0);
		long projectId = ParamUtil.getLong(resourceRequest, "projectId",0);
		long towerCustomerMapId = ParamUtil.getLong(resourceRequest, "towerCustomerMapId",0);
		long tTechnologyCustomerMapId = ParamUtil.getLong(resourceRequest, "tTechnologyCustomerMapId",0);
		long ttDeliverableCustomerMapId = ParamUtil.getLong(resourceRequest, "ttDeliverableCustomerMapId",0);
		long ttdProcessCustomerMapId = ParamUtil.getLong(resourceRequest, "ttdProcessCustomerMapId",0);
		
		
		Organization customer = null;
		Organization project = null;
		TowerCustomerMap tcm = null;
		TTechnologyCustomerMap ttcm = null;
		TTDeliverableCustomerMap ttdcm = null;
		TTDProcessCustomerMap ttdpcm = null; 
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
	
		try {
			
			if(ttdProcessCustomerMapId != 0) {
				
				ttdpcm = TTDProcessCustomerMapLocalServiceUtil.getTTDProcessCustomerMap(ttdProcessCustomerMapId);
				
				projectId = ttdpcm.getOrganizationId();
				
			}
			else if(ttDeliverableCustomerMapId != 0) {
				
				ttdcm = TTDeliverableCustomerMapLocalServiceUtil.getTTDeliverableCustomerMap(ttDeliverableCustomerMapId);
				
				projectId = ttdcm.getOrganizationId();
				
			}
			else if(tTechnologyCustomerMapId != 0) {
				
				ttcm = TTechnologyCustomerMapLocalServiceUtil.getTTechnologyCustomerMap(tTechnologyCustomerMapId);
				
				projectId = ttcm.getOrganizationId();
				
			}
			else if(towerCustomerMapId != 0) {
				
				tcm = TowerCustomerMapLocalServiceUtil.getTowerCustomerMap(towerCustomerMapId);
				
				projectId = tcm.getOrganizationId();
				
			}
			
		
			if(projectId == 0) {
				
				customer = OrganizationLocalServiceUtil.getOrganization(customerId);
				
				if(CatalogPermission.isCustomerCompleteViewer(themeDisplay, customer)) {
    	 			
    	 			List<Organization> projects = CustomerCatalogUtil.getCustomerProjects(themeDisplay, customer); 
    	 					
    	 			for(Organization proj : projects) {
    	 			
    	 				JSONObject jo = JSONFactoryUtil.createJSONObject();
        	 			
    	 				jo.put("projectId", proj.getOrganizationId());
    	 				jo.put("name", proj.getName());
    	 				
    	 				jsonArray.put(jo);
    	 				
    	 			}
    	 			
    	 			resourceResponse.getWriter().write(jsonArray.toString());
    	 			
    	 		}
				
			}
			else {
				
				project = OrganizationLocalServiceUtil.getOrganization(projectId);
				
				if(CatalogPermission.isProjectCompleteViewer(themeDisplay, project) ) {
					
					if(ttdProcessCustomerMapId != 0) {
						
	        	 		List<TTDPSubProcessCustomerMap> ttdpscms = CustomerCatalogUtil.getTTDSubProcessCustomerMapsByTTDProcess(ttdpcm);
	        	 	
	        	 		for(TTDPSubProcessCustomerMap ttdpscm1 : ttdpscms) {
	        	 	
	        	 			JSONObject jo = JSONFactoryUtil.createJSONObject();
	        	 			
	        	 			jo.put("ttdpSubProcessCustomerMapId", ttdpscm1.getTTDPSubProcessCustomerId());
	    	 				jo.put("name", ttdpscm1.getName(themeDisplay.getLocale()));
	    	 				
	    	 				jsonArray.put(jo);
	        	 		
	        	 		}
	        	 		
	        	 		resourceResponse.getWriter().write(jsonArray.toString());
					}
					else if(ttDeliverableCustomerMapId != 0) {
						
	        	 		List<TTDProcessCustomerMap> ttdpcms = CustomerCatalogUtil.getTTDProcessCustomerMapsByTTDeliverable(ttdcm);
	        	 
	        	 		for(TTDProcessCustomerMap ttdpcm1 : ttdpcms) {
		        
	        	 			JSONObject jo = JSONFactoryUtil.createJSONObject();
	        	 			
	        	 			jo.put("ttdProcessCustomerMapId", ttdpcm1.getTTDProcessCustomerId());
	    	 				jo.put("name", ttdpcm1.getName(themeDisplay.getLocale()));
	    	 				
	    	 				jsonArray.put(jo);
	        	 		
	        	 		}
	        	 		
	        	 		resourceResponse.getWriter().write(jsonArray.toString());
	        	 		
					}
					else if(tTechnologyCustomerMapId != 0) {
						
	        	 		List<TTDeliverableCustomerMap> ttdcms = CustomerCatalogUtil.getTTDeliverableCustomerMapsByTTechnology(ttcm);
	        	 		
	        	 		for(TTDeliverableCustomerMap ttdcm1 : ttdcms) {
		        	 	
	        	 			JSONObject jo = JSONFactoryUtil.createJSONObject();
	        	 			
	        	 			jo.put("ttDeliverableCustomerMapId", ttdcm1.getTTDeliverableCustomerId());
	    	 				jo.put("name", ttdcm1.getName(themeDisplay.getLocale()));
	    	 				
	    	 				jsonArray.put(jo);
	        	 		
	        	 		}
	        	 		
	        	 		resourceResponse.getWriter().write(jsonArray.toString());
	        	 		
					}
					else if(towerCustomerMapId != 0) {
						
	        	 		List<TTechnologyCustomerMap> ttcms = CustomerCatalogUtil.getTTechnologyCustomerMapsByTower(tcm);
						
	        	 		for(TTechnologyCustomerMap ttcm1 : ttcms) {
	        	 			
	        	 			JSONObject jo = JSONFactoryUtil.createJSONObject();
		        	 			
	        	 			jo.put("tTechnologyCustomerMapId", ttcm1.getTTechnologyCustomerId());
	    	 				jo.put("name", ttcm1.getName(themeDisplay.getLocale()));
	    	 				
	    	 				jsonArray.put(jo);
	    	 				
	        	 		}
	        	 		
	        	 		resourceResponse.getWriter().write(jsonArray.toString());
	        
					}
					else {
						
						List<TowerCustomerMap> tcms = TowerCustomerMapLocalServiceUtil.findActiveTowerCustomerMapByOrganizationId(project.getOrganizationId());
						
	        	 		for(TowerCustomerMap tcm1 : tcms) {
		        	 	
	        	 			JSONObject jo = JSONFactoryUtil.createJSONObject();
	        	 			
	        	 			jo.put("towerCustomerMapId", tcm1.getTowerCustomerId());
	    	 				jo.put("name", tcm1.getName(themeDisplay.getLocale()));
	    	 				
	    	 				jsonArray.put(jo);
	        	 		
	        	 		}

	        	 		resourceResponse.getWriter().write(jsonArray.toString());
	        	 		
					}
					
				}
				
			}
			
			
		}
		catch(Exception e) {
			
			_log.error("IPAC : Error fetching the datalist " + e);
			
		}
	}
	
	/*
	 *  Resource Method to get the Treeview JSON data based on the selected filter options
	 * 
	 */
	
	public void getDataListOfSelectedOptions(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException, PortletException, SystemException, PortalException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		PortletPreferences prefs=PortalPreferencesLocalServiceUtil.getPreferences(themeDisplay.getCompanyId(), PortletKeys.PREFS_OWNER_TYPE_COMPANY);
		long companyOrgID=Long.parseLong(prefs.getValue(CustomerConstants.COMPANY_ORG_ID, "0"));
		Organization companyOrg=null;
		if(companyOrgID !=0 )
		{
			companyOrg=OrganizationLocalServiceUtil.getOrganization(companyOrgID);
		}
		
		long customerId = ParamUtil.getLong(resourceRequest, "customerId",0);
		long projectId = ParamUtil.getLong(resourceRequest, "projectId",0);
		long towerCustomerMapId = ParamUtil.getLong(resourceRequest, "towerCustomerMapId",0);
		long tTechnologyCustomerMapId = ParamUtil.getLong(resourceRequest, "tTechnologyCustomerMapId",0);
		long ttDeliverableCustomerMapId = ParamUtil.getLong(resourceRequest, "ttDeliverableCustomerMapId",0);
		long ttdProcessCustomerMapId = ParamUtil.getLong(resourceRequest, "ttdProcessCustomerMapId",0);
		long ttdpSubProcessCustomerMapId = ParamUtil.getLong(resourceRequest, "ttdpSubProcessCustomerMapId",0);
		
		Organization customer = null;
		Organization project = null;
		
		if(customerId != 0) {
			
			customer = OrganizationLocalServiceUtil.getOrganization(customerId);
			
		}
		if(projectId != 0) {
			
			project = OrganizationLocalServiceUtil.getOrganization(projectId);
			
		}
		
		// Added 'Customer!=null' in 'if' condition for sonar bug by shashi on 4th may 2020
		if(customer !=null && project != null)
		{
			if(ProjectCatalogPermission.isProjectCatalogViewer(themeDisplay, project)) 
			{
				JSONArray custArr = JSONFactoryUtil.createJSONArray();
					JSONObject custObj = JSONFactoryUtil.createJSONObject();
		    	
					
					
		    		custObj.put("label", customer.getName());
		    		custObj.put("id", String.valueOf(customer.getOrganizationId()));
		    		custObj.put("leaf", false);	
		    		custObj.put("expanded",true); 
					
		    			
		    			JSONArray projArr = JSONFactoryUtil.createJSONArray();
		    			JSONObject projObj = JSONFactoryUtil.createJSONObject();
		        	
		        		projObj.put("label", project.getName());
		        		projObj.put("id", String.valueOf(project.getOrganizationId()));
		        		projObj.put("leaf", false);
		        		projObj.put("expanded",true);
		    			
		        		if(towerCustomerMapId != 0) {
		        			
		        			JSONArray tcmArr = JSONFactoryUtil.createJSONArray();
		        			JSONObject tcmObj = JSONFactoryUtil.createJSONObject();
		        			TowerCustomerMap tcm = TowerCustomerMapLocalServiceUtil.getTowerCustomerMap(towerCustomerMapId);
		        			
		            		tcmObj.put("label", tcm.getName(themeDisplay.getLocale()));
		            		tcmObj.put("id", String.valueOf(tcm.getTowerCustomerId()));
		            		tcmObj.put("leaf", false);
		            		tcmObj.put("expanded",true);
		        			
		            		if(tTechnologyCustomerMapId != 0) {
		            			
		            			JSONArray ttcmArr = JSONFactoryUtil.createJSONArray();
		            			JSONObject ttcmObj = JSONFactoryUtil.createJSONObject();
		            			TTechnologyCustomerMap ttcm = TTechnologyCustomerMapLocalServiceUtil.getTTechnologyCustomerMap(tTechnologyCustomerMapId);
		            			
		                		ttcmObj.put("label", ttcm.getName(themeDisplay.getLocale()));
		                		ttcmObj.put("id", String.valueOf(ttcm.getTTechnologyCustomerId()));
		                		ttcmObj.put("leaf", false);
		                		ttcmObj.put("expanded",true);
		            			
		                		if(ttDeliverableCustomerMapId != 0) {
		                			
		                			JSONArray ttdcmArr = JSONFactoryUtil.createJSONArray();
		                			JSONObject ttdcmObj = JSONFactoryUtil.createJSONObject();
		                			TTDeliverableCustomerMap ttdcm = TTDeliverableCustomerMapLocalServiceUtil.getTTDeliverableCustomerMap(ttDeliverableCustomerMapId);
		                			
		                    		ttdcmObj.put("label", ttdcm.getName(themeDisplay.getLocale()));
		                    		ttdcmObj.put("id", String.valueOf(ttdcm.getTTDeliverableCustomerId()));
		                    		ttdcmObj.put("leaf", false);
		                    		ttdcmObj.put("expanded",true);
		                			
		                    		if(ttdProcessCustomerMapId != 0) {
		                    			
		                    			JSONArray ttdpcmArr = JSONFactoryUtil.createJSONArray();
		                    			JSONObject ttdpcmObj = JSONFactoryUtil.createJSONObject();
		                    			TTDProcessCustomerMap ttdpcm = TTDProcessCustomerMapLocalServiceUtil.getTTDProcessCustomerMap(ttdProcessCustomerMapId);
		                    			
		                        		ttdpcmObj.put("label", ttdpcm.getName(themeDisplay.getLocale()));
		                        		ttdpcmObj.put("id", String.valueOf(ttdpcm.getTTDProcessCustomerId()));
		                        		ttdpcmObj.put("leaf", false);
		                        		ttdpcmObj.put("expanded",true);
		                    			
		                        		if(ttdpSubProcessCustomerMapId != 0) {
		                        			
		                        			JSONArray ttdpspcmArr = JSONFactoryUtil.createJSONArray();
		                        			JSONObject ttdpspcmObj = JSONFactoryUtil.createJSONObject();
		                        			TTDPSubProcessCustomerMap ttdpspcm = TTDPSubProcessCustomerMapLocalServiceUtil.getTTDPSubProcessCustomerMap(ttdpSubProcessCustomerMapId);
		                        			
		                            		ttdpspcmObj.put("label", ttdpspcm.getName(themeDisplay.getLocale()));
		                            		ttdpspcmObj.put("id", String.valueOf(ttdpspcm.getTTDPSubProcessCustomerId()));
		                            		ttdpspcmObj.put("leaf", false);
		                            		ttdpspcmObj.put("expanded",true);
		                            		ttdpspcmObj.put("children", CustomerCatalogUtil.getChildTTDPSPTaskCustomerNodes(ttdpspcm, resourceResponse, themeDisplay));
		                        			
		                            		ttdpspcmArr.put(ttdpspcmObj);
		                            		
		                            		ttdpcmObj.put("children", ttdpspcmArr);
		                            		
		                        		}
		                        		else {
		                        			
		                        			ttdpcmObj.put("children", CustomerCatalogUtil.getChildTTDPSubProcessCustomerNodes(ttdpcm, resourceResponse, themeDisplay));
		                        			
		                        		}
		                        		
		                        		ttdpcmArr.put(ttdpcmObj);
		                        		
		                        		ttdcmObj.put("children", ttdpcmArr);
		                        		
		                    		}
		                    		else {
		                    			
		                    			ttdcmObj.put("children", CustomerCatalogUtil.getChildTTDProcessCustomerNodes(ttdcm, resourceResponse, themeDisplay));
		                    			
		                    		}
		                    		
		                    		ttdcmArr.put(ttdcmObj);
		                    		
		                    		ttcmObj.put("children", ttdcmArr);
		                    		
		                		}
		                		else {
		                			
		                			ttcmObj.put("children",CustomerCatalogUtil.getChildTTDeliverableCustomerNodes(ttcm, resourceResponse, themeDisplay));
		                			
		                		}
		                		
		                		ttcmArr.put(ttcmObj);
		                		
		                		tcmObj.put("children", ttcmArr);
		                		
		            		}
		            		else {
		            			
		            			tcmObj.put("children", CustomerCatalogUtil.getChildTTechnologyCustomerNodes(tcm, resourceResponse, themeDisplay));
		            			
		            		}
		            		
		            		tcmArr.put(tcmObj);
		            		
		            		projObj.put("children", tcmArr);
		            		
		        		}
		        		else {
		        			
		        			projObj.put("children", CustomerCatalogUtil.getChildTowerCustomerNodes(project, resourceResponse, themeDisplay));
		        			
		        		}
		        		
		        		projArr.put(projObj);
		        		
		        		custObj.put("children", projArr);
		        		
					
					custArr.put(custObj);
		    		
		    		resourceResponse.getWriter().write(custArr.toString());
			}
		}
		else if(customer != null )
		{
			if(CatalogPermission.isCustomerCompleteViewer(themeDisplay, customer)) {
					
					JSONArray custArr = JSONFactoryUtil.createJSONArray();
					JSONObject custObj = JSONFactoryUtil.createJSONObject();
		    	
					
					
		    		custObj.put("label", customer.getName());
		    		custObj.put("id", String.valueOf(customer.getOrganizationId()));
		    		custObj.put("leaf", false);	
		    		custObj.put("expanded",true); 
					
		    	
		  
		    			custObj.put("children", CustomerCatalogUtil.getChildProjectNodes(customer, resourceResponse, themeDisplay));
		    			
		    		
		    		
		    		custArr.put(custObj);
		    		
		    		resourceResponse.getWriter().write(custArr.toString());
		    		
				}
				}
				else if(CatalogPermission.isCompanyCompleteViewer(themeDisplay, companyOrg)) {
					
					JSONArray custArr = JSONFactoryUtil.createJSONArray();
					
					custArr = CustomerCatalogUtil.getCustomerNodes(companyOrg, resourceResponse, themeDisplay);
					
					resourceResponse.getWriter().write(custArr.toString());
					
				}
			
				
	}
	
	/*
	 *  Resource Method for fetching all the active child project nodes of a Customer
	 */
	
	public void getChildNodesOfCustomer(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse ) throws IOException, PortalException, SystemException {
	
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		long customerId = ParamUtil.getLong(resourceRequest, "id",0);
		
		Organization customer = OrganizationLocalServiceUtil.getOrganization(customerId);
		
		if(CatalogPermission.isCustomerCompleteViewer(themeDisplay, customer)) {
		
			JSONArray projArr = CustomerCatalogUtil.getChildProjectNodes(customer, resourceResponse, themeDisplay);
		
			resourceResponse.getWriter().write(projArr.toString());
			
		}
		
	}
	
	/*
	 *  Resource Method for fetching all the active child towerCustomerMap nodes of a Project
	 */
	
	public void getChildNodesOfProject(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse ) throws IOException, PortalException, SystemException {
	
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		long projectId = ParamUtil.getLong(resourceRequest, "id",0);
		
		Organization project = OrganizationLocalServiceUtil.getOrganization(projectId);
		
		if(ProjectCatalogPermission.isProjectCatalogViewer(themeDisplay, project)) {
		
			JSONArray tcmArr = CustomerCatalogUtil.getChildTowerCustomerNodes(project, resourceResponse, themeDisplay);
		
			resourceResponse.getWriter().write(tcmArr.toString());
			
		}
		
	}
	
	/*
	 *  Resource Method for fetching all the active child ttechnologyCustomerMap nodes of a TowerCustomerMap
	 */
	
	public void getChildNodesOfTowerCustomer(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse ) throws IOException, PortalException, SystemException {
	
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		long towerCustomerMapId = ParamUtil.getLong(resourceRequest, "id",0);
	
		TowerCustomerMap tcm = TowerCustomerMapLocalServiceUtil.getTowerCustomerMap(towerCustomerMapId);
	
		Organization project = OrganizationLocalServiceUtil.getOrganization(tcm.getOrganizationId());
		
		if(ProjectCatalogPermission.isProjectCatalogViewer(themeDisplay, project)) {
		
			JSONArray ttcmArr = CustomerCatalogUtil.getChildTTechnologyCustomerNodes(tcm, resourceResponse, themeDisplay);
		
			resourceResponse.getWriter().write(ttcmArr.toString());
			
		}
		
	}
	
	/*
	 *  Resource Method for fetching all the active child ttdeliverableCustomerMap nodes of a TTechnologyCustomerMap
	 */
	
	
	public void getChildNodesOfTTechnologyCustomer(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse ) throws IOException, PortalException, SystemException {
	
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		long ttechnnologyCustomerMapId = ParamUtil.getLong(resourceRequest, "id",0);
	
		TTechnologyCustomerMap ttcm = TTechnologyCustomerMapLocalServiceUtil.getTTechnologyCustomerMap(ttechnnologyCustomerMapId);
	
		Organization project = OrganizationLocalServiceUtil.getOrganization(ttcm.getOrganizationId());
		
		if(ProjectCatalogPermission.isProjectCatalogViewer(themeDisplay, project)) {
		
			JSONArray ttdcmArr = CustomerCatalogUtil.getChildTTDeliverableCustomerNodes(ttcm, resourceResponse, themeDisplay);
		
			resourceResponse.getWriter().write(ttdcmArr.toString());
			
		}
		
	}
	/*
	 *  Resource Method for fetching all the active child ttdProcessCustomerMap nodes of a TTDeliverableCustomerMap
	 */
	
	
	public void getChildNodesOfTTDeliverableCustomer(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse ) throws IOException, PortalException, SystemException {
	
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		long ttDeliverableCustomerMapId = ParamUtil.getLong(resourceRequest, "id",0);
	
		TTDeliverableCustomerMap ttdcm = TTDeliverableCustomerMapLocalServiceUtil.getTTDeliverableCustomerMap(ttDeliverableCustomerMapId);
	
		Organization project = OrganizationLocalServiceUtil.getOrganization(ttdcm.getOrganizationId());
		
		if(ProjectCatalogPermission.isProjectCatalogViewer(themeDisplay, project)) {
		
			JSONArray ttdpcmArr = CustomerCatalogUtil.getChildTTDProcessCustomerNodes(ttdcm, resourceResponse, themeDisplay);
		
			resourceResponse.getWriter().write(ttdpcmArr.toString());
			
		}
		
	}
	
	/*
	 *  Resource Method for fetching all the active child ttdpSubProcessCustomerMap nodes of a TTDProcessCustomerMap
	 */
	
	
	public void getChildNodesOfTTDProcessCustomer(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse ) throws IOException, PortalException, SystemException {
	
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		long ttdProcessCustomerMapId = ParamUtil.getLong(resourceRequest, "id",0);
	
		TTDProcessCustomerMap ttdpcm = TTDProcessCustomerMapLocalServiceUtil.getTTDProcessCustomerMap(ttdProcessCustomerMapId);
	
		Organization project = OrganizationLocalServiceUtil.getOrganization(ttdpcm.getOrganizationId());
		
		if(ProjectCatalogPermission.isProjectCatalogViewer(themeDisplay, project)) {
		
			JSONArray ttdpspcmArr = CustomerCatalogUtil.getChildTTDPSubProcessCustomerNodes(ttdpcm, resourceResponse, themeDisplay);
		
			resourceResponse.getWriter().write(ttdpspcmArr.toString());
			
		}
		
	}
	
	/*
	 *  Resource Method for fetching all the active child ttdpSPTaskCustomerMap nodes of a TTDPSubProcessCustomerMap
	 */
	
	
	public void getChildNodesOfTTDPSubProcessCustomer(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse ) throws IOException, PortalException, SystemException {
	
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		long ttdpSubProcessCustomerMapId = ParamUtil.getLong(resourceRequest, "id",0);
	
		TTDPSubProcessCustomerMap ttdpspcm = TTDPSubProcessCustomerMapLocalServiceUtil.getTTDPSubProcessCustomerMap(ttdpSubProcessCustomerMapId);
	
		Organization project = OrganizationLocalServiceUtil.getOrganization(ttdpspcm.getOrganizationId());
		
		if(ProjectCatalogPermission.isProjectCatalogViewer(themeDisplay, project)) {
		
			JSONArray ttdpsptcmArr = CustomerCatalogUtil.getChildTTDPSPTaskCustomerNodes(ttdpspcm, resourceResponse, themeDisplay);
		
			resourceResponse.getWriter().write(ttdpsptcmArr.toString());
			
		}
		
	}
	
	/*
	 *  Resource Method to get the Elements Count based on the selected filter options
	 * 
	 */
	
	public void getCatalogElementsCount(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException, PortletException, SystemException, PortalException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		JSONObject jo = JSONFactoryUtil.createJSONObject("{customer:0,project:0,tower:0,technology:0,deliverable:0,process:0,subprocess:0,tasks:0}");
		
		PortletPreferences prefs=PortalPreferencesLocalServiceUtil.getPreferences(themeDisplay.getCompanyId(), PortletKeys.PREFS_OWNER_TYPE_COMPANY);
		long companyOrgID=Long.parseLong(prefs.getValue(CustomerConstants.COMPANY_ORG_ID, "0"));
		Organization companyOrg=null;
		if(companyOrgID !=0 )
		{
			companyOrg=OrganizationLocalServiceUtil.getOrganization(companyOrgID);
		}
		
		
		long customerId = ParamUtil.getLong(resourceRequest, "customerId",0);
		long projectId = ParamUtil.getLong(resourceRequest, "projectId",0);
		long towerCustomerMapId = ParamUtil.getLong(resourceRequest, "towerCustomerMapId",0);
		long tTechnologyCustomerMapId = ParamUtil.getLong(resourceRequest, "tTechnologyCustomerMapId",0);
		long ttDeliverableCustomerMapId = ParamUtil.getLong(resourceRequest, "ttDeliverableCustomerMapId",0);
		long ttdProcessCustomerMapId = ParamUtil.getLong(resourceRequest, "ttdProcessCustomerMapId",0);
		long ttdpSubProcessCustomerMapId = ParamUtil.getLong(resourceRequest, "ttdpSubProcessCustomerMapId",0);
		
		Organization customer = null;
		Organization project = null;
		
		List<Organization> customers = new ArrayList<Organization>();
		List<Organization> projects = new ArrayList<Organization>();
		List<Long> tIds = new ArrayList<Long>();
		List<Long> ttIds = new ArrayList<Long>();
		List<Long> ttdIds = new ArrayList<Long>();
		List<Long> ttdpIds = new ArrayList<Long>();
		List<Long> ttdpspIds = new ArrayList<Long>();
		List<Long> ttdpsptIds = new ArrayList<Long>();
		
		if(customerId != 0) {
			
			customer = OrganizationLocalServiceUtil.getOrganization(customerId);
			
			customers.add(customer);
			
		}
		else {
			
			customers = CustomerCatalogUtil.getCompanyCustomers(themeDisplay, companyOrg);
			
		}
		if(projectId != 0) {
			
			project = OrganizationLocalServiceUtil.getOrganization(projectId);
			
			projects.add(project);
			
		}
		else if(customers.size() > 0){
			
			projects = CustomerCatalogUtil.getProjectsByCustList(themeDisplay, customers);
			
		}
		
		
		if((customer ==  null && project == null && !CatalogPermission.isCompanyCompleteViewer(themeDisplay, companyOrg)) || (customer != null && project == null && !CatalogPermission.isCustomerCompleteViewer(themeDisplay, customer)) || (customer != null && project != null && !CatalogPermission.isCustomerCompleteViewer(themeDisplay, project))) {
			
			_log.error("IPAC : Error getting the elements count : " + themeDisplay.getUser().getFullName() + "does not have permissions to get the count..");
			
			return;
			
		}
		
		if(towerCustomerMapId != 0) {
		
			tIds.add(TowerCustomerMapLocalServiceUtil.getTowerCustomerMap(towerCustomerMapId).getTowerId());
			
		}
		else if(projects.size() > 0) {
			
			tIds = TowerCustomerMapLocalServiceUtil.getUniqueTCMsByProjList(projects);
			
		}
		if(tTechnologyCustomerMapId != 0) {
			
			ttIds.add(TTechnologyCustomerMapLocalServiceUtil.getTTechnologyCustomerMap(tTechnologyCustomerMapId).getTowerTechnologyId());
			
		}
		else if(tIds.size() > 0) {
			
			ttIds = TTechnologyCustomerMapLocalServiceUtil.getUniqueTTIDsByTIDList(projects, tIds);
			
		}
		if(ttDeliverableCustomerMapId != 0) {
			
			ttdIds.add(TTDeliverableCustomerMapLocalServiceUtil.getTTDeliverableCustomerMap(ttDeliverableCustomerMapId).getTTDeliverableId());
			
		}
		else if(ttIds.size() > 0) {
			
			ttdIds = TTDeliverableCustomerMapLocalServiceUtil.getUniqueTTDIDsByTTIDList(projects, ttIds);
			
		}
		if(ttdProcessCustomerMapId != 0) {
			
			ttdpIds.add(TTDProcessCustomerMapLocalServiceUtil.getTTDProcessCustomerMap(ttdProcessCustomerMapId).getTTDProcessId());
			
		}
		else if(ttdIds.size() > 0) {
		

			ttdpIds = TTDProcessCustomerMapLocalServiceUtil.getUniqueTTDPIDsByTTDIDList(projects, ttdIds);
			
		}
		if(ttdpSubProcessCustomerMapId != 0) {
			
			ttdpspIds.add(TTDPSubProcessCustomerMapLocalServiceUtil.getTTDPSubProcessCustomerMap(ttdpSubProcessCustomerMapId).getTTDPSubProcessId());
			
		}
		else if(ttdpIds.size() > 0) {
			
			ttdpspIds = TTDPSubProcessCustomerMapLocalServiceUtil.getUniqueTTDPSPIDsByTTDPIDList(projects, ttdpIds);
			
		}
		if(ttdpspIds.size() > 0) {
		
			ttdpsptIds = TTDPSPTaskCustomerMapLocalServiceUtil.getUniqueTTDPSPTIDsByTTDPSPIDList(projects, ttdpspIds);
			
		}
		
		jo.put("customer", customers.size());
		
		jo.put("project", projects.size());
		
		jo.put("tower", tIds.size());
		
		jo.put("technology", ttIds.size());
		
		jo.put("deliverable", ttdIds.size());
		
		jo.put("process", ttdpIds.size());
		
		jo.put("subprocess", ttdpspIds.size());
		
		jo.put("tasks", ttdpsptIds.size());
		
		resourceResponse.getWriter().write(jo.toString());
		
	}
	
	public void editTTDPSPTaskCustomerMap(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException, PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			
			long tTDPSPTaskCustomerId = ParamUtil.getLong(actionRequest, "tTDPSPTaskCustomerId");
			int statusId = ParamUtil.getInteger(actionRequest, "statusId");
			long doGroupId=ParamUtil.getLong(actionRequest, "doGroupId");
			Map<Locale, String> name =
					LocalizationUtil.getLocalizationMap(actionRequest, "name");
			TTDPSPTaskCustomerMap ttdpspTaskCustomerMap=TTDPSPTaskCustomerMapLocalServiceUtil.getTTDPSPTaskCustomerMap(tTDPSPTaskCustomerId);
			Organization project=OrganizationLocalServiceUtil.getOrganization(ttdpspTaskCustomerMap.getOrganizationId());
			if (ProjectCatalogPermission.isProjectCatalogManager(themeDisplay, project))
			{

				TTDPSPTaskCustomerMapLocalServiceUtil
						.editTTDPSPTaskCustomerMapping(tTDPSPTaskCustomerId, name,
								themeDisplay.getCompanyId(),
								themeDisplay.getUserId(), statusId,doGroupId);

			} else {
				_log.error("IPAC : Error while creating PSPTask Customer Map . User '"
						+ themeDisplay.getUserId()
						+ "' does not have permission to create PSPTask Customer Map.");
				SessionErrors.add(actionRequest, PrincipalException.class);
			}
		} catch (Exception e) {
			_log.error("IPAC : Error while editing PSPTaskCustomer Map",
					e);
			actionResponse.setRenderParameter("mvcPath",
					"/html/customercatalogmanagement/managePSPTask.jsp");
			SessionErrors.add(actionRequest, e.getClass());

		}
	}
	
	/*
	 * Method to get the list of existing tTPSPTask customer map Id's
	 */

	public List<Long> getAvailableTTDPSPTaskCustomerIds(long organizationId,
			long[] TTDPSPTaskIdMapIds) throws SystemException {

		try {
			DynamicQuery dq = DynamicQueryFactoryUtil
					.forClass(TTDPSPTaskCustomerMap.class);
					dq.add(PropertyFactoryUtil.forName("organizationId").eq(
							organizationId));
					dq.add(PropertyFactoryUtil.forName("taskId").in(
							TTDPSPTaskIdMapIds));		
					dq.setProjection(
							ProjectionFactoryUtil.property("taskId"));

			@SuppressWarnings("unchecked")
			List<Long> availablePSPTaskIds = TTDPSPTaskCustomerMapLocalServiceUtil
					.dynamicQuery(dq);

			return availablePSPTaskIds;
		} catch (Exception e) {
			_log.error(
					"IPAC : Error while getting avaialble TTDPSPTaskId for PSPTaskCustomer Map",
					e);
		}

		return null;
	}
	
	
	
}