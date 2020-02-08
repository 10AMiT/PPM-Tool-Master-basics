package io.algostack.ppmtool.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Project Name is Mandatory")
    private String projectName;

    @NotBlank(message = "Project Identifier is Mandatory")
    @Size(min = 4,max = 5,message = "Project Identifier must have 4 to 5 character")
    @Column(updatable = false, unique = true)
    private String projectIdentifier;

    @NotBlank(message = "Project Description is required")
    private String description;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date start_date;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private  Date end_date;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date created_at;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date update_at;

    public Project() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }

    @PrePersist
    protected void onCreate () {
        this.created_at = new Date();
    }

    @PreUpdate
    protected  void onUpdate () {
        this.update_at = new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return id == project.id &&
                Objects.equals(projectName, project.projectName) &&
                Objects.equals(projectIdentifier, project.projectIdentifier) &&
                Objects.equals(description, project.description) &&
                Objects.equals(start_date, project.start_date) &&
                Objects.equals(end_date, project.end_date) &&
                Objects.equals(created_at, project.created_at) &&
                Objects.equals(update_at, project.update_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectName, projectIdentifier, description, start_date, end_date, created_at, update_at);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", projectIdentifier='" + projectIdentifier + '\'' +
                ", description='" + description + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", created_at=" + created_at +
                ", update_at=" + update_at +
                '}';
    }
}
