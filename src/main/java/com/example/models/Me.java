
        package com.example.models;

        import java.io.Serializable;
        import com.fasterxml.jackson.annotation.JsonInclude;
        import com.fasterxml.jackson.annotation.JsonProperty;
        import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "fullName",
        "admissionNumber",
        "id"
})
public class Me implements Serializable
{

    @JsonProperty("fullName")
    private String fullName;
    @JsonProperty("admissionNumber")
    private Integer admissionNumber;
    @JsonProperty("id")
    private Integer id;
    private final static long serialVersionUID = -565863600542889377L;

    @JsonProperty("fullName")
    public String getfullName() {
        return fullName;
    }

    @JsonProperty("fullName")
    public void setfullName(String fullName) {
        this.fullName = fullName;
    }

    @JsonProperty("admissionNumber")
    public Integer getadmissionNumber() {
        return admissionNumber;
    }

    @JsonProperty("admissionNumber")
    public void setadmissionNumber(Integer admissionNumber) {
        this.admissionNumber = admissionNumber;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

}