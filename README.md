# 📌 Diagrama de Entidade e Relacionamento (DER) - CRM Imobiliário  

```mermaid
erDiagram
    LEAD {
        UUID ID
        string Nome
        string Email
        string Telefone
        string Origem
        string Status
        datetime Created_at
    }

    USUARIO {
        UUID ID
        string Nome
        string Email
        string Senha
        string Perfil
    }

    APARTAMENTO {
        UUID ID
        int Numero
        float Area
        float Preco
    }

    EMPREENDIMENTO {
        UUID ID
        string Nome
        string Localizacao
    }

    CONTRATO {
        UUID ID
        date Data
        float Valor
    }

    LEAD ||--o{ USUARIO : "Responsável"
    LEAD ||--o{ CONTRATO : "Pode Fechar"
    CONTRATO ||--|| APARTAMENTO : "Refere-se a"
    EMPREENDIMENTO ||--o{ APARTAMENTO : "Contém"
    LEAD ||--o{ APARTAMENTO : "Interessado em"
    LEAD ||--o{ EMPREENDIMENTO : "Interessado em"
