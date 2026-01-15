Hey there, thank you for lending your expertise in crafting the unit test. I'm reaching out to seek your assistance in breaking down the method under test into a single slice based on a specific target line aimed at completing a specific subtask. This slicing approach is crucial to streamline the design process for our test cases. When we're designing unit tests, it's essential to focus solely on covering the specific slice.

Below, I'll provide you with all the necessary information for this decomposition process. First, I'll present the basic details about the method under test, including its source code and dependencies (i.e., the methods and fields it invokes). Following that, I'll outline instructions on how to decompose the method into a single slice based on a specific target line corresponding to a specific subtask. Finally, I'll specify the desired format for your output.

### Basic Information of the Method under Test and Its Dependencies
The focal method is `{{ focal_method }}` within the focal class `{{ class_name }}`, and the target line for slicing is ${target_line}. Here's the source code snippet of the focal class, covering all its fields and member methods:
```
${full_fm}
```

For other member methods, I'll provide only their signatures.
<#list c_deps as key, value>
    Brief information about the dependent class ${key} is as follows:
    ```
    ${value}
    ```
</#list>

<#list m_deps as key, value>
    Brief information about the dependent method ${key} is as follows:
    ```
    ${value}
    ```
</#list>

### Instructions on Decomposing the Method under Test into a Single Slice

1. Summarize the focal method with respect to reaching and executing the specific target line.
2. List the test environment settings required to execute the specific target line in the focal method, including:
- Enumerate all input parameters and object/class fields invoked in the focal method that need to be set or mocked to reach and execute the target line.
- Enumerate all object/class methods invoked in the focal method that need to be set or mocked to reach and execute the target line.
3. Important Note! Please decompose the method under test into a slice according to a backward slicing strategy from the specific target line. The slicing objective is to identify, in a backward manner, all original method statements that the target line depends on. Identify and describe the slice you found.
4. Construct a slice based on the following instructions:
- Start from the specific target line.
- Identify all variables, fields, or method return values used in that line.
- Trace backward to the statements where these values are defined or modified.
- Recursively repeat this process until reaching the first code statement of the method under test.
- The slice is computed by following data and control dependencies of the specific target line backward through the method under test.
- Your analysis has two parts:
a. Describe control and data flow of the slice.
b. Replicate the corresponding original code statements.

### Format of the Output

Begin by performing the analysis in text format. Once the analysis is complete, organize the findings into a JSON object, structured as follows:

- "summarization": A string summarizing the focal method based on the slice.
- "invoked_outside_vars": A JSON array of strings listing global variables, focal method parameters, and object/class fields used in the focal method that require setting or mocking.
- "invoked_outside_methods": A JSON array of strings listing external methods invoked by the focal method that require setting or mocking.
- "steps": A JSON array containing one JSON object that represents the identified slice. The object has two key value pairs:
- key: "desp"; value: a string of the slice's description
- key: "code"; value: a string of the original code statements within the slice

Here's an example output format for your analysis:

```json
{
    "summarization": "...",
    "//": "Local variables defined in the focal method should not be reported.",
    "invoked_outside_vars": [
        "input_str: string, input parameter, the input string to handle",
        "code.format: public string, public class field of object 'code' of class Encoding, representing the format to encode the input string",
        "..."
    ],
    "invoked_outside_methods": [
        "parser.norm(string): public member method of object 'parser' of class 'Parser', responsible for normalizing the input string",
        "..."
    ],
    "steps": [
        {"desp": "Initialization and setup\n    - Initialize an empty list of tokens.\n    - Initialize a boolean flag `eatTheRest` to false.",
         "code": "    ArrayList&lt;String&gt; tokens = new List();\n boolean eatTheRest = false;\n"}
    ]
}
```