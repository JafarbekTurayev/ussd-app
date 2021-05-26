package ecma.ai.ussdapp.repository;

import ecma.ai.ussdapp.entity.SimCard;
import ecma.ai.ussdapp.entity.UssdCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface USSDRepository extends JpaRepository<UssdCode, UUID> {


}
