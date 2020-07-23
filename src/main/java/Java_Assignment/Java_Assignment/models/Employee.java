package Java_Assignment.Java_Assignment.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EmployeeInformation")
public class Employee {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        private String designation;

        private String team;

        private Date date_of_joining;

        @Column(unique=true)
        private String email;
        @Column(unique=true)
        private String phone;

        private String reporting_manager;

        private Date create_date;

        private Date update_date;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public String getTeam() {
            return team;
        }

        public void setTeam(String team) {
            this.team = team;
        }

        public Date getDate_of_joining() {
            return date_of_joining;
        }

        public void setDate_of_joining(Date date_of_joining) {
            this.date_of_joining = date_of_joining;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getReporting_manager() {
            return reporting_manager;
        }

        public void setReporting_manager(String reporting_manager) {
            this.reporting_manager = reporting_manager;
        }

        public Date getCreate_date() {
            return create_date;
        }

        public void setCreate_date(Date create_date) {
            this.create_date = create_date;
        }

        public Date getUpdate_date() {
            return update_date;
        }

        public void setUpdate_date(Date update_date) {
            this.update_date = update_date;
        }


}


