package com.example.fw;

public class ApplicationManager {
	
	
	private static ApplicationManager singletone;

	private WebDriverHelper webDriverHelper;
	
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	private NavigationHelper navigationHelper;
	private SelectHelper selectHelper;
		
	public static ApplicationManager getInstance() {
		if (singletone == null) {
			singletone = new ApplicationManager();
		}
		return singletone;
	}
	
	public void stop() {
		if (webDriverHelper != null) {
		webDriverHelper.stop();
	}
}
		public WebDriverHelper getWebDriverHelper() {
			if (webDriverHelper == null) {
				webDriverHelper = new WebDriverHelper(this);
			}	
			return webDriverHelper;
			}

		public GroupHelper getGroupHelper() {
			if (groupHelper == null) {
				groupHelper = new GroupHelper(this);
			}
			return groupHelper;
			}

		public ContactHelper getContacthelper() {
			if (contactHelper == null) {
				contactHelper = new ContactHelper(this);
			}	
			return contactHelper;
			}

		public NavigationHelper getNavigationHelper() {
			if (navigationHelper == null) {
				navigationHelper = new NavigationHelper(this);
			}		
			return navigationHelper;
			}
				

		public SelectHelper getSelectHelper() {
			if (selectHelper == null) {
				selectHelper = new SelectHelper(this);
			}		
			return selectHelper;
			}
		
		
		}
				
