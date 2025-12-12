package ua.transport.dal;

import ua.transport.dal.entity.Route;
import ua.transport.dal.entity.TransportUnit;
import ua.transport.dal.uow.UnitOfWork;
import ua.transport.dal.uow.UnitOfWorkImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Запуск програми...");

        try (UnitOfWork uow = new UnitOfWorkImpl()) {

            // Створення даних
            System.out.println("\n=== Створення даних ===");

            Route route16 = new Route("16", "Вокзал - Майдан Незалежності");

            TransportUnit bus1 = new TransportUnit("AA 1111 AA", "Автобус");
            bus1.addRoute(route16);

            TransportUnit bus2 = new TransportUnit("BB 2222 BB", "Автобус");
            bus2.addRoute(route16);

            uow.getRouteRepository().create(route16);

            uow.commit();
            System.out.println("Дані успішно збережено в базу даних!");

            System.out.println("\n=== Читання даних з БД ===");

            Route foundRoute = uow.getRouteRepository().findByNumber("16");

            if (foundRoute != null) {
                System.out.println("Знайдено маршрут: " + foundRoute.getDescription());
                System.out.println("Транспорт на лінії:");

                for (TransportUnit t : foundRoute.getTransportUnits()) {
                    System.out.println(" - " + t.getType() + " [" + t.getLicensePlate() + "]");
                }
            } else {
                System.out.println("Маршрут не знайдено!");
            }
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}