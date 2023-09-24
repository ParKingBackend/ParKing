package com.example.clientservice.model;

import jakarta.persistence.*;

import java.util.Date;

import com.example.clientservice.model.Client;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Table(name = "premium_subscriptions")
public class PremiumSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id") // Links the premium subscription to a client
    private Client client;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "price")
    private double price;

    @Column(name = "benefits")
    private String benefits;

    public PremiumSubscription() {
    }

    public PremiumSubscription(Client client, Date startDate, Date endDate, double price, String benefits) {
        this.client = client;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.benefits = benefits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    @Override
    public String toString() {
        return "PremiumSubscription{" +
                "id=" + id +
                ", client=" + client +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                ", benefits='" + benefits + '\'' +
                '}';
    }
}
