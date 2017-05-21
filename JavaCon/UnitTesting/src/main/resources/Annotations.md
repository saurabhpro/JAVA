The constraints denote the following:
- `_` - any value
- `null` - null value
- `!null` - a value statically proved to be not-null
- `true` - true boolean value
- `false` - false boolean value
- `fail` - the method throws an exception, if the arguments satisfy argument constraints

Examples:
- `@Contract("_, null -> null")` - method returns null if its second argument is null

- `@Contract("_, null -> null; _, !null -> !null")` - method returns null if its second argument is null and not-null otherwise
- `@Contract("true -> fail")` - a typical assertFalse method which throws an exception if true is passed to it