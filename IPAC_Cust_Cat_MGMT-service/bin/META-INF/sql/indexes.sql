create index IX_CECAAF75 on IPAC_CUST_CAT_MGMT_TTDPSPCustDecisionTaskTable (parentTTDPSPTaskCustomerId, condition_);
create index IX_89AE3852 on IPAC_CUST_CAT_MGMT_TTDPSPCustDecisionTaskTable (parentTTDPSPTaskCustomerId, subTTDPSPTaskCustomerId, condition_);

create index IX_AFA8B8F4 on IPAC_CUST_CAT_MGMT_TTDPSPTaskCustomerMap (TTDPSPTaskCustomerId, organizationId);
create index IX_FE856E97 on IPAC_CUST_CAT_MGMT_TTDPSPTaskCustomerMap (TTDPSubProcessId, taskId, organizationId);
create index IX_C49FE223 on IPAC_CUST_CAT_MGMT_TTDPSPTaskCustomerMap (organizationId, TTDPSubProcessId);
create index IX_E4BA2D on IPAC_CUST_CAT_MGMT_TTDPSPTaskCustomerMap (taskId, organizationId);

create index IX_C8F3D7D4 on IPAC_CUST_CAT_MGMT_TTDPSubProcessCustomerMap (TTDPSubProcessCustomerId, organizationId);
create index IX_78D55D6 on IPAC_CUST_CAT_MGMT_TTDPSubProcessCustomerMap (TTDPSubProcessId, organizationId);
create index IX_AA051A37 on IPAC_CUST_CAT_MGMT_TTDPSubProcessCustomerMap (organizationId, TTDPSubProcessId, statusId);

create index IX_E23C2C54 on IPAC_CUST_CAT_MGMT_TTDProcessCustomerMap (TTDProcessCustomerId, organizationId);
create index IX_B6B22A56 on IPAC_CUST_CAT_MGMT_TTDProcessCustomerMap (TTDProcessId, organizationId);
create index IX_72E18FB7 on IPAC_CUST_CAT_MGMT_TTDProcessCustomerMap (organizationId, TTDProcessId, statusId);

create index IX_394E3626 on IPAC_CUST_CAT_MGMT_TTDeliverableCustomerMap (TTDeliverableCustomerId, organizationId);
create index IX_7DCC2628 on IPAC_CUST_CAT_MGMT_TTDeliverableCustomerMap (TTDeliverableId, organizationId);
create index IX_93624726 on IPAC_CUST_CAT_MGMT_TTDeliverableCustomerMap (organizationId);

create index IX_A35BD528 on IPAC_CUST_CAT_MGMT_TTechnologyCustomerMap (TTechnologyCustomerId, organizationId);
create index IX_5BCF3365 on IPAC_CUST_CAT_MGMT_TTechnologyCustomerMap (organizationId);
create index IX_23DDBD9F on IPAC_CUST_CAT_MGMT_TTechnologyCustomerMap (towerTechnologyId, organizationId);

create index IX_3130B4DC on IPAC_CUST_CAT_MGMT_TowerCustomerMap (organizationId);
create index IX_5D8D3BDC on IPAC_CUST_CAT_MGMT_TowerCustomerMap (towerId, organizationId);