@SpringBootApplication
public class SNP {

    private final UserService userService;

    public SNP(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void initialize() {
        userService.initializeUsersFromCSV();
    }

    public static void main(String[] args) {
        SpringApplication.run(SNP.class, args);
    }
}
