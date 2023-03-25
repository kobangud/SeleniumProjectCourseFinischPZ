package ru.ibs.appline.framework.three_project.pages.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.bg.И;
import ru.ibs.appline.framework.three_project.pages.managere.PageManager;

public class SelectFilterCategoryPageStep {
    PageManager pageManager = PageManager.getInstance();


    @И("^Проверяем,что категория каталога открылась$")
    public void selectFilter() {
        pageManager.getSelectFilter().loadingTitle();
    }

    @И("^Заполняем поле$")
    public void fillField(DataTable mapFieldAndValue) {
        mapFieldAndValue.asMap(String.class, String.class)
                .forEach((key, value) ->
                        pageManager.getSelectFilter().fillField((String) key, (String) value));
    }

    @И("^Выбираем производителя '(.+)'$")
    public void selectCheckBox(String nameSubMenu) {
        pageManager.getSelectFilter().selectCheckBox(nameSubMenu);

    }

    @И("^Прогрузка экрана результатов поиска$")
    public void loadingAfterSelect() {
        pageManager.getSelectFilter().loadingAfterSelect();
    }


    @И("^Проверяем найденное количество загрженных строк поиска по фильтру  на странице внизу страницы '(.+)'$")
    public void findElementQuantity(String count) {
        pageManager.getSelectFilter().findElementQuantity(count);
    }

    @И("^Сохраняем результат поиска  строки (\\d+) в переменную$")
    public void findElement(int num) {
        pageManager.getSelectFilter().findElement(num);
    }

    @И("^Делаем поиск товара через поле Поиска используя сохраненное значение")
    public void fieldFindElement() {
    pageManager.getSelectFilter().fieldFindElement();
    }


    @И("^Сравниваем значение указаное в строке поиска с найденным$")
    public void doubleFindElement() {
        pageManager.getSelectFilter().doubleFindElement();
    }


}
