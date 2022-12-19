package com.example.selenide_task12;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class GitHubTest extends TestBase{
  @Test
  void gitHubSolutionsTest(){
    step("Открывыаем страницу", () ->{
      open("https://github.com/");});
    step("Наводим мышкой на меню Solution", () ->{
      $x("//button[contains(text(),'Solutions')]").hover();});
    step("Кликаем на Enterprise в выподающем списке", () ->{
      $$x("//li[text()='For']//following::a[contains(text(),'Enterprise')]").get(0).shouldBe(Condition.visible).click();});
    step("Проверяем заголовок", () ->{
      $$x("//h1[text()='Build like the best']").get(0).shouldBe(Condition.visible);});

  }
}
