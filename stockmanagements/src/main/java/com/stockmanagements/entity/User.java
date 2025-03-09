package com.stockmanagements.entity;


import com.stockmanagements.enums.JacquardType;
import com.stockmanagements.enums.MachineType;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "usersss")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;

    private String userMobileNo;


    private String userGmailId;

    private String userAddress;


    @Enumerated(EnumType.STRING)
    private MachineType userMachineType;

    @NotNull
    @Enumerated(EnumType.STRING)
    private JacquardType userJacquardType;

    private Integer userJacquardChowkNo;


    // Getters and setters


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobileNo() {
        return userMobileNo;
    }

    public void setUserMobileNo(String userMobileNo) {
        this.userMobileNo = userMobileNo;
    }

    public String getUserGmailId() {
        return userGmailId;
    }

    public void setUserGmailId(String userGmailId) {
        this.userGmailId = userGmailId;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public MachineType getUserMachineType() {
        return userMachineType;
    }

    public void setUserMachineType(MachineType userMachineType) {
        this.userMachineType = userMachineType;
    }

    public JacquardType getUserJacquardType() {
        return userJacquardType;
    }

    public void setUserJacquardType(JacquardType userJacquardType) {
        this.userJacquardType = userJacquardType;
    }

    public Integer getUserJacquardChowkNo() {
        return userJacquardChowkNo;
    }

    public void setUserJacquardChowkNo(Integer userJacquardChowkNo) {
        this.userJacquardChowkNo = userJacquardChowkNo;
    }
}
