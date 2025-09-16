package cloudcomputing.service_java

import jakarta.persistence.*

@Entity
@Table(name = "Textos")
data class Texto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val conteudo: String
)
