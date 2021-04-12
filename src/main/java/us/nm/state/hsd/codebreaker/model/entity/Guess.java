package us.nm.state.hsd.codebreaker.model.entity;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.NonNull;

@Entity
public class Guess {


 @NonNull
 @Id
 @GeneratedValue(generator = "uuid2") 
 @GenericGenerator(name = "uuid2", strategy = "uuid2")
 @Column(name = "guess_id", updatable = false, columnDefinition = "CHAR(16) FOR BIT DATA")
 private UUID id;
  
 @NonNull
 @CreationTimestamp
 @Temporal(TemporalType.TIMESTAMP)
 @Column(nullable = false, updatable = false)
 private Date created;
 
 @NonNull
 @Column(name = "guess_text", nullable = false, updatable = false)
 @NotEmpty
 private String textString;
 
 private int exactMatches;
 
 private int nearMatches;
 
 @NonNull
 @ManyToOne(optional = false, fetch = FetchType.LAZY)
 @JoinColumn(name = "code_id", nullable = false, updatable = false)
 private Code code;

protected String getTextString() {
  return textString;
}

protected void setTextString(String textString) {
  this.textString = textString;
}

protected int getExactMatches() {
  return exactMatches;
}

protected void setExactMatches(int exactMatches) {
  this.exactMatches = exactMatches;
}

protected int getNearMatches() {
  return nearMatches;
}

protected void setNearMatches(int nearMatches) {
  this.nearMatches = nearMatches;
}

protected Code getCode() {
  return code;
}

protected void setCode(Code code) {
  this.code = code;
}

protected UUID getId() {
  return id;
}

protected Date getCreated() {
  return created;
}
 
 
 
}
