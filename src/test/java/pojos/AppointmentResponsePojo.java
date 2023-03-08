package pojos;

public class AppointmentResponsePojo {

    private String createdBy;
    private  String createdDate;
    private int id;
    private String startDate;
    private String endDate;
    private String status;
    private Object anamnesis;
    private Object treatment;
    private Object diagnosis;
    private Object prescription;
    private Object description;
    private Object physician;
    private AppointmentResponsePatientPojo patient;
    private Object ctests;

    public AppointmentResponsePojo(String createdBy, String createdDate, int id, String startDate, String endDate, String status, Object anamnesis, Object treatment, Object diagnosis, Object prescription, Object description, Object physician, AppointmentResponsePatientPojo patient, Object ctests) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.anamnesis = anamnesis;
        this.treatment = treatment;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.description = description;
        this.physician = physician;
        this.patient = patient;
        this.ctests = ctests;
    }

    public AppointmentResponsePojo() {
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(Object anamnesis) {
        this.anamnesis = anamnesis;
    }

    public Object getTreatment() {
        return treatment;
    }

    public void setTreatment(Object treatment) {
        this.treatment = treatment;
    }

    public Object getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Object diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Object getPrescription() {
        return prescription;
    }

    public void setPrescription(Object prescription) {
        this.prescription = prescription;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getPhysician() {
        return physician;
    }

    public void setPhysician(Object physician) {
        this.physician = physician;
    }

    public AppointmentResponsePatientPojo getPatient() {
        return patient;
    }

    public void setPatient(AppointmentResponsePatientPojo patient) {
        this.patient = patient;
    }

    public Object getCtests() {
        return ctests;
    }

    public void setCtests(Object ctests) {
        this.ctests = ctests;
    }

    @Override
    public String toString() {
        return "AppointmentResponsePojo{" +
                "createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", id=" + id +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", status='" + status + '\'' +
                ", anamnesis=" + anamnesis +
                ", treatment=" + treatment +
                ", diagnosis=" + diagnosis +
                ", prescription=" + prescription +
                ", description=" + description +
                ", physician=" + physician +
                ", patient=" + patient +
                ", ctests=" + ctests +
                '}';
    }
}
/*
Response Body:
{
    "createdBy": "anonymousUser",
    "createdDate": "2023-02-22T05:40:16.604444Z",
    "id": 3291,
    "startDate": "2024-02-21T00:00:00Z",
    "endDate": "2024-02-21T01:00:00Z",
    "status": "UNAPPROVED",
    "anamnesis": null,
    "treatment": null,
    "diagnosis": null,
    "prescription": null,
    "description": null,
    "physician": null,
    "patient": {
        "createdBy": "patientjohn",
        "createdDate": "2023-02-18T22:36:49.996695Z",
        "id": 1206,
        "firstName": "Patient",
        "lastName": "John",
        "birthDate": null,
        "phone": "444-444-4444",
        "gender": null,
        "bloodGroup": null,
        "adress": null,
        "email": "patientjohn@gmail.com",
        "description": null,
        "user": {
            "createdBy": "anonymousUser",
            "createdDate": "2023-02-18T22:08:37.674114Z",
            "id": 1140,
            "login": "patientjohn",
            "firstName": "Patient",
            "lastName": "John",
            "email": "patientjohn@gmail.com",
            "activated": true,
            "langKey": "en",
            "imageUrl": null,
            "resetDate": null,
            "ssn": "456-58-9637"
        },
        "inPatients": null,
        "country": null,
        "cstate": null
    },
    "ctests": null
}
 */

