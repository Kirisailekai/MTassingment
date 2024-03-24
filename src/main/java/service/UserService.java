package service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final DataBootstrap dataBootstrap;

    public UserService(UserRepository userRepository, DataBootstrap dataBootstrap) {
        this.userRepository = userRepository;
        this.dataBootstrap = dataBootstrap;
    }

    public void initializeUsersFromCSV() {
        List<String[]> userData = dataBootstrap.loadDataFromCSV();
        for (String[] userDataItem : userData) {
            User user = new User();
            user.setUsername(userDataItem[0]);
            user.setFullName(userDataItem[1]);
            user.setEmail(userDataItem[2]);
            userRepository.save(user);
        }
    }
}
