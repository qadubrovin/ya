package ru.yandex.tests;

import ru.yandex.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.pages.YaJobsPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class YandexTests extends TestBase {

    YaJobsPage jobs = new YaJobsPage();

    String expectedTitle = "Работа в Яндексе",
           vacancies = "Вакансии",
            errorText = "SEVERE";

    @Test
    @Description("Check that ya.ru available")
    @DisplayName("Ya.ru is available")
    void siteAvailable() {
        step("Open 'https://ya.ru', check that its available", () -> {
            jobs.openYaJobs();
        });
    }

    @Test
    @Description("Checking that title have needful text ")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open 'https://ya.ru'", () -> {
            jobs.openYaJobs();
        });

        step("Page title should have text 'Работа в Яндексе'", () -> {
            String actualTitle = title();
            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Description("Go to vacancies is work")
    @DisplayName("Go to vacancies is work")
    void goToVacancies() {
        step("Open 'https://ya.ru'", () -> {
            jobs.openYaJobs();
        });

        step("Check that button 'Vacancies is available and click on it'", () -> {
            jobs.toVacanciesButton.shouldHave(text(vacancies));
            jobs.toVacanciesButton.click();
        });

        step("Check that vacancy section is available", () -> {
            jobs.vacanciesPageHeader.shouldBe(visible);;
        });
    }

}