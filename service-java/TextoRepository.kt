package cloudcomputing.service_java


import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TextoRepository : JpaRepository<Texto, Long>
