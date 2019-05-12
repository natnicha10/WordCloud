package wordcloud.wordcloud;

import org.springframework.data.mongodb.core.mapping.Field;

public class beyonce {
	@Field("Id")
	private String id;

	@Field("Created-At")
	private double createdAt;

	@Field("From-User")
	private String fromUser;

	@Field("From-User-Id")
	private String fromUserId;

	@Field("Language")
	private String language;

	@Field("Retweet-Count")
	private int retweetCount;

	@Field("Source")
	private String source;

	@Field("Text")
	private String text;

	@Field("To-User-Id")
	private String toUserId;

	@Field("polarity")
	private String polarity;

	@Field("polarity_confidence")
	private double polarityConfidence;

	@Field("subjectivity")
	private String subjectivity;

	@Field("subjectivity_confidence")
	private double subjectivityConfidence;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(double createdAt) {
		this.createdAt = createdAt;
	}
	
	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public String getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(String fromUserId) {
		this.fromUserId = fromUserId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getRetweetCount() {
		return retweetCount;
	}

	public void setRetweetCount(int retweetCount) {
		this.retweetCount = retweetCount;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}


	public String getText() {
		return text;
	}

	public void setText(String text) { 
		this.text = text;
	}

	public String getToUserId() {
		return toUserId;
	}

	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}

	public String getPolarity() {
		return polarity;
	}

	public void setPolarity(String polarity) {
		this.polarity = polarity;
	}

	public double getPolarityConfidence() {
		return polarityConfidence;
	}

	public void setPolarityConfidence(double polarityConfidence) {
		this.polarityConfidence = polarityConfidence;
	}

	public String getSubjectivity() {
		return subjectivity;
	}

	public void setSubjectivity(String subjectivity) {
		this.subjectivity = subjectivity;
	}

	public double getSubjectivityConfidence() {
		return subjectivityConfidence;
	}

	public void setSubjectivityConfidence(double subjectivityConfidence) {
		this.subjectivityConfidence = subjectivityConfidence;
	}

}