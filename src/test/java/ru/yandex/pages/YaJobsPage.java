package ru.yandex.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class YaJobsPage {
    //selectors
    public SelenideElement toVacanciesButton = $x("//*[@class='button_white-button']"),
            vacanciesPageHeader = $x("//*[@id ='jobs-obertka-spiska-vakansij-1']//*[@class='lc-jobs-filters-wrapper__vacancies']//*[contains(text(),'Вакансии')]"),
            jobsHeader = $x("//h1");

    //methods
    public void openYaJobs() {
        open("https://yandex.ru/jobs");
        $x("//h1").shouldHave(text("Создавайте с нами сервисы, которыми пользуются миллионы"));
    }

}
