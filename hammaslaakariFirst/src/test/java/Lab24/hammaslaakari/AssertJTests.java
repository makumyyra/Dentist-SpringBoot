package Lab24.hammaslaakari;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.AbstractIterableAssert;
import org.assertj.core.api.ListAssert;
import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import Lab24.hammaslaakari.model.Tooth;
import Lab24.hammaslaakari.model.ToothRepository;

public class AssertJTests {
    @Autowired
    ToothRepository toothRepository;

    @Test
    public void testTeeth() {

        List<Tooth> teeth = (List<Tooth>) toothRepository.findAll();

        assertThat(
                ((AbstractIterableAssert<ListAssert<Tooth>, List<? extends Tooth>, Tooth, ObjectAssert<Tooth>>) toothRepository
                        .findAll()).hasSize(12));

        assertThat(teeth).isNotNull();

    }

}
