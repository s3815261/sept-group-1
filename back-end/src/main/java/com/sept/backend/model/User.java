package com.sept.backend.model;


import org.hibernate.annotations.OnDelete;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "users")
//@Inheritance(strategy = InheritanceType.JOINED)
public class User implements UserDetails {
    @Id @GeneratedValue private long id;
    @NotBlank(message = "First Name is required") private String firstName;
    @NotBlank(message = "Last name is required") private String lastName;
    @NotBlank(message = "Email is is required") private String email;
    // blank txt file for now.. have a implement salting method
    @NotBlank(message = "A password is required") private String password;
    // role will most likely a foreign key
    @NotBlank(message = "A role is required") private String role;
    private boolean isAdmin;

    private String healthStatus;

    public User(){

    }

    public User(@NotBlank String firstName, @NotBlank String lastName, @NotBlank String email, @NotBlank String password, @NotBlank String role, @NotBlank Boolean isAdmin) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isAdmin = isAdmin;
    }

    public String getRole() {return role;}

    public void setRole(String role) {
        this.role = role;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {return password; }

    public void setPassword(String password) {this.password = password;}

    public Boolean getIsAdmin() {return isAdmin;}

    public void setIsAdmin(Boolean isAdmin) {this.isAdmin = isAdmin;}

    public void setHealthStatus(String healthStatus) {this.healthStatus = healthStatus;}

    public String getHealthStatus() {return this.healthStatus;}

    @Override
    public String toString() {
        return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,firstName, lastName, email, password, role, isAdmin);
    }

    public Long getId() {
        return id;
    }

    // UserDetails overrides
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
