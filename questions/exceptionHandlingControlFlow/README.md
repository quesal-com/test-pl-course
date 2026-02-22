## Background

This question tests students' knowledge of exception handling. An exception hierarchy is provided and students must decide
where to catch what exception based on some given criteria for an implementation. Additionally, students must decide where
to break out of a loop and where to call a method based on the same criteria.

The question is based on `midterm21w2/exceptionsCannotStudy` but has been significantly improved with randomization and multiple 
variants.

## How it works

The file `variants.json` expresses multiple variants of classes for the hierarchy. The keys of each variant object refers
to where the exception would be placed in the hierarchy. For example, `exBottomLeft` refers to the exception placed at the
bottom left of the diagram. Each variant also has a `method` key whose value is the method name that will throw the exception.

Class diagrams are generated based on the variants using the `generate_puml_files.py` script (we use [PlantUML](https://github.com/plantuml/plantuml)). 
These files will be written to `./files/puml/*`. The `.puml` files can then be used to generate class diagram SVGs (use 
SVG and not PNG), for example using the [PlantUML Integration](https://plugins.jetbrains.com/plugin/7017-plantuml-integration) 
IntelliJ plugin. There must be one SVG file for each variant in `clientFilesQuestion` for this question to work.

For the code displayed in this question, we use templates in `./files/*`. These templates are read in `server.py` and 
formatted with variables using `string.format` or `string.format_map`.

The single characters used in the question to refer to blocks of code are randomized between three sequences: A-J, K-S, 1-9. We
decided against fully randomizing these characters because it is much more intuitive for these to be sequential.

## How to improve or extend this question

You can extend this question by adding more variants to `variants.json`.
