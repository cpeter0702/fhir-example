package dao;

import java.util.Date;

public class ObservationDao {
	private String obsId;
	private String obsStatus;
	private String obsSubjectType;
	private String obsSubjectId;
	private Date obsEffectiveStart;
	private Date obsEffectiveEnd;
	private String obsPerformerType;
	private String obsPerformerId;
	private String obsValue;
	private Date obsCreated;
	private String systemUrl;
	private String systemCode;
	private String systemDisplay;
	
	
	
	
	
	public String getObsId() {
		return obsId;
	}
	public void setObsId(String obsId) {
		this.obsId = obsId;
	}
	public String getObsStatus() {
		return obsStatus;
	}
	public void setObsStatus(String obsStatus) {
		this.obsStatus = obsStatus;
	}
	public String getObsSubjectType() {
		return obsSubjectType;
	}
	public void setObsSubjectType(String obsSubjectType) {
		this.obsSubjectType = obsSubjectType;
	}
	public String getObsSubjectId() {
		return obsSubjectId;
	}
	public void setObsSubjectId(String obsSubjectId) {
		this.obsSubjectId = obsSubjectId;
	}
	public Date getObsEffectiveStart() {
		return obsEffectiveStart;
	}
	public void setObsEffectiveStart(Date obsEffectiveStart) {
		this.obsEffectiveStart = obsEffectiveStart;
	}
	public Date getObsEffectiveEnd() {
		return obsEffectiveEnd;
	}
	public void setObsEffectiveEnd(Date obsEffectiveEnd) {
		this.obsEffectiveEnd = obsEffectiveEnd;
	}
	public String getObsPerformerType() {
		return obsPerformerType;
	}
	public void setObsPerformerType(String obsPerformerType) {
		this.obsPerformerType = obsPerformerType;
	}
	public String getObsPerformerId() {
		return obsPerformerId;
	}
	public void setObsPerformerId(String obsPerformerId) {
		this.obsPerformerId = obsPerformerId;
	}
	public String getObsValue() {
		return obsValue;
	}
	public void setObsValue(String obsValue) {
		this.obsValue = obsValue;
	}
	public Date getObsCreated() {
		return obsCreated;
	}
	public void setObsCreated(Date obsCreated) {
		this.obsCreated = obsCreated;
	}
	public String getSystemUrl() {
		return systemUrl;
	}
	public void setSystemUrl(String systemUrl) {
		this.systemUrl = systemUrl;
	}
	public String getSystemCode() {
		return systemCode;
	}
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}
	public String getSystemDisplay() {
		return systemDisplay;
	}
	public void setSystemDisplay(String systemDisplay) {
		this.systemDisplay = systemDisplay;
	}

	
	
}
