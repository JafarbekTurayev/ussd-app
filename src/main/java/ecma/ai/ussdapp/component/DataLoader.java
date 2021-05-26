package ecma.ai.ussdapp.component;

import ecma.ai.ussdapp.entity.Client;
import ecma.ai.ussdapp.entity.Role;
import ecma.ai.ussdapp.entity.Staff;
import ecma.ai.ussdapp.entity.UssdCode;
import ecma.ai.ussdapp.entity.enums.ClientType;
import ecma.ai.ussdapp.entity.enums.RoleName;
import ecma.ai.ussdapp.repository.ClientRepository;
import ecma.ai.ussdapp.repository.RoleRepository;
import ecma.ai.ussdapp.repository.StaffRepository;
import ecma.ai.ussdapp.repository.USSDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataLoader implements CommandLineRunner {

    @Value("${spring.datasource.initialization-mode}")
    private String initialMode;

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    USSDRepository ussdRepository;

    @Override
    public void run(String... args) throws Exception {
        if (initialMode.equals("always")) {

            Staff director = new Staff();
            director.setUserName("Jafarbek");
            director.setFullName("TJU");
            director.setPosition("BOSS");
            director.setPassword(passwordEncoder.encode("123"));
            director.setEnabled(true); //tizimdan foydalanish

            Set<Role> roles = new HashSet<>(roleRepository.findAll());
            director.setRoles(roles);
            staffRepository.save(director);


            Client client = new Client();
            client.setClientType(ClientType.JISMONIY);
            client.setPassword(passwordEncoder.encode("123"));
            client.setRoles(Collections.singleton(roleRepository.findByRoleName(RoleName.ROLE_CLIENT)));
            client.setFullName("To'rayev Avazbek");
            client.setPassportNumber("AA4444206");

            clientRepository.save(client);


            List<UssdCode> ussdCodes = new ArrayList<>();
            UssdCode hisob = new UssdCode();

            hisob.setCode("*100#");
            hisob.setDescription("O'sha hisobni tekshirish!");

            ussdCodes.add(hisob);

            ussdRepository.saveAll(ussdCodes);

        }
    }
}
