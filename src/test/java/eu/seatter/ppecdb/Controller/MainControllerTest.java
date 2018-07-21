//package eu.seatter.ppecdb.Controller;
//
//import eu.seatter.ppecdb.Model.VAPILastTemp;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.Collections;
//
//import static org.mockito.BDDMockito.given;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(MainController.class)
//public class MainControllerTest {
//    @Autowired MockMvc mvc;
//
//    @MockBean MainController mainController;
//
//    @Test
//    public void getLastTemperature() throws Exception {
//        VAPILastTemp vapiLastTemp = new VAPILastTemp();
//        vapiLastTemp.setTemperature(100f);
//
//        Iterable<VAPILastTemp> lastTemp = Collections.singletonList(vapiLastTemp);
//
//        given(mainController.getLastTemperature()).willReturn(lastTemp);
//
//        // TODO mvc.perform(get());
//
//    }
//}
