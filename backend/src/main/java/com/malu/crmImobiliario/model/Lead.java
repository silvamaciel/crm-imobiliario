package com.malu.crmImobiliario.model;
import java.time.LocalDateTime;
import java.util.UUID;

import com.malu.crmImobiliario.model.enums.LeadStatus;
import com.malu.crmImobiliario.model.enums.OrigemLead;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "lead")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lead {

    @Id
    @GeneratedValue
    private UUID id;

    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String estadoCivil;

   @Column(columnDefinition = "jsonb")
    private String informacoesAdicionais;

    @Column(length = 500)
    private String endereco;

    @Enumerated(EnumType.STRING)
    private LeadStatus status;

    @Enumerated(EnumType.STRING)
    private OrigemLead origem;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
@JoinColumn(name = "empresa_id", nullable = false)
private Empresa empresa;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}