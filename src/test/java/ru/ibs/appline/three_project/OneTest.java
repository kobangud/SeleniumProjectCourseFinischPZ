package ru.ibs.appline.three_project;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.ibs.appline.framework.three_project.pages.utils.AllureListener;

@ExtendWith(AllureListener.class)
@DisplayName(value = "Сценарий для Allure репорта")

public class OneTest extends BaseTests{

    @Test
    @DisplayName(value = "Командировки")
    public void tripsTest() throws InterruptedException {
        pageManager.getLoadingOpenPage()
                .loadingLoginForm()
                .loginForm()
                .inputBtn()
                .checkOpenHomePage()
                .selectBaseMenuByText("Расходы")
                .selectSubMenuByText("Командировки")
                .checkOpenTravelPage()
                .selectPulMenuByText("Создать командировку")
                .checkOpenTravelSubPage()
                .selectCreateTravelPage("подразделение")
                .selectListSubdivisionByText("Отдел")
                .openListOrganization()
                .openListSelectOrganization()
                .selectOrganization("Хром")
                .selectCheckBoxTask("Заказ билетов1")   //файлится для скрина
                .fillField("Город выбытия", "Москва")
                .fillField("Город прибытия", "Тула")
                .fillField("Планируемая дата выезда", "20.04.2023")
                .fillField("Планируемая дата возвращения", "30.05.2023")
                .clickBtnSaveClose()
                .checkErrorMessageAlert("Список командируемых сотрудников не может быть пустым");

        Thread.sleep(10000);

    }

}
