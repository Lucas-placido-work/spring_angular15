@RestController
@RequestMapping("/pedidos")
public class PedidoController {

  @Autowired
  private PedidoService pedidoService;
  
  //Removido a lógica de negócio para o service, deixando apenas a responsabilidade de receber a requisição e enviar a resposta
  @PostMapping
  public ResponseEntity<String> criarPedido(@RequestBody PedidoDTO dto) {
    try {
        pedidoService.criarPedido(dto);
        return ResponseEntity.ok("Pedido criado com sucesso");
    } catch (IllegalArgumentException e) {
        return ResponseEntity.badRequest().body("Algo de errado aconteceu: " + e.getMessage());
    }
  }
}