package com.tibco.automation.page.common;

public interface Locators {

	public interface TemplatePageLocators {
		public String TOP_NAVIGATION_LOC = "ll-navigation-menu";
		public String TOP_NAVIGATION_BUTTON_LOC = "xpath=//button[text()='%s']";
		public String TOP_NAVIGATION_DROPDOWN_LOC = "xpath=//div[.//ul[@class='x-menu-list']][contains(@style,'visibility: visible')]//li[.//span[text()='%s']]";
		//public String MENU_ITEM_LOC_FORMAT = "//div[@id='navbarNavDropdown']//a[contains(text(),'%s')]";
		//GS locator
		//public String MENU_ITEM_LOC_FORMAT = "//div[@class='navbar navbar-default navbar-static-top']//a[contains(text(),'Admin')]";
		public String MENU_ITEM_LOC_FORMAT = "//div[@class='navbar navbar-default navbar-static-top']//a[contains(text(),'%s')]";
		
		//public String SUB_MENU_ITEM_LOC = "//div[@id='sidebarContentArea']/ul[@class='menuItems']//li[text()='%s']";
		//public String SUB_MENU_ITEM_LOC = "//div[@class='btn-group']//button[@id='useradmingroup']";
		//public String CHILD_SUB_MENU_ITEM_LOC = "//a[contains(text(),'User Admin')]";
		public String SUB_MENU_ITEM_LOC = "//div[@class='btn-group']//button[@id='%s']";
		//public String SUB_MENU_ITEM_LOC = "//div[@class='btn-group']//button[@id='useradmingroup']";
		public String CHILD_SUB_MENU_ITEM_LOC = "//a[contains(text(),'%s')]";
				
		//public String SUB_MENU_PARENT_ITEM_LOC = "//div[@id='sidebarContentArea']/ul[@class='menuItems']//a[text()='%s']";
		//public String SUB_MENU_PARENT_ITEM_LOC = "//div[@class='btn-group']//button[@id='useradmingroup']"	;
		public String SUB_MENU_PARENT_ITEM_LOC = "//div[@class='btn-group']//button[@id='%s']"	;
												
		
		public String ACTION_ITEM_POPUP_LOC = "//div[@class='dijitPopup dijitMenuPopup rowActionDiv']//tr[contains(@id,'dijit_MenuItem')]//td[2][text()='%s']";
		public String ACTION_COLUMN_TABLE_LOC = "//tr[%d]/td[./table[@class='action_column_table']]";
		public String GLOBAL_ACTIONS_POPUP_TABLE_LOC = "//table[@id='editMenu']";
		public String GLOBAL_ACTIONS_POPUP_TABLE_ITEM_LOC = GLOBAL_ACTIONS_POPUP_TABLE_LOC
				+ "//tr/td[2][./span[text()='%s']]";
		//public String PAGE_TITLE_LOC = "//div[@class='titlerow']/div[contains(@class,'pageTitle') and text()='%s']";
		
		//GS locators
		
		//public String PAGE_TITLE_LOC = "xpath=//div[@class='pageTitle'] and text()='%s']";
		public String PAGE_TITLE_LOC = "//div[@class='contentTopTitleSize']/div[contains(@class,'pageTitle') and text()='%s']";
		
		public String HELP_LOCATOR = "//span[contains(@title, 'Help')]";
		
		public String BACK_LINK_LOC_ON_PAGES = "//div[@id='contentsRow']//a[@class='backlink']";
		public String DASHBOARD_PAGE_TITLE_LOC = "//div[@class='row dashboardTitle']//span[contains(text(),'%s')]";
		public String RESULTS_PER_PAGE_INPUT_LOC = "//select[@name='table_id_length']";
		public String MODAL_TITLE_LOC = "//div[contains(@style,'display')]//div[@id='titleid' or @class='modal-title']";
		public String MODAL_HEADER_LOC = "//div[contains(@style,'display')]//div[@class='modal-header' and ./div[@id='titleid' or @class='modal-title']]";
		public String MODAL_READONLY_PROPERTIES_BODY_LOC = MODAL_HEADER_LOC
				+ "/following-sibling::div[@class='detail-modal-body modal-body']//div[text()='%s']/following-sibling::div";
		public String MODAL_ADD_EDIT_PROPERTIES_BODY_LOC = MODAL_HEADER_LOC
				+ "/following-sibling::div[@class='modal-body']//div[normalize-space(text())='%s']/following-sibling::div/*";
		public String VIEW_FULL_DETAILS_ENGINE_DETAILS_PROP_LOC = MODAL_HEADER_LOC
				+ "/following-sibling::div//div[@id='fullDetailsTable']//div[text()='%s']/following-sibling::div";
		public String MORE_BUTTON_LOC = "//div[normalize-space(@class)='topaginate']/div[./button[normalize-space(text())='More']][last()]";
		public String COLUMNS_SELECTOR_BUTTON_LOC = "//div[normalize-space(@class)='topaginate']//div[@id='columnsButton']";
		public String COLUMNS_SELECTOR_POPUP_LOC = "//div[@id='columnsButton_dropdown']//table[@class='popuptable']";
		public String GLOBAL_ACTION_LEVEL_ONE_ITEM_LOC = MORE_BUTTON_LOC
				+ "/ul[@class='dropdown-menu show']//*[./span[text()='%s'] or ./a[text()='%s']]";
		public String GLOBAL_ACTION_LEVEL_TWO_ITEM_LOC = GLOBAL_ACTION_LEVEL_ONE_ITEM_LOC
				+ "//following-sibling::a[text()='%s']";
		public String PERIOD_WITHIN_LAST_OPTIONS_BUTTONS_LOC = "//button[contains(@class,'btn btn-sm btn-outline-secondary btn-DateSF') and text()='%s']";
		public String SELECTED_PERIOD_WITHIN_LAST_OPTION_LOC = "//button[@class='btn btn-sm btn-outline-secondary btn-DateSF selected'  and text()='%s']";

	}

	//GS Locator
	public interface CommonLocators{
		public String GLOBAL_ACTION_LINK_LOCATOR="//button[@id='globalActionsParent']";
		public String GLOBAL_ACTION_NAME="//ul[@class='globalActionsList']/descendant::li[text()='%s']";
		public String LOCAL_ACTION_LINK_LOC="//button[@id='itemButton']";
		public String LOCAL_ACTION_ITEM_LOC="//ul[@class='itemActionsList']/descendant::li[text()='%s']";
		public String SEARCH_TYPE_BUTTON_LOC="//button[@id='tableSearchType']";
		public String SEARCH_TYPE_ITEM_LOC="//li[text()='%s']";
		public String SEARCH_STRING_LOC="//input[@type='text' and @class='basicTableSearchString form-control']";
		public String SEARCH_COLUMN_NAME_LOC="//select[@class='tableSearchColumns form-control']";
		public String SEARCH_BUTTON_LOC="//button[@id='tableFindButton' and @title='Search']";
		public String CLEAR_SEARCH_RESULTS_LOC="//button[@id='clearBtnArea']";
		
		public String QUERY_BUILDER_COLUMN_NAME_SELECT_LOC="//tr[contains(@class,'tableInstance')]/descendant::select[@class='tableAdvancedSearchColumns form-control']";
		public String QUERY_BUILDER_CONDITION_SELECT_LOC="//tr[contains(@class,'tableInstance')]/descendant::select[@class='tableAdvancedSearchColumns form-control']/following-sibling::select[@class='tableOperators form-control']";
		public String QUERY_BUILDER_VALUE_LOC="//tr[contains(@class,'tableInstance')]/descendant::input[contains(@class,'tableAdvancedSearchValue form-control')]";
		public String QUERY_BUILDER_SEARCH_BUTTON_LOC="//div[@id='complexSearchBtnArea']/descendant::span[text()='Search']";
		public String QUERY_BUILDER_CLOSE_BUTTON_LOC="//span[@id='tableClearButton']";
	
		
		public String RESULTS_PER_PAGE_LOC="//input[@type='text' and @id='pageSizeEditBottom']";
		public String ROW_CHECKBOX_ARRAY_LOC="//input[@type='checkbox' and @title='Available actions']";
		
		public String PAGINATION_NEXT_BUTTON_BOTTOM_ENABLED_LOC="//i[@id='pagination_nextBottom' and @class='glyphicon glyphicon-triangle-right pageImage']";
		public String PAGINATION_PREVIOUS_BUTTON__BOTTOM_ENABLED_LOC="//i[@id='pagination_prevBottom' and @class='glyphicon glyphicon-triangle-left pageImage pagePrev']";
		public String PAGINATION_FIRST_BUTTON_BOTTOM_ENABLED_LOC="//i[@id='pagination_firstBottom' and @class='glyphicon glyphicon-step-backward pageImage']";
		public String PAGINATION_LAST_BUTTON_BOTTOM_ENABLED_LOC="//i[@id='pagination_lastBottom' and @class='glyphicon glyphicon-step-forward pageImage']";
		public String PAGE_NUMBER_ON_PAGINATION="//input[@id='pageNumberEditBottom']";
		
		public String PAGINATION_NEXT_BUTTON_BOTTOM_DISABLED_LOC="//i[@id='pagination_nextBottom' and @class='glyphicon glyphicon-triangle-right pageImage pagination_disabled']";
		public String PAGINATION_PREVIOUS_BUTTON_BOTTOM_DISABLED_LOC="//i[@id='pagination_prevBottom' and @class='glyphicon glyphicon-triangle-left pageImage pagePrev pagination_disabled']";
		public String PAGINATION_FIRST_BUTTON_BOTTOM_DISABLED_LOC="//i[@id='pagination_firstBottom' and @class='glyphicon glyphicon-step-backward pageImage pagination_disabled']";
		public String PAGINATION_LAST_BUTTON_BOTTOM_DISABLED_LOC="//i[@id='pagination_lastBottom' and @class='glyphicon glyphicon-step-forward pageImage pagination_disabled']";
	
		public String REFRESH_BUTTON_LOC="//button[@id='refreshParent']";
		public String LAST_REFRESH_BUTTON_LOC="//button[@id='refreshParent' and contains(@title,'Last Refresh')]";
		public String REFRESH_BUTTON_DISABLED_LOC="//button[@id='refreshParent' and contains(@title,'Refresh Disabled')]";
	}
	
	public interface LoginPageLocators {
		public String USERNAME_INPUT_LOC = "xpath=//input[@name='username']";
		public String PASSWORD_INPUT_LOC = "xpath=//input[@name='password']";
		//public String SIGN_IN_INPUT_LOC = "xpath=//button[normalize-space(@text='SIGN IN')]";
		//public String SIGN_IN_INPUT_LOC = "xpath=//button[normalize-space(@text='Login')]";
		//public String SIGN_IN_INPUT_LOC = "//div[@class='navbar navbar-default navbar-static-top']//a[contains(text(),'Admin')]";
		
				//public String USER_PROFILE_LINK_LOC = "xpath=//span[normalize-space(@text='Admin')]";
		//GS locator
		public String SIGN_IN_INPUT_LOC = "//div[@class='logindiv']//a[contains(text(),'Login')]";
		public String USER_PROFILE_LINK_LOC = "//ul[@class='nav navbar-nav navbar-right']//li[@title='Profile Manager']";
		public String PROFILE_BUTTON = "//div[@id='user-sidebar-wrapper']//iframe[@id='userProfile']";
		//public String LOGOUT_BUTTON= "//a[contains(text(),'LOG OUT')]";
		public String LOGOUT_BUTTON = "css=#logoutbutton";
		 
		//public String USER_PROFILE_LINK_LOC = "xpath=//span[normalize-space(@text='Admin')]";
		
	}

	public interface HomePageLocators {
		public String HELP_BUTTON_LOC = "xpath=//button[text()='Help']";
		public String TAB_LOC = "xpath=//a[@title='%s']";
		public String LOGOUT_LINK_LOC ="xpath=//a[@class='sf-signout']";
		public String STATISTICS_MORE_LONK_LOC = "//div[contains(@class,'dashboard-statrow')]//div[./span[normalize-space(text())='%s']]/following-sibling::div//a";
		public String MODAL_HEADER_WITH_TITLE_LOC = "//div[not(contains(@style,'display'))]//div[@class='modal-header' and ./div[@id='titleid' or @class='modal-title' and text()='%s']]";
	}

	public interface ColumnNames {
		String ACTIONS = "Actions";
		String NAME = "Name";
		String ACCOUNT = "Account";
		String DESCRIPTION = "Description";
		String STATUS = "Status";
		String MODE = "Mode";
		String ACTIVEPOLICY = "Active Policy";
		String CHANGED = "Changed";
		String TYPE = "Type";
		String ENABLER = "Enabler";
		String ENABLERVERSION = "Enabler Version";
		String UTILITY = "Utility";
		String SUPPORTEDCOMPONENTTYPES = "Supported Component Types";
		String LASTMODIFIED = "Last Modified";
		String HOSTNAME = "Host Name";
		String DRAINING = "Draining";
		String OS = "OS";
		String CPU = "CPUs";
		String MFLOPS = "MFlops";
		String LASTLOGIN = "Last Login";
		String CONFIGURATION = "Configuration";
		String PRIMARYDIRECTOR = "Primary Director";
		String SECONDRYDIRECTOR = "Secondry Director";
		String INSTANCES = "Instances";
		String INSTANCE = "Instance";
		String LOGLEVEL = "Log Level";
		String USERNAME = "Username";
		String COMPONENTNAME = "Component Name";
		String ENGINECOUNT = "Engine Count (Total/Draining)";
		String SESSIONCOUNT = "Session Count";
		String APPLICATIONSESSIONCOUNT = "Application Session Count";
		String QUEUEDEPTH = "Queue Depth";
		String REDIRECT = "Redirect";
		String RELATIVEURLS = "Relative URLs";
		String STATISTIC = "Statistic";
		String CURRENT = "Current";
		String HIGHTODAY = "High Today";
		String LAST7DAYS = "Last 7 Days";
		String VALUE = "Value";
		String EXPORT = "Export";
		String AUTOINCREMENT = "Auto Increment";
		String OVERRIDDENCONTAINERVARIABLE = "Overridden Container Variable";
		String DISTRIBUTIONVERSION = "Distribution Version";
		String VERSION = "Version";
		String PROPERTY="Property";
		String DEPARTMENTNAME="Department Name";
		String LOCATIONNAME="Location Name";
		

	}

	public interface ButtonsOnModal {
		String OK = "OK";
		String CANCEL = "Cancel";
		String SAVE = "Save";
		String SEARCH = "Search";
		String RESET = "Reset";
	}

	public interface ModalHeader {
		String CHANGEENABLER = "Change Enabler";
		String COPYCOMPONENT = "Copy Component";
	}

	public interface ComponentTypes {
		String COMMANDLINE = "Command Line";
		String DEFAULT = "Default";
		String J2EE = "J2EE";
		String TIBCOBPMRUNTIME = "TIBCO ActiveMatrix BPM Runtime";
		String TIBCOBPMSERVER = "TIBCO ActiveMatrix BPM Server";
		String TIBCOBW = "TIBCO ActiveMatrix BusinessWorks";
		String TIBCOADMINISTRATOR = "TIBCO Administrator";
		String TIBCOEMSSERVER = "TIBCO EMS Server";
		String TIBCOENTERPRISEADMINISTRATOR = "TIBCO Enterprise Administrator";
	}

	public interface EnablerNames {
		String COMMANDLINEENABLER = "Command Line Container";
		String EXAMPLEENABLER = "Example Enabler";
		String TOMCAT60ENABLER = "Tomcat 6.0 Enabler";
		String JBOSSEAP64ENABLER = "JBoss EAP 6.4 Enabler";
		String JBOSSEAPENABLER = "JBoss EAP Enabler";
		String TIBCOAMXBPMRUNTIMEENABLER = "TIBCO ActiveMatrix BPM Runtime Enabler";
		String TIBCOAMXBPMSERVERENABLER = "TIBCO ActiveMatrix BPM Server Enabler";
		String TIBCOAMXBWENABLER = "TIBCO ActiveMatrix BusinessWorks container";
		String TIBCOADMINISTRATORENABLER = "TIBCO Administrator container";
		String TIBCOEMSSERVERENABLER = "TIBCO EMS Server container";
		String TIBCOENTERPRISEADMINISTRATORENABLER = "TIBCO Enterprise Administrator container";
	}

	public interface ComponentsPageLocators {
		public String TITLE = "Components";
		public String GLOBAL_ACTIONS_LINK_LOC = "//div[normalize-space(@class)='topaginate']/div[./button[normalize-space(text())='More']][last()]/button";
		public String ENABLER_VERSION_SELECTION_POPUP = "//div[./span[@class='ui-dialog-title' and text()='%s']]";
		public String BUTTON_LOC_ON_POPUP = "//button//span[text()='%s']";
	}

	public interface StacksPageLocators {
		public String CREATE_NEW_STACK_LINK_LOC = "//div[contains(@class,'pageTitle')]/following-sibling::div/button[text()='Create']";
		public String STACK_BUILDER_BASIC_ROW_LOC = "//table[@id='builderContent']/tbody/tr[@id='basicsRow']";
		public String STACK_BUILDER_POLICIES_ROW_LOC = "//table[@id='builderContent']/tbody/tr[@id='policiesRow']";
		public String STACK_BUILDER_BOTTOM_ROW_LOC = "//table[@id='builderContent']/tbody/tr[@id='bottomRow']";
		public String STACK_BUILDER_NAME_INPUT_LOC = "//div[@class='panel-body']//div[normalize-space(text())='Name']/following-sibling::div/input";
		public String STACK_BUILDER_DESC_INPUT_LOC = "//div[@class='panel-body']//div[normalize-space(text())='Description']/following-sibling::div/input";
		public String STACK_BUILDER_DISPLAYNAME_INPUT_LOC = "//div[@class='panel-body']//div[normalize-space(text())='Display Name']/following-sibling::div/input";
		public String STACK_COMPONENTS_EXPAND_LOC = "//a[@id='dropdownMenu' and normalize-space(text())='Add available components']";
		public String AVAILABLE_COMPONENTS_SELECT_LOC = "//ul[@id='componentsToAddMenu']";
		public String SELECTED_COMPONENTS_ROW_LOC = "//div[@id='cmpnsList']//div[text()='%s']/following-sibling::div/img";
		public String ADD_COMPONENTS_TO_SELECTED_LOC = STACK_BUILDER_BASIC_ROW_LOC + "//span[@id='addCmpns']";
		public String REMOVE_COMPONENTS_FROM_SELECTED_LOC = STACK_BUILDER_BASIC_ROW_LOC + "//span[@id='removeCmpns']";
		public String POLICIES_SECTION_LOC = "//table[@class='fTable policiesTable']";
		public String COMPONENTS_LOC_IN_POLICIES_LOC = POLICIES_SECTION_LOC + "//td[text()='%s']";
		public String ADD_RULES_LINK_POLICIES_LOC = COMPONENTS_LOC_IN_POLICIES_LOC
				+ "/following-sibling::td[text()='Add rules']";
		public String POLICIES_RULE_TABLE_LOC = POLICIES_SECTION_LOC
				+ "//tr[./td[text()='%s']]/following-sibling::tr[1]";
		public String POLICIES_TABLE_RULE_TYPE_INDIVIDUAL_REMOVE_LOC = POLICIES_RULE_TABLE_LOC
				+ "//tr[not(contains(@class,'rule_template')) and ./td[text()='%s']]//button[contains(@class,'remove_rule')]/img";
		public String POLICIES_TABLE_RULE_TYPE_REMOVE_LOC = POLICIES_RULE_TABLE_LOC
				+ "//tr[2][not(contains(@class,'rule_template')) and ./td[text()='%s']]//button[contains(@class,'remove_rule')]/img";
		public String POLICIES_RULE_TABLE_REMOVE_LINK_LOC = POLICIES_RULE_TABLE_LOC
				+ "//tr[2][not(contains(@class,'rule_template'))]//button[contains(@class,'remove_rule')]/img";
		public String NEW_RULE_ADD_LINK_POLICIES_LOC = POLICIES_SECTION_LOC
				+ "//tr[./td[text()='%s']]/following-sibling::tr[1]//a[normalize-space(text())='New Rule']";
		public String MIN_ENGINES_VALUE_LOC = POLICIES_SECTION_LOC + "/following-sibling::td/input[@id='min']";
		public String MAX_ENGINES_VALUE_LOC = POLICIES_SECTION_LOC + "/following-sibling::td/input[@id='max']";
		public String SET_COMPONENT_PRIORITY_SELECT_LOC = POLICIES_SECTION_LOC + "/following-sibling::td/select";
		public String EXPAND_POLICY_COMPONENT_FOR_RULE = POLICIES_SECTION_LOC + "/preceding-sibling::td/img";
		public String NEW_RULE_POPUP_LOC_FOR_POLICIES = POLICIES_SECTION_LOC
				+ "//tr[./td[text()='%s']]/following-sibling::tr[1]//ul[@class='dropdown-menu rule_adder pull-left show']";
		public String SELECT_RULE_TYPE_FOR_COMPONENT_LOC = NEW_RULE_POPUP_LOC_FOR_POLICIES + "//a[text()='%s']";
		public String RULES_POPUP_MODAL_LOC = "//div[not(contains(@style,'display')) and @class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front ui-draggable ui-resizable ui-dialog-buttons']";
		public String STACK_CREATE_EDIT_PAGE_MODAL_BUTTONS_LOC = RULES_POPUP_MODAL_LOC + "//button[text()='%s']";
		public String EXPAND_COMPONENT_MANUAL_MODE_DETAILS_LOC = STACK_BUILDER_POLICIES_ROW_LOC
				+ "//td[./span[@class='pseudoName' and text()='%s - Manual Mode']]/preceding-sibling::td/img";
		public String COMPONENT_DEPENDENCY_POPUP_BOOLEAN_VALUES_LOC = "//div[./b[contains(text(),'%s')]]/following-sibling::div/label[@class='switch-text switch-round']/input";
		public String SET_RESOURCE_PREFERENCE_DIV_LOC = "//div[./span[text()='Create Resource Preference Rule']]/following-sibling::div[1]";
		public String COLLAPSED_ACCORDION_DIV_LOC = "//div[@id='accordion']//div[@class='panel' or @class='panel panel-default']";
		public String EXPANDED_ACCORDION_DIV_LOC = "//div[@id='accordion']//div[@class='panel active' or @class='panel panel-default active']";
		public String URLS_TABLE_DIV_LOC = "//*[@id='stackURLTable']";
		public String ADD_URLS_LINK_LOC = URLS_TABLE_DIV_LOC + "//a[contains(.,'Add')]//img";
		public String PROPERTIES_TABLE_DIV_LOC = "//*[@id='skywayPropertyTable']";
		public String ADD_PROPERTIES_LINK_LOC = PROPERTIES_TABLE_DIV_LOC + "//a[contains(.,'Add')]//img";

	}

	public interface ComponentStatsLocator {
		public String COMPONENT_SELECT_BOX_LOCATION = "//select[@id='componentStatsPanel_componentPopup']";

	}

	public interface ArchiveStatsLocator {
		public String ARCHIVE_SELECT_BOX_LOCATION = "//select[@id='archiveStatsPanel_archivePopup']";

	}

	public interface EnginePageLocators {
		public String ACTIVATION_INFO_PROPRTY_VALUE_ENGINE_DETAILS_LOC = "";
	}
	
	
	//GS Locator
	public interface OverviewPageLocators
	{
		public String TOP_MENU_LINK_LOC="//a[contains(@class,'navbar-brand ') and normalize-space(text())='%s']";
		public String OVERVIEW_LINK_LOC="//a[contains(@class,'disable_false sidebar_link') and text()='Overview']";
		public String OPENED_PAGE_TITLE_LOC="//div[@class='pageTitle' and text()='%s']";
		public String LINK_LOC="//span/a[text()='%s']";
		public String SERVICE_GRAPH_LOC="//div[@id='service_runTask']";
		public String BROKER_GRAPH_LOC="//div[@id='broker_runTask']";
		public String DRIVER_GRAPH_LOC="//div[@id='recentDriver']";
		public String ENGINE_GRAPH_LOC="//div[@id='longRun']";
		public String DAEMON_GRAPH_LOC="//div[@id='recentDaemon']";
		public String SERVICE_SESSION_ADMIN_BUTTON_LOC="//div[@id='service_runTask']/following::a[@class='btn btn-primary' and normalize-space(text())='Service Session Admin'][1]";
		public String BROKER_ADMIN_BUTTON_LOC="//div[@id='broker_runTask']/following::a[@class='btn btn-primary' and normalize-space(text())='Broker Admin'][1]";
		public String DRIVER_ADMIN_BUTTON_LOC="//div[@id='recentDriver']/following::a[@class='btn btn-primary' and normalize-space(text())='Driver Admin'][1]";
		public String ENGINE_ADMIN_BUTTON_LOC="//div[@id='longRun']/following::a[@class='btn btn-primary' and normalize-space(text())='Engine Admin'][2]";
		public String DAEMON_ADMIN_BUTTON_LOC="//div[@id='recentDaemon']/following::a[@class='btn btn-primary' and normalize-space(text())='Daemon Admin'][1]";
		public String HELP_BUTTON_LOC="//a[@id='question-toggle']";
		public String OVERVIEW_HELP_TITLE_LOC="//h4[normalize-space(text())='Dashboard > Overview']";
		public String DOWNLOAD_BUTTON_LOC="//a[@id='download-toggle']";
		public String DOWNLOAD_VERIFICATION_TEXT_LOC="//td[normalize-space(text())='Driver SDK & Engine']";
	}
	
	//GS Locator
	public interface DirectorMonitorPageLocators
	{
		public String TOP_MENU_LINK_LOC="//a[contains(@class,'navbar-brand ') and normalize-space(text())='%s']";
		public String DIRECTOR_MONITOR_LINK_LOC="//a[contains(@class,'disable_false sidebar_link') and text()='Director Monitor']";
		public String ENGINE_CHECKBOX_LOC="//input[@id='gridEngine' and @type='checkbox']";
		public String TASK_CHECKBOX_LOC="//input[@id='gridTask' and @type='checkbox']";
		public String SERVICES_CHECKBOX_LOC="//input[@id='gridService' and @type='checkbox']";
		public String SYSTEM_CHECKBOX_LOC="//input[@id='gridSystem' and @type='checkbox']";
		public String ENGINE_GRAPH_LOC="//div[contains(@class,'heading') and normalize-space(text())='Grid Engine Monitor']";
		public String TASK_GRAPH_LOC="//div[contains(@class,'heading') and normalize-space(text())='Grid Task Monitor']";
		public String SERVICES_GRAPH_LOC="//div[contains(@class,'heading') and normalize-space(text())='Grid Service Monitor']";
		public String SYSTEM_GRAPH_LOC="//div[contains(@class,'heading') and normalize-space(text())='Grid System Monitor']";
	}
	
	//GS Locator
	public interface BrokerMonitorPageLocators
	{
		public String TOP_MENU_LINK_LOC="//a[contains(@class,'navbar-brand ') and normalize-space(text())='%s']";
		public String BROKER_MONITOR_LINK_LOC="//a[contains(@class,'disable_false sidebar_link') and text()='Broker Monitor']";
		public String ENGINE_CHECKBOX_LOC="//input[@id='engine' and @type='checkbox']";
		public String SERVICE_VIEW_CHECKBOX_LOC="//input[@id='allservices' and @type='checkbox']";
		public String TASKS_CHECKBOX_LOC="//input[@id='task' and @type='checkbox']";
		public String SERVICES_CHECKBOX_LOC="//input[@id='service' and @type='checkbox']";
		public String SYSTEM_CHECKBOX_LOC="//input[@id='system' and @type='checkbox']";
		public String ENGINE_GRAPH_LOC="//div[contains(@class,'heading') and normalize-space(text())='Engine Monitor']";
		public String SERVICE_VIEW_GRAPH_LOC="//div[contains(@class,'heading') and normalize-space(text())='Service View']";
		public String TASK_GRAPH_LOC="//div[contains(@class,'heading') and normalize-space(text())='Task Monitor']";
		public String SERVICES_GRAPH_LOC="//option[contains(text(),'-- Choose Service --')]";
		public String SYSTEM_GRAPH_LOC="//div[contains(@class,'heading') and normalize-space(text())='System Monitor']";
	}
	
	//GS Locator
	public interface GridSearchPageLocators
	{
		public String TOP_MENU_LINK_LOC="//a[contains(@class,'navbar-brand ') and normalize-space(text())='%s']";
		public String GRID_SEARCH_LINK_LOC="//a[contains(@class,'disable_false sidebar_link') and text()='Grid Search']";
	}
	
	//GS Locator
	public interface GridLibraries{
	       public String FIRST_GRIDLIB_CHECKBOX="//input[@name='select_0']";
	       public String UPLOAD_GRIDLIB_LOC="//a[@class='uploadGrid']";
	       public String UPLOAD_BUTTON_LOC="//a[@class='btn btn-blue btn-sm subfile']";
	       public String BROWSE_BUTTON_LOC="//input[@id='fupload']";
	       public String GRID_LIB_CHECKBOX_LOC="//input[@name='select_0']";
	       public String DEPLY_BUTTON_LOC="//a[contains(text(),'Deploy')]";
	       public String UPLOAD_ALERT_LOC="//div[@class='alert alert-success alert-dismissable']";
	       public String DELETE_BUTTON_LOC="//a[contains(text(),'Delete')]";
	       public String UPDATE_BUTTON_LOC="//a[contains(text(),'Update')]";
	       public String CALC_GRIDLIB_LINK_LOC="//a[@title='click for grid library details'][contains(text(),'calculator')]";
	       public String GRIDLIB_DESC_LOC="//span[@id='ui-id-1']";
	       public String CANCLE_BUTTON_LOC="//button[contains(text(),'Close')]";
	       public String TABLE_HEADER_CHECKBOX="//input[@name='toggle_select']";
	       public String GRID_LIB_DOWNLOAD_LINK_LOC="//a[contains(text(),'calculator-1.0.0.1.tar.gz')]";
	       public String FILE_UPLOAD_MSG_LOC="//div[@id='libPopup']//div[@id='message']";
	       public String GRID_LIB_EXIST_MSG_LOC="//div[@id='libPopup']//div[@id='message']";
	   }

	//GS Locator
	public interface ServiceConditionsLocators
	{
		public String ADD_COLUMN_LOC="//button[@id='columnPickerParent']";
		public String SAVE_BUTTON_ADD_COLUMN_LOC="//button[@id='pickerOKBtn' and normalize-space(text())='Save']";
		public String REMOVE_COLUMN_BUTTON_LOC="//li[@class='option_show']/descendant::span[text()='%s']//following::i[@class='glyphicon glyphicon-remove remove-list-item']";
		public String ADD_COLUMN_BUTTON_LOC="//ul[@class='selectColumns']/descendant::li[@value='%s']/descendant::i[@class='glyphicon glyphicon-plus-sign add-list-item']";
		public String COLUMN_ON_TABLE="//tr[@class='active']/descendant::a[text()='%s']";
		public String REVERT_BUTTON_ADD_COLUMN_LOC="//button[@id='restoreDefaultsBtn' and normalize-space(text())='Revert']";
		public String TOTAL_ROWS_AFTER_SEARCH_LOC="//span[@class='leftFloat resultscount']/descendant::strong[text()='%s']";
		public String SHOWING_RESULTS_LOC="//span[@class='leftFloat resultscount']/descendant::strong";
		public String RESULTS_PER_PAGE_LOC="//input[@type='text' and @id='pageSizeEditBottom']";
		public String ADD_BUTTON_LOC="//span[text()='Add']";
		public String NAME_INPUT_LOC="//input[@type='text' and @id='name']";
		public String TYPE_SELECT_LOC="//select[@id='type']";
		public String SAVE_BUTTON_LOC="//a[text()='Save']";
		public String CANCEL_BUTTON_LOC="//a[text()='Cancel']";
		public String ADDED_SERVICE_CONDITION_LOC="//td[@class='tablevalueWrap' and normalize-space(text())='%s']";
		public String SERVICE_CONDITION_CHECKBOX_LOC="//td[@class='tablevalue']/following::td[@class='tablevalueWrap' and normalize-space(text())='%s']/preceding::input[@type='checkbox'][1]";
		public String COPY_NAME_INPUTBOX_LOC="//input[@type='text' and @id='newName']";
		public String COPY_SAVE_BUTTON_LOC="//button[@type='button' and text()='Save']";
		public String COPY_CANCEL_BUTTON_LOC="//button[@type='button' and text()='Cancel']";
	}
	
	
	//GS Locator
	public interface BatchDefinitionLocators
	{
		public String ADD_BUTTON_LOC="//a[@data-toggle='modal' and text()='Add']";
		public String DEFINITION_CHECKBOX_LOC="//td[@class='tablevalue' and text()='%s']/preceding::input[@type='checkbox'][1]";
		public String BATCH_DEFINITION_INPUT_BOX="//input[@type='text' and @id='property']";
		public String ADD_BUTTON_ON_POPUP_LOC="//div[@class='modal-footer']/a[text()='Add']";
		public String CANCEL_BUTTON_LOC="//button[text()='Cancel']";
		public String SAVE_BUTTON_LOC="//a[text()='Save']";
		public String CANCEL_BUTTON_ON_EDIT_PAGE_LOC="//a[text()='Cancel']";
		public String DEFINITION_NAME_LOC="//td[@class='tablevalue' and text()='%s']";
		public String DESCRIPTION_INPUT_LOC="//td[text()='description']/following-sibling::td/input[1]";
		public String DESCRIPTION_VALUE_LOC="//td[@class='tablevalue' and text()='%s']";
		public String NEW_BATCH_DEFINITION_INPUT_LOC="//input[@type='text' and @id='newName']";
		public String NEW_BATCH_CANCEL_LOC="//button[text()='Save']/following-sibling::button[text()='Cancel']";
		public String NEW_BATCH_SAVE_LOC="//button[text()='Save']";
		public String BATCH_SCHEDULE_VERIFICATION_LOC="//div[@class='pageTitle' and text()='Batch Schedule']";
		public String BATCH_VIEW_PAGE_LOC="//div[normalize-space(text())='Batch'][1]";
	}
	
	
	//GS Locator
	public interface ServiceRunnerPageLocators
	{
		public String ADD_BUTTON_LOC="//a[@data-toggle='modal' and text()='Add']";
		public String SERVICE_RUNNER_INPUT_BOX_LOC="//input[@type='text' and @id='property']";
		public String ADD_BUTTON_ON_POPUP_LOC="//div[@class='modal-footer']/a[text()='Add']";
		public String CANCEL_BUTTON_LOC="//button[text()='Cancel']";
		public String SERVICE_RUNNER_CHECKBOX_LOC="//td[@class='tablevalue' and text()='%s']/preceding::input[@type='checkbox'][1]";
		public String SAVE_BUTTON_LOC="//a[text()='Save']";
		public String CANCEL_BUTTON_ON_EDIT_PAGE_LOC="//a[text()='Cancel']";
		public String SERVICE_RUNNER_NAME_LOC="//td[@class='tablevalue' and text()='%s']";
		public String DESCRIPTION_INPUT_LOC="//td[text()='description']/following-sibling::td/input[1]";
		public String DESCRIPTION_VALUE_LOC="//td[@class='tablevalue' and text()='%s']";
		public String NEW_SERVICE_RUNNER_INPUT_LOC="//input[@type='text' and @id='newName']";
		public String NEW_SERVICE_RUNNER_CANCEL_LOC="//button[text()='Save']/following-sibling::button[text()='Cancel']";
		public String NEW_SERVICE_RUNNER_SAVE_LOC="//button[text()='Save']";
		public String LAUNCH_SERVICE_RUNNER_VERIFICATION_LOC="//div[@class='pageTitle' and text()='Service Session Admin']";
	}
	public interface ServiceTestLocators
	{
		public String LINPACK="//a[contains(text(),'Linpack Test')]";
		public String SERVICE="//a[contains(text(),'Service Test')]";
		public String PERFORMANCE="//a[contains(text(),'Performance Test')]";
		public String SUBMIT="//a[@class='btn btn-blue btn-block testSubmit']";
		public String SERVICESESSIONADMIN="//a[contains(text(),'Service Session Admin')]";
		public String SESSION="//tr[2]//td[3]";
	}
	public interface CacheSchemaLocators
	{
		public String CACHENAME="//input[@type='text' and @id='name']";
		public String ADDBUTTON="//a[@class='btn btn-blue btn-sm']";
		public String VERIFYADDSCHEMA="//td[contains(text(), '%s')]";
		public String CANCELADDSCHEMA="//a[@class='btn btn-white btn-sm']";
		public String ACTION="//td[contains(text(),'%s')]/preceding::i[@class='gearImage glyphicon glyphicon-collapse-down itemActions'][1]";
		public String EDITSCHEMA="//li[contains(text(),'Edit Schema')]";
		public String CACHEREGION="//input[@name='CacheSchema.regionRegex']";
		public String VERIFYEDIT="//input[@name='CacheSchema.regionRegex' and@ value='region']";
		public String REMOVESCHEMA="//li[contains(text(),'Remove Schema')]";
		public String ACTION_="//i[@class='gearImage glyphicon glyphicon-collapse-down itemActions']";
		public String COPYSCHEMA="//li[contains(text(),'Copy Schema')]";
		public String COPYSCHEMANAMEFIELD="//div[@id='ui-id-1']//input[@id='newName']";
		public String SAVESCHEMA="//button[@class='btn btn-small btn-blue']";
		public String CANCELCOPYSCHEMA="//button[@class='btn btn-small btn-white']";
		public String RENAMESCHEMA="//li[contains(text(),'Rename Schema')]";
		
	}
	
	//GS Locator
	public interface BrokerConfigurationPageLocators{
		public String ADD_COLUMN_LOC="//button[@id='columnPickerParent']";
		public String SAVE_BUTTON_ADD_COLUMN_LOC="//button[@id='pickerOKBtn' and normalize-space(text())='Save']";
		public String REMOVE_COLUMN_BUTTON_LOC="//li[@class='option_show']/descendant::span[text()='%s']//following::i[@class='glyphicon glyphicon-remove remove-list-item']";
		public String ADD_COLUMN_BUTTON_LOC="//ul[@class='selectColumns']/descendant::li[@value='%s']/descendant::i[@class='glyphicon glyphicon-plus-sign add-list-item']";
		public String COLUMN_ON_TABLE="//tr[@class='active']/descendant::a[text()='%s']";
		public String REVERT_BUTTON_ADD_COLUMN_LOC="//button[@id='restoreDefaultsBtn' and normalize-space(text())='Revert']";
		public String TOTAL_ROWS_AFTER_SEARCH_LOC="//span[@class='leftFloat resultscount']/descendant::strong[text()='%s']";
		public String SHOWING_RESULTS_LOC="//span[@class='leftFloat resultscount']/descendant::strong";
		public String RESULTS_PER_PAGE_LOC="//input[@type='text' and @id='pageSizeEditBottom']";
		public String ROW_BROKER_NAME_ARRAY_LOC="//input[contains(@name,'brokername')]";
		public String FIRST_BROKER_NAME="//input[contains(@name,'brokername')][1]";
		public String SAVE_BUTTON_LOC="//a[text()='Save']";
		public String RESET_BUTTON_LOC="//a[text()='Reset']";
		public String FIRST_OFFLINE_BROKER_LOC="//input[@type='checkbox' and @class='gearImage itemActions'][1]";
	}
	
	//GS Locators
	public interface BrokerRoutingPageLocators{
		public String EDIT_BUTTON_LOC="//a[text()='Edit']";
		public String SAVE_BUTTON_LOC="//a[text()='Save']";
		public String CANCEL_BUTTON_LOC="//a[text()='Cancel']";
		public String ENGINE_PROPERTY_LOC="//select[@id='property']";
		public String ENGINE_COMPARATOR_LOC="//select[@id='property']//following::select[@id='comparator'][1]";
		public String ENGINE_VALUE_LOC="//select[@id='property']//following::input[@id='value'][1]";
		public String ADD_ICON_FOR_ENGINE_LOC="//select[@id='property']//following::i[@class='fa fa-plus'][1]";
		public String DRIVER_PROPERTY_LOC="//input[@id='property']";
		public String DRIVER_COMPARATOR_LOC="//select[@id='property']//following::select[@id='comparator'][2]";
		public String DRIVER_VALUE_LOC="//select[@id='property']//following::input[@id='value'][2]";
		public String ADD_ICON_FOR_DRIVER_LOC="//select[@id='property']//following::i[@class='fa fa-plus'][2]";
		public String EDIT_BUTTON_ON_RULE_LOC="//td[@class='tablevaluewrapall' and normalize-space(text())='%s']//following::span[@class='glyphicon glyphicon-edit'][1]";
		public String REMOVE_BUTTON_ON_RULE_LOC="//td[@class='tablevaluewrapall' and normalize-space(text())='%s']//following::span[@class='glyphicon glyphicon-trash'][1]";
		public String SAVE_BUTTON_ON_RULE_LOC="//span[@class='glyphicon glyphicon-save']";
		public String VERIFICATION_TEXT_LOC="//td[@class='tablevaluewrapall' and normalize-space(text())='%s']";
		public String EDITED_ENGINE_VALUE_LOC="//span[@class='glyphicon glyphicon-save']/preceding::select[@id='property']//following::input[@id='value'][1]";
		public String EDITED_DRIVER_VALUE_LOC="//span[@class='glyphicon glyphicon-save']/preceding::select[@id='property']//following::input[@id='value'][2]";
	}
	
	
	//GS Locators
	public interface BrokerAdminPageLocators{
		public String ADD_COLUMN_LOC="//button[@id='columnPickerParent']";
		public String SAVE_BUTTON_ADD_COLUMN_LOC="//button[@id='pickerOKBtn' and normalize-space(text())='Save']";
		public String REMOVE_COLUMN_BUTTON_LOC="//li[@class='option_show']/descendant::span[text()='%s']//following::i[@class='glyphicon glyphicon-remove remove-list-item']";
		public String ADD_COLUMN_BUTTON_LOC="//ul[@class='selectColumns']/descendant::li[@value='%s']/descendant::i[@class='glyphicon glyphicon-plus-sign add-list-item']";
		public String COLUMN_ON_TABLE="//tr[@class='active']/descendant::a[text()='%s']";
		public String REVERT_BUTTON_ADD_COLUMN_LOC="//button[@id='restoreDefaultsBtn' and normalize-space(text())='Revert']";
		public String TOTAL_ROWS_AFTER_SEARCH_LOC="//span[@class='leftFloat resultscount']/descendant::strong[text()='%s']";
		public String SHOWING_RESULTS_LOC="//span[@class='leftFloat resultscount']/descendant::strong";
		public String RESULTS_PER_PAGE_LOC="//input[@type='text' and @id='pageSizeEditBottom']";
		public String ROW_BROKER_NAME_ARRAY_LOC="//input[contains(@name,'brokername')]";
		public String ONLINE_BROKER_CHECKBOX_LOC="//td[@class='tablevalue' and normalize-space(text())='online']/preceding::input[@type='checkbox' and @title='Available actions'][1]";
		public String OFFLINE_BROKER_CHECKBOX_LOC="//td[@class='tablevalue' and normalize-space(text())='offline']/preceding::input[@type='checkbox' and @title='Available actions'][1]";
		public String PAGE_TITLE_LOCATOR="//div[@class='pageTitle' and text()='%s']";
		public String BROKER_MONITOR_PAGE_LOC="//td[@class='titleSize']/div[contains(text(),Broker)]";
	}
	
	public interface EngineConfigurationLocators{	
		public String CONFIGDROPDOWN="//select[@id='platform']";
		public String VALUE="//input[@id='newitem']";
		public String CREATE="//a[@class='btn btn-blue btn-sm fbtn']";
		public String CONFIGURATION="//label[contains(text(),'%s')]";
		public String ENGINECONFIG="//a[contains(text(),'Engine Configurations')]";
		public String CONFIGSAVE="//a[@class='propSubmitSaveConfirm btn btn-blue btn-sm']";
		public String CONFIGCANCEL="//a[contains(text(),'Cancel')]";
		public String CONFIGCOPY="//a[contains(text(),'Copy')]";
		public String CONFIGDELETE="//a[@class='propSubmitDelete btn btn-blue btn-sm']";
		public String CONFIGEXPANDALL="//a[@id='expandAll']";
		public String CONFIGCOLLAPSEALL="//a[@id='collapseAll']";
		public String CONFIGCHECKBOX="//input[@name='CONFIG.PROCESS_TABLE.PROCESS.AUTOLOAD.temp']";
		public String LINUX64CONFIG="//label[contains(text(),'linux64:default')]";
		public String COPYNAME="//input[@id='newName']";
		public String SAVECOPYCONFIG="//button[@class='btn btn-small btn-blue']";
		public String SIDELINK="//b[contains(text(),'current')]";
	}
	//GS Locator
	public interface EnginePropertiesPageLocators{
		public String ADD_BUTTON_LOC="//a[@class='btn btn-blue btn-sm' and text()='Add']";
		public String PROPERTIES_CHECKBOX_LOC="//td[@class='tablevalue' and text()='%s']/preceding::input[@type='checkbox'][1]";
		public String EDIT_BUTTON_LOC="//span[@class='glyphicon glyphicon-edit']";
		public String REMOVE_BUTTON_LOC="//span[@class='glyphicon glyphicon-trash']";
		public String PROPERTY_INPUT_BOX_LOC="//input[@class='fFieldNearButton form-control' and @id='property']";
		public String DESCRIPTION_INPUT_BOX_LOC="//input[@class='fFieldNearButton form-control' and @id='value']";
		public String ADD_PROPERTY_BUTTON_LOC="//a[@class='btn btn-blue btn-sm addProp' and text()='Add']";
		public String CANCEL_PROPERTY_BUTTON_LOC="//button[@type='button' and text()='Cancel']";
		public String CLOSE_ADD_PROPERTY_LOC="//button[@type='button' and @class='close']";
		public String UPDATE_BUTTON_LOC="//a[@id='updateTab' and text()='Update']";
		public String PROPERTY_NAME_LOC="//td[@class='tablevalue' and text()='%s']";
		public String EDIT_DESCRIPTION_INPUTBOX_LOC="//input[@type='text' and @id='value' and @value='%s']";
	}
	public interface EngineAdminPageLocators{
		public String REFRESHBUTTON="//button[@id='refreshParent']//img[@class='topparenticons']";
		public String ADD_COL_OPTION="//button[@id='columnPickerParent']//img[@class='topparenticons']";
		public String ADDCOLUMN="//li[@id='column_enginedotnet']//i[@class='glyphicon glyphicon-plus-sign add-list-item']";
		public String NETFRAMEWORK="//a[contains(text(),'.NET Framework Versions')]";
		public String ADDNETFRAMEWORKCOL="//li[@id='column_enginedotnet']//i[@class='glyphicon glyphicon-plus-sign add-list-item']";
		public String ENGINESIMPLESEARCH="//tr[2]//td[9][contains(text(),'win64')]";
		public String ENGINEQUERYSEARCH="//tr[2]//td[10][contains(text(),'WIN10')]";
		public String EXPANDVIEWALL="//li[contains(text(),'Expand View of All')]";
		public String VERIFYEXPANDVIEWALL="//td[contains(text(),'additionalPlatforms')]";
		public String CHECKBOX_="//div[@class='itemsParent notForDashboard']//tr[2]//td[1]";
		public String VERIFYSEARCHLOGS="//a[contains(text(),'Log Search for')]";
		public String NEXTSEARCH="//a[@id='next_button']";
		public String BACKSEARCH="//a[@id='prev_button']";
		public String BACKTOTOP="//a[contains(text(),'Back to the top')]";
		public String PAGENUM="//span[text()='2']";
		public String LOGDURATION="//select[@id='back']";
		public String YEAR="//option[@value='year']";
		public String HOUR="//option[@value='hour']";
		public String DAY="//option[@value='day']";
		public String WEEK="//option[@value='week']";
		public String MONTH="//option[@value='month']";
		public String CLEARLOG="//a[@id='clear']";
		public String SNAPSHOT="//a[@id='snapshot']";
		public String VERIFYSNAPSHOT="//title[contains(text(),'Manager Log Snapshot')]";
		public String LOGFILES="//span[contains(text(),'Download')]";
		public String DOWNLOAD="//a[@id='zipall']";
		
		
		
	}
	
	//GS Locator
	public interface WebServices{
	       public String EXPAND_ALL_LOC="//button[@id='expand']";
	       public String COLLAPSE_ALL_LOC="//button[@id='collapse']";
	       public String BATCH_ADMIN_LOC="//a[contains(text(),'BatchAdmin')]";
	       public String OPERATIONS_LOC="//a[@href='javascript:void(0);'][contains(text(),'BatchAdmin')]";
	       public String LOCAL_ACTION_LOC="//button[@id='actionButton']";
	       public String BATCH_ADMIN_CHECKBOX="//tbody//tr[2]//td[1]";
	       public String GENERATE_WSDL_LOC="//li[contains(text(),'Generate WSDL')]";
	       public String MORE_ACTION_LOC="//span[text()='More']";
	   }
	
	
	//GS Locator
	public interface DriverAdminPageLocators{
		public String ADD_COLUMN_LOC="//button[@id='columnPickerParent']";
		public String SAVE_BUTTON_ADD_COLUMN_LOC="//button[@id='pickerOKBtn' and normalize-space(text())='Save']";
		public String REMOVE_COLUMN_BUTTON_LOC="//li[@class='option_show']/descendant::span[text()='%s']//following::i[@class='glyphicon glyphicon-remove remove-list-item']";
		public String ADD_COLUMN_BUTTON_LOC="//ul[@class='selectColumns']/descendant::li[@value='%s']/descendant::i[@class='glyphicon glyphicon-plus-sign add-list-item']";
		public String COLUMN_ON_TABLE="//tr[@class='active']/descendant::a[text()='%s']";
		public String REVERT_BUTTON_ADD_COLUMN_LOC="//button[@id='restoreDefaultsBtn' and normalize-space(text())='Revert']";
		public String TOTAL_ROWS_AFTER_SEARCH_LOC="//span[@class='leftFloat resultscount']/descendant::strong[text()='%s']";
		public String SHOWING_RESULTS_LOC="//span[@class='leftFloat resultscount']/descendant::strong";
		public String EXPAND_COLLAPSE_VERIFICATION_TEXT="//td[@class='tablelabel' and text()='baseDir']";
		public String INTERNAL_DRIVER_LOC="//td[@class='tablevalue' and normalize-space(text())='internal']/preceding::input[1]";
	}
	
	
	public interface UsersPageLocators {
				
		public String ADD_COLUMN_LOC="//button[@id='columnPickerParent' and @title='Columns']";
		public String SAVE_BUTTON_ADD_COLUMN_LOC="//button[@id='pickerOKBtn' and normalize-space(text())='Save']";
		public String REMOVE_COLUMN_BUTTON_LOC="//li[@class='option_show']/descendant::span[text()='%s']//following::i[@class='glyphicon glyphicon-remove remove-list-item']";
		public String ADD_COLUMN_BUTTON_LOC="//ul[@class='selectColumns']/descendant::li[@value='%s']/descendant::i[@class='glyphicon glyphicon-plus-sign add-list-item']";
		public String COLUMN_ON_TABLE="//tr[@class='active']/descendant::a[text()='%s']";
		public String REVERT_BUTTON_ADD_COLUMN_LOC="//button[@id='restoreDefaultsBtn' and normalize-space(text())='Revert']";
        public String CANCEL_BUTTON="//a[@class='btn btn-sm btn-white' and text()='Cancel']";
        public String USERNAME_LOC="//input[@name='pm_u_name']";
        public String CONFIGURE_ROLE_LOC="//option[@value='Configure']";
        public String ADD_ROLE_BUTTON_LOC="//a[@id='addRoles']";
        public String REMOVE_ROLE_BUTTON_LOC="//a[@id='removeRoles']";
        public String PASSWORD_LOC="//input[@type='password' and @name='pm_u_pd']";
        public String CONFIRM_PASSWORD_LOC="//input[@type='password' and @name='confirm']";
        public String SAVE_BUTTON_LOC="//a[@class='btn btn-sm  btn-blue' and text()='Save']";
        public String EMAIL_LOC="//input[@name='email']";
        public String ADDED_USERNAME="//td[@class='tablevalue' and normalize-space(text())='%s']";
        public String ROLE_TOOLTIP_LOC="//i[@data-toggle='tooltip' and @title='Assign roles to this user by moving them to the right pane.']";
        public String EMAIL_SUBJECT_TEMPLATE_LOC="//td[@class='tablelabel' and text()='email subject template']";
        public String EMAIL_SUBJECT_TEXTAREA_LOC="//textarea[@name='emailsubject']";
        public String SAVE_EMAIL_BUTTON="//a[@class='btn btn-sm btn-blue' and text()='Save']";
        public String USER_EVENTS_PAGE_LOC="//*[@class='pageTitle' and text()='User Events']";
        public String EXPORT_RESULTS_BUTTON_LOC="//a[text()='Export Results']";
        public String DISPLAY_RESULTS_BUTTON_LOC="//a[text()='Display Results']";
        public String TIMESTAMP_COLUMN_LOC="//td[@class='tablehead' and text()='TIME STAMP']";
        public String BETWEEN_RADIO_BUTTON_LOC="//input[@name='useDateOffset']//following::td[text()='between']";
        public String WITHIN_RADIO_BUTTON_LOC="//input[@name='useDateOffset']//following::td[text()='within last']";
        public String DRIVER_EVENTS_PAGE_TITLE="//*[@class='pageTitle' and text()='Driver Events']";
        public String USERNAME_CHECKBOX_LOC="//td[normalize-space(text())='%s']/preceding::input[@type='checkbox'][1]";
        public String FIRSTNAME_TEXTBOX_LOC="//input[@name='firstname']";
        public String UPDATED_FIRSTNAME="//td[@class='tablevalue' and normalize-space(text())='%s']";
        public String TOTAL_ROWS_AFTER_SEARCH_LOC="//span[@class='leftFloat resultscount']/descendant::strong[text()='%s']";
        public String USERNAME_DROPDOWN_LOC="//select[@name='whereVal']";
        public String DRIVER_DROPDOWN_LOC="//select[@name='replace1']";
	}
	
	public interface RolePageLocators{
        //Role Admin
       public String GLOBAL_ACTION = "//div[@class='container leftFloat tableBottomSizerArea']//button[@id='globalActionsParent']";
       public String CREATE_NEW_ROLE_LINK_LOC="//div[@class='selectPopup globalActionsUI']//ul[@class='globalActionsList']//li[contains(text(),'Create New Role')]";
       public String ROLE_NAME="//input[@name='role_name']";
       public String MANAGER_LIST="//input[@name='broker_access']";
       public String SAVE_BUTTON1="//a[contains(@class,'btn-blue')]";
       public String CANCEL1="//div[1]//a[1]";
       public String CANCEL2= "//div[2]//a[1]";
       public String CHECKBOX="//table[@class='allContent table']//tr[2]//td[1]//input[1]";
       public String LOCALACTION="//div[@class='container leftFloat tableBottomSizerArea']//button[@id='itemButton']";
       public String VIEWEDIT = "//div[@class='selectPopup itemActionsUI']//ul[@class='itemActionsList']//li[contains(text(),'View/Edit')]";
       public String ENTERDESCRIPTION="//input[@name='role_description']";
       public String SAVE_BUTTON2="//div[1]//a[2]";
       public String EXPANDALL="//button[@id='expall']";
       public String COLLAPSEALL="//button[contains(text(),'Collapse All')]";
       public String ENABLEPERMISSION="//select[@id='factoryDefaults']";
       public String COPYROLE="//select[@id='copyRole']";
       public String SUBTABLEEXPANDCOLLAPSE="//i[@id='Dashboard']";
       public String SUBTABLEEXPANDCOLLAPSE1="//i[@id='Services']";
       public String SUBTABLEEXPANDCOLLAPSE2= "//i[@id='Engine']";
       public String SUBTABLEEXPANDCOLLAPSE3="//i[@id='Users']";
       public String SUBTABLEEXPANDCOLLAPSE4="//i[@id='Driver']";
       public String SUBTABLEEXPANDCOLLAPSE5="//i[@id='Manager']";
       public String SUBTABLEEXPANDCOLLAPSE6="//i[@id='Admin']";
       public String SUBTABLEEXPANDCOLLAPSE7="//i[@id='Batch']";
       public String CHECKBOXENABLEPERMISSION="//input[@id='enable_20']";
       public String PERMISSION="//td[contains(text(),'Dashboard Brokers View')]";
       public String ADDREMOVECOLUMN="//div[@class='container leftFloat tableBottomSizerArea']//img[@class='topparenticons']";
       public String REMOVECOLUMN="//li[@value='rolename']//i[@class='glyphicon glyphicon-remove remove-list-item']";
       public String ADDCOLUMN="//li[@id='column_rolename']//i[@class='glyphicon glyphicon-plus-sign add-list-item']";
       public String ADDCOLUMNSAVE="//button[@id='pickerOKBtn']";
       public String ROLENAME="//a[contains(text(),'Role Name')]";
       public String REVERT="//button[@id='restoreDefaultsBtn']";
       public String VERIFYREVERT="//a[text()='Role Name']/following::a[text()='Description']";
       public String SIMPLESEARCH="//td[contains(text(),'View')]";
       public String QUERYSEARCH="//td[contains(text(),'Default View Role')]";
       public String LOCALACTIONCOPY="//li[contains(text(),'Copy')]";
       public String LOCALACTIONDELET="//li[contains(text(),'Delete')]";
       public String CHECK="//input[@id='enable_4']";
       public String CONFIGUREROLE="//td[contains(text(), 'Configure')]";
       public String CLEAR="//span[@class='glyphicon glyphicon-remove']";
       public String ROLE="//td[contains(text(),'%s')]";
       public String ROLE1="//tr//td[contains(text(),'%s')]/preceding-sibling::td";
       public String ROLE3="//tr//td[contains(text(),'%s')]/following-sibling::td[contains(text(),'Management of all services and other components')]";
       public String INVALID="//td[contains(text(),'There are no entries for this view')]";
		


    }
	
	//GS Locator
	public interface RunAsPageLocators{
		public String RUN_AS_PAGE_TITLE_LOC="//*[@class='pageTitle' and text()='Run-As Credentials']";
		public String ADD_BUTTON_LOC="//button[@type='button' and text()='Add']";
		public String CREDENTIAL_LOC="//input[@id='credName']";
		public String PASSWORD_LOC="//input[@id='passwordCred']";
		public String CONFIRM_PASSWORD_LOC="//input[@id='confirmPasswordCred']";
		public String SAVE_BUTTON_LOC="//button[@id='saveCred']";
		public String CLOSE_BUTTON_LOC="//button[@class='close']";
		public String ADDED_CREDENTIAL_NAME_LOC="//td[@class='tablevalue' and text()='%s']";
		public String REMOVE_BUTTON_LOC="//input[@type='hidden' and @id='property' and @value='%s']/following-sibling::a[text()='Remove']";
	}
	
	//GS Locator
	public interface ManagerConfiguration_LoggingPageLocators
	{
		public String LOGGING_SIDE_MENU_LOC="//li[@class='sidebarlistsmall']/descendant::a[text()='Logging']";
		public String EXPAND_ALL_LOC="//button[@id='expall']";
		public String COLLAPSE_ALL_LOC="//button[@id='clpall']";
		public String SAVE_BUTTON_LOC="//a[@class='btn btn-sm btn-blue' and text()='Save']";
		public String CANCEL_BUTTON_LOC="//a[@class='btn btn-sm btn-white' and text()='Cancel']";
		public String DEFAULT_DEBUG_LEVEL_SELECT_LOC="//select[@name='new-0' and @class='bodyselect form-control']";
		public String EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC="//td[@class='tablelabel' and text()='Default Debug Level']";
		public String GENERAL_HEADER_LOC="//tr[@id='cat_General']/descendant::shortdescription[normalize-space(text())='General logging settings.']";
		public String MAX_FILE_LENGTH_TOOLTIP_LOC="//input[@type='text' and @name='new-5' and @data-toggle='tooltip' and  @data-original-title='Needs to Be > 0']";
		public String DEBUG_LEVEL_DESCRIPTION_TOOLTIP="//span[@data-toggle='tooltip' and contains(@data-title,'Severe and  Warning level messages are logged')]";
	}
	
	//GS Locator
	public interface ManagerConfiguration_ServicesPageLocators
	{
		public String SERVICES_SIDE_MENU_LOC="//li[@class='sidebarlistsmall']/descendant::a[text()='Services']";
		public String EXPAND_ALL_LOC="//button[@id='expall']";
		public String COLLAPSE_ALL_LOC="//button[@id='clpall']";
		public String SAVE_BUTTON_LOC="//a[@class='btn btn-sm btn-blue' and text()='Save']";
		public String CANCEL_BUTTON_LOC="//a[@class='btn btn-sm btn-white' and text()='Cancel']";
		public String CASE_SENSITIVE_SERVICE_NAME_SELECT_LOC="//select[@name='new-0' and @class='bodyselect form-control']";
		public String EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC="//td[@class='tablelabel' and text()='Use Case Sensitive Service Name']";
		public String SERVICE_REGISTRY_HEADER_LOC="//tr[@id='cat_Service_Registry']/descendant::shortdescription[normalize-space(text())='Service Registry settings.']";
		public String DEFAULT_MAXIMUM_TASK_RETRIES_TOOLTIP_LOC="//input[@type='text' and @name='new-1' and @data-toggle='tooltip' and  @data-original-title='Needs to Be >= 0']";
		public String SERVICE_REGISTRY_DESCRIPTION_TOOLTIP="//span[@data-toggle='tooltip' and contains(@data-title,'Server must be restarted')]";
	}
	
	//GS Locator
	public interface ManagerConfiguration_EnginesAndClientsPageLocators
	{
		public String ENGINES_AND_CLIENTS_SIDE_MENU_LOC="//li[@class='sidebarlistsmall']/descendant::a[text()='Engines and Clients']";
		public String EXPAND_ALL_LOC="//button[@id='expall']";
		public String COLLAPSE_ALL_LOC="//button[@id='clpall']";
		public String SAVE_BUTTON_LOC="//a[@class='btn btn-sm btn-blue' and text()='Save']";
		public String CANCEL_BUTTON_LOC="//a[@class='btn btn-sm btn-white' and text()='Cancel']";
		public String LOGIN_WITH_EXPIRED_PASSWORD_SELECT_LOC="//select[@name='new-2' and @class='bodyselect form-control']";
		public String EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC="//td[@class='tablelabel' and text()='Routing Info Validity Duration (ms)']";
		public String CLIENT_MANAGEMENT_HEADER_LOC="//tr[@id='cat_Client_Management']/descendant::h5[normalize-space(text())='Client Management']";
		public String CLIENT_TIMEOUT_TOOLTIP_LOC="//input[@type='text' and @name='new-1' and @data-toggle='tooltip' and  @data-original-title='Needs to Be >= 0']";
		public String CLIENT_TIMEOUT_DESCRIPTION_TOOLTIP="//span[@data-toggle='tooltip' and contains(@data-title,'amount of time a disconnected Client')]";
	}
	
	//GS Locator
	public interface ManagerConfiguration_AdminPageLocators
	{
		public String ADMIN_SIDE_MENU_LOC="//li[@class='sidebarlistsmall']/descendant::a[text()='Admin']";
		public String EXPAND_ALL_LOC="//button[@id='expall']";
		public String COLLAPSE_ALL_LOC="//button[@id='clpall']";
		public String SAVE_BUTTON_LOC="//a[@class='btn btn-sm btn-blue' and text()='Save']";
		public String CANCEL_BUTTON_LOC="//a[@class='btn btn-sm btn-white' and text()='Cancel']";
		public String HOSTNAME_FOR_ENGINE_LOG_URL_SELECT_LOC="//select[@name='new-1' and @class='bodyselect form-control']";
		public String EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC="//td[@class='tablelabel' and text()='Max Results Per Page']";
		public String ADMIN_CONFIGURATION_HEADER_LOC="//tr[@id='cat_Admin_Configuration']/descendant::h5[normalize-space(text())='Admin Configuration']";
		public String MAX_RESULTS_PER_PAGE_TOOLTIP_LOC="//input[@type='text' and @name='new-0' and @data-toggle='tooltip' and  @data-original-title='Needs to Be >= 1']";
		public String MAX_RESULTS_PER_PAGE_DESCRIPTION_TOOLTIP="//span[@data-toggle='tooltip' and contains(@data-title,'If it is not,  it will fallback to the IP address')]";
	}
	
	//GS Locator
	public interface ManagerConfiguration_DatabasePageLocators
	{
		public String DATABASE_SIDE_MENU_LOC="//li[@class='sidebarlistsmall']/descendant::a[text()='Database']";
		public String EXPAND_ALL_LOC="//button[@id='expall']";
		public String COLLAPSE_ALL_LOC="//button[@id='clpall']";
		public String SAVE_BUTTON_LOC="//a[@class='btn btn-sm btn-blue' and text()='Save']";
		public String CANCEL_BUTTON_LOC="//a[@class='btn btn-sm btn-white' and text()='Cancel']";
		public String CONNECTION_SUSPENDED_SELECT_LOC="//select[@name='new-0' and @class='bodyselect form-control']";
		public String EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC="//td[@class='tablelabel' and text()='Statistic Period (s)']";
		public String BROKER_REPORTING_HEADER_LOC="//tr[@id='cat_Broker_Reporting']/descendant::h5[normalize-space(text())='Broker Reporting']";
		public String STATISTIC_PERIOD_TOOLTIP_LOC="//input[@type='text' and @name='new-2' and @data-toggle='tooltip' and  @data-original-title='Needs to Be >= 30']";
		public String STATISTIC_PERIOD_DESCRIPTION_TOOLTIP="//span[@data-toggle='tooltip' and contains(@data-title,'total Engines, total Drivers')]";
	}
	
	//GS Locator
	public interface ManagerConfiguration_ResourceDeploymentPageLocators
	{
		public String RESOURCE_DEPLOYMENT_SIDE_MENU_LOC="//li[@class='sidebarlistsmall']/descendant::a[text()='Resource Deployment']";
		public String EXPAND_ALL_LOC="//button[@id='expall']";
		public String COLLAPSE_ALL_LOC="//button[@id='clpall']";
		public String SAVE_BUTTON_LOC="//a[@class='btn btn-sm btn-blue' and text()='Save']";
		public String CANCEL_BUTTON_LOC="//a[@class='btn btn-sm btn-white' and text()='Cancel']";
		public String SIGN_IF_UNMODIFIED_SELECT_LOC="//select[@name='new-2' and @class='bodyselect form-control']";
		public String EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC="//td[@class='tablelabel' and text()='Token Timeout']";
		public String COMMON_HEADER_LOC="//tr[@id='cat_Common']/descendant::h5[normalize-space(text())='Common']";
		public String DIRECTOR_MONITOR_INTERVAL_TOOLTIP_LOC="//input[@type='text' and @name='new-1' and @data-toggle='tooltip' and  @data-original-title='Needs to Be >= 0']";
		public String TOKEN_TIMEOUT_DESCRIPTION_TOOLTIP="//span[@data-toggle='tooltip' and contains(@data-title,'This may need to be increased for Managers')]";
	}
	
	//GS Locator
	public interface ManagerConfiguration_CachePageLocators
	{
		public String CACHE_SIDE_MENU_LOC="//li[@class='sidebarlistsmall']/descendant::a[text()='Cache']";
		public String EXPAND_ALL_LOC="//button[@id='expall']";
		public String COLLAPSE_ALL_LOC="//button[@id='clpall']";
		public String SAVE_BUTTON_LOC="//a[@class='btn btn-sm btn-blue' and text()='Save']";
		public String CANCEL_BUTTON_LOC="//a[@class='btn btn-sm btn-white' and text()='Cancel']";
		public String MEMORY_SIZE_LOC="//input[@name='new-1' and @type='text']";
		public String EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC="//td[@class='tablelabel' and text()='Disk size in MB']";
		public String GRIDCACHE_HEADER_LOC="//tr[@id='cat_GridCache']/descendant::h5[normalize-space(text())='GridCache']";
		public String MEMORY_SIZE_TOOLTIP_LOC="//input[@type='text' and @name='new-1' and @data-toggle='tooltip' and  @data-original-title='Needs to Be >= 0']";
		public String MEMORY_SIZE_DESCRIPTION_TOOLTIP="//span[@data-toggle='tooltip' and contains(@data-title,'A value of 0 disables  the memory cache')]";
		public String ALERT_LOC="//div[@class='alert alert-info alert-dismissable']";
	}
	
	//GS Locator
	public interface ManagerConfiguration_SecurityPageLocators
	{
		public String SECURITY_SIDE_MENU_LOC="//li[@class='sidebarlistsmall']/descendant::a[text()='Security']";
		public String EXPAND_ALL_LOC="//button[@id='expall']";
		public String COLLAPSE_ALL_LOC="//button[@id='clpall']";
		public String SAVE_BUTTON_LOC="//a[@class='btn btn-sm btn-blue' and text()='Save']";
		public String CANCEL_BUTTON_LOC="//a[@class='btn btn-sm btn-white' and text()='Cancel']";
		public String PAGE_REFRESH_EXPIRES_SELECT_LOC="//select[@name='new-4' and @class='bodyselect form-control']";
		public String EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC="//td[@class='tablelabel' and text()='Grid Single Sign-On']";
		public String ADMIN_USER_MANAGEMENT_HEADER_LOC="//tr[@id='cat_Admin_User_Management']/descendant::h5[normalize-space(text())='Admin User Management']";
		public String ADMIN_BROWSER_TIMEOUT_TOOLTIP_LOC="//input[@type='text' and @name='new-3' and @data-toggle='tooltip' and  @data-original-title='Needs to Be 1 - 30000']";
		public String ADMIN_BROWSER_DESCRIPTION_TOOLTIP="//span[@data-toggle='tooltip' and contains(@data-title,'Only applies to newly created sessions.')]";
	}
	
	//GS Locator
	public interface ManagerConfiguration_CommunicationPageLocators
	{
		public String COMMUNICATION_SIDE_MENU_LOC="//li[@class='sidebarlistsmall']/descendant::a[text()='Communication']";
		public String EXPAND_ALL_LOC="//button[@id='expall']";
		public String COLLAPSE_ALL_LOC="//button[@id='clpall']";
		public String SAVE_BUTTON_LOC="//a[@class='btn btn-sm btn-blue' and text()='Save']";
		public String CANCEL_BUTTON_LOC="//a[@class='btn btn-sm btn-white' and text()='Cancel']";
		public String TRANSLATE_INSIDE_RANGE_SELECT_LOC="//select[@name='new-7' and @class='bodyselect form-control']";
		public String EXPAND_COLLAPSE_VERIFICATION_TEXT_LOC="//td[@class='tablelabel' and text()='NAT Translation Range']";
		public String NAT_TRANSLATION_MANAGEMENT_HEADER_LOC="//tr[@id='cat_NAT_Translation']/descendant::h5[normalize-space(text())='NAT Translation']";
		public String SELF_PING_PERIOD_TOOLTIP_LOC="//input[@type='text' and @name='new-38' and @data-toggle='tooltip' and  @data-original-title='Needs to Be >= 0']";
		public String MANAGER_ID_DESCRIPTION_TOOLTIP="//span[@data-toggle='tooltip' and contains(@data-title,'The Manager Id, which is by default a random integer')]";
	}
	
	//GS Locator
	public interface ManagerConfiguration_HotfixesPageLocators
	{
		public String HOTFIXES_SIDE_MENU_LOC="//li[@class='sidebarlistsmall']/descendant::a[text()='Hotfixes']";
		public String EXPAND_ALL_LOC="//button[@id='expall']";
		public String COLLAPSE_ALL_LOC="//button[@id='clpall']";
		public String COLLAPSE_VERIFICATION="//tr[@class='collapse']";
		public String EXPAND_VERIFICATION="//tr[@class='collapse in']";
	}
	
	//GS Locator
	public interface EmailNotificationPageLocators
	{
		public String ADD_COLUMN_LOC="//button[@id='columnPickerParent']";
		public String SAVE_BUTTON_ADD_COLUMN_LOC="//button[@id='pickerOKBtn' and normalize-space(text())='Save']";
		public String REMOVE_COLUMN_BUTTON_LOC="//li[@class='option_show']/descendant::span[text()='%s']//following::i[@class='glyphicon glyphicon-remove remove-list-item']";
		public String ADD_COLUMN_BUTTON_LOC="//ul[@class='selectColumns']/descendant::li[@value='%s']/descendant::i[@class='glyphicon glyphicon-plus-sign add-list-item']";
		public String COLUMN_ON_TABLE="//tr[@class='active']/descendant::a[text()='%s']";
		public String REVERT_BUTTON_ADD_COLUMN_LOC="//button[@id='restoreDefaultsBtn' and normalize-space(text())='Revert']";
		public String CREATE_NEW_SUBSCRIBER_GLOBAL_ACTION_LOC="//ul[@class='globalActionsList']/descendant::li[text()='Create New Subscriber']";
		public String EMAIL_CREATE_NEW_SUB_POPUP_LOC="//input[@id='email']";
		public String FILTER_CREATE_NEW_SUB_POPUP_LOC="//input[@id='filter']";
		public String SUBMIT_BUTTON_CREATE_NEW_SUB_POPUP_LOC="//a[text()='Submit']";
		public String CANCEL_BUTTON_CREATE_NEW_SUB_POPUP_LOC="//a[text()='Cancel']";
		public String SERVICE_CHECK_CREATE_NEW_SUB_LOC="//input[@type='checkbox' and @id='ServiceEvent']";
		public String ENGINE_DIED_CHECK_LOC="//input[@type='checkbox' and @id='EngineDiedEvent']";
		public String BROKER_ADDED_CHECK_CREATE_NEW_SUB_LOC="//input[@type='checkbox' and @id='BrokerAddedEvent']";
		public String ADDED_SUBSCRIBER_VALUE_LOC="//td[@class='tablevalue' and normalize-space(text())='%s']";
		public String SUBSCRIBER_CHECK_BOX_LOC="//td[@class='tablevalue' and normalize-space(text())='%s']/preceding::input[1]";
		public String UPDATED_EVENT_VERIFY_LOC="//td[normalize-space(text())='%s']/following-sibling::td[contains(text(),'Broker Added')]";
		public String TOTAL_ROWS_AFTER_SEARCH_LOC="//span[@class='leftFloat resultscount']/descendant::strong[text()='%s']";
		public String SHOWING_RESULTS_LOC="//span[@class='leftFloat resultscount']/descendant::strong";
		
	}
	
	//GS Locator
	public interface SNMPEventTrapsLocators{
		public String SNMPVERSION_LOC="//input[@type='radio' and @id='snmpversion' and @value='%s']";
		public String BROKERADDEDEVENT_CHECKBOX_LOC="//td[@class='tablevalue' and text()='BrokerAddedEvent']/preceding::input[@type='checkbox']";
		public String HOSTNAME_INPUT_LOC="//input[@type='text' and @id='property']";
		public String PORT_INPUT_LOC="//input[@type='text' and @id='value']";
		public String ADD_BUTTON_LOC="//a[@class='btn btn-sm btn-white btn-blue' and text()='Add']";
		public String ADDED_HOST_LOC="//td[@class='tablevalue' and text()='%s']";
		public String EDIT_HOST_LOC="//td[@class='tablevalue' and text()='%s']/following-sibling::td[@class='tablevalue']/descendant::a[@class='btn btn-sm btn-white' and text()='Edit']";
		public String EDIT_HOSTNAME_INPUT_LOC="//input[@type='text' and @id='property' and @value='%s']";
		public String REMOVE_HOST_LOC="//td[@class='tablevalue' and text()='%s']/following-sibling::td[@class='tablevalue']/descendant::a[@class='btn btn-sm btn-white' and text()='Remove']";
		public String UPDATE_BUTTON_LOC="//a[@class='btn btn-sm btn-white' and text()='Update']";
	}
	
	//GS Locator
	public interface LicenseInformationLocators
	{
		public String CHOOSE_FILE_LOC="//input[@type='file']";
		public String UPLOAD_LINK_LOC="//a[@class='uploadGrid' and text()='Upload New License']";
	}
	
	
	//GS Locator
	public interface ManagerReinstallLocators
	{
		public String TOP_MENU_LINK_LOC="//a[contains(@class,'navbar-brand ') and normalize-space(text())='%s']";
		public String MANAGER_REINSTALL_LINK_LOC="//a[contains(@class,'disable_false sidebar_link') and text()=' Manager Reinstall']";
		public String NEXT_BUTTON_LOC="//a[normalize-space(text())='Next >>']";
		public String PREVIOUS_BUTTON_LOC="//a[normalize-space(text())='<< Previous']";
		public String START_OVER_BUTTON_LOC="//a[normalize-space(text())='Start Over']";
		public String FIRST_PAGE_VERIFICATION_TEXT_LOC="//div[@class='bblue leftFloat']/descendant::b[text()='Installation Type']";
		public String SECOND_PAGE_VERIFICATION_TEXT_LOC="//select[@id='director']";
	}
	
	//GS Locator
	public interface GridArchitectureLocators
	{
		public String TOP_MENU_LINK_LOC="//a[contains(@class,'navbar-brand ') and normalize-space(text())='%s']";
		public String SIDE_MENU_TITLE_LINK_LOC="//button[contains(@class,'btn') and normalize-space(text())='%s']";
		public String SIDE_MENU_ITEM_ENABLED_LINK_LOC="//a[contains(@class,'disable_false sidebar')  and normalize-space(text())='%s']";
		public String SIDE_MENU_ITEM_DISABLED_LINK_LOC="//a[contains(@class,'disable_true sidebar')  and normalize-space(text())='%s']";
	}
	public interface LocationPageLocators {
		public String CREATE_BTN_LOC= "//button[@class='btn btn-primary btn-createSF']";

		public String LOCATION_NAME_LOC = "//div[@class='col-md-8']//input[@name='property']";
		public String VALUE_LOC = "//textarea[@name='value']";
		
		
		
	}
	public interface ManagerImportExport
    {
          public String IMPORT_FILE_BUTTON_LOC="//button[contains(text(),'Import File')]";
       
       public String EXPORT_BUTTON_LOC="//a[@class='btn btn-white btn-sm']";
       public String EXPAND_ALL_BUTTON_LOC="//button[@id='expall']";
       public String COLLAPSE_ALL_BUTTON_LOC="//button[@id='clpall']";
       public String CONFIG_ALL_LOC="//th[@colspan='3']//input[@value='Select All']";
       public String DIRECTOR_HOOKS_ALL_LOC="//tbody[@id='RGlyZWN0b3IgSG9va3M']//input[@value='Select All']";
       public String DIRECTOR_REST_ALL_LOC="//input[@id='director--se-rest-logger.xml']";
       public String ENGINE_CONFIG_ALL_LOC="//tbody[@id='RW5naW5lIENvbmZpZ3VyYXRpb25z']//input[@value='Select All']";
       public String GRID_CACHE_SCEAMA_ALL_LOC="//tbody[@id='R3JpZENhY2hlIFNjaGVtYXM']//input[@value='Select All']";
       public String SERVICE_RUNNERS_ALL_LOC="//tbody[@id='U2VydmljZSBSdW5uZXJz']//input[@value='Select All']";
       public String SERVICE_TYPE_LOC="//tbody[@id='U2VydmljZSBUeXBlcw']//input[@value='Select All']";
       public String CONFIG_ALL_ARROW_LOC="//i[@id='U1RBVElDX0NBVEVHT1JZ0s']";
       public String CONFIG_DOWN_ARROW_LOC="//i[@class='glyphicon collapse_icon glyphicon-triangle-bottom' and @id='U1RBVElDX0NBVEVHT1JZ0s']";
       public String DIRECTOR_HOOKS_ALL_ARROW_LOC="//i[@id='RGlyZWN0b3IgSG9va3M1s']";
       public String ENGINE_CONFIG_ALL_ARROW_LOC="//i[@id='RW5naW5lIENvbmZpZ3VyYXRpb25z3s']";
       public String GRID_CACHE_SCEAMA_ALL_ARROW_LOC="//i[@id='R3JpZENhY2hlIFNjaGVtYXM3s']";
       public String SERVICE_RUNNERS_ALL_ARROW_LOC="//i[@id='U2VydmljZSBSdW5uZXJz4s']";
       public String SERVICE_TYPE_ARROW_LOC="//i[@id='U2VydmljZSBUeXBlcw5s']";
       public String BROKER_CONFIG="//label[@for='broker_configuration']";
       public String ENGINE_CONFIG_LOC="//tbody[@id='RW5naW5lIENvbmZpZ3VyYXRpb25z']//td[@class='textRow']//label";
       public String DIRECTOR_CONFIG_LOC= "//label[@for='director_configuration']";
       public String DIR_CONFIG_LOC="//input[@id='director_configuration']";
       public String BLANK_IMPORT="//div[@class='alert alert-info alert-dismissable']";
       public String IMPORT_UPLOAD_LOC="//a[@class='btn btn-blue']";
       public String CHOOSE_FILE_LOC="//label[@class='btn btn-sm btn-white']";
       public String JAR_IMPORT_LOC="//a[text()='Import']";
       public String ENGINE_CONFIG_IMPORT_ALL="//input[@id='import_elements_Engine Configurations_doSelect']";
       public String SUCCESS_MSG_LOC= "//td[contains(text(),'Success')]";
       public String CANCLE_BUTTON_LOC="//a[@class='btn btn-sm btn-white']";
       public String ENGINE_CONFIG_OVERWRITE_ALL_LOC="//input[@id='overwrite_Engine Configurations_doSelect']";
    }

    
	
 public interface Reports
 {
	 
	 public String DISPLAYRESULT_BUTTON_LOC="//a[contains(text(),'Display Results')]";
     public String EXPORT_BUTTON_LOC="//a[contains(text(),'Export Results')]";
     public String SUMMARIES_LOC= "//a[contains(text(),'Summaries')]";
     public String BETWEEN_LOC="//td[text()='between']//preceding::input[@name='useDateOffset'][1]";
     public String MONTH_LOC="//option[@value='Months']";
     public String DISPLAY_RESULT_LOC="//a[contains(text(),'LinpackServiceTest')]";
     public String SUMMERIES_RESULT_LOC="//td[contains(text(),'SERVICE SESSION ID')]";
     public String BACK_LINK_LOC="//a[@class='ublue']";
 }
public interface CacheRegionLocators
    {
        public String REMOVECOL="//li[@id='column_gridcachename']//i[@class='glyphicon glyphicon-remove remove-list-item']";
        public String ADDCOL="//li[@id='column_gridcachename']//i[@class='glyphicon glyphicon-plus-sign add-list-item']";
        public String NAME="//a[contains(text(),'Name')]";
        public String CACHEREGIONREVERT="//a[contains(text(),'Name')]/following::a[@class='uwhite'][contains(text(),'Entries')]";
    }
public interface RealTimeLogs
 {
	public String CLEAR_BUTTON_LOC="//a[@id='clear']";
	public String SNAPSHOT_BUTTON_LOC="//*[@id='snapshot']";
	
	public String TOP_MENU_LINK_LOC="//a[contains(@class,'navbar-brand ') and normalize-space(text())='%s']";
	public String REALTIMELOG_LINK_LOC="//a[contains(@class,'disable_false sidebar_link') and text()='Real Time Log']";
 }
 public interface ServiceDiagnostics
 {
     public String TOP_MENU_LINK_LOC="//a[contains(@class,'navbar-brand ') and normalize-space(text())='%s']";
	 public String SERVICEDIAGNOSTICS_LINK_LOC="//a[contains(@class,'disable_false sidebar_link') and text()='Service Diagnostics']";
	 public String DROP_DOWN_SESSION_LOC="//option[@value='2907482815227095637']";
	 public String SEARCH_BUTTON_LOC="//a[@class='btn btn-blue btn-sm doSearch']";
	 public String HELP_ICON_LOC="//*[@id='question-icon']";
	
 	 public String ENGINE_TABLE_LOC="//td[contains(text(),'Engine')]";
 	 public String PAGE_HELP="//span[@id='question-icon']";
 	 public String PAGE_HELP_TITLE="//div[@class='col-md-10']";
	 
 }
 public interface ManagerDiagnostics
 {
	 public String TOP_MENU_LINK_LOC="//a[contains(@class,'navbar-brand ') and normalize-space(text())='%s']";
	 public String MANAGER_DIAGNOSTICS_LINK_LOC="//a[contains(@class,'disable_false sidebar_link') and text()='Manager Diagnostics']";
	 public String MANAGER_LOGS_CHECKBOX_LOC="//input[@id='server']";
	 public String ENV_LOG_CHECKBOX_LOC="//input[@id='environment']";
	 public String TASK_QUEUE_CHECKBOX_LOC="//input[@id='taskQueues']";
	 public String DISPLAY_BUTTON_LOC="//a[contains(text(),'Display')]";
	 public String DOWNLOAD_BUTTON_LOC="//a[contains(text(),'Download')]";
	 public String BETWEEN_LOC="//tr//tbody//tbody//tbody//tr[3]//td[1]//input[1]";
	 public String WITHIN_LOST_LOC="//tr//tbody//tbody//tr[1]//td[1]";
	 public String WITHIN_LAST_HOUR_LOC="//option[@value='Hours']";
     public String WITHIN_LAST_MIN_LOC="//option[@value='Minutes']";
     public String WITHIN_LAST_YEAR_LOC="//option[@value='Years']";
     public String MAX_LOG_LINE_LOC="//input[@id='fetchSize']";
     public String VERIFY_DISPLAY_BUTTON="//body[@class='noStripe']//table//tbody//tr//td";
     
 }
 public interface AuthenticationPageLocators
        {
           
        public String AUTH_MODE = "AuthenticationMode";
        public String COLLAPSE_ALL="//button[@id='clpall']";
        public String EXPAND_ALL="//button[@id='expall']";

        public String SAVE_BUTTON="//a[contains(@class,'btn-blue')]";
        public String PROVIDERS_URL= "//input[@id='new_ProviderUrls']";
        public String USERNAME_DN= "//input[@id='new_ConnectionDn']";
        public String PASSWORD= "//input[@id='new_ConnectionPassword']";
        public String USER_SEARCH_STRING_FOR= "//input[@id='new_UserSearchFormat']";
        public String USER_SEARCH_BASE="//input[@id='new_UserSearchBase']";
        public String USER_SEARCH_SUBTREE="//select[@name='new_UserSearchSubtree']";
        public String GROUP_SEARCH_ATTRIBUTE="//input[@id='new_GroupSearchAttrName']";
        public String GROUP_SEARCH_BASE="//input[@id='new_GroupSearchBase']";
        public String GROUP_SEARCH_FORMAT="//input[@id='new_GroupSearchString']";
        public String GROUP_SEARCH_SUBTREE="//select[@name='new_GroupSearchSubtree']";
        public String CANCEL_BTN="//a[contains(@class,'btn-white')]";
        public String GLOBAL_ACTION= "//*[@id='globalActionsParent']";
       public String ADD_LDAP_SERVER_LINK_LOC = "//div[@class='selectPopup globalActionsUI']//ul[@class='globalActionsList']//li[contains(text(),'Add LDAP Server')]";
        public String ACTION_LINK="//*[@class='gearImage glyphicon glyphicon-collapse-down itemActions']";
        public String ACTION_LINK1="/html/body/div[8]/div[2]/table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/div[4]/div/table/tbody/tr[37]/th[1]/i";
        public String EXPAND_DETAILS="//li[contains(text(),'Expand Details')]";
        public String COLLAPSE_DETAILS="//li[contains(text(),'Collapse Details')]";
        public String REMOVE_LDAP="//ul[@class='itemActionsList']//li[@unselectable='on'][contains(text(),'Remove LDAP Server')]";
        public String TABLE_ARROW_DB_MODE= "//*[@id='WaffleConfig0']";
        public String WINDOWS_DOMAIN="//td[contains(text(),'Windows Domain')]";
        public String COMMON_LDAP_CONFIG_ARROW="//*[@id='CommonLDAPConfig0']";
        public String CONNE_CONFIG_ARROW="//*[@id='ConnectionConfig0']";
        public String GROUP_CONFIG_ARROW="//*[@id='GroupConfig0']";
        public String USER_CONFIG_ARROW ="//*[@id='UserConfig0']";
        public String TEST_CONNECTION="//div[@class='btn btn-default btn-sm ldapConnectionTest']";
        public String CONNE_MSG="//td[contains(text(),'Connection Successful')]";
        public String INVALIDE_PASS_CONNE_MSG="//td[contains(text(),'Error: [LDAP: error code 49 - Invalid Credentials]')]";
        public String CLOSE_BUTTON="//button[contains(text(),'Close')]";
        public String CACHE_TTL="//input[@id='new_UserCacheTTL']";
        public String INVALIDE_DN_CONNE_MSG="//td[contains(text(),'Error: [LDAP: error code 34 - invalid DN]')]";
        public String SCROLLBAR= "/html/body/div[7]/div/div[4]";
        public String CACHE_TTL_TOLLTIP="//input[@type='text' and @id='new_UserCacheTTL' and @data-toggle='tooltip' and  @data-original-title='Needs to Be >= 60']";
        }
		 public interface BatchScheduleLocators
		 {    
	   public String REFRESH_BUTTON_LOC="//button[@id='refreshParent']//img[@class='topparenticons']";
	   
	    public String BATCH_SCHEDULE_LOC="//input[@name='4[]']";
	    public String LOCAL_ACTION_LOC="//button[@id='itemButton']//span[@class='glyphicon glyphicon-option-horizontal']";
	    public String VIEW_EXECUTION_LOC="//li[contains(text(),'View Executions')]";
	    public String BATCH_DEFINATION="//td[contains(text(),'CalculatorServiceExample')]";
        public String GLOBAL_ACTION_LOC="//button[@id='globalActionsParent']//span[@class='glyphicon glyphicon-option-horizontal']";
        public String CREATE_NEW_BATCH="//li[contains(text(),'Create New Batch')]";
        public String ADD_BUTTON_LOC="//table[@class='table titleTable']//a[@class='btn btn-blue btn-sm'][contains(text(),'Add')]";
        public String REMOVE_FINISHED_BATCH_LOC="//li[contains(text(),'Remove Finished Batches')]";
        public String SUSPEND_ALL_BATCH_ON_PAGE_LOC ="//li[contains(text(),'Suspend All Batches On Page')]";
        public String SUSPEND_ALL_BATCH_LOC="//div[@id='globalActionsArea']//li[5]";
        public String SEARCH_LOGS_LOC="//li[contains(text(),'Search Logs')]";
        public String VIEW_EDIT_LOC="//li[contains(text(),'View/Edit Batch')]";
        public String BATCH_TYPE_LOC="//select[@name='Node:0.Batch.6.Schedule.p1.property.type']";
        public String SAVE_BUTTON_LOC="//a[contains(text(),'Save')]";
        public String CANCEL_BUTTON_LOC="//a[@class='btn btn-sm btn-white']";
        public String ADD_COL_LOC="//button[@id='columnPickerParent']//img[@class='topparenticons']";
        public String REMOVE_COL_OPT_LOC="//li[@id='column_batchid']//i[@class='glyphicon glyphicon-remove remove-list-item']";
        public String ADD_OPT="//li[@id='column_batchid']//i[@class='glyphicon glyphicon-plus-sign add-list-item']";
        public String BATCH_ID="//li[@id='column_batchid']";
        public String REVERT_BUTTON_LOC="//button[@id='restoreDefaultsBtn']";
        public String SAVE_COL_BUTTON_LOC="//button[@id='pickerOKBtn']";
        public String REMOVE_BATCH_LOC="//li[contains(text(),'Remove Batch')]";
       public  String BATCH_NAME_LOC="//td[contains(text(),'%s')]";
       public String BATCH_ADMIN_VERIFICATION_LOC= "//div[@class='pageTitle' and text()='Batch Admin']";
       public String DESCRIPTION_INPUT_LOC="//input[@name='Node:0.Batch.p2.property.description']";
       public String DESCRIPTION_VALUE_LOC="//td[@class='tablevalue' and text()='%s']";
       public String BATCH_DEF="//td[contains(text(),'%s')]";
      public  String BATCH_LOC="//select[contains(@onchange,'%s')]/preceding::input[@class='gearImage itemActions' and @type ='checkbox'][1]";
 	  public String BATCH_DEFINATION_PAGE_LOC="//a[contains(text(),'Batch Definitions')]";
 	 public String GLOBAL_ACTION = "//div[@class='container leftFloat tableBottomSizerArea']//button[@id='globalActionsParent']";
 	public String INVALID="//td[contains(text(),'There are no entries for this view')]";
 	 public String CLEAR="//span[@class='glyphicon glyphicon-remove']";
}

		  public interface ServiceSessionAdmin
		  {
			 public String REFRESHBUTTON="//button[@id='refreshParent']//img[@class='topparenticons']";
		     public String ADD_COL_LOC="//button[@id='columnPickerParent']//img[@class='topparenticons']";  
		     public	String REMOVE_SESSIONID_LOC="//li[@id='column_jobid']//i[@class='glyphicon glyphicon-remove remove-list-item']";
		     public	String ADD_SESSIONID="//li[@id='column_jobid']//i[@class='glyphicon glyphicon-plus-sign add-list-item']";
		     public  String ADD_APPLICATION_DESCRIPTION_LOC="//li[@id='column_jobappdesc']//i[@class='glyphicon glyphicon-plus-sign add-list-item']";
			 public	String REMOVE_APPLICATION_DESCRIPTION_LOC="//li[@id='column_jobappdesc']//i[@class='glyphicon glyphicon-remove remove-list-item']";
			 public String REVERT_BUTTON_LOC="//button[@id='restoreDefaultsBtn']";
			 public	String SAVE_BUTTON="//button[@id='pickerOKBtn']";
		   	 public String INVALID="//td[contains(text(),'There are no entries for this view')]";
		  	 public String CLEAR="//span[@class='glyphicon glyphicon-remove']";
		  	 public String GLOBAL_ACTION = "//button[@id='globalActionsParent']//span[@class='glyphicon glyphicon-option-horizontal']";
		     public String EXPAND_ALL_LOC="//li[contains(text(),'Expand View of All')]";
		 	 public String COLLAPSE_ALL_LOC="//li[contains(text(),'Collapse View of All')]";
		     public String VERIFY_EXPAND_ALL_LOC="//td[contains(text(),'Application Description')]";
		     public String REMOVE_SERVICESESSION_LOC="//li[contains(text(),'Remove Finished Service Sessions')]";
		     public String SET_PRIORITY_ON_PAGE_LOC="//li[contains(text(),'Set Priority of All Sessions on Page')]";
		     public String REMOVE_FINISH_SERVICE_SESSION_LOC="//li[contains(text(),'Remove Finished Service Sessions')]";
		     public String SERVICE_STATUS_LOC="//td[contains(text(),'Finished')]";
		     public String SET_PRIORITY_ON_PAGE="//li[contains(text(),'Set Priority of All Sessions on Page')]";
		     public String LOCAL_ACTION_LOC="//button[@id='itemButton']//span[@class='glyphicon glyphicon-option-horizontal']";
		     public String SERVICE_SESSION_CHECKBOX="//input[@name='4[]']";
		     public String CANCEL_ALL_SESSION_ON_PAGE="//li[contains(text(),'Cancel All Service Sessions on Page')]";
		     public String CANCEL_ALL_SESSION="//div[@id='globalActionsArea']//li[7]";
		     public String CANCEL_STATUS="//td[contains(text(),'Cancelled')]";
		     public String RUNNING_STATUS="//td[contains(text(),'Running')]";
		    // public string SET_PRIORITY_ON_PAGE="//li[contains(text(),'Set Priority of All Sessions on Page')]";
		     public String PRIORITY_LOC="//td[contains(text(),'Urgent')]";
		     public String URGENT_PRIORITY_LOC="//div[@class='ui-dialog ui-corner-all ui-widget ui-widget-content ui-front ui-dialog-buttons ui-draggable ui-resizable']//div[1]//input[1]";
		     public String SAVE_BUTTON_LOC="//button[@class='btn btn-small btn-blue']";
		     public String CHART_LOC="//div[@id='chart']";
		     public String SEARCH_LOGS_LOC="//code[@class='logExcerpts']";
		     public String SERVICE_TEST_PAGE_LINK="//a[contains(@class,'disable_false sidebar_link sidebar_link_selected')]";
		     public String SERVICE_NAME_LOC="//b[contains(text(),'Service Name:')]";
		     public String CANCEL_SERVICE_STATUS="//td[contains(text(),'Cancelled')]";
		  
		  }
		   
		   public interface SchedulerInstrumentation
		  {
		     public String TOP_MENU_LINK_LOC="//a[contains(@class,'navbar-brand ') and normalize-space(text())='%s']";
		 	 public String SCHEDULER_INSTRUMENATION_LINK_LOC="//a[contains(@class,'disable_false sidebar_link') and text()='Scheduler Instrumentation']";
		 	 public String DROP_DOWN_SESSION_LOC="//option[@value='2907482815227095637']";
		 	 public String SEARCH_BUTTON_LOC="//a[@class='btn btn-blue btn-sm doSearch']";
		 	 public String HELP_ICON_LOC="//*[@id='question-icon']";
		 	 public String SEARCH_BUTTON="//button[@id='searchButton']";
		 	 public String START_DATE_CALENDAR="//div[@id='datetimepicker1']//span[@class='glyphicon glyphicon-calendar']";
		 	 public String END_DATE_CALENDAR="//div[@id='datetimepicker2']//span[@class='glyphicon glyphicon-calendar']";
		 	 public String START_DATE_TEXBOX_LOC="//input[@id='startDate']";
		 	 public String END_DATE_TEXBOX_LOC="//input[@id='endDate']";
		 	public String RESULTS_PER_PAGE_LOC="//input[@id='spageSizeEditBottom']";
		 	 public String GLOBAL_ACTION = "//div[@class='container leftFloat tableBottomSizerArea']//button[@id='globalActionsParent']";
		 	 public String PAGINATION_LAST_BUTTON_BOTTOM_ENABLED_LOC="//i[@id='spagination_right_max']"; 
		 	public String PAGINATION_LAST_BUTTON_BOTTOM_DISABLED_LOC="//i[@id='spagination_right_max' and @class='glyphicon glyphicon-step-forward pageImage  pagination_disabled']";
		 	 public String PAGINATION_FIRST_BUTTON_BOTTOM_DISABLED_LOC="//i[@id='spagination_left_max' and @class='glyphicon glyphicon-step-backward pageImage  pagination_disabled']";
		 	public String PAGINATION_FIRST_BUTTON_BOTTOM_ENABLED_LOC="//i[@id='spagination_left_max']";
		 	public String SERVICES_SIDE_MENU_LOC="//li[@class='sidebarlistsmall']/descendant::a[text()='Services']";
		 	public String SAVE_BUTTON="//a[@class='btn btn-sm btn-blue']";
		 	public String CHECK_POINTS_CHEKBOX="//input[@id='scheckCP']";
		 	public String MATCH_ITEMS_CHECKBOX="//input[@id='scheckMI']";
		 	public String ENGINE_INFO_CHECKBOX="//input[@id='scheckEI']";
		 	public String WAITING_LIST_CHECKBOX="//input[@id='scheckWL']";
		 	public String CHECKPOINTS_LOC="//tr[3]//td[1]//b[1]";
		 	public String MATCHITEMS_LOC="//tr[2]//td[1]//b[1]";
		 	public String WAITINGLIST_LOC="//tr[1]//td[1]//b[1]";
		 	public String ENGINEINFO_LOC="//tr[7]//td[1]//b[1]";
		 	public String MORE_INFO_BUTTON="//tr[3]//td[5]//button[@class='expandCheckpoint btn btn-sm']";
		 	public String MORE_INFO_LOC="//tr[@id='Checks3']//td[contains(text(),'Priority : 5')]";
		 	public String KEYWORDSEARCH_LOC="//input[@id='querytext']";
		 	public String DIAGNOSTICS_LINK="//a[@id='diagnostic']";
		 	public String SCHEDULER_INSTRUMENTAION_LINK="//a[contains(text(),'Scheduler Instrumentation')]";
		    public String ADMIN_PAGE_LINK="//a[@id='admin']";
		   public String SYS_ADMIN="//button[@id='sysadmingroup']";
		   public  String MANAGER_CONFIGURATION_LINK="//a[contains(text(),'Manager Configuration')]";
		   public String CLEAR_BUTTON="//button[@id='clearButton']";
		  }
		   public interface ManagerHooks
		    {
		    	public String INVALID="//td[contains(text(),'There are no entries for this view')]";
		    	 public String CLEAR="//span[@class='glyphicon glyphicon-remove']"; 	 
		    	public String GLOBAL_ACTION = "//div[@class='container leftFloat tableBottomSizerArea']//button[@id='globalActionsParent']";
		    	 public String ADD_BUTTON_LOC="//img[@class='topparenticons']";
		    	public String ADD_COL_LOC="//li[@id='column_hookserver']//i[@class='glyphicon glyphicon-plus-sign add-list-item']";
		         public String REMOVE_COL_OPT_LOC="//li[@id='column_hookserver']//i[@class='glyphicon glyphicon-remove remove-list-item']";
		         public String SAVE_BUTTON="//button[@id='pickerOKBtn']";
			    public String REVERT_BUTTON="//button[@id='restoreDefaultsBtn']";
			    public String CREATE_NEW_HOOK="//li[contains(text(),'Create New Hook')]";
			    public String FILE_NAME_LOC="//input[@id='file']";
			    public String HOOK_TYPE="//option[contains(text(),'Broker')]";
			    public String CLASS_NAME="//input[@name='c']";
			    public String SAVE_HOOK_BUTTON="//tr[1]//td[1]//p[1]//a[@class='btn btn-sm btn-blue']";
			    public String CANCEL_HOOK_BUTTON="//tr[1]//td[1]//p[1]//a[@class='btn btn-sm btn-white']";
			    public String LOCAL_FILE_NAME="//div[@class='itemsParent notForDashboard']//td[contains(text(),'BasicBrokerHook.xml')]";
			  public String LOCAL_ACTION_LINK_LOC="//button[@id='itemButton']";
				public String LOCAL_ACTION_ITEM_LOC="//ul[@class='itemActionsList']/descendant::li[text()='%s']";
				public String HOOK_LOC="//select[contains(@onchange,'BasicBrokerHook.xml')]/preceding::input[@class='gearImage itemActions' and @type ='checkbox'][1]";
				public String UPDATE_PROPERTIES_BUTTON="//a[contains(text(),'Update Properties')]";
		        public String DESCRIPTION="//td[contains(text(),'description')]";
		        public String LOCAL_ACTION_LOC="//button[@id='itemButton']//span[@class='glyphicon glyphicon-option-horizontal']";
		        public String XML_VIEW_LOC="//select[@id='view']//option[contains(text(),'XML View')]";
		        public String HELP_PAGE_TITLE="//h4[contains(text(),'Admin > System Admin > Manager Hooks')]";
		        public String GENERATE_XML_BUTTON_LOC="//button[@class='btn btn-sm btn-blue']";
		        public String XML_AREA_LOC="//textarea[@name='contents']";
		        public String DESCRIPTION_INPUT="//input[@name='property.description']";
		        public String DESCRIPTION_VALUE_LOC="//td[contains(text(),'%s')]";
		        public String TRUE_LOC="//div[@class='itemsParent notForDashboard']//td[contains(text(),'true')]";
		        public String DESCRIPTION_LOC="//div[@class='itemsParent notForDashboard']//td[contains(text(),'%s')]";
		        public  String FALSE_LOC="//div[@class='itemsParent notForDashboard']//td[contains(text(),'false')]";
		        public String s1="//div[@class='itemsParent notForDashboard']//td[contains(text(),'%s')]";
		        public String OPTION="//a[@class='uwhite'][contains(text(),'Manager')]";
		         public String PAGE_HELP="//span[@id='question-icon']";
		         
		    
		    }
			 public interface ServiceTypes
		  {
		    public String SERVICETYPENAME_INPUTBOX="//input[@id='name']";
		    public String ADD_BUTTON_LOC="//a[@class='btn btn-blue btn-sm']";
		    public String DESCRIPTION_INPUTBOX="//textarea[@name='uidescription']";
		    public String UI_DESCRIPTION_LOC="//tbody//tr[8]//td[4]";
		    public String SERVICETYPE_SAVE_BUTTON_LOC="//tbody//tbody//tr[1]//td[1]//a[1]";
		    public String SERVICETYPE_CANCLE_LOC="//td[@colspan='3']//a[@class='btn btn-sm btn-white'][contains(text(),'Cancel')]";    
		   
		    public String SAVE_BUTTON_LOC="//button[contains(text(),'Save')]";
		    public String CANCEL_LOC="//button[contains(text(),'Cancel')]";
		    
		    public String CLASS_NAME_LOC="//input[@name='Provider.className']";
		    public String LOCAL_ACTIONS="//span[contains(@class,'glyphicon glyphicon-option-horizontal')]";
		    public String CANCEL_BUTTON_LOC="//tbody//tbody//tr[1]//td[1]//a[2]";
		    public String EDIT_SERVICETYPE="//li[contains(text(),'Edit Service Type')]";
		    public String FIRST_SERVICETYPE_LOC="//tbody//tbody//tr[2]//td[1]";
		    public String EDIT_CANCLE_BUTTON_LOC="//tbody//tbody//tr[1]//td[1]//a[2]";
		    public String EXPAND_ALL_LOC="//button[@id='expall']";
		    public String COLLAPSE_ALL_LOC="//button[@id='clpall']";
			public String DESCRIPTION_VALUE_LOC="//td[@class='tablevalue' and text()='%s']";
		   
		    public String DUPLICATE_SERVICETYPE_LOC="//td[contains(text(),'GenericService2')]";
		    public String DUPLICATE_SERVICETYPE_CHECKBOX_LOC="/html/body/div[8]/table/tbody/tr/td/div[2]/div/table/tbody/tr[13]/td[1]/input";
		    public String SCROLLBAR="/html/body/div[7]/i";
		    public String BATCH_DEF_LOC="//a[contains(text(),'Batch Definitions')]";
		    public String INITIALIZION_METHID_DESCRIPTION="//span[@data-toggle='tooltip' and contains(@data-title,'Initialization method. Called prior to the first Service invocation on an Engine. Ignored if null')]";
		    public String SERVICE_TYPE_CHECKBOX="//tr[2]//td[1]//input[1]";
		    public String INIT_METHOD_LOC="//td[contains(text(),'initMethod')]";
		    public String NEW_SERVICE_TYPE_CHECKBOX="//td[@class='tablevalue' and text()='%s']/preceding::input[@type='checkbox'][1]";
		    public String SERVICE_TYPE_LOC="//td[@class='tablevalue' and text()='%s']";
		    public String RENAME_INPUT_LOX="//div[@id='ui-id-1']//input[@id='newName']";
		    
		    public String RENAME_SAVE_BUTON_LOC="//button[@class='btn btn-small btn-blue']";
		    public String RENAME_CANCEL_LOC="//button[@class='btn btn-small btn-white']";
		  }
		 	 public interface DaemonAdminLocators
			 {
				 public String ADD_COL_OPT="//button[@id='columnPickerParent']//img[@class='topparenticons']";
				 public String REFRESH_BUTTON="//button[@id='refreshParent']//img[@class='topparenticons']";
				 public String GLOBAL_ACTION_LOC="//button[@id='globalActionsParent']//span[@class='glyphicon glyphicon-option-horizontal']";
			     public String AVAILABLE_DISK_LOC="//td[contains(text(),'availableDiskInMB')]";
			     public String VERIRY_MANUAL_MODE_ON_PAGE="//td[contains(text(),'Manual')]";
			     public String VERIFY_AUTO_MODE_ON_PAGE="//td[contains(text(),'Auto')]";
			     public String VERIFY_DISABLE_ENGINE_ON_PAGE="//td[contains(text(),'Disabled')]";
			     public String VERIFY_ENABLE_ENGINE_ON_PAGE="//td[contains(text(),'Enabled')]";
			     public String CONFIGURE_DAEMON_INSTANCES_INPUT_BOX="//input[@id='daemoninst']";
			     public String SAVE_BUTTON="//a[@class='btn btn-sm btn-blue submitbutton'][1]";
			     public String VERIFY_CONFIGURE_DAEMON="//input[@id='instances0'][@value=1]";
			     public String OK_BUTTON_LOC="//a[@class='btn btn-white btn-sm' and text()='OK'][1]";
			      public String CONFIG_CANCEL_BUTTON="//a[@class='btn btn-white btn-sm']";
			     public String CANCEL_BUTTON_LOC="//a[@class='btn btn-white btn-sm']";
			     public String ENABLE_INSTANCE_CHECKBOX="//input[@name='enabledaemoninst']";
			     public String CONFIGURATION_CHECKBOX="//input[@name='enabledaemondistro']";
			     public String ENGINE_CHECKBOX="//div[@class='itemsParent notForDashboard']//tr[2]//td[1]";
			     public String DAEMON_LOGFILES_TABLE="//table[@class='table table-bordered']";
			     public String ENGINED_LOG_FILE_LINK="//a[@class='ublue'][contains(text(),'engined.log')]";
			     public String ENGINED_LOGS_DISPLAY="//iframe[@id='fileContent']";
			     public String VERIFY_SEARCH_LOGS="//body[@class='noStripe']//table//tbody//tr//td";
			     public String AUTO_MODE="//tr[2]//td[contains(text(),'Auto')]";
			     public String MANUAL_MODE="//tr[2]//td[contains(text(),'Manual')]";
			     public String DISABLE_DAEMON="//tr[2]//td[contains(text(),'Disabled')]";
			     public String ENABLE_DAEMON="//tr[2]//td[contains(text(),'Enabled')]";
			     public String CHECKBOX="//input[@name='4[]']";
			     public String LOCAL_ACTION_ENGINE_EVENT="//span[@class='glyphicon glyphicon-option-horizontal']";
                  public String SAVE_BUTTON_ON_ENGINEPROPRTIES="//button[@class='btn btn-small btn-blue']";
                 public String CANCEL_BUTTON_ON_ENGINEPROPRTIES="//button[@class='btn btn-small btn-white']";
			     public String DROP_DOWNLIST_ON_ENGINEPROPRTIES="//button[@class='toggleList comboToggle glyphicon glyphicon-chevron-down ui-corner-right']";
			     public String SELECT_DESCRPTION="//div[@id='ui-id-50']";
			     public String REMOVE_BUTTON="//tr[@class='propRow']//button[@class='removeIcon iconButton glyphicon glyphicon-remove']";
			     public String QUARANTNE_STATUS="//td[contains(text(),'QuarantineStatus')]";
                 public String CLOSE_ENGINE_PROPERTIES="//button[@class='ui-dialog-titlebar-close']";
			     public String PLUS_BUTTON="//button[@class='addIcon iconButton glyphicon glyphicon-plus']";
			      public String DESCRIPTION_TEXTBOX="//tr[@class='propRow']//input[@class='propvalue bodyselect']";
			      public String CONFIG_ALL_SAVE_BUTTON="//a[@class='btn btn-sm btn-blue submitbutton']";
			      public String VERIFY_DEFAULT_INSTANCE="//input[@id='instances0'][@value='default']";
			      public String DESCIPTION_VALUE_ON_PAGE="//input[@id='value']";
			      public String SUBMIT_BUTTON="//a[@class='btn btn-blue btn-sm submitbutton']";
			      public String CLOSE_BUTTON="//a[@class='btn btn-blue btn-sm']";
			      public String RESTART_OK_BUTTON="//button[@class='btn btn-small btn-blue']";
			      public String VERIFY_RESTART_DAEMON_ON_PAGE="//span[@id='ui-id-1' and text()='Restart Daemons On Page']";
			      public String VERIFY_PURGE_OFFLINE_ENGINE="//td[contains(text(),'offline')]";
			     public String CONFIGURE_DAEMON_ON_PAGE_OK_BUTTON_LOC="//a[@class='btn btn-white btn-sm']";
			      public String NEXT_BUTTON="//a[@id='next_button']";
			      public String BACK_BUTTON="//a[@id='prev_button']";
			      public String SEARCH_LOGS_LOC="//code[@class='logExcerpts']";
			      public String LOCAL_ACTION_LOC="//button[@id='itemButton']//span[@class='glyphicon glyphicon-option-horizontal']";
			      public String CONFIGURE_DAEMON_SAVE_BUTTON="//a[@class='btn btn-blue btn-sm submitbutton']";
			      public String VERIFY_RESTART_ALL_DAEMON_ON_PAGE="//span[@id='ui-id-1' and text()='Restart All Daemons']";
				   public  String OFFLINE_ENGINE_CHECKBOX="//tr[@class='offline']//td[@class='tablevalue']//input[@name='4[]']";
				  public  String DESCRIPTION_VALUE_LOC="//td[@class='tablevalue' and text()='%s']";
				  	public String DESCRIPTION_TEXTBOX1="//input[@class='newPropName bodyselect comboText ui-autocomplete-input']";
				 public String ENGINE_ADMIN_PAGE_VERIFICATION_LOC="//div[@class='pageTitle' and text()='Engine Admin']";
					public String VERIFY_RESTART_DAEMON="//td[contains(text(),'restarting')]";
					public String DESCRIPTION_ADD="//li[@id='column_dyna_column_Description']//i[@class='glyphicon glyphicon-plus-sign add-list-item']";
		   	         public String ADDCOLUMNSAVE_BUTTON="//button[@id='pickerOKBtn']";
			        public String VERIFY_ADD="//a[contains(text(),'Description')]";
			        public String REMOVE_DESCRIPTIO_OPT="//li[@id='column_dyna_column_Description']//following-sibling::span[@class='pull-right']";
			       public String REVERT_BUTTON="//button[@id='restoreDefaultsBtn']";
			 }
}
