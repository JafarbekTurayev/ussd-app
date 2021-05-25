package ecma.ai.ussdapp.entity;

import ecma.ai.ussdapp.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.annotation.security.DenyAll;
import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Filial extends AbsEntity {

    private String name;

    //user
    @OneToOne
    private Staff director;

    //staffs xodimlar ro'yxati
    @OneToMany(mappedBy = "filial", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Staff> staffList;

}
