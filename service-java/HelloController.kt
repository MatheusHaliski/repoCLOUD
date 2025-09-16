package cloudcomputing.service_java

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class HelloController(
    private val textoRepository: TextoRepository
) {
    @GetMapping("/hello")
    fun hello(): String {
        return "Servidor rodando com sucesso 🚀"
    }

    // POST com JSON para salvar no banco
    @PostMapping("/echo")
    fun echo(@RequestBody body: Map<String, Any>): Texto {
        val conteudo = body["conteudo"]?.toString() ?: "vazio"

        val novoTexto = Texto(conteudo = conteudo)
        val salvo = textoRepository.save(novoTexto)

        return novoTexto
    }

    // GET com parâmetro
    @GetMapping("/soma")
    fun soma(@RequestParam a: Int, @RequestParam b: Int): Map<String, Int> {
        return mapOf("resultado" to (a + b))
    }
}
