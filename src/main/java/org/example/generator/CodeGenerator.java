package org.example.generator;

import org.example.generator.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeGenerator {
    public void generate(String dslTest) throws Exception {
        List<Entity> entities = new ArrayList<>();
        List<Validation> validations = new ArrayList<>();
        List<Controller> controllers = new ArrayList<>();
        Datasource datasource = null;

        // Extract entities
        Pattern entityPattern = Pattern.compile("ENTITY\\s+(\\w+)\\s*\\{([^}]*)\\}");
        Pattern attributePattern = Pattern.compile("(\\w+)\\s+AS\\s+(\\w+)");

        Matcher entityMatcher = entityPattern.matcher(dslTest);
        while (entityMatcher.find()) {
            String entityName = entityMatcher.group(1);
            String attributesBlock = entityMatcher.group(2);
            List<Attribute> attributes = new ArrayList<>();

            Matcher attributeMatcher = attributePattern.matcher(attributesBlock);
            while (attributeMatcher.find()) {
                attributes.add(new Attribute(attributeMatcher.group(1), attributeMatcher.group(2)));
            }

            entities.add(new Entity(entityName, attributes));
        }

        // Extract Validation
        Pattern validationPattern = Pattern.compile("VALIDATIONS\\s+FOR\\s+(\\w+)\\s*\\{([^}]*)\\}");
        Pattern rulePattern = Pattern.compile("(\\w+)\\s+IS\\s+((?:NOT\\s+)?(?:NULL|EMPTY|UNIQUE|GREATER_THAN|LESS_THAN|EQUALS_TO\\s+\\d+))");

        Matcher validationMatcher = validationPattern.matcher(dslTest);
        while (validationMatcher.find()) {
            String entityName = validationMatcher.group(1);
            String rulesBlock = validationMatcher.group(2);
            List<ValidationRule> rules = new ArrayList<>();

            Matcher ruleMatcher = rulePattern.matcher(rulesBlock);
            while (ruleMatcher.find()) {
                rules.add(new ValidationRule(ruleMatcher.group(1), ruleMatcher.group(2)));
            }

            validations.add(new Validation(entityName, rules));
        }

        // Extract COntrollers
        Pattern controllerPattern = Pattern.compile("CONTROLLER\\s+FOR\\s+(\\w+)\\s*\\{([^}]*)\\}");
        Pattern actionPattern = Pattern.compile("(GET_ALL|GET_BY_ID|UPDATE|SAVE|DELETE|GET_BY\\s+\\w+(?:\\s+AND\\s+\\w+)*)");

        Matcher controllerMatcher = controllerPattern.matcher(dslTest);
        while (controllerMatcher.find()) {
            String entityName = controllerMatcher.group(1);
            String actionsBlock = controllerMatcher.group(2);
            List<String> actions = new ArrayList<>();

            Matcher actionMatcher = actionPattern.matcher(actionsBlock);
            while (actionMatcher.find()) {
                actions.add(actionMatcher.group(1));
            }

            controllers.add(new Controller(entityName, actions));
        }

        // Extract Datasource
        Pattern datasourcePattern = Pattern.compile("DATASOURCE\\s*\\{([^}]*)\\}");
        Pattern configPattern = Pattern.compile("(DBMS|IP|DATABASE|USERNAME|PASSWORD)\\s+IS\\s+(\"[^\"]+\"|\\w+)");

        Matcher datasourceMatcher = datasourcePattern.matcher(dslTest);
        if (datasourceMatcher.find()) {
            String datasourceConfig = datasourceMatcher.group(1);
            Map<String, String> config = new HashMap<>();

            Matcher configMatcher = configPattern.matcher(datasourceConfig);
            while (configMatcher.find()) {
                config.put(configMatcher.group(1), configMatcher.group(2).replace("\"", ""));
            }

            datasource = new Datasource(
                    config.get("DBMS"),
                    config.get("IP"),
                    config.get("DATABASE"),
                    config.get("USERNAME"),
                    config.get("PASSWORD")
            );
        }

        // Show results
        System.out.println("\n Entidades:");
        entities.forEach(System.out::println);

        System.out.println("\n Validaciones:");
        validations.forEach(System.out::println);

        System.out.println("\n Controladores:");
        controllers.forEach(System.out::println);

        System.out.println("\n Datasource:");
        System.out.println(datasource);

        CommandLoader commandLoader = new CommandLoader();
        commandLoader.createProject("xd");
    }
}
