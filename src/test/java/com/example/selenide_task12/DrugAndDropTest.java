package com.example.selenide_task12;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class DrugAndDropTest extends TestBase{
    @Test
    void drugAndDropTest(){
        step("Открывыаем страницу", () ->{
            open("https://the-internet.herokuapp.com/drag_and_drop");});
        step("Перетаскиваем квадрат А на квадрат Б", () ->{
            $("#column-a").dragAndDropTo($("#column-b"));});
        step("Проверяем что квадраты поменялись местами", () ->{
            $("#column-a header").shouldHave(Condition.text("B"));
            $("#column-b header").shouldHave(Condition.text("A"));});
    }
    @Disabled
    @Test
    void drugAndDropActionsTest(){
        step("Открывыаем страницу", () ->{
            open("https://the-internet.herokuapp.com/drag_and_drop");});
        step("Перетаскиваем квадрат А на квадрат Б", () ->{
            actions().
                    clickAndHold($("#column-a")).
                    moveToElement($("#column-b")).
                    release().build().perform();});
        step("Проверяем что квадраты поменялись местами", () ->{
            $("#column-a header").shouldHave(Condition.text("B"));
            $("#column-b header").shouldHave(Condition.text("A"));});
    }
}
