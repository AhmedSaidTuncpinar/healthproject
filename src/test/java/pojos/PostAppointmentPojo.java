package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostAppointmentPojo {

    private String appoSpeciality;
    private String birthDate;
    private String email;
    private String firstName;
    private String gender;
    private String lastName;
    private String phone;
    private String snumber;
    private String ssn;
    private String startDate;

    public PostAppointmentPojo(String appoSpeciality, String birthDate, String email, String firstName, String gender, String lastName, String phone, String snumber, String ssn, String startDate) {
        this.appoSpeciality = appoSpeciality;
        this.birthDate = birthDate;
        this.email = email;
        this.firstName = firstName;
        this.gender = gender;
        this.lastName = lastName;
        this.phone = phone;
        this.snumber = snumber;
        this.ssn = ssn;
        this.startDate = startDate;
    }

    public PostAppointmentPojo() {
    }

    public String getAppoSpeciality() {
        return appoSpeciality;
    }

    public void setAppoSpeciality(String appoSpeciality) {
        this.appoSpeciality = appoSpeciality;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSnumber() {
        return snumber;
    }

    public void setSnumber(String snumber) {
        this.snumber = snumber;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "PostAppointmentPojo{" +
                "appoSpeciality='" + appoSpeciality + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", snumber='" + snumber + '\'' +
                ", ssn='" + ssn + '\'' +
                ", startDate='" + startDate + '\'' +
                '}';
    }


}

/*
Request body:
{
            "appoSpeciality": "string",
            "birthDate": "2023-02-21T16:34:31.108Z",
            "email": "string",
            "firstName": "string",
            "gender": "string",
            "lastName": "string",
            "phone": "string",
            "snumber": "string",
            "ssn": "string",
            "startDate": "2023-02-21"
    }

Response from API:
{
    "createdBy": "anonymousUser",
    "createdDate": "2023-02-22T05:03:02.913489Z",
    "id": 3287,
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
    "ctests": [

    ]
}
 */



















