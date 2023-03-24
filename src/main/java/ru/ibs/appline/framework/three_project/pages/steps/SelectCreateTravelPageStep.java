package ru.ibs.appline.framework.three_project.pages.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.bg.И;
import ru.ibs.appline.framework.three_project.pages.managere.PageManager;

public class SelectCreateTravelPageStep {
    PageManager pageManager = PageManager.getInstance();


    @И("^Выбираем меню подразделений '(.+)'$")
    public void selectCreateTravelPage(String nameMenu) {
        pageManager.getSelectCreateTravelPage().selectCreateTravelPage(nameMenu);
    }


    @И("^Выбираем из списка подразделений '(.+)'$")
    public void selectListSubdivisionByText(String nameMenu) {
        pageManager.getSelectCreateTravelPage().selectListSubdivisionByText(nameMenu);
    }

    @И("^В меню 'Задачи' выбираем опцию '(.+)'$")
    public void selectCheckBoxTask(String nameSubMenu) {
        pageManager.getSelectCreateTravelPage().selectCheckBoxTask(nameSubMenu);
    }

    @И("^Нажимаем - Открыть список$")
    public void openListOrganization() {
        pageManager.getSelectCreateTravelPage().openListOrganization();
    }

    @И("^Раскрываем  список организаций$")
    public void openListSelectOrganization() {
        pageManager.getSelectCreateTravelPage().openListSelectOrganization();
    }

    @И("^Выбираем из списка организацию '(.+)'$")
    public void selectOrganization(String nameSubMenu) {
        pageManager.getSelectCreateTravelPage().selectOrganization(nameSubMenu);
    }

    @И("^Заполняем поле")
    public void fillField(DataTable mapFieldAndValue) {
        mapFieldAndValue.asMap(String.class, String.class)
                .forEach((key, value) ->
                        pageManager.getSelectCreateTravelPage().fillField((String) key, (String) value));
    }

    @И("^Нажимаем на кнопку  - 'Сохранить и закрыть'$")
    public void clickBtnSaveClose() {
        pageManager.getSelectCreateTravelPage().clickBtnSaveClose();
    }

    @И("^Проверяем сообщение о том,  что  - '(.+)'$")
    public void checkErrorMessageAlert(String errMessage) {
        pageManager.getSelectCreateTravelPage().checkErrorMessageAlert(errMessage);
    }
}
