package com.library;

import com.library.catalog.Catalog;
import com.library.factory.UserFactory;
import com.library.model.*;
import com.library.repository.ReservationRepository;
import com.library.service.*;
import com.library.strategy.*;

public class Main {
    public static void main(String[] args) {

        Catalog catalog = new Catalog();

        Member bhanu = (Member) UserFactory.createUser(
                "MEMBER",
                "M101",
                "Bhanu",
                "bhanu@gmail.com"
        );

        Member ravi = (Member) UserFactory.createUser(
                "MEMBER",
                "M102",
                "Ravi",
                "ravi@gmail.com"
        );

        Book cleanCode = new Book(
                "ISBN-001",
                "Clean Code",
                "Robert Martin",
                "Programming"
        );

        catalog.addBook(cleanCode);

        BookItem copy1 =
                new BookItem(
                        "BC101",
                        cleanCode);

        LendingService lendingService =
                new LendingService();

        ReservationRepository reservationRepository =
                new ReservationRepository();

        ReservationService reservationService =
                new ReservationService(
                        reservationRepository);

        LibraryManagementService libraryService =
                new LibraryManagementService(
                        lendingService,
                        reservationService);

        // ==========================
        // Bhanu borrows
        // ==========================

        BookLending lending =
                lendingService.checkout(
                        bhanu,
                        copy1);

        System.out.println(
                "Book borrowed by "
                        + bhanu.getName());

        // ==========================
        // Ravi reserves
        // ==========================

        BookReservation reservation =
                reservationService.reserveBook(
                        ravi,
                        copy1);

        System.out.println(
                "Book reserved by "
                        + ravi.getName());

        // ==========================
        // Bhanu returns
        // ==========================

        libraryService.returnBook(copy1);

        System.out.println(
                "Book returned by "
                        + bhanu.getName());

        // ==========================
        // Fine
        // ==========================

        FineService fineService =
                new FineService(
                        new DailyFineStrategy());

        System.out.println(
                "Fine = ₹"
                        + fineService.calculateFine(4));
    }
}