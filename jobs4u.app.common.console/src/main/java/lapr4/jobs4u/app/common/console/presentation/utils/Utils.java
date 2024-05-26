package lapr4.jobs4u.app.common.console.presentation.utils;

import eapli.framework.io.util.Console;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

public class Utils {

    static public Calendar readDateFromConsole(String prompt, String dateFormat, String regex) {
        String errorMessage = "Invalid date format. Please enter date in " + dateFormat + " format.";
        Pattern pattern = Pattern.compile(regex);
        while (true) {
            try {
                String strDate = Console.readLine(prompt);
                if (!pattern.matcher(strDate).matches()) {
                    throw new Exception(errorMessage);
                }
                SimpleDateFormat df = new SimpleDateFormat(dateFormat);
                Date date = df.parse(strDate);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                return calendar;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

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

    static public String getPath(boolean isDirectory) {
        try {
            // Set system look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int selectionMode = isDirectory ? JFileChooser.DIRECTORIES_ONLY : JFileChooser.FILES_ONLY;
        chooser.setFileSelectionMode(selectionMode);
        JDialog dialog = new JDialog();
        dialog.setIconImage(null); // Remove application icon
        int returnVal = chooser.showOpenDialog(dialog);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            Path currentPath = Paths.get(System.getProperty("user.dir"));
            Path absolutePath = Paths.get(chooser.getSelectedFile().getAbsolutePath());
            Path relativePath = currentPath.relativize(absolutePath);
            String relativePathStr = relativePath.toString();
            return relativePathStr.replace("\\", "/");
        }

        return null;
    }

    static public Boolean copyFile(String source, String destination) {
        try {
            File sourceFile = new File(source);
            File destinationFile = new File(destination);
            java.nio.file.Files.copy(sourceFile.toPath(), destinationFile.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e) {
            System.out.println("Error copying file");
            return false;
        }
    }
}