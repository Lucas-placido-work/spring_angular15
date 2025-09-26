@Service
@RequiredArgsConstructor
public class PedidoService {

  @Autowired
  private PedidoRepository pedidoRepository;

  private NotificacaoService notificacaoService;

  // Valida o pedido e pode ser expandido conforme necessário
  private void validarPedido(PedidoDTO dto) {
    if (dto.getValor() <= 0) {
      throw new IllegalArgumentException("Valor inválido");
    }
  }
  
  // Mapeia o DTO para a entidade Pedido e também pode ser expnadido conforme necessário
  public mapDtoToEntity(PedidoDTO dto) {
    Pedido pedido = new Pedido();
    pedido.setClienteId(dto.getClienteId());
    pedido.setValor(dto.getValor());
    pedido.setDataCriacao(LocalDateTime.now());
    return pedido;
  }

  public void criarPedido(PedidoDTO dto) {

    validarPedido(dto);

    Pedido pedido = mapDtoToEntity(dto);

    pedidoRepository.save(pedido); // se tudo tiver certo, salva o pedido no banco
  
    notificacaoService.enviarEmail(dto.getClienteId(), "Pedido criado!");
  }
}