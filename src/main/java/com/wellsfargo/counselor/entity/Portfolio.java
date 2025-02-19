package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    @ManyToOne
    @JoinColumn(name = "clientId", nullable = false)
    private Client client;

    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Security> securities;

    public Portfolio() {}

    public Portfolio(Client client, Date creationDate) {
        this.client = client;
        this.creationDate = creationDate;
    }

    public Long getPortfolioId() { return portfolioId; }
    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
    public Date getCreationDate() { return creationDate; }
    public void setCreationDate(Date creationDate) { this.creationDate = creationDate; }
}
