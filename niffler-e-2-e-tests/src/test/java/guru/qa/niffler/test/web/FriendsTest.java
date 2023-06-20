package guru.qa.niffler.test.web;

import com.codeborne.selenide.Selenide;
import guru.qa.niffler.jupiter.annotation.ApiLogin;
import guru.qa.niffler.jupiter.annotation.Friends;
import guru.qa.niffler.jupiter.annotation.GenerateUser;
import guru.qa.niffler.jupiter.annotation.User;
import guru.qa.niffler.model.rest.UserJson;
import guru.qa.niffler.page.MainPage;
import io.qameta.allure.AllureId;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Epic("[WEB][niffler-frontend]: Друзья")
@DisplayName("[WEB][niffler-frontend]: Друзья")
public class FriendsTest extends BaseWebTest {

    @Test
    @AllureId("500018")
    @DisplayName("WEB: Пользователь должен видеть список своих друзей")
    @Tag("WEB")
    @ApiLogin(nifflerUser = @GenerateUser(friends = @Friends(count = 2)))
    void shouldViewExistingFriendsInTable(@User UserJson user) {
        Selenide.open(MainPage.URL, MainPage.class)
                .getHeader()
                .toFriendsPage()
                .checkExistingFriendsCount(user.getFriendsJsons().size());
    }
}
