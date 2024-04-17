package Lab24.hammaslaakari;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import Lab24.hammaslaakari.model.Tooth;
import Lab24.hammaslaakari.model.ToothRepository;

public class JpaTest {

    @Autowired
    ToothRepository toothRepository;

    @Test
    public void teethInDbIs12() {
        Optional<Tooth> rightUp1 = toothRepository.findById(1L);
        // assertThat(rightUp1.getToothname().equalsIgnoreCase("rightUp1"));
    }
}
