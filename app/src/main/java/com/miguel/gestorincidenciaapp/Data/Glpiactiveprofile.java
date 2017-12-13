package com.miguel.gestorincidenciaapp.Data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Glpiactiveprofile {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("interface")
    @Expose
    private String _interface;
    @SerializedName("is_default")
    @Expose
    private Integer isDefault;
    @SerializedName("helpdesk_hardware")
    @Expose
    private Integer helpdeskHardware;
    @SerializedName("helpdesk_item_type")
    @Expose
    private List<String> helpdeskItemType = null;
    @SerializedName("ticket_status")
    @Expose
    private List<Object> ticketStatus = null;
    @SerializedName("date_mod")
    @Expose
    private Object dateMod;
    @SerializedName("comment")
    @Expose
    private Object comment;
    @SerializedName("problem_status")
    @Expose
    private List<Object> problemStatus = null;
    @SerializedName("create_ticket_on_login")
    @Expose
    private Integer createTicketOnLogin;
    @SerializedName("tickettemplates_id")
    @Expose
    private Integer tickettemplatesId;
    @SerializedName("change_status")
    @Expose
    private Object changeStatus;
    @SerializedName("date_creation")
    @Expose
    private Object dateCreation;
    @SerializedName("backup")
    @Expose
    private Integer backup;
    @SerializedName("bookmark_public")
    @Expose
    private Integer bookmarkPublic;
    @SerializedName("budget")
    @Expose
    private Integer budget;
    @SerializedName("calendar")
    @Expose
    private Integer calendar;
    @SerializedName("cartridge")
    @Expose
    private Integer cartridge;
    @SerializedName("certificate")
    @Expose
    private Integer certificate;
    @SerializedName("change")
    @Expose
    private Integer change;
    @SerializedName("changevalidation")
    @Expose
    private Integer changevalidation;
    @SerializedName("computer")
    @Expose
    private Integer computer;
    @SerializedName("config")
    @Expose
    private Integer config;
    @SerializedName("consumable")
    @Expose
    private Integer consumable;
    @SerializedName("contact_enterprise")
    @Expose
    private Integer contactEnterprise;
    @SerializedName("contract")
    @Expose
    private Integer contract;
    @SerializedName("device")
    @Expose
    private Integer device;
    @SerializedName("devicesimcard_pinpuk")
    @Expose
    private Integer devicesimcardPinpuk;
    @SerializedName("document")
    @Expose
    private Integer document;
    @SerializedName("domain")
    @Expose
    private Integer domain;
    @SerializedName("dropdown")
    @Expose
    private Integer dropdown;
    @SerializedName("entity")
    @Expose
    private Integer entity;
    @SerializedName("followup")
    @Expose
    private Integer followup;
    @SerializedName("group")
    @Expose
    private Integer group;
    @SerializedName("infocom")
    @Expose
    private Integer infocom;
    @SerializedName("internet")
    @Expose
    private Integer internet;
    @SerializedName("itilcategory")
    @Expose
    private Integer itilcategory;
    @SerializedName("knowbase")
    @Expose
    private Integer knowbase;
    @SerializedName("knowbasecategory")
    @Expose
    private Integer knowbasecategory;
    @SerializedName("license")
    @Expose
    private Integer license;
    @SerializedName("line")
    @Expose
    private Integer line;
    @SerializedName("lineoperator")
    @Expose
    private Integer lineoperator;
    @SerializedName("link")
    @Expose
    private Integer link;
    @SerializedName("location")
    @Expose
    private Integer location;
    @SerializedName("logs")
    @Expose
    private Integer logs;
    @SerializedName("monitor")
    @Expose
    private Integer monitor;
    @SerializedName("netpoint")
    @Expose
    private Integer netpoint;
    @SerializedName("networking")
    @Expose
    private Integer networking;
    @SerializedName("notification")
    @Expose
    private Integer notification;
    @SerializedName("password_update")
    @Expose
    private Integer passwordUpdate;
    @SerializedName("peripheral")
    @Expose
    private Integer peripheral;
    @SerializedName("phone")
    @Expose
    private Integer phone;
    @SerializedName("planning")
    @Expose
    private Integer planning;
    @SerializedName("printer")
    @Expose
    private Integer printer;
    @SerializedName("problem")
    @Expose
    private Integer problem;
    @SerializedName("profile")
    @Expose
    private Integer profile;
    @SerializedName("project")
    @Expose
    private Integer project;
    @SerializedName("projecttask")
    @Expose
    private Integer projecttask;
    @SerializedName("queuednotification")
    @Expose
    private Integer queuednotification;
    @SerializedName("reminder_public")
    @Expose
    private Integer reminderPublic;
    @SerializedName("reports")
    @Expose
    private Integer reports;
    @SerializedName("reservation")
    @Expose
    private Integer reservation;
    @SerializedName("rssfeed_public")
    @Expose
    private Integer rssfeedPublic;
    @SerializedName("rule_dictionnary_dropdown")
    @Expose
    private Integer ruleDictionnaryDropdown;
    @SerializedName("rule_dictionnary_printer")
    @Expose
    private Integer ruleDictionnaryPrinter;
    @SerializedName("rule_dictionnary_software")
    @Expose
    private Integer ruleDictionnarySoftware;
    @SerializedName("rule_import")
    @Expose
    private Integer ruleImport;
    @SerializedName("rule_ldap")
    @Expose
    private Integer ruleLdap;
    @SerializedName("rule_mailcollector")
    @Expose
    private Integer ruleMailcollector;
    @SerializedName("rule_softwarecategories")
    @Expose
    private Integer ruleSoftwarecategories;
    @SerializedName("rule_ticket")
    @Expose
    private Integer ruleTicket;
    @SerializedName("search_config")
    @Expose
    private Integer searchConfig;
    @SerializedName("show_group_hardware")
    @Expose
    private Integer showGroupHardware;
    @SerializedName("slm")
    @Expose
    private Integer slm;
    @SerializedName("software")
    @Expose
    private Integer software;
    @SerializedName("solutiontemplate")
    @Expose
    private Integer solutiontemplate;
    @SerializedName("state")
    @Expose
    private Integer state;
    @SerializedName("statistic")
    @Expose
    private Integer statistic;
    @SerializedName("task")
    @Expose
    private Integer task;
    @SerializedName("taskcategory")
    @Expose
    private Integer taskcategory;
    @SerializedName("ticket")
    @Expose
    private Integer ticket;
    @SerializedName("ticketcost")
    @Expose
    private Integer ticketcost;
    @SerializedName("ticketrecurrent")
    @Expose
    private Integer ticketrecurrent;
    @SerializedName("tickettemplate")
    @Expose
    private Integer tickettemplate;
    @SerializedName("ticketvalidation")
    @Expose
    private Integer ticketvalidation;
    @SerializedName("transfer")
    @Expose
    private Integer transfer;
    @SerializedName("typedoc")
    @Expose
    private Integer typedoc;
    @SerializedName("user")
    @Expose
    private Integer user;
    @SerializedName("entities")
    @Expose
    private List<Entity_> entities = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInterface() {
        return _interface;
    }

    public void setInterface(String _interface) {
        this._interface = _interface;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getHelpdeskHardware() {
        return helpdeskHardware;
    }

    public void setHelpdeskHardware(Integer helpdeskHardware) {
        this.helpdeskHardware = helpdeskHardware;
    }

    public List<String> getHelpdeskItemType() {
        return helpdeskItemType;
    }

    public void setHelpdeskItemType(List<String> helpdeskItemType) {
        this.helpdeskItemType = helpdeskItemType;
    }

    public List<Object> getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(List<Object> ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Object getDateMod() {
        return dateMod;
    }

    public void setDateMod(Object dateMod) {
        this.dateMod = dateMod;
    }

    public Object getComment() {
        return comment;
    }

    public void setComment(Object comment) {
        this.comment = comment;
    }

    public List<Object> getProblemStatus() {
        return problemStatus;
    }

    public void setProblemStatus(List<Object> problemStatus) {
        this.problemStatus = problemStatus;
    }

    public Integer getCreateTicketOnLogin() {
        return createTicketOnLogin;
    }

    public void setCreateTicketOnLogin(Integer createTicketOnLogin) {
        this.createTicketOnLogin = createTicketOnLogin;
    }

    public Integer getTickettemplatesId() {
        return tickettemplatesId;
    }

    public void setTickettemplatesId(Integer tickettemplatesId) {
        this.tickettemplatesId = tickettemplatesId;
    }

    public Object getChangeStatus() {
        return changeStatus;
    }

    public void setChangeStatus(Object changeStatus) {
        this.changeStatus = changeStatus;
    }

    public Object getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Object dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Integer getBackup() {
        return backup;
    }

    public void setBackup(Integer backup) {
        this.backup = backup;
    }

    public Integer getBookmarkPublic() {
        return bookmarkPublic;
    }

    public void setBookmarkPublic(Integer bookmarkPublic) {
        this.bookmarkPublic = bookmarkPublic;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getCalendar() {
        return calendar;
    }

    public void setCalendar(Integer calendar) {
        this.calendar = calendar;
    }

    public Integer getCartridge() {
        return cartridge;
    }

    public void setCartridge(Integer cartridge) {
        this.cartridge = cartridge;
    }

    public Integer getCertificate() {
        return certificate;
    }

    public void setCertificate(Integer certificate) {
        this.certificate = certificate;
    }

    public Integer getChange() {
        return change;
    }

    public void setChange(Integer change) {
        this.change = change;
    }

    public Integer getChangevalidation() {
        return changevalidation;
    }

    public void setChangevalidation(Integer changevalidation) {
        this.changevalidation = changevalidation;
    }

    public Integer getComputer() {
        return computer;
    }

    public void setComputer(Integer computer) {
        this.computer = computer;
    }

    public Integer getConfig() {
        return config;
    }

    public void setConfig(Integer config) {
        this.config = config;
    }

    public Integer getConsumable() {
        return consumable;
    }

    public void setConsumable(Integer consumable) {
        this.consumable = consumable;
    }

    public Integer getContactEnterprise() {
        return contactEnterprise;
    }

    public void setContactEnterprise(Integer contactEnterprise) {
        this.contactEnterprise = contactEnterprise;
    }

    public Integer getContract() {
        return contract;
    }

    public void setContract(Integer contract) {
        this.contract = contract;
    }

    public Integer getDevice() {
        return device;
    }

    public void setDevice(Integer device) {
        this.device = device;
    }

    public Integer getDevicesimcardPinpuk() {
        return devicesimcardPinpuk;
    }

    public void setDevicesimcardPinpuk(Integer devicesimcardPinpuk) {
        this.devicesimcardPinpuk = devicesimcardPinpuk;
    }

    public Integer getDocument() {
        return document;
    }

    public void setDocument(Integer document) {
        this.document = document;
    }

    public Integer getDomain() {
        return domain;
    }

    public void setDomain(Integer domain) {
        this.domain = domain;
    }

    public Integer getDropdown() {
        return dropdown;
    }

    public void setDropdown(Integer dropdown) {
        this.dropdown = dropdown;
    }

    public Integer getEntity() {
        return entity;
    }

    public void setEntity(Integer entity) {
        this.entity = entity;
    }

    public Integer getFollowup() {
        return followup;
    }

    public void setFollowup(Integer followup) {
        this.followup = followup;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public Integer getInfocom() {
        return infocom;
    }

    public void setInfocom(Integer infocom) {
        this.infocom = infocom;
    }

    public Integer getInternet() {
        return internet;
    }

    public void setInternet(Integer internet) {
        this.internet = internet;
    }

    public Integer getItilcategory() {
        return itilcategory;
    }

    public void setItilcategory(Integer itilcategory) {
        this.itilcategory = itilcategory;
    }

    public Integer getKnowbase() {
        return knowbase;
    }

    public void setKnowbase(Integer knowbase) {
        this.knowbase = knowbase;
    }

    public Integer getKnowbasecategory() {
        return knowbasecategory;
    }

    public void setKnowbasecategory(Integer knowbasecategory) {
        this.knowbasecategory = knowbasecategory;
    }

    public Integer getLicense() {
        return license;
    }

    public void setLicense(Integer license) {
        this.license = license;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public Integer getLineoperator() {
        return lineoperator;
    }

    public void setLineoperator(Integer lineoperator) {
        this.lineoperator = lineoperator;
    }

    public Integer getLink() {
        return link;
    }

    public void setLink(Integer link) {
        this.link = link;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public Integer getLogs() {
        return logs;
    }

    public void setLogs(Integer logs) {
        this.logs = logs;
    }

    public Integer getMonitor() {
        return monitor;
    }

    public void setMonitor(Integer monitor) {
        this.monitor = monitor;
    }

    public Integer getNetpoint() {
        return netpoint;
    }

    public void setNetpoint(Integer netpoint) {
        this.netpoint = netpoint;
    }

    public Integer getNetworking() {
        return networking;
    }

    public void setNetworking(Integer networking) {
        this.networking = networking;
    }

    public Integer getNotification() {
        return notification;
    }

    public void setNotification(Integer notification) {
        this.notification = notification;
    }

    public Integer getPasswordUpdate() {
        return passwordUpdate;
    }

    public void setPasswordUpdate(Integer passwordUpdate) {
        this.passwordUpdate = passwordUpdate;
    }

    public Integer getPeripheral() {
        return peripheral;
    }

    public void setPeripheral(Integer peripheral) {
        this.peripheral = peripheral;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getPlanning() {
        return planning;
    }

    public void setPlanning(Integer planning) {
        this.planning = planning;
    }

    public Integer getPrinter() {
        return printer;
    }

    public void setPrinter(Integer printer) {
        this.printer = printer;
    }

    public Integer getProblem() {
        return problem;
    }

    public void setProblem(Integer problem) {
        this.problem = problem;
    }

    public Integer getProfile() {
        return profile;
    }

    public void setProfile(Integer profile) {
        this.profile = profile;
    }

    public Integer getProject() {
        return project;
    }

    public void setProject(Integer project) {
        this.project = project;
    }

    public Integer getProjecttask() {
        return projecttask;
    }

    public void setProjecttask(Integer projecttask) {
        this.projecttask = projecttask;
    }

    public Integer getQueuednotification() {
        return queuednotification;
    }

    public void setQueuednotification(Integer queuednotification) {
        this.queuednotification = queuednotification;
    }

    public Integer getReminderPublic() {
        return reminderPublic;
    }

    public void setReminderPublic(Integer reminderPublic) {
        this.reminderPublic = reminderPublic;
    }

    public Integer getReports() {
        return reports;
    }

    public void setReports(Integer reports) {
        this.reports = reports;
    }

    public Integer getReservation() {
        return reservation;
    }

    public void setReservation(Integer reservation) {
        this.reservation = reservation;
    }

    public Integer getRssfeedPublic() {
        return rssfeedPublic;
    }

    public void setRssfeedPublic(Integer rssfeedPublic) {
        this.rssfeedPublic = rssfeedPublic;
    }

    public Integer getRuleDictionnaryDropdown() {
        return ruleDictionnaryDropdown;
    }

    public void setRuleDictionnaryDropdown(Integer ruleDictionnaryDropdown) {
        this.ruleDictionnaryDropdown = ruleDictionnaryDropdown;
    }

    public Integer getRuleDictionnaryPrinter() {
        return ruleDictionnaryPrinter;
    }

    public void setRuleDictionnaryPrinter(Integer ruleDictionnaryPrinter) {
        this.ruleDictionnaryPrinter = ruleDictionnaryPrinter;
    }

    public Integer getRuleDictionnarySoftware() {
        return ruleDictionnarySoftware;
    }

    public void setRuleDictionnarySoftware(Integer ruleDictionnarySoftware) {
        this.ruleDictionnarySoftware = ruleDictionnarySoftware;
    }

    public Integer getRuleImport() {
        return ruleImport;
    }

    public void setRuleImport(Integer ruleImport) {
        this.ruleImport = ruleImport;
    }

    public Integer getRuleLdap() {
        return ruleLdap;
    }

    public void setRuleLdap(Integer ruleLdap) {
        this.ruleLdap = ruleLdap;
    }

    public Integer getRuleMailcollector() {
        return ruleMailcollector;
    }

    public void setRuleMailcollector(Integer ruleMailcollector) {
        this.ruleMailcollector = ruleMailcollector;
    }

    public Integer getRuleSoftwarecategories() {
        return ruleSoftwarecategories;
    }

    public void setRuleSoftwarecategories(Integer ruleSoftwarecategories) {
        this.ruleSoftwarecategories = ruleSoftwarecategories;
    }

    public Integer getRuleTicket() {
        return ruleTicket;
    }

    public void setRuleTicket(Integer ruleTicket) {
        this.ruleTicket = ruleTicket;
    }

    public Integer getSearchConfig() {
        return searchConfig;
    }

    public void setSearchConfig(Integer searchConfig) {
        this.searchConfig = searchConfig;
    }

    public Integer getShowGroupHardware() {
        return showGroupHardware;
    }

    public void setShowGroupHardware(Integer showGroupHardware) {
        this.showGroupHardware = showGroupHardware;
    }

    public Integer getSlm() {
        return slm;
    }

    public void setSlm(Integer slm) {
        this.slm = slm;
    }

    public Integer getSoftware() {
        return software;
    }

    public void setSoftware(Integer software) {
        this.software = software;
    }

    public Integer getSolutiontemplate() {
        return solutiontemplate;
    }

    public void setSolutiontemplate(Integer solutiontemplate) {
        this.solutiontemplate = solutiontemplate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getStatistic() {
        return statistic;
    }

    public void setStatistic(Integer statistic) {
        this.statistic = statistic;
    }

    public Integer getTask() {
        return task;
    }

    public void setTask(Integer task) {
        this.task = task;
    }

    public Integer getTaskcategory() {
        return taskcategory;
    }

    public void setTaskcategory(Integer taskcategory) {
        this.taskcategory = taskcategory;
    }

    public Integer getTicket() {
        return ticket;
    }

    public void setTicket(Integer ticket) {
        this.ticket = ticket;
    }

    public Integer getTicketcost() {
        return ticketcost;
    }

    public void setTicketcost(Integer ticketcost) {
        this.ticketcost = ticketcost;
    }

    public Integer getTicketrecurrent() {
        return ticketrecurrent;
    }

    public void setTicketrecurrent(Integer ticketrecurrent) {
        this.ticketrecurrent = ticketrecurrent;
    }

    public Integer getTickettemplate() {
        return tickettemplate;
    }

    public void setTickettemplate(Integer tickettemplate) {
        this.tickettemplate = tickettemplate;
    }

    public Integer getTicketvalidation() {
        return ticketvalidation;
    }

    public void setTicketvalidation(Integer ticketvalidation) {
        this.ticketvalidation = ticketvalidation;
    }

    public Integer getTransfer() {
        return transfer;
    }

    public void setTransfer(Integer transfer) {
        this.transfer = transfer;
    }

    public Integer getTypedoc() {
        return typedoc;
    }

    public void setTypedoc(Integer typedoc) {
        this.typedoc = typedoc;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public List<Entity_> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity_> entities) {
        this.entities = entities;
    }

}
