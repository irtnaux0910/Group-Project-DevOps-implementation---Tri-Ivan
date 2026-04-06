package com.spring.mvc.jpa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.math.BigDecimal;

@Entity
@Table(name = "Member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @NotBlank(message = "Member Name is required")
    private String memberName;

    @Pattern(regexp = "^\\d{10}$", message = "Telephone must be exactly 10 digits")
    private String telephoneNumber;

    @NotNull(message = "Date of Birth is required")
    @Past(message = "Date of Birth must be a past date")
    private LocalDate dateOfBirth;

    @NotNull(message = "Monthly fee is required")
    @Digits(integer = 3, fraction = 2, message = "Fee must be in format 00.00")
    @Column(precision = 5, scale = 2) 
    private BigDecimal monthlyFee;

    @NotBlank(message = "Please select a status")
    private String paymentStatus;

    public Long getMemberId() { return memberId; }
    public void setMemberId(Long memberId) { this.memberId = memberId; }

    public String getMemberName() { return memberName; }
    public void setMemberName(String memberName) { this.memberName = memberName; }

    public String getTelephoneNumber() { return telephoneNumber; }
    public void setTelephoneNumber(String telephoneNumber) { this.telephoneNumber = telephoneNumber; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public BigDecimal getMonthlyFee() { return monthlyFee; }
    public void setMonthlyFee(BigDecimal monthlyFee) { this.monthlyFee = monthlyFee; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
}