package com.dentist.ProjectDentist;

import com.dentist.ProjectDentist.Service.DentistService;
import com.dentist.ProjectDentist.entity.Dentist;
import com.dentist.ProjectDentist.exceptions.BadRequestException;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class DentistServiceTest {

    @Autowired
    private DentistService dentistService;

    public void loadingData() throws BadRequestException{
        this.dentistService.registerDentist(new Dentist("paula", "hernandez", "123"));
    }

    @Test
    public void dentistTestAdd() throws BadRequestException{
        this.loadingData();
        Dentist dentist = dentistService.registerDentist(new Dentist("camila","cruz","456"));

        Assert.assertTrue(dentist.getId() != null);
    }
}
