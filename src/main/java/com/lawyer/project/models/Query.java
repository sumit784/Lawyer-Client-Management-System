// package com.lawyer.project.models;

// import java.util.Date;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.Table;
// import javax.persistence.Temporal;
// import javax.persistence.TemporalType;
// import javax.validation.constraints.Size;

// @Entity
// @Table(name="cases")
// public class Cases {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String username;
//     private String status;
//     private String description;
//     private String caseType;
//     private Long judge_id;
//     private Long court_id;
//     @Temporal(TemporalType.DATE)
//     Date previousHearingDate;
//     @Temporal(TemporalType.DATE)
//     Date nextHearingDate;
//     @Temporal(TemporalType.DATE)
//     Date judgementDate;

    

//     public Cases (){

//     }

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getUsername() {
//         return username;
//     }

//     public void setUsername(String username) {
//         this.username = username;
//     }

//     public String getStatus() {
//         return status;
//     }

//     public void setStatus(String status) {
//         this.status = status;
//     }

//     public String getDescription() {
//         return description;
//     }

//     public void setDescription(String description) {
//         this.description = description;
//     }

//     public String getCaseType() {
//         return caseType;
//     }

//     public void setCaseType(String caseType) {
//         this.caseType = caseType;
//     }

//     public Long getJudge_id() {
//         return judge_id;
//     }

//     public void setJudge_id(Long judge_id) {
//         this.judge_id = judge_id;
//     }

//     public Long getCourt_id() {
//         return court_id;
//     }

//     public void setCourt_id(Long court_id) {
//         this.court_id = court_id;
//     }

//     public Date getPreviousHearingDate() {
//         return previousHearingDate;
//     }

//     public void setPreviousHearingDate(Date previousHearingDate) {
//         this.previousHearingDate = previousHearingDate;
//     }

//     public Date getNextHearingDate() {
//         return nextHearingDate;
//     }

//     public void setNextHearingDate(Date nextHearingDate) {
//         this.nextHearingDate = nextHearingDate;
//     }

//     public Date getJudgementDate() {
//         return judgementDate;
//     }

//     public void setJudgementDate(Date judgementDate) {
//         this.judgementDate = judgementDate;
//     }

// }