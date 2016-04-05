package com.jiro.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="blog_user")
public class BlogUser {
    
    private long userId;
    private String username;
    private String password;
    private String email;
    private Date lastLogin;
    private String firstName;
    private String middleName;
    private String lastName;
    private Set<BlogPost> blogPosts;
    private Set<BlogComment> blogComments;
    
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    
    @Column(name="username")
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name="password")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="email")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="last_login")
    public Date getLastLogin() {
        return lastLogin;
    }
    public void setLastLogin(Date last_login) {
        this.lastLogin = last_login;
    }

    @Column(name="first_name")
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="middle_name")
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Column(name="last_name")
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "blogUser", fetch = FetchType.LAZY)
    public Set<BlogPost> getBlogPosts() {
        return blogPosts;
    }
    
    public void setBlogPosts(Set<BlogPost> blogPosts) {
        this.blogPosts = blogPosts;
    }
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "blogUser", fetch = FetchType.LAZY)
    public Set<BlogComment> getBlogComments() {
        return blogComments;
    }
    
    public void setBlogComments(Set<BlogComment> blogComments) {
        this.blogComments = blogComments;
    }
        
}
