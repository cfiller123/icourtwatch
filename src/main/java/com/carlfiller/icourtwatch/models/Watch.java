package com.carlfiller.icourtwatch.models;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Watch {

    private static final String START_DATE_FORMAT_PATTERN = "MM/dd/yyyy";
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT
            = new SimpleDateFormat(START_DATE_FORMAT_PATTERN);

    @Id
    @GeneratedValue
    private int id;

    @NotNull(message = "Please enter a valid date")
    @DateTimeFormat(pattern = START_DATE_FORMAT_PATTERN)
    private Date date;

    @NotNull
    private String defendant;

    private Disposition disposition;

    @Min(1)
    @Max(5)
    private int audability;

    @Min(1)
    @Max(5)
    private int eyeContact;

    @Min(1)
    @Max(5)
    private int explainCharges;

    @Min(1)
    @Max(5)
    private int caseDetails;

    @Min(1)
    @Max(5)
    private int listeningSkills;

    @Min(1)
    @Max(5)
    private int courtProceedings;

    @Min(1)
    @Max(5)
    private int voiceTone;

    @Min(1)
    @Max(5)
    private int timeMgmt;

    private int ownerId;

    @ManyToOne
    private Judge judge;

    public Watch(Date date, String defendant, Disposition disposition, int audability, int eyeContact, int explainCharges, int caseDetails, int listeningSkills, int courtProceedings, int voiceTone, int timeMgmt) {
        this.date = date;
        this.defendant = defendant;
        this.disposition = disposition;
        this.audability = audability;
        this.eyeContact = eyeContact;
        this.explainCharges = explainCharges;
        this.caseDetails = caseDetails;
        this.listeningSkills = listeningSkills;
        this.courtProceedings = courtProceedings;
        this.voiceTone = voiceTone;
        this.timeMgmt = timeMgmt;
    }

    public Watch() {
    }

    public int getId() {
        return id;
    }

    public String getDefendant() {
        return defendant;
    }

    public Disposition getDisposition() {
        return disposition;
    }

    public void setDefendant(String defendant) {
        this.defendant = defendant;
    }

    public void setDisposition(Disposition disposition) {
        this.disposition = disposition;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAudability() {
        return audability;
    }

    public void setAudability(int audability) {
        this.audability = audability;
    }

    public int getEyeContact() {
        return eyeContact;
    }

    public void setEyeContact(int eyeContact) {
        this.eyeContact = eyeContact;
    }

    public int getExplainCharges() {
        return explainCharges;
    }

    public void setExplainCharges(int explainCharges) {
        this.explainCharges = explainCharges;
    }

    public int getCaseDetails() {
        return caseDetails;
    }

    public void setCaseDetails(int caseDetails) {
        this.caseDetails = caseDetails;
    }

    public int getListeningSkills() {
        return listeningSkills;
    }

    public void setListeningSkills(int listeningSkills) {
        this.listeningSkills = listeningSkills;
    }

    public int getCourtProceedings() {
        return courtProceedings;
    }

    public void setCourtProceedings(int courtProceedings) {
        this.courtProceedings = courtProceedings;
    }

    public int getVoiceTone() {
        return voiceTone;
    }

    public void setVoiceTone(int voiceTone) {
        this.voiceTone = voiceTone;
    }

    public int getTimeMgmt() {
        return timeMgmt;
    }

    public void setTimeMgmt(int timeMgmt) {
        this.timeMgmt = timeMgmt;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public Judge getJudge() {
        return judge;
    }

    public void setJudge(Judge judge) {
        this.judge = judge;
    }

    public String getFormattedStartDate() {
        return Watch.SIMPLE_DATE_FORMAT.format(date);
    }
}

