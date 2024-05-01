package lapr4.jobs4u.app.common.console.presentation.utils;

import eapli.framework.io.util.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Utils {

    static public boolean confirm(String message) {
        String input;
        do {
            input = Console.readNonEmptyLine(message + " (Y/N): ", "Please Insert Y or N");
        } while (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n"));

        return input.equalsIgnoreCase("y");
    }

    static public <E> int showAndSelectIndex(List<E> list, String header) {
        showList(list, header);
        return selectsIndex(list);
    }

    static public <E> void showList(Iterable<E> iterable, String header) {
        System.out.println(header);

        int index = 0;
        for (Object o : iterable) {
            index++;

            System.out.println(index + ". " + o.toString());
        }
        System.out.println("0. Exit");
    }

    static public <E> int selectsIndex(List<E> list) {
        String input;
        Integer value;
        do {
            input = Console.readNonEmptyLine("Insert an option: ", "Pleas insert a valid option");
            try {
                value = Integer.valueOf(input);
            } catch (NumberFormatException ex) {
                value = -1;
            }
        } while (value < 0 || value > list.size());

        return value - 1;
    }

    static public <E> Object showAndSelectOne(Iterable<E> iterable, String header) {
        showList(iterable, header);
        return selectsObject(iterable);
    }

    static public <E> E selectsObject(Iterable<E> iterable) {
        List<E> list = StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
        String input;
        Integer value;
        do {
            input = Console.readNonEmptyLine("Insert an option: ", "Pleas insert a valid option");
            try {
                value = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                System.out.println("Please insert a valid number");
                value = -1;
            }
        } while (value < 0 || value > list.size());

        return value == 0 ? null : list.get(value - 1);
    }
}
