package ru.ibs.appline.three_project;


import org.junit.jupiter.api.Test;
import ru.ibs.appline.framework.three_project.pages.BaseMenuPage;
import ru.ibs.appline.framework.three_project.pages.InsuranceOpenPage;
import ru.ibs.appline.framework.three_project.pages.LogPage;
import ru.ibs.appline.framework.three_project.pages.SelectCreateTravelPage;

public class OneTest extends BaseTests{

    LogPage logPage = new LogPage();
    InsuranceOpenPage insuranceOpenPage = new InsuranceOpenPage();
    BaseMenuPage baseMenuPage = new BaseMenuPage();
    SelectCreateTravelPage selectCreateTravelPage = new SelectCreateTravelPage();

    @Test
    public void trips() throws InterruptedException {
        logPage.loginForm();
        insuranceOpenPage.checkOpenHomePage();
        baseMenuPage.selectBaseMenuByText("Расходы");
        baseMenuPage.selectSubMenuByText("Командировки");
        insuranceOpenPage.loding();
        insuranceOpenPage.checkOpenTravelPage();
        baseMenuPage.selectPulMenuByText("Создать командировку");
        insuranceOpenPage.loding();
        insuranceOpenPage.checkOpenTravelSubPage();//провалились в Командировки / Создать командировку
        selectCreateTravelPage.selectCreateTravelPage("подразделение");
        selectCreateTravelPage.selectListSubdivisionByText("Отдел");
        selectCreateTravelPage.openListOrganization();
        selectCreateTravelPage.openListSelectOrganization();
        selectCreateTravelPage.selectOrganization("Хром");
        selectCreateTravelPage.selectCheckBoxTask("Заказ билетов");
        selectCreateTravelPage.fillField("Город выбытия", "Москва");
        selectCreateTravelPage.fillField("Город прибытия", "Тула");
        selectCreateTravelPage.fillField("Планируемая дата выезда", "20.04.2023");
        selectCreateTravelPage.fillField("Планируемая дата возвращения", "30.05.2023");
        selectCreateTravelPage.clickBtnSaveClose();
        insuranceOpenPage.loding();
        selectCreateTravelPage.checkErrorMessageAlert("Список командируемых сотрудников не может быть пустым");
        Thread.sleep(5000);

    }

}
