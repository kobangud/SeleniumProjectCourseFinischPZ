package ru.ibs.appline.three_project;


import org.junit.jupiter.api.Test;

public class OneTest extends BaseTests{


    @Test
    public void trips() throws InterruptedException {
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
                .selectCheckBoxTask("Заказ билетов")
                .fillField("Город выбытия", "Москва")
                .fillField("Город прибытия", "Тула")
                .fillField("Планируемая дата выезда", "20.04.2023")
                .fillField("Планируемая дата возвращения", "30.05.2023")
                .clickBtnSaveClose()
                .checkErrorMessageAlert("Список командируемых сотрудников не может быть пустым");

        Thread.sleep(10000);

    }

}
