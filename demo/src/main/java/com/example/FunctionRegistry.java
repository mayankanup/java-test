import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class FunctionRegistry {

    public static void main(String[] args) {

        ToolRegistry registry = new ToolRegistry();

        registry.register(new HelloTool());
        registry.register(new AddTool());
        registry.register(new JokeTool());

        registry.printCommands();

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("\n> ");
            String line = scanner.nextLine().trim();

            if (line.equalsIgnoreCase("exit")) {
                break;
            }

            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");

            String command = parts[0];
            String[] arguments = new String[parts.length - 1];

            System.arraycopy(parts, 1, arguments, 0, arguments.length);

            registry.execute(command, arguments);
        }

        scanner.close();
    }
}

public class ToolRegistry {

    private final Map<String, Tool> tools = new HashMap<>();

    public void register(Tool tool) {
        tools.put(tool.getName().toLowerCase(), tool);
    }

    public void execute(String command, String[] args) {

        Tool tool = tools.get(command.toLowerCase());

        if (tool == null) {
            System.out.println("Unknown command: " + command);
            return;
        }

        tool.execute(args);
    }

    public void printCommands() {
        System.out.println("Available commands:");

        tools.values().forEach(t ->
                System.out.printf("- %-10s : %s%n",
                        t.getName(),
                        t.getDescription()));
    }
}

public class JokeTool implements Tool {

    @Override
    public String getName() {
        return "joke";
    }

    @Override
    public String getDescription() {
        return "Tells a joke";
    }

    @Override
    public void execute(String[] args) {
        System.out.println("Why do Java developers wear glasses?");
        System.out.println("Because they don't C#.");
    }
}

public class AddTool implements Tool {

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getDescription() {
        return "Adds two numbers";
    }

    @Override
    public void execute(String[] args) {

        if (args.length != 2) {
            System.out.println("Usage: add <num1> <num2>");
            return;
        }

        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);

            System.out.println("Sum = " + (a + b));
        } catch (NumberFormatException e) {
            System.out.println("Arguments must be integers.");
        }
    }
}

public class HelloTool implements Tool {

    @Override
    public String getName() {
        return "hello";
    }

    @Override
    public String getDescription() {
        return "Greets the user";
    }

    @Override
    public void execute(String[] args) {
        System.out.println("Hello! Welcome to the Java demo.");
    }
}

public interface Tool {
    String getName();
    String getDescription();
    void execute(String[] args);
}
