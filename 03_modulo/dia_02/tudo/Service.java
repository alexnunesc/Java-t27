@Service
public class RegistrationService {
  private RegistrationRepository repository;

  @Autowired
  public RegistrationService(RegistrationRepository repository) {
    this.repository = repository;
  }

  // implementações específicas de service (que vão utilizar 'repository')
}