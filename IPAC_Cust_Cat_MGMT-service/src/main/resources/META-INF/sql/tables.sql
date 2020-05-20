create table IPAC_CUST_CAT_MGMT_TTDPSPCustDecisionTaskTable (
	TTDPSPCustDecisionTaskTableId LONG not null primary key,
	subTTDPSPTaskCustomerId LONG,
	condition_ BOOLEAN,
	order_ INTEGER,
	parentTTDPSPTaskCustomerId LONG
);

create table IPAC_CUST_CAT_MGMT_TTDPSPTaskCustomerMap (
	TTDPSPTaskCustomerId LONG not null primary key,
	TTDPSubProcessId LONG,
	taskId LONG,
	orderBy INTEGER,
	organizationId LONG,
	name STRING null,
	taskTypeId INTEGER,
	companyId LONG,
	createdBy LONG,
	createdOn DATE null,
	modifiedBy LONG,
	modifiedOn DATE null,
	statusId INTEGER,
	doGroupId LONG,
	taskAssessmentId LONG,
	parentTTDPSPTaskCustMapId LONG,
	linkedTTDPSubprocessCustMapId LONG,
	taskOrderNumber INTEGER
);

create table IPAC_CUST_CAT_MGMT_TTDPSubProcessCustomerMap (
	TTDPSubProcessCustomerId LONG not null primary key,
	TTDPSubProcessId LONG,
	organizationId LONG,
	name STRING null,
	companyId LONG,
	createdBy LONG,
	createdOn DATE null,
	modifiedBy LONG,
	modifiedOn DATE null,
	statusId INTEGER
);

create table IPAC_CUST_CAT_MGMT_TTDProcessCustomerMap (
	TTDProcessCustomerId LONG not null primary key,
	TTDProcessId LONG,
	organizationId LONG,
	name STRING null,
	companyId LONG,
	createdBy LONG,
	createdOn DATE null,
	modifiedBy LONG,
	modifiedOn DATE null,
	statusId INTEGER
);

create table IPAC_CUST_CAT_MGMT_TTDeliverableCustomerMap (
	TTDeliverableCustomerId LONG not null primary key,
	TTDeliverableId LONG,
	organizationId LONG,
	name STRING null,
	companyId LONG,
	createdBy LONG,
	createdOn DATE null,
	modifiedBy LONG,
	modifiedOn DATE null,
	statusId INTEGER
);

create table IPAC_CUST_CAT_MGMT_TTechnologyCustomerMap (
	TTechnologyCustomerId LONG not null primary key,
	towerTechnologyId LONG,
	organizationId LONG,
	name STRING null,
	companyId LONG,
	createdBy LONG,
	createdOn DATE null,
	modifiedBy LONG,
	modifiedOn DATE null,
	statusId INTEGER
);

create table IPAC_CUST_CAT_MGMT_TowerCustomerMap (
	towerCustomerId LONG not null primary key,
	towerId LONG,
	organizationId LONG,
	name STRING null,
	companyId LONG,
	createdBy LONG,
	createdOn DATE null,
	modifiedBy LONG,
	modifiedOn DATE null,
	statusId INTEGER
);