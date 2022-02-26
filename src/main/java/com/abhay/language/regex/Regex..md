
? matches any single character
* matches any sequence of characters
[abc] matches any one character inside square brackets, so it will match a, b, or c

Match a character or a group of characters optionally (0 or 1 times)
Use quantifiers in regex patterns to match variable length text
Use a character class to match one of the listed characters or match a range of characters
Use a negated character class to match any character except those matched by the character class
Match only certain character categories, such as match only digits, only upper case letters, or only punctuation characters
Match a character or a group of characters for a specific length.
Match a length range, such as allow only six to 10 digits in the input or match an input of a minimum of eight characters
Use Boolean "OR" in an alternation to match one of the few alternative options
Use groups in regex patterns and capture substrings that we want to extract or replace from a given input
Alter the behavior of matching by keeping it greedy (eager), lazy (reluctant), or possessive
Use back references and forward references of groups that we capture
Use zero-width assertions such as the following:
Start and end anchors
Word boundary
Lookahead and lookbehind assertions
Start a match from the end of a previous match


a or b --> a|b
5 o rmore digit --> 5+
starts with p and ends with w---> p.*w

| Symbol                                       | Meaning                                                                                                                                                                        | Example                                                                                                                                                                                    |
|----------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| . (dot or period)                            | Matches any character other than newline.                                                                                                                                      | Matches #, @, A, f, 5, or .                                                                                                                                                                |
| * (asterisk)                                 | * matches zero or more occurrences of the preceding character or group.                                                                                                        | m* matches 0 or more occurrences of the letter m.                                                                                                                                          |
| + (plus)                                     | + matches one or more occurrences of the preceding element.                                                                                                                    | m+ matches one or more occurrences of the letter m.                                                                                                                                        |
| ? (question mark)                            | ? means optional match. It is used to match zero or one occurrence of the preceding element. It is also used for lazy matching (which will be covered in the coming chapters). | nm? means match n or nm, as m is an optional match here.                                                                                                                                   |
| \| (pipe)                                    | \| means alternation. It is used to match one of the elements separated by \|                                                                                                  | m\|n\|p means match either the letter m or the letter n or the letter p                                                                                                                    |
| ^ (cap)                                      | ^ is called anchor, that matches start of the line                                                                                                                             | ^m matches m only when it is the first character of the string that we are testing against the regular expression. Also, note that you do not use ^ in the middle of a regular expression. |
| $ (dollar)                                   | $ is called anchor that matches line end.                                                                                                                                      | m$ matches m only at line end.                                                                                                                                                             |
| \b (backslash followed by the letter b)      | Alphabets, numbers, and underscore are considered word characters. \b asserts word boundary, which is the position just before and after a word.                               | \bjava\b matches the word, java . So, it will not match javascript since the word, javascript, will fail to assert \b after java in the regex.                                             |
| \B (backslash followed by uppercase B)       | \B asserts true where \b doesn't, that is, between two word characters.                                                                                                        | For the input text, abc, \B will be asserted at two places: Between a and b. Between b and c.                                                                                              |
| (...) a sub-pattern inside round parentheses | This is for grouping a part of text that can be used to capture a certain substring or for setting precedence.                                                                 | m(ab)*t matches m, followed by zero or more occurrences of the substring, ab, followed by t.                                                                                               |
| {min,max}                                    | A quantifier range to match the preceding element between the minimum and the maximum number.                                                                                  | mp{2,4} matches m followed 2 to 4 occurrences of the letter p.                                                                                                                             |
| [...]                                        | This is called a character class.                                                                                                                                              | [A-Z] matches any uppercase English alphabet.                                                                                                                                              |
| \d (backslash followed by the letter d)      | This will match any digit.                                                                                                                                                     | \d matches any digit in the 0-9 range.                                                                                                                                                     |
| \D (backslash followed by uppercase D)       | This matches any character that is not a digit.                                                                                                                                | \D matches a, $, or _.                                                                                                                                                                     |
| \s (backslash followed by the letter s)      | Matches any whitespace, including tab, space, or newline.                                                                                                                      | \s matches [ \t\n].                                                                                                                                                                        |
| \S (backslash followed by uppercase S)       | Matches any non-whitespace.                                                                                                                                                    | \S matches the opposite of \s                                                                                                                                                              |
| \w (backslash followed by the letter w)      | Matches any word character that means all alphanumeric characters or underscore.                                                                                               | \w will match [a-zA-Z0-9_], so it will match any of these strings: "abc", "a123", or "pq_12_ABC"                                                                                           |
| \W (backslash followed by the letter W)      | Matches any non-word character, including whitespaces. In regex, any character that is not matched by \w can be matched using \W.                                              | It will match any of these strings: "+                                                                                                                                                     |


|  Regex |                        Meaning                       |
|:------:|:----------------------------------------------------:|
| .      | Matches any single character.                        |
| ?      | Matches the preceding element once or not at all.    |
| +      | Matches the preceding element once or more times.    |
| *      | Matches the preceding element zero or more times.    |
| ^      | Matches the starting position within the string.     |
| $      | Matches the ending position within the string.       |
| \|     | Alternation operator.                                |
| [abc]  | Matches a or b, or c.                                |
| [a-c]  | Range; matches a or b, or c.                         |
| [^abc] | Negation, matches everything except a, or b, or c.   |
| \s     | Matches white space character.                       |
| \w     | Matches a word character; equivalent to [a-zA-Z_0-9] |
|        |                                                      |
|        |                                                      |
|        |                                                      |
|        |                                                      |
|        |                                                      |
|        |                                                      |


ab*c --> a followed by zero or more b, followed by c
ab+c---> a followed by 1 or more b, follwoed by c
ab?c->  a followed by zero or more b, followed by c ex abc or ac
^abc$ ---> abc string in a line
a(bc)*z-->
ab{1,3}c
\b(cat|dog)\b -->>>serach for complete word 
[0,9] ---> digit
[a-zA-Z0-9]---> alpanumeric
^\d+$ ---> any alphanumeric character




  


