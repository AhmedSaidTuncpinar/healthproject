package pojos;

public class AppointmentResponsePatientPojo {

    private String createdBy;
    private String createdDate;
    private int id;
    private String firstName;
    private String lastName;
    private Object birthDate;
    private String phone;
    private Object gender;
    private Object bloodGroup;
    private Object adress;
    private String email;
    private Object description;
    private AppointmentResponseUserPojo user;
    private Object inPatients;
    private Object country;
    private Object cstate;

    public AppointmentResponsePatientPojo(String createdBy, String createdDate, int id, String firstName, String lastName, Object birthDate, String phone, Object gender, Object bloodGroup, Object adress, String email, Object description, AppointmentResponseUserPojo user, Object inPatients, Object country, Object cstate) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.adress = adress;
        this.email = email;
        this.description = description;
        this.user = user;
        this.inPatients = inPatients;
        this.country = country;
        this.cstate = cstate;
    }

    public AppointmentResponsePatientPojo() {
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Object getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Object birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public Object getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(Object bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Object getAdress() {
        return adress;
    }

    public void setAdress(Object adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public AppointmentResponseUserPojo getUser() {
        return user;
    }

    public void setUser(AppointmentResponseUserPojo user) {
        this.user = user;
    }

    public Object getInPatients() {
        return inPatients;
    }

    public void setInPatients(Object inPatients) {
        this.inPatients = inPatients;
    }

    public Object getCountry() {
        return country;
    }

    public void setCountry(Object country) {
        this.country = country;
    }

    public Object getCstate() {
        return cstate;
    }

    public void setCstate(Object cstate) {
        this.cstate = cstate;
    }

    @Override
    public String toString() {
        return "AppointmentResponsePatientPojo{" +
                "createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                ", bloodGroup=" + bloodGroup +
                ", adress=" + adress +
                ", email='" + email + '\'' +
                ", description=" + description +
                ", user=" + user +
                ", inPatients=" + inPatients +
                ", country=" + country +
                ", cstate=" + cstate +
                '}';
    }
}
/*
Response body:
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

