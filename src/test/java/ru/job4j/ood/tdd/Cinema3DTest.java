package ru.job4j.ood.tdd;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.Calendar;
import java.util.List;


@Disabled("Тесты отключены. Удалить аннотацию после реализации всех методов по заданию.")
class Cinema3DTest {

    @Test
    public void whenBuyThenGetTicket() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket).isEqualTo(new Ticket3D());
    }

    @Test
    public void whenAddSessionThenItExistsBetweenAllSessions() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        List<Session> sessions = cinema.find(session1 -> true);
        assertThat(sessions).contains(session);

    }

    @Test
    public void whenBuyOnInvalidRowThenGetException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        assertThatThrownBy(() -> cinema.buy(account, -1, 1, date))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenBuyInvalidColumnThenGetException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        assertThatThrownBy(() -> cinema.buy(account, 1, 0, date))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenAccountIsNull() {
        Calendar calendar = Calendar.getInstance();
        Cinema cinema = new Cinema3D();
        assertThatThrownBy(() -> cinema.buy(null, 1, 1, calendar))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void whenMistakeDate() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        assertThatThrownBy(() -> cinema.buy(account, 1, 1, null))
                .isInstanceOf(NullPointerException.class);
    }

}