package com.miguel.gestorincidenciaapp.Data;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Session {

    @SerializedName("glpi_plugins")
    @Expose
    private List<Object> glpiPlugins = null;
    @SerializedName("valid_id")
    @Expose
    private String validId;
    @SerializedName("glpi_currenttime")
    @Expose
    private String glpiCurrenttime;
    @SerializedName("glpi_use_mode")
    @Expose
    private Integer glpiUseMode;
    @SerializedName("glpi_table_of")
    @Expose
    private GlpiTableOf glpiTableOf;
    @SerializedName("glpiID")
    @Expose
    private Integer glpiID;
    @SerializedName("glpiname")
    @Expose
    private String glpiname;
    @SerializedName("glpirealname")
    @Expose
    private String glpirealname;
    @SerializedName("glpifirstname")
    @Expose
    private Object glpifirstname;
    @SerializedName("glpidefault_entity")
    @Expose
    private Integer glpidefaultEntity;
    @SerializedName("glpiusers_idisation")
    @Expose
    private Boolean glpiusersIdisation;
    @SerializedName("glpiextauth")
    @Expose
    private Integer glpiextauth;
    @SerializedName("glpiauthtype")
    @Expose
    private Integer glpiauthtype;
    @SerializedName("glpiroot")
    @Expose
    private String glpiroot;
    @SerializedName("glpi_plannings")
    @Expose
    private List<Object> glpiPlannings = null;
    @SerializedName("glpicrontimer")
    @Expose
    private Integer glpicrontimer;
    @SerializedName("glpi_tabs")
    @Expose
    private List<Object> glpiTabs = null;
    @SerializedName("glpibackcreated")
    @Expose
    private Integer glpibackcreated;
    @SerializedName("glpicsv_delimiter")
    @Expose
    private String glpicsvDelimiter;
    @SerializedName("glpidate_format")
    @Expose
    private Integer glpidateFormat;
    @SerializedName("glpidefault_requesttypes_id")
    @Expose
    private Integer glpidefaultRequesttypesId;
    @SerializedName("glpidisplay_count_on_home")
    @Expose
    private Integer glpidisplayCountOnHome;
    @SerializedName("glpiduedatecritical_color")
    @Expose
    private String glpiduedatecriticalColor;
    @SerializedName("glpiduedatecritical_less")
    @Expose
    private Integer glpiduedatecriticalLess;
    @SerializedName("glpiduedatecritical_unit")
    @Expose
    private String glpiduedatecriticalUnit;
    @SerializedName("glpiduedateok_color")
    @Expose
    private String glpiduedateokColor;
    @SerializedName("glpiduedatewarning_color")
    @Expose
    private String glpiduedatewarningColor;
    @SerializedName("glpiduedatewarning_less")
    @Expose
    private Integer glpiduedatewarningLess;
    @SerializedName("glpiduedatewarning_unit")
    @Expose
    private String glpiduedatewarningUnit;
    @SerializedName("glpifollowup_private")
    @Expose
    private Integer glpifollowupPrivate;
    @SerializedName("glpiis_ids_visible")
    @Expose
    private Integer glpiisIdsVisible;
    @SerializedName("glpikeep_devices_when_purging_item")
    @Expose
    private Integer glpikeepDevicesWhenPurgingItem;
    @SerializedName("glpilanguage")
    @Expose
    private String glpilanguage;
    @SerializedName("glpilist_limit")
    @Expose
    private Integer glpilistLimit;
    @SerializedName("glpilock_autolock_mode")
    @Expose
    private Integer glpilockAutolockMode;
    @SerializedName("glpilock_directunlock_notification")
    @Expose
    private Integer glpilockDirectunlockNotification;
    @SerializedName("glpinames_format")
    @Expose
    private Integer glpinamesFormat;
    @SerializedName("glpinotification_to_myself")
    @Expose
    private Integer glpinotificationToMyself;
    @SerializedName("glpinumber_format")
    @Expose
    private Integer glpinumberFormat;
    @SerializedName("glpipdffont")
    @Expose
    private String glpipdffont;
    @SerializedName("glpipriority_1")
    @Expose
    private String glpipriority1;
    @SerializedName("glpipriority_2")
    @Expose
    private String glpipriority2;
    @SerializedName("glpipriority_3")
    @Expose
    private String glpipriority3;
    @SerializedName("glpipriority_4")
    @Expose
    private String glpipriority4;
    @SerializedName("glpipriority_5")
    @Expose
    private String glpipriority5;
    @SerializedName("glpipriority_6")
    @Expose
    private String glpipriority6;
    @SerializedName("glpirefresh_ticket_list")
    @Expose
    private Integer glpirefreshTicketList;
    @SerializedName("glpiset_default_tech")
    @Expose
    private Integer glpisetDefaultTech;
    @SerializedName("glpiset_default_requester")
    @Expose
    private Integer glpisetDefaultRequester;
    @SerializedName("glpishow_count_on_tabs")
    @Expose
    private Integer glpishowCountOnTabs;
    @SerializedName("glpishow_jobs_at_login")
    @Expose
    private Integer glpishowJobsAtLogin;
    @SerializedName("glpitask_private")
    @Expose
    private Integer glpitaskPrivate;
    @SerializedName("glpitask_state")
    @Expose
    private Integer glpitaskState;
    @SerializedName("glpiuse_flat_dropdowntree")
    @Expose
    private Integer glpiuseFlatDropdowntree;
    @SerializedName("glpilayout")
    @Expose
    private String glpilayout;
    @SerializedName("glpiticket_timeline")
    @Expose
    private Integer glpiticketTimeline;
    @SerializedName("glpiticket_timeline_keep_replaced_tabs")
    @Expose
    private Integer glpiticketTimelineKeepReplacedTabs;
    @SerializedName("glpipalette")
    @Expose
    private String glpipalette;
    @SerializedName("glpihighcontrast_css")
    @Expose
    private Integer glpihighcontrastCss;
    @SerializedName("glpi_dropdowntranslations")
    @Expose
    private List<Object> glpiDropdowntranslations = null;
    @SerializedName("glpipluralnumber")
    @Expose
    private Integer glpipluralnumber;
    @SerializedName("glpiprofiles")
    @Expose
    private Glpiprofiles glpiprofiles;
    @SerializedName("glpiactiveprofile")
    @Expose
    private Glpiactiveprofile glpiactiveprofile;
    @SerializedName("glpiactiveentities")
    @Expose
    private List<Integer> glpiactiveentities = null;
    @SerializedName("glpisearch")
    @Expose
    private List<Object> glpisearch = null;
    @SerializedName("glpiactiveentities_string")
    @Expose
    private String glpiactiveentitiesString;
    @SerializedName("glpiparententities")
    @Expose
    private List<Object> glpiparententities = null;
    @SerializedName("glpiparententities_string")
    @Expose
    private String glpiparententitiesString;
    @SerializedName("glpiactive_entity")
    @Expose
    private Integer glpiactiveEntity;
    @SerializedName("glpiactive_entity_recursive")
    @Expose
    private Integer glpiactiveEntityRecursive;
    @SerializedName("glpiactive_entity_name")
    @Expose
    private String glpiactiveEntityName;
    @SerializedName("glpiactive_entity_shortname")
    @Expose
    private String glpiactiveEntityShortname;
    @SerializedName("glpishowallentities")
    @Expose
    private Integer glpishowallentities;
    @SerializedName("glpigroups")
    @Expose
    private List<Object> glpigroups = null;
    @SerializedName("noAUTO")
    @Expose
    private Integer noAUTO;

    public List<Object> getGlpiPlugins() {
        return glpiPlugins;
    }

    public void setGlpiPlugins(List<Object> glpiPlugins) {
        this.glpiPlugins = glpiPlugins;
    }

    public String getValidId() {
        return validId;
    }

    public void setValidId(String validId) {
        this.validId = validId;
    }

    public String getGlpiCurrenttime() {
        return glpiCurrenttime;
    }

    public void setGlpiCurrenttime(String glpiCurrenttime) {
        this.glpiCurrenttime = glpiCurrenttime;
    }

    public Integer getGlpiUseMode() {
        return glpiUseMode;
    }

    public void setGlpiUseMode(Integer glpiUseMode) {
        this.glpiUseMode = glpiUseMode;
    }

    public GlpiTableOf getGlpiTableOf() {
        return glpiTableOf;
    }

    public void setGlpiTableOf(GlpiTableOf glpiTableOf) {
        this.glpiTableOf = glpiTableOf;
    }

    public Integer getGlpiID() {
        return glpiID;
    }

    public void setGlpiID(Integer glpiID) {
        this.glpiID = glpiID;
    }

    public String getGlpiname() {
        return glpiname;
    }

    public void setGlpiname(String glpiname) {
        this.glpiname = glpiname;
    }

    public String getGlpirealname() {
        return glpirealname;
    }

    public void setGlpirealname(String glpirealname) {
        this.glpirealname = glpirealname;
    }

    public Object getGlpifirstname() {
        return glpifirstname;
    }

    public void setGlpifirstname(Object glpifirstname) {
        this.glpifirstname = glpifirstname;
    }

    public Integer getGlpidefaultEntity() {
        return glpidefaultEntity;
    }

    public void setGlpidefaultEntity(Integer glpidefaultEntity) {
        this.glpidefaultEntity = glpidefaultEntity;
    }

    public Boolean getGlpiusersIdisation() {
        return glpiusersIdisation;
    }

    public void setGlpiusersIdisation(Boolean glpiusersIdisation) {
        this.glpiusersIdisation = glpiusersIdisation;
    }

    public Integer getGlpiextauth() {
        return glpiextauth;
    }

    public void setGlpiextauth(Integer glpiextauth) {
        this.glpiextauth = glpiextauth;
    }

    public Integer getGlpiauthtype() {
        return glpiauthtype;
    }

    public void setGlpiauthtype(Integer glpiauthtype) {
        this.glpiauthtype = glpiauthtype;
    }

    public String getGlpiroot() {
        return glpiroot;
    }

    public void setGlpiroot(String glpiroot) {
        this.glpiroot = glpiroot;
    }

    public List<Object> getGlpiPlannings() {
        return glpiPlannings;
    }

    public void setGlpiPlannings(List<Object> glpiPlannings) {
        this.glpiPlannings = glpiPlannings;
    }

    public Integer getGlpicrontimer() {
        return glpicrontimer;
    }

    public void setGlpicrontimer(Integer glpicrontimer) {
        this.glpicrontimer = glpicrontimer;
    }

    public List<Object> getGlpiTabs() {
        return glpiTabs;
    }

    public void setGlpiTabs(List<Object> glpiTabs) {
        this.glpiTabs = glpiTabs;
    }

    public Integer getGlpibackcreated() {
        return glpibackcreated;
    }

    public void setGlpibackcreated(Integer glpibackcreated) {
        this.glpibackcreated = glpibackcreated;
    }

    public String getGlpicsvDelimiter() {
        return glpicsvDelimiter;
    }

    public void setGlpicsvDelimiter(String glpicsvDelimiter) {
        this.glpicsvDelimiter = glpicsvDelimiter;
    }

    public Integer getGlpidateFormat() {
        return glpidateFormat;
    }

    public void setGlpidateFormat(Integer glpidateFormat) {
        this.glpidateFormat = glpidateFormat;
    }

    public Integer getGlpidefaultRequesttypesId() {
        return glpidefaultRequesttypesId;
    }

    public void setGlpidefaultRequesttypesId(Integer glpidefaultRequesttypesId) {
        this.glpidefaultRequesttypesId = glpidefaultRequesttypesId;
    }

    public Integer getGlpidisplayCountOnHome() {
        return glpidisplayCountOnHome;
    }

    public void setGlpidisplayCountOnHome(Integer glpidisplayCountOnHome) {
        this.glpidisplayCountOnHome = glpidisplayCountOnHome;
    }

    public String getGlpiduedatecriticalColor() {
        return glpiduedatecriticalColor;
    }

    public void setGlpiduedatecriticalColor(String glpiduedatecriticalColor) {
        this.glpiduedatecriticalColor = glpiduedatecriticalColor;
    }

    public Integer getGlpiduedatecriticalLess() {
        return glpiduedatecriticalLess;
    }

    public void setGlpiduedatecriticalLess(Integer glpiduedatecriticalLess) {
        this.glpiduedatecriticalLess = glpiduedatecriticalLess;
    }

    public String getGlpiduedatecriticalUnit() {
        return glpiduedatecriticalUnit;
    }

    public void setGlpiduedatecriticalUnit(String glpiduedatecriticalUnit) {
        this.glpiduedatecriticalUnit = glpiduedatecriticalUnit;
    }

    public String getGlpiduedateokColor() {
        return glpiduedateokColor;
    }

    public void setGlpiduedateokColor(String glpiduedateokColor) {
        this.glpiduedateokColor = glpiduedateokColor;
    }

    public String getGlpiduedatewarningColor() {
        return glpiduedatewarningColor;
    }

    public void setGlpiduedatewarningColor(String glpiduedatewarningColor) {
        this.glpiduedatewarningColor = glpiduedatewarningColor;
    }

    public Integer getGlpiduedatewarningLess() {
        return glpiduedatewarningLess;
    }

    public void setGlpiduedatewarningLess(Integer glpiduedatewarningLess) {
        this.glpiduedatewarningLess = glpiduedatewarningLess;
    }

    public String getGlpiduedatewarningUnit() {
        return glpiduedatewarningUnit;
    }

    public void setGlpiduedatewarningUnit(String glpiduedatewarningUnit) {
        this.glpiduedatewarningUnit = glpiduedatewarningUnit;
    }

    public Integer getGlpifollowupPrivate() {
        return glpifollowupPrivate;
    }

    public void setGlpifollowupPrivate(Integer glpifollowupPrivate) {
        this.glpifollowupPrivate = glpifollowupPrivate;
    }

    public Integer getGlpiisIdsVisible() {
        return glpiisIdsVisible;
    }

    public void setGlpiisIdsVisible(Integer glpiisIdsVisible) {
        this.glpiisIdsVisible = glpiisIdsVisible;
    }

    public Integer getGlpikeepDevicesWhenPurgingItem() {
        return glpikeepDevicesWhenPurgingItem;
    }

    public void setGlpikeepDevicesWhenPurgingItem(Integer glpikeepDevicesWhenPurgingItem) {
        this.glpikeepDevicesWhenPurgingItem = glpikeepDevicesWhenPurgingItem;
    }

    public String getGlpilanguage() {
        return glpilanguage;
    }

    public void setGlpilanguage(String glpilanguage) {
        this.glpilanguage = glpilanguage;
    }

    public Integer getGlpilistLimit() {
        return glpilistLimit;
    }

    public void setGlpilistLimit(Integer glpilistLimit) {
        this.glpilistLimit = glpilistLimit;
    }

    public Integer getGlpilockAutolockMode() {
        return glpilockAutolockMode;
    }

    public void setGlpilockAutolockMode(Integer glpilockAutolockMode) {
        this.glpilockAutolockMode = glpilockAutolockMode;
    }

    public Integer getGlpilockDirectunlockNotification() {
        return glpilockDirectunlockNotification;
    }

    public void setGlpilockDirectunlockNotification(Integer glpilockDirectunlockNotification) {
        this.glpilockDirectunlockNotification = glpilockDirectunlockNotification;
    }

    public Integer getGlpinamesFormat() {
        return glpinamesFormat;
    }

    public void setGlpinamesFormat(Integer glpinamesFormat) {
        this.glpinamesFormat = glpinamesFormat;
    }

    public Integer getGlpinotificationToMyself() {
        return glpinotificationToMyself;
    }

    public void setGlpinotificationToMyself(Integer glpinotificationToMyself) {
        this.glpinotificationToMyself = glpinotificationToMyself;
    }

    public Integer getGlpinumberFormat() {
        return glpinumberFormat;
    }

    public void setGlpinumberFormat(Integer glpinumberFormat) {
        this.glpinumberFormat = glpinumberFormat;
    }

    public String getGlpipdffont() {
        return glpipdffont;
    }

    public void setGlpipdffont(String glpipdffont) {
        this.glpipdffont = glpipdffont;
    }

    public String getGlpipriority1() {
        return glpipriority1;
    }

    public void setGlpipriority1(String glpipriority1) {
        this.glpipriority1 = glpipriority1;
    }

    public String getGlpipriority2() {
        return glpipriority2;
    }

    public void setGlpipriority2(String glpipriority2) {
        this.glpipriority2 = glpipriority2;
    }

    public String getGlpipriority3() {
        return glpipriority3;
    }

    public void setGlpipriority3(String glpipriority3) {
        this.glpipriority3 = glpipriority3;
    }

    public String getGlpipriority4() {
        return glpipriority4;
    }

    public void setGlpipriority4(String glpipriority4) {
        this.glpipriority4 = glpipriority4;
    }

    public String getGlpipriority5() {
        return glpipriority5;
    }

    public void setGlpipriority5(String glpipriority5) {
        this.glpipriority5 = glpipriority5;
    }

    public String getGlpipriority6() {
        return glpipriority6;
    }

    public void setGlpipriority6(String glpipriority6) {
        this.glpipriority6 = glpipriority6;
    }

    public Integer getGlpirefreshTicketList() {
        return glpirefreshTicketList;
    }

    public void setGlpirefreshTicketList(Integer glpirefreshTicketList) {
        this.glpirefreshTicketList = glpirefreshTicketList;
    }

    public Integer getGlpisetDefaultTech() {
        return glpisetDefaultTech;
    }

    public void setGlpisetDefaultTech(Integer glpisetDefaultTech) {
        this.glpisetDefaultTech = glpisetDefaultTech;
    }

    public Integer getGlpisetDefaultRequester() {
        return glpisetDefaultRequester;
    }

    public void setGlpisetDefaultRequester(Integer glpisetDefaultRequester) {
        this.glpisetDefaultRequester = glpisetDefaultRequester;
    }

    public Integer getGlpishowCountOnTabs() {
        return glpishowCountOnTabs;
    }

    public void setGlpishowCountOnTabs(Integer glpishowCountOnTabs) {
        this.glpishowCountOnTabs = glpishowCountOnTabs;
    }

    public Integer getGlpishowJobsAtLogin() {
        return glpishowJobsAtLogin;
    }

    public void setGlpishowJobsAtLogin(Integer glpishowJobsAtLogin) {
        this.glpishowJobsAtLogin = glpishowJobsAtLogin;
    }

    public Integer getGlpitaskPrivate() {
        return glpitaskPrivate;
    }

    public void setGlpitaskPrivate(Integer glpitaskPrivate) {
        this.glpitaskPrivate = glpitaskPrivate;
    }

    public Integer getGlpitaskState() {
        return glpitaskState;
    }

    public void setGlpitaskState(Integer glpitaskState) {
        this.glpitaskState = glpitaskState;
    }

    public Integer getGlpiuseFlatDropdowntree() {
        return glpiuseFlatDropdowntree;
    }

    public void setGlpiuseFlatDropdowntree(Integer glpiuseFlatDropdowntree) {
        this.glpiuseFlatDropdowntree = glpiuseFlatDropdowntree;
    }

    public String getGlpilayout() {
        return glpilayout;
    }

    public void setGlpilayout(String glpilayout) {
        this.glpilayout = glpilayout;
    }

    public Integer getGlpiticketTimeline() {
        return glpiticketTimeline;
    }

    public void setGlpiticketTimeline(Integer glpiticketTimeline) {
        this.glpiticketTimeline = glpiticketTimeline;
    }

    public Integer getGlpiticketTimelineKeepReplacedTabs() {
        return glpiticketTimelineKeepReplacedTabs;
    }

    public void setGlpiticketTimelineKeepReplacedTabs(Integer glpiticketTimelineKeepReplacedTabs) {
        this.glpiticketTimelineKeepReplacedTabs = glpiticketTimelineKeepReplacedTabs;
    }

    public String getGlpipalette() {
        return glpipalette;
    }

    public void setGlpipalette(String glpipalette) {
        this.glpipalette = glpipalette;
    }

    public Integer getGlpihighcontrastCss() {
        return glpihighcontrastCss;
    }

    public void setGlpihighcontrastCss(Integer glpihighcontrastCss) {
        this.glpihighcontrastCss = glpihighcontrastCss;
    }

    public List<Object> getGlpiDropdowntranslations() {
        return glpiDropdowntranslations;
    }

    public void setGlpiDropdowntranslations(List<Object> glpiDropdowntranslations) {
        this.glpiDropdowntranslations = glpiDropdowntranslations;
    }

    public Integer getGlpipluralnumber() {
        return glpipluralnumber;
    }

    public void setGlpipluralnumber(Integer glpipluralnumber) {
        this.glpipluralnumber = glpipluralnumber;
    }

    public Glpiprofiles getGlpiprofiles() {
        return glpiprofiles;
    }

    public void setGlpiprofiles(Glpiprofiles glpiprofiles) {
        this.glpiprofiles = glpiprofiles;
    }

    public Glpiactiveprofile getGlpiactiveprofile() {
        return glpiactiveprofile;
    }

    public void setGlpiactiveprofile(Glpiactiveprofile glpiactiveprofile) {
        this.glpiactiveprofile = glpiactiveprofile;
    }

    public List<Integer> getGlpiactiveentities() {
        return glpiactiveentities;
    }

    public void setGlpiactiveentities(List<Integer> glpiactiveentities) {
        this.glpiactiveentities = glpiactiveentities;
    }

    public List<Object> getGlpisearch() {
        return glpisearch;
    }

    public void setGlpisearch(List<Object> glpisearch) {
        this.glpisearch = glpisearch;
    }

    public String getGlpiactiveentitiesString() {
        return glpiactiveentitiesString;
    }

    public void setGlpiactiveentitiesString(String glpiactiveentitiesString) {
        this.glpiactiveentitiesString = glpiactiveentitiesString;
    }

    public List<Object> getGlpiparententities() {
        return glpiparententities;
    }

    public void setGlpiparententities(List<Object> glpiparententities) {
        this.glpiparententities = glpiparententities;
    }

    public String getGlpiparententitiesString() {
        return glpiparententitiesString;
    }

    public void setGlpiparententitiesString(String glpiparententitiesString) {
        this.glpiparententitiesString = glpiparententitiesString;
    }

    public Integer getGlpiactiveEntity() {
        return glpiactiveEntity;
    }

    public void setGlpiactiveEntity(Integer glpiactiveEntity) {
        this.glpiactiveEntity = glpiactiveEntity;
    }

    public Integer getGlpiactiveEntityRecursive() {
        return glpiactiveEntityRecursive;
    }

    public void setGlpiactiveEntityRecursive(Integer glpiactiveEntityRecursive) {
        this.glpiactiveEntityRecursive = glpiactiveEntityRecursive;
    }

    public String getGlpiactiveEntityName() {
        return glpiactiveEntityName;
    }

    public void setGlpiactiveEntityName(String glpiactiveEntityName) {
        this.glpiactiveEntityName = glpiactiveEntityName;
    }

    public String getGlpiactiveEntityShortname() {
        return glpiactiveEntityShortname;
    }

    public void setGlpiactiveEntityShortname(String glpiactiveEntityShortname) {
        this.glpiactiveEntityShortname = glpiactiveEntityShortname;
    }

    public Integer getGlpishowallentities() {
        return glpishowallentities;
    }

    public void setGlpishowallentities(Integer glpishowallentities) {
        this.glpishowallentities = glpishowallentities;
    }

    public List<Object> getGlpigroups() {
        return glpigroups;
    }

    public void setGlpigroups(List<Object> glpigroups) {
        this.glpigroups = glpigroups;
    }

    public Integer getNoAUTO() {
        return noAUTO;
    }

    public void setNoAUTO(Integer noAUTO) {
        this.noAUTO = noAUTO;
    }

}
