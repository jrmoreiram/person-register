package com.junior.personcadastre;

import com.junior.personcadastre.api.controller.PersonController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonControllerTest {

    @Autowired
    private PersonController personController;

    @Test
    public void controllerInitializedCorrectly() {
        assertThat(personController).isNotNull();
    }
}