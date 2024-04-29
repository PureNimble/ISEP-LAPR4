package lapr4.jobs4u.app.common.console.presentation.utils;

import eapli.framework.io.util.Console;
import java.util.List;

public class Utils {

    static public boolean confirm(String message) {
        String input;
        do {
            input = Console.readNonEmptyLine(message + " (S/N): ", "Por favor insira S ou N");
        } while (!input.equalsIgnoreCase("s") && !input.equalsIgnoreCase("n"));

        return input.equalsIgnoreCase("s");
    }

    static public <E> int showAndSelectIndex(List<E> list, String header) {
        showList(list, header);
        return selectsIndex(list);
    }

    static public <E> void showList(List<E> list, String header) {
        System.out.println(header);

        int index = 0;
        for (Object o : list) {
            index++;

            System.out.println(index + ". " + o.toString());
        }
        System.out.println("0. Sair");
    }

    static public <E> int selectsIndex(List<E> list) {
        String input;
        Integer value;
        do {
            input = Console.readNonEmptyLine("Insira uma opção: ", "Por favor insira uma opção válida");
            try {
                value = Integer.valueOf(input);
            } catch (NumberFormatException ex) {
                value = -1;
            }
        } while (value < 0 || value > list.size());

        return value - 1;
    }

    static public <E> Object showAndSelectOne(List<E> list, String header) {
        showList(list, header);
        return selectsObject(list);
    }

    static public <E> Object selectsObject(List<E> list) {
        String input;
        Integer value;
        do {
            input = Console.readNonEmptyLine("Insira uma opção: ", "Por favor insira uma opção válida");
            value = Integer.valueOf(input);
        } while (value < 0 || value > list.size());

        return value == 0 ? null : list.get(value - 1);
    }
}
