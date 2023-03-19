<h2>Overview</h2>

This application contains logic to fetch the value of a given key of an object.
This key could be a multi-level key, separated by a delimeter.

The solution considers the given object to be of java.util.Map type, and presents the logic accordingly.
It also contains a few test cases in the form of JUnit to verify the logic in the program.

The method `getValue()` in the class GetValue contains the actual logic which is written recursively.
It takes three parameters in the form of the input object, string key and the delimiter that separates the keys in the input.

The code traverses the key a level deeper on each recursive call until it reaches the end of the input, after which it returns the expected value.

<h2>Example</h2>
<b>Input:</b> {address={area={pincode=400001}}} <br>
<b>Key:</b> address/area <br>
<b>Delimiter:</b> / (slash) <br>

<b>Expected Output:</b> {pincode=400001}