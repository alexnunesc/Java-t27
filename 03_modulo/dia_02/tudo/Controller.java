@Controller
public class RegistrationController {
  private RegistrationService service;

  @Autowired
  public RegistrationController(RegistrationService service) {
    this.service = service;
  }

  // implementações específicas de controller (que vão utilizar 'service')
}