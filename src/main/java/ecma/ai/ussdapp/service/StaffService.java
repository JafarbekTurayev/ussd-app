package ecma.ai.ussdapp.service;

import ecma.ai.ussdapp.payload.ApiResponse;
import ecma.ai.ussdapp.payload.StaffDto;
import ecma.ai.ussdapp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffService {
    @Autowired
    RoleRepository roleRepository;

    public ApiResponse addStaff(StaffDto staffDto) {

        return null;
    }
}
